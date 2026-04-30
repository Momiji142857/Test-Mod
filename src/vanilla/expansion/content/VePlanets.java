package vanilla.expansion.content;

import arc.graphics.Color;
import mindustry.content.Planets;
import mindustry.gen.Musics;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.graphics.g3d.NoiseMesh;
import mindustry.graphics.g3d.SunMesh;
import mindustry.type.Planet;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.Env;
import vanilla.expansion.content.VePlanetGenerators.CyclantPlanetGenerator;
import vanilla.expansion.content.VePlanetGenerators.MaressPlanetGenerator;
import vanilla.expansion.content.VePlanetGenerators.PhoonPlanetGenerator;

public class VePlanets {
    public static Planet
            sol2,
            cyclant,
            phoon,
            sitrullus,
            maress;

    public static void load() {

        sol2 = new Planet("sol2", null, 2f) {{
            drawOrbit = false;
            orbitRadius = 300f;
            orbitTime = 12000f;
            rotateTime = 10f * 60f;
            accessible = false;
            bloom = true;
            iconColor = Color.valueOf("387aff");
            // children.add(cyclant, maress, sitrullus);

            meshLoader = () -> new SunMesh(
                    this, 5, 5f, 0.3f,
                    1.5f, 1.2f, 1f, 1.1f,
                    Color.valueOf("387aff"),
                    Color.valueOf("3896ff"),
                    Color.valueOf("4cc6ff"),
                    Color.valueOf("4cc6ff"),
                    Color.valueOf("71e3ff"),
                    Color.valueOf("8eeef4")
            );
        }};

        cyclant = new Planet("cyclant", sol2, 1f, 3) {{
            alwaysUnlocked = true;

            generator = new CyclantPlanetGenerator();
            minZoom = 0.001f;
            maxZoom = 10f;
            drawOrbit = true;
            orbitRadius = 90f;
            orbitTime = 12000f;
            rotateTime = 20f * 60f;
            tidalLock = false;
            accessible = true;
            defaultEnv = Env.terrestrial | Env.groundOil | Env.groundWater | Env.oxygen;
            defaultAttributes.set(Attribute.spores, -1);
            defaultAttributes.set(Attribute.steam, 1);
            launchMusic = Musics.game4;
            defaultCore = VeBlocks.isomorphicCoreShard;

            updateLighting = true;
            lightSrcFrom = 0f;
            lightSrcTo = 0.8f;
            lightDstFrom = 0.25f;
            lightDstTo = 0.85f;

            bloom = false;
            visible = true;
            landCloudColor = Color.valueOf("938c9c7f");
            lightColor = Color.valueOf("3fc2ff80");
            atmosphereColor = Color.valueOf("90dbff80");
            iconColor = Color.valueOf("90dbff");
            hasAtmosphere = true;
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.4f;

            startSector = 170;
            sectorSeed = 0;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
            launchCapacityMultiplier = 0.5f;
            allowSectorInvasion = false;
            clearSectorOnLose = true;
            enemyCoreSpawnReplace = true;
            prebuildBase = false;
            allowLaunchToNumbered = false;
            allowCampaignRules = true;
            allowSelfSectorLaunch = false;

            showRtsAIRule = false;
            solarSystem = sol2;

            meshLoader = () -> new MultiMesh(
                    new NoiseMesh(this, 204, 6, 1f, 10, 0.5f, 1f, 0.5f, Color.valueOf("c59a78"), Color.valueOf("909862"), 1, 1f, 1f, 0.5f),
                    new NoiseMesh(this, 3, 6, 1f, 6, 0.5f, 0.5f, 0.5f, Color.valueOf("4d5ca420"), Color.valueOf("5867ac20"), 1, 1f, 1f, 0.5f),
                    new NoiseMesh(this, 2, 6, 0.982f, 8, 0.5f, 2f, 0.5f, Color.valueOf("3c4448"), Color.valueOf("909862"), 1, 1f, 1f, 0.5f),
                    new NoiseMesh(this, 9, 3, 0.3f, 8, 0.5f, 5f, 0.5f, Color.valueOf("00ff00"), Color.valueOf("00ff00"), 1, 1f, 1f, 0.5f),
                    //new NoiseMesh(this, 1005, 6, 0.988f, 6, 0.9f, 0.1f, 0.5f, Color.valueOf("c2c2c2"), Color.valueOf("676593"), 1, 1f, 1f, 0.5f),
                    new SunMesh(this, 2, 6f, 0.5f, 0.01f, 1.2f, 1.5f, 1.1f, Color.valueOf("ffa665"), Color.valueOf("feb380"))
            );
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 9, 2.8f, 0.07f, 5, Color.valueOf("938c9cd0"), 2, 0.42f, 0.9f, 0.43f),
                    new HexSkyMesh(this, 19, 1f, 0.15f, 5, Color.valueOf("b8c1e050"), 2, 0.4f, 0.5f, 0.45f),
                    new HexSkyMesh(this, 29, 0.6f, 0.2f, 5, Color.valueOf("c7e5ff30"), 2, 0.38f, 0.3f, 0.47f),
                    new HexSkyMesh(this, 39, 0.8f, 0.25f, 5, Color.valueOf("b8c1e020"), 2, 0.38f, 0.3f, 0.6f),
                    new HexSkyMesh(this, 49, 1.2f, 0.3f, 5, Color.valueOf("c7e5ff10"), 2, 0.38f, 0.3f, 0.75f)
            );
        }};

        phoon = new Planet("phoon", cyclant, 0.2f, 1) {{
            alwaysUnlocked = true;

            generator = new PhoonPlanetGenerator();
            camRadius = 0.25f;
            minZoom = 0.2f;
            maxZoom = 3f;
            drawOrbit = true;
            orbitRadius = 4.5f;
            orbitTime = 600f;
            rotateTime = 10f * 60f;
            tidalLock = true;
            accessible = true;
            defaultEnv = Env.terrestrial | Env.groundOil | Env.groundWater | Env.oxygen;
            defaultAttributes.set(Attribute.spores, -1);
            defaultAttributes.set(Attribute.steam, 1);
            launchMusic = Musics.game4;
            defaultCore = VeBlocks.isomorphicCoreShard;

            updateLighting = false;
            bloom = false;
            visible = true;
            landCloudColor = Color.valueOf("989aa4f");
            lightColor = Color.valueOf("b0bac0dd");
            atmosphereColor = Color.valueOf("989aa422");
            iconColor = Color.valueOf("989aa4");
            hasAtmosphere = true;
            atmosphereRadIn = 0.01f;
            atmosphereRadOut = 0.02f;

            startSector = 0;
            sectorSeed = 0;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
            launchCapacityMultiplier = 0.5f;
            allowSectorInvasion = false;
            clearSectorOnLose = true;
            enemyCoreSpawnReplace = true;
            prebuildBase = true;
            allowLaunchToNumbered = false;
            allowCampaignRules = true;

            showRtsAIRule = false;
            solarSystem = sol2;

            meshLoader = () -> new MultiMesh(
                    new NoiseMesh(this, 204, 2, 0.2f, 5, 0.5f, 1f, 0.5f, Color.valueOf("b0bac0"), Color.valueOf("989aa4"), 1, 1f, 1f, 0.5f),
                    new NoiseMesh(this, 3, 2, 0.2f, 3, 0.5f, 0.5f, 0.5f, Color.valueOf("989aa4"), Color.valueOf("6e7080"), 1, 1f, 1f, 0.5f)
            );
            cloudMeshLoader = () -> new MultiMesh();
        }};

        sitrullus = new Planet("sitrullus", sol2, 0.6f, 2) {{
            alwaysUnlocked = true;

            minZoom = 1.2f;
            maxZoom = 10f;
            drawOrbit = true;
            orbitRadius = 105f;
            orbitTime = 15122f;
            rotateTime = 30f * 60f;
            tidalLock = false;
            accessible = true;
            // defaultEnv = Env.terrestrial | Env.groundOil | Env.groundWater | Env.oxygen;
            defaultAttributes.set(Attribute.spores, 0.5f);
            defaultAttributes.set(Attribute.water, 2f);
            launchMusic = Musics.game8;
            // defaultCore = VeBlocks.coreGeneraleneral;
            updateLighting = true;
            lightSrcFrom = 0f;
            lightSrcTo = 1f;
            lightDstFrom = 0f;
            lightDstTo = 1f;

            bloom = false;
            visible = true;
            landCloudColor = Color.valueOf("daf9c87f");
            lightColor = Color.valueOf("ff555550");
            atmosphereColor = Color.valueOf("88c96180");
            iconColor = Color.valueOf("88c961");
            hasAtmosphere = true;
            atmosphereRadIn = 0.01f;
            atmosphereRadOut = 0.1f;

            startSector = 15;
            sectorSeed = 0;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
            launchCapacityMultiplier = 0.5f;
            allowSectorInvasion = false;
            clearSectorOnLose = true;
            enemyCoreSpawnReplace = true;
            prebuildBase = false;
            allowLaunchToNumbered = false;
            allowCampaignRules = true;
            allowSelfSectorLaunch = true;

            showRtsAIRule = false;
            solarSystem = sol2;

            meshLoader = () -> new MultiMesh(
                    new NoiseMesh(this, 73, 5, 0.609f, 10, 0.5f, 12f, 0f, Color.valueOf("ff555520"), Color.valueOf("9e78dc80"), 1, 1f, 1f, 0.5f),
                    new NoiseMesh(this, 117, 5, 0.6f, 10, 0.5f, 2f, 0.2f, Color.valueOf("ff555520"), Color.valueOf("cc343420"), 1, 1f, 1f, 0.5f),
                    new NoiseMesh(this, 128, 5, 0.585f, 10, 0.5f, 1f, 0.4f, Color.valueOf("88c961"), Color.valueOf("5ba232"), 1, 1f, 1f, 0.5f),
                    new NoiseMesh(this, 128, 5, 0.59f, 10, 0.5f, 1f, 0.33f, Color.valueOf("ddf5b0"), Color.valueOf("edf5b0"), 1, 1f, 1f, 0.5f)
            );
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 574, 0.3f, 0.08f, 4, Color.valueOf("daf9c840"), 2, 0.42f, 0.9f, 0.43f),
                    new HexSkyMesh(this, 73, 0.2f, 0.1f, 4, Color.valueOf("edffe220"), 2, 0.42f, 0.9f, 0.43f)
            );
        }};

        maress = new Planet("maress", sol2, 0.75f, 3) {{
            alwaysUnlocked = true;

            generator = new MaressPlanetGenerator();
            minZoom = 0.001f;
            maxZoom = 10f;
            drawOrbit = true;
            orbitRadius = 120f;
            orbitTime = 21333f;
            rotateTime = 1100f;
            tidalLock = false;
            accessible = true;
            // defaultEnv = Env. | Env.; // 环境
            defaultAttributes.set(Attribute.spores, -1);
            defaultAttributes.set(Attribute.light, 0.2f);
            defaultAttributes.set(Attribute.sand, 1);
            launchMusic = Musics.game8;
            defaultCore = VeBlocks.isomorphicCoreShard;

            updateLighting = true;
            lightSrcFrom = 0f;
            lightSrcTo = 1f;
            lightDstFrom = 0f;
            lightDstTo = 1.2f;

            bloom = false;
            visible = true;
            landCloudColor = Color.valueOf("b6a49911");
            lightColor = Color.valueOf("e69663dd");
            atmosphereColor = Color.valueOf("e69663");
            iconColor = Color.valueOf("de8a5b");
            hasAtmosphere = true;
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.15f;

            startSector = 43;
            sectorSeed = 0;
            allowLaunchSchematics = false;
            allowLaunchLoadout = true;
            launchCapacityMultiplier = 0.5f;
            allowSectorInvasion = false;
            clearSectorOnLose = true;
            enemyCoreSpawnReplace = true;
            prebuildBase = false;
            allowLaunchToNumbered = false;

            showRtsAIRule = false;
            solarSystem = sol2;

            meshLoader = () -> new MultiMesh(
                    new NoiseMesh(this, 177, 5, 0.733f, 10, 0.5f, 2f, 0.3f, Color.valueOf("ba754e"), Color.valueOf("88624c40"), 1, 1f, 1f, 0.5f),
                    new NoiseMesh(this, 995, 5, 0.708f, 6, 0.5f, 0.1f, 0.5f, Color.valueOf("c2c2c2"), Color.valueOf("b6a499"), 1, 1f, 1f, 0.5f),
                    new NoiseMesh(this, 995, 2, 0.01f, 6, 0.5f, 10f, 100f, Color.valueOf("c2c2c2"), Color.valueOf("b6a499"), 1, 1f, 1f, 0.5f),
                    new NoiseMesh(this, 995, 2, 0.5f, 6, 0.5f, 2f, 1f, Color.valueOf("c2c2c2"), Color.valueOf("b6a499"), 1, 1f, 1f, 0.5f)
            );
            cloudMeshLoader = () -> new HexSkyMesh(
                    this, 78, 1f, 0.12f, 5,
                    Color.valueOf("b6a49933"),
                    2, 0.4f, 0.5f, 0.45f
            );
        }};

        cyclant.launchCandidates.add(Planets.serpulo, phoon, sitrullus, maress);
        phoon.launchCandidates.add(cyclant);
        maress.launchCandidates.add(cyclant, sitrullus);

        /*
        planet = new Planet("", , f, ) {{
            alwaysUnlocked = ; // false

            // 基础属性
            generator = new (); // 区块生成器
            camRadius = f; // 摄像机半径偏移
            minZoom = f; // 0.5f 视角最小缩放
            maxZoom = f; // 2f 视角最大缩放
            drawOrbit = ; // true 有无公转轨道
            orbitRadius = f; // 公转轨道半径
            orbitTime = f; // 公转周期
            rotateTime = f; // 24f * 60f 自转周期
            tidalLock = ; // false 是否潮汐锁定
            accessible = ; // true 是否在星球选择界面显示
            defaultEnv = Env. | Env.; // 环境
            defaultAttributes.set(Attribute., ); // 属性
            launchMusic = Musics.; // launch 星球界面播放的音乐
            defaultCore = Blocks.; // coreShard 默认核心类型
            techTree = TechTree.all.find((t) -> t.content == ); // 在此星球打开科技树时默认的根节点
            autoAssignPlanet = ; // true 是否自动将该星球添加到科技树内容的shownPlanets列表里
            unlockedOnLand.add(); // 着陆时自动解锁

            // 外观
            updateLighting = ; // false 昼夜循环
            lightSrcFrom = f; // 0f 光源起始位置
            lightSrcTo = f; // 0.8f 光源终止位置
            lightDstFrom = f; // 0.2f 光源距离起始值
            lightDstTo = f; // 1f 光源距离最大值

            bloom = ; // false 是否启用泛光渲染效果
            visible = ; // true 是否在星系中显示
            landCloudColor = Color.valueOf(""); // 着陆时显示的云的颜色
            lightColor = Color.valueOf(""); // 仅用于恒星, 照射到行星上的颜色
            atmosphereColor = Color.valueOf(""); // 大气颜色
            iconColor = Color.valueOf(""); // 行星列表中的图标颜色
            hasAtmosphere = ; // true 有无大气层
            atmosphereRadIn = f; // 0f 大气层内径
            atmosphereRadOut = f; // 0.3f 大气层外径

            // 区块相关
            startSector = ; // 0 默认起始区块
            sectorSeed = ; // -1 区块基地生成种子
            allowLaunchSchematics = ; // false 能否使用发射蓝图
            allowLaunchLoadout = ; // false 指定发射时消耗的资源
            launchCapacityMultiplier = f; // 0.25f 发射时可携带物品的最大数量与核心容量的比例
            allowSectorInvasion = ; // false 是否启用敌人反攻
            allowLegacyLaunchPads = ; // false 是否启用旧版发射台
            clearSectorOnLose = ; // false 丢失区块时是否重置区块
            enemyBuildSpeedMultiplier = f; // 1f 敌方重建建筑的速度倍率
            enemyInfiniteItems = ; // true 敌方是否始终拥有无限物品
            enemyCoreSpawnReplace = ; // false 是否启用核心生成
            prebuildBase = ; // false 着陆时是否清除核心附近建筑并在冲击波中重建
            allowWaves = ; // false 区块丢失时是否生成波次
            allowLaunchToNumbered = ; // true 是否启用数字区块
            allowCampaignRules = ; // false 能否在星球界面更改难度和规则
            allowSelfSectorLaunch = ; // 星际加速器能否去往该星球的任意区块

            // 规则相关
            campaignRules. = ; // 全局难度/修改器设置
            campaignRuleDefaults. = ; // 规则的默认值
            ruleSetter = r -> {
                r. = ;
            }; // 游戏加载时为该星球上的任意区块设置规则
            showRtsAIRule = ; // false 能否自定义Rts AI

            // 地形和云层
            meshLoader = () -> new MultiMesh();
            cloudMeshLoader = () -> new MultiMesh();

            // 与其他星球关联
            solarSystem = Planets.; // 所处星系的中心天体
            children.add(Planets.); // 所有卫星, 按半径升序排列
            launchCandidates.addAll(Planets.); // 能从该星球发射去往的目标星球列表
            updateGroup.add(); // 可同时进行后台运算的星球
        }};
        */

        /*
        planet = new Planet("", , f, ) {{
            alwaysUnlocked = ; // false

            minZoom = f; // 0.5f 视角最小缩放
            maxZoom = f; // 2f 视角最大缩放
            drawOrbit = ; // true 有无公转轨道
            atmosphereRadIn = f; // 0f 大气层内径
            atmosphereRadOut = f; // 0.3f 大气层外径
            orbitRadius = f; // 公转轨道半径
            orbitTime = f; // 公转周期
            rotateTime = f; // 24f * 60f 自转周期
            tidalLock = ; // false 是否潮汐锁定
            accessible = ; // true 是否在星球选择界面显示
            defaultEnv = Env. | Env.; // 环境
            defaultAttributes.set(Attribute., ); // 属性
            updateLighting = ; // false 昼夜循环
            lightSrcFrom = f; // 0f 光源起始位置
            lightSrcTo = f; // 0.8f 光源终止位置
            lightDstFrom = f; // 0.2f 光源距离起始值
            lightDstTo = f; // 1f 光源距离最大值
            startSector = ; // 0 默认起始区块
            sectorSeed = ; // -1 区块基地生成种子
            launchCapacityMultiplier = f; // 0.25f 发射时可携带物品的最大数量与核心容量的比例
            bloom = ; // false 是否启用光晕渲染效果
            visible = ; // true 是否在星系中显示
            landCloudColor = Color.valueOf(""); // 着陆时显示的云的颜色
            lightColor = Color.valueOf(""); // 仅用于恒星, 照射到行星上的颜色
            atmosphereColor = Color.valueOf(""); // 大气颜色
            iconColor = Color.valueOf(""); // 行星列表中的图标颜色
            hasAtmosphere = ; // true 有无大气层
            allowLaunchSchematics = ; // false 能否使用发射蓝图
            allowLaunchLoadout = ; // false 指定发射时消耗的资源
            allowSectorInvasion = ; // false 是否启用敌人反攻
            allowLegacyLaunchPads = ; // false 是否启用旧版发射台
            clearSectorOnLose = ; // false 丢失区块时是否重置区块
            enemyBuildSpeedMultiplier = f; // 1f 敌方重建建筑的速度倍率
            enemyInfiniteItems = ; // true 敌方是否始终拥有无限物品
            enemyCoreSpawnReplace = ; // false 是否启用核心生成
            prebuildBase = ; // false 着陆时是否清除核心附近建筑并在冲击波中重建
            allowWaves = ; // false 区块丢失时是否生成波次
            allowLaunchToNumbered = ; // true 是否启用数字区块
            allowCampaignRules = ; // false 能否在星球界面更改难度和规则
            launchMusic = Musics.; // launch 星球界面播放的音乐
            defaultCore = Blocks.; // coreShard 默认核心类型
            solarSystem = Planets.; // 所处星系的中心天体
            children.add(Planets.); // 所有卫星, 按半径升序排列
            techTree = TechTree.all.find((t) -> t.content == ); // 在此星球打开科技树时默认的根节点
            launchCandidates.addAll(Planets.); // 能从该星球发射去往的目标星球列表
            allowSelfSectorLaunch = ; // 星际加速器能否去往该星球的任意区块
            autoAssignPlanet = ; // true 是否自动将该星球添加到科技树内容的shownPlanets列表里
            unlockedOnLand.add(); // 着陆时自动解锁

            updateGroup.add(); // 可同时进行后台运算的星球
            campaignRules. = ; // 全局难度/修改器设置
            campaignRuleDefaults. = ; // 规则的默认值
            ruleSetter = r -> {
                r. = ;
            }; // 游戏加载时为该星球上的任意区块设置规则
            showRtsAIRule = ; // false 能否自定义Rts AI

            meshLoader = () -> new MultiMesh();

            cloudMeshLoader = () -> new MultiMesh();

        }};
        */
    }
}
