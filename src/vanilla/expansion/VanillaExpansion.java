package vanilla.expansion;

import arc.graphics.g2d.TextureRegion;
import mindustry.graphics.MultiPacker;
import mindustry.mod.ClassMap;
import mindustry.mod.Mod;
import mindustry.world.meta.Attribute;
import vanilla.expansion.VeEntities.Part.StatefulRegionPart;
import vanilla.expansion.VeEntities.Part.VePartProgress;
import vanilla.expansion.VeType.StatefulWeapon;
import vanilla.expansion.content.*;
import vanilla.expansion.content.Override;

import vanilla.expansion.assetsload.AssetLoader;

public class VanillaExpansion extends Mod {

    /** 添加新的环境属性 */
    public static final Attribute plant = Attribute.add("plant");

    public static String VeName(String add) {
        return "ve2" + "-" + add;
    }

    @java.lang.Override
    public void loadContent() {

        // 尝试让json文件也能使用StatefulWeapon
        ClassMap.classes.put("StatefulWeapon", StatefulWeapon.class);
        ClassMap.classes.put("StatefulRegionPart", StatefulRegionPart.class);
        ClassMap.classes.put("VePartProgress", VePartProgress.class);

        VeSounds.load();
        VeItems.load();
        VeStatusEffects.load();
        VeLiquids.load();
        VeWeathers.load();
        VeMissileUnitType.load();
        VeUnitTypes.load();
        VeTestUnitTypes.load();
        VeBlocks.load();
        VePlanets.load();
        VeSectors.load();
        VeTechTree.load();
        Override.load();
        SetShownPlanets.load();
    }

    @java.lang.Override
    public void packSprites(MultiPacker packer) {
        super.packSprites(packer);
        AssetLoader.packSheet(
                packer,
                "vesprites/nitroalkoss.png",
                "ve2-nitroalkoss",
                4, 3, 32, 32, 0
        );
        AssetLoader.packSheet(
                packer,
                "vesprites/phecteel.png",
                "ve2-phecteel",
                5, 4, 32, 32, 0, 1
        );
        AssetLoader.packSheet(
                packer,
                "vesprites/wall1.png",
                "ve2-",
                new String[] {
                        "aluminium-wall",
                        "aluminium-lead-wall",
                        "silicide-aluminium-wall",
                        "silicide-wall",
                        "chromium-wall",
                        "silicide-chromium-wall",
                        "mechanical-gate-small",
                        "mechanical-gate-small-open",
                        "advanced-plastanium-wall",
                        "fibralt-wall",
                        "ferrum-wall"
                },
                4, 3, 32, 32, 1, 1
        );
        AssetLoader.packSheet(
                packer,
                "vesprites/wall2.png",
                "ve2-",
                new String[] {
                        "aluminium-wall-large",
                        "aluminium-lead-wall-large",
                        "silicide-aluminium-wall-large",
                        "silicide-wall-large",
                        "chromium-wall-large",
                        "silicide-chromium-wall-large",
                        "mechanical-gate",
                        "mechanical-gate-open",
                        "automatic-gate",
                        "automatic-gate-open",
                        "advanced-plastanium-wall-large",
                        "fibralt-wall-large",
                        "surge-shield-wall",
                        "surge-shield-wall-glow",
                        "blocking-wall",
                        "blocking-wall-glow",
                        "blocking-wall-team",
                        "ferrum-wall-large"
                },
                5, 4, 64, 64, 1, 2
        );
        AssetLoader.packSheet(
                packer,
                "vesprites/production.png",
                "ve2-",
                new String[] {
                        "isomorphic-press",
                        "isomorphic-smelter",
                        "isomorphic-smelter-top",
                        "quartz-separator-large",
                        "quartz-separator-large-rotator1",
                        "quartz-separator-large-rotator2",
                        "quartz-separator-large-top",
                        "isomorphic-kiln",
                        "isomorphic-kiln-top"
                },
                3, 3, 64, 64, 1
        );
    }
}
