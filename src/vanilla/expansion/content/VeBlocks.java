package vanilla.expansion.content;

import arc.audio.RandomSound;
import arc.graphics.Color;
import arc.math.Interp;
import arc.struct.Seq;
import mindustry.content.*;
import mindustry.entities.TargetPriority;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.DrawPart;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootBarrel;
import mindustry.entities.pattern.ShootMulti;
import mindustry.entities.pattern.ShootPattern;
import mindustry.gen.Sounds;
import mindustry.graphics.CacheLayer;
import mindustry.graphics.Layer;
import mindustry.type.*;
import mindustry.world.Block;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.LiquidTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.power.BeamNode;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.storage.Unloader;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import vanilla.expansion.VanillaExpansion;

public class VeBlocks {

    public static Block
            //environment
            accessibleDeepWater, deepWaterOil, flowingLava, antigrass, semigrass, gravel, carbonShale, hillStone, saltyIce, deepslate, deepslateBrick, coreZoneCyclant, metalTiles13ve, metalTiles14ve, metalTiles15ve, metalTiles16ve,
                    antigrassWall, semigrassWall, carbonShaleWall, hillStoneWall, deepslateWall, deepslateBrickWall, darkMetalRepaired,
                    carbonShaleBoulder, hillStoneBoulder,

            redSoilFloor, redSoilFinely, redSoilPebble, redSoilWet, ferricShale,
                    redSoilWall, redSoilWetWall, ferricShaleWall,
                    mirmat, ferricShaleBoulder, silvelade, silveladeLarge,

            melonwaterDeep, melonwater, melondirtWater, melondirt, melondirtWhite, melonShell, melonShellDark,
                    sporeMelonwaterDeep, sporeMelonwater, sporeMelondirt, sporeMelondirtMoss,
                    melondirtWall, sporeMelondirtWall,

            orePyratite, oreAluminium, oreChromium, oreCobalt, oreFerrum, oreSilver, oreSilverPure, oreTantalum,
                    oreWallAluminium, oreWallQuartz,
                    oreCatalyzon,

            redGround, greenGround, blueGround, whiteGround, darkGround,
                    pureDark,

            //turrets
            click, frag, pulse, rise, bake, waterer,
            beat, crack, shock,
            buffet, burn, dot, spurt,
            snipe, halberd, shell,
            sweep, chain, stab,
            buster, parasite,

            burst, ash, pantype,

            douible, vector,

            sans,

            //production
            mechanicalDrillMicro, mechanicalDrillHuge,

            isomorphicDrill, isomorphicDrillHuge, laserBore, powerDrill, beamDrill, silicideDrill,
                    hydraulicDrill, powderDigger, floorCrusher, spaceDigger,

            powerWell, pressureWell,
                    extractionPlatform, lavaWell,

            isomorphicCultivator, cultivateTank, tissueCultivator,
                    nitroalkossCultivator, nitroalkossCultivatorSilicide,

            reflectorCultivator,

            collector, magneticDigger, mechanicalWell, rotChamber,

            //transport - serpulo
            armoredBridgeConveyor, armoredRouter, armoredOverflowGate, armoredUnderflowGate, armoredUnloader,
                    silicideDuct, silicideArmoredDuct, silicideJunction, silicideBridgeConveyor, silicideSorter, silicideInvertedSorter, silicideRouter, silicideDistributor, silicideOverflowGate, silicideUnderflowGate, silicideUnloader,

            //transport - erekir
            ductJunction,

            //transport - cyclant
            rail, railJunction, railBridge, railRouter, railOverflowGate, railUnderflowGate, railUnloader,
                    silicideRail, silicideRailJunction, silicideRailBridge, silicideRailRouter, silicideRailOverflowGate, silicideRailUnderflowGate, silicideRailUnloader,
                    chromiumConveyor, chromiumSorter, cobaltRail, cobaltRailBridge, cobaltRailUnderflowGate, cobaltRailUnloader,

            stackRail, silicideStackRail, phaseUnloader, multiUnloader, massLauncher, massRailgun, warpDriver,

            //transport - maress, sitrullus
            ferricConveyor, ferricConveyorArmored, ferricRail, /* magneticDuct, */ valveCross, ferricBridge, valveSort, valveInvertedSort, valveDistribute, valveOverflow, valveUnderflow, valveUnload,

            //liquid
            isomorphicPump, platformPump, pressurePump,
                    isomorphicConduit, fluidJunction, isomorphicBridgeConduit, fluidRouter, can, tank,
                    pressureConduit, platformBridgeConduit,
                    silicidePlatedConduit,
                    silicideConduit, silicideFluidJunction, silicideBridgeConduit, silicideFluidRouter, canSilicide, tankSilicide,

            //liquid - maress, sitrullus
            chainedPump,
                    silverConduit, silverConduitArmored, valveFluidCross, silverBridge, valveFluidDistribute,

            //power
            advancedNode, advancedNodeLarge, isomorphicNode, isomorphicNodeLarge, insulatedNode, sectorPowerTower,
                    nodeBlocker, powerBattery, silicideBattery, sodiumSulphurBattery, charger, discharger,
                    largeCombustionGenerator, largeTurbineGenerator, geothermalGenerator, solarPad, lavaThermalGenerator, internalCombustionGenerator, sodiumReactor, solidFuelCell, fluidFuelCell, microReactor, isomorphicReactor, radioactiveThermalGenerator, fusionReactor,

            spotSolarPad,
                    cable, batteryNode, melonCell, fermentor,

            winTower,

            //defense
            copperWallHuge, titaniumWallHuge, thoriumWallHuge,
                    defensiveWall, defensiveWallLarge, defensiveWallHuge,
                    effectiveWall, effectiveWallLarge,

            aluminiumWall, aluminiumWallLarge, aluminiumWallHuge,
                    aluminiumLeadWall, aluminiumLeadWallLarge, aluminiumLeadWallHuge,
                    silicideWall, silicideWallLarge,
                    silicideAluminiumWall, silicideAluminiumWallLarge, silicideAluminiumWallHuge,
                    chromiumWall, chromiumWallLarge, chromiumWallHuge,
                    silicideChromiumWall, silicideChromiumWallLarge, silicideChromiumWallHuge,
                    mechanicalGateSmall, mechanicalGate, mechanicalGateSilicide,
                    automaticGate, automaticGateSilicide,
                    advancedPlastaniumWall, advancedPlastaniumWallLarge, fibraltWall, fibraltWallLarge, surgeShieldWall,
                    blockingWall, blockingWallSilicide,

            ferrumWall, ferrumWallLarge, ferrumWallHuge,

            titanicPlastaniumWall, bush, tree,

            //crafting
            quartzExtractor,

            //crafting - cyclant
            isomorphicPress, hydraulicPress, isomorphicSmelter, substitutionChamber, quartzSeparator, quartzSeparatorLarge, isomorphicKiln, silicideCrucible, silicideMixer, pyratiter, blaster, lavaCooler, plantPress, cellLaboratory,
                    gasificationChamber, sporeBlender, meltingElectrolyzer, sodiumCarbonFixator, saltElectrolyzer, surgeElectrolyzer, nitroalkossReactor,
                    crackingCompressor, fibraltExtender, chainTransferer, carbonizationChamber,
                    surgeCoagulator, catalyzonCrafter, fusionRefueller, fusionDisfueller, phaseLoom, warper, titaniumExtractor, carbonShaleSmelter, coalSynthezer, isomorphicPulverizer, largePulverizer, decomposer, eddyMelter, Extractor, recycler,

            //crafting - maress, sitrullus
            blastFurnace, multiFurnace, reductionChember, magneticSeparator, centrifugeKiln, reflectorThermolyzer,
                    boiler, reactorCore,

            siliconOxidator, concentrator,
                    filter, blender,

            //units
            giganticPayloadConveyor,

            //units - cyclant
            groundFabricator, airFabricator, navalFabricator, specialFabricator, integratedConstructor,
                    isomorphicAdditiveReconstructor, isomorphicMultiplicativeReconstructor,
                    juniorArmorcarReconstructor, juniorCrabbotReconstructor, juniorHovershipReconstructor,
                    seniorArmorcarReconstructor, seniorCrabbotReconstructor, seniorHovershipReconstructor,
                    superReconstructor, ultraReconstructor,
                    juniorRefabricator, seniorRefabricator,
                    specialAssembler, superAssembler, ultraAssembler, bossAssembler,
                    assemblePacker, assembleSelector1, assembleSelector2, assembleSelector3, superAssemblePack, ultraAssemblePack, hyperAssemblePack,
                    isomorphicRepairPoint, platformTheta, platformLambda, platformSigma, warpTeleporter,

            payloadRail, payloadRailRouter, cobaltPayloadRail, cobaltPayloadRailRouter,
                    payloadRailLarge, payloadRailRouterLarge, cobaltPayloadRailLarge, cobaltPayloadRailRouterLarge,

            //effect
            overdriver, mendDome,

            //effect - cyclant
            mendPoint, menderator, mendGlobe, overdriverPoint, overdrivator, overdriverGlobe, forcerator,
                    teamProjectorSharded, plastaniumStool, warpDefender,
                    isomorphicCoreShard, isomorphicCoreFoundation, isomorphicCoreUncleus, coreQuark, coreSingularity,
                    shelf, shelfSilicide, containerSilicide, warpDisc, bank, bankSilicide, warpBase,
                    lamp, lampAlarm, advancedLaunchPad, advancedLandingPad, isomorphicAcceleratorSmall, isomorphicAccelerator,

            //effect - maress, sitrullus
            nuke, coreGeneral, tradePortal, sporeBomb,

            //effect - Special
            coreHolder, gammaBlock, coreThurium,

            //logic
            isomorphicMessage, isomorphicSwitch, isomorphicProcessor, isomorphicMemory,
                    quantumProcessor, quantumMemoryCell,

            //sandbox
            silicideItemSource, silicideItemVoid,
                    silicideFluidSource, silicideFluidVoid,
                    mapPowerSource,
                    sweeper, sandboxBlast, pogMender, pogOverdriver, forceSource,

            //test
            testTurret, testTurret2, testTurret3,
                    testChainBurst, testChainDrill,
                    bridge3,testInstantConvey, testUnloader,
                    spepipe, testChainPump,
                    testBeam,
                    testBoulder, testWall, testShieldWall, twoBillionWall,
                    testOmegaSpawn, testRequireChange, testSectordestroyer, test4spawn, testrec,
                    testDirectionalShield, testDisplayStorage, testAccelerator,
                    coreNucleusRoot, coreNuleusRootSitrullus, coreSingularityRoot, teamProjectorCrux, isomorphicAcceleratorCrux, coreSingularityCrux, coreBoss, coreGeneralStg, coreGeneralFungikiller;

