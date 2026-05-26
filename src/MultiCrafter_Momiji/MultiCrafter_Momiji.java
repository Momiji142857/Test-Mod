package MultiCrafter_Momiji;

import arc.Core;
import arc.audio.Sound;
import arc.graphics.Color;
import arc.math.Angles;
import arc.math.Mathf;
import arc.math.geom.Vec2;
import arc.scene.style.TextureRegionDrawable;
import arc.scene.ui.ScrollPane;
import arc.scene.ui.TextButton;
import arc.scene.ui.layout.Table;
import arc.struct.EnumSet;
import arc.struct.ObjectMap;
import arc.struct.ObjectSet;
import arc.struct.Seq;
import arc.util.*;
import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.content.Fx;
import mindustry.core.UI;
import mindustry.ctype.UnlockableContent;
import mindustry.entities.Effect;
import mindustry.entities.Units;
import mindustry.gen.Building;
import mindustry.gen.Icon;
import mindustry.gen.Iconc;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.*;
import mindustry.ui.Bar;
import mindustry.ui.Fonts;
import mindustry.ui.Styles;
import mindustry.world.Block;
import mindustry.world.blocks.heat.HeatBlock;
import mindustry.world.blocks.heat.HeatConsumer;
import mindustry.world.blocks.payloads.BuildPayload;
import mindustry.world.blocks.payloads.Payload;
import mindustry.world.blocks.payloads.PayloadBlock;
import mindustry.world.blocks.payloads.UnitPayload;
import mindustry.world.consumers.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

public class MultiCrafter_Momiji extends Block {
    public static Recipe[] recipes = {};
    public int payloadCapacity = 10;
    public int itemCapacity = -1;
    public @Nullable Effect craftEffect;
    public boolean dumpExtraLiquid = true;
    public float maxEfficiency = 1f;
    public float overheatScale = 1f;

    public MultiCrafter_Momiji(String name) {
        super(name);
        update = true;
        solid = true;
        hasItems = true;
        ambientSound = Sounds.loopMachine;
        sync = true;
        ambientSoundVolume = 0.03f;
        drawArrow = false;
        hasPower = true;
        hasLiquids = true;
        destructible = true;
        breakable = true;
        targetable = true;
        configurable = true;
        flags = EnumSet.of(BlockFlag.factory);
        clearOnDoubleTap = true;
        // group = BlockGroup.;
    }

    @Override
    public void init() {
        // 规范化 recipes 的输入输出
        Recipe.Recipe_set();

        // 设定动态消费者
        consume(new ConsumeItemDynamic((MultiCrafterBuild b) -> {
            Recipe r = b.getCurrentRecipe();
            return r != null && r.inputItems != null ? r.inputItems : ItemStack.empty;
        }));
        consume(new ConsumeLiquidsDynamic((MultiCrafterBuild b) -> {
            Recipe r = b.getCurrentRecipe();
            return r != null && r.inputLiquids != null ? r.inputLiquids : LiquidStack.empty;
        }));
        consume(new ConsumePayloadDynamic(MultiCrafterBuild::getInputPayloadSeq));

        // 设置电力输出标志
        boolean hasOutputPower = false;
        for (Recipe r : recipes) {
            if (r.outputPower > 0) {
                hasOutputPower = true;
                break;
            }
        }
        outputsPower = hasOutputPower;

        // 永久基底，消耗为 0，保证 power 模块永远存在
        consumePower(0f);

        // 计算所有配方中的最大电力需求，注册一个 usage = 最大需求的静态消费者
        float maxPower = 0f;
        for (Recipe r : recipes) {
            if (r.inputPower > maxPower) maxPower = r.inputPower;
        }
        if (maxPower > 0) {
            consume(new DynamicConsumePower(maxPower));
        }

        // 自动计算物品和液体的容量
        if (itemCapacity < 0) {
            int maxItemCap = 10;
            for (Recipe r : recipes) {
                if (r.inputItems != null) for (ItemStack s : r.inputItems)
                    maxItemCap = Math.max(maxItemCap, s.amount * 2);
                if (r.outputItems != null) for (ItemStack s : r.outputItems)
                    maxItemCap = Math.max(maxItemCap, s.amount * 2);
            }
            itemCapacity = maxItemCap;
        }
        if (liquidCapacity < 0) {
            float maxLiquidCap = 1f;
            for (Recipe r : recipes) {
                if (r.inputLiquids != null) for (LiquidStack stack : r.inputLiquids)
                    maxLiquidCap = Math.max(maxLiquidCap, stack.amount * 60f);
                if (r.outputLiquids != null) for (LiquidStack stack : r.outputLiquids)
                    maxLiquidCap = Math.max(maxLiquidCap, stack.amount * 60f);
            }
            liquidCapacity = Mathf.round(10f * maxLiquidCap);
        }

        // 设置载荷和旋转相关字段
        boolean hasInputPayload = false;
        boolean hasOutputPayload = false;

        for (Recipe r : recipes) {
            if (Recipe.haveInputPayloads(r)) hasInputPayload = true;
            if (Recipe.haveOutputPayloads(r)) hasOutputPayload = true;
        }

        // 根据结果统一设置
        if (!rotate && hasOutputPayload) {
            Log.warn("MultiCrafter '@' has payload output recipes, but rotation is disabled. Forcing rotate=true.", name);
            rotate = true;
            drawArrow = true;
        }
        acceptsPayload = hasInputPayload;
        acceptsUnitPayloads = hasInputPayload;
        outputsPayload = hasOutputPayload;

        // 注册配置处理器：保存/恢复配方索引
        config(Integer.class, (MultiCrafterBuild build, Integer i) -> {
            if (build.currentRecipe != i) {
                build.switchRecipe(i);
            }
        });
        // 双击清空配置时将 currentRecipe 重置为 -1
        configClear((MultiCrafterBuild build) -> build.switchRecipe(-1));

        super.init();
    }

