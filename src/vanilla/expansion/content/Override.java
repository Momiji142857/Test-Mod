package vanilla.expansion.content;

import arc.struct.Seq;
import mindustry.content.*;
import mindustry.ctype.UnlockableContent;
import mindustry.game.Objectives;
import mindustry.world.blocks.units.UnitFactory;

import static mindustry.content.Blocks.*;
import static mindustry.content.Items.*;
import static mindustry.content.SectorPresets.*;
import static mindustry.content.StatusEffects.corroded;
import static mindustry.content.UnitTypes.*;
import static mindustry.type.ItemStack.with;
import static vanilla.expansion.content.VeItems.*;
import static vanilla.expansion.content.VeSectors.*;

/**
 * 原版内容修改<p>
 * 修改内容:
 * - 物品属性
 * - 状态效果
 * - 兵厂生产配方
 * - 科技树节点
 */
public class Override {

    /** 用于 addAfter 方法中临时存储父节点 */
    public static TechTree.TechNode context = null;

    public static void load() {

        // Items
        pyratite.hardness = 2;

        // StatusEffects
        corroded.buildSpeedMultiplier = 1.75f;
        corroded.damage = 0.3f;

        // Liquids

        // Blocks
        worldMessage.forceDark = true;
        worldSwitch.forceDark = true;
        ((UnitFactory)groundFactory).plans.add(
                new UnitFactory.UnitPlan(flare, 60f * 40, with(silicon, 30, lead, 15, silicide, 20)),
                new UnitFactory.UnitPlan(mono, 60f * 25, with(silicon, 30, lead, 20)),
                new UnitFactory.UnitPlan(risso, 60f * 25, with(silicon, 30, lead, 20))
        );
        ((UnitFactory)airFactory).plans.add(
                new UnitFactory.UnitPlan(dagger, 60f * 20, with(silicon, 20, graphite, 20)),
                new UnitFactory.UnitPlan(crawler, 60f * 25, with(silicon, 30, graphite, 20)),
                new UnitFactory.UnitPlan(nova, 60f * 20, with(silicon, 25, lead, 10)),
                new UnitFactory.UnitPlan(risso, 60f * 55, with(silicon, 45, quartz, 20))
        );

        // TechTree
        addAfter(
                groundZero,
                TechTree.node(classic175, Seq.with(new Objectives.OnSector(groundZero)), () -> {
                    TechTree.node(classic222, Seq.with(new Objectives.OnSector(frozenForest)), () -> {
                        TechTree.node(classic223, Seq.with(new Objectives.OnSector(frozenForest)), () -> {
                            TechTree.node(classic133, Seq.with(new Objectives.OnSector(overgrowth)), () -> {});
                            TechTree.node(classic195, Seq.with(new Objectives.OnSector(frontier)), () -> {});
                            TechTree.node(classic7, Seq.with(new Objectives.OnSector(nuclearComplex)), () -> {});
                        });
                        TechTree.node(VeSectors.classic85, Seq.with(new Objectives.OnSector(frozenForest)), () -> {});
                    });
                })
        );
        addAfter(
                Items.sand,
                TechTree.nodeProduce(quartz, () -> {
                    TechTree.nodeProduce(silicide, () -> {});
                })
        );

    }

    /**
     * 在指定解锁内容后添加科技树节点
     * @param c       父节点对应的解锁内容
     * @param newNode 要添加的子节点
     * @throws IllegalArgumentException 父节点不存在或新节点为空
     */
    private static void addAfter(UnlockableContent c, TechTree.TechNode newNode) {
        if (c == null) {
            throw new IllegalArgumentException("父节点内容不能为空");
        }
        if (newNode == null) {
            throw new IllegalArgumentException("新节点不能为空");
        }

        TechTree.TechNode parent = TechTree.all.find(t -> t.content == c);
        if (parent == null) {
            throw new IllegalArgumentException("未找到父节点, 预期解锁内容: " + c);
        }

        parent.children.add(newNode);
        newNode.parent = parent;
    }

}