    public static void load() {

        accessibleDeepWater = new Floor("accessible-deep-water", 0) {{
            speedMultiplier = 0.2f;
            drownTime = 0f;
            status = StatusEffects.wet;
            statusDuration = 120f;
            isLiquid = true;
            supportsOverlay = true;
            liquidDrop = Liquids.water;
            liquidMultiplier = 1.5f;
            mapColor = Color.valueOf("3d4980");
            cacheLayer = CacheLayer.water;
            hasColor = true;
            albedo = 0.9f;
            useColor = false;
        }};

        deepWaterOil = new Floor("deep-water-oil", 0) {{
            speedMultiplier = 0.2f;
            drownTime = 200f;
            status = StatusEffects.wet;
            statusDuration = 120f;
            isLiquid = true;
            supportsOverlay = true;
            liquidDrop = Liquids.water;
            attributes.set(Attribute.oil ,2);
            cacheLayer = CacheLayer.water;
            albedo = 0.9f;
        }};

        flowingLava = new Floor("flowing-lava") {{
            speedMultiplier = 0.3f;
            drownTime = 600f;
            status = VeStatusEffects.fusing;
            isLiquid = true;
            liquidDrop = VeLiquids.lava;
            liquidMultiplier = 0.5f;
            attributes.set(Attribute.heat, 0.9f);
            blendGroup = Blocks.basalt;
            cacheLayer = CacheLayer.water;
            lightColor = Color.valueOf("df171744");
            emitLight = true;
            lightRadius = 35f;
        }};

        antigrass = new Floor("antigrass") {{
            attributes.set(Attribute.water, -0.1f);
        }};

        semigrass = new Floor("semigrass") {{
            attributes.set(VanillaExpansion.plant, 0.5f);
        }};

        gravel = new Floor("gravel", 5) {{
            itemDrop = Items.sand;
            playerUnmineable = true;
            attributes.set(Attribute.water, -0.1f);
        }};

        carbonShale = new Floor("carbon-shale") {{
            itemDrop = VeItems.carbonShaleCobble;
            playerUnmineable = true;
            attributes.set(Attribute.oil, 2f);
            attributes.set(VanillaExpansion.plant, 1f);
        }};

        hillStone = new Floor("hill-stone", 4) {{
            attributes.set(Attribute.water, 0.1f);
        }};

        saltyIce = new Floor("salty-ice") {{
            speedMultiplier = 0.9f;
            dragMultiplier = 0.35f;
            itemDrop = VeItems.salt;
            playerUnmineable = true;
            attributes.set(Attribute.water, 0.3f);
            albedo = 0.5f;
        }};

        deepslate = new Floor("deepslate", 8);

        deepslateBrick = new Floor("deepslate-brick", 8);

        coreZoneCyclant = new Floor("core-zone-cyclant", 0) {{
            allowCorePlacement = true;
            attributes.set(Attribute.water, -1f);
            blendGroup = this;
        }};

        metalTiles13ve = new Floor("metal-tiles-13ve", 0) {{
            autotile = true;
            drawEdgeIn = false;
            drawEdgeOut = false;
        }};

        metalTiles14ve = new Floor("metal-tiles-14ve", 0) {{
            autotile = true;
            drawEdgeIn = false;
            drawEdgeOut = false;
        }};

        metalTiles15ve = new Floor("metal-tiles-15ve", 0) {{
            autotile = true;
            drawEdgeIn = false;
            drawEdgeOut = false;
        }};

        metalTiles16ve = new Floor("metal-tiles-16ve", 0) {{
            autotile = true;
            drawEdgeIn = false;
            drawEdgeOut = false;
        }};

        antigrassWall = new StaticWall("antigrass-wall") {{
            antigrass.asFloor().wall = this;
        }};

        semigrassWall = new StaticWall("semigrass-wall") {{
            semigrass.asFloor().wall = this;
        }};

        carbonShaleWall = new StaticWall("carbon-shale-wall") {{
            carbonShale.asFloor().wall = this;
        }};

        hillStoneWall = new StaticWall("hill-stone-wall") {{
            hillStone.asFloor().wall = this;
        }};

        deepslateWall = new StaticWall("deepslate-wall") {{
            variants = 4;
        }};

        deepslateBrickWall = new StaticWall("deepslate-brick-wall") {{
            variants = 5;
        }};

        darkMetalRepaired = new StaticWall("dark-metal-repaired") {{
            variants = 4;
        }};

        carbonShaleBoulder = new Prop("carbon-shale-boulder") {{
            variants = 2;
            carbonShale.asFloor().decoration = this;
        }};

        hillStoneBoulder = new Prop("hill-stone-boulder") {{
            variants = 2;
            hillStone.asFloor().decoration = this;
        }};

        redSoilFloor = new Floor("red-soil-floor", 4) {{
            itemDrop = VeItems.redSoil;
            playerUnmineable = true;
            // "decoration": "red-soil-boulder",
        }};

        redSoilFinely = new Floor("red-soil-finely", 5) {{
            speedMultiplier = 0.9f;
            status = VeStatusEffects.dusty;
            statusDuration = 600f;
            itemDrop = VeItems.redSoil;
            playerUnmineable = true;
            attributes.set(Attribute.water, -0.25f);
            //"decoration": "red-soil-boulder",
        }};

        redSoilPebble = new Floor("red-soil-pebble", 5) {{
            speedMultiplier = 0.7f;
            status = VeStatusEffects.dusty;
            statusDuration = 600f;
            attributes.set(Attribute.water, -0.25f);
            //"decoration": "red-soil-boulder",
        }};

        redSoilWet = new Floor("red-soil-wet", 4) {{
            status = StatusEffects.muddy;
            statusDuration = 30f;
            itemDrop = VeItems.redSoil;
            playerUnmineable = true;
            attributes.set(Attribute.water, 0.5f);
            //"decoration": "red-soil-boulder",
        }};

        ferricShale = new Floor("ferric-shale") {{
            itemDrop = VeItems.ferricShaleCobble;
            playerUnmineable = true;
            attributes.set(Attribute.water, -0.5f);
        }};

        redSoilWall = new StaticWall("red-soil-wall") {{
            redSoilFloor.asFloor().wall =redSoilFinely.asFloor().wall =  redSoilPebble.asFloor().wall = this;
        }};

        redSoilWetWall = new StaticWall("red-soil-wet-wall") {{
            redSoilWet.asFloor().wall = this;
        }};

        ferricShaleWall = new StaticWall("ferric-shale-wall") {{
            ferricShale.asFloor().wall = this;
        }};

        mirmat = new WobbleProp("mirmat") {{
            requirements(Category.distribution, BuildVisibility.sandboxOnly, ItemStack.with(VeItems.reflectorMatter, 10));
            wscl = 30f;
            wmag = 0.2f;
            variants = 5;
            customShadow = true;
            albedo = 1f;
            alwaysUnlocked = true;
        }};

        ferricShaleBoulder = new Prop("ferric-shale-boulder") {{
            variants = 2;
            ferricShale.asFloor().decoration = this;
        }};

        silvelade = new TreeBlock("silvelade") {{
            shadowOffset = -5.5f;
            variants = 3;
            customShadow = true;
            albedo = 1f;
        }};

        silveladeLarge = new TreeBlock("silvelade-large") {{
            shadowOffset = -8.5f;
            variants = 0;
            customShadow = true;
            albedo = 1f;
        }};

        melonwaterDeep = new Floor("melonwater-deep", 0) {{
            speedMultiplier = 0.2f;
            drownTime = 600f;
            status = StatusEffects.wet;
            statusDuration = 120f;
            isLiquid = true;
            supportsOverlay = true;
            liquidDrop = VeLiquids.melonWater;
            liquidMultiplier = 1.5f;
            attributes.set(Attribute.spores, 3f);
            cacheLayer = CacheLayer.water;
            mapColor = Color.valueOf("bb2626");
            hasColor = true;
            albedo = 0.9f;
            useColor = false;
        }};

        melonwater = new Floor("melonwater", 0) {{
            speedMultiplier = 0.6f;
            drownTime = 0f; // -
            status = StatusEffects.wet;
            statusDuration = 120f;
            isLiquid = true;
            supportsOverlay = true;
            shallow = true; // +
            liquidDrop = VeLiquids.melonWater;
            liquidMultiplier = 1f; // -
            attributes.set(Attribute.spores, 3f);
            cacheLayer = CacheLayer.water;
            mapColor = Color.valueOf("cc3434");
            hasColor = true;
            albedo = 0.9f;
            useColor = false;
        }};

        melondirt = new Floor("melondirt", 6) {{
            itemDrop = VeItems.melonDirt;
            playerUnmineable = true;
            attributes.set(Attribute.spores, 2f);
            attributes.set(Attribute.water, 3f);
            attributes.set(Attribute.steam, 1f);
            mapColor = Color.valueOf("e44646");
            hasColor = true;
            useColor = false;
        }};

        /*
        melondirtWater = new Floor("melondirt-water", 6) {{
            speedMultiplier = 0.8f;
            drownTime = 0f; // -
            status = StatusEffects.wet;
            statusDuration = 120f;
            isLiquid = true;
            supportsOverlay = true;
            liquidDrop = VeLiquids.melonWater;
            liquidMultiplier = 1f; // -
            itemDrop = VeItems.melonDirt;
            playerUnmineable = true;
            attributes.set(Attribute.spores, 2.5f);
            cacheLayer = CacheLayer.water;
            mapColor = Color.valueOf("da3939");
            hasColor = true;
            albedo = 0.9f;
            useColor = false;
        }};
        */

        melondirtWater = new ShallowLiquid("melondirt-water") {{
            liquidBase = (Floor)melonwater; // 液体基础
            floorBase = (Floor)melondirt; // 地板基础
            speedMultiplier = 0.8f;
            drownTime = 0f; // -
            status = StatusEffects.wet;
            statusDuration = 120f;
            isLiquid = true;
            supportsOverlay = true;
            liquidDrop = VeLiquids.melonWater;
            liquidMultiplier = 1f; // -
            itemDrop = VeItems.melonDirt;
            playerUnmineable = true;
            attributes.set(Attribute.spores, 2.5f);
            variants = 6;
            cacheLayer = CacheLayer.water;
            mapColor = Color.valueOf("da3939");
            hasColor = true;
            albedo = 0.9f;
            useColor = false;
        }};

        melondirtWhite = new Floor("melondirt-white", 6) {{
            attributes.set(Attribute.spores, 1f);
            attributes.set(Attribute.water, 1.5f);
            attributes.set(Attribute.steam, 0.5f);
            mapColor = Color.valueOf("dcc6c6");
            hasColor = true;
            useColor = false;

        }};

        melonShell = new Floor("melon-shell", 6) {{
            dragMultiplier = 0.9f;
            attributes.set(Attribute.spores, 0f);
            attributes.set(Attribute.water, 1f);
            attributes.set(Attribute.steam, 0.25f);
            mapColor = Color.valueOf("70ae4c");
            hasColor = true;
            albedo = 0.3f;
            useColor = false;
        }};

        melonShellDark = new Floor("melon-shell-dark", 0) {{
            dragMultiplier = 0.9f;
            attributes.set(Attribute.spores, 0f);
            attributes.set(Attribute.water, 1f);
            attributes.set(Attribute.steam, 0.25f);
            mapColor = Color.valueOf("284417");
            hasColor = true;
            albedo = 0.3f;
            useColor = false;
        }};

        sporeMelonwaterDeep = new Floor("spore-melonwater-deep") {{
            speedMultiplier = 0.1f;
            drownTime = 600f;
            status = StatusEffects.wet;
            statusDuration = 120f;
            isLiquid = true;
            supportsOverlay = true;
            liquidDrop = Liquids.water;
            liquidMultiplier = 1.5f;
            attributes.set(Attribute.spores, 2f);
            cacheLayer = CacheLayer.water;
        }};

        sporeMelonwater = new Floor("spore-melonwater") {{
            speedMultiplier = 0.4f;
            drownTime = 0f; // -
            status = StatusEffects.wet;
            statusDuration = 120f;
            isLiquid = true;
            supportsOverlay = true;
            shallow = true; // +
            liquidDrop = Liquids.water;
            liquidMultiplier = 1f; // -
            attributes.set(Attribute.spores, 2f);
            attributes.set(Attribute.steam, -9.99f);
            cacheLayer = CacheLayer.water;
        }};

        sporeMelondirt = new Floor("spore-melondirt", 8) {{
            attributes.set(Attribute.spores, 1.5f);
            attributes.set(Attribute.steam, -9.99f);
        }};

        sporeMelondirtMoss = new Floor("spore-melondirt-moss", 8) {{
            itemDrop = Items.sporePod;
            attributes.set(Attribute.spores, 2.5f);
            attributes.set(Attribute.steam, -9.99f);
        }};

        melondirtWall = new StaticWall("melondirt-wall") {{
            variants = 3;
            mapColor = Color.valueOf("ff5555");
            hasColor = true;
            useColor = false;
            melondirt.asFloor().wall = this;
        }};

        sporeMelondirtWall = new StaticWall("spore-melondirt-wall") {{
            variants = 3;
            // sporeMelondirt.asFloor().wall = sporeMelondirtMoss.asFloor().wall = this;
        }};

        orePyratite = new OreBlock("ore-pyratite", Items.pyratite);

        oreAluminium = new OreBlock("ore-aluminium", VeItems.aluminium);

        oreChromium = new OreBlock("ore-chromium", VeItems.chromium);

        oreCobalt = new OreBlock("ore-cobalt", VeItems.cobalt);

        oreFerrum = new OreBlock("ore-ferrum", VeItems.ferrum) {{
            variants = 4;
        }};

        oreSilver = new OreBlock("ore-silver", VeItems.silver) {{
            variants = 6;
        }};

        oreSilverPure = new OreBlock("ore-silver-pure", VeItems.silver) {{
            variants = 5;
        }};

        oreTantalum = new OreBlock("ore-tantalum", VeItems.tantalum) {{
            variants = 4;
        }};

        oreWallAluminium = new OreBlock("ore-wall-aluminium", VeItems.aluminium) {{
            wallOre = true;
        }};

        oreWallQuartz = new OreBlock("ore-wall-quartz", VeItems.quartz) {{
            wallOre = true;
        }};

        oreCatalyzon = new OreBlock("ore-catalyzon", VeItems.catalyzon) {{
            variants = 0;
        }};

        redGround = new Floor("red-ground", 1) {{
            allowCorePlacement = true;
        }};

        greenGround = new Floor("green-ground", 1) {{
            allowCorePlacement = true;
        }};

        blueGround = new Floor("blue-ground", 1) {{
            allowCorePlacement = true;
        }};

        whiteGround = new Floor("white-ground", 1) {{
            canShadow = false;
            allowCorePlacement = true;
        }};

        darkGround = new Floor("dark-ground", 1);

        pureDark = new StaticWall("pure-dark") {{
            variants = 0;
        }};


        click = new ItemTurret("click") {{
            requirements(Category.turret, ItemStack.with(VeItems.aluminium, 40));
            ammo(
                    Items.graphite, new BasicBulletType(4f, 19f) {{
                        width = 11f;
                        height = 13f;
                        lifetime = 50f;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        ammoMultiplier = 4f;
                        hitColor = frontColor = Color.valueOf("dae1ee");
                        backColor = Color.valueOf("7d89d8");
                    }},
                    Items.silicon, new BasicBulletType(4f, 15f) {{
                        width = 9f;
                        height = 11f;
                        lifetime = 60f;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        ammoMultiplier = 5f;
                        reloadMultiplier = 1.5f;
                        rangeChange = 40f;
                        hitColor = frontColor = Color.valueOf("999ba0");
                        backColor = trailColor = Color.valueOf("707594");
                        trailLength = 3;
                        homingPower = 0.15f;
                    }},
                    VeItems.aluminium, new BasicBulletType(4f, 9f) {{
                        width = 9f;
                        height = 11f;
                        lifetime = 50f;
                    }},
                    VeItems.quartz, new BasicBulletType(5f, 13f) {{
                        width = 8f;
                        height = 13f;
                        pierce = true;
                        pierceBuilding = false;
                        pierceCap = 4;
                        hitEffect = despawnEffect = Fx.hitSquaresColor;
                        hitColor = backColor = Color.valueOf("f68021");
                    }},
                    VeItems.ferrum, new BasicBulletType(3.5f, 20f) {{
                        width = 10f;
                        height = 12f;
                        shrinkY = 0f;
                        lifetime = 57f;
                        hitEffect = Fx.flakExplosion;
                        despawnEffect = Fx.hitBulletColor;
                        ammoMultiplier = 3f;
                        setDefaults = false;
                        hitColor = frontColor = Color.valueOf("9f8c88");
                        backColor = Color.valueOf("7e6863");
                        despawnHit = true;
                        splashDamage = 8f;
                        splashDamageRadius = 12f;
                        fragRandomSpread = 30f;
                        fragBullets = 2;
                        fragVelocityMin = 0.5f;
                        fragLifeMin = 0f;
                        fragOffsetMax = 1f;
                        fragBullet = new BasicBulletType(3.5f, 4f) {{
                            width = 7f;
                            height = 9f;
                            shrinkY = 0f;
                            spin = 10f;
                            lifetime = 30f;
                            pierce = true;
                            pierceBuilding = false;
                            pierceCap = 3;
                            hitEffect = despawnEffect = Fx.hitBulletColor;
                            pierceArmor = true;
                            hitColor = frontColor = Color.valueOf("9f8c88");
                            backColor = Color.valueOf("7e6863");
                        }};
                    }}
            );
            inaccuracy = 2f;
            shootX = 0f;
            shootY = 3f;
            ammoUseEffect = Fx.casing1;
            recoil = 0.7f;
            reload = 18f;
            range = 200f;
            rotateSpeed = 15f;
            coolant = consumeCoolant(0.1f);
            health = 220;
            researchCostMultiplier = 0.15f;
            // shownPlanets.addAll(VePlanets.cyclant, VePlanets.maress);
        }};

        frag = new ItemTurret("frag") {{
            requirements(Category.turret, ItemStack.with(Items.lead, 45, VeItems.aluminium, 30));
            ammo(
                    Items.lead, new BasicBulletType(0f, 0f) {{
                        lifetime = 1f;
                        despawnEffect = Fx.none;
                        shootEffect = Fx.colorSpark;
                        reloadMultiplier = 1.1f;
                        collides = false;
                        hitColor = Color.valueOf("f8ad42");
                        fragRandomSpread = 20f;
                        fragBullets = 4;
                        fragVelocityMin = 0.8f;
                        fragLifeMin = 0.7f;
                        fragBullet = new FlakBulletType(4.2f, 3f) {{
                            height = 8f;
                            lifetime = 50f;
                            hitEffect = Fx.flakExplosion;
                            splashDamage = 37;
                            splashDamageRadius = 15f;
                        }};
                    }},
                    Items.metaglass, new BasicBulletType(0f, 0f) {{
                        lifetime = 1f;
                        despawnEffect = Fx.none;
                        shootEffect = Fx.colorSpark;
                        ammoMultiplier = 5f;
                        reloadMultiplier = 0.8f;
                        collides = false;
                        hitColor = Color.valueOf("f8ad42");
                        fragRandomSpread = 20f;
                        fragBullets = 4;
                        fragVelocityMin = 0.8f;
                        fragLifeMin = 0.7f;
                        fragBullet = new FlakBulletType(4.2f, 3f) {{
                            height = 8f;
                            lifetime = 50f;
                            hitEffect = Fx.flakExplosion;
                            splashDamage = 42;
                            splashDamageRadius = 20f;
                            fragBullets = 6;
                            fragBullet = new BasicBulletType(3f, 5f) {{
                                shrinkY = 1f;
                                lifetime = 20f;
                                despawnEffect = Fx.none;
                                collidesTiles = false;
                                collidesGround = false;
                                backColor = Color.valueOf("b9c9df");
                                frontColor = Color.valueOf("ffffff");
                            }};
                        }};
                    }},
                    Items.scrap, new BasicBulletType(0f, 0f) { {
                        lifetime = 1f;
                        despawnEffect = Fx.none;
                        shootEffect = Fx.colorSpark;
                        ammoMultiplier = 5f;
                        reloadMultiplier = 0.8f;
                        collides = false;
                        hitColor = Color.valueOf("f8ad42");
                        fragRandomSpread = 20f;
                        fragBullets = 4;
                        fragVelocityMin = 0.8f;
                        fragLifeMin = 0.7f;
                        fragBullet = new FlakBulletType(4f, 3f) {{
                            height = 8f;
                            lifetime = 50f;
                            hitEffect = Fx.flakExplosion;
                            backColor = Color.valueOf("d8887e");
                            frontColor = Color.valueOf("f5e0cc");
                            splashDamage = 33;
                            splashDamageRadius = 24f;
                        }};
                    }},
                    VeItems.ferrum, new BasicBulletType(0f, 0f) {{
                        lifetime = 1f;
                        despawnEffect = Fx.none;
                        shootEffect = Fx.colorSpark;
                        ammoMultiplier = 3f;
                        reloadMultiplier = 1.7f;
                        collides = false;
                        hitColor = Color.valueOf("9f8c88");
                        fragRandomSpread = 20f;
                        fragBullets = 4;
                        fragVelocityMin = 0.8f;
                        fragLifeMin = 0.7f;
                        fragBullet = new FlakBulletType(4.2f, 5f) {{
                            width = 10f;
                            height = 10f;
                            shrinkY = 0f;
                            lifetime = 50f;
                            hitEffect = Fx.flakExplosion;
                            despawnEffect = Fx.hitBulletColor;
                            collidesTiles = false;
                            setDefaults = false;
                            hitColor = frontColor = Color.valueOf("9f8c88");
                            backColor = Color.valueOf("7e6863");
                            despawnHit = true;
                            splashDamage = 32f;
                            splashDamageRadius = 16f;
                            fragRandomSpread = 30f;
                            fragBullets = 2;
                            fragVelocityMin = 0.5f;
                            fragLifeMin = 0f;
                            fragOffsetMax = 1f;
                            fragBullet = new BasicBulletType(4.2f, 8f) {{
                                width = 6f;
                                height = 9f;
                                shrinkY = 0f;
                                spin = 10f;
                                lifetime = 30f;
                                pierce = true;
                                pierceBuilding = false;
                                pierceCap = 3;
                                hitEffect = despawnEffect = Fx.hitBulletColor;
                                collidesTiles = false;
                                collidesGround = false;
                                pierceArmor = true;
                                hitColor = frontColor = Color.valueOf("9f8c88");
                                backColor = Color.valueOf("7e6863");
                            }};
                        }};
                    }}
            );
            inaccuracy = 3f;
            shootX = 0f;
            shootY = 1.25f;
            targetGround = false;
            ammoUseEffect = Fx.casing3;
            // shootSound = Sounds.shootAltClassic;
            recoil = 2f;
            reload = 65f;
            range = 210f;
            rotateSpeed = 22f;
            coolant = consumeCoolant(0.1f);
            health = 320;
            researchCostMultiplier = 0.15f;
        }};

        pulse = new PowerTurret("pulse") {{
            requirements(Category.turret, ItemStack.with(Items.lead, 50, Items.silicon, 25, VeItems.aluminium, 55));
            consumePower(3.2f);
            shootType = new BasicBulletType(1.8f, 25f) {{
                width = 7f;
                shrinkX = -0.2f;
                shrinkY = -0.2f;
                sprite = "circle-bullet";
                lifetime = 49f;
                drag = -0.02f;
                hitEffect = new MultiEffect(
                        new ExplosionEffect() {{
                            waveColor = sparkColor = Color.valueOf("8aa3f4");
                            waveRad = 18f;
                        }},
                        new ParticleEffect() {{
                            particles = 9;
                            sizeFrom = 3f;
                            colorFrom = Color.valueOf("ffffff");
                            colorTo = Color.valueOf("8aa3f4");
                            lifetime = 15f;
                        }}
                );
                shootEffect = Fx.shootBigColor;
                smokeEffect = Fx.none;
                // despawnSound = Sounds.spark;
                status = StatusEffects.shocked;
                statusDuration = 10f;
                hittable = false;
                despawnShake = 1f;
                hitColor = Color.valueOf("8aa3f4");
                trailColor = backColor = Color.valueOf("8aa3f4");
                frontColor = Color.valueOf("ffffff");
                trailInterval = 5f;
                fragBullets = 4;
                fragBullet = new LightningBulletType() {{
                    speed = 5f;
                    damage = 9f;
                    drag = 0.1f;
                    statusDuration = 10f;
                    lightningColor = Color.valueOf("8aa3f4");
                    lightningLength = 5;
                    lightningLengthRand = 4;
                }};
                bulletInterval = 4f;
                intervalBullet = new LightningBulletType() {{
                    damage = 9f;
                    statusDuration = 10f;
                    collidesAir = false;
                    lightningColor = Color.valueOf("8aa3f4");
                    lightningLength = 3;
                    lightningLengthRand = 2;
                }};
            }};
            shootY = 3f;
            shootSound = Sounds.shootLocus;
            reload = 58f;
            range = 144f;
            rotateSpeed = 20f;
            coolant = consumeCoolant(0.1f);
            coolantMultiplier = 8f;
            health = 280;
            researchCostMultiplier = 0.04f;
        }};

        rise = new ItemTurret("rise") {{
            requirements(Category.turret, ItemStack.with(Items.graphite, 30, VeItems.aluminium, 45));
            ammo(
                    Items.graphite, new BasicBulletType(1.5f, 25f) {{
                        width = 9f;
                        height = 9f;
                        shrinkY = 0f;
                        sprite = "missile";
                        lifetime = 65f;
                        drag = -0.025f;
                        hitEffect = despawnEffect = Fx.flakExplosion;
                        hitSound = despawnSound = Sounds.explosion;
                        collidesAir = false;
                        frontColor = Color.valueOf("dae1ee");
                        backColor = Color.valueOf("7d89d8");
                        splashDamage = 40f;
                        splashDamageRadius = 20f;
                        trailInterval = 6f;
                        homingPower = 0.15f;
                    }},
                    Items.silicon, new BasicBulletType(1.5f, 25f) {{
                        width = 9f;
                        height = 9f;
                        shrinkY = 0f;
                        sprite = "missile";
                        lifetime = 65f;
                        drag = -0.025f;
                        hitEffect = despawnEffect = Fx.flakExplosion;
                        hitSound = despawnSound = Sounds.explosion;
                        ammoMultiplier = 3f;
                        reloadMultiplier = 1.2f;
                        collidesAir = false;
                        backColor = Color.valueOf("b2c6d2");
                        splashDamage = 40f;
                        splashDamageRadius = 20f;
                        trailInterval = 6f;
                        homingPower = 0.3f;
                        homingRange = 80f;
                    }},
                    Items.pyratite, new BasicBulletType(1.5f, 32f) {{
                        width = 9f;
                        height = 9f;
                        shrinkY = 0f;
                        sprite = "missile";
                        lifetime = 65f;
                        drag = -0.025f;
                        hitEffect = despawnEffect = Fx.blastExplosion;
                        hitSound = despawnSound = Sounds.explosion;
                        ammoMultiplier = 4f;
                        status = StatusEffects.burning;
                        statusDuration = 240f;
                        collidesAir = false;
                        makeFire = true;
                        backColor = Color.valueOf("f8ad42");
                        trailColor = frontColor = Color.valueOf("f8e096");
                        splashDamage = 55f;
                        splashDamageRadius = 20f;
                        trailInterval = 4f;
                        homingPower = 0.15f;
                    }},
                    VeItems.ferrum, new BasicBulletType(1.5f, 20f) {{
                        width = 10f;
                        height = 10f;
                        shrinkY = 0f;
                        sprite = "missile";
                        lifetime = 65f;
                        drag = -0.025f;
                        hitEffect = Fx.flakExplosion;
                        despawnEffect = Fx.hitBulletColor;
                        hitSound = despawnSound = Sounds.explosion;
                        collidesAir = false;
                        setDefaults = false;
                        hitColor = frontColor = Color.valueOf("9f8c88");
                        trailColor = backColor = Color.valueOf("7e6863");
                        trailInterval = 6f;
                        homingPower = 0.15f;
                        despawnHit = true;
                        splashDamage = 35f;
                        splashDamageRadius = 24f;
                        fragRandomSpread = 40f;
                        fragBullets = 4;
                        fragVelocityMin = 0.5f;
                        fragLifeMin = 0f;
                        fragOffsetMax = 1f;
                        fragBullet = new BasicBulletType(4f, 6f) {{
                            width = 7f;
                            height = 9f;
                            shrinkY = 0f;
                            spin = 10f;
                            lifetime = 30f;
                            pierce = true;
                            pierceBuilding = false;
                            pierceCap = 3;
                            hitEffect = despawnEffect = Fx.hitBulletColor;
                            collidesAir = false;
                            pierceArmor = true;
                            hitColor = frontColor = Color.valueOf("9f8c88");
                            backColor = Color.valueOf("7e6863");
                        }};
                    }}
            );
            shootY = 3.25f;
            targetAir = false;
            predictTarget = false;
            ammoUseEffect = Fx.casing3;
            shootSound = Sounds.shootMissile;
            recoil = 1.2f;
            reload = 50f;
            range = 240f;
            rotateSpeed = 7.5f;
            coolant = consumeCoolant(0.1f);
            health = 350;
            researchCostMultiplier = 0.35f;
        }};

        bake = new ItemTurret("bake") {{
            requirements(Category.turret, ItemStack.with(Items.graphite, 25, VeItems.aluminium, 35));
            ammo(
                    Items.coal, new BasicBulletType(3.25f, 17f) {{
                        lifetime = 18f;
                        hitSize = 7f;
                        pierce = true;
                        hitEffect = Fx.hitFlameSmall;
                        shootEffect = Fx.shootSmallFlame;
                        despawnEffect = smokeEffect = Fx.none;
                        ammoMultiplier = 3f;
                        status = StatusEffects.burning;
                        statusDuration = 240f;
                        collidesAir = false;
                        keepVelocity = false;
                        hittable = false;
                        backColor = frontColor = Color.valueOf("ffffff00");
                    }},
                    Items.pyratite, new BasicBulletType(4f, 60f) {{
                        lifetime = 18f;
                        hitSize = 7f;
                        pierce = true;
                        hitEffect = Fx.hitFlameSmall;
                        shootEffect = Fx.shootPyraFlame;
                        despawnEffect = smokeEffect = Fx.none;
                        ammoMultiplier = 6f;
                        status = StatusEffects.burning;
                        statusDuration = 600f;
                        collidesAir = false;
                        keepVelocity = false;
                        hittable = false;
                        backColor = frontColor = Color.valueOf("ffffff00");
                    }},
                    VeItems.nitroalkoss, new BasicBulletType(4f, 107f) {{
                        lifetime = 24f;
                        hitSize = 12f;
                        pierce = true;
                        hitEffect = Fx.hitFlameSmall;
                        despawnEffect = smokeEffect = Fx.none;
                        shootEffect = new MultiEffect(
                                Fx.shootSmallFlame,
                                Fx.shootPyraFlame
                        );
                        ammoMultiplier = 12f;
                        // status = StatusEffects.combusting;
                        statusDuration = 900f;
                        collidesAir = false;
                        keepVelocity = false;
                        hittable = false;
                        pierceArmor = true;
                        backColor = frontColor = Color.valueOf("ffffff00");
                    }}
            );
            shootY = 2f;
            targetAir = false;
            ammoUseEffect = Fx.none;
            shootSound = Sounds.shootFlame;
            recoil = 0f;
            reload = 5f;
            range = 60f;
            rotateSpeed = 10f;
            coolantMultiplier = 1.5f;
            coolant = consumeCoolant(0.1f);
            health = 400;
            researchCostMultiplier = 0.35f;
        }};

        waterer = new LiquidTurret("waterer") {{
            requirements(Category.turret, ItemStack.with(Items.metaglass, 25, VeItems.aluminium, 25));
            ammo(
                    Liquids.water, new LiquidBulletType(Liquids.water) {{
                        puddleSize = 4f;
                        orbSize = 2f;
                        drag = 0.01f;
                        layer = Layer.bullet - 2f;
                        knockback = 0.4f;
                        // status = StatusEffects.wet;
                        statusDuration = 90f;
                    }},
                    Liquids.oil, new LiquidBulletType(Liquids.oil) {{
                        puddleSize = 4f;
                        orbSize = 2f;
                        drag = 0.01f;
                        layer = Layer.bullet - 2f;
                        ammoMultiplier = 3f;
                        knockback = 0.4f;
                        // status = StatusEffects.tarred;
                        statusDuration = 90f;
                    }},
                    Liquids.cryofluid, new LiquidBulletType(Liquids.cryofluid) {{
                        puddleSize = 4f;
                        orbSize = 2f;
                        drag = 0.01f;
                        ammoMultiplier = 3f;
                        knockback = 0.4f;
                        // status = StatusEffects.freezing;
                        statusDuration = 90f;
                    }}
            );
            inaccuracy = 5f;
            shootCone = 50f;
            shootY = 3.25f;
            liquidCapacity = 15f;
            shoot.shots = 3;
            shoot.shotDelay = 2f;
            shootSound = Sounds.none;
            recoil = 0f;
            reload = 6f;
            range = 110f;
            rotateSpeed = 20f;
            health = 300;
            researchCostMultiplier = 0.1f;
        }};

        beat = new ItemTurret("beat") {{
            requirements(Category.turret, ItemStack.with(Items.silicon, 50, VeItems.aluminium, 75, VeItems.silicide, 30));
            ammo(
                    Items.graphite, new BasicBulletType(4f, 22f) {{
                        width = 11f;
                        height = 13f;
                        lifetime = 50f;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        ammoMultiplier = 5f;
                        hitColor = frontColor = Color.valueOf("dae1ee");
                        backColor = Color.valueOf("7d89d8");
                    }},
                    Items.silicon, new BasicBulletType(4f, 17f) {{
                        width = 9f;
                        height = 11f;
                        lifetime = 60f;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        ammoMultiplier = 6f;
                        reloadMultiplier = 1.4f;
                        rangeChange = 40f;
                        hitColor = frontColor = Color.valueOf("999ba0");
                        trailColor = backColor = Color.valueOf("707594");
                        trailLength = 4;
                        homingPower = 0.15f;
                    }},
                    Items.pyratite, new BasicBulletType(4f, 20f) {{
                        width = 10f;
                        height = 12f;
                        lifetime = 50f;
                        hitEffect = new MultiEffect(
                                Fx.hitBulletSmall,
                                Fx.fireHit
                        );
                        ammoMultiplier = 6f;
                        status = StatusEffects.burning;
                        makeFire = true;
                        frontColor = Color.valueOf("f8e096");
                        backColor = Color.valueOf("f8ad42");
                        splashDamage = 12f;
                        splashDamageRadius = 22f;
                    }},
                    VeItems.aluminium, new BasicBulletType(4f, 11f) {{
                        width = 9f;
                        height = 11f;
                        lifetime = 50f;
                        ammoMultiplier = 3f;
                    }},
                    VeItems.quartz, new BasicBulletType(5f, 16f) {{
                        width = 8f;
                        height = 13f;
                        pierce = true;
                        pierceBuilding = false;
                        pierceCap = 4;
                        pierceDamageFactor = 0.75f;
                        ammoMultiplier = 4f;
                        hitEffect = despawnEffect = Fx.hitSquaresColor;
                        hitColor = backColor = Color.valueOf("f68021");
                    }},
                    VeItems.silicide, new BasicBulletType(5f, 28f) {{
                        width = 10f;
                        height = 12f;
                        lifetime = 50f;
                        hitEffect = new MultiEffect(
                                new WaveEffect() {{
                                    colorFrom = colorTo = lightColor = Color.valueOf("565666ff");
                                    sizeTo = 12f;
                                    strokeFrom = 6f;
                                    strokeTo = 4f;
                                    lifetime = 7f;
                                }},
                                new WaveEffect() {{
                                    colorFrom = colorTo = lightColor = Color.valueOf("565666ff");
                                    sizeTo = 16f;
                                    strokeFrom = 5f;
                                    strokeTo = 3f;
                                    lifetime = 5f;
                                }}
                        );
                        ammoMultiplier = 7f;
                        reloadMultiplier = 1.1f;
                        knockback = 2.1f;
                        hittable = false;
                        rangeChange = 50f;
                        despawnHit = true;
                        splashDamage = 10f;
                        splashDamageRadius = 14f;
                    }},
                    VeItems.chromium, new BasicBulletType(4f, 26f) {{
                        width = 9f;
                        height = 15f;
                        shrinkY = 0f;
                        spin = 10f;
                        lifetime = 50f;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        ammoMultiplier = 4f;
                        shieldDamageMultiplier = 4f;
                        pierceArmor = true;
                        hitColor = backColor = Color.valueOf("ff6b41");
                    }},
                    VeItems.ferrum, new BasicBulletType(3.5f, 24f) {{
                        width = 10f;
                        height = 12f;
                        shrinkY = 0f;
                        lifetime = 57f;
                        hitEffect = Fx.flakExplosion;
                        despawnEffect = Fx.hitBulletColor;
                        ammoMultiplier = 4f;
                        setDefaults = false;
                        hitColor = frontColor = Color.valueOf("9f8c88");
                        backColor = Color.valueOf("7e6863");
                        despawnHit = true;
                        splashDamage = 9f;
                        splashDamageRadius = 14f;
                        fragRandomSpread = 30f;
                        fragBullets = 3;
                        fragVelocityMin = 0.5f;
                        fragLifeMin = 0f;
                        fragOffsetMax = 1f;
                        fragBullet = new BasicBulletType(3.5f, 5f) {{
                            width = 7f;
                            height = 9f;
                            shrinkY = 0f;
                            spin = 10f;
                            lifetime = 30f;
                            pierce = true;
                            pierceBuilding = false;
                            pierceCap = 3;
                            hitEffect = despawnEffect = Fx.hitBulletColor;
                            pierceArmor = true;
                            hitColor = frontColor = Color.valueOf("9f8c88");
                            backColor = Color.valueOf("7e6863");
                        }};
                    }}
            );
            inaccuracy = 1f;
            shootY = 0f;
            warmupMaintainTime = 30f;
            shoot = new ShootBarrel() {{
                barrels = new float[]{
                        1.75f, 5.5f, 0,
                        -1.75f, 5.5f, 0
                };
                firstShotDelay = 4f;
            }};
            ammoUseEffect = Fx.casing2;
            shootSound = Sounds.shootSalvo;
            shootWarmupSpeed = 0.25f;
            recoil = 1f;
            drawer = new DrawTurret() {{
                basePrefix = "dark-";
                parts.add(new RegionPart("-blade") {{
                    mirror = true;
                    moveX = 0f;
                    moveY = -2f;
                    moveRot = -10f;
                }});
            }};
            reload = 8f;
            range = 200f;
            rotateSpeed = 14f;
            coolant = consumeCoolant(0.2f);
            health = 1100;
            armor = 4f;
            size = 2;
            crushDamageMultiplier = 0.05f;
            outlineColor = Color.valueOf("2d2f39");
            researchCostMultiplier = 0.05f;
        }};

        crack = new ItemTurret("crack") {{
            requirements(Category.turret, ItemStack.with(Items.lead, 60, Items.graphite, 30, VeItems.silicide, 40));
            ammo(
                    Items.lead, new BasicBulletType(8f, 20f) {{
                        width = 8f;
                        height = 14f;
                        lifetime = 30f;
                        hitEffect = despawnEffect = Fx.flakExplosion;
                        ammoMultiplier = 3f;
                        knockback = 2.4f;
                        impact = true;
                        collidesTiles = false;
                        collidesGround = false;
                        splashDamage = 16f;
                        splashDamageRadius = 16f;
                    }},
                    Items.metaglass, new BasicBulletType(8f, 25f) {{
                        width = 10f;
                        height = 14f;
                        lifetime = 25f;
                        hitEffect = despawnEffect = Fx.flakExplosion;
                        ammoMultiplier = 5f;
                        knockback = 3f;
                        impact = true;
                        collidesTiles = false;
                        collidesGround = false;
                        splashDamage = 22f;
                        splashDamageRadius = 20f;
                        fragRandomSpread = 30f;
                        fragBullets = 2;
                        fragVelocityMin = 0.5f;
                        fragLifeMin = 0f;
                        fragBullet = new BasicBulletType(5f, 1f) {{
                            width = 8f;
                            height = 10f;
                            lifetime = 20f;
                            pierce = true;
                            pierceCap = 2;
                            hitEffect = despawnEffect = Fx.flakExplosion;
                            collidesTiles = false;
                            collidesGround = false;
                            splashDamage = 12f;
                            splashDamageRadius = 16f;
                        }};
                    }},
                    Items.scrap, new BasicBulletType(8f, 12f) {{
                        width = 8f;
                        height = 14f;
                        lifetime = 30f;
                        hitEffect = despawnEffect = Fx.flakExplosion;
                        ammoMultiplier = 3f;
                        knockback = 1.2f;
                        impact = true;
                        collidesTiles = false;
                        collidesGround = false;
                        backColor = Color.valueOf("d8887e");
                        frontColor = Color.valueOf("f5e0cc");
                        splashDamage = 14f;
                        splashDamageRadius = 24f;
                    }},
                    Items.plastanium, new BasicBulletType(8f, 30f) {{
                        width = 11f;
                        height = 15f;
                        lifetime = 25f;
                        hitEffect = despawnEffect = Fx.flakExplosion;
                        ammoMultiplier = 6f;
                        inaccuracy = 1f;
                        knockback = 3f;
                        impact = true;
                        status = StatusEffects.blasted;
                        statusDuration = 60f;
                        collidesTiles = false;
                        collidesGround = false;
                        hitShake = 1f;
                        backColor = Color.valueOf("d8d97f");
                        frontColor = Color.valueOf("fffac6");
                        splashDamage = 25f;
                        splashDamageRadius = 32f;
                        fragRandomSpread = 30f;
                        fragBullets = 4;
                        fragVelocityMin = 0.5f;
                        fragLifeMin = 0f;
                        fragBullet = new BasicBulletType(6f, 1f) {{
                            width = 8f;
                            height = 10f;
                            lifetime = 20f;
                            pierce = true;
                            pierceCap = 3;
                            hitEffect = despawnEffect = Fx.flakExplosion;
                            collidesTiles = false;
                            collidesGround = false;
                            backColor = Color.valueOf("d8d97f");
                            frontColor = Color.valueOf("fffac6");
                            splashDamage = 12f;
                            splashDamageRadius = 16f;
                        }};
                    }},
                    Items.surgeAlloy, new BasicBulletType(8f, 38f) {{
                        width = 12f;
                        height = 16f;
                        lifetime = 30f;
                        hitEffect = despawnEffect = Fx.blastExplosion;
                        ammoMultiplier = 6f;
                        knockback = 3.2f;
                        impact = true;
                        collidesTiles = false;
                        collidesGround = false;
                        hitShake = 1f;
                        trailColor = backColor = Color.valueOf("f3e979");
                        frontColor = Color.valueOf("ffffff");
                        trailInterval = 1f;
                        trailEffect = Fx.missileTrailShort;
                        trailWidth = 0.75f;
                        lightning = 2;
                        lightningLength = 9;
                        lightningDamage = 20f;
                        splashDamage = 14f;
                        splashDamageRadius = 24f;
                    }},
                    Items.blastCompound, new BasicBulletType(8f, 32f) {{
                        width = 11f;
                        height = 15f;
                        lifetime = 30f;
                        hitEffect = despawnEffect = Fx.blastExplosion;
                        ammoMultiplier = 6f;
                        knockback = 3.5f;
                        impact = true;
                        status = StatusEffects.blasted;
                        statusDuration = 60f;
                        collidesTiles = false;
                        collidesGround = false;
                        hitShake = 1;
                        despawnShake = 1;
                        backColor = Color.valueOf("e9665b");
                        frontColor = Color.valueOf("eeab89");
                        splashDamage = 28f;
                        splashDamageRadius = 36f;
                    }},
                    VeItems.silicide, new BasicBulletType(9f, 40f) {{
                        width = 12f;
                        height = 16f;
                        lifetime = 36f;
                        hitEffect = new MultiEffect(
                                Fx.flakExplosion,
                                new WaveEffect() {{
                                    colorFrom = colorTo = lightColor = Color.valueOf("565666ff");
                                    sizeTo = 12f;
                                    strokeFrom = 6f;
                                    strokeTo = 4f;
                                    lifetime = 7f;
                                }},
                                new WaveEffect() {{
                                    colorFrom = colorTo = lightColor = Color.valueOf("565666ff");
                                    sizeTo = 16f;
                                    strokeFrom = 5f;
                                    strokeTo = 3f;
                                    lifetime = 5f;
                                }}
                        );
                        despawnEffect = Fx.none;
                        ammoMultiplier = 6f;
                        reloadMultiplier = 1.3f;
                        knockback = 4.6f;
                        impact = true;
                        collidesTiles = false;
                        collidesGround = false;
                        rangeChange = 84f;
                        despawnHit = true;
                        splashDamage = 18f;
                        splashDamageRadius = 16f;
                        hittable = false;
                    }},
                    VeItems.ferrum, new BasicBulletType(8f, 30f) {{
                        width = 11f;
                        height = 15f;
                        shrinkY = 0f;
                        lifetime = 30f;
                        hitEffect = Fx.flakExplosion;
                        despawnEffect = Fx.hitBulletColor;
                        ammoMultiplier = 4f;
                        collidesTiles = false;
                        collidesGround = false;
                        setDefaults = false;
                        hitColor = frontColor = Color.valueOf("9f8c88");
                        backColor = Color.valueOf("7e6863");
                        despawnHit = true;
                        splashDamage = 10f;
                        splashDamageRadius = 16f;
                        fragRandomSpread = 30f;
                        fragBullets = 4;
                        fragVelocityMin = 0.5f;
                        fragLifeMin = 0f;
                        fragOffsetMax = 1f;
                        fragBullet = new BasicBulletType(6f, 6f) {{
                            width = 7f;
                            height = 11f;
                            shrinkY = 0f;
                            spin = 10f;
                            lifetime = 20f;
                            pierce = true;
                            pierceBuilding = false;
                            pierceCap = 4;
                            hitEffect = despawnEffect = Fx.hitBulletColor;
                            collidesTiles = false;
                            collidesGround = false;
                            pierceArmor = true;
                            hitColor = frontColor = Color.valueOf("9f8c88");
                            backColor = Color.valueOf("7e6863");
                        }};
                    }}
            );
            maxAmmo = 40;
            inaccuracy = 1f;
            shootY = 0f;
            trackingRange = 296f;
            warmupMaintainTime = 30f;
            shoot = new ShootBarrel() {{
                barrels = new float[]{
                        1.75f, 6, 0,
                        -1.75f, 6, 0
                };
            }};
            targetGround = false;
            ammoUseEffect = Fx.casing2;
            shootSound = Sounds.shootSalvo;
            shootWarmupSpeed = 0.25f;
            recoil = 2f;
            recoilTime = 20f;
            shake = 1f;
            drawer = new DrawTurret() {{
                basePrefix = "dark-";
                parts.add(
                        new RegionPart("-side") {{
                            mirror = true;
                            moveX = 2f;
                            moveY = -2f;
                            moveRot = 0f;
                            under = true;
                        }},
                        new RegionPart("-shell") {{
                            progress = PartProgress.recoil;
                            moveX = 0f;
                            moveY = 0.75f;
                            moveRot = 0f;
                        }},
                        new RegionPart("-tubes") {{
                            progress = PartProgress.recoil;
                            moveX = 0f;
                            moveY = -1f;
                            moveRot = 0f;
                            under = true;
                        }}
                );
            }};
            reload = 6f;
            range = 240f;
            rotateSpeed = 14f;
            coolant = consumeCoolant(0.3f);
            health = 1400;
            armor = 4f;
            size = 2;
            crushDamageMultiplier = 0.05f;
            outlineColor = Color.valueOf("2d2f39");
            researchCostMultiplier = 0.1f;
        }};

        shock = new PowerTurret("shock") {{
            requirements(Category.turret, ItemStack.with(Items.silicon, 30, VeItems.aluminium, 65, VeItems.silicide, 20));
            consumePower(3.8f);
            shootType = new MultiBulletType(
                    new RailBulletType() {{
                        pierceEffect = Fx.none;
                        pointEffect = new ParticleEffect() {{
                            particles = 1;
                            colorFrom = colorTo = Color.valueOf("8aa3f4");
                            length = 0f;
                            baseLength = 0f;
                            sizeInterp = Interp.circleIn;
                            sizeFrom = 1.5f;
                            sizeTo = 0f;
                            lifetime = 3f;
                        }};
                        length = 144f;
                        pointEffectSpace = 1f;
                        damage = 8f;
                        pierce = true;
                        pierceBuilding = false;
                        pierceCap = 2;
                        hitEffect = new MultiEffect(
                                Fx.hitLancer,
                                new ParticleEffect() {{
                                    particles = 1;
                                    colorFrom = colorTo = Color.valueOf("8aa3f4");
                                    length = 0f;
                                    baseLength = 0f;
                                    sizeInterp = Interp.circleIn;
                                    sizeFrom = 2f;
                                    sizeTo = 0f;
                                    lifetime = 4f;
                                }});
                        despawnEffect = smokeEffect = Fx.shootSmallSmoke;
                        shootEffect = new MultiEffect(
                                new ParticleEffect() {{
                                    colorFrom = colorTo = Color.valueOf("8aa3f4");
                                    particles = 1;
                                    length = 0f;
                                    baseLength = 0f;
                                    sizeFrom = 3f;
                                    sizeTo = 0;
                                    sizeInterp = Interp.circleIn;
                                    lifetime = 4f;
                                }});
                        pierceArmor = true;
                        hitShake = 0f;
                    }}) {{
                damage = 144f;
                pierce = true;
                pierceCap = 2;
                pierceArmor = true;
            }};
            shootY = 0f;
            minWarmup = 0.95f;
            warmupMaintainTime = 40f;
            shoot = new ShootMulti(
                    new ShootPattern() {{
                        shots = 9;
                        shotDelay = 2f;
                    }},
                    new ShootBarrel() {{
                        barrels = new float[]{
                                3, 0, 0,
                                -3, 0, 0
                        };
                        shots = 2;
                    }}
            );
            predictTarget = false;
            // shootSound = VeSounds.lasershootClassic;
            soundPitchMin = 1.5f;
            soundPitchMax = 1.5f;
            shootWarmupSpeed = 0.25f;
            recoil = 1.5f;
            recoilTime = 120f;
            drawer = new DrawTurret() {{
                basePrefix = "dark-";
                parts.add(
                        new RegionPart("-blade") {{
                            mirror = true;
                            moveX = 1f;
                            moveY = 0.75f;
                            moveRot = 0f;
                            heatLight = true;
                            heatProgress = PartProgress.recoil;
                            under = true;
                        }}
                );
            }};
            reload = 60f;
            range = 144f;
            rotateSpeed = 10f;
            coolantMultiplier = 12f;
            coolant = consumeCoolant(0.2f);
            health = 1200;
            size = 2;
            crushDamageMultiplier = 0.05f;
            researchCostMultiplier = 0.01f;
        }};


        mechanicalDrillMicro = new Drill("mechanical-drill-micro") {{
            requirements(Category.production, ItemStack.with(Items.copper, 4));
            tier = 2;
            drillTime = 600f;
            size = 1; // -
            itemCapacity = 5;
            consumeLiquid(Liquids.water, 1.5f / 60f).boost();
        }};

        mechanicalDrillHuge = new Drill("mechanical-drill-huge") {{
            requirements(Category.production, ItemStack.with(Items.copper, 50));
            tier = 2;
            drillTime = 600f;
            itemCapacity = 10; // -
            size = 4;
            consumeLiquid(Liquids.water, 6f / 60f).boost().boost();
            researchCostMultiplier = 0.05f;
        }};

        isomorphicDrill = new Drill("isomorphic-drill") {{
            requirements(Category.production, ItemStack.with(VeItems.aluminium, 15));
            tier = 2;
            drillTime = 600f;
            drillMultipliers.put(Items.sporePod, 0f); // -
            size = 2;
            itemCapacity = 10; // -
            consumeLiquid(Liquids.water, 1.5f / 60f).boost().boost();
            researchCostMultiplier = 0.05f;
        }};

        isomorphicDrillHuge = new Drill("isomorphic-drill-huge") {{
            requirements(Category.production, ItemStack.with(VeItems.aluminium, 65));
            tier = 2;
            drillTime = 600f;
            drillMultipliers.put(Items.sporePod, 0f); // -
            size = 4;
            itemCapacity = 10; // -
            consumeLiquid(Liquids.water, 6f / 60f).boost();
            researchCostMultiplier = 0.05f;
        }};

        laserBore = new BeamDrill("laser-bore") {{
            requirements(Category.production, ItemStack.with(VeItems.aluminium, 10, VeItems.quartz, 8));
            drillTime = 240f;
            range = 5; // -
            tier = 4;
            drillMultipliers.put(VeItems.aluminium, 1.5f);
            drillMultipliers.put(VeItems.quartz, 2f);
            sparkColor = Color.valueOf("ffd37f");
            heatColor = Color.valueOf("ffd37f");
            size = 2;
            consumesPower = true; // -
            consumeLiquid(Liquids.hydrogen, 0.25f / 60f).boost();
            consumePower(9f / 60f);
            researchCostMultiplier = 0.05f;
        }};

        powerDrill = new Drill("power-drill") {{
            requirements(Category.production, ItemStack.with(Items.graphite, 16, VeItems.aluminium, 20));
            tier = 3;
            drillTime = 320f;
            liquidBoostIntensity = 1.8f;
            warmupSpeed = 0.03f;
            drillMultipliers.put(Items.sporePod, 0f); // -
            rotateSpeed = 5f;
            size = 2;
            itemCapacity = 10; // -
            hasPower = true;
            conductivePower = true;
            consumeLiquid(Liquids.water, 1.5f / 60f).boost();
            consumePower(8f / 60f);
            researchCostMultiplier = 0.01f;
        }};

        beamDrill = new Drill("beam-drill") {{
            requirements(Category.production, ItemStack.with(Items.lead, 60, Items.graphite, 40, Items.silicon, 35, VeItems.quartz, 55));
            tier = 4;
            drillTime = 108f;
            liquidBoostIntensity = 1.8f;
            warmupSpeed = 0.01f;
            drillMultipliers.put(Items.sporePod, 0f); // -
            rotateSpeed = 7f;
            updateEffect = new ParticleEffect() {{
                colorFrom = Color.valueOf("ffffff");
                colorTo = Color.valueOf("ffdaa9");
                particles = 4;
                length = 20f; // -
                baseLength = 0f; // -
                line = true;
                strokeFrom = 3f;
                strokeTo = 0f; // -
                lenFrom = 10f;
                lenTo = 0f;
                lifetime = 10f;
            }};
            drawRim = true;
            heatColor = Color.valueOf("ffdaa9");
            size = 3;
            itemCapacity = 30;
            hasPower = true;
            consumeLiquid(Liquids.hydrogen, 3f / 60f).boost();
            consumePower(72f / 60f);
            ambientSound = Sounds.loopMineBeam;
            ambientSoundVolume = 0.02f;
            researchCostMultiplier = 0.01f;
        }};

        silicideDrill = new Drill("silicide-drill") {{
            requirements(Category.production, ItemStack.with(Items.lead, 100, Items.graphite, 60, VeItems.aluminium, 80, VeItems.silicide, 50));
            hardnessDrillMultiplier = 15f;
            tier = 6;
            drillTime = 360f;
            liquidBoostIntensity = 1.6f; // -
            warmupSpeed = 0.001f;
            drillMultipliers.put(Items.sporePod, 0f); // -
            drillEffect = Fx.mineHuge;
            rotateSpeed = 2f; // -
            updateEffect = Fx.smoke;
            updateEffectChance = 0.05f;
            drawRim = true;
            ambientSoundVolume = 0.2f;
            explosivenessScale = 1.5f;
            flammabilityScale = 0f;
            size = 4;
            itemCapacity = 20;
            liquidCapacity = 20f;
            hasPower = true;
            consumeLiquid(Liquids.water, 6f / 60f).boost();
            consumePower(1f);
            squareSprite = false;
            researchCostMultiplier = 0.1f;
        }};

        hydraulicDrill = new Drill("hydraulic-drill") {{
            requirements(Category.production, ItemStack.with(Items.lead, 90, Items.graphite, 55, Items.silicon, 40, VeItems.silicide, 50, VeItems.chromium, 115));
            hardnessDrillMultiplier = 15f;
            tier = 6;
            drillTime = 100f;
            liquidBoostIntensity = 1.4f;
            warmupSpeed = 0.01f;
            drillMultipliers.put(Items.sporePod, 0f); // -
            drillEffect = Fx.mineHuge;
            rotateSpeed = 9f;
            updateEffect = Fx.pulverizeRed;
            drawRim = true;
            ambientSoundVolume = 0.1f;
            armor = 5f;
            size = 4;
            crushDamageMultiplier = 0.2f;
            itemCapacity = 30;
            liquidCapacity = 40f;
            hasPower = true;
            consumeLiquid(Liquids.water, 12f / 60f);
            consumeLiquid(Liquids.hydrogen, 6f / 60f).boost();
            consumePower(150f / 60f);
            squareSprite = false;
            researchCostMultiplier = 0.05f;
        }};

        powderDigger = new Drill("powder-digger") {{
            requirements(Category.production, ItemStack.with(Items.lead, 40, Items.graphite, 55, Items.silicon, 20, VeItems.chromium, 45));
            tier = 0;
            drillTime = 75f;
            liquidBoostIntensity = 1.53f;
            warmupSpeed = 0.01f;
            drillMultipliers.put(Items.sporePod, 0f); // -
            blockedItem = Items.scrap;
            drillEffect = Fx.breakProp;
            rotateSpeed = 10f;
            updateEffect = Fx.pulverizeSmall;
            updateEffectChance = 0.06f;
            ambientSoundVolume = 0.25f;
            size = 3;
            crushDamageMultiplier = 0.2f;
            itemCapacity = 40;
            liquidCapacity = 20f;
            hasPower = true;
            consumeLiquid(Liquids.water, 4.5f / 60f).boost();
            consumePower(72f / 60f);
            squareSprite = false;
            researchCostMultiplier = 0.01f;
        }};

        floorCrusher = new BurstDrill("floor-crusher") {{
            requirements(Category.production, ItemStack.with(Items.graphite, 60, Items.silicon, 50, VeItems.silicide, 70, VeItems.chromium, 90));
            drillTime = 240f;
            size = 3;
            tier = 7;
            drillEffect = new MultiEffect(
                    Fx.massiveExplosion,
                    Fx.drillSteam,
                    Fx.breakProp,
                    Fx.breakProp,
                    Fx.breakProp,
                    Fx.breakProp,
                    new SoundEffect() {{
                        sound = new RandomSound(
                                VeSounds.get("lbp3PlungerSwitch1"),
                                VeSounds.get("lbp3PlungerSwitch2"),
                                VeSounds.get("lbp3PlungerSwitch3")
                        );
                        maxVolume = 0.06f;
                        minVolume = 0.06f;
                        maxPitch = 1f;
                        minPitch = 1f;
                        effect = Fx.none;
                    }}
            );
            shake = 3f;
            arrows = 1;
            armor = 5f;
            invertedTime = 120f;
            arrowColor = glowColor = Color.valueOf("ff6b41");
            baseArrowColor = Color.valueOf("2d2f39");
            itemCapacity = 30;
            researchCostMultiplier = 0.1f;
            consumeLiquid(Liquids.water, 6f / 60f);
            consumePower(90f / 60f);
            crushDamageMultiplier = 0.2f;
            squareSprite = false;
            blockedItems = Seq.with(
                    Items.copper,
                    Items.lead,
                    Items.titanium,
                    Items.thorium,
                    Items.scrap,
                    Items.beryllium,
                    Items.tungsten,
                    VeItems.aluminium,
                    VeItems.catalyzon
            );

            drillMultipliers.put(Items.copper, 0);
            drillMultipliers.put(Items.lead, 0);
            drillMultipliers.put(Items.sand, 2);
            drillMultipliers.put(Items.titanium, 0);
            drillMultipliers.put(Items.thorium, 0);
            drillMultipliers.put(Items.sporePod, 6);
            drillMultipliers.put(Items.pyratite, 4);
            drillMultipliers.put(Items.beryllium, 0);
            drillMultipliers.put(Items.tungsten, 1);
            drillMultipliers.put(VeItems.aluminium, 0);
            drillMultipliers.put(VeItems.catalyzon, 0);
            drillMultipliers.put(VeItems.salt, 2);
            drillMultipliers.put(VeItems.chromium, 0);
            drillMultipliers.put(VeItems.carbonShaleCobble, 3);
            drillMultipliers.put(VeItems.shaleCobble, 3);
            drillMultipliers.put(VeItems.ferrum, 1);
            drillMultipliers.put(VeItems.silver, 0);
            drillMultipliers.put(VeItems.tantalum, 1);
            drillMultipliers.put(VeItems.melonDirt, 4);
        }};

        spaceDigger = new Drill("space-digger") {{
            requirements(Category.production, ItemStack.with(Items.lead, 150, Items.graphite, 120, Items.silicon, 300, VeItems.cobalt, 90, VeItems.warpNucleus, 40));
            tier = 7;
            warmupSpeed = 0.02f;
            drillTime = 60f;
            itemCapacity = 100;
            liquidBoostIntensity = 2f;
            rotateSpeed = -9f;
            size = 5;
            researchCostMultiplier = 0.03f;
            hardnessDrillMultiplier = 0f;
            consumeLiquid(Liquids.cryofluid, 12f / 60f).boost();
            consumePower(390f / 60f);
            hasPower = true;
            ambientSoundVolume = 0.015f;
            updateEffect = new WrapEffect(Fx.mineHuge, Color.valueOf("b791eb"));
            updateEffectChance = 0.04f;
            liquidCapacity = 60f;
            drillEffect = Fx.mineHuge;
            drillEffectChance = 0.01f;
            ambientSound = VeSounds.get("lbp3PlasmaProjectile");
            heatColor = Color.valueOf("b791eb");
            drawRim = true;
        }};

        powerWell = new SolidPump("power-well") {{
            requirements(Category.production, ItemStack.with(Items.metaglass, 40, Items.graphite, 35, VeItems.aluminium, 20));
            result = Liquids.water; // -
            rotateSpeed = 4f;
            attribute = Attribute.water;
            pumpAmount = 8f / 60f;
            size = 2;
            researchCostMultiplier = 0.3f;
            liquidCapacity = 40f;
            consumePower(78f / 60f);
        }};

        pressureWell = new SolidPump("pressure-well") {{
            requirements(Category.production, ItemStack.with(Items.graphite, 90, Items.silicon, 60, VeItems.chromium, 140));
            result = Liquids.water; // -
            rotateSpeed = 7f;
            attribute = Attribute.water;
            pumpAmount = 48f / 60f;
            health = 755;
            armor = 5f;
            size = 3;
            researchCostMultiplier = 0.5f;
            buildCostMultiplier = 3f;
            liquidCapacity = 300f;
            consumeLiquid(Liquids.hydrogen, 2f / 60f);
            consumePower(150f / 60f);
            squareSprite = false;
        }};

        extractionPlatform = new SolidPump("extraction-platform") {{
            requirements(Category.production, ItemStack.with(Items.graphite, 230, Items.silicon, 100, VeItems.aluminium, 270, VeItems.chromium, 200));
            result = Liquids.oil;
            updateEffect = Fx.pulverize;
            updateEffectChance = 0.06f;
            rotateSpeed = 2.5f;
            baseEfficiency = 0f;
            attribute = Attribute.oil;
            pumpAmount = 33f / 60f;
            armor = 12f;
            size = 4;
            researchCostMultiplier = 0.2f;
            placeableLiquid = true;
            floating = true;
            crushDamageMultiplier = 0.2f;
            liquidCapacity = 300f;
            consumeLiquid(Liquids.water, 21f / 60f);
            consumePower(300f / 60f);
        }};

        lavaWell = new SolidPump("lava-well") {{
            requirements(Category.production, ItemStack.with(Items.graphite, 200, Items.silicon, 40, VeItems.silicide, 70, VeItems.chromium, 180));
            result = VeLiquids.lava;
            updateEffect = Fx.drillSteam;
            rotateSpeed = 2f;
            baseEfficiency = 0f;
            attribute = Attribute.sand;
            pumpAmount = 16f / 60f;
            size = 4;
            researchCostMultiplier = 0.3f;
            liquidCapacity = 100f;
            consumePower(360f / 60f);
        }};


        isomorphicCultivator = new GenericCrafter("isomorphic-cultivator") {{
            requirements(Category.production, BuildVisibility.sandboxOnly, ItemStack.with(Items.lead, 25, Items.silicon, 20, Items.sporePod, 1, VeItems.aluminium, 50));
            outputItem = new ItemStack(Items.sporePod, 1);
            alwaysUnlocked = true;
            consumeLiquid(Liquids.water, 16f / 60f);
            consumePower(1f); // 60f / 60f
            craftEffect = Fx.none;
            liquidCapacity = 10f;
            hasItems = true;
            hasLiquids = true;
            hasPower = true;
            itemCapacity = 10;
            craftTime = 100f;
            size = 2;
            priority = -10f;
            allowDerelictRepair = false;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(Liquids.water),
                    new DrawCultivator(),
                    new DrawDefault(),
                    new DrawRegion("-top")
            );
            destroyBulletSameTeam = true;
            destroyBullet = new BulletType() {{
                instantDisappear = true;
                hitEffect = despawnEffect = new ExplosionEffect() {{
                    waveColor = Color.valueOf("7457ce");
                    smokeColor = Color.valueOf("7457ce55");
                    sparkColor = Color.valueOf("7457ce");
                    sparks = 4;
                    smokeRad = 32f;
                    waveRad = 20f;
                    smokes = 10;
                    lifetime = 60f;
                }};
                collides = false;
                splashDamage = 1f;
                splashDamageRadius = 32f;
                status = StatusEffects.sporeSlowed;
                statusDuration = 400f;
                // despawnUnit = VeUnitTypes.fungusFactoryDie;
            }};
        }};