    @Override
    public void setStats(){
        // 原版 Block 的方法
        stats.add(Stat.size, "@x@", size, size);
        if(synthetic()) {
            stats.add(Stat.health, health, StatUnit.none);
            if(armor > 0) stats.add(Stat.armor, armor, StatUnit.none);
        }
        if(canBeBuilt() && requirements.length > 0) {
            stats.add(Stat.buildTime, buildTime / 60, StatUnit.seconds);
            stats.add(Stat.buildCost, StatValues.items(false, requirements));
        }
        if(instantTransfer) {stats.add(Stat.maxConsecutive, 2, StatUnit.none);}
        for(var c : consumers) {c.display(stats);}
        if(hasLiquids) stats.add(Stat.liquidCapacity, liquidCapacity, StatUnit.liquidUnits);
        if(hasItems && itemCapacity > 0) stats.add(Stat.itemCapacity, itemCapacity, StatUnit.items);

        // 显示各个配方
        stats.add(Stat.output, table -> {
            table.clearChildren();
            table.left();

            for (int i = 0; i < recipes.length; i++) {
                Recipe rec = recipes[i];
                int finalI = i;
                int colspan = Recipe.calcColspan(rec);
                table.table(Styles.grayPanel, t -> {
                    t.left().defaults().left();
                    t.add("[accent]Recipe " + (finalI + 1) + "[]").colspan(colspan).padTop(4).padBottom(4).left();
                    t.row();

                    // 输入行
                    boolean hasInput = rec.inputItems != null || rec.inputLiquids != null
                            || rec.inputPower > 0 || rec.inputHeat > 0 || rec.inputPayloads != null;
                    if (hasInput) {
                        t.add("[lightgray]" + Core.bundle.get("stat.input") + ":[]");
                        if (rec.inputItems != null) for (ItemStack s : rec.inputItems)
                            t.add(StatValues.displayItem(s.item, s.amount, rec.craftTime, true)).pad(5);
                        if (rec.inputLiquids != null) for (LiquidStack s : rec.inputLiquids)
                            t.add(StatValues.displayLiquid(s.liquid, s.amount * 60f, true)).pad(5);
                        if (rec.inputPayloads != null) for (PayloadStack s : rec.inputPayloads)
                            t.add(displayPayload(s.item, s.amount, rec.craftTime, true)).pad(5);
                        if (rec.inputPower > 0)
                            t.table(p -> StatValues.number(rec.inputPower * 60f, StatUnit.powerSecond).display(p)).pad(5);
                        if (rec.inputHeat > 0)
                            t.table(h -> StatValues.number(rec.inputHeat, StatUnit.heatUnits).display(h)).pad(5);
                        t.row();
                    }

                    // 输出行
                    boolean hasOutput = rec.outputItems != null || rec.outputLiquids != null
                            || rec.outputHeat > 0 || rec.outputPower > 0 || rec.outputPayloads != null;
                    if (hasOutput) {
                        t.add("[lightgray]" + Core.bundle.get("stat.output") + ":[]");
                        if (rec.outputItems != null) for (ItemStack s : rec.outputItems)
                            t.add(StatValues.displayItem(s.item, s.amount, rec.craftTime, true)).pad(5);
                        if (rec.outputLiquids != null) for (LiquidStack s : rec.outputLiquids)
                            t.add(StatValues.displayLiquid(s.liquid, s.amount * 60f, true)).pad(5);
                        if (rec.outputPayloads != null) for (PayloadStack s : rec.outputPayloads)
                            t.add(displayPayload(s.item, s.amount, rec.craftTime, true)).pad(5);
                        if (rec.outputPower > 0)
                            t.table(p -> StatValues.number(rec.outputPower * 60f, StatUnit.powerSecond).display(p)).pad(5);
                        if (rec.outputHeat > 0)
                            t.table(h -> StatValues.number(rec.outputHeat, StatUnit.heatUnits).display(h)).pad(5);
                        t.row();
                    }

                    // 底部信息：时间 + 超速
                    boolean canOverdrive = !(rec.outputHeat > 0) && rec.allowOverdrive;
                    t.table(info -> {
                        info.left();
                        info.add("[lightgray]" + Core.bundle.get("stat.productiontime") + ":[] " + Strings.autoFixed(rec.craftTime / 60f, 3) + " " + Core.bundle.get("unit.seconds"));
                        info.add("  [lightgray]能否超速:[] " + (canOverdrive ? Core.bundle.get("yes") : Core.bundle.get("no")));
                    }).colspan(colspan).padTop(4).left();
                }).growX().pad(5).row();
            }
        });
    }

