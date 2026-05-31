package vanilla.expansion;

import arc.Core;
import arc.files.Fi;
import arc.graphics.Pixmap;
import arc.graphics.g2d.PixmapRegion;
import arc.graphics.g2d.TextureRegion;
import mindustry.Vars;
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

    public static TextureRegion[] nitroFrames;

    @java.lang.Override
    public void loadContent() {

        /*
        Fi sheetFile = Vars.tree.get("vesprites/nitroalkoss.png");
        if (sheetFile == null) {
            // 如果为 null，说明 jar 内路径不对，请用压缩软件检查 jar 内完整路径
            throw new RuntimeException("vesprites/nitroalkoss.png not found in mod jar. Check the jar structure.");
        }

        TextureRegion[] frames = AssetLoader.loadSheet(
                sheetFile,
                "nitroalkoss",   // 第一帧名 nitroalkoss，后续 nitroalkoss-1...
                4, 3,            // 列、行
                32, 32,          // 帧尺寸
                0                // 间距
        );
        */

        /*
        TextureRegion[] frames = AssetLoader.loadSheet(
                sheetFile,
                "nitroalkoss",   // 基础名，第一帧就是这个，第二帧 nitroalkoss-1 ...
                4, 2,            // 列、行
                64, 64,          // 帧宽、帧高
                0                // padding
        );
        */

        /*
        Fi testFile = Core.files.internal("assets/vesprites/nitroalkoss.png");
        Log.info("File exists: @", testFile.exists());
        Log.info("Full path: @", testFile.absolutePath());
        */

        /*
        AssetLoader.loadSheet(
                "vesprites/nitroalkoss.png",
                "nitroalkoss",
                4, 3,
                32, 32,
                0
        );
        */

        // packSprites 已在异步阶段执行完毕，此时 Core.atlas 已包含所有帧
        int totalFrames = 8;
        nitroFrames = new TextureRegion[totalFrames];
        nitroFrames[0] = Core.atlas.find("ve2-nitroalkoss");
        for (int i = 1; i < totalFrames; i++) {
            nitroFrames[i] = Core.atlas.find("ve2-nitroalkoss" + i);
        }

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