        cultivateTank = new GenericCrafter("cultivate-tank") {{
            requirements(Category.production, ItemStack.with(Items.lead, 45, Items.metaglass, 30, Items.silicon, 25, Items.sporePod, 5, VeItems.aluminium, 50, VeItems.silicide, 50));
            outputItem = new ItemStack(Items.sporePod, 8);
            hasItems = true;
            hasLiquids = true;
            hasPower = true;
            consumeLiquid(Liquids.water, 56f / 60f);
            consumePower(90f / 60f);
            flammabilityScale = 0f;
            explosivenessScale = 1.5f;
            craftEffect = Fx.none;
            liquidCapacity = 20f;
            itemCapacity = 20;
            craftTime = 120f;
            size = 3;
            armor = 16f;
            legacyReadWarmup = true;
            destroyBullet = new BulletType() {{
                collidesTiles = false;
                collides = false;
                despawnEffect = Fx.launchPod;
                speed = 0f;
                splashDamageRadius = 56f;
                lifetime = 1f;
                splashDamage = 470f;
                hittable = false;
                despawnShake = 8f;
                status = StatusEffects.blasted;
                statusDuration = 60f;
                collidesAir = true;
            }};
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(Liquids.water),
                    new DrawCultivator(),
                    new DrawDefault()
            );
        }};

        tissueCultivator = new AttributeCrafter("tissue-cultivator") {{
            requirements(Category.production, ItemStack.with(Items.metaglass, 25, Items.silicon, 35, VeItems.aluminium, 40));
            outputItem = new ItemStack(VeItems.plantMatter, 2);
            consumeItem(VeItems.salt, 1);
            consumeLiquid(Liquids.water, 0.4f / 60f);
            consumePower(30f / 60f);
            craftEffect = Fx.none;
            hasItems = hasLiquids = hasPower = true;
            // attribute = Attribute.plant;
            liquidCapacity = 15f;
            itemCapacity = 10;
            craftTime = 300f;
            size = 2;
            legacyReadWarmup = true;
            maxBoost = 0.75f;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(Liquids.water),
                    new DrawCultivator() {{
                        plantColorLight = Color.valueOf("6aa95e");
                        plantColor = Color.valueOf("4e904f");
                        bottomColor = Color.valueOf("3f7a50");
                    }},
                    new DrawRegion(""),
                    new DrawRegion("-top0"),
                    new DrawFlame() {{
                        flameColor = Color.valueOf("ffffff00");
                        flameRadius = 0f;
                        flameRadiusIn = 0f;
                        lightRadius = 16f;
                        // lightColor = Color.valueOf("3300ff");
                        lightAlpha = 0.8f;
                    }}
            );
            researchCostMultiplier = 0.5f;
        }};

        nitroalkossCultivator = new GenericCrafter("nitroalkoss-cultivator") {{
            requirements(Category.production, ItemStack.with(Items.metaglass, 40, Items.silicon, 60, VeItems.chromium, 35, VeItems.nitroalkoss, 2));
            outputItems = ItemStack.with(Items.blastCompound,2, VeItems.nitroalkoss, 7);
            consumeItem(Items.pyratite, 3);
            consumeLiquid(Liquids.water, 14f / 60f);
            consumePower(45f / 60f);
            baseExplosiveness = 2f;
            hasItems = hasLiquids = hasPower = true;
            craftEffect = Fx.none;
            liquidCapacity = 20f;
            itemCapacity = 15;
            craftTime = 440f;
            size = 2;
            armor = 2f;
            legacyReadWarmup = true;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(Liquids.water),
                    new DrawCultivator() {{
                        plantColorLight = Color.valueOf("ff8a67");
                        plantColor = Color.valueOf("e16049");
                        bottomColor = Color.valueOf("ba352b");
                    }},
                    new DrawRegion()
            );
        }};

        nitroalkossCultivatorSilicide = new GenericCrafter("nitroalkoss-cultivator-silicide") {{
            requirements(Category.production, ItemStack.with(Items.metaglass, 40, Items.silicon, 150, VeItems.silicide, 80, VeItems.chromium, 140, VeItems.nitroalkoss, 10));
            health = 4000;
            armor = 24f;
            outputItems = ItemStack.with(Items.blastCompound,10, VeItems.nitroalkoss, 35);
            consumeItem(Items.pyratite, 14);
            consumeLiquid(Liquids.water, 72f / 60f);
            consumePower(90f / 60f);
            flammabilityScale = 0f;
            explosivenessScale = 1.5f;
            baseExplosiveness = -10f;
            hasItems = hasLiquids = hasPower = true;
            craftEffect = Fx.none;
            liquidCapacity = 100f;
            itemCapacity = 70;
            craftTime = 420f;
            size = 4;
            legacyReadWarmup = true;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(Liquids.water),
                    new  DrawCultivator() {{
                        plantColorLight = Color.valueOf("ff8a67");
                        plantColor = Color.valueOf("e16049");
                        bottomColor = Color.valueOf("ba352b");
                    }},
                    new DrawRegion("")
            );
            researchCostMultiplier = 0.01f;
        }};

        reflectorCultivator = new GenericCrafter("reflector-cultivator") {{
            requirements(Category.production, ItemStack.with(Items.lead, 30, Items.silicon, 40, VeItems.aluminium, 50, VeItems.ferrum, 20, VeItems.reflectorMatter, 10));
            outputItem = new ItemStack(VeItems.reflectorMatter, 5);
            consumeItem(VeItems.redSoil, 2);
            consumeLiquid(Liquids.water, 2f / 60f);
            consumePower(42f / 60f);
            craftEffect = Fx.none;
            hasItems = hasLiquids = hasPower = true;
            // attribute = Attribute.plant;
            liquidCapacity = 10f;
            itemCapacity = 15;
            craftTime = 480f;
            size = 2;
            armor = 4f;
            legacyReadWarmup = true;
            // maxBoost = 0.75f;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(Liquids.water),
                    new DrawCultivator() {{
                        plantColorLight = plantColor = bottomColor = Color.valueOf("a58570");
                    }},
                    new DrawRegion(""),
                    new DrawFlame() {{
                        flameColor = Color.valueOf("ffffff00");
                        flameRadius = 0f;
                        flameRadiusIn = 0f;
                        lightRadius = 24f;
                        // lightColor = Color.valueOf("3300ff");
                        lightAlpha = 0.8f;
                    }},
                    new DrawGlowRegion("-glow") {{
                        alpha = 0.5f;
                        color = Color.valueOf("ffa665");
                        glowScale = 10f;
                        glowIntensity = 0.1f;
                    }}
            );
        }};


        collector = new Drill("collector") {{
            requirements(Category.production, ItemStack.with(VeItems.ferrum, 20));
            hardnessDrillMultiplier = 0f;
            tier = 3;
            drillTime = 400f;
            drillMultipliers.put(Items.sporePod, 2f);
            drillMultipliers.put(VeItems.melonDirt, 2f);
            blockedItems = Seq.with(
                    Items.copper,
                    Items.lead,
                    Items.coal,
                    Items.titanium,
                    Items.beryllium,
                    VeItems.aluminium
            );
            rotateSpeed = 5f;
            size = 2;
            itemCapacity = 10; // -
            consumeCoolant(0.025f).boost();
            squareSprite = false;
            researchCostMultiplier = 0.02f;
        }};

        magneticDigger = new Drill("magnetic-digger") {{
            requirements(Category.production, ItemStack.with(Items.graphite, 70, Items.silicon, 40, VeItems.quartz, 40, VeItems.ferrum, 120));
            hardnessDrillMultiplier = 25f;
            tier = 4;
            drillTime = 90f;
            liquidBoostIntensity = 1.6f; // -
            warmupSpeed = 0.0035f;
            drillMultipliers.put(Items.sand, 0.6f);
            drillMultipliers.put(Items.coal, 0.6f);
            drillMultipliers.put(Items.scrap, 1.2f);
            drillMultipliers.put(Items.sporePod, 0f); // -
            drillMultipliers.put(Items.pyratite, 0.6f);
            drillMultipliers.put(VeItems.salt, 0.6f);
            drillMultipliers.put(VeItems.redSoil, 0.9f);
            drillMultipliers.put(VeItems.ferrum, 1.5f);
            drillMultipliers.put(VeItems.silver, 1.2f);
            drillMultipliers.put(VeItems.tantalum, 1.2f);
            drillMultipliers.put(VeItems.melonDirt, 0.6f);
            drillEffect = Fx.mineHuge;
            rotateSpeed = 7f;
            updateEffect = new WrapEffect(Fx.mine, Color.valueOf("cc8270"));
            drawRim = true;
            heatColor = Color.valueOf("cc8270");
            ambientSound = Sounds.loopMachineSpin;
            ambientSoundVolume = 0.15f;
            size = 3;
            crushDamageMultiplier = 0.2f;
            itemCapacity = 30;
            hasPower = true;
            consumesPower = true; // -
            conductivePower = true;
            consumeLiquid(Liquids.water, 9f / 60f).boost();
            consumePower(120f / 60f);
            researchCostMultiplier = 0.03f;
        }};

        mechanicalWell = new SolidPump("mechanical-well") {{
            requirements(Category.production, ItemStack.with(VeItems.ferrum, 20, VeItems.silver, 30));
            result = VeLiquids.melonWater;
            rotateSpeed = 2f;
            baseEfficiency = 0f;
            attribute = Attribute.steam;
            pumpAmount = 4f / 60f;
            armor = 4f;
            size = 2;
            liquidCapacity = 40f;
            hasPower = false;
            consumesPower = false;
            consume(new ConsumeLiquid(VeLiquids.melonWater, 0f) {{
                optional = true;
                booster = false;
            }});
            researchCostMultiplier = 0.3f;
        }};


        rotChamber = new AttributeCrafter("rot-chamber") {{
            requirements(Category.production, ItemStack.with(Items.silicon, 25, VeItems.ferrum, 60, VeItems.silver, 10));
            outputItem = new ItemStack(Items.sporePod, 2);
            outputLiquid = new LiquidStack(VeLiquids.melonWater, 0);
            consumeItem(Items.sporePod, 0).optional = true;
            consumeLiquid(VeLiquids.melonWater, 9f / 60f);
            consumePower(54f / 60f);
            hasItems = hasLiquids = hasPower = true;
            conductivePower = true;
            craftEffect = Fx.none;
            liquidCapacity = 20f;
            itemCapacity = 10;
            ignoreLiquidFullness = true;
            craftTime = 120f;
            size = 2;
            armor = 6f;
            legacyReadWarmup = true;
            maxBoost = 1f;
            attribute = Attribute.spores;
            drawer = new  DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(VeLiquids.melonWater),
                    new DrawCultivator(),
                    new DrawDefault()
            );
            researchCostMultiplier = 0.5f;
        }};


        armoredBridgeConveyor = new DuctBridge("armored-bridge-conveyor") {{
            requirements(Category.distribution, ItemStack.with(Items.metaglass, 10, Items.thorium, 10, Items.plastanium, 10));
            speed = 4f;
            range = 6;
            health = 220;
        }};

        armoredRouter = new DuctRouter("armored-router") {{
            requirements(Category.distribution, ItemStack.with(Items.metaglass, 4, Items.thorium, 4, Items.plastanium, 4));
            speed = 4f;
            solid = false; // -
            health = 190;
            regionRotated1 = 1;
        }};

        armoredOverflowGate = new OverflowDuct("armored-overflow-gate") {{
            requirements(Category.distribution, ItemStack.with(Items.graphite, 4, Items.thorium, 4, Items.plastanium, 4));
            speed = 4f;
            health = 190;
            solid = false;
        }};

        armoredUnderflowGate = new OverflowDuct("armored-underflow-gate") {{
            requirements(Category.distribution, ItemStack.with(Items.graphite, 4, Items.thorium, 4, Items.plastanium, 4));
            speed = 4f;
            invert = true;
            health = 190;
            solid = false;
        }};

        armoredUnloader = new DirectionalUnloader("armored-unloader") {{
            requirements(Category.distribution, ItemStack.with(Items.graphite, 10, Items.thorium, 10, Items.silicon, 10, Items.plastanium, 10));
            speed = 4f;
            allowCoreUnload = true;
            solid = false;
            health = 190;
            regionRotated1 = 1;
        }};

        silicideDuct = new Duct("silicide-duct") {{
            requirements(Category.distribution, ItemStack.with(Items.titanium, 1, VeItems.silicide, 1));
            speed = 4f;
            health = 280;
            armor = 16f;
            explosivenessScale = 1.5f;
            flammabilityScale = 0f;
            crushDamageMultiplier = 0.05f;
        }};

        silicideArmoredDuct = new Duct("silicide-armored-duct") {{
            requirements(Category.distribution, ItemStack.with(Items.metaglass, 1, Items.thorium, 1, VeItems.silicide, 1));
            speed = 4f;
            armored = true;
            health = 460;
            armor = 16f;
            explosivenessScale = 1.5f;
            flammabilityScale = 0f;
            crushDamageMultiplier = 0.05f;
        }};

        silicideJunction = new Junction("silicide-junction") {{
            requirements(Category.distribution, ItemStack.with(Items.copper, 4, VeItems.silicide, 2));
            speed = 6f;
            capacity = 8;
            displayedSpeed = 72f; // 60f / 6f * 8 = 80f, 实测80帧下稳定72.0
            health = 280;
            armor = 16f;
            explosivenessScale = 1.5f;
            flammabilityScale = 0f;
            crushDamageMultiplier = 0.05f;
            buildCostMultiplier = 6f;
            ((Duct)silicideDuct).junctionReplacement = ((Duct)silicideArmoredDuct).junctionReplacement = this;
        }};

        silicideBridgeConveyor = new BufferedItemBridge("silicide-bridge-conveyor") {{
            requirements(Category.distribution, ItemStack.with(Items.copper, 6, Items.lead, 6, VeItems.silicide, 6));
            speed = 40f; // -
            bufferCapacity = 30;
            displayedSpeed = 15f; // 60f / 40f * 30 = 45, 实测30帧下稳定15.0
            range = 4;
            fadeIn = false;
            moveArrows = false;
            arrowSpacing = 6f; // -
            health = 370;
            armor = 16f;
            explosivenessScale = 1.5f;
            flammabilityScale = 0f;
            crushDamageMultiplier = 0.05f;
            buildCostMultiplier = 3f;
            ((Duct)silicideDuct).bridgeReplacement = ((Duct)silicideArmoredDuct).bridgeReplacement = this;
        }};

        silicideSorter = new Sorter("silicide-sorter") {{
            requirements(Category.distribution, ItemStack.with(Items.copper, 6, Items.lead, 2, VeItems.silicide, 3));
            health = 370;
            armor = 16f;
            explosivenessScale = 1.5f;
            flammabilityScale = 0f;
            crushDamageMultiplier = 0.05f;
            buildCostMultiplier = 3f;
        }};

        silicideInvertedSorter = new Sorter("silicide-inverted-sorter") {{
            requirements(Category.distribution, ItemStack.with(Items.copper, 6, Items.lead, 2, VeItems.silicide, 3));
            invert = true;
            health = 370;
            armor = 16f;
            explosivenessScale = 1.5f;
            flammabilityScale = 0f;
            crushDamageMultiplier = 0.05f;
            buildCostMultiplier = 3f;
        }};

        silicideRouter = new Router("silicide-router") {{
            requirements(Category.distribution, ItemStack.with(Items.copper, 6, VeItems.silicide, 3));
            speed = 4f;
            health = 370;
            armor = 16f;
            explosivenessScale = 1.5f;
            flammabilityScale = 0f;
            crushDamageMultiplier = 0.05f;
            buildCostMultiplier = 4f;
        }};

        silicideDistributor = new Router("silicide-distributor") {{
            requirements(Category.distribution, ItemStack.with(Items.copper, 5, Items.lead, 5, VeItems.silicide, 7));
            speed = 4f;
            health = 640;
            armor = 16f;
            explosivenessScale = 1.5f;
            flammabilityScale = 0f;
            size = 2;
            crushDamageMultiplier = 0.05f;
            buildCostMultiplier = 4f;
        }};

        silicideOverflowGate = new OverflowGate("silicide-overflow-gate") {{
            requirements(Category.distribution, ItemStack.with(Items.copper, 6, Items.lead, 4, VeItems.silicide, 3));
            health = 370;
            armor = 16f;
            explosivenessScale = 1.5f;
            flammabilityScale = 0f;
            crushDamageMultiplier = 0.05f;
            buildCostMultiplier = 3f;
        }};

        silicideUnderflowGate = new OverflowGate("silicide-underflow-gate") {{
            requirements(Category.distribution, ItemStack.with(Items.copper, 6, Items.lead, 4, VeItems.silicide, 3));
            invert = true;
            health = 370;
            armor = 16f;
            explosivenessScale = 1.5f;
            flammabilityScale = 0f;
            crushDamageMultiplier = 0.05f;
            buildCostMultiplier = 3f;
        }};

        silicideUnloader = new Unloader("silicide-unloader") {{
            requirements(Category.distribution, ItemStack.with(Items.graphite, 10, Items.titanium, 25, Items.silicon, 15, VeItems.silicide, 5));
            speed = 4f;
            health = 370;
            armor = 16f;
            size = 1; // -
            explosivenessScale = 1.5f;
            flammabilityScale = 0f;
            group = BlockGroup.transportation;
            crushDamageMultiplier = 0.05f;
        }};

        ductJunction = new DuctJunction("duct-junction") {{
            requirements(Category.distribution, ItemStack.with(Items.beryllium, 3));
            speed = 4f;
            health = 120;
        }};

        rail = new Conveyor("rail") {{
            requirements(Category.distribution, ItemStack.with(VeItems.aluminium, 1));
            speed = 0.09f;
            displayedSpeed = 12f; // 60f * 0.09f / 0.4f = 13.5f, 实测120帧下在12.5到13.0之间波动
            pushUnits = false;
            ambientSound = Sounds.none;
            health = 25;
            researchCostMultiplier = 0.125f;
            drawCracks = false;
            hasShadow = false;
            drawTeamOverlay = false;
            }};

        railJunction = new Junction("rail-junction") {{
            requirements(Category.distribution, ItemStack.with(VeItems.aluminium, 2));
            speed = 10f;
            capacity = 5;
            displayedSpeed = 24f; // 60f / 10f * 5 = 30f 实测30帧下稳定25.0
            researchCostMultiplier = 0.1f;
            buildCostMultiplier = 6f;
            squareSprite = false;
            ((Conveyor) VeBlocks.rail).junctionReplacement = this;
        }};

        railBridge = new ItemBridge("rail-bridge") {{
            requirements(Category.distribution, ItemStack.with(Items.lead, 8, VeItems.aluminium, 8));
            range = 4;
            transportTime = 2f;
            fadeIn = false;
            moveArrows = false;
            arrowSpacing = 2f;
            arrowPeriod = 1.6f;
            arrowTimeScl = 3f;
            bridgeWidth = 8f;
            itemCapacity = 10; // -
            hasPower = false;
            health = 80;
            researchCostMultiplier = 0.1f;
            buildCostMultiplier = 3f;
            squareSprite = false;
            ((Conveyor) VeBlocks.rail).bridgeReplacement = this;
        }};

        railRouter = new DuctRouter("rail-router") {{
            requirements(Category.distribution, ItemStack.with(Items.lead, 4, VeItems.aluminium, 4));
            speed = 2.5f;
            solid = false; // -
            researchCostMultiplier = 0.2f;
            buildCostMultiplier = 4f;
            squareSprite = false;
            regionRotated1 = 1;
        }};

        railOverflowGate = new OverflowDuct("rail-overflow-gate") {{
            requirements(Category.distribution, ItemStack.with(Items.lead, 2, VeItems.aluminium, 4));
            speed = 2.5f;
            solid = false; // -
            researchCostMultiplier = 0.1f;
            buildCostMultiplier = 4f;
            squareSprite = false;
        }};

        railUnderflowGate = new OverflowDuct("rail-underflow-gate") {{
            requirements(Category.distribution, ItemStack.with(Items.lead, 2, VeItems.aluminium, 4));
            speed = 2.5f;
            invert = true;
            solid = false; // -
            researchCostMultiplier = 0.1f;
            buildCostMultiplier = 4f;
            squareSprite = false;
        }};

        railUnloader = new DirectionalUnloader("rail-unloader") {{
            requirements(Category.distribution, ItemStack.with(Items.graphite, 10, Items.silicon, 10));
            speed = 2.5f;
            allowCoreUnload = true;
            solid = false;
            researchCostMultiplier = 0.1f;
            buildCostMultiplier = 3f;
            squareSprite = false;
            regionRotated1 = 1;
        }};

        silicideRail = new Conveyor("silicide-rail") {{
            requirements(Category.distribution, ItemStack.with(VeItems.aluminium, 1, VeItems.silicide, 1));
            speed = 0.12f;
            displayedSpeed = 15f; // 60f * 0.12f / 0.4f = 18f, 实测30帧下稳定15.0
            pushUnits = false;
            ambientSound = Sounds.none;
            health = 230;
            armor = 24f;
            explosivenessScale = 1.5f;
            flammabilityScale = 0f;
            crushDamageMultiplier = 0.05f;
            drawCracks = false;
            drawTeamOverlay = false;
            hasShadow = false;
        }};

        silicideRailJunction = new Junction("silicide-rail-junction") {{
            requirements(Category.distribution, ItemStack.with(VeItems.aluminium, 2, VeItems.silicide, 1));
            speed = 10f;
            capacity = 10;
            displayedSpeed = 54f; // 60f / 10f * 10 = 60f, 实测60帧下在54.5到55.0之间波动
            health = 280;
            armor = 24f;
            explosivenessScale = 1.5f;
            flammabilityScale = 0f;
            researchCostMultiplier = 0.1f;
            buildCostMultiplier = 6f;
            crushDamageMultiplier = 0.05f;
            squareSprite = false;
            ((Conveyor) VeBlocks.silicideRail).junctionReplacement = this;
        }};

        silicideRailBridge = new ItemBridge("silicide-rail-bridge") {{
            requirements(Category.distribution, ItemStack.with(Items.lead, 8, VeItems.aluminium, 8, VeItems.silicide, 5));
            range = 4;
            transportTime = 1f;
            fadeIn = false;
            moveArrows = false;
            arrowSpacing = 2f;
            arrowPeriod = 1.6f;
            arrowTimeScl = 3f;
            bridgeWidth = 8f;
            itemCapacity = 10; // -
            hasPower = false;
            health = 400;
            armor = 24f;
            explosivenessScale = 1.5f;
            flammabilityScale = 0f;
            researchCostMultiplier = 0.1f;
            buildCostMultiplier = 3f;
            crushDamageMultiplier = 0.05f;
            squareSprite = false;
            ((Conveyor) VeBlocks.silicideRail).bridgeReplacement = this;
        }};

        silicideRailRouter = new DuctRouter("silicide-rail-router") {{
            requirements(Category.distribution, ItemStack.with(Items.lead, 4, VeItems.aluminium, 4, VeItems.silicide, 3));
            speed = 1.5f;
            solid = false; // -
            health = 340;
            armor = 24f;
            explosivenessScale = 1.5f;
            flammabilityScale = 0f;
            researchCostMultiplier = 0.1f;
            buildCostMultiplier = 4f;
            crushDamageMultiplier = 0.05f;
            squareSprite = false;
            regionRotated1 = 1;
        }};

        silicideRailOverflowGate = new OverflowDuct("silicide-rail-overflow-gate") {{
            requirements(Category.distribution, ItemStack.with(Items.lead, 2, VeItems.aluminium, 4, VeItems.silicide, 3));
            speed = 1.5f;
            solid = false; // -
            health = 340;
            armor = 24f;
            explosivenessScale = 1.5f;
            flammabilityScale = 0f;
            researchCostMultiplier = 0.1f;
            buildCostMultiplier = 4f;
            crushDamageMultiplier = 0.05f;
            squareSprite = false;
        }};

        silicideRailUnderflowGate = new OverflowDuct("silicide-rail-underflow-gate") {{
            requirements(Category.distribution, ItemStack.with(Items.lead, 2, VeItems.aluminium, 4, VeItems.silicide, 3));
            speed = 1.5f;
            invert = true;
            solid = false; // -
            health = 340;
            armor = 24f;
            explosivenessScale = 1.5f;
            flammabilityScale = 0f;
            researchCostMultiplier = 0.1f;
            buildCostMultiplier = 4f;
            crushDamageMultiplier = 0.05f;
            squareSprite = false;
        }};

        silicideRailUnloader = new DirectionalUnloader("silicide-rail-unloader") {{
            requirements(Category.distribution, ItemStack.with(Items.graphite, 10, Items.silicon, 10, VeItems.silicide, 5));
            speed = 1.5f;
            allowCoreUnload = true;
            solid = false;
            health = 400;
            armor = 24f;
            explosivenessScale = 1.5f;
            flammabilityScale = 0f;
            researchCostMultiplier = 0.1f;
            buildCostMultiplier = 3f;
            crushDamageMultiplier = 0.05f;
            squareSprite = false;
            regionRotated1 = 1;
        }};

        chromiumConveyor = new ArmoredConveyor("chromium-conveyor") {{
            requirements(Category.distribution, ItemStack.with(Items.lead, 1, VeItems.chromium, 1));
            speed = 0.12f;
            displayedSpeed = 15f; // 60f * 0.12f / 0.4f = 18f, 实测30帧下稳定15.0
            junctionReplacement = VeBlocks.railJunction;
            bridgeReplacement = VeBlocks.railBridge;
            health = 300;
            armor = 10f;
            buildCostMultiplier = 3f;
            crushDamageMultiplier = 0.2f;
            hasShadow = true;
        }};

        chromiumSorter = new Sorter("chromium-sorter") {{
            requirements(Category.distribution, ItemStack.with(Items.lead, 4, VeItems.chromium, 4));
            health = 120;
            buildCostMultiplier = 3f;
            crushDamageMultiplier = 0.2f;
        }};

        cobaltRail = new Conveyor("cobalt-rail") {{
            requirements(Category.distribution, ItemStack.with(Items.graphite, 1, VeItems.cobalt, 1));
            speed = 0.21f;
            displayedSpeed = 24f; // 60f * 0.21f / 0.4f = 31.5f 实测60帧下稳定30.0, 但不同帧率运力变化规律不明显
            pushUnits = false;
            junctionReplacement = VeBlocks.railJunction;
            ambientSound = Sounds.none;
            health = 35;
            researchCostMultiplier = 0.8f;
            drawCracks = false;
            drawTeamOverlay = false;
            hasShadow = false;
        }};

        cobaltRailBridge = new ItemBridge("cobalt-rail-bridge") {{
            requirements(Category.distribution, ItemStack.with(Items.lead, 10, VeItems.cobalt, 10));
            range = 7;
            transportTime = 1f;
            fadeIn = false;
            moveArrows = false;
            arrowSpacing = 2f;
            arrowPeriod = 1.6f;
            arrowTimeScl = 3f;
            bridgeWidth = 8f;
            itemCapacity = 10; // -
            hasPower = false;
            health = 150;
            researchCostMultiplier = 0.1f;
            buildCostMultiplier = 3f;
            crushDamageMultiplier = 0.2f;
            drawCracks = false;
            drawTeamOverlay = false;
            squareSprite = false;
            hasShadow = true;
            ((Conveyor) VeBlocks.cobaltRail).bridgeReplacement = this;
        }};

        cobaltRailUnderflowGate = new OverflowGate("cobalt-rail-underflow-gate") {{
            requirements(Category.distribution, ItemStack.with(Items.lead, 2, VeItems.cobalt, 4));
            invert = true;
            buildCostMultiplier = 3f;
            squareSprite = false;
        }};

        cobaltRailUnloader = new Unloader("cobalt-rail-unloader") {{
            requirements(Category.distribution, ItemStack.with(Items.graphite, 10, Items.silicon, 15, VeItems.cobalt, 10));
            speed = 2.5f;
            size = 1; // -
            group = BlockGroup.transportation;
            squareSprite = false;
        }};

        stackRail = new StackConveyor("stack-rail") {{
            requirements(Category.distribution, ItemStack.with(Items.graphite, 1, Items.silicon, 1, VeItems.aluminium, 2));
            speed = 0.08f;
            itemCapacity = 10; // -
            ambientSound = Sounds.none;
            health = 200;
            drawTeamOverlay = false;
        }};

        silicideStackRail = new StackConveyor("silicide-stack-rail") {{
            requirements(Category.distribution, ItemStack.with(Items.graphite, 1, Items.silicon, 1, VeItems.silicide, 2));
            speed = 0.12f;
            itemCapacity = 10; // -
            ambientSound = Sounds.none;
            health = 500;
            armor = 24f;
            explosivenessScale = 1.5f;
            flammabilityScale = 0f;
            underBullets = true;
            crushDamageMultiplier = 0.05f;
            dumpTime = 1;
            drawTeamOverlay = false;
        }};

        phaseUnloader = new Unloader("phase-unloader") {{
            requirements(Category.distribution, ItemStack.with(Items.graphite, 25, Items.silicon, 30, Items.plastanium, 25, Items.phaseFabric, 15));
            speed = 1f;
            // health = 200;
            size = 1; // -
            group = BlockGroup.transportation;
        }};

        multiUnloader = new Unloader("multi-unloader") {{
            requirements(Category.distribution, ItemStack.with(Items.lead, 40, Items.graphite, 50, Items.silicon, 50, VeItems.cobalt, 40));
            speed = 1f;
            health = 500;
            size = 3;
            researchCostMultiplier = 0.4f;
            group = BlockGroup.transportation;
            dumpTime = 1;
            squareSprite = false;
        }};

        massLauncher = new MassDriver("mass-launcher") {{
            requirements(Category.distribution, ItemStack.with(Items.lead, 60, Items.silicon, 55, VeItems.silicide, 30));
            range = 320f;
            rotateSpeed = 5f; // -
            minDistribute = 30;
            reload = 120f;
            bulletSpeed = 9f;
            shootEffect = new MultiEffect(
                    Fx.shootBig,
                    new ExplosionEffect() {{
                        waveColor = Color.valueOf("ffd37f");
                        sparkColor = Color.valueOf("ffd37f");
                        waveStroke = 3f; // -
                        waveRad = 18f;
                    }}
            );
            smokeEffect = Fx.shootBigSmoke;
            shootSound = Sounds.shootSalvo;
            shake = 3f; // -
            size = 2;
            researchCostMultiplier = 0.03f;
            itemCapacity = 90;
            consumePower(1f);
        }};

        massRailgun = new MassDriver("mass-railgun") {{
            requirements(Category.distribution, ItemStack.with(Items.lead, 170, Items.silicon, 115, VeItems.silicide, 60, VeItems.cobalt, 85));
            range = 960f;
            rotateSpeed = 2.5f;
            minDistribute = 60;
            reload = 180f;
            bullet = new MassDriverBolt() {{
                height = 30f;
                despawnEffect = Fx.mineHuge;
            }};
            bulletSpeed = 15f;
            shootEffect = new MultiEffect(
                    Fx.blastExplosion,
                    Fx.shootTitan,
                    new ExplosionEffect() {{
                        waveColor = Color.valueOf("ffd37f");
                        sparkColor = Color.valueOf("ffd37f");
                        waveStroke = 3f; // -
                        waveRad = 24f;
                    }}
            );
            smokeEffect = Fx.shootBigSmoke;
            shootSound = Sounds.massdriver; // -
            shake = 5f;
            size = 4;
            researchCostMultiplier = 0.03f;
            itemCapacity = 360;
            hasLiquids = true;
            liquidCapacity = 90f;
            dumpTime = 1;
            consumeLiquid(Liquids.water, 12f / 60f);
            consumePower(192f / 60f);
        }};

        warpDriver = new MassDriver("warp-driver") {{
            requirements(Category.distribution, ItemStack.with(Items.silicon, 30, VeItems.aluminium, 20, VeItems.warpNucleus, 10));
            range = 240f;
            rotateSpeed = 360f;
            translation = 0f;
            minDistribute = 10; // -
            knockback = 0f;
            reload = 40f;
            bullet = new MassDriverBolt() {{
                width = 0f;
                height = 0f;
                speed = 800f;
                hitEffect = Fx.none;
                despawnEffect = Fx.none;
                backColor = frontColor = Color.valueOf("bf92f900");
                collides = hittable = reflectable = absorbable = false;
                hitSize = 1f;
            }};
            bulletSpeed = 800f;
            shootEffect = new MultiEffect(
                    new SoundEffect() {{
                        sound = new RandomSound(
                                VeSounds.get("si2Teleporter1"),
                                VeSounds.get("si2Teleporter2"),
                                VeSounds.get("si2Teleporter3"),
                                VeSounds.get("si2Teleporter4")
                        );
                        minPitch = 1f;
                        maxPitch = 1f;
                        minVolume = 0.1f;
                        maxVolume = 0.1f;
                        effect = new ParticleEffect() {{
                            colorFrom = Color.valueOf("bf92f9");
                            colorTo = Color.valueOf("bf92f9");
                            particles = 1;
                            length = 0f;
                            baseLength = 0f; // -
                            interp = Interp.circleIn;
                            sizeFrom = 2f; // -
                            sizeTo = 0f; // -
                            lifetime = 40f;
                        }};
                    }},
                    new WaveEffect() {{
                        colorFrom = Color.valueOf("bf92f9aa");
                        colorTo = Color.valueOf("bf92f900");
                        sizeFrom = 0f; // -
                        sizeTo = 12f;
                        sides = 24;
                        strokeFrom = 2f; // -
                        strokeTo = 0f; // -
                        interp = Interp.circleOut;
                        lifetime = 40f;
                    }},
                    new WaveEffect() {{
                        colorFrom = Color.valueOf("bf92f9");
                        colorTo = Color.valueOf("bf92f900");
                        sizeFrom = 0f; // -
                        sizeTo = 8f;
                        sides = 24;
                        strokeFrom = 2f; // -
                        strokeTo = 2f;
                        interp = Interp.circleOut;
                        lifetime = 40f;
                    }}
            );
            smokeEffect = Fx.none;
            receiveEffect = new SoundEffect() {{
                sound = new RandomSound(
                        VeSounds.get("si2Teleporter1"),
                        VeSounds.get("si2Teleporter2"),
                        VeSounds.get("si2Teleporter3"),
                        VeSounds.get("si2Teleporter4")
                );
                minPitch = 1f;
                maxPitch = 1f;
                minVolume = 0.1f;
                maxVolume = 0.1f;
                effect = new ParticleEffect() {{
                    colorFrom = Color.valueOf("bf92f9");
                    colorTo = Color.valueOf("bf92f9");
                    particles = 1;
                    cone = 0f;
                    length = 0f;
                    baseLength = 0f; // -
                    interp = Interp.circleOut;
                    sizeFrom = 2f; // -
                    sizeTo = 0f; // -
                    lifetime = 40f;
                }};
            }};
            shootSound = Sounds.none;
            receiveSound = Sounds.none;
            shake = 0f;
            outlineIcon = false;
            health = 300;
            baseExplosiveness = 7f;
            size = 1; // -
            researchCostMultiplier = 0.1f;
            buildCostMultiplier = 3f;
            itemCapacity = 100;
            dumpTime = 1;
            consumePower(36f / 60f);
        }};

        ferricConveyor = new Conveyor("ferric-conveyor") {{
            requirements(Category.distribution, ItemStack.with(VeItems.ferrum, 1));
            speed = 0.12f;
            displayedSpeed = 15f; // 60f * 0.12f / 0.4f = 18f, 实测30帧下稳定15.0
            health = 120;
            armor = 6f;
            buildCostMultiplier = 1.5f;
            crushDamageMultiplier = 0.2f;
            hasShadow = true;
        }};

        ferricConveyorArmored = new ArmoredConveyor("ferric-conveyor-armored") {{
            requirements(Category.distribution, ItemStack.with(VeItems.ferrum, 2));
            speed = 0.12f;
            displayedSpeed = 15f; // 60f * 0.12f / 0.4f = 18f, 实测30帧下稳定15.0
            health = 180;
            armor = 6f;
            buildCostMultiplier = 1.5f;
            crushDamageMultiplier = 0.2f;
            hasShadow = true;
        }};

        ferricRail = new ArmoredConveyor("ferric-rail") {{
            requirements(Category.distribution, ItemStack.with(VeItems.aluminium, 1, VeItems.ferrum, 1));
            speed = 0.12f;
            displayedSpeed = 15f; // 60f * 0.12f / 0.4f = 18f, 实测30帧下稳定15.0
            pushUnits = false;
            ambientSound = Sounds.none;
            health = 120;
            armor = 6f;
            crushDamageMultiplier = 0.2f;
            drawCracks = false;
            drawTeamOverlay = false;
            hasShadow = false;
        }};

        /*
        magneticDuct = new Duct("magnetic-duct") {{
            requirements(Category.distribution, ItemStack.with(VeItems.astroPlate, 1, VeItems.phecteel, 1));
            speed = 1f;
            armored = ;
            transparentColor = Color.valueOf("");
            bridgeReplacement = Blocks.;
            junctionReplacement = Blocks.;
            health = 300;
            armor = 32f;
            crushDamageMultiplier = 0f;
            // hidden = true;
        }};
        */

        valveCross = new Junction("valve-cross") {{
            requirements(Category.distribution, ItemStack.with(VeItems.ferrum, 2));
            speed = 10f;
            capacity = 5;
            displayedSpeed = 25f; // 60f / 10f * 5 = 30f, 实测30帧下稳定25.0
            buildCostMultiplier = 4f;
            ((Conveyor) VeBlocks.ferricConveyor).junctionReplacement =
                    ((ArmoredConveyor) VeBlocks.ferricConveyorArmored).junctionReplacement =
                            ((ArmoredConveyor) VeBlocks.ferricRail).junctionReplacement = this;
        }};

        ferricBridge = new ItemBridge("ferric-bridge") {{
            requirements(Category.distribution, ItemStack.with(Items.graphite, 4, VeItems.ferrum, 6));
            range = 4;
            transportTime = 2f;
            fadeIn = false;
            moveArrows = false;
            arrowSpacing = 8f;
            arrowOffset = 4f;
            arrowPeriod = 1.6f;
            arrowTimeScl = 2f;
            bridgeWidth = 8f;
            itemCapacity = 10; // -
            hasPower = false;
            health = 300;
            armor = 6f;
            researchCostMultiplier = 0.1f;
            buildCostMultiplier = 3f;
            squareSprite = false;
            ((Conveyor) VeBlocks.ferricConveyor).bridgeReplacement =
                    ((ArmoredConveyor) VeBlocks.ferricConveyorArmored).bridgeReplacement =
                            ((ArmoredConveyor) VeBlocks.ferricRail).bridgeReplacement = this;
        }};

        valveSort = new Sorter("valve-sort") {{
            requirements(Category.distribution, ItemStack.with(Items.silicon, 2, VeItems.ferrum, 3));
            health = 120;
            armor = 6f;
            buildCostMultiplier = 3f;
            crushDamageMultiplier = 0.2f;
        }};

        valveInvertedSort = new Sorter("valve-inverted-sort") {{
            requirements(Category.distribution, ItemStack.with(Items.silicon, 2, VeItems.ferrum, 3));
            invert = true;
            health = 120;
            armor = 6f;
            buildCostMultiplier = 3f;
            crushDamageMultiplier = 0.2f;
        }};

        valveDistribute = new Router("valve-distribute") {{
            requirements(Category.distribution, ItemStack.with(VeItems.ferrum, 4));
            speed = 2f;
            health = 120;
            armor = 6f;
            buildCostMultiplier = 4f;
            crushDamageMultiplier = 0.2f;
        }};

        valveOverflow = new OverflowGate("valve-overflow") {{
            requirements(Category.distribution, ItemStack.with(Items.silicon, 1, VeItems.ferrum, 4));
            health = 120;
            armor = 6f;
            buildCostMultiplier = 3f;
            crushDamageMultiplier = 0.2f;
        }};

        valveUnderflow = new OverflowGate("valve-underflow") {{
            requirements(Category.distribution, ItemStack.with(Items.silicon, 1, VeItems.ferrum, 4));
            invert = true;
            health = 120;
            armor = 6f;
            buildCostMultiplier = 3f;
            crushDamageMultiplier = 0.2f;
        }};

        valveUnload = new Unloader("valve-unload") {{
            requirements(Category.distribution, ItemStack.with(Items.silicon, 15, VeItems.ferrum, 15));
            speed = 2f;
            health = 400;
            armor = 6f;
            size = 1; // -
            group = BlockGroup.transportation;
            crushDamageMultiplier = 0.2f;
        }};

        isomorphicPump = new Pump("isomorphic-pump") {{
            requirements(Category.liquid, ItemStack.with(Items.metaglass, 12, VeItems.aluminium, 10));
            pumpAmount = 8f / 60f;
            warmupSpeed = 0.015f;
            researchCostMultiplier = 0.1f;
            squareSprite = false;
        }};

        platformPump = new Pump("platform-pump") {{
            requirements(Category.liquid, ItemStack.with(Items.lead, 20, Items.metaglass, 50, VeItems.chromium, 60));
            pumpAmount = 15f / 60f;
            warmupSpeed = 0.02f;
            health = 335;
            armor = 6f;
            size = 2;
            researchCostMultiplier = 0.5f;
            placeableLiquid = true;
            floating = true;
            crushDamageMultiplier = 0.2f;
            liquidCapacity = 300f;
            hasPower = true;
            conductivePower = true;
            consume(new ConsumeCoolant(0f) {{
                maxTemp = 10f;
                maxFlammability = 10f;
                optional = true;
                booster = false;
            }});
            consumePower(18f / 60f);
            squareSprite = false;
        }};

        pressurePump = new Pump("pressure-pump") {{
            requirements(Category.liquid, ItemStack.with(Items.lead, 30, VeItems.chromium, 40));
            pumpAmount = 24f / 60f;
            warmupSpeed = 0.02f;
            armor = 5f;
            size = 2;
            researchCostMultiplier = 0.3f;
            crushDamageMultiplier = 0.2f;
            liquidCapacity = 150f;
            hasPower = true;
            consumePower(30f / 60f);
            squareSprite = false;
        }};

        isomorphicConduit = new Conduit("isomorphic-conduit") {{
            requirements(Category.liquid, ItemStack.with(VeItems.aluminium, 2));
            health = 40;
            drawTeamOverlay = false;
        }};

        fluidJunction = new LiquidJunction("fluid-junction") {{
            requirements(Category.liquid, ItemStack.with(Items.graphite, 4, VeItems.aluminium, 12));
            health = 40;
            solid = false;
            ((Conduit) VeBlocks.isomorphicConduit).junctionReplacement = this;
        }};

        isomorphicBridgeConduit = new LiquidBridge("isomorphic-bridge-conduit") {{
            requirements(Category.liquid, ItemStack.with(Items.graphite, 4, VeItems.aluminium, 20));
            range = 4;
            fadeIn = false;
            moveArrows = false;
            arrowSpacing = 2f;
            arrowPeriod = 1.6f;
            arrowTimeScl = 3f;
            bridgeWidth = 8f;
            health = 40;
            buildCostMultiplier = 3f;
            hasPower = false;
            squareSprite = false;
            ((Conduit) VeBlocks.isomorphicConduit).bridgeReplacement = this;
        }};

        fluidRouter = new LiquidRouter("fluid-router") {{
            requirements(Category.liquid, ItemStack.with(Items.graphite, 4, VeItems.aluminium, 8));
            liquidPadding = 2f; // 0f 液体填充
            health = 40;
            liquidCapacity = 80f;
            squareSprite = true;
        }};

        can = new LiquidRouter("can") {{
            requirements(Category.liquid, ItemStack.with(Items.metaglass, 10, VeItems.chromium, 15));
            armor = 6f;
            size = 2;
            solid = true;
            liquidCapacity = 800f;
            squareSprite = true;
        }};

        tank = new LiquidRouter("tank") {{
            requirements(Category.liquid, ItemStack.with(Items.metaglass, 20, VeItems.chromium, 50));
            armor = 6f;
            size = 3;
            solid = true;
            liquidCapacity = 2200f;
            squareSprite = true;
        }};

        pressureConduit = new ArmoredConduit("pressure-conduit") {{
            requirements(Category.liquid, ItemStack.with(Items.metaglass, 1, VeItems.chromium, 1));
            junctionReplacement = VeBlocks.fluidJunction;
            bridgeReplacement = VeBlocks.isomorphicBridgeConduit;
            health = 230;
            armor = 16f;
            crushDamageMultiplier = 0.2f;
            liquidCapacity = 80f;
            liquidPressure = 5f;
            drawTeamOverlay = false;
        }};

        platformBridgeConduit = new LiquidBridge("platform-bridge-conduit") {{
            requirements(Category.liquid, ItemStack.with(Items.graphite, 10, VeItems.chromium, 10));
            range = 8;
            fadeIn = false;
            moveArrows = false;
            arrowSpacing = 2f;
            arrowPeriod = 1.6f;
            arrowTimeScl = 3f;
            bridgeWidth = 8f;
            health = 300;
            armor = 6f;
            placeableLiquid = true;
            floating = true;
            buildCostMultiplier = 3f;
            liquidCapacity = 150f;
            hasPower = false;
            squareSprite = false;
        }};

        silicidePlatedConduit = new ArmoredConduit("silicide-plated-conduit") {{
            requirements(Category.liquid, ItemStack.with(Items.metaglass, 1, Items.titanium, 1, Items.thorium, 1, VeItems.silicide, 1));
            health = 460;
            armor = 16f;
            explosivenessScale = 0.25f;
            flammabilityScale = 0f;
            liquidCapacity = 16f;
            liquidPressure = 1.025f;
            crushDamageMultiplier = 0.05f;
        }};

        silicideConduit = new Conduit("silicide-conduit") {{
            requirements(Category.liquid, ItemStack.with(Items.metaglass, 1, Items.titanium, 1, VeItems.silicide, 1));
            health = 280;
            armor = 16f;
            explosivenessScale = 0.25f;
            flammabilityScale = 0f;
            liquidCapacity = 16f;
            liquidPressure = 1.025f;
            crushDamageMultiplier = 0.05f;
            drawTeamOverlay = false;
        }};

        silicideFluidJunction = new LiquidJunction("silicide-fluid-junction") {{
            requirements(Category.liquid, ItemStack.with(Items.metaglass, 8, Items.graphite, 4, Items.titanium, 4, VeItems.silicide, 4));
            health = 370;
            armor = 16f;
            explosivenessScale = 0.25f;
            flammabilityScale = 0f;
            solid = false;
            crushDamageMultiplier = 0.05f;
            ((ArmoredConduit) VeBlocks.silicidePlatedConduit).junctionReplacement =
                    ((Conduit) VeBlocks.silicideConduit).junctionReplacement = this;
        }};

        silicideBridgeConduit = new LiquidBridge("silicide-bridge-conduit") {{
            requirements(Category.liquid, ItemStack.with(Items.metaglass, 8, Items.graphite, 4, Items.titanium, 6, VeItems.silicide, 6));
            range = 4;
            fadeIn = false;
            moveArrows = false;
            arrowSpacing = 6f;
            health = 370;
            armor = 16f;
            explosivenessScale = 0.25f;
            flammabilityScale = 0f;
            buildCostMultiplier = 3f;
            crushDamageMultiplier = 0.05f;
            liquidCapacity = 70f;
            hasPower = false;
            ((ArmoredConduit) VeBlocks.silicidePlatedConduit).bridgeReplacement =
                    ((Conduit) VeBlocks.silicideConduit).bridgeReplacement = this;
        }};

        silicideFluidRouter = new LiquidRouter("silicide-fluid-router") {{
            requirements(Category.liquid, ItemStack.with(Items.metaglass, 2, Items.graphite, 4, Items.titanium, 4, VeItems.silicide, 4));
            health = 370;
            armor = 16f;
            explosivenessScale = 0.25f;
            flammabilityScale = 0f;
            solid = false;
            underBullets = true;
            crushDamageMultiplier = 0.05f;
            liquidCapacity = 200f;
        }};

        canSilicide = new LiquidRouter("can-silicide") {{
            requirements(Category.liquid, ItemStack.with(Items.metaglass, 10, VeItems.silicide, 30, VeItems.chromium, 30));
            health = 2000;
            armor = 24f;
            explosivenessScale = 0.25f;
            flammabilityScale = 0f;
            size = 2;
            solid = true;
            crushDamageMultiplier = 0.05f;
            liquidCapacity = 800f;
        }};

        tankSilicide = new LiquidRouter("tank-silicide") {{
            requirements(Category.liquid, ItemStack.with(Items.metaglass, 20, VeItems.silicide, 50, VeItems.chromium, 90));
            health = 4500;
            armor = 24f;
            explosivenessScale = 0.25f;
            flammabilityScale = 0f;
            size = 3;
            solid = true;
            crushDamageMultiplier = 0.05f;
            liquidCapacity = 2200f;
        }};

        chainedPump = new Pump("chained-pump") {{
            requirements(Category.liquid, ItemStack.with(VeItems.ferrum, 10, VeItems.silver, 20));
            pumpAmount = 9f / 60f;
            armor = 4f;
            size = 1; // -
            researchCostMultiplier = 0.1f;
            placeableLiquid = true;
            floating = true;
            liquidCapacity = 50f;
            hasPower = false;
            consume(new ConsumeCoolant(0f) {{
                maxTemp = 10f;
                maxFlammability = 10f;
                optional = true;
                booster = false;
            }});
            squareSprite = false;
        }};

        silverConduit = new Conduit("silver-conduit") {{
            requirements(Category.liquid, ItemStack.with(VeItems.silver, 1));
            health = 40;
            liquidCapacity = 30f;
            drawTeamOverlay = false;
        }};

        silverConduitArmored = new ArmoredConduit("silver-conduit-armored") {{
            requirements(Category.liquid, ItemStack.with(VeItems.ferrum, 1, VeItems.silver, 1));
            leaks = true;
            health = 120;
            armor = 6f;
            liquidCapacity = 30f;
            drawTeamOverlay = false;
        }};

        valveFluidCross = new LiquidJunction("valve-fluid-cross") {{
            requirements(Category.liquid, ItemStack.with(VeItems.silver, 2));
            health = 40;
            solid = false;
            ((Conduit) VeBlocks.silverConduit).junctionReplacement =
                    ((ArmoredConduit) VeBlocks.silverConduitArmored).junctionReplacement = this;
        }};

        silverBridge = new LiquidBridge("silver-bridge") {{
            requirements(Category.liquid, ItemStack.with(Items.graphite, 6, VeItems.silver, 10));
            range = 4;
            fadeIn = false;
            moveArrows = false;
            arrowSpacing = 8f;
            arrowOffset = 4f;
            arrowPeriod = 1.6f;
            arrowTimeScl = 2f;
            bridgeWidth = 8f;
            health = 40;
            buildCostMultiplier = 3f;
            hasPower = false;
            ((Conduit) VeBlocks.silverConduit).bridgeReplacement =
                    ((ArmoredConduit) VeBlocks.silverConduitArmored).bridgeReplacement = this;
        }};

        valveFluidDistribute = new LiquidRouter("valve-fluid-distribute") {{
            requirements(Category.liquid, ItemStack.with(VeItems.silver, 6));
            health = 40;
            liquidCapacity = 100f;
            squareSprite = false;
        }};

        advancedNode = new BeamNode("advanced-node") {{
            requirements(Category.power, ItemStack.with(Items.lead, 4, VeItems.quartz, 3));
            range = 12;
            laserColor2 = Color.valueOf("ffd37f");
            laserWidth = 0.25f;
            researchCostMultiplier = 0.01f;
            drawTeamOverlay = false;
        }};

        advancedNodeLarge = new BeamNode("advanced-node-large") {{
            requirements(Category.power, ItemStack.with(Items.lead, 40, Items.silicon, 35, VeItems.quartz, 50));
            range = 28;
            laserColor2 = Color.valueOf("ffd37f");
            laserWidth = 0.5f;
            armor = 4f;
            size = 3;
            researchCostMultiplier = 0.3f;
            drawTeamOverlay = false;
        }};

        isomorphicNode = new PowerNode("isomorphic-node") {{
            requirements(Category.power, ItemStack.with(Items.lead, 2, VeItems.quartz, 5));
            laserRange = 6f; // -
            maxNodes = 10;
            researchCostMultiplier = 0.01f;
            drawTeamOverlay = false;
        }};

        isomorphicNodeLarge = new PowerNode("isomorphic-node-large") {{
            requirements(Category.power, ItemStack.with(Items.lead, 10, Items.metaglass, 5, Items.graphite, 5, VeItems.quartz, 30));
            laserRange = 18f;
            maxNodes = 15;
            health = 160;
            armor = 4f;
            size = 2;
            placeableLiquid = true;
            researchCostMultiplier = 0.3f;
            drawTeamOverlay = false;
        }};

        insulatedNode = new PowerNode("insulated-node") {{
            requirements(Category.power, ItemStack.with(Items.lead, 5, VeItems.quartz, 10));
            laserRange = 16f;
            maxNodes = 3; // -
            autolink = false;
            drawRange = true; // -
            health = 300;
            insulated = true;
            absorbLasers = true;
            researchCostMultiplier = 1f; // -
            conductivePower = false;
            drawTeamOverlay = false;
        }};

        sectorPowerTower = new LongPowerNode("sector-power-tower") {{
            requirements(Category.power, ItemStack.with(Items.graphite, 500, Items.silicon, 250, Items.plastanium, 300, VeItems.aluminium, 800, VeItems.quartz, 500, VeItems.silicide, 100));
            glowColor = Color.valueOf("fbd367dd");
            glowMag = 0.8f;
            laserRange = 4000f;
            maxNodes = 10;
            autolink = false;
            laserScale = 1.2f;
            laserColor1 = Color.valueOf("ffffff");
            laserColor2 = Color.valueOf("fbd367");
            health = 10000;
            armor = 24f;
            baseExplosiveness = 3f;
            size = 5;
            researchCostMultiplier = 0.5f;
            underBullets = false;
            buildCostMultiplier = 0.5f;
            drawTeamOverlay = false;
        }};

        nodeBlocker = new Wall("node-blocker") {{
            requirements(Category.power, ItemStack.with(VeItems.quartz, 4));
            insulated = true;
            absorbLasers = false; // -
            health = 40;
            researchCostMultiplier = 1f; // -
            schematicPriority = 10;
            buildCostMultiplier = 1f;
        }};

        powerBattery = new Battery("power-battery") {{
            requirements(Category.power, ItemStack.with(Items.lead, 25, VeItems.aluminium, 6));
            consumePowerBuffered(5000f);
            baseExplosiveness = 1f;
            researchCostMultiplier = 0.1f;
        }};

        silicideBattery = new Battery("silicide-battery") {{
            requirements(Category.power, ItemStack.with(Items.lead, 80, Items.graphite, 20, Items.silicon, 20, VeItems.silicide, 40));
            consumePowerBuffered(25000f);
            health = 4200;
            armor = 8f;
            baseExplosiveness = 2f;
            size = 2;
            priority = TargetPriority.under; // -2f
            buildCostMultiplier = 4f;
            solid = true; // -
            crushDamageMultiplier = 0.25f;
            hasPower = true; // -
            conductivePower = true;
        }};

        sodiumSulphurBattery = new Battery("sodium-sulphur-battery") {{
            requirements(Category.power, ItemStack.with(Items.graphite, 60, Items.silicon, 90, Items.pyratite, 80, VeItems.silicide, 100, VeItems.sodium, 80));
            consumePowerBuffered(200000f);
            health = 2000;
            armor = 24f;
            baseExplosiveness = 20f;
            size = 3;
            researchCostMultiplier = 0.5f;
            destroyBullet = new BasicBulletType() {{
                instantDisappear = true;
                splashDamage = 200f;
                splashDamageRadius = 48f;
                makeFire = true;
                hitEffect = Fx.shockwave;
                despawnEffect = Fx.shockwave;
                hitShake = 12f;
                despawnShake = 12f;
            }};
        }};


        // charger;


        discharger = new ConsumeGenerator("discharger") {{
            requirements(Category.power, ItemStack.with(Items.lead, 100, Items.graphite, 80, Items.silicon, 60, VeItems.chromium, 30));
            itemDuration = 10f;
            consumeEffect = new MultiEffect(
                    new ParticleEffect() {{
                        colorFrom = Color.valueOf("ffffff");
                        colorTo = Color.valueOf("f3e979");
                        particles = 4;
                        length = 20f; // -
                        baseLength = 0f; // -
                        line = true;
                        strokeFrom = 3f;
                        strokeTo = 0f; // -
                        lenFrom = 10f;
                        lenTo = 0f;
                        lifetime = 10f;
                    }},
                    new ParticleEffect() {{
                        colorFrom = Color.valueOf("ffffff44");
                        colorTo = Color.valueOf("ffffff00");
                        particles = 1;
                        length = 0f;
                        baseLength = 0f; // -
                        sizeFrom = 8f;
                        sizeTo = 8f;
                        region = "ve-discharger-heat";
                        lifetime = 60f;
                        layer = 30.1f;
                    }},
                    new SoundEffect(VeSounds.get("roSpark"), Fx.none) {{
                        minVolume = 0.2f;
                        maxVolume = 0.2f;
                    }}
            );
            powerProduction = 17850f / 60f;
//            drawer = new DrawMulti(
//                    new DrawDefault(),
//                    new DrawFade() {{
//                        suffix = "-heat";
//                    }},
//                    new DrawFlame(Color.valueOf("ffc59a")) {{
//                        flameRadius = 1.3f;
//                        flameRadiusIn = 1f;
//                    }}
//            );
            size = 2;
            researchCostMultiplier = 0.05f;
            itemCapacity = 10;
            consumeItem(VeItems.capacitor, 1);
            ambientSound = Sounds.loopHum;
            ambientSoundVolume = 0f;
            generateEffectRange = 0f;
        }};

        largeCombustionGenerator = new ConsumeGenerator("large-combustion-generator") {{
            requirements(Category.power, ItemStack.with(Items.lead, 45, VeItems.aluminium, 60));
            itemDuration = 60f;
            generateEffect = Fx.smeltsmoke;
            itemDurationMultipliers.put(Items.pyratite, 2f);
            itemDurationMultipliers.put(VeItems.plantMatter, 0.75f);
            itemDurationMultipliers.put(VeItems.nitroalkoss, 1.25f);
            itemDurationMultipliers.put(VeItems.reflectorMatter, 0.75f);
            powerProduction = 195f / 60f;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawFade() {{
                        suffix = "-heat";
                    }},
                    new DrawFlame(Color.valueOf("ffc59a")) {{
                        flameRadius = 1.3f;
                        flameRadiusIn = 1f;
                    }}
            );
            size = 2;
            researchCostMultiplier = 0.01f;
            consume(new ConsumeItemExplode(0.7f));
            consume(new ConsumeItemFlammable(1f));
            ambientSound = Sounds.loopSmelter;
            ambientSoundVolume = 0.06f;
        }};

        largeTurbineGenerator = new ConsumeGenerator("large-turbine-generator") {{
            requirements(Category.power, ItemStack.with(Items.lead, 60, Items.graphite, 50, Items.silicon, 40, VeItems.aluminium, 50));
            itemDuration = 75f;
            effectChance = 0.02f;
            generateEffect = Fx.generatespark;
            itemDurationMultipliers.put(Items.pyratite, 3f);
            itemDurationMultipliers.put(VeItems.plantMatter, 0.75f);
            itemDurationMultipliers.put(VeItems.nitroalkoss, 2f /* 0.9f */ );
            itemDurationMultipliers.put(VeItems.reflectorMatter, 0.75f);
            powerProduction = 465f / 60f;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(Liquids.water),
                    new DrawLiquidTile(Liquids.cryofluid),
                    new DrawRegion(""),
                    new DrawFade() {{
                        suffix = "-heat";
                    }},
                    new DrawRegion("-rotator2", -4f, true),
                    new DrawRegion("-rotator1", 2f, true),
                    new DrawRegion("-cap")
            );
            size = 3;
            researchCostMultiplier = 0.3f;
            itemCapacity = 20;
            hasLiquids = true;
            liquidCapacity = 40f;
            consume(new ConsumeItemExplode());
            consume(new ConsumeItemFlammable(1f));
            consumeLiquid(Liquids.water, 15f / 60f);
            ambientSound = Sounds.loopMachineSpin;
            ambientSoundVolume = 0.1f;
        }};

        geothermalGenerator = new ThermalGenerator("geothermal-generator") {{
            requirements(Category.power, ItemStack.with(Items.lead, 50, Items.graphite, 35, Items.silicon, 35, VeItems.aluminium, 40, VeItems.silicide, 40));
            generateEffect = Fx.redgeneratespark;
            effectChance = 0.011f;
            powerProduction = 108 / 60f;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawGlowRegion("-glow") {{
                        alpha = 0.7f;
                        glowIntensity = 0.2f;
                        color = Color.valueOf("ffa665");
                    }}
            );
            health = 160;
            armor = 6f;
            size = 2;
            researchCostMultiplier = 0.1f;
            floating = true;
            ambientSound = Sounds.loopDifferential;
            ambientSoundVolume = 0.06f;
        }};

        solarPad = new SolarGenerator("solar-pad") {{
            requirements(Category.power, ItemStack.with(VeItems.aluminium, 5, VeItems.catalyzon, 10));
            powerProduction = 48f / 60f;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawFade() {{
                        suffix = "-fade";
                        alpha = 1f;
                        scale = 120f;
                    }}
            );
            size = 2;
            solid = false;
            underBullets = true;
        }};

        lavaThermalGenerator = new ConsumeGenerator("lava-thermal-generator") {{
            requirements(Category.power, ItemStack.with(Items.metaglass, 80, Items.graphite, 100, Items.silicon, 60, VeItems.aluminium, 200, VeItems.silicide, 50));
            itemDuration = 120f; // -
            effectChance = 0.1f;
            generateEffect = Fx.fuelburn;
            consumeEffect = Fx.redgeneratespark;
            generateEffectRange = 10f;
            powerProduction = 1650f / 60f; // 630f / 60f
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawFade(),
                    new DrawGlowRegion("-glow") {{
                        glowIntensity = 0.2f;
                        color = Color.valueOf("ffa665");
                    }}
            );
            armor = 6f;
            size = 3;
            researchCostMultiplier = 0.1f;
            floating = false;
            hasLiquids = true;
            liquidCapacity = 60f;
            consumeLiquids(LiquidStack.with(VeLiquids.lava, 10f / 60f, Liquids.water, 24f / 60f));
            ambientSound = Sounds.loopDifferential;
            ambientSoundVolume = 0.15f;
        }};

        internalCombustionGenerator = new ConsumeGenerator("internal-combustion-generator") {{
            requirements(Category.power, ItemStack.with(Items.lead, 15, Items.graphite, 15, VeItems.chromium, 30));
            itemDuration = 60f;
            generateEffect = Fx.plasticburn;
            powerProduction = 132f / 60f;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(Liquids.oil),
                    new DrawDefault(),
                    new DrawWarmupRegion(),
                    new DrawRegion("-rotator", 44f) {{
                        rotation = -45f;
                    }},
                    new DrawRegion("-cap")
            );
            size = 2;
            buildCostMultiplier = 0.5f;
            hasLiquids = true;
            liquidCapacity = 30f;
            consumeLiquid(Liquids.oil, 2f / 60f);
            ambientSound = VeSounds.get("combustionClassic");
            ambientSoundVolume = 0.005f;
        }};

        sodiumReactor = new ConsumeGenerator("sodium-reactor") {{
            requirements(Category.power, ItemStack.with(Items.silicon, 20, VeItems.aluminium, 30, VeItems.chromium, 20));
            itemDuration = 40f;
            consumeEffect = Fx.plasticburn;
            baseLightRadius = 0f;
            outputLiquid = new LiquidStack(Liquids.hydrogen, 9f / 60f);
            explodeOnFull = true;
            powerProduction = 30f / 60f;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(Liquids.water, 2f),
                    new DrawBubbles(Color.valueOf("7693e3")) {{
                        amount = 15;
                        sides = 8; // -
                        spread = 4f;
                        recurrence = 3f;
                    }},
                    new DrawLiquidTile(Liquids.hydrogen),
                    new DrawRegion("")
            );
            group = BlockGroup.liquids;
            size = 2;
            researchCostMultiplier = 0.05f;
            hasItems = true;
            itemCapacity = 10;
            hasLiquids = true;
            liquidCapacity = 60f;
            consumeItem(VeItems.sodium, 1);
            consumeLiquid(Liquids.water, 15f / 60f);
            ambientSound = Sounds.loopSpray;
            ambientSoundVolume = 0.05f;
        }};


        /*
        solidFuelCell = new ConsumeGenerator("solid-fuel-cell") {{
            requirements(Category.power, ItemStack.with(Items.graphite, 40, Items.silicon, 20, VeItems.catalyzon, 15, VeItems.silicide, 30));
            itemDuration = 150f;
            generateEffect = Fx.generatespark;
            itemDurationMultipliers.put(Items.sporePod, 1.2f);
            itemDurationMultipliers.put(Items.pyratite, 3f);
            itemDurationMultipliers.put(VeItems.plantMatter, 1.5f);
            itemDurationMultipliers.put(VeItems.carbonShaleCobble, 1.8f);
            itemDurationMultipliers.put(VeItems.nitroalkoss, 8f); // 1.2f
            itemDurationMultipliers.put(VeItems.fusionFuel, 3.2f);
            itemDurationMultipliers.put(VeItems.reflectorMatter, 8f);
            itemDurationMultipliers.put(VeItems.melonDirt, 8f);
            itemDurationMultipliers.put(VeItems.sugar, 2.2f);
            powerProduction = 396f / 60f;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawWarmupRegion()
            );
            size = 2;
            consume(new ConsumeItemFlammable(0.3f));
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.1f;
        }};
        */
        solidFuelCell = new ConsumeGenerator("solid-fuel-cell") {{
            requirements(Category.power, ItemStack.with(Items.graphite, 40, Items.silicon, 20, VeItems.catalyzon, 15, VeItems.silicide, 30));
            itemDuration = 150f;
            generateEffect = Fx.generatespark;
            itemDurationMultipliers.put(Items.sporePod, 1.2f);
            itemDurationMultipliers.put(Items.pyratite, 3f);
            itemDurationMultipliers.put(VeItems.plantMatter, 1.5f);
            itemDurationMultipliers.put(VeItems.carbonShaleCobble, 1.8f);
            itemDurationMultipliers.put(VeItems.nitroalkoss, 8f); // 1.2f
            itemDurationMultipliers.put(VeItems.fusionFuel, 3.2f);
            itemDurationMultipliers.put(VeItems.reflectorMatter, 8f);
            itemDurationMultipliers.put(VeItems.melonDirt, 8f);
            itemDurationMultipliers.put(VeItems.sugar, 2.2f);
            powerProduction = 396f / 60f;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawWarmupRegion()
            );
            size = 2;
            consume(new ConsumeItemFlammable(0.3f));
            ambientSound = Sounds.none;
            ambientSoundVolume = 0.1f;
        }};


        fluidFuelCell = new ConsumeGenerator("fluid-fuel-cell") {{
            requirements(Category.power, ItemStack.with(Items.metaglass, 15, Items.graphite, 55, VeItems.catalyzon, 20, VeItems.chromium, 40));
            generateEffect = Fx.generatespark;
            powerProduction = 495f / 60f;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(Liquids.oil),
                    new DrawLiquidTile(Liquids.cyanogen),
                    new DrawLiquidTile(Liquids.ozone),
                    new DrawLiquidTile(Liquids.hydrogen),
                    new DrawRegion(""),
                    new DrawGlowRegion("-glow") {{
                        color = Color.valueOf("ffffff");
                    }}
            );
            size = 2;
            researchCostMultiplier = 0.1f;
            liquidCapacity = 60f;
            consume(new ConsumeLiquidFlammable(1f, 0.075f));
            ambientSound = Sounds.loopCircuit;
            ambientSoundVolume = 0.1f;
        }};

        microReactor = new NuclearReactor("micro-reactor") {{
            requirements(Category.power, ItemStack.with(Items.lead, 150, Items.graphite, 80, Items.thorium, 20, Items.silicon, 120, VeItems.chromium, 100));
            lightColor = Color.valueOf("bf92f9");
            itemDuration = 360f;
            heating = 0.9f / 60f;
            heatOutput = 6f;
            ambientCooldownTime = 10f * 60f;
            flashThreshold = 0.01f;
            coolantPower = 0.3f;
            powerProduction = 1200f / 60f; // 5f / 60f
            explosionRadius = 12; // -
            explosionDamage = 1250;
            explodeEffect = new MultiEffect(
                    Fx.launchPod,
                    new ParticleEffect() {{
                        colorFrom = colorTo = Color.valueOf("8a73c6b3");
                        particles = 7;
                        length = 80f;
                        interp = Interp.pow10Out;
                        sizeInterp = Interp.circleIn;
                        sizeFrom = 12f;
                        sizeTo = 0f; // -
                        sizeChangeStart = 150f;
                        lifetime = 300f;
                    }},
                    new ParticleEffect() {{
                        colorFrom = colorTo = Color.valueOf("8a73c6b3");
                        particles = 9;
                        length = 100f;
                        interp = Interp.pow10Out;
                        sizeInterp = Interp.circleIn;
                        sizeFrom = 8f;
                        sizeTo = 0f; // -
                        sizeChangeStart = 150f;
                        lifetime = 300f;
                    }},
                    new ParticleEffect() {{
                        colorFrom = colorTo = Color.valueOf("8a73c6b3");
                        particles = 11;
                        length = 120f;
                        interp = Interp.pow10Out;
                        sizeInterp = Interp.circleIn;
                        sizeFrom = 4f;
                        sizeTo = 0f; // -
                        sizeChangeStart = 150f;
                        lifetime = 300f;
                    }}
            );
            explodeSound = Sounds.explosionArtilleryShock;
            explosionShake = 3f;
            explosionShakeDuration = 12f;
            health = 600;
            armor = 4f;
            size = 2;
            researchCostMultiplier = 0.2f;
            itemCapacity = 10;
            liquidCapacity = 20f;
            consumeItem(Items.thorium);
            consume(
                    new ConsumeLiquid(Liquids.water, 3f / 60f) {{
                        update = false;
                    }}
            );
            ambientSound = Sounds.loopThoriumReactor;
            ambientSoundVolume = 0.08f;
        }};

        isomorphicReactor = new NuclearReactor("isomorphic-reactor") {{
            requirements(Category.power, ItemStack.with(Items.lead, 400, Items.graphite, 200, Items.thorium, 60, Items.silicon, 300, VeItems.chromium, 280));
            lightColor = Color.valueOf("bf92f9");
            itemDuration = 360f;
            heating = 1.6f / 60f;
            heatOutput = 14f;
            ambientCooldownTime = 25f * 60f;
            flashThreshold = 0.01f;
            coolantPower = 0.5f; // -
            explodeSound = Sounds.explosionReactor; // -
            powerProduction = 4500f / 60f;
            health = 2000;
            armor = 24f;
            size = 3;
            researchCostMultiplier = 0.1f;
            itemCapacity = 40;
            liquidCapacity = 80;
            consumeItem(Items.thorium);
            consume(
                    new ConsumeLiquid(Liquids.cryofluid, 3.2f / 60f) {{
                        update = false;
                    }}
            );
            ambientSound = Sounds.loopThoriumReactor;
            ambientSoundVolume = 0.14f;
        }};

        radioactiveThermalGenerator = new ConsumeGenerator("radioactive-thermal-generator") {{
            requirements(Category.power, ItemStack.with(Items.lead, 80, Items.silicon, 50, Items.phaseFabric, 5, VeItems.cobalt, 40));
            itemDuration = 1260f;
            generateEffect = Fx.generatespark;
            itemDurationMultipliers.put(Items.phaseFabric, 15f);
            itemDurationMultipliers.put(VeItems.fusionFuel, 0.8f);
            itemDurationMultipliers.put(VeItems.warpNucleus, 20f);
            powerProduction = 180f / 60f;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawGlowRegion("-glow") {{
                        alpha = 0.5f;
                        glowScale = 2f;
                        color = Color.valueOf("bf92f9");
                    }}
            );
            health = 200;
            armor = 4f;
            size = 2;
            researchCostMultiplier = 1f;
            consume(new ConsumeItemRadioactive());
            ambientSound = Sounds.loopDifferential;
            ambientSoundVolume = 0.05f;
        }};

        fusionReactor = new ImpactReactor("fusion-reactor") {{
            requirements(Category.power, ItemStack.with(Items.lead, 400, Items.graphite, 350, Items.silicon, 500, Items.surgeAlloy, 1000, VeItems.quartz, 100, VeItems.silicide, 300, VeItems.chromium, 200, VeItems.cobalt, 250));
            warmupSpeed = 0.0005f;
            itemDuration = 125f;
            powerProduction = 330000f / 60f;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawGlowRegion("-glow3") {{
                        alpha = 0.3f;
                        glowScale = 2f;
                        glowIntensity = 0.1f;
                        color = Color.valueOf("9eabf7");
                    }},
                    new DrawPlasma() {{
                        plasma1 = Color.valueOf("d1efffaa");
                        plasma2 = Color.valueOf("9eabf766");
                    }},
                    new DrawDefault(),
                    new DrawGlowRegion("-glow1") {{
                        alpha = 0.9f;
                        glowScale = 2f;
                        color = Color.valueOf("9eabf7");
                    }},
                    new DrawGlowRegion("-glow2") {{
                        alpha = 0.7f;
                        glowScale = 10f; // -
                        color = Color.valueOf("9eabf7");
                    }}
            );
            explosionRadius = 35;
            explosionDamage = 50000;
            explodeEffect = new MultiEffect(
                    Fx.launchPod,
                    Fx.massiveExplosion,
                    new ExplosionEffect() {{
                        waveColor = Color.valueOf("f3e979");
                        waveLife = 18f;
                        waveStroke = 4f;
                        waveRad = 160f;
                        waveRadBase = 0f;
                        smokeColor = Color.valueOf("9eabf766");
                        smokeSize = 50f;
                        smokeSizeBase = 1f;
                        smokeRad = 700f;
                        smokes = 50;
                        sparkColor = Color.valueOf("f3e979");
                        sparkStroke = 7f;
                        sparkRad = 500f;
                        sparkLen = 50f;
                        sparks = 30;
                        lifetime = 360f;
                    }}
            );
            explodeSound = VeSounds.get("rlElectricBlockerBreakLoud");
            explosionMinWarmup = 0.5f;
            explosionShake = 32f;
            explosionShakeDuration = 60f;
            health = 30000;
            armor = 24f;
            baseExplosiveness = 8f;
            explosivenessScale = 1.5f;
            flammabilityScale = 0f;
            size = 6;
            researchCostMultiplier = 0.1f;
            destroyBullet = new BasicBulletType(0f, 0f) {{
                lifetime = 10f;
                collides = false;
                hittable = false;
                instantDisappear = true;
                fragBullets = 12;
                fragBullet = new LightningBulletType() {{
                    lifetime = 15;
                    damage = 300f;
                    lightningColor = Color.valueOf("f3e979");
                    lightningLength = 30;
                    lightningLengthRand = 20;
                }};
                lightningColor = Color.valueOf("f3e979");
                lightning = 18;
                lightningLength = 50;
                lightningLengthRand = 15;
                lightningDamage = 300f;
                hitSound = Sounds.explosionReactor;
                despawnSound = Sounds.explosionReactor;
            }};
            itemCapacity = 50;
            hasLiquids = false;
            liquidCapacity = 0f;
            consumePower(6000f / 60f);
            consumeItem(VeItems.fusionFuel);
            lightColor = Color.valueOf("9eabf7");
            ambientSound = VeSounds.get("si2OverchargedLaserLoop");
            ambientSoundVolume = 0.3f;
        }};

        spotSolarPad = new SolarGenerator("spot-solar-pad") {{
            requirements(Category.power, ItemStack.with(Items.silicon, 10, VeItems.aluminium, 30, VeItems.reflectorMatter, 15));
            powerProduction = 120f / 60f;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawGlowRegion("-glow") {{
                        alpha = 0.5f;
                        glowIntensity = 0.1f;
                        color = Color.valueOf("fbd367");
                    }}
            );
            size = 3;
            solid = false;
            underBullets = true;
            variants = 3;
        }};


        // cable


        batteryNode = new PowerNode("battery-node") {{
            requirements(Category.power, ItemStack.with(VeItems.quartz, 4, VeItems.silver, 4));
            laserRange = 8f;
            maxNodes = 8;
            laserColor2 = Color.valueOf("fb9567");
            researchCostMultiplier = 0.1f;
            consumesPower = true;
            outputsPower = true;
            consumePowerBuffered(500f);
            drawTeamOverlay = false;
            enableDrawStatus = false;
        }};

        melonCell = new NuclearReactor("melon-cell") {{
            requirements(Category.power, ItemStack.with(VeItems.silver, 10, VeItems.melonDirt, 10));
            lightColor = Color.valueOf("000000");
            hotColor = Color.valueOf("ffffff00");
            itemDuration = 1200f;
            heating = 0.0000277777777f;
            heatOutput = 0f;
            ambientCooldownTime = Float.POSITIVE_INFINITY;
            smokeThreshold = 1f;
            flashThreshold = 1f;
            coolantPower = 1f / 60f;
            fuelItem = VeItems.ferrum;
            explodeSound = Sounds.none;
            powerProduction = 4f / 60f;
            explosionRadius = 0;
            explosionDamage = 0; // -
            explodeEffect = Fx.none; // -
            explosionShake = 0f; // -
            explosionShakeDuration = 0f;
            health = 40;
            baseExplosiveness = 0f;
            size = 1; // -
            researchCostMultiplier = 0f;
            createRubble = false;
            itemCapacity = 10;
            liquidCapacity = 1f;
            consumeItem(VeItems.ferrum);
            consume(
                    new ConsumeLiquid(VeLiquids.melonWater, 1f / 60f) {{
                        update = false;
                        optional = true;
                    }}
            );
            squareSprite = false;
            emitLight = false;
            lightRadius = 0f;
            destroySound = Sounds.none;
            ambientSound = Sounds.none; // -
            ambientSoundVolume = 0f;
            destroyEffect = Fx.none;
        }};

        fermentor = new ConsumeGenerator("fermentor") {{
            requirements(Category.power, ItemStack.with(Items.sporePod, 10, VeItems.ferrum, 20, VeItems.silver, 10));
            itemDuration = 300f;
            generateEffect = Fx.none; // -
            powerProduction = 135f / 60f;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawFade()
            );
            size = 1;
            researchCostMultiplier = 0.01f;
            consumeItem(VeItems.sugar);
            ambientSound = Sounds.loopBio;
            ambientSoundVolume = 0.08f;
        }};

        winTower = new ThermalGenerator("win-tower") {{
            requirements(Category.power, BuildVisibility.editorOnly, ItemStack.with(Items.graphite, 20, VeItems.aluminium, 100, VeItems.chromium, 30));
            generateEffect = Fx.none; // -
            effectChance = 0f;
            minEfficiency = -1f;
            attribute = Attribute.steam;
            powerProduction = 45f / 60f;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawRegion("-leaves", -5f, true) {{
                        rotation = 0f;
                    }},
                    new DrawRegion("-leaves", -5f, true) {{
                        rotation = -15f;
                    }},
                    new DrawRegion("-leaves", -5f, true) {{
                        rotation = -30f;
                    }},
                    new DrawRegion("-leaves", -5f, true) {{
                        rotation = -45f;
                    }},
                    new DrawRegion("-leaves", -5f, true) {{
                        rotation = -60f;
                    }},
                    new DrawRegion("-leaves", -5f, true) {{
                        rotation = -75f;
                    }},
                    new DrawRegion("-cap")
            );
            size = 3;
            researchCostMultiplier = 0.3f;
            floating = false;
            ambientSound = Sounds.loopMachineSpin;
            ambientSoundVolume = 0.01f;
        }};

        copperWallHuge = new Wall("copper-wall-huge") {{
            requirements(Category.defense, ItemStack.with(Items.copper, 54));
            scaledHealth = 320f;
            armor = 0f; // -
            size = 3;
            researchCostMultiplier = 1f; // -
        }};

        titaniumWallHuge = new Wall("titanium-wall-huge") {{
            requirements(Category.defense, ItemStack.with(Items.titanium, 54));
            scaledHealth = 440f;
            armor = 0f; // -
            size = 3;
            researchCostMultiplier = 1f; // -
        }};

        thoriumWallHuge = new Wall("thorium-wall-huge") {{
            requirements(Category.defense, ItemStack.with(Items.thorium, 54));
            scaledHealth = 800f;
            armor = 0f; // -
            size = 3;
            researchCostMultiplier = 1f; // -
        }};

        defensiveWall = new Wall("defensive-wall") {{
            requirements(Category.defense, ItemStack.with(Items.copper, 4, Items.titanium, 4, Items.thorium, 4, VeItems.silicide, 4));
            scaledHealth = 1560f;
            armor = 16f;
            size = 1; // -
            researchCostMultiplier = 1f; // -
            buildCostMultiplier = 10f;
            crushDamageMultiplier = 0.05f;
        }};

        defensiveWallLarge = new Wall("defensive-wall-large") {{
            requirements(Category.defense, ItemStack.with(Items.copper, 16, Items.titanium, 16, Items.thorium, 16, VeItems.silicide, 16));
            scaledHealth = 1560f;
            armor = 16f;
            size = 2;
            researchCostMultiplier = 1f; // -
            buildCostMultiplier = 10f;
            crushDamageMultiplier = 0.05f;
        }};

        defensiveWallHuge = new Wall("defensive-wall-huge") {{
            requirements(Category.defense, ItemStack.with(Items.copper, 36, Items.titanium, 36, Items.thorium, 36, VeItems.silicide, 36));
            scaledHealth = 1560f;
            armor = 16f;
            size = 3;
            researchCostMultiplier = 1f; // -
            buildCostMultiplier = 10f;
            crushDamageMultiplier = 0.05f;
        }};

        effectiveWall = new Wall("effective-wall") {{
            requirements(Category.defense, ItemStack.with(Items.metaglass, 2, Items.graphite, 4, Items.plastanium, 3, Items.phaseFabric, 3, Items.surgeAlloy, 3, VeItems.silicide, 4));
            lightningChance = 0.05f;
            chanceDeflect = 10f;
            flashHit = true;
            scaledHealth = 1010f;
            armor = 8f;
            size = 1; // -
            researchCostMultiplier = 1f; // -
            buildCostMultiplier = 10f;
            insulated = true;
            absorbLasers = true;
            schematicPriority = 10;
            conductivePower = true;
            destroyBulletSameTeam = true;
            destroyBullet = new BasicBulletType(0f, 1f) {{
                collidesTiles = false;
                collidesAir = true; // -
                collides = false;
                hittable = false;
                instantDisappear = true;
                splashDamage = 19f;
                splashDamageRadius = 40f;
                status = StatusEffects.blasted;
                statusDuration = 60f;
            }};
        }};

        effectiveWallLarge = new Wall("effective-wall-large") {{
            requirements(Category.defense, ItemStack.with(Items.metaglass, 8, Items.graphite, 16, Items.plastanium, 12, Items.phaseFabric, 12, Items.surgeAlloy, 12, VeItems.silicide, 16));
            lightningChance = 0.05f;
            chanceDeflect = 10f;
            flashHit = true;
            scaledHealth = 1010f;
            armor = 8f;
            size = 2;
            researchCostMultiplier = 1f; // -
            buildCostMultiplier = 10f;
            insulated = true;
            absorbLasers = true;
            schematicPriority = 10;
            conductivePower = true;
            destroyBulletSameTeam = true;
            destroyBullet = new BasicBulletType(0f, 1f) {{
                collidesTiles = false;
                collidesAir = true; // -
                collides = false;
                hittable = false;
                instantDisappear = true;
                splashDamage = 76f;
                splashDamageRadius = 45f;
                status = StatusEffects.blasted;
                statusDuration = 60f;
            }};
        }};

        aluminiumWall = new Wall("aluminium-wall") {{
            requirements(Category.defense, ItemStack.with(VeItems.aluminium, 6));
            scaledHealth = 300f;
            armor = 0f; // -
            size = 1; // -
            researchCostMultiplier = 0.1f;
        }};

        aluminiumWallLarge = new Wall("aluminium-wall-large") {{
            requirements(Category.defense, ItemStack.with(VeItems.aluminium, 24));
            scaledHealth = 300f;
            armor = 0f; // -
            size = 2;
            researchCostMultiplier = 0.1f;
        }};

        aluminiumWallHuge = new Wall("aluminium-wall-huge") {{
            requirements(Category.defense, ItemStack.with(VeItems.aluminium, 54));
            scaledHealth = 300f;
            armor = 0f; // -
            size = 3;
            researchCostMultiplier = 0.1f;
        }};

        aluminiumLeadWall = new Wall("aluminium-lead-wall") {{
            requirements(Category.defense, ItemStack.with(Items.lead, 6, VeItems.aluminium, 6));
            scaledHealth = 480f;
            armor = 0f; // -
            size = 1; // -
            researchCostMultiplier = 0.2f;
        }};

        aluminiumLeadWallLarge = new Wall("aluminium-lead-wall-large") {{
            requirements(Category.defense, ItemStack.with(Items.lead, 24, VeItems.aluminium, 24));
            scaledHealth = 480f;
            armor = 0f; // -
            size = 2;
            researchCostMultiplier = 0.2f;
        }};

        aluminiumLeadWallHuge = new Wall("aluminium-lead-wall-huge") {{
            requirements(Category.defense, ItemStack.with(Items.lead, 54, VeItems.aluminium, 54));
            scaledHealth = 480f;
            armor = 0f; // -
            size = 3;
            researchCostMultiplier = 0.2f;
        }};

        silicideWall = new Wall("silicide-wall") {{
            requirements(Category.defense, ItemStack.with(Items.graphite, 4, VeItems.silicide, 8));
            scaledHealth = 950f;
            armor = 8f;
            // insulated = true;
            size = 1; // -
            researchCostMultiplier = 0.2f;
            crushDamageMultiplier = 0.25f;
            destroyBulletSameTeam = true;
            destroyBullet = new BasicBulletType(0f, 1f) {{
                collidesTiles = false;
                collidesAir = true; // -
                collides = false;
                hittable = false;
                instantDisappear = true;
                splashDamage = 29f;
                splashDamageRadius = 40f;
                status = StatusEffects.blasted;
                statusDuration = 60f;
            }};
            hasPower = true;
            conductivePower = true;
        }};

        silicideWallLarge = new Wall("silicide-wall-large") {{
            requirements(Category.defense, ItemStack.with(Items.graphite, 16, VeItems.silicide, 32));
            scaledHealth = 950f;
            armor = 8f;
            // insulated = true;
            size = 2;
            researchCostMultiplier = 0.2f;
            crushDamageMultiplier = 0.25f;
            destroyBulletSameTeam = true;
            destroyBullet = new BasicBulletType(0f, 1f) {{
                collidesTiles = false;
                collidesAir = true; // -
                collides = false;
                hittable = false;
                instantDisappear = true;
                splashDamage = 116f;
                splashDamageRadius = 64f;
                status = StatusEffects.blasted;
                statusDuration = 60f;
            }};
            hasPower = true;
            conductivePower = true;
        }};

        silicideAluminiumWall = new Wall("silicide-aluminium-wall") {{
            requirements(Category.defense, ItemStack.with(VeItems.aluminium, 6, VeItems.silicide, 4));
            scaledHealth = 640f;
            armor = 6f;
            size = 1; // -
            researchCostMultiplier = 0.2f;
            crushDamageMultiplier = 0.25f;
        }};

        silicideAluminiumWallLarge = new Wall("silicide-aluminium-wall-large") {{
            requirements(Category.defense, ItemStack.with(VeItems.aluminium, 24, VeItems.silicide, 16));
            scaledHealth = 640f;
            armor = 6f;
            size = 2;
            researchCostMultiplier = 0.2f;
            crushDamageMultiplier = 0.25f;
        }};

        silicideAluminiumWallHuge = new Wall("silicide-aluminium-wall-huge") {{
            requirements(Category.defense, ItemStack.with(VeItems.aluminium, 54, VeItems.silicide, 36));
            scaledHealth = 640f;
            armor = 6f;
            size = 3;
            researchCostMultiplier = 0.2f;
            crushDamageMultiplier = 0.25f;
        }};

        chromiumWall = new Wall("chromium-wall") {{
            requirements(Category.defense, ItemStack.with(VeItems.chromium, 6));
            scaledHealth = 900f;
            armor = 3f;
            size = 1; // -
            researchCostMultiplier = 0.3f;
            crushDamageMultiplier = 1f;
        }};

        chromiumWallLarge = new Wall("chromium-wall-large") {{
            requirements(Category.defense, ItemStack.with(VeItems.chromium, 24));
            scaledHealth = 900f;
            armor = 3f;
            size = 2;
            researchCostMultiplier = 0.3f;
            crushDamageMultiplier = 1f;
        }};

        chromiumWallHuge = new Wall("chromium-wall-huge") {{
            requirements(Category.defense, ItemStack.with(VeItems.chromium, 54));
            scaledHealth = 900f;
            armor = 6f;
            size = 3;
            researchCostMultiplier = 0.3f;
            crushDamageMultiplier = 1f;
        }};

        silicideChromiumWall = new Wall("silicide-chromium-wall") {{
            requirements(Category.defense, ItemStack.with(VeItems.chromium, 6, VeItems.silicide, 6));
            scaledHealth = 1240f;
            armor = 16f;
            size = 1; // -
            researchCostMultiplier = 1f; // -
            crushDamageMultiplier = 0f;
        }};

        silicideChromiumWallLarge = new Wall("silicide-chromium-wall-large") {{
            requirements(Category.defense, ItemStack.with(VeItems.chromium, 24, VeItems.silicide, 24));
            scaledHealth = 1240f;
            armor = 16f;
            size = 2;
            researchCostMultiplier = 1f; // -
            crushDamageMultiplier = 0f;
        }};

        silicideChromiumWallHuge = new Wall("silicide-chromium-wall-huge") {{
            requirements(Category.defense, ItemStack.with(VeItems.chromium, 54, VeItems.silicide, 54));
            scaledHealth = 1240f;
            armor = 16f;
            size = 3;
            researchCostMultiplier = 1f; // -
            crushDamageMultiplier = 0f;
        }};

        mechanicalGateSmall = new Door("mechanical-gate-small") {{
            requirements(Category.defense, ItemStack.with(VeItems.chromium, 10));
            openfx = new SoundEffect(VeSounds.get("si2DoorOpen"), Fx.dooropen) {{
                minPitch = 1f;
                maxPitch = 1f;
            }};
            closefx = new SoundEffect(VeSounds.get("si2DoorClose"), Fx.doorclose) {{
                minPitch = 1f;
                maxPitch = 1f;
            }};
            doorSound = Sounds.none;
            chainEffect = true;
            consumesTap = false;
            health = 1000;
            armor = 3f;
            size = 1; // -
            researchCostMultiplier = 0.1f;
            crushDamageMultiplier = 1f;
        }};

        mechanicalGate = new Door("mechanical-gate") {{
            requirements(Category.defense, ItemStack.with(Items.silicon, 10, VeItems.chromium, 40));
            openfx = new SoundEffect(VeSounds.get("si2DoorOpen"), Fx.dooropenlarge) {{
                minPitch = 1f;
                maxPitch = 1f;
            }};
            closefx = new SoundEffect(VeSounds.get("si2DoorClose"), Fx.doorcloselarge) {{
                minPitch = 1f;
                maxPitch = 1f;
            }};
            doorSound = Sounds.none;
            chainEffect = true;
            health = 4000;
            armor = 3f;
            size = 2;
            researchCostMultiplier = 0.1f;
            crushDamageMultiplier = 1f;
        }};

        mechanicalGateSilicide = new Door("mechanical-gate-silicide") {{
            requirements(Category.defense, ItemStack.with(Items.silicon, 10, VeItems.silicide, 50, VeItems.chromium, 70));
            openfx = new SoundEffect(VeSounds.get("si2DoorOpen"), Fx.dooropenlarge) {{
                minPitch = 1f;
                maxPitch = 1f;
            }};
            closefx = new SoundEffect(VeSounds.get("si2DoorClose"), Fx.doorcloselarge) {{
                minPitch = 1f;
                maxPitch = 1f;
            }};
            doorSound = Sounds.none;
            chainEffect = true;
            health = 12000;
            armor = 16f;
            size = 3;
            researchCostMultiplier = 0.3f;
            crushDamageMultiplier = 0.25f;
        }};

        automaticGate = new AutoDoor("automatic-gate") {{
            requirements(Category.defense, ItemStack.with(Items.silicon, 25, VeItems.chromium, 40));
            openfx = new SoundEffect(VeSounds.get("si2DoorOpen"), Fx.dooropenlarge) {{
                minPitch = 1f;
                maxPitch = 1f;
            }};
            closefx = new SoundEffect(VeSounds.get("si2DoorClose"), Fx.doorcloselarge) {{
                minPitch = 1f;
                maxPitch = 1f;
            }};
            doorSound = Sounds.none;
            health = 4000;
            armor = 3f;
            size = 2;
            researchCostMultiplier = 0.1f;
            crushDamageMultiplier = 1f;
        }};

        automaticGateSilicide = new AutoDoor("automatic-gate-silicide") {{
            requirements(Category.defense, ItemStack.with(Items.silicon, 25, VeItems.silicide, 50, VeItems.chromium, 70));
            openfx = new SoundEffect(VeSounds.get("si2DoorOpen"), Fx.dooropenlarge) {{
                minPitch = 1f;
                maxPitch = 1f;
            }};
            closefx = new SoundEffect(VeSounds.get("si2DoorClose"), Fx.doorcloselarge) {{
                minPitch = 1f;
                maxPitch = 1f;
            }};
            doorSound = Sounds.none;
            health = 12000;
            armor = 16f;
            size = 3;
            researchCostMultiplier = 0.3f;
            crushDamageMultiplier = 0.25f;
        }};

        advancedPlastaniumWall = new PowerNode("advanced-plastanium-wall") {{
            requirements(Category.defense, ItemStack.with(Items.plastanium, 5, VeItems.quartz, 3, VeItems.silicide, 2));
            laserRange = 5f;
            maxNodes = 2;
            autolink = false;
            laserColor2 = Color.valueOf("cbd97f");
            insulated = true;
            absorbLasers = true;
            health = 550;
            armor = 12f;
            size = 1; // -
            canOverdrive = false; // -
            researchCostMultiplier = 0.2f;
            priority = TargetPriority.under;
            solid = true; // -
            group = BlockGroup.walls;
            allowRectanglePlacement = true;
            schematicPriority = 10;
            buildCostMultiplier = 6f;
            crushDamageMultiplier = 5f;
            drawDisabled = false; // -
            conductivePower = false; // -
            destroySound = Sounds.blockExplodeWall;
            destroySoundVolume = 1f; // -
        }};

        advancedPlastaniumWallLarge = new PowerNode("advanced-plastanium-wall-large") {{
            requirements(Category.defense, ItemStack.with(Items.plastanium, 20, VeItems.quartz, 12, VeItems.silicide, 8));
            laserRange = 6f;
            maxNodes = 8;
            autolink = false;
            laserColor2 = Color.valueOf("cbd97f");
            insulated = true;
            absorbLasers = true;
            health = 2200;
            armor = 12f;
            size = 2;
            canOverdrive = false; // -
            researchCostMultiplier = 0.2f;
            priority = TargetPriority.under;
            solid = true; // -
            group = BlockGroup.walls;
            allowRectanglePlacement = true;
            schematicPriority = 10;
            buildCostMultiplier = 6f;
            crushDamageMultiplier = 5f;
            drawDisabled = false; // -
            conductivePower = false; // -
            destroySound = Sounds.blockExplodeWall;
            destroySoundVolume = 1.5f;
        }};


        fibraltWall = new RegenProjector("fibralt-wall") {{
            requirements(Category.defense, ItemStack.with(Items.silicon, 4, VeItems.fibralt, 6));
            range = 1;
            healPercent = 0.15f;
            consumePower(1f / 60f);
            conductivePower = true;
            size = 1;
            solid = true;
            buildCostMultiplier = 6f;
            group = BlockGroup.walls;
            crushDamageMultiplier = 5f;
            canOverdrive = true;
            drawDisabled = false;
            priority = -2f;
            health = 1100;
            armor = 10f;
            hasPower = true;
            effectChance = 0f;
            baseColor = Color.valueOf("90dbff");
            ambientSoundVolume = 0.05f;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawShape() {{
                        layer = 100f;
                        radius = 1.75f;
                        useWarmupRadius = true;
                        timeScl = 2;
                        color = Color.valueOf("90dbff");
                    }}
            );
            destroySound = Sounds.blockExplodeWall;
            destroySoundVolume = 1f;
        }};

        fibraltWallLarge = new RegenProjector("fibralt-wall-large") {{
            requirements(Category.defense, ItemStack.with(Items.silicon, 16, VeItems.fibralt, 24));
            range = 2;
            healPercent = 0.15f;
            consumePower(4f / 60f);
            conductivePower = true;
            size = 2;
            solid = true;
            buildCostMultiplier = 6f;
            group = BlockGroup.walls;
            crushDamageMultiplier = 5f;
            canOverdrive = true;
            drawDisabled = false;
            priority = -2f;
            health = 4400;
            armor = 10f;
            hasPower = true;
            effectChance = 0f;
            baseColor = Color.valueOf("90dbff");
            ambientSoundVolume = 0.2f;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawShape() {{
                        layer = 100f;
                        radius = 3.5f;
                        useWarmupRadius = true;
                        timeScl = 2;
                        color = Color.valueOf("90dbff");
                    }}
            );
            destroySound = Sounds.blockExplodeWall;
            destroySoundVolume = 1.5f;
        }};


        surgeShieldWall = new ShieldWall("surge-shield-wall") {{
            requirements(Category.defense, ItemStack.with(Items.silicon, 5, Items.phaseFabric, 30, Items.surgeAlloy, 30));
            shieldHealth = 6000f;
            breakCooldown = 4f * 60f;
            regenSpeed = 4f;
            lightningChance = 0.35f;
            lightningDamage = 40f;
            health = 3880;
            armor = 8f;
            size = 2;
            destroyBulletSameTeam = true;
            destroyBullet= new BasicBulletType() {{
                instantDisappear = true;
                lightningColor = Color.valueOf("f3e979");
                lightning = 5;
                lightningLength = 10;
                lightningDamage = 40f;
                hitEffect = Fx.none;
                despawnEffect = Fx.none;
                hitSound = Sounds.shootArc;
                despawnSound = Sounds.shootArc;
            }};
            hasPower = true;
            consumesPower = true;
            outputsPower = false;
            conductivePower = true;
            consumePower(9f / 60f);
            drawTeamOverlay = false;
            ambientSound = Sounds.loopShield;
            ambientSoundVolume = 0.06f;
        }};


        blockingWall = new BaseShield("blocking-wall") {{
            requirements(Category.defense, ItemStack.with(Items.thorium, 20, Items.silicon, 20, Items.phaseFabric, 8));
            radius = 8f;
            sides = 4;
            consumePower(14f / 60f);
            conductivePower = true;
            size = 2;
            solid = true;
            buildCostMultiplier = 6f;
            group = BlockGroup.walls;
            crushDamageMultiplier = 5f;
            canOverdrive = false;
            researchCostMultiplier = 0.05f;
            drawDisabled = false;
            priority = -2f;
            health = 3000;
            hasPower = true;
            rebuildable = true;
            ambientSoundVolume = 0.06f;
            ambientSound = Sounds.loopShield;
            drawTeamOverlay = false;
            destroySound = Sounds.blockExplodeWall;
            destroySoundVolume = 1.5f;
        }};

        blockingWallSilicide = new BaseShield("blocking-wall-silicide") {{
            requirements(Category.defense, ItemStack.with(Items.thorium, 36, Items.silicon, 45, Items.phaseFabric, 12, VeItems.silicide, 54));
            radius = 14f;
            sides = 4;
            consumePower(24f / 60f);
            conductivePower = true;
            size = 3;
            armor = 16f;
            solid = true;
            buildCostMultiplier = 6f;
            group = BlockGroup.walls;
            canOverdrive = false;
            drawDisabled = false;
            priority = -2f;
            health = 9810;
            hasPower = true;
            rebuildable = true;
            researchCostMultiplier = 0.2f;
            crushDamageMultiplier = 0.25f;
            ambientSoundVolume = 0.08f;
            ambientSound = Sounds.loopShield;
            drawTeamOverlay = false;
            destroySound = Sounds.blockExplodeWall;
            destroySoundVolume = 2f;
        }};


        ferrumWall = new Wall("ferrum-wall") {{
            requirements(Category.defense, ItemStack.with(VeItems.ferrum, 6));
            insulated = true;
            scaledHealth = 550f;
            armor = 4f;
            size = 1; // -
            // researchCostMultiplier = 1f;
            crushDamageMultiplier = 0.2f;
            hasPower = true; // -
        }};

        ferrumWallLarge = new Wall("ferrum-wall-large") {{
            requirements(Category.defense, ItemStack.with(VeItems.ferrum, 24));
            insulated = true;
            scaledHealth = 550f;
            armor = 4f;
            size = 2;
            // researchCostMultiplier = 1f;
            crushDamageMultiplier = 0.2f;
            hasPower = true; // -
        }};

        ferrumWallHuge = new Wall("ferrum-wall-huge") {{
            requirements(Category.defense, ItemStack.with(VeItems.ferrum, 6));
            insulated = true;
            scaledHealth = 550f;
            armor = 4f;
            size = 3;
            // researchCostMultiplier = 1f;
            crushDamageMultiplier = 0.2f;
            hasPower = true; // -
        }};

        titanicPlastaniumWall = new PowerNode("titanic-plastanium-wall") {{
            requirements(Category.defense, ItemStack.with(Items.plastanium, 700, VeItems.quartz, 300, VeItems.ferrum, 300));
            laserRange = 100f;
            maxNodes = 2;
            autolink = false;
            laserScale = 1f;
            laserColor2 = Color.valueOf("cbd97f");
            group = BlockGroup.walls;
            insulated = true;
            absorbLasers = true;
            health = 75000; // 67200
            baseExplosiveness = 5f;
            size = 9;
            canOverdrive = false; // -
            researchCostMultiplier = 0.1f;
            priority = TargetPriority.wall;
            solid = true; // -
            allowRectanglePlacement = true;
            schematicPriority = -20;
            buildCostMultiplier = 8f;
            crushDamageMultiplier = 0f;
            baseShake = 32f;
            rebuildable = false;
            drawDisabled = false; // -
            conductivePower = false; // -
            // destroySound = VeSounds.get("blockExplode3");
            destroySound = Sounds.blockExplode3;
            destroySoundVolume = 3f;
        }};

        bush = new Prop("bush") {{
            requirements(Category.defense, BuildVisibility.sandboxOnly, ItemStack.with(VeItems.plantMatter, 8));
            buildCostMultiplier = 6f;
            instantDeconstruct = false;
            variants = 4;
            hasShadow = false;
            breakSound = Sounds.plantBreak;
            alwaysUnlocked = true;
        }};

        tree = new TreeBlock("tree") {{
            requirements(Category.defense, BuildVisibility.sandboxOnly, ItemStack.with(VeItems.plantMatter, 30));
            breakable = true;
            buildCostMultiplier = 18f;
            instantDeconstruct = false; // -
            variants = 6;
            breakSound = Sounds.plantBreak;
            alwaysUnlocked = true;
        }};


        quartzExtractor = new GenericCrafter("quartz-extractor") {{
            requirements(Category.crafting, ItemStack.with(Items.copper, 16, Items.graphite, 12));
            outputItem = new ItemStack(VeItems.quartz, 1);
            craftEffect = Fx.pulverize;
            craftTime = 35f;
            updateEffect = Fx.pulverizeSmall;
            hasItems = true;
            size = 1;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawRegion() {{
                        spinSprite = true;
                        rotateSpeed = 3.5f;
                        suffix = "-rotator";
                    }},
                    new DrawRegion("-top")
            );
            ambientSound = Sounds.loopGrind;
            ambientSoundVolume = 0.03f;
            consumeItem(Items.sand, 2);
        }};

        isomorphicPress = new GenericCrafter("isomorphic-press") {{
            requirements(Category.crafting, ItemStack.with(Items.lead, 30, VeItems.aluminium, 40));
            outputItem = new ItemStack(Items.graphite, 2);
            craftTime = 120f;
            craftEffect = Fx.smeltsmoke;
            hasItems = true;
            size = 2;
            ambientSound = Sounds.loopMachine;
            ambientSoundVolume = 0.04f;
            researchCostMultiplier = 0.1f;
            consumeItem(Items.coal, 4);
        }};

        hydraulicPress = new GenericCrafter("hydraulic-press") {{
            requirements(Category.crafting, ItemStack.with(Items.graphite, 40, Items.silicon, 20, VeItems.aluminium, 70, VeItems.chromium, 80));
            outputItem = new ItemStack(Items.graphite, 5);
            craftTime = 60f;
            craftEffect = Fx.fuelburn;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(Liquids.water),
                    new DrawRegion(),
                    new DrawRegion("-rotator", -6f),
                    new DrawPistons() {{
                        sinMag = 2.5f;
                        sinScl = 4.9f;
                        sinOffset = 0f;
                    }},
                    new DrawRegion("-top")
            );
            hasItems = true;
            hasLiquids = true;
            hasPower = true;
            itemCapacity = 30;
            liquidCapacity = 80f;
            size = 3;
            ambientSound = Sounds.loopMachineSpin;
            ambientSoundVolume = 0.06f;
            researchCostMultiplier = 0.01f;
            consumeItem(Items.coal, 8);
            consumeLiquid(Liquids.water, 8f / 60f);
            consumePower(96f / 60f);
        }};

        isomorphicSmelter = new GenericCrafter("isomorphic-smelter") {{
            requirements(Category.crafting, ItemStack.with(Items.lead, 30, VeItems.aluminium, 45));
            outputItem = new ItemStack(Items.silicon, 2);
            craftTime = 40f;
            craftEffect = Fx.smeltsmoke;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawFlame(Color.valueOf("ffef99"))
            );
            hasItems = true;
            hasPower = true;
            size = 2;
            ambientSound = Sounds.loopSmelter;
            ambientSoundVolume = 0.09f;
            researchCostMultiplier = 0.05f;
            consumeItems(ItemStack.with(Items.coal, 2, VeItems.quartz, 2));
            consumePower(48f / 60f);
        }};

        substitutionChamber = new GenericCrafter("substitution-chamber") {{
            requirements(Category.crafting, ItemStack.with(Items.graphite, 85, VeItems.aluminium, 105, VeItems.silicide, 70));
            outputItem = new ItemStack(Items.silicon, 12);
            outputLiquid = new LiquidStack(Liquids.water, 15f / 60f);
            craftTime = 80f;
            craftEffect = Fx.smeltsmoke;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(Liquids.hydrogen),
                    new DrawRegion(),
                    new DrawFlame(Color.valueOf("d1efff")) {{
                        lightRadius = 45f;
                        flameRadius = 3.5f;
                        flameRadiusIn = 2.2f;
                    }}
            );
            hasItems = true;
            hasLiquids = true;
            hasPower = true;
            itemCapacity = 30;
            liquidCapacity = 60f;
            explosivenessScale = 1.5f;
            flammabilityScale = 0f;
            size = 3;
            ambientSound = Sounds.loopSmelter;
            ambientSoundVolume = 0.1f;
            researchCostMultiplier = 0.3f;
            consumeItem(VeItems.quartz, 6);
            consumeLiquid(Liquids.hydrogen, 9f / 60f);
            consumePower(240f / 60f);
        }};

        quartzSeparator = new GenericCrafter("quartz-separator") {{
            requirements(Category.crafting, ItemStack.with(Items.graphite, 10, VeItems.aluminium, 20));
            outputItem = new ItemStack(VeItems.quartz, 1);
            craftTime = 40f;
            craftEffect = Fx.pulverize;
            updateEffect = Fx.pulverizeSmall;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawRegion("-rotator", 3f, true),
                    new DrawRegion("-top")
            );
            hasItems = true;
            size = 1;
            ambientSound = Sounds.loopGrind;
            ambientSoundVolume = 0.03f;
            researchCostMultiplier = 0.6f;
            consumeItem(Items.sand, 2);
        }};

        quartzSeparatorLarge = new GenericCrafter("quartz-separator-large") {{
            requirements(Category.crafting, ItemStack.with(Items.graphite, 40, VeItems.aluminium, 55, VeItems.chromium, 30));
            outputItem = new ItemStack(VeItems.quartz, 4);
            craftTime = 50f;
            craftEffect = Fx.pulverize;
            updateEffect = Fx.pulverizeSmall;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawRegion("-rotator1", 4f, true),
                    new DrawRegion("-rotator2", -6f, true),
                    new DrawRegion("-top")
            );
            hasItems = true;
            hasPower = true;
            itemCapacity = 20;
            size = 2;
            ambientSound = Sounds.loopGrind;
            ambientSoundVolume = 0.07f;
            researchCostMultiplier = 0.6f;
            consumeItem(Items.sand, 6);
            consumePower(42f / 60f);
        }};

        isomorphicKiln = new GenericCrafter("isomorphic-kiln") {{
            requirements(Category.crafting, ItemStack.with(Items.graphite, 30, VeItems.aluminium, 55));
            outputItem = new ItemStack(Items.metaglass, 4);
            craftTime = 80f;
            craftEffect = Fx.smeltsmoke;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawFlame(Color.valueOf("ccbcee"))
            );
            hasItems = true;
            hasPower = true;
            size = 2;
            ambientSound = Sounds.loopSmelter;
            ambientSoundVolume = 0.08f;
            researchCostMultiplier = 0.3f;
            consumeItems(ItemStack.with(Items.sand, 4, Items.lead, 3));
            consumePower(48f / 60f);
        }};

        isomorphicCoreShard = new CoreBlock("isomorphic-core-shard") {{
            requirements(Category.effect, BuildVisibility.coreZoneOnly, ItemStack.with(Items.lead, 1600, VeItems.aluminium, 1000));
            alwaysUnlocked = true;
            health = 2500;
            size = 3;
            unitType = VeUnitTypes.theta;
            itemCapacity = 4000;
            unitCapModifier = 8;
            isFirstTier = true;
            requiresCoreZone = false;
            rebuildable = false;
            drawTeamOverlay = false;
            // shownPlanets.addAll(VePlanets.cyclant, VePlanets.maress);
        }};

        coreNucleusRoot = new CoreBlock("core-nucleus-root") {{
            requirements(Category.effect, BuildVisibility.editorOnly, ItemStack.with(Items.copper, 8000, Items.lead, 8000, Items.thorium, 4000, Items.silicon, 5000));
            alwaysUnlocked = true;
            thrusterLength = 10f;
            health = 6000;
            armor = 3f;
            size = 5;
            unitType = UnitTypes.gamma;
            itemCapacity = 13000;
            unitCapModifier = 24;
            isFirstTier = true;
            requiresCoreZone = false;
            rebuildable = false;
            drawTeamOverlay = false;
            researchCostMultiplier = 0f;
        }};

        /*
        block = new TreeBlock("") {{
            // = new Block("") {{
                // = new TreeBlock("") {{
                shadowOffset = f; // -4f

                solid = true; // 是否为实体
                clipSize = 90; // -1f 方块的贴图裁剪范围大小
                customShadow = true; // false 是否绘制自定义阴影(VeName-shadow)

            // Block
            requirements(Category.distribution, BuildVisibility.hidden, ItemStack.with(Items., ));

            // 基础属性
            insulated = ; // false 是否具有绝缘属性
            absorbLasers = ; // false 能否吸收激光
            scaledHealth = f; // -1f 每个格子所占的生命值基数, 结果为: health = size * size * scaledHealth并四舍五入至5的倍数
            health = ; // -1 生命值, 跳过scaledHealth
            armor = f; // 0f 护甲
            baseExplosiveness = ; // 0f 基础爆炸性
            explosivenessScale = ; // 1f 爆炸性系数
            flammabilityScale = ; // 1f 易燃性系数
            size = ; // 1 方块大小
            placeOverlapRange = f; // 50f 启用placeRangeCheck规则时, 检测敌方方块的范围
            attacks = ; // false 能否攻击
            suppressable = ; // false 是否与修复有关
            canOverdrive = ; // true 能否超速
            researchCostMultiplier = f; // 1f 研究成本倍数
            researchCostMultipliers.put(Items., f); // 每种物品的研究成本
            researchCost = ItemStack.with(Items., ); // 覆盖研究成本
            unitCapModifier = ; // 0 提供的单位容量, 仅当方块的标志包含unitModifier时生效
            fogRadius = ; // -1 能揭示多大范围的战争迷雾
            // 作为载荷
            updateInUnits = ; // true 当方块作为单位搬运的载荷时，是否继续更新
            alwaysUpdateInUnits = ; // false 作为载荷时, 是否无视实验性游戏规则，始终更新
            canPickup = ; // true 能否被搬起
            deconstructDropAllLiquid = ; // false 如果为false, 则在解构时仅输出可焚烧液体, 否则输出所有液体
            // 索敌
            flags = EnumSet.of(BlockFlag.); // 方块的标志集合，用于AI索引
            priority = f; // TargetPriority.base 敌人瞄准优先级
            targetable = ; // true 单位是否瞄准此方块
            // 特殊属性
            inEditor = ; // true 编辑器中是否可见
            editorConfigurable = ; // 是否可在编辑器中配置
            update = ; // 该方块是否具有持续更新的方块实体
            solid = ; // 是否为实体
            solidifes = ; // 是否为实心方块
            teamPassable = ; // 如果为true, 则被视为同阵营的非实体方块
            underBullets = ; // 如果为true, 则该方块除非被明确指定, 否则无法被子弹击中
            saveData = ; // 是否保存数据到世界存档
            timers = ; // 0 计时器的最大值
            sync = ; // 是否需要周期性的在网络中同步
            forceTeam = ; // 所有这个方块全部强制属于这个队伍

            // 放置和拆除
            breakable = ; // 是否可以用右键直接拆除这个方块
            requiresWater = ; // false 是否只能放置在水上
            placeableLiquid = ; // false 能否放置在任何液体上
            placeablePlayer = ; // true 能否通过建筑菜单直接放置
            placeableOn = ; // true 其他方块能否放置在这个方块上面
            floating = ; // false 是否可以放置在液体边缘
            alwaysReplace = ; // false 是否在所有情况下都可以被替换
            replaceable = ; // true 能否被替换
            group = BlockGroup.; // 属于哪个组, 同组方块可以相互替换
            delayLandingConfig = ; // 如果为true, 则在着陆构建动画中, 该方块的配置操作会被延迟, 未来可能会被移除
            conveyorPlacement = ; // 是否使用传送带式放置模式
            allowDiagonal = ; // true 能否使用对角线放置模式(ctrl)
            swapDiagonalPlacement = ; // 是否交换对角线放置模式
            allowRectanglePlacement = ; // false 是否为矩形放置, 而非线性放置
            schematicPriority = ; // 0 蓝图建造优先级
            buildTime = f; // -1f 建造时间
            buildCostMultiplier = f; // -1f 建造此方块的速度倍率
            ignoreBuildDarkness = ; // false 能否在黑暗区域放置, 用于编辑静态墙
            deconstructThreshold = f; // 0f 拆除完成的阈值
            instantDeconstruct = ; // false 是否立即拆除, 不返还资源
            // 旋转
            rotate = ; // 是否可旋转
            quickRotate = ; // true 放置后能否旋转
            ignoreLineRotation = ; // false 如果为true, 该方块的朝向不会朝向拖动方向
            invertFlip = ; // false 如果为true, 则放置或保存蓝图时不会旋转
            rotateDraw = ; // true 当rotate为true且该项为false时, 该方块在渲染时不会旋转
            rotateDrawEditor = ; // true 当rotate为true且该项为false时, 该方块在编辑器中渲染时不会旋转
            lockRotation = ; // true 当rotate为false且该项为true时, 该方块放置时旋转将锁定到0(默认)
            visualRotationOffset = f; // 0f 视觉旋转偏移
            // 摧毁和重建
            destructible = ; // 该方块是否具有生命值并可摧毁. update为true时, 该项为false不会有任何效果
            unitMoveBreakable = ; // 如果为true, 某些单位踩到或移动到该方块上时会破坏该方块
            crushDamageMultiplier = f; // 1f 碾压伤害倍率
            crushFragile = ; // false 如果为true, 当坦克的crushFragile同为true时, 会立刻破坏该方块
            drawCracks = ; // true 损坏时是否产生裂纹
            baseShake = ; // 3f 被摧毁时的屏幕震动
            createRubble = ; // true 被摧毁时是否产生残骸
            rebuildable = ; // true 是否可重建
            allowDerelictRepair = ; // true 该方块的废墟能否通过点击修复
            destroyBulletSameTeam = ; // false 被摧毁时产生子弹的阵营
            destroyBullet = new () {{}}; // 被摧毁时产生的子弹
            // 环境需求
            envRequired = Env. | Env.; // 0 必要环境
            envEnabled = Env. | Env.; // Env.terrestrial 可运行环境
            envDisabled = Env. | Env.; // 0 无法运行的环境

            // 配置
            saveConfig = ; // false 是否保存上一次的配置并应用到新方块
            copyConfig = ; // true 能否通过选取操作复制配置
            clearOnDoubleTap = ; // true 能否通过双击清除配置
            configurable = ; // 能否被点击并打开配置界面
            allowConfigInventory = ; // true 物品库存是否与配置界面一起显示
            selectionRows = ; // 5 选择菜单的行数
            selectionColumns = ; // 4 选择菜单的列数
            consumesTap = ; // 当方块被点击时，是否拦截touchDown事件
            ignoreResizeConfig = ; // 如果为true, 在地图大小改变时, 不会有名为transform的点配置
            commandable = ; // 在指挥模式下能否被选中
            // 逻辑
            privileged = ; // false 对于逻辑相关方块, 能否被普通逻辑处理器更改
            autoResetEnabled = ; // true 当逻辑块长时间没有交互时，是否自动重置其启用状态
            drawDisabled = ; // true 是否绘制禁用状态
            noUpdateDisabled = ; // false 当方块被禁用时，是否停止更新
            logicConfigurable = ; // false 能否被逻辑配置

            // 生产
            itemDrop = Items.; // 被钻头开采时, 能够开采出的物品
            playerUnmineable = ; // false 如果为false, 该方块无法被玩家手动开采
            attributes.set(Attribute., ); // 对某些事物的效率加成
            // 物品
            hasItems = ; // 是否拥有物品模块
            depositCooldown = f; // -1f 玩家向该方块存入物品时的冷却时间
            itemCapacity = ; // 10 物品容量
            separateItemCapacity = ; // false 物品容量是否独立计算
            unloadable = ; // true 装卸器能否作用于该方块
            // 液体
            hasLiquids = ; // 是否拥有液体模块
            liquidCapacity = f; // -1f 液体容量
            outputsLiquid = ; // false 是否输出液体
            liquidPressure = f; // 1f 液体输出速率
            displayFlow = ; // true 显示液体传输速率
            // 电力
            hasPower = ; // 是否拥有电力模块
            consumesPower = ; // true 是否被视为耗电单元
            outputsPower = ; // false 是否输出电力
            connectedPower = ; // true 能否被节点连接
            conductivePower = ; // false 能否通过接触传导电力
            // 单位
            outputsPayload = ; // false 能否输出载荷
            acceptsUnitPayloads = ; // false 能否输入载荷
            acceptsPayload = ; // false 载荷是否尝试进入该方块
            // 输入输出
            acceptsItems = ; // false 是否与附近的传送带连接
            alwaysAllowDeposit = ; // false 是否忽略onlyDepositCore规则
            outputFacing = ; // true 是否按方块朝向输出
            noSideBlend = ; // false 是否接受来自侧面的输入
            isDuct = ; // false 该方块是否为管道
            allowResupply = ; // false 单位能否从该方块拿取物品
            instantTransfer = ; // false 是否支持瞬时传输(光传)
            dumpTime = ; // 5 尝试输出的时间间隔, 填5即每秒尝试输出12次
            consumeLiquid(Liquids., f / 60f); // + .boost(); 消耗的液体 + 强化
            consumeLiquids(LiquidStack.with(Liquids., f / 60f));
            consumeCoolant(f); // + .boost(); 消耗任意冷却液 + 强化
            consumePower(f / 60f); // 消耗的电力
            consumeItem(Items., ); // 消耗的物品
            consumeItems(ItemStack.with(Items., , Items., ));

            // 渲染
            variants = ; // 0 不同的变体贴图数量
            drawArrow = ; // true 是否绘制旋转箭头
            drawTeamOverlay = ; // true 是否绘制队伍标识
            squareSprite = ; // true 贴图是否为完整方块
            enableDrawStatus = ; // true 是否绘制状态
            lightLiquid = Liquids.; // 用于光照效果的液体
            offset = f; // 0f 方块在网格中的偏移量
            clipSize = f; // -1f 方块的贴图裁剪范围大小
            lightClipSize = f; // 仅用于光照的裁剪范围
            cacheLayer = CacheLayer.; // 缓存渲染层类型
            fillsTile = ; // true 如果为 false，即使被缓存，也会在方块下方绘制地板
            forceDark = ; // false 是否强制让这个方块被黑暗/战争迷雾覆盖
            drawLiquidLight = ; // true 是否绘制液体的发光效果
            mapColor = ; // 小地图颜色
            hasColor = ; //false 是否具有小地图颜色
            outlineColor = Color.valueOf(""); // 404049 方块图标的轮廓颜色
            outlineIcon = ; // false 是否有图标轮廓
            outlineRadius = ; // 4 轮廓宽度
            outlinedIcon = ; // -1 哪个图标区域会添加轮廓
            hasShadow = ; // true 下方是否有阴影
            customShadow = ; // false 是否绘制自定义阴影(VeName-shadow)
            albedo = f; // 0f 反射率
            lightColor = Color.valueOf(""); // 方块自身发出的环境光颜色
            emitLight = ; // false 是否调用drawLight()
            obstructsLight = ; // true 是否遮挡其他方块发出的光线
            lightRadius = f; // 60f 光照半径
            useColor = ; // true 是否在小地图中使用这个方块的颜色
            // 音效
            configureSound = Sounds.; // click 进行配置时产生的音效
            placePitchChange = ; // true 建造时是否改变建造音效的音高
            breakPitchChange = ; // true 拆除时是否改变拆除音效的音高
            placeSound = Sounds.; // unset 建造音效
            breakSound = Sounds.; // unset 拆除音效
            destroySound = Sounds.; // unset 摧毁音效
            destroySoundVolume = f; // 1f 摧毁音效音量
            destroyPitchMin = f; // 1f 摧毁音效音调范围
            destroyPitchMax = f; // 1f
            ambientSound = Sounds.; // none 空闲时发出的声音
            ambientSoundVolume = f; // 0.05f 空闲音效音量
            // 粒子效果
            placeEffect = Fx.; // placeBlock 放置效果
            breakEffect = Fx.; // breakBlock 拆除效果
            destroyEffect = Fx.; // dynamicExplosion 摧毁效果

        }};
        */

        /*
        effect = new ParticleEffect() {{
            // = new ParticleEffect() {{
            colorFrom = Color.valueOf(""); // Color.white.cpy() 粒子起始颜色
            colorTo = Color.valueOf(""); // Color.white.cpy() 粒子结束颜色
            particles = ; // 6 粒子数量
            randLength = ; // true 是否随机粒子长度
            casingFlip = ; // 是否支持弹壳翻转效果
            cone = f; // 180f 粒子发射锥形角度
            length = f; // 20f 粒子最大长度/距离
            baseLength = f; // 0f 粒子基础长度
            interp = Interp.; // linear 粒子大小/长度变化的插值方式
            sizeInterp = ; // null 粒子大小的专用插值
            offsetX = f; // 粒子位置偏移
            offsetY = f;
            lightScl = f; // 2f 光照大小缩放
            lightOpacity = f; // 0.6f 光照透明度
            lightColor = Color.valueOf(""); // 光照颜色
            //region only
            spin = f; // 每帧旋转角度
            sizeFrom = f; // 2f 贴图起始大小
            sizeTo = f; // 0f 贴图结束大小
            sizeChangeStart = f; // 0f 贴图开始改变大小的延迟时间
            useRotation = ; // true 是否继承父级旋转
            offset = f; // 0 旋转角度偏移
            region = ; // "circle" 使用的纹理名称
            // line only
            line = ; // 是否使用线条模式
            strokeFrom = f; // 2f 线条起始粗细
            strokeTo = f; // 0f 线条结束粗细
            lenFrom = f; // 4f 线条起始长度
            lenTo = f; // 2f 线条结束长度
            cap = ; // true 是否绘制端点

            // = new ExplosionEffect() {{
            // 冲击波
            waveColor = Color.valueOf(""); // ffd2ae 冲击波颜色
            waveLife = f; // 6f 冲击波存在时间
            waveStroke = f; // 3f 冲击波线条粗细
            waveRad = f; // 15f 冲击波最大半径
            waveRadBase = f; // 2f 冲击波基础半径
            // 烟雾
            smokeColor = Color.valueOf(""); // Color.gray 烟雾颜色
            smokeSize = f; // 4f 烟雾最终大小
            smokeSizeBase = f; // 0.5f 烟雾基础大小
            smokeRad = f; // 23f 烟雾扩散半径
            smokes = ; // 5 烟雾数量
            // 火花
            sparkColor = Color.valueOf(""); // e58956 火花颜色
            sparkStroke = f; // 1f 火花线条粗细
            sparkRad = f; // 23f 火花扩散半径
            sparkLen = f; // 3f 火花长度
            sparks = ; // 4 火花数量
            // Effect
            clip = 100f; // 特效的裁剪范围
            lifetime = 22f; // 50f 特效存在时间

            // = new MultiEffect(各个粒子效果);

            // = new RadialEffect(effect, amount, spacing, lengthOffset, effectRotationOffset) {{
            effect = Fx.; // Fx.none
            rotationSpacing = f; // 90f 特效之间的旋转间隔角度
            rotationOffset = f; // 0f 整体旋转偏移角度
            effectRotationOffset = f; // 0f 特效自身的旋转偏移
            lengthOffset = f; // 0f 特效离中心的距离偏移
            amount = ; // 4 特效数量
            // Effect
            clip = 100f; // 特效的裁剪范围

            // = new SeqEffect(按顺序的各个粒子效果);

            // = new SoundEffect(sound, effect) {{
            sound = Sounds.; // none 播放的音效
            minPitch = f; // 0.8f 最小音调
            maxPitch = f; // 1.2f 最大音调
            minVolume = f; // 1f 最小音量
            maxVolume = f; // 1f 最大音量
            effect = Fx.; // 粒子效果
            // Effect
            startDelay = -1f; // 特效开始前的延迟时间

            // = new WaveEffect() {{
            colorFrom = Color.valueOf(""); // Color.white.cpy() 光环起始颜色
            colorTo = Color.valueOf(""); // Color.white.cpy() 光环结束颜色
            lightColor = Color.valueOf(""); // 光照颜色
            sizeFrom = f; // 0f 光环起始大小
            sizeTo = f; // 100f 光环结束大小
            lightScl = f; // 3f 光照大小缩放
            lightOpacity = f; // 0.8f 光照透明度
            sides = f; // -1 多边形边数
            rotation = f; // 0f 整体旋转角度
            strokeFrom = f; // 2f 起始线条粗细
            strokeTo = f; // 0f 结束线条粗细
            interp = Interp.; // linear 大小/颜色变化的插值方式
            lightInterp = Interp.; // reverse 光照的专用插值
            offsetX = f; // 光环中心偏移量
            offsetY = f;
            // Effect
            clip = Math.max(clip, Math.max(sizeFrom, sizeTo) + Math.max(strokeFrom, strokeTo)); // 特效的裁剪范围

            // = new WrapEffect(effect, color, rotation) {{
            effect = Fx.; // none
            color = ; Color.valueOf("")// Color.white.cpy()
            rotation = f; // 0f 整体旋转角度

            // = new Effect(life, clipsize, renderer) {{
            shakeFalloff = f; // 10000f 屏幕震动衰减系数
            renderer = ; // 特效的渲染逻辑
            lifetime = f; // 50f 特效存在时间
            clip = f; // 特效的裁剪范围
            startDelay = f; // 特效开始前的延迟时间
            baseRotation = f; // 基础旋转角度
            followParent = ; // true 是否跟随父级单位移动
            rotWithParent = ; // 是否跟随父级单位旋转
            layer = f; // Layer.effect 特效的渲染层
            layerDuration = f; // 特定层的持续时间
        }};
        */
    }

}