    @Override
    public void setBars() {
        addBar("health", entity -> new Bar("stat.health", Pal.health, entity::healthf).blink(Color.white));

        // 电力消耗条
        addBar("powerInput", (MultiCrafterBuild e) -> {
            Recipe r = e.getCurrentRecipe();
            if (r == null || r.inputPower <= 0) return null;

            return new Bar(
                    () -> {
                        float recipePower = r.inputPower * 60f;
                        float status = e.power.status;
                        float available = recipePower * status;

                        if (status >= 1f && e.efficiency >= 1f) {
                            return StatUnit.powerSecond.icon + "- " + powerFmtNum(recipePower);
                        }
                        return StatUnit.powerSecond.icon + "- " +
                                powerFmtNum(available) + "/" + fmtNum(recipePower) +
                                " [lightgray]| " + Strings.autoFixed(e.efficiency * 100, 1) + "%[]";
                    },
                    () -> Pal.powerBar,
                    () -> e.power.status
            );
        });

        // 电力输出条
        addBar("powerOutput", (MultiCrafterBuild e) -> {
            Recipe r = e.getCurrentRecipe();
            if (r == null || r.outputPower <= 0) return null;

            return new Bar(
                    () -> {
                        float recipeOutput = r.outputPower * 60f;
                        float actualOutput = e.getPowerProduction();

                        if (e.efficiency >= 1f) {
                            return StatUnit.powerSecond.icon + "+ " + powerFmtNum(recipeOutput);
                        }
                        return StatUnit.powerSecond.icon + "+ " +
                                powerFmtNum(actualOutput) + "/" + fmtNum(recipeOutput) +
                                " [lightgray]| " + Strings.autoFixed(e.efficiency * 100, 1) + "%[]";
                    },
                    () -> Pal.powerBar,
                    () -> e.efficiency
            );
        });

        // 物品条
        addBar("items", (MultiCrafterBuild e) -> {
            Recipe r = e.getCurrentRecipe();
            if (r == null ||
                    (!Recipe.haveItems(r) && e.items.total() == 0)) return null;
            return new Bar(
                    () -> Core.bundle.format("bar.items", e.items.total()),
                    () -> Pal.items,
                    () -> (float)e.items.total() / itemCapacity
            );
        });

        // === 液体条（统一，不区分输入输出） ===
        ObjectSet<Liquid> allLiquids = new ObjectSet<>();
        for (Recipe r : recipes) {
            if (r.inputLiquids != null) for (LiquidStack stack : r.inputLiquids) allLiquids.add(stack.liquid);
            if (r.outputLiquids != null) for (LiquidStack stack : r.outputLiquids) allLiquids.add(stack.liquid);
        }
        int liqIdx = 0;
        for (Liquid liq : allLiquids) {
            addBar("liquid" + liqIdx, (MultiCrafterBuild e) -> {
                Recipe r = e.getCurrentRecipe();
                if (r == null || !Recipe.haveLiquids(r)) return null;

                // 检查当前配方是否包含该液体
                boolean found = false;
                if (r.inputLiquids != null) for (LiquidStack s : r.inputLiquids) if (s.liquid == liq) { found = true; break; }
                if (!found && r.outputLiquids != null) for (LiquidStack s : r.outputLiquids) if (s.liquid == liq) { found = true; break; }
                if (!found) return null;

                return new Bar(
                        () -> {
                            float current = e.liquids.get(liq);
                            float fill = current / liquidCapacity;
                            if (fill > 0.99f) return liq.localizedName + " " + fmtNum(current);
                            return liq.localizedName + " " + fmtNum(current) + "/" + fmtNum(liquidCapacity)
                                    + " [lightgray]| " + Strings.autoFixed(fill * 100f, 1) + "%[]";
                        },
                        liq::barColor,
                        () -> e.liquids.get(liq) / liquidCapacity
                );
            });
            liqIdx++;
        }

        // === 热量条 ===
        addBar("heatInput", (MultiCrafterBuild e) -> {
            Recipe r = e.getCurrentRecipe();
            if (r == null || r.inputHeat <= 0) return null;
            return new Bar(
                    () -> {
                        boolean hasOutput = r.outputHeat > 0;
                        String label = hasOutput ? Core.bundle.get("stat.input") + Core.bundle.get("bar.heat") : Core.bundle.get("bar.heat");
                        float heatVal = e.heat;
                        float heatReq = r.inputHeat;
                        if (heatVal > heatReq) {
                            return label + " " + fmtNum(heatVal)
                                    + " [lightgray]| 100%[]";
                        }
                        return label + " " + fmtNum(heatVal) + "/" + fmtNum(heatReq)
                                + " [lightgray]| " + Strings.autoFixed(heatVal / heatReq * 100f, 1) + "%[]";
                    },
                    () -> Pal.lightOrange,
                    () -> e.heat / r.inputHeat
            );
        });
        addBar("heatOutput", (MultiCrafterBuild e) -> {
            Recipe r = e.getCurrentRecipe();
            if (r == null || r.outputHeat <= 0) return null;
            return new Bar(
                    () -> {
                        boolean hasInput = r.inputHeat > 0;
                        String label = hasInput ? Core.bundle.get("stat.output") + Core.bundle.get("bar.heat") : Core.bundle.get("bar.heat");
                        float heatVal = e.heatOutput;
                        float heatReq = r.outputHeat;
                        if (heatVal >= heatReq) {
                            return label + " " + fmtNum(heatVal) + " (100%)";
                        }
                        return label + " " + fmtNum(heatVal) + "/" + fmtNum(heatReq)
                                + " [lightgray]| " + Strings.autoFixed(heatVal / heatReq * 100f, 1) + "%[]";
                    },
                    () -> Pal.lightOrange,
                    () -> e.heatOutput / r.outputHeat
            );
        });

        // 单位上限条（与原版 UnitFactory 一致）
        // 1. 首先收集所有配方中输出的单位类型
        ObjectSet<UnitType> unitTypes = new ObjectSet<>();
        for (Recipe r : recipes) {
            if (r.outputPayloads != null) {
                for (PayloadStack stack : r.outputPayloads) {
                    if (stack.item instanceof UnitType ut) {
                        unitTypes.add(ut);
                    }
                }
            }
        }
        // 2. 为每种单位类型创建一个条，条内部动态检查当前配方是否包含它
        int idx = 0;
        for (UnitType type : unitTypes) {
            addBar("unitOutput" + idx, (MultiCrafterBuild e) -> {
                Recipe r = e.getCurrentRecipe();
                if (r == null || !Recipe.haveOutputPayloads(r)) return null;

                // 检查当前配方是否输出这个单位
                boolean found = false;
                for (PayloadStack s : r.outputPayloads) {
                    if (s.item == type) { found = true; break; }
                }
                if (!found) return null;

                return new Bar(
                        () -> Core.bundle.format("bar.unitcap",
                                Fonts.getUnicodeStr(type.name),
                                e.team.data().countType(type),
                                type.useUnitCap ? Units.getStringCap(e.team) : "∞"
                        ),
                        () -> Pal.power,
                        () -> type.useUnitCap ? (float)e.team.data().countType(type) / Units.getCap(e.team) : 1f
                );
            });
            idx++;
        }

        // 生产进度条
        addBar("progress", (MultiCrafterBuild e) -> new Bar(
                () -> {
                    String icon;
                    Recipe r = e.getCurrentRecipe();
                    if (r != null && r.outputPayloads != null && r.outputPayloads.length > 0) {
                        icon = String.valueOf(Iconc.units);      // 兵厂图标
                    } else if (r != null && r.outputPower > 0) {
                        icon = String.valueOf(Iconc.power);      // 发电图标
                    } else {
                        icon = String.valueOf(Iconc.crafting);    // 工厂图标
                    }
                    float progress = e.progress();
                    int percent = (int)(progress * 100);
                    float remaining = (e.craftTime * (1f - progress)) / Math.max(e.efficiency, 0.01f) / 60f;
                    return icon + " " + percent + "% [orange]" + Strings.autoFixed(remaining, 2) + "s[]";
                },
                () -> Pal.ammo,
                e::progress
        ));
    }

