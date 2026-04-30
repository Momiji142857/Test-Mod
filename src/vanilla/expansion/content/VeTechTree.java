package vanilla.expansion.content;

import arc.struct.Seq;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.game.Objectives;

import static mindustry.content.Items.*;
import static mindustry.content.Liquids.*;
import static mindustry.content.TechTree.*;
import static vanilla.expansion.content.VeBlocks.*;
import static vanilla.expansion.content.VeItems.*;
import static vanilla.expansion.content.VeLiquids.*;
import static vanilla.expansion.content.VeSectors.*;

public class VeTechTree {
    public static void load() {

        // cyclant
        VePlanets.cyclant.techTree = nodeRoot("ve-cyclant", coreNucleusRoot, () -> {

            // Items & Liquids
            nodeProduce(aluminium, () -> {
                nodeProduce(carbonShaleCobble, () -> {
                    nodeProduce(shaleCobble, () -> {

                    });
                });

                nodeProduce(catalyzon, () -> {
                    nodeProduce(fusionFuel, () -> {

                    });
                });

                nodeProduce(chromium, () -> {
                    nodeProduce(cobalt, () -> {
                        nodeProduce(capacitor, () -> {

                        });

                        nodeProduce(fibralt, () -> {

                        });

                        nodeProduce(warpNucleus, () -> {

                        });
                    });
                });

                nodeProduce(quartz, () -> {
                    nodeProduce(lava, () -> {

                    });

                    nodeProduce(silicide, () -> {

                    });
                });

                nodeProduce(salt, () -> {
                    nodeProduce(chlorine, () -> {

                    });

                    nodeProduce(plantMatter, () -> {
                        nodeProduce(nitroalkoss, () -> {

                        });
                    });

                    nodeProduce(sodium, () -> {

                    });
                });
            });

            /*
            nodeProduce(aluminium, () -> {
                nodeProduce(water, () -> {

                });

                nodeProduce(lead, () -> {
                    nodeProduce(Items.titanium, () -> {
                        nodeProduce(Liquids.cryofluid, () -> {

                        });

                        nodeProduce(Items.thorium, () -> {
                            nodeProduce(Items.surgeAlloy, () -> {

                            });

                            nodeProduce(Items.phaseFabric, () -> {

                            });
                        });
                    });

                    nodeProduce(Items.metaglass, () -> {

                    });

                    nodeProduce(chromium, () -> {
                        nodeProduce(cobalt, () -> {
                            nodeProduce(capacitor, () -> {

                            });

                            nodeProduce(fibralt, () -> {

                            });

                            nodeProduce(warpNucleus, () -> {

                            });
                        });
                    });
                });

                nodeProduce(sand, () -> {
                    nodeProduce(Items.scrap, () -> {
                        nodeProduce(Liquids.slag, () -> {

                        });

                        nodeProduce(catalyzon, () -> {
                            nodeProduce(fusionFuel, () -> {

                            });
                        });
                    });

                    nodeProduce(coal, () -> {
                        nodeProduce(Items.graphite, () -> {
                            nodeProduce(Items.silicon, () -> {

                            });
                        });

                        nodeProduce(Items.pyratite, () -> {
                            nodeProduce(Items.blastCompound, () -> {

                            });
                        });

                        nodeProduce(Items.sporePod, () -> {

                        });

                        nodeProduce(Liquids.oil, () -> {
                            nodeProduce(Items.plastanium, () -> {

                            });
                        });
                    });

                    nodeProduce(quartz, () -> {
                        nodeProduce(lava, () -> {

                        });

                        nodeProduce(silicide, () -> {

                        });
                    });

                    nodeProduce(salt, () -> {
                        nodeProduce(hydrogen, () -> {

                        });

                        nodeProduce(chlorine, () -> {

                        });

                        nodeProduce(plantMatter, () -> {
                            nodeProduce(nitroalkoss, () -> {

                            });
                        });

                        nodeProduce(sodium, () -> {

                        });
                    });

                    nodeProduce(carbonShaleCobble, () -> {
                        nodeProduce(shaleCobble, () -> {

                        });
                    });
                });
            });
             */

            // Sectors
            node(barrierHill, () -> {
                node(carbonRelics, Seq.with(
                        new Objectives.SectorComplete(barrierHill),
                        new Objectives.Research(isomorphicCoreShard),
                        new Objectives.Research(frag)
                ), () -> {
                    node(intervalley, Seq.with(
                            //
                    ), () -> {
                        node(volcanicTop, Seq.with(
                                //
                        ), () -> {
                            node(fortPort, Seq.with(
                                    //
                            ), () -> {
                                node(fungusFactory, Seq.with(
                                        //
                                ), () -> {
                                    node(isolateIsland, Seq.with(
                                            //
                                    ), () -> {

                                    });
                                });

                                node(gobi, Seq.with(
                                        //
                                ), () -> {
                                    node(shaleQuarry, Seq.with(
                                            //
                                    ), () -> {
                                        node(unitLaboratory, Seq.with(
                                                //
                                        ), () -> {
                                            node(ruins, Seq.with(
                                                    //
                                            ), () -> {

                                            });

                                            node(siliconFacility, Seq.with(
                                                    //
                                            ), () -> {

                                            });

                                            node(thoriumHacienda, Seq.with(
                                                    //
                                            ), () -> {
                                                node(blastTest, Seq.with(
                                                        //
                                                ), () -> {

                                                });

                                                node(nuclearPowerplant, Seq.with(
                                                        //
                                                ), () -> {
                                                    node(crossForest, Seq.with(
                                                            //
                                                    ), () -> {
                                                        node(primeRoute, Seq.with(
                                                                //
                                                        ), () -> {
                                                            node(planetaryCargoCenter, Seq.with(
                                                                    //
                                                            ), () -> {
                                                                node(retreatZone, Seq.with(
                                                                        //
                                                                ), () -> {

                                                                });
                                                            });
                                                        });
                                                    });
                                                });
                                            });
                                        });
                                    });
                                });
                            });
                        });
                    });

                    node(wetlandMiningfield, Seq.with(
                            //
                    ), () -> {

                    });
                });
            });

            // turrets & defense
            node(click, Seq.with(new Objectives.OnSector(barrierHill)), () -> {
                node(aluminiumWall, () -> {
                    node(aluminiumLeadWall, () -> {
                        node(aluminiumLeadWallLarge, () -> {
                            node(aluminiumLeadWallHuge, () -> {

                            });
                        });
                    });

                    node(aluminiumWallLarge, () -> {
                        node(aluminiumWallHuge, () -> {

                        });
                    });
                });

                node(beat, () -> {

                });

                node(frag, () -> {
                    node(rise, () -> {
                        node(bake, () -> {

                        });
                    });
                });

                node(pulse, Seq.with(new Objectives.SectorComplete(barrierHill)), () -> {
                    node(waterer, Seq.with(new Objectives.OnSector(wetlandMiningfield)), () -> {

                    });
                });
            });

            // production
            node(isomorphicDrill, Seq.with(new Objectives.OnSector(barrierHill)), () -> {
                node(isomorphicDrillHuge, () -> {

                });

                node(isomorphicPress, Seq.with(new Objectives.OnSector(barrierHill)), () -> {
                    node(hydraulicPress, Seq.with(new Objectives.OnSector(fortPort)), () -> {

                    });

                    node(isomorphicKiln, Seq.with(new Objectives.SectorComplete(carbonRelics)), () -> {

                    });

                    node(quartzSeparator, Seq.with(new Objectives.SectorComplete(barrierHill)), () -> {
                        /*
                        node(isomorphicPulverizer, () -> {

                        });
                        */
                        node(isomorphicSmelter, () -> {

                        });

                        node(quartzSeparatorLarge, Seq.with(new Objectives.OnSector(fortPort)), () -> {

                        });
                    });
                });

                node(laserBore, Seq.with(new Objectives.OnSector(carbonRelics)), () -> {

                });

                node(powerDrill, Seq.with(new Objectives.SectorComplete(barrierHill)), () -> {

                });
            });

            // transport
            node(rail, () -> {
                node(railJunction, () -> {
                    node(railRouter, () -> {
/*

                        node(advancedLaunchPad, () -> {

                        });
*/

                        node(railBridge, () -> {

                        });

                        node(railOverflowGate, () -> {
                            node(railUnderflowGate, () -> {

                            });
                        });

                        node(railUnloader, () -> {

                        });
/*

                        node(stackRail, () -> {

                        });
*/

                    });
                });
            });

        });

        Blocks.swarmer.shownPlanets.addAll(VePlanets.cyclant, VePlanets.maress);

    }

}
