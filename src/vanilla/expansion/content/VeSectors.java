package vanilla.expansion.content;

import mindustry.content.Planets;
import mindustry.type.SectorPreset;

public class VeSectors {
    public static SectorPreset
            // Serpulo
            classic175, classic222, classic223, classic85, classic133, classic195, classic7,

            // cyclant
            barrierHill, carbonRelics, wetlandMiningfield, intervalley,
                    volcanicTop, fortPort, gobi, fungusFactory, shaleQuarry, unitLaboratory,
                    ruins, thoriumHacienda, nuclearPowerplant, crossForest,
                    primeRoute, planetaryCargoCenter, retreatZone,

            isolateIsland, siliconFacility, blastTest;

    public static void load() {

        // Serpulo
        classic175 = new SectorPreset("classic-175", Planets.serpulo, 175) {{
            captureWave = 25;
            difficulty = 3f;
            isLastSector = false;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
        }};

        classic222 = new SectorPreset("classic-222", Planets.serpulo, 222) {{
            captureWave = 25;
            difficulty = 4f;
            isLastSector = false;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
        }};

        classic223 = new SectorPreset("classic-223", Planets.serpulo, 218) {{
            captureWave = 25;
            difficulty = 4f;
            isLastSector = false;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
            originalPosition = 223;
        }};

        classic85 = new SectorPreset("classic-85", Planets.serpulo, 125) {{
            captureWave = 25;
            difficulty = 4f;
            isLastSector = false;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
            originalPosition = 85;
        }};

        classic133 = new SectorPreset("classic-133", Planets.serpulo, 133) {{
            captureWave = 0;
            difficulty = 6f;
            isLastSector = false;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
        }};

        classic195 = new SectorPreset("classic-195", Planets.serpulo, 195) {{
            captureWave = 25;
            difficulty = 4f;
            isLastSector = false;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
        }};

        classic7 = new SectorPreset("classic-7", Planets.serpulo, 7) {{
            captureWave = 35;
            difficulty = 6f;
            isLastSector = false;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
        }};

        //cyclant
        barrierHill = new SectorPreset("barrier-hill", VePlanets.cyclant, 170) {{
            alwaysUnlocked = true;
            captureWave = 10;
            difficulty = 1;
            addStartingItems = true;
            isLastSector = false;
        }};

        carbonRelics = new SectorPreset("carbon-relics", VePlanets.cyclant, 35) {{
            captureWave = 20;
            difficulty = 3f;
            isLastSector = false;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
        }};

        wetlandMiningfield = new SectorPreset("wetland-miningfield", VePlanets.cyclant, 20) {{
            captureWave = 0;
            difficulty = 3f;
            isLastSector = false;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
        }};

        intervalley = new SectorPreset("intervalley", VePlanets.cyclant, 19) {{
            captureWave = 30;
            difficulty = 5f;
            isLastSector = false;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
        }};

        volcanicTop = new SectorPreset("volcanic-top", VePlanets.cyclant, 95) {{
            captureWave = 0;
            difficulty = 4f;
            isLastSector = false;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
        }};

        fortPort = new SectorPreset("fort-port", VePlanets.cyclant, 137) {{
            captureWave = 40;
            difficulty = 5f;
            isLastSector = false;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
        }};

        gobi = new SectorPreset("gobi", VePlanets.cyclant, 222) {{
            captureWave = 0;
            difficulty = 4f;
            isLastSector = false;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
        }};

        fungusFactory = new SectorPreset("fungus-factory", VePlanets.cyclant, 230) {{
            captureWave = 0;
            difficulty = 4f;
            isLastSector = false;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
        }};

        shaleQuarry = new SectorPreset("shale-quarry", VePlanets.cyclant, 261) {{
            captureWave = 50;
            difficulty = 7f;
            isLastSector = false;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
        }};

        unitLaboratory = new SectorPreset("unit-laboratory", VePlanets.cyclant, 143) {{
            captureWave = 0;
            difficulty = 8f;
            isLastSector = false;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
        }};

        ruins = new SectorPreset("ruins", VePlanets.cyclant, 98) {{
            captureWave = 0;
            difficulty = 7f;
            isLastSector = false;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
        }};

        thoriumHacienda = new SectorPreset("thorium-hacienda", VePlanets.cyclant, 227) {{
            captureWave = 60;
            difficulty = 6f;
            isLastSector = false;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
        }};

        nuclearPowerplant = new SectorPreset("nuclear-powerplant", VePlanets.cyclant, 228) {{
            captureWave = 0;
            difficulty = 8f;
            isLastSector = false;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
        }};

        crossForest = new SectorPreset("cross-forest", VePlanets.cyclant, 39) {{
            captureWave = 30;
            difficulty = 9f;
            isLastSector = false;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
        }};

        primeRoute = new SectorPreset("prime-route", VePlanets.cyclant, 144) {{
            captureWave = 40;
            difficulty = 9f;
            isLastSector = false;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
        }};

        planetaryCargoCenter = new SectorPreset("planetary-cargo-center", VePlanets.cyclant, 245) {{
            captureWave = 0;
            difficulty = 10f;
            isLastSector = false;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
        }};

        retreatZone = new SectorPreset("retreat-zone", VePlanets.cyclant, 224) {{
            captureWave = 0;
            difficulty = 10f;
            isLastSector = true;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
        }};

        isolateIsland = new SectorPreset("isolate-island", VePlanets.cyclant, 91) {{
            captureWave = 50;
            difficulty = 6f;
            isLastSector = true;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
        }};

        siliconFacility = new SectorPreset("silicon-facility", VePlanets.cyclant, 53) {{
            captureWave = 0;
            difficulty = 4f;
            isLastSector = true;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
        }};

        blastTest = new SectorPreset("blast-test", VePlanets.cyclant, 24) {{
            captureWave = 0;
            difficulty = 9f;
            isLastSector = true;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
        }};

        /*
        Sector = new SectorPreset("", Planets., ) {{
            captureWave = ; // 0 占领波次
            difficulty = f; // 0-10 难度
            startWaveTimeMultiplier = f; // 2f 起始波次时间倍率
            addStartingItems = ; // false 是否添加起始物品
            noLighting = ; // false 是否无光照
            isLastSector = ; // 是否为最终区域
            requireUnlock = ; // true 是否需要解锁
            showHidden = ; // false 是否显示隐藏区域. 即使是一个始终解锁的隐藏区域，是否也显示其图标和名称 (后续可能会更改)
            showSectorLandInfo = ; // true 发射时是否显示详细信息
            overrideLaunchDefaults = ; // false 是否覆盖默认发射配置
            allowLaunchSchematics = ; // false 能否使用发射蓝图
            allowLaunchLoadout = ; // false 是否允许自定义携带的物品
            attackAfterWaves = ; // false 波次结束后是否转为进攻模式
            originalPosition = ; // 区块原始位置
            shieldSectors = ; // 护盾区域列表. 仅当列表内的区块全部占领之后才解锁
            fileName = ""; // 文件名
        }};
        */
    }
}