    /** >= 1000 用原版 UI.formatAmount */
    private static String fmtNum(float value) {
        float abs = Math.abs(value);
        if (abs >= 1000f) return UI.formatAmount((long)value);
        if (abs >= 0.01f) return Strings.autoFixed(value, 2);
        if (abs == 0f)  return "0";
        if (abs < 0.000_001f) return "0.0";
        int exponent = (int)Math.floor(Math.log10(abs));
        float mantissa = (float)(value / Math.pow(10, exponent));
        mantissa = Mathf.round(mantissa, 2);
        return mantissa + "[lightgray]E" + exponent + "[]";
    }

    /** >= 1_000_000 用原版 UI.formatAmount */
    private static String powerFmtNum(float value) {
        float abs = Math.abs(value);
        if (abs >= 1_000_000f) return UI.formatAmount((long)value);
        if (abs >= 0.01f) return Strings.autoFixed(value, 2);
        if (abs == 0f)  return "0";
        if (abs < 0.000_001f) return "0";
        int exponent = (int)Math.floor(Math.log10(abs));
        float mantissa = (float)(value / Math.pow(10, exponent));
        mantissa = Mathf.round(mantissa, 2);
        return mantissa + "[lightgray]E" + exponent + "[]";
    }

    /** Displays a payload with a "/sec" qualifier based on the time period, in ticks. */
    public static Table displayPayload(UnlockableContent content, int amount, float craftTime, boolean showName) {
        Table t = new Table();
        t.add(StatValues.stack(content, amount, !showName));
        t.add((showName ? content.localizedName + "\n" : "") +
                "[lightgray]" + Strings.autoFixed(amount / (craftTime / 60f), 3) +
                StatUnit.perSecond.localized()).padLeft(2).padRight(5).style(Styles.outlineLabel);
        return t;
    }

    // 配方类
    public static class Recipe {
        public @Nullable ItemStack[] inputItems;
        public @Nullable LiquidStack[] inputLiquids;
        public float inputPower;
        public float inputHeat;
        public @Nullable ItemStack[] outputItems;
        public @Nullable LiquidStack[] outputLiquids;
        public float outputPower;
        public float outputHeat;
        public float craftTime = 80f;
        public @Nullable PayloadStack[] inputPayloads;
        public @Nullable PayloadStack[] outputPayloads;
        public boolean allowOverdrive = true;
        public @Nullable Effect craftEffect;
        public @Nullable Effect updateEffect;
        public float updateEffectChance = 0.04f;
        public @Nullable Effect switchEffect;
        public @Nullable Sound craftSound;
        public @Nullable Sound updateSound;
        public int inputPayloadCapacity = 0;
        public float inputPayloadMultiplier = 2f;

        public @Nullable ItemStack outputItem;
        public @Nullable LiquidStack outputLiquid;
        public @Nullable ItemStack inputItem;
        public @Nullable LiquidStack inputLiquid;

