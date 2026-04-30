package vanilla.expansion.content;

import mindustry.ctype.UnlockableContent;
import mindustry.type.Planet;

import static mindustry.content.Items.*;
import static mindustry.content.Liquids.*;
import static mindustry.content.Planets.serpulo;
import static vanilla.expansion.content.VeItems.*;
import static vanilla.expansion.content.VeLiquids.*;
import static vanilla.expansion.content.VePlanets.*;

/**
 * 配置各个内容在各个星球上的可见性.<p>
 * 用于设置原版和模组内容在哪些星球的科技树中显示.
 */

public class SetShownPlanets {

    // cyclant 和 phoon 共用相同的内容
    private static final Planet[] CYCLANT_PHOON = {cyclant, phoon};

    public static void load() {

        // Items
        addToShownPlanets(serpulo, quartz, silicide, salt);

        addToShownPlanets(CYCLANT_PHOON,
                // Vanilla
                lead, metaglass, graphite, sand, coal,
                titanium, thorium, scrap, silicon, plastanium,
                phaseFabric, surgeAlloy, sporePod, blastCompound, pyratite,
                // VE
                aluminium, quartz, catalyzon, silicide, salt,
                plantMatter, chromium, sodium, carbonShaleCobble, shaleCobble,
                nitroalkoss, cobalt, fibralt, fusionFuel, capacitor, warpNucleus
        );

        addToShownPlanets(maress,
                // Vanilla
                lead, metaglass, graphite, sand, coal,
                thorium, silicon, phaseFabric, surgeAlloy, blastCompound, pyratite,
                // VE
                aluminium, quartz, catalyzon, silicide, salt,
                chromium, sodium, nitroalkoss, fibralt, fusionFuel,
                capacitor, warpNucleus, redSoil, ferrum, reflectorMatter,
                ferricShaleCobble, silver, tantalum, astroPlate, phecteel
        );

        addToShownPlanets(sitrullus,
                // Vanilla
                graphite, coal, silicon,
                // VE
                quartz, silicide, nitroalkoss, ferrum, silver, melonDirt, sugar
        );

        // Liquids
        addToShownPlanets(CYCLANT_PHOON,
                // Vanilla
                water, slag, oil, cryofluid, hydrogen,
                // VE
                lava, chlorine
        );

        addToShownPlanets(maress,
                // Vanilla
                water, hydrogen,
                // VE
                lava, chlorine
        );

        addToShownPlanets(sitrullus,
                // Vanilla
                water, hydrogen,
                // VE
                melonWater
        );

    }

    /**
     * 将一个星球添加到多个内容的 shownPlanets 列表
     *
     * @param planet   要添加的星球
     * @param contents 可变参数，要添加星球的 UnlockableContent
     * @param <T>      内容类型，必须是 UnlockableContent 的子类
     * @throws NullPointerException 如果 planet 或 contents 中的元素为 null
     * @see UnlockableContent#shownPlanets
     */
    @SafeVarargs
    public static <T extends UnlockableContent> void addToShownPlanets(Planet planet, T... contents) {
        // 遍历所有内容实例，将星球添加到其显示列表中
        for (T content : contents) {
            content.shownPlanets.add(planet);
        }
    }

    /**
     * 将多个星球添加到多个内容的 shownPlanets 列表
     *
     * @param planets  要添加的星球数组
     * @param contents 可变参数，要添加星球的 UnlockableContent
     * @param <T>      内容类型，必须是 UnlockableContent 的子类
     * @throws NullPointerException 如果 planets 或 contents 中的元素为 null
     * @see UnlockableContent#shownPlanets
     */
    @SafeVarargs
    public static <T extends UnlockableContent> void addToShownPlanets(Planet[] planets, T... contents) {
        for (T content : contents) {
            content.shownPlanets.addAll(planets);
        }
    }

}