        public static void Recipe_set() {
            // 将 Recipe 的单值字段转换为数组, 兼容原版 JSON 简写
            for (Recipe r : recipes) {
                // 输入单值 -> 数组
                if (r.inputItems == null && r.inputItem != null) r.inputItems = new ItemStack[] {r.inputItem};
                if (r.inputLiquids == null && r.inputLiquid != null) r.inputLiquids = new LiquidStack[] {r.inputLiquid};
                if (r.outputItems == null && r.outputItem != null) r.outputItems = new ItemStack[] {r.outputItem};
                if (r.outputLiquids == null && r.outputLiquid != null) r.outputLiquids = new LiquidStack[] {r.outputLiquid};
                // 写回单值, 方便逻辑处理器读取
                if (r.outputLiquid == null && r.outputLiquids != null && r.outputLiquids.length > 0) r.outputLiquid = r.outputLiquids[0];
            }
        }

        public static boolean havePower(Recipe r) {
            return r.inputPower > 0 || r.outputPower > 0;
        }

        public static boolean haveItems(Recipe r) {
            return (r.inputItems != null && r.inputItems.length > 0) ||
                    (r.outputItems != null && r.outputItems.length > 0);
        }

        public static boolean haveLiquids(Recipe r) {
            return (r.inputLiquids != null && r.inputLiquids.length > 0) ||
                    (r.outputLiquids != null && r.outputLiquids.length > 0);
        }

        public static boolean haveInputPayloads(Recipe r) {
            return r.inputPayloads != null && r.inputPayloads.length > 0;
        }

        public static boolean haveOutputPayloads(Recipe r) {
            return  r.outputPayloads != null && r.outputPayloads.length > 0;
        }

        private static int calcColspan(Recipe rec) {
            int inputCount = 0, outputCount = 0;
            if (rec.inputItems != null) inputCount += rec.inputItems.length;
            if (rec.inputLiquids != null) inputCount += rec.inputLiquids.length;
            if (rec.inputPayloads != null) inputCount += rec.inputPayloads.length;
            // 假定电力 + 热量各占 1 项，直接加 2
            inputCount += 2;

            if (rec.outputItems != null) outputCount += rec.outputItems.length;
            if (rec.outputLiquids != null) outputCount += rec.outputLiquids.length;
            if (rec.outputPayloads != null) outputCount += rec.outputPayloads.length;
            outputCount += 2;

            return Math.max(1, Math.max(inputCount, outputCount)) + 2;
        }
    }

    public class MultiCrafterBuild extends Building implements HeatBlock, HeatConsumer {
        public int currentRecipe;
        public float heat = 0f;
        public float heatOutput = 0f;
        public PayloadSeq blocks = new PayloadSeq();
        private final Seq<PayloadStack> cachedInputPayloadSeq = new Seq<>();
        public final Seq<Payload> outputPayloadQueue = new Seq<>();
        private final ObjectMap<UnlockableContent, Integer> outputCountCache = new ObjectMap<>();
        private Recipe lastRecipe = null;
        public float[] sideHeat = new float[4];
        public float totalProgress;
        public float progress;
        public float warmup;
        public float warmupRate = 0.15f;
        public float warmupSpeed = 0.019f;
        private final Vec2 payVector = new Vec2();
        private float payRotation = 0f;
        public final float payloadSpeed = 0.7f;
        public final float payloadRotateSpeed = 5f;
        public float craftTime = 80f;
        public boolean canOverdrive = true;

        // 获取配方
        public Recipe getCurrentRecipe() {
            if (recipes.length == 0) return null;
            if (currentRecipe < 0 || currentRecipe >= recipes.length) return null;
            return recipes[currentRecipe];
        }

        public Seq<PayloadStack> getInputPayloadSeq() {
            Recipe r = getCurrentRecipe();
            // 配方没变，直接返回上一次的缓存，避免重复 clear + addAll
            if (lastRecipe == r) return cachedInputPayloadSeq;
            lastRecipe = r;
            cachedInputPayloadSeq.clear();
            if (r != null && r.inputPayloads != null) cachedInputPayloadSeq.addAll(r.inputPayloads);
            return cachedInputPayloadSeq;
        }

        @Override
        public void updateTile() {
            Recipe rec = getCurrentRecipe();

            // 热量
            if (rec != null && rec.inputHeat > 0) heat = calculateHeat(sideHeat);

            // 工厂运作
            if(efficiency > 0){

                progress += getProgressIncrease(craftTime);
                warmup = Mathf.approachDelta(warmup, warmupTarget(), warmupSpeed);
                totalProgress += warmup * delta();
                // 平滑输出液体
                if (rec != null && rec.outputLiquids != null) {
                    float inc = getProgressIncrease(1f);
                    for (LiquidStack output : rec.outputLiquids) {
                        handleLiquid(this, output.liquid, Math.min(output.amount * inc, liquidCapacity - liquids.get(output.liquid)));
                    }
                }
                // 随机特效
                if (wasVisible && rec != null && rec.updateEffect != null)
                    if (Mathf.chanceDelta(rec.updateEffectChance))
                        rec.updateEffect.at(x + Mathf.range(size * 4f), y + Mathf.range(size * 4f));
            } else {
                warmup = Mathf.approachDelta(warmup, 0f, warmupSpeed);
            }

            // 输出热量
            if (rec != null && rec.outputHeat > 0)
                heatOutput = Mathf.approachDelta(heatOutput, rec.outputHeat * efficiency, warmupRate * delta());
            else
                heatOutput = Mathf.approachDelta(heatOutput, 0, warmupRate * delta());

            // 输出载荷
            moveOutPayload();

            // 完成制造
            if (progress >= 1f) craft();
            dumpOutputs();
        }

        public float warmupTarget() {
            Recipe r = getCurrentRecipe();
            if (r == null || r.inputHeat <= 0) return 1f;
            return Mathf.clamp(heat / r.inputHeat);
        }

        // 载荷输出
        public void moveOutPayload() {
            if (outputPayloadQueue.isEmpty()) return;

            Payload p = outputPayloadQueue.first();
            p.update(null, this);

            Vec2 dest = Tmp.v1.trns(rotdeg(), size * tilesize / 2f);

            payRotation = Angles.moveToward(payRotation, rotdeg(), payloadRotateSpeed * delta());
            payVector.approach(dest, payloadSpeed * delta());

            p.set(x + payVector.x, y + payVector.y, payRotation);

            Building front = front();
            boolean canDump = front == null || !front.tile.solid();
            boolean canMove = front != null && (front.block.outputsPayload || front.block.acceptsPayload);

            if (canDump && !canMove) {
                PayloadBlock.pushOutput(p, 1f - (payVector.dst(dest) / (size * tilesize / 2f)));
            }

            if (payVector.within(dest, 0.001f)) {
                payVector.clamp(-size * tilesize / 2f, -size * tilesize / 2f, size * tilesize / 2f, size * tilesize / 2f);
                if (canMove) {
                    if (movePayload(p)) {
                        outputPayloadQueue.remove(0);
                        payVector.setZero();
                    }
                } else if (canDump) {
                    // 1. 将载荷向前微推 0.1 格，帮助它离开建筑碰撞体积
                    float tx = Angles.trnsx(p.rotation(), 0.1f);
                    float ty = Angles.trnsy(p.rotation(), 0.1f);
                    p.set(p.x() + tx, p.y() + ty, p.rotation());

                    // 2. 尝试将载荷丢弃到世界上
                    if (p.dump()) {
                        outputPayloadQueue.remove(0);
                        payVector.setZero();
                    } else {
                        // 3. 如果失败，把载荷退回原位
                        p.set(p.x() - tx, p.y() - ty, p.rotation());
                    }
                }
            }
}

        public void craft() {
            Recipe rec = getCurrentRecipe();
            if (rec == null) return;
            consume();

            if (rec.outputItems != null) {
                for (ItemStack output : rec.outputItems) {
                    for (int i = 0; i < output.amount; i++) offload(output.item);
                }
            }

            if (rec.outputPayloads != null) {
                for (PayloadStack stack : rec.outputPayloads) {
                    for (int i = 0; i < stack.amount; i++) {
                        Payload p = createPayload(stack.item);
                        if (p != null) {
                            outputPayloadQueue.add(p);
                            if (payVector.isZero()) {
                                payVector.setZero();
                                payRotation = rotdeg();
                            }
                        }
                    }
                }
            }

            Effect effect = rec.craftEffect != null ? rec.craftEffect : craftEffect;
            if (wasVisible) effect.at(x, y);
            progress %= 1f;
        }

        public Payload createPayload(UnlockableContent content) {
            if (content instanceof Block b) return new BuildPayload(b, team);
            else if (content instanceof UnitType unitType) return new UnitPayload(unitType.create(team));
            return null;
        }

        public void dumpOutputs() {
            if (timer(timerDump, dumpTime / timeScale)) {
                Recipe rec = getCurrentRecipe();
                if (rec != null) {
                    if (rec.outputItems != null) {
                        for (ItemStack output : rec.outputItems) dump(output.item);
                    }
                    if (rec.outputLiquids != null) {
                        for (LiquidStack output : rec.outputLiquids) dumpLiquid(output.liquid);
                    }
                }
            }
        }

        // 配方选择
        @Override
        public void buildConfiguration(Table table) {
            table.clearChildren();

            ScrollPane pane = new ScrollPane(new Table(), Styles.smallPane);
            pane.setFadeScrollBars(false);
            pane.setScrollingDisabled(true, false);

            Table content = (Table) pane.getWidget();
            content.background(Styles.black6);   // 整个面板深色背景
            content.top().left();
            content.margin(2f);
            content.marginRight(12f);   // 预留滚动条宽度，防止遮挡

            pane.update(() -> {
                if (content.getWidth() != pane.getWidth()) {
                    content.setWidth(pane.getWidth());
                    content.invalidate();
                }
            });

            for (int i = 0; i < recipes.length; i++) {
                final int idx = i;
                Recipe rec = recipes[i];
                final int recipeNum = i + 1;

                // 使用 TextButton（与兵厂 ImageButton 视觉统一）
                TextButton btn = new TextButton("");
                btn.clearChildren();

                // 样式：完全模拟兵厂 clearNoneTogglei 的效果
                btn.setStyle(new TextButton.TextButtonStyle() {{
                    up = Styles.none;               // 未选中 → 透明
                    over = Styles.flatOver;         // 鼠标悬停 → 淡灰
                    down = Styles.flatDown;         // 按下 → 深色
                    checked = Styles.flatDown;      // 选中 → 深色背景
                    font = Fonts.def;
                    fontColor = Color.white;
                    disabledFontColor = Color.gray;
                }});

                btn.table(btnTable -> {
                    btnTable.left().defaults().left();

                    // 配方编号
                    btnTable.add(String.valueOf(recipeNum))
                            .width(24f).right()
                            .padRight(8f).padLeft(8f)
                            .color(Color.lightGray);

                    // 图标行
                    btnTable.table(iconRow -> {
                        iconRow.left().defaults().left();

                        // --- 输入图标 ---
                        if (rec.inputItems != null) for (ItemStack s : rec.inputItems)
                            iconRow.image(s.item.uiIcon).size(24f).pad(2);
                        if (rec.inputLiquids != null) for (LiquidStack s : rec.inputLiquids)
                            iconRow.image(s.liquid.uiIcon).size(24f).pad(2);
                        if (rec.inputPayloads != null) for (PayloadStack s : rec.inputPayloads)
                            iconRow.image(s.item.uiIcon).size(24f).pad(2);
                        if (rec.inputPower > 0)
                            iconRow.add(StatUnit.powerSecond.icon).style(Styles.outlineLabel).fontScale(1.3f).pad(2);
                        if (rec.inputHeat > 0)
                            iconRow.add(StatUnit.heatUnits.icon).style(Styles.outlineLabel).fontScale(1.3f).pad(2);

                        // --- 箭头（可真正缩放） ---
                        iconRow.image().size(24f).pad(6)
                                .update(i2 -> i2.setDrawable(new TextureRegionDrawable(Icon.right)))
                                .with(i2 -> i2.setScaling(Scaling.fit));

                        // --- 输出图标 ---
                        if (rec.outputItems != null) for (ItemStack s : rec.outputItems)
                            iconRow.image(s.item.uiIcon).size(24f).pad(2);
                        if (rec.outputLiquids != null) for (LiquidStack s : rec.outputLiquids)
                            iconRow.image(s.liquid.uiIcon).size(24f).pad(2);
                        if (rec.outputPayloads != null) for (PayloadStack s : rec.outputPayloads)
                            iconRow.image(s.item.uiIcon).size(24f).pad(2);
                        if (rec.outputPower > 0)
                            iconRow.add(StatUnit.powerSecond.icon).style(Styles.outlineLabel).fontScale(1.25f).pad(2);
                        if (rec.outputHeat > 0)
                            iconRow.add(StatUnit.heatUnits.icon).style(Styles.outlineLabel).fontScale(1.25f).pad(2);
                    });
                });

                btn.clicked(() -> {
                    if (currentRecipe == idx) switchRecipe(-1);
                    else switchRecipe(idx);
                    deselect();
                });

                btn.update(() -> btn.setChecked(currentRecipe == idx));

                content.add(btn).growX().pad(0);
                content.row();
            }

            table.add(pane).grow();
        }

        @Override
        public boolean onConfigureBuildTapped(Building other) {
            return this != other;
        }

        private void switchRecipe(int idx) {
            if (currentRecipe == idx) return;
            Recipe newRec = idx < 0 ? null : (idx < recipes.length ? recipes[idx] : null);
            currentRecipe = idx;

            // 清空生产进度和热量输出
            progress = 0f;
            heatOutput = 0f;

            updateRecipeAttributes();

            // 播放切换特效
            Effect switchEff = (newRec != null && newRec.switchEffect != null) ? newRec.switchEffect : Fx.rotateBlock;
            switchEff.at(x, y, block.size);
        }

        @Override
        public boolean shouldConsume() {
            Recipe rec = getCurrentRecipe();
            if (rec == null) return false;

            if (rec.outputItems != null) for (ItemStack s : rec.outputItems) if (items.get(s.item) + s.amount > itemCapacity) return false;

            if (rec.outputLiquids != null) {
                boolean allFull = true;
                for (LiquidStack s : rec.outputLiquids) {
                    if (liquids.get(s.liquid) >= liquidCapacity - 0.001f) {
                        if (!dumpExtraLiquid) return false;
                    } else allFull = false;
                }
                if (allFull) return false;
            }

            if (rec.outputPayloads != null) {
                outputCountCache.clear();
                for (Payload p : outputPayloadQueue) {
                    UnlockableContent c = p.content();
                    outputCountCache.put(c, outputCountCache.get(c, 0) + 1);
                }
                for (PayloadStack s : rec.outputPayloads) {
                    if (outputCountCache.get(s.item, 0) + s.amount > payloadCapacity) return false;
                }
            }

            return enabled;
        }

        @Override
        public void write(Writes w) {
            super.write(w);
            w.i(currentRecipe);
            blocks.write(w);
            w.f(payVector.x);
            w.f(payVector.y);
            w.f(payRotation);
            w.i(outputPayloadQueue.size);
            for (Payload p : outputPayloadQueue) Payload.write(p, w);
            w.f(heatOutput);
            w.f(heat);
            w.f(progress);
            w.f(warmup);
        }

        @Override
        public void read(Reads r, byte revision) {
            super.read(r, revision);
            currentRecipe = r.i();
            blocks.read(r);
            payVector.set(r.f(), r.f());
            payRotation = r.f();
            outputPayloadQueue.clear();
            int size = r.i();
            for (int i = 0; i < size; i++) {
                Payload p = Payload.read(r);
                if (p != null) outputPayloadQueue.add(p);
            }
            heatOutput = r.f();
            heat = r.f();
            progress = r.f();
            warmup = r.f();

            // 恢复 craftTime 和 canOverdrive
            Recipe rec = getCurrentRecipe();
            if (rec == null) {
                craftTime = 80f;
                canOverdrive = false;
            } else {
                craftTime = rec.craftTime;
                canOverdrive = !(rec.outputHeat > 0) && rec.allowOverdrive;
            }
        }

        @Override
        public float efficiencyScale() {
            Recipe r = getCurrentRecipe();
            if (r == null || r.inputHeat <= 0) return 1f;
            float over = Math.max(heat - r.inputHeat, 0f);
            return Math.min(Mathf.clamp(heat / r.inputHeat) + over / r.inputHeat * overheatScale, maxEfficiency);
        }

        @Override
        public void update() {
            // 使用建筑实例自己的 canOverdrive（每个建筑独立判断）
            if ((timeScaleDuration -= Time.delta) <= 0f || !canOverdrive) {
                timeScale = 1f;
            }

            // 以下照搬原版逻辑
            if (!headless && block.ambientSound != Sounds.none && shouldAmbientSound()) {
                control.sound.loop(block.ambientSound, this, block.ambientSoundVolume * ambientVolume());
            }

            updateConsumption();

            if (enabled || !block.noUpdateDisabled) {
                updateTile();
            }
        }

        @Override
        public Object config() {
            return currentRecipe;
        }

        @Override
        public void placed() {
            super.placed();
            updateRecipeAttributes();
        }

        private void updateRecipeAttributes() {
            Recipe rec = getCurrentRecipe();
            if (rec == null) {
                craftTime = 80f;
                canOverdrive = false;
            } else {
                craftTime = rec.craftTime;
                canOverdrive = !(rec.outputHeat > 0) && rec.allowOverdrive;
            }
        }

        @Override
        public boolean acceptItem(Building source, Item item) {
            Recipe r = getCurrentRecipe();
            if (r == null || r.inputItems == null) return false;
            for (ItemStack s : r.inputItems) {
                if (s.item == item) return items.get(item) < itemCapacity;
            }
            return false;
        }

        @Override
        public boolean acceptLiquid(Building source, Liquid liquid) {
            Recipe r = getCurrentRecipe();
            if (r == null || r.inputLiquids == null) return false;
            for (LiquidStack s : r.inputLiquids) {
                if (s.liquid == liquid) return liquids.get(liquid) < liquidCapacity;
            }
            return false;
        }

        @Override
        public float warmup() {
            return warmup;
        }

        @Override
        public float totalProgress() {
            return totalProgress;
        }

        @Override
        public float getPowerProduction() {
            Recipe r = getCurrentRecipe();
            return (r != null && r.outputPower > 0) ? r.outputPower * efficiency : 0f;
        }

        @Override
        public float progress() {
            return Mathf.clamp(progress);
        }

        //region heat 部分
        @Override
        public float heat() {
            return heatOutput;
        }

        @Override
        public float heatFrac() {
            Recipe r = getCurrentRecipe();
            return (r != null && r.outputHeat > 0) ? heatOutput / r.outputHeat : 0f;
        }

        @Override
        public float[] sideHeat() {
            return sideHeat;
        }

        @Override
        public float heatRequirement() {
            Recipe r = getCurrentRecipe();
            return r != null ? r.inputHeat : 0f;
        }
        //endregion

        //region Payload 部分
        @Override
        public boolean acceptPayload(Building source, Payload payload) {
            Recipe r = getCurrentRecipe();
            if (r == null || r.inputPayloads == null) return false;
            var content = payload.content();
            for (var stack : r.inputPayloads) {
                if (stack.item == content) {
                    if (r.inputPayloadCapacity != 0) return blocks.get(content) < r.inputPayloadCapacity;
                    else return blocks.get(content) < stack.amount * r.inputPayloadMultiplier;
                }
            }
            return false;
        }

        @Override
        public void handlePayload(Building source, Payload payload) {
            var content = payload.content();
            Fx.payloadDeposit.at(x, y);
            blocks.add(content, 1);
            if (payload instanceof UnitPayload up) up.unit.remove();
        }

        @Override
        public Payload getPayload() {
            return outputPayloadQueue.isEmpty() ? null : outputPayloadQueue.first();
        }

        @Override
        public Payload takePayload() {
            if (outputPayloadQueue.isEmpty()) return null;
            return outputPayloadQueue.remove(0);
        }

        @Override
        public PayloadSeq getPayloads() {
            return blocks;
        }
        //endregion

    }

    public static class DynamicConsumePower extends ConsumePower {
        public DynamicConsumePower(float usage) {
            // 仅仅是把新配方需求传给父类，固定 usage
            super(usage, 0f, false);
        }

        @Override
        public float requestedPower(Building entity) {
            if (entity instanceof MultiCrafterBuild build) {
                Recipe r = build.getCurrentRecipe();
                return (r != null && r.inputPower > 0 && entity.shouldConsume()) ? r.inputPower : 0f;
            }
            return 0f;
        }

        // 新增：当前配方不耗电时，不参与效率计算
        @Override
        public float efficiency(Building entity) {
            if (entity instanceof MultiCrafterBuild build) {
                Recipe r = build.getCurrentRecipe();
                if (r == null || r.inputPower <= 0) return 1f; // 不需要电 → 满效率
            }
            return entity.power.status; // 需要电 → 正常检查电网满足率
        }

        @Override
        public void trigger(Building entity) {
            if (entity instanceof MultiCrafterBuild build) {
                Recipe r = build.getCurrentRecipe();
                if (r == null || r.inputPower <= 0) return; // 不需要电 → 不触发
            }
            // 需要电时，照搬原版逻辑
            if (buffered) {
                entity.power.status -= requestedPower(entity) / capacity;
            }
            // 原版直接消费者无实际触发动作，状态已在 update 中更新
        }
    }

}
