package vanilla.expansion.content;

import arc.audio.RandomSound;
import arc.graphics.Blending;
import arc.graphics.Color;
import arc.math.Interp;
import arc.math.Mathf;
import arc.math.geom.Rect;
import arc.struct.Seq;
import mindustry.Vars;
import mindustry.ai.UnitCommand;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.entities.pattern.ShootBarrel;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.*;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.StatusEffect;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.weapons.*;
import mindustry.world.meta.BlockFlag;
import mindustry.world.meta.Env;
import vanilla.expansion.VeEntities.Bullet.BulletChain;
import vanilla.expansion.VeEntities.Bullet.ChainFragBullet;
import vanilla.expansion.VeEntities.Bullet.FragLayer;
import vanilla.expansion.VeEntities.Part.StatefulRegionPart;
import vanilla.expansion.VeEntities.Part.VePartProgress;
import vanilla.expansion.VeType.StatefulWeapon;

import static vanilla.expansion.VanillaExpansion.VeName;

public class VeUnitTypes {

    public static UnitType
            // core units
            theta, lambda, sigma, delta, omega,
                    thetaTether, lambdaTether, sigmaTether,

            iota, iotaFungikiller, iotaStg,

            zeta, eta,

            // 特种单位 - cyclant
            // armorcar
            conscript, arrange, charge, capture, triumph,

            // crabbot
            smarb, mider, velocite, slidoid, hovopid,

            // hovership
            dust, mist, haze, hurricane, meteorology,

            // 反制单位
            flocculate, alleviate,

            // 强化单位
            // 陆战
            blade, hammer, ballistic, firelock, ray,

            // 陆辅
            stardust, vortex, nebula, galaxy, universe,

            // 空战
            aurora, plasma, solar, magnetic, corona,

            // 空辅
            point, line, square, stereo, meta,

            // maress
            vibrate, shake, quake,
                    sparkle, plasm, surge, tide, thunder,
                    shimmer, daybreak, sunrise,
                    uprise, soar, hover, dive,

            // Boss
            thoriumEradicator, hugeDagger, hyper,

            // 改装单位
            lance, hoe,
                    astrologe,
                    prominence, stellar,
                    string, plain,

            // 特殊单位
            flyLaserDrill, wideFortress, alev, toxorpion, antumbright, eclire,
                    thoriumBlaster, thoriumBomber, thoriumRocketeer,
                    egnarra, magneticSmall, duplicator, duplicatorSmall,

            md, j, kobe, shard, coreNucleusUnit,

            // assembly drone
            assemblyDroneVe, assemblyDroneHyper,

            // missile
            pantypeMissile, pantypeMissileNitroalkoss, pantypeMissilePhase, pantypeMissileSilicide, pantypeMissileSilicon, pantypeMissileSurge, pantypeMissileThorium, pantypeMissileWarp,
                    chargeMissile, hurricaneMissile, meteorologyOrb, alleviateMissile,
                    metaOrb, metaOrbSmall,
                    hyperMissile,
                    thoriumRocketeerMissileAccel, thoriumRocketeerMissile,
                    surgeMissile,

            // test
            test1, test2, test3, test4, test5, test6, test7, test8, test9,
                    testA, testB, testC, testD, testE, testF, testGHead, testGTail,
                    testMissile, testMissileLarge, testOutline,

            // 超维
            hyperDebrisBack, hyperDebrisFrontl, hyperDebrisFrontr, hyperDebrisRing1, hyperDebrisRing2, hyperDebrisShellL, hyperDebrisShellR, hyperDebrisSidedL, hyperDebrisSidedR, hyperDebrisSideL,
                    hyperDebrisSideR, hyperOrb, hyperSpawn,

            // 菌噬体
            fungitronAbsorb, fungitronAttackLaser, fungitronAttackMissileUnit, fungitronAttackMissile, fungitronExplosion, fungitronMass1, fungitronMass2, fungitronMass3, fungitronMass4, fungitronMissile,
                    fungitronPhase1, fungitronPhase2L, fungitronPhase2R, fungitronPhase3LD, fungitronPhase3LU, fungitronPhase3RD, fungitronPhase3RU, fungitronPrebattle, fungitronRoarShort, fungitronRoar,
                    fungusFactoryDie,

            // 西击舰
            octPainted,
                    zentackArmLCannon, zentackArmL, zentackArmRCannon, zentackArmR, zentackBody, zentackCannonMid, zentackClawLCannon, zentackClawL, zentackClawRCannon, zentackClawR,
                    zentackGun, zentackHeadL, zentackHeadR, zentackLegL, zentackLegR, zentackLightning, zentackMissile,

            // 潜行小游戏
            zenithSentry,
            // 其他

            iotaStealth, turretUnitBuildTower, coronaSpawn, magneticSpawn, metaSpawn, mgsSpotIdea, mgsSpotNotice, mgsSpot, omegaAngry1, omegaAngry2,
                    omegaObserver, speaker, surgeOfficerHuh, surgeOfficer, thoriumBomberCircle, zenithAudience, zenithMelondropper, zenithPilot;

            /*
            "flying": UnitEntity::create;
            "mech": MechUnit::create;
            "legs": LegsUnit::create;
            "naval": UnitWaterMove::create;
            "payload": PayloadUnit::create;
            "missile": TimedKillUnit::create;
            "tank": TankUnit::create;
            "hover": ElevationMoveUnit::create;
            "tether": BuildingTetherPayloadUnit::create;
            "crawl": CrawlUnit::create;
            */

    public static void load() {

        // core units
        theta = new UnitType("theta") {{
            constructor = UnitEntity::create;
            health = 180f;
            armor = 0f; // -
            hitSize = 10f;
            mineSpeed = 7f;
            mineTier = 1;
            mineWalls = true;
            buildRange = Vars.buildingRange; // -
            buildSpeed = 0.5f;
            itemCapacity = 30;
            pickupUnits = false;
            payloadCapacity = 0f;
            fogRadius = 0f;
            researchCostMultiplier = 0f; // -
            isEnemy = false;
            flying = true;
            speed = 3.3f;
            rotateSpeed = 15f;
            drag = 0.05f;
            accel = 0.1f;
            faceTarget = true; // -
            lowAltitude = true;
            drawBuildBeam = true; // -
            buildBeamOffset = 3f;
            mineBeamOffset = 3.25f;
            engineOffset = 6f;
            engineSize = 2.5f; // -
            lightColor = Pal.accent;
            immunities.add(VeStatusEffects.frozen);
            targetFlags = new BlockFlag[] {BlockFlag.drill, BlockFlag.factory};
            weapons.add(new Weapon(VeName("theta-weapon")) {{
                rotate = false; // -
                top = false;
                shootX = -0.75f;
                shootY = 2.75f;
                x = 3f;
                y = 2.25f;
                ejectEffect = Fx.none; // -
                parentizeEffects = true;
                recoil = 1f;
                heatColor = Color.white;
                shootSound = Sounds.shootLaser;
                reload = 17f;
                bullet = new LaserBoltBulletType(4.5f, 13f) {{
                    width = 2f; // -
                    height = 9f;
                    backColor = frontColor = Pal.accent;
                    shrinkY = 0f;
                    lifetime = 35f;
                    buildingDamageMultiplier = 0.01f;
                    collidesTeam = true;
                    healAmount = 5f;
                    hitEffect = despawnEffect = new WaveEffect() {{
                        colorFrom = colorTo = Pal.accent;
                        sizeFrom = 1f;
                        sizeTo = 5f;
                        sides = 12;
                        strokeFrom = 2f; // -
                        strokeTo = 0f; // -
                        lifetime = 10f;
                    }};
                    shootEffect = new WaveEffect() {{
                        colorFrom = colorTo = Pal.accent;
                        sizeFrom = 1f;
                        sizeTo = 4f;
                        sides = 12;
                        strokeFrom = 2f; // -
                        strokeTo = 0f; // -
                        lifetime = 10f;
                        followParent = true; // -
                        rotWithParent = true;
                    }};
                    smokeEffect = new WaveEffect() {{
                        colorFrom = colorTo = Pal.accent;
                        sizeFrom = 2f;
                        sizeTo = 0f;
                        sides = 12;
                        strokeFrom = 1f;
                        strokeTo = 1f;
                        lifetime = 10f;
                        followParent = true; // -
                        rotWithParent = true;
                    }};
                    lightColor = Pal.accent;
                }};
            }});
        }};

        lambda = new UnitType("lambda") {{
            constructor = UnitEntity::create;
            health = 250f;
            armor = 1f;
            hitSize = 11f;
            mineSpeed = 8f;
            mineTier = 2;
            mineWalls = true;
            buildRange += 20f;
            buildSpeed = 0.85f;
            itemCapacity = 50;
            pickupUnits = false;
            payloadCapacity = 0f;
            fogRadius = 0f;
            researchCostMultiplier = 0f; // -
            isEnemy = false;
            flying = true;
            speed = 3.5f;
            rotateSpeed = 10f;
            drag = 0.05f;
            accel = 0.1f;
            faceTarget = false;
            lowAltitude = true;
            drawBuildBeam = true; // -
            buildBeamOffset = 5f;
            mineBeamOffset = 4.5f;
            engineOffset = 6.5f;
            engineSize = 3.25f;
            lightColor = Pal.accent;
            immunities.add(VeStatusEffects.frozen);
            targetFlags = new BlockFlag[] {BlockFlag.drill, BlockFlag.factory};
            weapons.add(
                    new Weapon(VeName("lambda-weapon")) {{
                        alternate = false;
                        rotate = true;
                        rotateSpeed = 10f;
                        top = false;
                        shootX = 1.5f;
                        shootY = 5.5f;
                        x = 2f;
                        y = 0f; // -
                        shoot.firstShotDelay = 22f;
                        ejectEffect = Fx.none; // -
                        parentizeEffects = true;
                        recoil = 2.25f;
                        recoilTime = 22f;
                        recoilPow = 2f;
                        heatColor = Color.white;
                        shootSound = Sounds.shootLaser;
                        reload = 25f;
                        parts.add(new ShapePart() {{
                            circle = true;
                            radius = 0f;
                            radiusTo = 2f;
                            x = 1.5f;
                            y = 5.5f;
                            color = Pal.accent;
                            progress = PartProgress.charge.curve(Interp.circleOut);
                            layer = 110;
                        }});
                        bullet = new BasicBulletType(5f, 19f) {{
                            backColor = frontColor = Pal.accent;
                            width = 6f;
                            height = 6f;
                            shrinkY = 0f;
                            sprite = "circle-bullet";
                            lifetime = 35f;
                            buildingDamageMultiplier = 0.01f;
                            collidesTeam = true;
                            healPercent = 5f;
                            hitEffect = Fx.hitLaserBlast;
                            hitColor = Pal.accent;
                            despawnEffect = Fx.hitLaserBlast;
                            shootEffect = new WaveEffect() {{
                                colorFrom = colorTo = Pal.accent;
                                sizeFrom = 1f;
                                sizeTo = 5f;
                                sides = 12;
                                strokeFrom = 3f;
                                strokeTo = 0f; // -
                                lifetime = 10f;
                                followParent = true; // -
                                rotWithParent = true;
                            }};
                            chargeEffect = new SoundEffect(VeSounds.get("msChargeLittle"), Fx.none) {{
                                minPitch = 1f;
                                maxPitch = 1f;
                                minVolume = 0.25f;
                                maxVolume = 0.25f;
                            }};
                            smokeEffect = new WaveEffect() {{
                                colorFrom = colorTo = Pal.accent;
                                sizeFrom = 2f;
                                sizeTo = 0f;
                                sides = 12;
                                strokeFrom = 1f;
                                strokeTo = 1f;
                                lifetime = 10f;
                                followParent = true; // -
                                rotWithParent = true;
                            }};
                            lightColor = trailColor = Pal.accent;
                            trailEffect = Fx.missileTrail;
                            trailLength = 3;
                            trailWidth = 3f;
                        }};
                    }},
                    new Weapon(VeName("lambda-shell")) {{
                        display = false;
                        mirror = false;
                        rotate = false; // -
                        top = false;
                        x = 0f;
                        y = 0f; // -
                        recoil = 0f;
                        minWarmup = 2f;
                        shootSound = Sounds.none;
                        reload = 60f;
                    }}
            );
        }};

        sigma = new UnitType("sigma") {{
            constructor = UnitEntity::create;
            health = 250f;
            armor = 2f;
            hitSize = 12f;
            mineSpeed = 9f;
            mineTier = 2;
            mineWalls = true;
            buildRange += 30f;
            buildSpeed = 1.2f;
            itemCapacity = 70;
            pickupUnits = false;
            // payloadCapacity = Mathf.sqr(1f) * Vars.tilePayload;
            fogRadius = 0f;
            researchCostMultiplier = 0f; // -
            isEnemy = false;
            flying = true;
            speed = 3.6f;
            rotateSpeed = 10f;
            drag = 0.05f;
            accel = 0.1f;
            faceTarget = true; // -
            lowAltitude = true;
            drawBuildBeam = true; // -
            buildBeamOffset = 4.5f;
            mineBeamOffset = 4f;
            engineOffset = 8f;
            engineSize = 3.5f;
            lightColor = Pal.accent;
            immunities.add(VeStatusEffects.frozen);
            targetFlags = new BlockFlag[] {BlockFlag.battery, BlockFlag.storage};
            weapons.add(new Weapon(VeName("sigma-weapon")) {{
                rotate = false; // -
                top = false;
                shootX = 0f; // -
                shootY = 0f;
                x = 8.25f;
                y = 1.25f;
                ejectEffect = Fx.casing1;
                recoil = 1f;
                recoilTime = 5f; // -
                minWarmup = 0.95f;
                shootWarmupSpeed = 0.3f;
                shootSound = Sounds.shootSalvo;
                reload = 5f;
                parts.add(
                        new RegionPart() {{
                            suffix = "-weapon";
                            progress = PartProgress.warmup; // -
                            layerOffset = -0.0001f;
                            x = -4f;
                            y = -4.25f;
                            rotation = 90f;
                            moveX = 4f;
                            moveRot = -90f;
                            under = true;
                        }},
                        new RegionPart() {{
                            suffix = "-side";
                            progress = PartProgress.warmup; // -
                            x = -8.25f;
                            y = -1.25f;
                            moveX = 4f;
                            moveRot = -5f;
                            under = true;
                        }},
                        new RegionPart() {{
                            suffix = "-shell";
                            progress = PartProgress.recoil;
                            x = -8.25f;
                            y = -1.25f;
                            moveY = 1f;
                            under = false; // -
                        }}
                );
                bullet = new BasicBulletType(7f, 11f) {{
                    width = 6.5f;
                    height = 15f;
                    shrinkY = 0f;
                    lifetime = 35f;
                    buildingDamageMultiplier = 0.01f;
                    homingPower = 0.1f;
                    homingDelay = 10f;
                    fragBullets = 2;
                    fragBullet = new LightningBulletType() {{
                        speed = 0.0001f;
                        damage = 5f;
                        buildingDamageMultiplier = 0f;
                        collidesTiles = false;
                        status = StatusEffects.shocked; // -
                        statusDuration = 10f;
                        lightningColor = hitColor = lightColor = Pal.accent;
                        lightningLength = 5;
                        // despawnSound = VESounds.get("sparkBullet");
                    }};
                    hitEffect = despawnEffect = Fx.hitScepterSecondary;
                    shootEffect = Fx.shootSmall; // -
                    smokeEffect = Fx.shootSmallSmoke; // -
                    lightColor = trailColor = Pal.accent;
                    trailChance = 0.04f;
                    trailEffect = Fx.bulletSparkSmokeTrailSmall;
                    trailSpread = 12f;
                    trailLength = 3;
                    hitSound = Sounds.shockBullet;
                }};
            }});
        }};

        delta = new UnitType("delta") {{
            constructor = PayloadUnit::create;
            health = 460f;
            armor = 3f;
            hitSize = 15f;
            mineSpeed = 10f;
            mineTier = 3;
            mineWalls = true;
            buildRange += 60f;
            buildSpeed = 1.6f;
            itemCapacity = 90;
            pickupUnits = true; // -
            payloadCapacity = Mathf.sqr(2f) * Vars.tilePayload;
            fogRadius = 0f;
            researchCostMultiplier = 0f; // -
            isEnemy = false;
            flying = true;
            speed = 3.9f;
            rotateSpeed = 12f;
            drag = 0.035f;
            accel = 0.1f;
            faceTarget = false;
            lowAltitude = true;
            drawBuildBeam = false;
            mineBeamOffset = 6f;
            engineOffset = 8f;
            engineSize = 3.25f;
            lightColor = Pal.accent;
            immunities.add(VeStatusEffects.frozen);
            targetFlags = new BlockFlag[] {BlockFlag.storage, BlockFlag.repair};
            weapons.add(
                    new BuildWeapon() {{
                        rotate = false;
                        top = false;
                        shootX = 0f; // -
                        shootY = 0f;
                        x = 2.5f;
                        y = 7.75f;
                    }},
                    new Weapon(VeName("delta-weapon")) {{
                        rotate = true;
                        baseRotation = 0f; // -
                        rotateSpeed = 5f;
                        layerOffset = -0.001f;
                        shootX = 5.5f;
                        shootY = 8.25f;
                        x = 0f;
                        y = -3f;
                        shake = 2f;
                        ejectEffect = Fx.casing3;
                        recoil = 3f;
                        shootSound = VeSounds.get("bangClassic");
                        reload = 30f;
                        bullet = new ArtilleryBulletType(1f, 15f) {{
                            hitSound = Sounds.explosionArtillery; // -
                            backColor = Color.valueOf("f9c27a");
                            frontColor = Pal.accent;
                            width = 8f;
                            height = 8f;
                            shrinkY = 0f;
                            sprite = "missile-large";
                            lifetime = 95f;
                            scaleLife = false;
                            maxRange = 280f;
                            drag = -0.02f;
                            buildingDamageMultiplier = 0.01f;
                            armorMultiplier = 0.3f;
                            hitSize = 6f;
                            collidesTiles = true;
                            collidesAir = true;
                            collides = true;
                            homingPower = 0.06f;
                            homingRange = 72f;
                            homingDelay = 15f;
                            splashDamage = 28f;
                            splashDamageRadius = 32f;
                            status = StatusEffects.blasted;
                            statusDuration = 60f;
                            hitEffect = new ExplosionEffect() {{
                                waveColor = Color.valueOf("989aa4");
                                waveStroke = 3f; // -
                                waveRad = 32f;
                                sparkColor = Pal.accent;
                            }};
                            /*
                            hitEffect = new MultiEffect(
                                    new ExplosionEffect() {{
                                        waveColor = Color.valueOf("989aa4");
                                        waveStroke = 3f; // -
                                        waveRad = 32f;
                                        sparkColor = Pal.accent;
                                    }}
                            );
                            */

                            despawnEffect = new ExplosionEffect() {{
                                waveColor = Color.valueOf("989aa4");
                                waveStroke = 3f; // -
                                waveRad = 32f;
                                sparkColor = Pal.accent;
                            }};
                            /*
                            despawnEffect = new MultiEffect(
                                    new ExplosionEffect() {{
                                        waveColor = Color.valueOf("989aa4");
                                        waveStroke = 3f; // -
                                        waveRad = 32f;
                                        sparkColor = Pal.accent;
                                    }}
                            );
                            */

                            shootEffect = Fx.shootBig; // -
                            smokeEffect = Fx.shootBigSmoke;
                            hitShake = 2f;
                            lightColor = Pal.accent;
                            trailColor = Color.valueOf("f9c27aaa");
                            trailInterval = 5f;
                            trailEffect = Fx.missileTrail;
                            despawnSound = Sounds.explosionArtillery;
                        }};
                    }},
                    new Weapon(VeName("small-mount-weapon")) {{
                        rotate = true;
                        rotateSpeed = 15f;
                        top = false;
                        x = 2.75f;
                        y = 1.75f;
                        shoot = new ShootSpread() {{
                            spread = 0f;
                            shots = 3;
                            shotDelay = 4f;
                        }};
                        ejectEffect = Fx.casing1;
                        shootSound = Sounds.shootCyclone;
                        reload = 20f;
                        inaccuracy = 3f;
                        bullet = new BasicBulletType(4f, 11f) {{
                            width = 6.5f;
                            height = 11f;
                            shrinkY = 0f;
                            spin = 10f;
                            lifetime = 70f;
                            buildingDamageMultiplier = 0.01f;
                            pierceArmor = true;
                            hitSize = 10f;
                            shootEffect = Fx.shootSmall; // -
                            smokeEffect = Fx.shootSmallSmoke; // -
                            lightColor = Pal.accent;
                        }};
                    }}
            );
        }};

        omega = new UnitType("omega") {{
            constructor = PayloadUnit::create;
            health = 620f;
            armor = 5f;
            hitSize = 16f;
            mineRange = 110f;
            mineSpeed = 11f;
            mineTier = 3;
            mineWalls = true;
            buildRange += 100f;
            buildSpeed = 2.1f;
            itemCapacity = 110;
            pickupUnits = true; // -
            payloadCapacity = Mathf.sqr(2.5f) * Vars.tilePayload;
            fogRadius = 0f;
            researchCostMultiplier = 0f; // -
            isEnemy = false;
            flying = true;
            speed = 4.3f;
            rotateSpeed = 9f;
            drag = 0.035f;
            accel = 0.095f;
            faceTarget = true; // -
            lowAltitude = true;
            drawBuildBeam = true; // -
            buildBeamOffset = 3.5f;
            mineBeamOffset = 5.75f;
            engineOffset = 9f;
            engineSize = 3.75f;
            lightColor = Pal.accent;
            immunities.add(VeStatusEffects.frozen);
            targetFlags = new BlockFlag[] {BlockFlag.turret, BlockFlag.generator, BlockFlag.battery, BlockFlag.repair};
            abilities.add(
                    new ShieldArcAbility() {{
                        radius = 20f;
                        regen = 0.4f;
                        max = 380f;
                        cooldown = 60f;
                        angle = 120f;
                        angleOffset = 0f; // -
                        whenShooting = true; // -
                        width = 9f;
                        pushUnits = false;
                    }}
            );
            weapons.add(
                    new BuildWeapon() {{
                        rotate = false;
                        top = false;
                        shootX = 0f; // -
                        shootY = 0f;
                        x = 6f;
                        y = 6f;
                    }},
                    new Weapon(VeName("fast-power-weapon")) {{
                        rotate = false; // -
                        top = false;
                        shootX = 0f; // -
                        shootY = 4f;
                        x = 3.75f;
                        y = -4.25f;
                        shoot.shots = 5;
                        shoot.shotDelay = 3f;
                        ejectEffect = Fx.casing1;
                        shootSound = Sounds.shootSalvo;
                        reload = 20f;
                        inaccuracy = 1.5f;
                        bullet = new BasicBulletType(7f, 17f) {{
                            width = 7f;
                            height = 16f;
                            shrinkY = 0f;
                            lifetime = 45f;
                            buildingDamageMultiplier = 0.01f;
                            homingPower = 0.12f;
                            homingDelay = 10f;
                            fragBullets = 2;
                            fragBullet = new LightningBulletType() {{
                                speed = 0.0001f;
                                damage = 5f;
                                buildingDamageMultiplier = 0f;
                                collidesTiles = false;
                                status = StatusEffects.shocked; // -
                                statusDuration = 10f;
                                lightningColor = hitColor = lightColor = Pal.accent;
                                lightningLength = 5;
                            }};
                            spawnBullets.add(new BasicBulletType(3f, 99.99f) {{
                                width = 15.25f;
                                height = 10.5f;
                                spin = 45f;
                                sprite = "ve-gggg";
                                lifetime = 199.98f;
                                buildingDamageMultiplier = 0.01f;
                                hittable = false;
                                createChance = 0.0001f;
                                despawnHit = true;
                                splashDamage = 99.99f;
                                splashDamageRadius = 99.99f;
                                layer = 139f;
                                hitEffect = Fx.blastExplosion;
                                despawnEffect = Fx.none;
                                trailColor = Pal.accent;
                                trailLength = 10;
                            }});
                            hitEffect = Fx.hitScepterSecondary;
                            despawnEffect = Fx.hitScepterSecondary;
                            shootEffect = Fx.shootSmall; // -
                            smokeEffect = Fx.shootSmallSmoke; // -
                            lightColor = trailColor = Pal.accent;
                            trailChance = 0.04f;
                            trailEffect = Fx.bulletSparkSmokeTrailSmall;
                            trailSpread = 12f;
                            trailLength = 3;
                            hitSound = Sounds.shockBullet;
                            // despawnSound = VeSounds.get("sparkBullet");
                        }};
                    }},
                    new Weapon(VeName("omega-weapon")) {{
                        rotate = true;
                        rotateSpeed = 7f;
                        rotationLimit = 150f;
                        top = false;
                        layerOffset = -0.002f;
                        shootX = 7.5f;
                        shootY = -0.25f;
                        x = 4.5f;
                        y = 0.25f;
                        shake = 3f;
                        shoot = new ShootBarrel() {{
                            barrels = new float[]{
                                    0f, 0f, 3f
                            };
                        }};
                        ejectEffect = Fx.none; // -
                        recoil = 4f;
                        recoilTime = 25f;
                        cooldownTime = 60f;
                        minWarmup = 0.9f;
                        heatColor = Pal.accent;
                        soundPitchMin = 1f;
                        soundPitchMax = 1.05f;
                        shootSound = Sounds.shootLancer;
                        reload = 32f;
                        parts.add(new RegionPart("-weapon") {{
                            progress = PartProgress.warmup; // -
                            layerOffset = 0.001f;
                            moveX = 7.5f;
                            moveY = -4f;
                            moveRot = 3f;
                            color = VePal.grayMid;
                            colorTo = Color.white;
                            under = false; // -
                        }});
                        bullet = new LaserBulletType(100f) {{
                            length = 265f;
                            sideLength = 45f;
                            sideWidth = 0.75f;
                            sideAngle = 30f;
                            colors = new Color[]{
                                    VePal.accent40, Pal.accent, Color.white
                            };
                            hitColor = lightColor = Pal.accent;
                            buildingDamageMultiplier = 0.01f;
                            armorMultiplier = 0.5f;
                            recoil = 0f;
                            shootEffect = new MultiEffect(Fx.hitLaserBlast, Fx.colorSpark);
                        }};
                    }}
            );
        }};

        thetaTether = new UnitType("theta-tether") {{
            constructor = BuildingTetherPayloadUnit::create;
            health = 180f;
            armor = 0f; // -
            hitSize = 10f;
            mineSpeed = 7f;
            mineTier = 1;
            mineWalls = true;
            buildRange = Vars.buildingRange; // -
            buildSpeed = 0.5f;
            itemCapacity = 30;
            pickupUnits = false;
            payloadCapacity = 0f;
            fogRadius = 0f;
            researchCostMultiplier = 0f; // -
            isEnemy = false;
            flying = true;
            speed = 3.3f;
            rotateSpeed = 15f;
            drag = 0.05f;
            accel = 0.1f;
            faceTarget = true; // -
            lowAltitude = true;
            drawBuildBeam = true; // -
            buildBeamOffset = 3f;
            mineBeamOffset = 3.25f;
            engineOffset = 6f;
            engineSize = 2.5f; // -
            lightColor = Pal.accent;
            immunities.add(VeStatusEffects.frozen);
            targetFlags = new BlockFlag[] {BlockFlag.drill, BlockFlag.factory};

            logicControllable = true; // -
            playerControllable = true; // -
            useUnitCap = true;
            hidden = true;
            defaultCommand = UnitCommand.assistCommand;
            weapons.add(theta.weapons.copy());
        }};

        lambdaTether = new UnitType("lambda-tether") {{
            constructor = BuildingTetherPayloadUnit::create;
            health = 250f;
            armor = 1f;
            hitSize = 11f;
            mineSpeed = 8f;
            mineTier = 2;
            mineWalls = true;
            buildRange += 20f;
            buildSpeed = 0.85f;
            itemCapacity = 50;
            pickupUnits = false;
            payloadCapacity = 0f;
            fogRadius = 0f;
            researchCostMultiplier = 0f; // -
            isEnemy = false;
            flying = true;
            speed = 3.5f;
            rotateSpeed = 10f;
            drag = 0.05f;
            accel = 0.1f;
            faceTarget = false;
            lowAltitude = true;
            drawBuildBeam = true; // -
            buildBeamOffset = 5f;
            mineBeamOffset = 4.5f;
            engineOffset = 6.5f;
            engineSize = 3.25f;
            lightColor = Pal.accent;
            immunities.add(VeStatusEffects.frozen);
            targetFlags = new BlockFlag[] {BlockFlag.drill, BlockFlag.factory};

            logicControllable = true; // -
            playerControllable = true; // -
            useUnitCap = true; // -
            hidden = true;
            defaultCommand = UnitCommand.assistCommand;
            weapons.add(lambda.weapons.copy());
        }};

        sigmaTether = new  UnitType("sigma-tether") {{
            constructor = BuildingTetherPayloadUnit::create;
            health = 250f;
            armor = 2f;
            hitSize = 12f;
            mineSpeed = 9f;
            mineTier = 2;
            mineWalls = true;
            buildRange += 30f;
            buildSpeed = 1.2f;
            itemCapacity = 70;
            pickupUnits = false;
            // payloadCapacity = Mathf.sqr(1f) * Vars.tilePayload;
            fogRadius = 0f;
            researchCostMultiplier = 0f; // -
            isEnemy = false;
            flying = true;
            speed = 3.6f;
            rotateSpeed = 10f;
            drag = 0.05f;
            accel = 0.1f;
            faceTarget = true; // -
            lowAltitude = true;
            drawBuildBeam = true; // -
            buildBeamOffset = 4.5f;
            mineBeamOffset = 4f;
            engineOffset = 8f;
            engineSize = 3.5f;
            lightColor = Pal.accent;
            immunities.add(VeStatusEffects.frozen);
            targetFlags = new BlockFlag[] {BlockFlag.battery, BlockFlag.storage};

            logicControllable = true; // -
            playerControllable = true; // -
            useUnitCap = true; // -
            hidden = true;
            defaultCommand = UnitCommand.assistCommand;
            weapons.add(sigma.weapons.copy());
        }};

        iota = new UnitType("iota") {{
            constructor = UnitEntity::create;
            health = 400f;
            armor = 4f;
            hitSize = 12f;
            mineSpeed = 8f;
            mineTier = 2;
            buildRange = Vars.buildingRange; // -
            buildSpeed = 1.25f;
            flying = true;
            speed = 3.55f;
            rotateSpeed = 9f;
            drag = 0.04f;
            accel = 0.11f;
            lowAltitude = true;
            buildBeamOffset = 0f;
            mineBeamOffset = 5.5f;
            engineOffset = 5.75f;
            engineSize = 3.5f;
            weapons.add(new Weapon(VeName("iota-weapon")) {{
                alternate = false;
                top = false;
                shootY = 6f;
                x = 5.5f;
                y = 0f; // -
                shoot.shots = 2;
                shoot.shotDelay = 5f;
                recoil = 0.75f;
                recoilTime = 45f;
                shootSound = Sounds.shootLaser;
                reload = 30f;
                bullet = new LaserBoltBulletType(5.2f, 15f) {{
                    backColor = healColor = hitColor = lightColor = Pal.accent;
                    frontColor = Color.white;
                    buildingDamageMultiplier = 0.01f;
                    collidesTeam = true;
                    despawnHit = true;
                    healPercent = 2f;
                    healAmount = 20f;
                    hitEffect = Fx.hitLaserBlast;
                    despawnEffect = smokeEffect = Fx.none;
                }};
            }});
        }};

        iotaFungikiller = new UnitType("iota-fungikiller") {{
            constructor = UnitEntity::create;
            health = 400f;
            armor = 4f;
            hitSize = 12f;
            mineSpeed = 7f;
            mineTier = 1;
            buildRange += 60f;
            buildSpeed = 1.5f;
            createWreck = false;
            flying = true;
            speed = 3.55f;
            rotateSpeed = 9f;
            drag = 0.04f;
            accel = 0.11f;
            lowAltitude = true;
            buildBeamOffset = 0f;
            mineBeamOffset = 5.5f;
            engineOffset = 5.75f;
            engineSize = 3.5f;
            weapons.add(new Weapon(VeName("iota-fungikiller-weapon")) {{
                top = false;
                shootY = 8.75f;
                x = 6f;
                y = 0f; // -
                recoil = 2f;
                recoilTime = 9f;
                shootSound = Sounds.shootDuo;
                reload = 6f;
                velocityRnd = 0.2f;
                bullet = new BasicBulletType(12f, 40f) {{
                    backColor = Color.valueOf("c1b8c0");
                    frontColor = Color.valueOf("e2dade");
                    width = 9f;
                    height = 18f;
                    shrinkY = 0f;
                    lifetime = 30f;
                    pierce = true;
                    pierceBuilding = false;
                    pierceCap = 4;
                    knockback = 1f;
                    hitEffect = Fx.hitBulletColor;
                    hitColor = Color.valueOf("e2dade");
                    despawnEffect = Fx.hitBulletColor;
                    shootEffect = Fx.shootSmall; // -
                    smokeEffect = Fx.shootSmallSmoke; // -
                }};
            }});
        }};

        iotaStg = new UnitType("iota-stg") {{
            constructor = UnitEntity::create;
            health = 400f;
            armor = 4f;
            hitSize = 10f;
            buildRange = Vars.buildingRange; // -
            buildSpeed = 1.5f;
            rotateToBuilding = false;
            createScorch = false;
            createWreck = false;
            flying = true;
            wobble = false;
            speed = 2.7f;
            strafePenalty = 1f;
            rotateSpeed = 0f;
            drag = 0.05f;
            accel = 0.07f;
            faceTarget = false;
            lowAltitude = true;
            buildBeamOffset = 0f;
            engineOffset = 5.75f;
            engineSize = 3.5f;
            weapons.add(new Weapon() {{
                mirror = false;
                rotate = true;
                baseRotation = 0f; // -
                rotateSpeed = 0f;
                shootY = 6.25f;
                x = 0f;
                y = 0f; // -
                recoil = 0f;
                recoilTime = 10f; // -
                shootSound = Sounds.none;
                reload = 10f;
                shootCone = 361f;
                parts.add(new RegionPart() {{
                    name = VeName("iota-stg-glow");
                    outline = false;
                    progress = PartProgress.recoil;
                    blending = Blending.additive;
                    color = VePal.accent0;
                    colorTo = VePal.accent73;
                    under = false;
                }});
                bullet = new BasicBulletType(7f, 40f) {{
                    backColor = Pal.accent;
                    frontColor = Color.white;
                    width = 4f;
                    height = 6f;
                    shrinkY = 0f;
                    sprite = "circle-bullet";
                    lifetime = 120f;
                    keepVelocity = false;
                    knockback = 1f;
                    hitEffect = Fx.hitBulletColor;
                    hitColor = Pal.accent;
                    despawnEffect = Fx.hitBulletColor;
                    shootEffect = Fx.colorSpark;
                    smokeEffect = new SoundEffect() {{
                        sound = new RandomSound(
                                VeSounds.get("lbp3ScifiLaserFire1"),
                                VeSounds.get("lbp3ScifiLaserFire2"),
                                VeSounds.get("lbp3ScifiLaserFire3")
                        );
                        minPitch = 1f;
                        maxPitch = 1f;
                        minVolume = 0.6f;
                        maxVolume = 0.6f;
                        effect = Fx.none;
                    }};
                    trailColor = Pal.accent;
                    trailLength = 3; // 3.5
                    trailWidth = 1.75f;
                }};
            }});
        }};

        zeta = new UnitType("zeta") {{
            constructor = LegsUnit::create;
            health = 200f; // -
            armor = 0f; // -
            hitSize = 12f;
            mineSpeed = 9f;
            mineTier = 2;
            mineWalls = true;
            buildSpeed = 1.1f;
            speed = 3f;
            rotateSpeed = 7f;
            drag = 0.07f;
            accel = 0.07f;
            hovering = true;
            stepShake = 0f;
            groundLayer = 75f;
            buildBeamOffset = 4.5f;
            mineBeamOffset = 6f; // -
            lightColor = Pal.accent;
            stepSound = Sounds.walkerStepSmall;
            stepSoundVolume = 0.15f;
            stepSoundPitch = 1f; // -
            stepSoundPitchRange = 0.1f; // -
            allowLegStep = true;
            legCount = 4; // -
            legLength = 10f; // -
            legSpeed = 0.15f;
            legForwardScl = 0.85f;
            legBaseOffset = 1f;
            legMoveSpace = 2.5f;
            legExtension = -3f;
            lockLegBase = false; // -
            legContinuousMove = false;
            immunities.add(VeStatusEffects.dusty);
            abilities.add(
                    new RepairFieldAbility(50f, 120f, 64f)
                    /*
                    new RepairFieldAbility(50f, 120f, 64f) {{
                        healEffect = new WaveEffect() {{
                            colorFrom = colorTo = Pal.accent;
                            sizeFrom = 0f; // -
                            sizeTo = 7f;
                            strokeFrom = 2f; // -
                            strokeTo = 0f; // -
                            interp = Interp.circleOut;
                            lifetime = 11f;
                        }};
                        activeEffect = new WaveEffect() {{
                            colorFrom = colorTo = Pal.accent;
                            sizeFrom = 0f; // -
                            sizeTo = 64f;
                            strokeFrom = 2f; // -
                            strokeTo = 0f; // -
                            interp = Interp.circleOut;
                            lifetime = 22f;
                        }};
                    }}
                    */
            );
            weapons.add(
                    new Weapon(VeName("zeta-weapon")) {{
                        rotate = true;
                        rotateSpeed = 9f;
                        shootY = 1.5f;
                        x = 6.5f;
                        y = 1.5f;
                        shootSound = Sounds.shootLaser;
                        reload = 9f;
                        bullet = new LaserBoltBulletType(5.2f, 9f) {{
                            backColor = Pal.accent;
                            frontColor = Color.white;
                            buildingDamageMultiplier = 0.01f;
                            collidesTeam = true;
                            despawnHit = true;
                            healPercent = 1.5f;
                            healAmount = 15f;
                            healColor = hitColor = Pal.accent;
                            hitEffect = Fx.hitLaserBlast;
                            despawnEffect = smokeEffect = Fx.none;
                        }};
                    }},
                    new Weapon(VeName("zeta-weapon")) {{
                        rotate = true;
                        rotateSpeed = 9f;
                        shootY = 1.5f;
                        x = 3.5f;
                        y = -4.75f;
                        shootSound = Sounds.shootLaser;
                        reload = 13f;
                        bullet = new LaserBoltBulletType(5.2f, 11f) {{
                            backColor = Pal.accent;
                            frontColor = Color.white;
                            buildingDamageMultiplier = 0.01f;
                            collidesTeam = true;
                            despawnHit = true;
                            healPercent = 3f;
                            healAmount = 25f;
                            healColor = hitColor = Pal.accent;
                            hitEffect = Fx.hitLaserBlast;
                            despawnEffect = smokeEffect = Fx.none;
                        }};
                    }}
            );
        }};

        eta = new UnitType("eta") {{
            constructor = LegsUnit::create;
            health = 550f;
            armor = 0f;
            hitSize = 16f;
            mineSpeed = 12f;
            mineTier = 3;
            mineWalls = true;
            buildRange += 100;
            buildSpeed = 1.9f;
            speed = 3f;
            rotateSpeed = 5f; // -
            drag = 0.065f;
            accel = 0.065f;
            hovering = true;
            stepShake = 0f;
            groundLayer = 75f;
            buildBeamOffset = 2.75f;
            mineBeamOffset = 8.25f;
            lightColor = Pal.accent;
            stepSound = Sounds.walkerStepSmall;
            stepSoundVolume = 0.15f;
            stepSoundPitch = 1f; // -
            stepSoundPitchRange = 0.1f; // -
            allowLegStep = true;
            legCount = 6;
            legGroupSize = 2; // -
            legLength = 12f;
            legSpeed = 0.15f;
            legForwardScl = 1.35f;
            legBaseOffset = 2.5f;
            legMoveSpace = 2.5f;
            legExtension = -3f;
            legMaxLength = 2f;
            lockLegBase = false; // -
            legContinuousMove = false;
            immunities.add(VeStatusEffects.dusty);
            abilities.add(
                    new RepairFieldAbility(80f, 120f, 80f)
                    /*
                    new RepairFieldAbility(80f, 120f, 80f) {{
                        healEffect = new WaveEffect() {{
                            colorFrom = colorTo = Pal.accent;
                            sizeFrom = 0f; // -
                            sizeTo = 7f;
                            strokeFrom = 2f; // -
                            strokeTo = 0f; // -
                            interp = Interp.circleOut;
                            lifetime = 11f;
                        }};
                        activeEffect = new WaveEffect() {{
                            colorFrom = colorTo = Pal.accent;
                            sizeFrom = 0f; // -
                            sizeTo = 80f;
                            strokeFrom = 2f; // -
                            strokeTo = 0f; // -
                            interp = Interp.circleOut;
                            lifetime = 22f;
                        }};
                    }}
                    */
            );
            weapons.add(
                    new Weapon(VeName("zeta-weapon")) {{
                        rotate = true;
                        rotateSpeed = 9f;
                        shootY = 1.5f;
                        x = 3.5f;
                        y = 4f;
                        shootSound = Sounds.shootLaser;
                        reload = 8f;
                        bullet = new LaserBoltBulletType(5.2f, 12f) {{
                            backColor = Pal.accent;
                            frontColor = Color.white;
                            buildingDamageMultiplier = 0.01f;
                            collidesTeam = true;
                            despawnHit = true;
                            healPercent = 2f;
                            healAmount = 20f;
                            healColor = hitColor = Pal.accent;
                            hitEffect = Fx.hitLaserBlast;
                            despawnEffect = smokeEffect = Fx.none;
                        }};
                    }},
                    new Weapon(VeName("eta-weapon")) {{
                        rotate = true;
                        rotateSpeed = 5f;
                        shootY = 3.25f;
                        x = 7.25f;
                        y = 1.25f;
                        shoot = new ShootSpread(2, 6f) {{shotDelay = 4f;}};
                        recoil = 1.5f; // -
                        shootSound = Sounds.shootMissilePlasmaShort;
                        reload = 25f;
                        bullet = new BasicBulletType(4f, 20f) {{
                            backColor = Pal.accent;
                            frontColor = Color.white;
                            width = 9f;
                            height = 9f;
                            shrinkY = 0f;
                            sprite = "missile";
                            lifetime = 60f;
                            buildingDamageMultiplier = 0.01f;
                            collidesTeam = true;
                            homingPower = 0.04f;
                            homingDelay = 15f;
                            splashDamage = 14f;
                            splashDamageRadius = 20f;
                            healPercent = 5f;
                            healAmount = 50f;
                            healColor = hitColor = trailColor = Pal.accent;
                            hitEffect = despawnEffect = Fx.hitLaserBlast;
                            smokeEffect = Fx.none;
                            trailInterval = 1f;
                            trailEffect = Fx.missileTrailShort;
                            trailWidth = 0.5f;
                        }};
                    }}
            );
        }};

        // 特种单位
        // armorcar
        Seq<StatusEffect> ARMORCAR_IMMUNITIES = Seq.with(
                StatusEffects.burning,
                StatusEffects.melting,
                StatusEffects.corroded,
                VeStatusEffects.fusing,
                VeStatusEffects.combusting
        );

        conscript = new UnitType("conscript") {{
            constructor = TankUnit::create;
            health = 670f;
            armor = 6f;
            hitSize = 12f;
            itemCapacity = 30;
            researchCostMultiplier = 0.01f;
            speed = 1.3f;
            floorMultiplier = 0.95f;
            rotateSpeed = 3f;
            drag = 0.07f;
            accel = 0.1f;
            omniMovement = false;
            rotateMoveFirst = true;
            squareShape = true;
            lightColor = Pal.redLight;
            emitWalkSound = false;
            treadRects = new Rect[]{new Rect(-23, -26, 12, 53)};
            treadFrames = 18; // -
            treadPullOffset = 3;
            tankMoveSound = VeSounds.get("lbp3TankTreads");
            tankMoveVolume = 0.1f;
            envDisabled = Env.none;
            immunities.addAll(ARMORCAR_IMMUNITIES);
            weapons.add(new Weapon(VeName("conscript-turret")) {{
                mirror = false;
                rotate = true;
                rotateSpeed = 3f;
                layerOffset = 0.001f;
                shootY = 6.5f;
                x = 0f;
                y = 0f; // -
                recoil = 1f;
                recoilTime = 35f;
                shootSound = Sounds.shootDuo;
                reload = 55f;
                parts.add(new RegionPart("-tube") {{
                    mirror = false; // -
                    progress = PartProgress.reload;
                    moveY = -1.25f;
                    under = true;
                }});
                bullet = new BasicBulletType(3.3f, 27f) {{
                    backColor = Pal.redLight;
                    frontColor = Color.white;
                    width = 6f;
                    height = 9f;
                    sprite = "missile-large";
                    lifetime = 55f;
                    drag = 0.008f;
                    hitSize = 5f;
                    splashDamage = 41f;
                    splashDamageRadius = 20f;
                    status = StatusEffects.blasted;
                    statusDuration = 60f;
                    hitEffect = despawnEffect = Fx.blastExplosion;
                    hitColor = trailColor = Pal.redLight;
                    shootEffect = Fx.shootBigColor;
                    smokeEffect = Fx.shootBigSmoke;
                    trailChance = 0.3f;
                    hitSound = despawnSound = Sounds.explosionArtillery;
                }};
            }});
        }};

        arrange = new UnitType("arrange") {{
            constructor = TankUnit::create;
            health = 1900f;
            armor = 12f;
            hitSize = 20f;
            itemCapacity = 60;
            researchCostMultiplier = 0.3f;
            speed = 1.1f; // -
            floorMultiplier = 0.8f;
            rotateSpeed = 3f;
            drag = 0.07f;
            accel = 0.1f;
            omniMovement = false;
            rotateMoveFirst = true;
            targetGround = false;
            squareShape = true;
            lightColor = Pal.redLight;
            emitWalkSound = false;
            treadRects = new Rect[]{new Rect(-31, -38, 15, 76)};
            treadFrames = 16;
            treadPullOffset = 5;
            tankMoveSound = VeSounds.get("lbp3TankTreads");
            tankMoveVolume = 0.2f;
            crushDamage = 0.2f;
            envDisabled = Env.none;
            immunities.addAll(ARMORCAR_IMMUNITIES);
            weapons.add(new Weapon(VeName("arrange-turret")) {{
                mirror = false;
                rotate = true;
                rotateSpeed = 6f;
                layerOffset = 0.001f;
                shootX = 0f; // -
                shootY = 10.5f;
                x = 0f;
                y = 0f; // -
                shoot = new ShootAlternate(3.5f);
                recoil = 1f;
                cooldownTime = 45f;
                shootSound = VeSounds.get("shootClassic");
                reload = 8f;
                inaccuracy = 7f;
                velocityRnd = 0.3f;
                shootCone = 30f;
                bullet = new FlakBulletType(5f, 27f) {{
                    explodeRange = 20f;
                    backColor = Pal.redLight;
                    frontColor = Color.white;
                    width = 3f;
                    height = 11f;
                    shrinkX = -3f;
                    shrinkY = 0.18f;
                    lifetime = 33f;
                    hitSize = 8f;
                    collidesTiles = false;
                    collidesGround = false; // -
                    splashDamage = 31f;
                    splashDamageRadius = 38f;
                    fragBullets = 9; // -
                    fragVelocityMin = 0.8f;
                    fragBullet = new BasicBulletType(3f, 22f) {{
                        backColor = Pal.redLight;
                        width = 9f;
                        height = 11f;
                        shrinkY = 1f;
                        lifetime = 15f;
                        drag = 0.05f;
                        collidesTiles = false;
                        collidesAir = true; // -
                        collidesGround = false;
                        despawnEffect = Fx.none;
                    }};
                    hitEffect = despawnEffect = Fx.flakExplosion;
                    hitColor = lightColor = Pal.redLight;
                    shootEffect = Fx.shootBigColor;
                    smokeEffect = Fx.shootSmallSmoke; // -
                }};
            }});
        }};

        charge = new UnitType("charge") {{
            constructor = TankUnit::create;
            health = 4700f;
            armor = 16f;
            hitSize = 28f;
            itemCapacity = 90;
            fogRadius = 180f;
            researchCostMultiplier = 0.3f;
            speed = 1f;
            rotateSpeed = 2f;
            floorMultiplier = 0.65f;
            drag = 0.07f;
            accel = 0.09f;
            omniMovement = false;
            rotateMoveFirst = true;
            targetGround = true; // -
            squareShape = true;
            lightColor = Pal.redLight;
            emitWalkSound = false;
            treadRects = new Rect[]{new Rect(-49, -55, 24, 102)};
            treadFrames = 24;
            treadPullOffset = 6;
            tankMoveSound = VeSounds.get("lbp3TankTreads");
            tankMoveVolume = 0.3f;
            crushDamage = 0.5f;
            envDisabled = Env.none;
            immunities.addAll(ARMORCAR_IMMUNITIES);
            targetFlags = new BlockFlag[]{BlockFlag.turret, BlockFlag.core};
            weapons.add(new Weapon(VeName("charge-turret")) {{
                mirror = false;
                rotate = true;
                rotateSpeed = 2.1f;
                layerOffset = 0.001f;
                shootX = 0f; // -
                shootY = 9f;
                x = 0f;
                y = -2f;
                shadow = 20f;
                shake = 3f;
                shoot = new ShootBarrel() {{
                    barrels = new float[]{
                            -9, 0, 0,
                            -3, 0, 0,
                            3, 0, 0,
                            9, 0, 0
                    };
                    shots = 4;
                    shotDelay = 6f;
                }};
                recoil = 3f;
                predictTarget = false;
                reload = 45f;
                shootCone = 30f;
                shootSound = VeSounds.get("lbp3SearchlightEdited");
                bullet = new BasicBulletType(0f, 32f) {{
                    backColor = Pal.redLight;
                    frontColor = Color.white;
                    width = 4f;
                    height = 24f;
                    shrinkY = 0f;
                    sprite = "missile-large";
                    lifetime = 80f;
                    drag = -0.01f;
                    buildingDamageMultiplier = 0.5f;
                    collidesTiles = true; // -
                    collidesGround = true; // -
                    homingPower = 0.06f;
                    homingDelay = 10f;
                    splashDamage = 58f;
                    splashDamageRadius = 48f;
                    status = StatusEffects.blasted;
                    statusDuration = 60f;
                    spawnUnit = VeMissileUnitType.chargeMissile;
                    parts.add(new FlarePart() {{
                        sides = 2;
                        radius = 6f;
                        stroke = 4f;
                        spinSpeed = 5f;
                        color1 = Pal.redLight;
                    }});
                    hitEffect = Fx.massiveExplosion;
                    hitColor = Pal.redLight;
                    despawnEffect = Fx.massiveExplosion;
                    shootEffect = new MultiEffect(
                            Fx.shootBig,
                            new RadialEffect(Fx.shootBigSmoke, 1, 180f, 16f)
                    );
                    smokeEffect = Fx.shootBigSmoke;
                    despawnShake = 4f;
                    trailColor = Pal.redLight;
                    trailLength = 30;
                    hitSound = VeSounds.get("bang");
                }};
            }});

            generateIcons = true; // -
        }};

        capture = new UnitType("capture") {{
            constructor = TankUnit::create;
            health = 12000f;
            armor = 22f;
            hitSize = 32f;
            itemCapacity = 160;
            researchCostMultiplier = 0.05f;
            speed = 1.1f;
            floorMultiplier = 0.5f;
            rotateSpeed = 1.7f;
            drag = 0.07f;
            accel = 0.07f;
            omniMovement = false;
            rotateMoveFirst = true;
            squareShape = true;
            lightColor = Pal.redLight;
            deathSound = VeSounds.get("si2Explode");
            emitWalkSound = false;
            treadRects = new Rect[]{new Rect(-69, -52, 37, 102)};
            treadFrames = 24;
            treadPullOffset = 6;
            tankMoveSound = VeSounds.get("lbp3TankTreadsSlow");
            tankMoveVolume = 0.45f;
            crushDamage = 1f;
            envDisabled = Env.none;
            immunities.addAll(ARMORCAR_IMMUNITIES);
            targetFlags = new BlockFlag[]{BlockFlag.storage};
            weapons.add(
                    new Weapon(VeName("capture-turret")) {{
                        mirror = true; // -
                        alternate = false;
                        rotate = true;
                        rotateSpeed = 2f;
                        shootX = 8f;
                        shootY = 15f;
                        x = 0f;
                        y = 0f; // -
                        shadow = 20f;
                        shake = 1f;
                        ejectEffect = Fx.none; // -
                        recoil = 0f;
                        cooldownTime = 100f;
                        shootSound = Sounds.beamMeltdown;
                        initialShootSound = Sounds.shootBeamPlasmaSmall;
                        continuous = true;
                        reload = 60f;
                        shootCone = 60f;
                        bullet = new ContinuousLaserBulletType(44f) {{
                            width = 4f;
                            colors = new Color[]{
                                    VePal.redLight20,
                                    VePal.redLight50,
                                    Pal.redLight,
                                    Color.white
                            };
                            length = 150f;
                            shake = 0.5f;
                            lifetime = 240f;
                            maxRange = 210f;
                            hitSize = 4f; // -
                            knockback = 1f;
                            status = StatusEffects.burning;
                            statusDuration = 4f * 60f;
                            makeFire = true;
                            incendAmount = 1;
                            incendSpread = 5f; // -
                            incendChance = 0.1f;
                            drawSize = 420f; // -
                            despawnEffect = Fx.smokeCloud;
                            smokeEffect = Fx.none;
                            lightColor = Pal.redLight;
                        }};
                    }},
                    new Weapon(VeName("capture-turret-mid")) {{
                        ejectEffect = Fx.casing4;
                        mirror = false;
                        rotate = true;
                        rotateSpeed = 2f;
                        reload = 70f;
                        inaccuracy = 1f;
                        shake = 2f;
                        recoil = 2f;
                        shootY = 13.25f;
                        x = 0f;
                        y = 0f; // -
                        shoot = new ShootSpread() {{
                            spread = 0f;
                            shots = 4;
                            shotDelay = 5f;
                        }};
                        velocityRnd = 0.2f;
                        shootCone = 10f;
                        shootSound = Sounds.shootScepter;
                        bullet = new BasicBulletType(7f, 130f) {{
                            backColor = Pal.redLight;
                            frontColor = Color.white;
                            width = 6f;
                            height = 9f;
                            shrinkY = 0f;
                            sprite = "missile-large";
                            lifetime = 30f;
                            shieldDamageMultiplier = 3f;
                            hitSize = 4f; // -
                            knockback = 2f;
                            despawnHit = true;
                            splashDamage = 70f;
                            splashDamageRadius = 32f;
                            fragRandomSpread = 90f;
                            fragBullets = 2;
                            fragVelocityMin = 0.5f;
                            fragOffsetMax = 1f;
                            fragBullet = new BasicBulletType(6f, 70f) {{
                                backColor = Pal.redLight;
                                frontColor = Color.white;
                                width = 5f; // -
                                height = 7f; // -
                                shrinkY = 0f;
                                sprite = "missile-large";
                                lifetime = 30f;
                                drag = 0.05f;
                                shieldDamageMultiplier = 3f;
                                hitSize = 4f; // -
                                collides = false;
                                knockback = 1f;
                                despawnHit = true;
                                splashDamage = 55f;
                                splashDamageRadius = 24f;
                                hitEffect = new ExplosionEffect() {{
                                    waveColor = smokeColor = sparkColor = Pal.redLight;
                                    waveRad = 24f;
                                    smokeSize = 4f; // -
                                    smokeRad = 24f;
                                    smokes = 6;
                                    sparkStroke = 2f;
                                    sparkRad = 24f;
                                    sparks = 6;
                                    lifetime = 30f;
                                }};
                                despawnEffect = Fx.none;
                                hitShake = 2f;
                                despawnShake = 2f;
                                lightColor = trailColor = Pal.redLight;
                                trailLength = 10;
                                trailWidth = 2f; // -
                                hitSound = despawnSound = Sounds.explosionArtillery;
                            }};
                            hitEffect = new ExplosionEffect() {{
                                waveColor = smokeColor = sparkColor = Pal.redLight;
                                waveRad = 32f;
                                smokeSize = 5f;
                                smokeRad = 32f;
                                smokes = 8;
                                sparkStroke = 2f;
                                sparkRad = 32f;
                                sparks = 8;
                                lifetime = 30f;
                            }};
                            despawnEffect = Fx.none;
                            shootEffect = Fx.shootBig;
                            smokeEffect = Fx.shootBigSmoke;
                            hitShake = 5f;
                            despawnShake = 5f;
                            lightColor = trailColor = Pal.redLight;
                            trailLength = 10;
                            trailWidth = 2f; // -
                            hitSound = despawnSound = Sounds.explosionArtillery;
                        }};
                    }}
            );

            generateIcons = true; // -
        }};

        triumph = new UnitType("triumph") {{
            constructor = TankUnit::create;
            health = 24000f;
            armor = 28f;
            hitSize = 54f;
            itemCapacity = 320;
            researchCostMultiplier = 0.05f;
            speed = 1.1f; // -
            floorMultiplier = 0.3f;
            rotateSpeed = 1.6f;
            drag = 0.06f;
            accel = 0.08f;
            omniMovement = false;
            rotateMoveFirst = true;
            squareShape = true;
            lightColor = Pal.redLight;
            deathSound = VeSounds.get("si2Explode");
            emitWalkSound = false;
            treadRects = new Rect[]{
                    new Rect(-111, -128, 47, 112),
                    new Rect(-111, 16, 47, 112)
            };
            treadFrames = 28;
            treadPullOffset = 14;
            tankMoveSound = VeSounds.get("lbp3TankTreadsSlower");
            tankMoveVolume = 0.65f;
            crushDamage = 2f;
            envDisabled = Env.none;
            immunities.addAll(ARMORCAR_IMMUNITIES.add(VeStatusEffects.frozen));
            targetFlags = new BlockFlag[]{BlockFlag.shield};
            weapons.add(
                    new Weapon(VeName("triumph-sub")) {{
                        alternate = false;
                        rotate = true;
                        rotateSpeed = 5f;
                        top = true; // -
                        shootY = 2.75f;
                        x = 23.25f;
                        y = -2f;
                        shadow = 25f;
                        ejectEffect = Fx.none; // -
                        recoil = 2f;
                        recoilTime = 20f;
                        cooldownTime = 70f;
                        shootSound = Sounds.shootFlame;
                        reload = 4f;
                        shootCone = 60f;
                        bullet = new BasicBulletType() {{
                            maxRange = 108f;
                            collides = false;
                            hittable = false;
                            absorbable = false;
                            instantDisappear = true;
                            fragRandomSpread = 7f;
                            fragBullets = 2;
                            fragVelocityMin = 0.6f;
                            fragOffsetMax = 1f;
                            fragBullet = new BasicBulletType(7f, 55f) {{
                                backColor = frontColor = Pal.redLight;
                                width = 4f;
                                height = 4f;
                                shrinkX = 1f;
                                shrinkY = 1f;
                                sprite = "circle-bullet";
                                lifetime = 15f;
                                buildingDamageMultiplier = 0.7f;
                                shieldDamageMultiplier = 0.5f;
                                pierceBuilding = false;
                                pierceCap = 5;
                                hitSize = 8f;
                                collidesTiles = true;
                                collides = true; // -
                                absorbable = true; // -
                                status = StatusEffects.burning;
                                statusDuration = 8f * 60f;
                                makeFire = true;
                                hitEffect = Fx.hitFlameSmall;
                                despawnEffect = Fx.none;
                            }};
                            hitEffect = Fx.none;
                            despawnEffect = Fx.none;
                            shootEffect = new MultiEffect(
                                    new ParticleEffect() {{
                                        colorFrom = Color.white;
                                        colorTo = VePal.redLight53;
                                        particles = 18;
                                        cone = 7f;
                                        length = 140f;
                                        baseLength = 0f; // -
                                        interp = Interp.circleOut;
                                        sizeInterp = Interp.circleIn;
                                        lightOpacity = 1f;
                                        lightColor = Pal.redLight;
                                        sizeFrom = 2.5f;
                                        sizeTo = 0f; // -
                                        lifetime = 32f;
                                    }},
                                    new ParticleEffect() {{
                                        colorFrom = Pal.redLight;
                                        colorTo = Color.valueOf("2d2f3900");
                                        particles = 22;
                                        cone = 7f;
                                        length = 170f;
                                        baseLength = 0f; // -
                                        interp = Interp.circleOut;
                                        sizeInterp = Interp.circleIn;
                                        lightOpacity = 0.5f;
                                        lightColor = Pal.redLight;
                                        sizeFrom = 4f;
                                        sizeTo = 2f;
                                        lifetime = 48f;
                                        layer = Layer.bullet; // 100f
                                    }}
                            );
                            smokeEffect = Fx.hitFlameSmall;
                        }};
                    }},
                    new Weapon(VeName("triumph-turret")) {{
                        display = true; // -
                        mirror = false;
                        alternate = false;
                        rotate = true;
                        rotateSpeed = 1.7f;
                        top = true; // -
                        layerOffset = 0.1f;
                        shootX = 0f; // -
                        shootY = 43.75f;
                        x = 0f;
                        y = 0f; // -
                        shadow = 55f;
                        shake = 4f;
                        shoot = new ShootBarrel() {{
                            barrels = new float[]{
                                    7.25f, 0, 0,
                                    -7.25f, 0, 0
                            };
                            shots = 2;
                            shotDelay = 0f; // -
                        }};
                        ejectEffect = Fx.casing4;
                        recoil = 3f;
                        recoilTime = 35f;
                        cooldownTime = 60f;
                        shootSound = Sounds.shootRipple;
                        reload = 50f;
                        parts.add(new RegionPart("-tube") {{
                            mirror = true;
                            progress = PartProgress.reload;
                            y = 12f;
                            moveY = -3f;
                            under = true;
                        }});
                        bullet = new BasicBulletType(10f, 80f) {{
                            backColor = frontColor = Pal.redLight;
                            width = 10f;
                            height = 30f;
                            shrinkY = 0.2f;
                            sprite = "missile-large";
                            lifetime = 70f;
                            rangeOverride = 472f;
                            accel = -0.12f;
                            shieldDamageMultiplier = 16f;
                            pierce = true;
                            pierceBuilding = true;
                            pierceCap = 5;
                            hittable = false;
                            absorbable = true; // -
                            knockback = 4f;
                            impact = true;
                            splashDamage = 70f;
                            splashDamageRadius = 54f;
                            splashDamagePierce = true;
                            fragOnAbsorb = false;
                            fragRandomSpread = 0f;
                            fragSpread = 120f;
                            fragBullets = 3;
                            fragVelocityMin = 1f;
                            fragOffsetMax = 1f;
                            fragBullet = new BasicBulletType(3f, 1f) {{
                                backColor = frontColor = Pal.redLight;
                                width = 9f;
                                height = 9f;
                                shrinkY = 0f;
                                sprite = "missile";
                                lifetime = 60f;
                                accel = -0.05f;
                                collides = false;
                                splashDamage = 32f;
                                splashDamageRadius = 32f;
                                status = StatusEffects.blasted;
                                statusDuration = 60f;
                                hitEffect = despawnEffect = new ExplosionEffect() {{
                                    waveColor = sparkColor = Pal.redLight;
                                    waveLife = 6f; // -
                                    waveStroke = 3f; // -
                                    waveRad = 32f;
                                    waveRadBase = 0f;
                                    smokeColor = VePal.redLight67;
                                    smokeSize = 5f;
                                    smokeSizeBase = 1f;
                                    smokeRad = 32f;
                                    smokes = 8;
                                    sparkStroke = 3f;
                                    sparkRad = 32f;
                                    sparkLen = 5f;
                                    sparks = 10;
                                    lifetime = 30f;
                                }};
                                hitShake = 2f;
                                despawnShake = 2f;
                                hitSound = despawnSound = Sounds.explosionArtillery;

                            }};
                            /*
                            parts.add(new RegionPart("-tube") {{
                                mirror = true;
                                progress = PartProgress.reload;
                                y = 12f;
                                moveY = -3f;
                                under = true;
                            }});
                            */
                            hitEffect = despawnEffect = new ExplosionEffect() {{
                                waveColor = Pal.redLight;
                                waveLife = 6f; // -
                                waveStroke = 4f;
                                waveRad = 54f;
                                waveRadBase = 0f;
                                smokeColor = VePal.redLight67;
                                smokeSize = 6f;
                                smokeSizeBase = 1f;
                                smokeRad = 54f;
                                smokes = 12;
                                sparkColor = Pal.redLight;
                                sparkStroke = 3f;
                                sparkRad = 54f;
                                sparkLen = 7f;
                                sparks = 16;
                                lifetime = 60f;
                            }};
                            shootEffect = new MultiEffect(
                                    Fx.shootTitan,
                                    Fx.shootBig
                            );
                            smokeEffect = new ParticleEffect() {{
                                colorFrom = Pal.redLight;
                                colorTo = VePal.redLight0;
                                particles = 8;
                                cone = 15f;
                                length = 32f;
                                interp = Interp.circleOut;
                                sizeFrom = 6.5f;
                                sizeTo = 1f;
                                lifetime = 90f;
                            }};
                            hitShake = 5f;
                            despawnShake = 5f;
                            trailColor = Pal.redLight;
                            trailInterval = 2f;
                            hitSound = Sounds.explosionArtillery;
                            despawnSound = Sounds.explosionArtillery;
                        }};
                    }}
            );

            generateIcons = true; // -
        }};

        // crabbot
        smarb = new UnitType("smarb") {{
            constructor = LegsUnit::create;
            health = 160f;
            armor = 2f;
            hitSize = 8f;
            researchCostMultiplier = 0.5f;
            speed = 1.2f;
            rotateSpeed = 9f;
            drag = 0.05f;
            accel = 0.07f;
            hovering = true;
            stepShake = 0f;
            rippleScale = 0.1f;
            groundLayer = Layer.legUnit;
            shadowElevation = 0.1f;
            lightColor = Pal.reactorPurple;
            stepSound = Sounds.walkerStepTiny;
            stepSoundVolume = 0.3f;
            stepSoundPitch = 1f; // -
            stepSoundPitchRange = 0.1f; // -
            allowLegStep = true;
            legPhysicsLayer = false;
            legCount = 4; // -
            legGroupSize = 2; // -
            legLength = 8f;
            legForwardScl = 1.3f;
            legBaseOffset = 1f;
            legMoveSpace = 1.5f;
            legExtension = -2f;
            legLengthScl = 0.96f;
            legMaxLength = 1.1f;
            legMinLength = 0.2f;
            legStraightness = 0.3f;
            lockLegBase = true;
            legContinuousMove = true;
            immunities.add(VeStatusEffects.dusty);
            weapons.add(new Weapon() {{
                mirror = false;
                shootY = 0f;
                x = 0f;
                y = 3f;
                shoot.shots = 3;
                shoot.shotDelay = 3f;
                ejectEffect = Fx.none; // -
                recoil = 0f;
                shootSound = Sounds.shootLaser;
                reload = 50f;
                bullet = new LaserBoltBulletType(5.2f, 10f) {{
                    backColor = frontColor = Pal.reactorPurple;
                    lifetime = 25f;
                    hittable = false; // -
                    recoil = 0.3f;
                    status = StatusEffects.sapped;
                    statusDuration = 5f * 60f;
                    hitEffect = new WaveEffect() {{
                        colorFrom = colorTo = Pal.reactorPurple;
                        sizeFrom = 1f;
                        sizeTo = 6f;
                        sides = 24;
                        strokeFrom = 2f; // -
                        strokeTo = 0f; // -
                        lifetime = 15f;
                    }};
                    hitColor = Pal.reactorPurple;
                    despawnEffect = new WaveEffect() {{
                        colorFrom = colorTo = Pal.reactorPurple;
                        sizeFrom = 1f;
                        sizeTo = 4f;
                        sides = 24;
                        strokeFrom = 3f;
                        strokeTo = 0f; // -
                        lifetime = 12f;
                    }};
                    shootEffect = Fx.shootSmallColor;
                    smokeEffect = Fx.none;
                    lightColor = Pal.reactorPurple;
                }};
            }});
        }};

        mider = new UnitType("mider") {{
            constructor = LegsUnit::create;
            health = 650f;
            armor = 4f;
            hitSize = 13f;
            researchCostMultiplier = 0.3f;
            speed = 1.6f;
            rotateSpeed = 7f;
            drag = 0.05f;
            accel = 0.07f;
            hovering = true;
            stepShake = 0f;
            rippleScale = 0.2f;
            groundLayer = Layer.legUnit;
            shadowElevation = 0.15f;
            lightColor = Pal.reactorPurple;
            stepSound = Sounds.walkerStepTiny;
            stepSoundVolume = 0.5f; // -
            stepSoundPitch = 0.9f;
            stepSoundPitchRange = 0.1f; // -
            allowLegStep = true;
            legPhysicsLayer = false;
            legCount = 4; // -
            legGroupSize = 2; // -
            legLength = 16f;
            legForwardScl = 1.1f;
            legBaseOffset = 2f;
            legMoveSpace = 1.5f;
            legExtension = -4f;
            legLengthScl = 0.96f;
            legMaxLength = 1.3f;
            legMinLength = 0.2f;
            legStraightness = 0.3f;
            lockLegBase = true;
            legContinuousMove = true;
            immunities.add(VeStatusEffects.dusty);
            weapons.add(new Weapon(VeName("mider-weapon")) {{
                top = false;
                shootY = 7.25f;
                x = 7.25f;
                y = 0f; // -
                ejectEffect = Fx.none; // -
                recoil = 1.5f; // -
                shootSound = Sounds.shootMerui;
                reload = 8f;
                bullet = new BasicBulletType(5.2f, 10f) {{
                    backColor = frontColor = Pal.reactorPurple;
                    width = 4f;
                    height = 6f;
                    sprite = "circle-bullet";
                    lifetime = 33f;
                    scaleLife = true;
                    collides = false;
                    despawnHit = true;
                    splashDamage = 14f;
                    splashDamageRadius = 12f;
                    status = StatusEffects.sapped;
                    statusDuration = 5f * 60f;
                    hitEffect = new ExplosionEffect() {{
                        waveColor = smokeColor = sparkColor = Pal.reactorPurple;
                        waveRad = 12f;
                        smokeRad = 8f;
                        smokes = 4;
                        sparkRad = 12f;
                        sparks = 5;
                        lifetime = 20f;
                    }};
                    hitColor = Pal.reactorPurple;
                    despawnEffect = Fx.none;
                    shootEffect = Fx.shootSmallColor;
                    smokeEffect = Fx.shootSmallSmoke; // -
                    hitShake = 0.5f;
                    despawnShake = 0.5f;
                    lightColor = trailColor = Pal.reactorPurple;
                    trailLength = 5;
                }};
            }});
        }};

        velocite = new UnitType("velocite") {{
            constructor = LegsUnit::create;
            health = 1500f;
            armor = 6f;
            hitSize = 18f;
            researchCostMultiplier = 0.5f;
            speed = 2.5f;
            rotateSpeed = 5f; // -
            drag = 0.04f;
            accel = 0.05f;
            hovering = true;
            stepShake = 0f;
            rippleScale = 0.3f;
            groundLayer = Layer.legUnit;
            shadowElevation = 0.25f;
            lightColor = Pal.reactorPurple;
            stepSound = Sounds.walkerStepSmall;
            stepSoundVolume = 0.3f;
            stepSoundPitch = 1f; // -
            stepSoundPitchRange = 0.1f;
            allowLegStep = true;
            legPhysicsLayer = false;
            legCount = 6;
            legGroupSize = 3;
            legLength = 28f;
            legForwardScl = 1f; // -
            legBaseOffset = -3f;
            legMoveSpace = 1.5f;
            legExtension = -2f;
            legLengthScl = 0.96f;
            legMaxLength = 1.3f;
            legMinLength = 0.2f;
            legStraightness = 0.3f;
            lockLegBase = true;
            legContinuousMove = true;
            immunities.add(VeStatusEffects.dusty);
            weapons.add(
                    new Weapon(VeName("mount-purple-weapon")) {{
                        rotate = true;
                        shootY = 4f;
                        x = 5.5f;
                        y = 4f;
                        ejectEffect = Fx.none; // -
                        shootSound = Sounds.shootSap;
                        reload = 18f;
                        bullet = new SapBulletType() {{
                            length = 50f;
                            sapStrength = 0.8f;
                            color = lightColor = hitColor = Pal.reactorPurple;
                            width = 0.4f; // -
                            lifetime = 25f;
                            damage = 18f;
                            knockback = -0.65f;
                            despawnEffect = Fx.none; // -
                            shootEffect = Fx.shootSmallColor;
                        }};
                    }},
                    new Weapon(VeName("spiroct-weapon")) {{
                        rotate = true;
                        shootY = 4f;
                        x = 5f; // -
                        y = -5.75f;
                        ejectEffect = Fx.none; // -
                        recoil = 2f;
                        shootSound = Sounds.shootSap;
                        reload = 13f;
                        bullet = new SapBulletType() {{
                            length = 85f;
                            sapStrength = 0.5f; // -
                            color = hitColor = lightColor = Pal.reactorPurple;
                            width = 0.54f;
                            lifetime = 35f;
                            damage = 23f;
                            knockback = -1.24f;
                            despawnEffect = Fx.none; // -
                            shootEffect = Fx.shootSmallColor;
                        }};
                    }},
                    new Weapon(VeName("velocite-laser")) {{
                        rotate = true;
                        rotateSpeed = 3f;
                        shootY = 3f; // -
                        x = 12.25f;
                        y = -4.75f;
                        shake = 3f;
                        shoot = new ShootBarrel() {{
                            barrels = new float[] {
                                    -1.25f,0,0,
                                    1.25f,0,0
                            };
                            shots = 2;
                            shotDelay = 0f; // -
                        }};
                        ejectEffect = Fx.none; // -
                        recoil = 3f;
                        recoilTime = 40f;
                        shootSound = Sounds.shootEclipse;
                        reload = 60f;
                        bullet = new LaserBulletType(53f) {{
                            length = 128f;
                            sideLength = 24f;
                            sideWidth = 0.75f;
                            sideAngle = 60f;
                            colors = new Color[] {
                                    VePal.reactorPurple40,
                                    Pal.reactorPurple,
                                    Color.white
                            };
                            recoil = 0.1f;
                            hitEffect = shootEffect = Fx.hitLaserBlast; // -
                            hitColor = lightColor = Pal.reactorPurple;
                        }};
                    }}
            );
        }};

        slidoid = new UnitType("slidoid") {{
            constructor = LegsUnit::create;
            health = 9000f;
            armor = 11f;
            hitSize = 18f;
            researchCostMultiplier = 0.3f;
            speed = 3.2f;
            rotateSpeed = 3.5f;
            drag = 0.04f;
            accel = 0.05f;
            hovering = true;
            stepShake = 1f;
            rippleScale = 0.6f;
            groundLayer = Layer.legUnit;
            shadowElevation = 0.25f;
            lightColor = Pal.reactorPurple;
            loopSound = Sounds.loopHover;
            loopSoundVolume = 0.4f;
            stepSound = Sounds.walkerStep;
            stepSoundVolume = 0.6f;
            stepSoundPitch = 1.3f;
            stepSoundPitchRange = 0.1f; // -
            allowLegStep = true;
            legPhysicsLayer = false;
            legCount = 4; // -
            legGroupSize = 2; // -
            legLength = 36f;
            legForwardScl = 1f; // -
            legBaseOffset = 0f; // -
            legMoveSpace = 1.5f;
            legExtension = -2f;
            legLengthScl = 0.96f;
            legMaxLength = 1.3f;
            legMinLength = 0.2f;
            legSplashDamage = 40f;
            legSplashRange = 12f;
            legStraightness = 0.3f;
            lockLegBase = true;
            legContinuousMove = true;
            immunities.add(VeStatusEffects.dusty);
            parts.add(
                    new HoverPart() {{
                        radius = 16f;
                        x = 0f;
                        y = -10f;
                        phase = 65f;
                        stroke = 4f;
                        minStroke = 0f;
                        sides = 6;
                        color = Pal.reactorPurple;
                        mirror = false; // -
                        layerOffset = -0.001f;
                    }},
                    new RegionPart("-glow") {{
                        outline = false;
                        blending = Blending.additive;
                        layerOffset = 0.001f;
                        x = 0f;
                        y = 0f;
                        color = mixColor = VePal.reactorPurple67;
                    }}
            );
            weapons.add(
                    new Weapon(VeName("slidoid-bolt")) {{
                        rotate = true;
                        rotateSpeed = 6f;
                        shootY = 5.75f;
                        x = 7.25f;
                        y = 0.25f;
                        shadow = 10f;
                        shoot = new ShootBarrel() {{
                            barrels = new float[] {
                                    -1.25f, 0, 0,
                                    -0.25f, 0, 0,
                                    0.75f, 0, 0,
                                    -0.25f, 0, 0
                            };
                            shots = 2;
                            shotDelay = 0f;
                        }};
                        ejectEffect = Fx.none; // -
                        recoil = 1f;
                        shootSound = VeSounds.get("trLaserGatling");
                        reload = 7f;
                        inaccuracy = 1f;
                        bullet = new BasicBulletType(5f, 40f) {{
                            backColor = Pal.reactorPurple;
                            frontColor = Color.white;
                            width = 8f;
                            height = 8f;
                            shrinkY = 0f;
                            sprite = "missile";
                            lifetime = 27f;
                            maxRange = 192f;
                            drag = -0.03f;
                            keepVelocity = true; // -
                            lifesteal = 0.4f;
                            despawnHit = true;
                            status = StatusEffects.sapped;
                            statusDuration = 5f * 60f;
                            hitEffect = Fx.hitLaserBlast;
                            hitColor = Pal.reactorPurple;
                            despawnEffect = Fx.none;
                            shootEffect = Fx.shootSmallColor;
                            smokeEffect = new WaveEffect() {{
                                colorTo = lightColor = Pal.reactorPurple;
                                sizeTo = 14f;
                                strokeFrom = 4f;
                                lifetime = 5f;
                            }};
                            trailColor = Pal.reactorPurple;
                            trailLength = 5;
                        }};
                    }},
                    new Weapon(VeName("slidoid-bolt")) {{
                        rotate = true;
                        rotateSpeed = 6f;
                        shootY = 5.75f;
                        x = 15.72f;
                        y = -13.5f;
                        shadow = 10f;
                        shoot = new ShootBarrel() {{
                            barrels = new  float[] {
                                    -1.25f, 0, 0,
                                    -0.25f, 0, 0,
                                    0.75f, 0, 0,
                                    -0.25f, 0, 0
                            };
                            shots = 2;
                            shotDelay = 0f;
                        }};
                        ejectEffect = Fx.none; // -
                        recoil = 1f;
                        shootSound = VeSounds.get("trLaserGatling");
                        reload = 9f;
                        inaccuracy = 1f;
                        bullet = new BasicBulletType(5f, 40f) {{
                            backColor = Pal.reactorPurple;
                            frontColor = Color.white;
                            width = 8f;
                            height = 8f;
                            shrinkY = 0f;
                            sprite = "missile";
                            lifetime = 27f;
                            maxRange = 192f;
                            drag = -0.03f;
                            keepVelocity = true; // -
                            lifesteal = 0.4f;
                            despawnHit = true;
                            status = StatusEffects.sapped;
                            statusDuration = 5f * 60f;
                            hitEffect = Fx.hitLaserBlast;
                            hitColor = Pal.reactorPurple;
                            despawnEffect = Fx.none;
                            shootEffect = Fx.shootSmallColor;
                            smokeEffect = new WaveEffect() {{
                                colorTo = lightColor = Pal.reactorPurple;
                                sizeTo = 14f;
                                strokeFrom = 4f;
                                lifetime = 5f;
                            }};
                            trailColor = Pal.reactorPurple;
                            trailLength = 5;
                        }};
                    }},
                    new Weapon(VeName("spiroct-weapon")) {{
                        rotate = true;
                        rotateSpeed = 9f;
                        shootY = 4.75f;
                        x = 7.25f;
                        y = 13.75f;
                        shake = 1f;
                        shoot.shots = 2;
                        shoot.shotDelay = 3f;
                        ejectEffect = Fx.none; // -
                        recoil = 1.5f; // -
                        shootSound = Sounds.shootArc;
                        reload = 20f;
                        bullet = new LightningBulletType() {{
                            damage = 42f;
                            status = StatusEffects.sapped;
                            statusDuration = 4f * 60f;
                            lightningColor = Pal.reactorPurple;
                            lightningLength = 15;
                            lightningLengthRand = 3;
                            hitEffect = Fx.hitLaserBlast;
                            hitColor = Pal.reactorPurple;
                            shootEffect = Fx.colorSpark;
                        }};
                    }}
            );
        }};

        hovopid = new UnitType("hovopid") {{
            constructor = LegsUnit::create;
            health = 20000f;
            armor = 13f;
            hitSize = 40f;
            researchCostMultiplier = 0.1f;
            speed = 4.2f;
            rotateSpeed = 2.5f;
            drag = 0.04f;
            accel = 0.04f;
            hovering = true;
            stepShake = 1f;
            rippleScale = 1f; // -
            groundLayer = Layer.legUnit;
            shadowElevation = 0.3f;
            lightColor = Pal.reactorPurple;
            loopSound = Sounds.loopHover;
            loopSoundVolume = 0.6f;
            stepSound = Sounds.walkerStep;
            stepSoundVolume = 0.8f;
            stepSoundPitch = 1.2f;
            stepSoundPitchRange = 0.1f; // -
            allowLegStep = true;
            legPhysicsLayer = false;
            legCount = 6;
            legGroupSize = 2;
            legLength = 52f;
            legForwardScl = 1.2f;
            legBaseOffset = 0f; // -
            legMoveSpace = 1.2f;
            legExtension = -2f;
            legLengthScl = 0.96f;
            legMaxLength = 1.3f;
            legMinLength = 0.2f;
            legSplashDamage = 70f;
            legSplashRange = 8f;
            legStraightness = 0.3f;
            lockLegBase = true;
            legContinuousMove = true;
            immunities.add(VeStatusEffects.dusty);
            parts.add(
                    new HoverPart() {{
                        radius = 24f;
                        x = 12.75f;
                        y = -11.75f;
                        phase = 65f;
                        stroke = 4f;
                        minStroke = 0f;
                        sides = 4; // -
                        color = Pal.reactorPurple;
                        mirror = true;
                        layerOffset = -0.001f;
                    }},
                    new RegionPart("-glow") {{
                        outline = false;
                        blending = Blending.additive;
                        layerOffset = 0.001f;
                        x = 0f;
                        y = 0f;
                        color = VePal.reactorPurple67;
                        mixColor = VePal.reactorPurple67;
                    }}
            );
            weapons.add(
                    new Weapon(VeName("hovopid-cog")) {{
                        mirror = false;
                        rotate = true;
                        rotateSpeed = 5f;
                        layerOffset = 0.1f;
                        x = 0f;
                        y = 12.25f;
                        shadow = 14f;
                        shake = 1f;
                        shoot.shots = 4;
                        shoot.shotDelay = 2f;
                        ejectEffect = Fx.none; // -
                        recoil = 1f;
                        recoilTime = 20f;
                        shootSound = VeSounds.get("shootAltLongClassic");
                        reload = 120f;
                        inaccuracy = 15f;
                        parts.add(
                                new RegionPart("-blade") {{
                                    progress = PartProgress.reload;
                                    moveY = -3f;
                                    under = false;
                                }},
                                new RegionPart("-side") {{
                                    mirror = true;
                                    progress = PartProgress.reload;
                                    growY = -3f;
                                    moveRot = -30f;
                                    under = true;
                                }}
                        );
                        bullet = new BasicBulletType(12f, 25f) {{
                            backColor = frontColor = Pal.reactorPurple;
                            width = 9f;
                            height = 9f;
                            shrinkY = 0f;
                            spin = 12f;
                            sprite = VeName("buzzsaw");
                            lifetime = 40f; // -
                            rangeOverride = 240f;
                            accel = -0.3f;
                            shieldDamageMultiplier = 4f;
                            hitSize = 8f;
                            hittable = true; // -
                            absorbable = true; // -
                            knockback = 0.8f;
                            impact = true;
                            sticky = true;
                            stickyExtraLifetime = 8f * 60f;
                            bulletInterval = 5f;
                            intervalBullets = 1; // -
                            intervalBullet = new BasicBulletType(0f, 6f) {{
                                backColor = frontColor = Color.clear;
                                shrinkY = 0f;
                                lifetime = 1f;
                                pierceArmor = true;
                                hitSize = 24f;
                                despawnHit = false; // -
                                hitEffect = Fx.hitLaserBlast;
                                hitColor = Pal.reactorPurple;
                                despawnEffect = Fx.none;
                            }};
                            despawnEffect = Fx.blastExplosion;
                            shootEffect = Fx.shootBig;
                            despawnSound = Sounds.explosion;
                        }};
                    }},
                    new Weapon(VeName("hovopid-cog")) {{
                        mirror = true; // -
                        alternate = false;
                        rotate = true;
                        rotateSpeed = 5f;
                        layerOffset = 0.1f;
                        x = 25f;
                        y = 0.75f;
                        shadow = 14f;
                        shake = 1f;
                        shoot.shots = 4;
                        shoot.shotDelay = 2f;
                        ejectEffect = Fx.none; // -
                        recoil = 1f;
                        recoilTime = 20f;
                        shootSound = VeSounds.get("shootAltLongClassic");
                        reload = 60f;
                        inaccuracy = 15f;
                        parts.add(
                                new RegionPart("-blade") {{
                                    progress = PartProgress.reload;
                                    moveY = -3f;
                                    under = false;
                                }},
                                new RegionPart("-side") {{
                                    mirror = true;
                                    progress = PartProgress.reload;
                                    growY = -3f;
                                    moveRot = -30f;
                                    under = true;
                                }}
                        );
                        bullet = new BasicBulletType(12f, 25f) {{
                            backColor = frontColor = Pal.reactorPurple;
                            width = 9f;
                            height = 9f;
                            shrinkY = 0f;
                            spin = 12f;
                            sprite = VeName("buzzsaw");
                            lifetime = 40f; // -
                            rangeOverride = 240f;
                            accel = -0.3f;
                            shieldDamageMultiplier = 4f;
                            hitSize = 8f;
                            hittable = true; // -
                            absorbable = true; // -
                            knockback = 0.8f;
                            impact = true;
                            sticky = true;
                            stickyExtraLifetime = 8f * 60f;
                            bulletInterval = 5f;
                            intervalBullets = 1; // -
                            intervalBullet = new BasicBulletType(0f, 6f) {{
                                backColor = frontColor = Color.clear;
                                shrinkY = 0f;
                                lifetime = 1f;
                                pierceArmor = true;
                                hitSize = 24f;
                                despawnHit = false; // -
                                hitEffect = Fx.hitLaserBlast;
                                hitColor = Pal.reactorPurple;
                                despawnEffect = Fx.none;
                            }};
                            despawnEffect = Fx.blastExplosion;
                            shootEffect = Fx.shootBig;
                            despawnSound = Sounds.explosion;
                        }};
                    }},
                    new Weapon(VeName("hovopid-shotgun")) {{
                        rotate = true;
                        rotateSpeed = 8f;
                        rotationLimit = 150f;
                        layerOffset = -0.01f;
                        shootX = 0f; // -
                        shootY = 10f;
                        x = 19.75f;
                        y = 15.25f;
                        shake = 5f;
                        shoot = new ShootSpread(3, 15f) {{
                            shotDelay = 0f; // -
                        }};
                        ejectEffect = Fx.casing3;
                        recoil = 4f;
                        cooldownTime = 40f;
                        shootSound = Sounds.shootToxopidShotgun;
                        reload = 13f;
                        shootCone = 60f;
                        bullet = new ShrapnelBulletType() {{
                            length = 88f;
                            width = 22f;
                            fromColor = toColor = Pal.reactorPurple;
                            serrations = 6;
                            serrationLenScl = 1f;
                            serrationWidth = 6f;
                            serrationSpaceOffset = 18f;
                            serrationFadeOffset = 0f;
                            damage = 104f;
                            knockback = 4f;
                            status = StatusEffects.sapped;
                            statusDuration = 5f * 60f;
                            shootEffect = Fx.sparkShoot;
                            smokeEffect = Fx.shootBigSmoke;
                            lightColor = Pal.reactorPurple;
                        }};
                    }}
            );
        }};

        // hovership
        dust = new UnitType("dust") {{
            constructor = ElevationMoveUnit::create;
            health = 190f;
            armor = 0f; // -
            hitSize = 10f;
            itemCapacity = 20;
            canDrown = false;
            drownTimeMultiplier = 99999f; // -
            fogRadius = 80f;
            researchCostMultiplier = 0.01f;
            flying = false; // -
            speed = 2.75f;
            strafePenalty = 1f;
            rotateSpeed = 9f;
            drag = 0.06f;
            accel = 0.07f;
            hovering = true;
            groundLayer = 70f;
            lowAltitude = true;
            shadowElevation = 0.1f;
            engineOffset = 6.5f;
            engineSize = 2f;
            useEngineElevation = false;
            lightColor = VePal.skyBlue;
            loopSound = Sounds.loopHover;
            loopSoundVolume = 0.15f;
            immunities.addAll(VeStatusEffects.blown, VeStatusEffects.dusty);
            parts.add(new HoverPart() {{
                radius = 5f;
                x = 5.5f;
                y = -1f;
                phase = 90f;
                stroke = 2f;
                minStroke = 0f;
                sides = 4; // -
                color = VePal.skyBlue;
                mirror = true;
                layerOffset = -0.001f;
            }});
            weapons.add(new Weapon(VeName("dust-weapon")) {{
                mirror = true; // -
                top = true; // -
                x = 4.75f;
                y = -2.5f;
                shoot = new ShootSpread() {{
                    spread = 0f;
                    shots = 3;
                    shotDelay = 5f;
                }};
                ejectEffect = Fx.casing1;
                recoil = 3.5f;
                recoilTime = 20f;
                shootSound = Sounds.shootSalvo;
                reload = 45f;
                inaccuracy = 2f;
                bullet = new BasicBulletType(7f, 12f) {{
                    backColor = VePal.skyBlue;
                    frontColor = Color.white;
                    width = 5f; // -
                    height = 15f;
                    lifetime = 45f;
                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    hitColor = VePal.skyBlue;
                    shootEffect = Fx.shootSmallColor;
                    smokeEffect = Fx.colorSpark;
                    lightColor = VePal.skyBlue;
                }};
            }});
        }};

        mist = new UnitType("mist") {{
            constructor = ElevationMoveUnit::create;
            health = 650f;
            armor = 4f;
            hitSize = 16f;
            itemCapacity = 40;
            canDrown = false;
            drownTimeMultiplier = 99999f; // -
            fogRadius = 120f;
            researchCostMultiplier = 0.3f;
            flying = false; // -
            speed = 2.5f;
            strafePenalty = 1f;
            rotateSpeed = 7f;
            drag = 0.06f;
            accel = 0.06f;
            hovering = true;
            targetAir = false;
            groundLayer = 70f;
            lowAltitude = true;
            shadowElevation = 0.1f;
            engineOffset = 7f;
            engineSize = 2.5f; // -
            useEngineElevation = false;
            lightColor = VePal.skyBlue;
            loopSound = Sounds.loopHover;
            loopSoundVolume = 0.2f;
            immunities.addAll(VeStatusEffects.blown, VeStatusEffects.dusty);
            targetFlags = new BlockFlag[] {BlockFlag.factory};
            parts.add(
                    new HoverPart() {{
                        radius = 6f;
                        x = 7.5f;
                        y = -1.75f;
                        phase = 85f;
                        stroke = 2.25f;
                        minStroke = 0f;
                        sides = 4; // -
                        color = VePal.skyBlue;
                        mirror = true;
                        layerOffset = -0.002f;
                    }},
                    new HoverPart() {{
                        radius = 6f;
                        x = 0;
                        y = 7.5f;
                        phase = 85f;
                        stroke = 2f;
                        minStroke = 0f;
                        sides = 4; // -
                        color = VePal.skyBlue;
                        mirror = false;
                        layerOffset = -0.002f;
                    }},
                    new RegionPart("-glow") {{
                        outline = false;
                        blending = Blending.additive;
                        layerOffset = 0.001f;
                        color = mixColor = VePal.skyBlue67;
                    }}
            );
            weapons.add(new Weapon(VeName("mist-weapon")) {{
                mirror = true; // -
                top = true; // -
                layerOffset = 0.002f;
                shootX = 0.25f;
                shootY = 3.75f;
                x = 5.75f;
                y = -4.75f;
                ejectEffect = Fx.none; // -
                recoil = 2f;
                minWarmup = 0.13f;
                shootSound = Sounds.shootMerui;
                reload = 120f;
                shootStatus = StatusEffects.slow;
                shootStatusDuration = 3f * 60f;
                // parts.add();
                bullet = new ArtilleryBulletType(2f, 5f) {{
                    backColor = VePal.skyBlue;
                    frontColor = Color.white;
                    width = 10f;
                    height = 10f;
                    shrinkX = 0f; // -
                    shrinkY = 0f;
                    sprite = "circle-bullet";
                    lifetime = 100f;
                    keepVelocity = false;
                    hitSize = 10f;
                    collidesAir = false; // -
                    collides = true;
                    collideTerrain = true;
                    hittable = false;
                    reflectable = false;
                    fragRandomSpread = 0f;
                    fragBullets = 1;
                    fragVelocityMin = 1f;
                    fragBullet = new BasicBulletType(0f, 42f) {{
                        backColor = Color.valueOf("78abd1");
                        frontColor = VePal.skyBlue;
                        width = 10f;
                        height = 10f;
                        shrinkY = 0f;
                        sprite = "circle-bullet";
                        lifetime = 120f * 60f;
                        // hitSize = 14f;
                        hitSize = 16f;
                        collidesAir = false;
                        collides = true; // -
                        collideTerrain = true;
                        hittable = false;
                        reflectable = false;
                        knockback = 3f;
                        splashDamage = 55f;
                        splashDamageRadius = 32f;
                        status = VeStatusEffects.blown;
                        statusDuration = 15f * 60f;
                        layer = 25f;
                        hitEffect = new MultiEffect(
                                Fx.massiveExplosion,
                                new SeqEffect(
                                        new WaveEffect() {{
                                            colorTo = lightColor = VePal.skyBlue;
                                            sizeTo = 32f;
                                            sides = 24;
                                            strokeFrom = 4f;
                                            lifetime = 5f;
                                        }},
                                        new WaveEffect() {{
                                            colorTo = lightColor = VePal.skyBlue;
                                            sizeTo = 29f;
                                            sides = 24;
                                            strokeFrom = 6f;
                                            lifetime = 5f;
                                        }},
                                        new WaveEffect() {{
                                            colorTo = lightColor = VePal.skyBlue;
                                            sizeTo = 26f;
                                            sides = 24;
                                            strokeFrom = 6f;
                                            lifetime = 5f;
                                        }},
                                        new WaveEffect() {{
                                            colorTo = lightColor = VePal.skyBlue;
                                            sizeTo = 23f;
                                            sides = 24;
                                            strokeFrom = 6f;
                                            lifetime = 5f;
                                        }}
                                )
                        );
                        hitColor = VePal.skyBlue;
                        despawnEffect = Fx.smeltsmoke;
                        hitShake = 3f;
                        lightRadius = 0f;
                        lightColor = Color.clear;
                        hitSound = VeSounds.get("bang");
                        despawnSound = VeSounds.get("bangClassic");
                    }};
                    hitEffect = despawnEffect = Fx.smeltsmoke;
                    hitColor = lightColor = trailColor = VePal.skyBlue;
                    shootEffect = Fx.shootBigColor;
                    smokeEffect = Fx.shootBigSmoke;
                    trailChance = 0.1f;
                    hitSound = Sounds.none;
                    despawnSound = Sounds.none; // -
                }};
            }});
        }};

        haze = new UnitType("haze") {{
            constructor = ElevationMoveUnit::create;
            health = 1100f;
            armor = 6f;
            hitSize = 20f;
            itemCapacity = 80;
            canDrown = false;
            drownTimeMultiplier = 99999f; // -
            fogRadius = 160f;
            researchCostMultiplier = 0.5f;
            flying = false; // -
            speed = 2f;
            strafePenalty = 1f;
            rotateSpeed = 4f;
            drag = 0.05f;
            accel = 0.05f;
            hovering = true;
            faceTarget = false;
            groundLayer = 70f;
            lowAltitude = true;
            shadowElevation = 0.15f;
            setEnginesMirror(
                    new UnitEngine(5f, -9.25f, 2.5f, -45f),
                    new UnitEngine(-5f, -9.25f, 2.5f, -135f)
            );
            engineOffset = 12f;
            engineSize = 0f;
            useEngineElevation = false;
            lightColor = VePal.skyBlue;
            loopSound = Sounds.loopHover;
            loopSoundVolume = 0.35f;
            immunities.addAll(VeStatusEffects.blown, VeStatusEffects.dusty);
            targetFlags = new BlockFlag[] {BlockFlag.turret};
            parts.add(
                    new HoverPart() {{
                        radius = 8f;
                        x = 11f;
                        y = 0f;
                        phase = 80f;
                        stroke = 2.5f;
                        minStroke = 0f;
                        sides = 6;
                        color = VePal.skyBlue;
                        mirror = true;
                        layerOffset = -0.001f;
                    }},
                    new RegionPart("-glow") {{
                        outline = false;
                        blending = Blending.additive;
                        layerOffset = 0.001f;
                        x = 0f;
                        y = 0f;
                        color = mixColor = VePal.skyBlue67;
                    }}
            );

            BulletType hazeBullet = ChainFragBullet.create(
                    new FragLayer[]{
                            new FragLayer(24f, 11f, 10f, 12f, 2f).basicFields(6f, 12f),
                            new FragLayer(22f, 10f, 13f, 16f, 2f).basicFields(11f, 11f),
                            new FragLayer(20f, 9f, 16f, 20f, 2f).basicFields(10f, 10f),
                            new FragLayer(18f, 9f, 19f, 24f, 2f).basicFields(9f, 9f),
                            new FragLayer(16f, 8f, 22f, 28f, 2f).basicFields(8f, 8f),
                            new FragLayer(14f, 7f, 24f, 26f, 1f).basicFields(7f, 7f),
                            new FragLayer(12f, 7f, 25f, 24f, 1f).basicFields(6f, 6f),
                            new FragLayer(10f, 6f, 24f, 22f, 1f).basicFields(5f, 5f),
                            new FragLayer(6f, 5f, 22f, 20f, 1f).basicFields(4f, 4f),
                            new FragLayer(6f, 4f, 19f, 18f, 1f).basicFields(3f, 3f),
                            new FragLayer(4f, 4f, 15f, 16f, 1f).basicFields(2f, 2f),
                            new FragLayer(2f, 4f, 35f, 40f, 3f).basicFields(1f, 1f)
                    },
                    new BasicBulletType(2.5f, 5f) {{
                        backColor = VePal.skyBlue;
                        frontColor = Color.white;
                        width = 6f;
                        height = 12f;
                        shrinkY = 0f;
                        sprite = "circle-bullet";
                        lifetime = 24f;
                        shieldDamageMultiplier = 2.5f;
                        hitSize = 11f;
                        splashDamage = 10f;
                        splashDamageRadius = 12f;
                        status = VeStatusEffects.blown;
                        statusDuration = 15f * 60f;
                        fragOnHit = false; // TODO
                        delayFrags = true;
                        fragRandomSpread = 0f;
                        fragBullets = 1;
                        fragVelocityMin = 1f;
                        fragOffsetMin = 2f;
                        fragOffsetMax = 2f;
                        hitEffect = new MultiEffect(
                                Fx.flakExplosion,
                                new SeqEffect(
                                        new WaveEffect() {{
                                            colorTo = lightColor = VePal.skyBlue;
                                            sizeTo = 12f;
                                            sides = 6;
                                            strokeFrom = 4f;
                                            lifetime = 10f;
                                        }}
                                )
                        );
                        lightColor = trailColor = VePal.skyBlue;
                        despawnEffect = Fx.flakExplosion;
                        despawnShake = 2f;
                        trailChance = 0.1f;
                        hitSound = despawnSound = VeSounds.get("bangClassic");
                    }}
            );
            hazeBullet.drag = 0.04f;
            hazeBullet.shootEffect = Fx.shootBigColor;
            hazeBullet.smokeEffect = Fx.shootBigSmoke;
            hazeBullet.hitColor = VePal.skyBlue;
            hazeBullet.maxRange = 432f;
            hazeBullet.speed = 5f;
            ((BasicBulletType) hazeBullet).shrinkX = -1f;
            var lastBullet = BulletChain.last(hazeBullet);
            lastBullet.despawnEffect = Fx.blastExplosion;
            lastBullet.knockback = 1;
            lastBullet.hitEffect = new MultiEffect(
                    Fx.blastExplosion,
                    new SeqEffect(
                            new WaveEffect() {{
                                colorTo = lightColor = VePal.skyBlue;
                                sizeTo = 40f;
                                sides = 6;
                                strokeFrom = 4f;
                                lifetime = 5f;
                            }},
                            new WaveEffect() {{
                                colorTo = lightColor = VePal.skyBlue;
                                sizeTo = 40f;
                                sides = 6;
                                strokeFrom = 4f;
                                lifetime = 5f;
                            }},
                            new WaveEffect() {{
                                colorTo = lightColor = VePal.skyBlue;
                                sizeTo = 40f;
                                sides = 6;
                                strokeFrom = 4f;
                                lifetime = 5f;
                            }}
                    )
            );

            weapons.add(
                    new Weapon(VeName("dust-weapon")) {{
                        mirror = true;
                        useAttackRange = false;
                        rotate = true;
                        rotateSpeed = 9f;
                        top = true;
                        layerOffset = 0.002f;
                        x = 7f;
                        y = 6.75f;
                        shoot = new ShootSpread(3, 0f) {{shotDelay = 5f;}};
                        ejectEffect = Fx.casing1;
                        recoil = 3.5f;
                        recoilTime = 20f;
                        minWarmup = 0.95f;
                        shootSound = Sounds.shootSalvo;
                        reload = 40f;
                        inaccuracy = 2f;
                        bullet = new BasicBulletType(7f, 12f) {{
                            backColor = VePal.skyBlue;
                            frontColor = Color.white;
                            width = 5f; // -
                            height = 15f;
                            lifetime = 45f;
                            hitEffect = despawnEffect = Fx.hitBulletColor;
                            hitColor = VePal.skyBlue;
                            shootEffect = Fx.shootSmallColor;
                            smokeEffect = Fx.colorSpark;
                            lightColor = VePal.skyBlue;
                        }};
                    }},
                    new Weapon(VeName("haze-weapon")) {{
                        mirror = true; // -
                        alternate = false;
                        rotate = true;
                        rotateSpeed = 4f;
                        top = true; // -
                        layerOffset = 0.002f;
                        x = 7.75f;
                        y = -3.5f;
                        shadow = 8f;
                        shake = 3f;
                        ejectEffect = Fx.casing4;
                        recoil = 5f;
                        recoilPow = 3f;
                        shootSound = Sounds.shootArtillery;
                        reload = 70f;
                        bullet = hazeBullet;
                    }},
                    new Weapon(VeName("haze-weapon")) {{
                        mirror = false;
                        alternate = false;
                        rotate = true;
                        rotateSpeed = 4f;
                        top = true; // -
                        layerOffset = 0.002f;
                        x = 0f;
                        y = 9.25f;
                        shadow = 8f;
                        shake = 3f;
                        ejectEffect = Fx.casing4;
                        recoil = 5f;
                        recoilPow = 3f;
                        shootSound = Sounds.shootArtillery;
                        reload = 140f;
                        bullet = hazeBullet;
                    }}
            );
        }};

        hurricane = new UnitType("hurricane") {{
            constructor = ElevationMoveUnit::create;
            health = 9000f;
            armor = 10f;
            maxRange = 520f;
            hitSize = 45f;
            itemCapacity = 160;
            canDrown = false;
            drownTimeMultiplier = 99999f; // -
            fogRadius = 240f;
            researchCostMultiplier = 0.05f;
            flying = false; // -
            speed = 1.5f;
            strafePenalty = 1f;
            rotateSpeed = 2f;
            drag = 0.04f;
            accel = 0.04f;
            hovering = true;
            groundLayer = 70f;
            lowAltitude = true;
            shadowElevation = 0.2f;
            setEnginesMirror(
                    new UnitEngine(4.5f, -19.5f, 3f, -70f),
                    new UnitEngine(-4.5f, -19.5f, 3f, -110f)
            );
            engineOffset = 22f;
            engineSize = 4f;
            useEngineElevation = false;
            lightColor = VePal.skyBlue;
            deathSound = VeSounds.get("si2Explode");
            loopSound = Sounds.loopHover;
            loopSoundVolume = 0.6f;
            immunities.addAll(StatusEffects.burning, StatusEffects.wet, StatusEffects.tarred,
                    VeStatusEffects.blown, VeStatusEffects.dusty);
            targetFlags = new BlockFlag[] {BlockFlag.drill, BlockFlag.battery, BlockFlag.reactor,
                    BlockFlag.repair, BlockFlag.storage};
            parts.addAll(
                    new HoverPart() {{
                        radius = 13f;
                        x = 18.5f;
                        y = -18.5f;
                        rotation = 45f;
                        phase = 65f;
                        stroke = 4f;
                        minStroke = 0f;
                        sides = 4; // -
                        color = VePal.skyBlue;
                        mirror = true;
                        layerOffset = -0.001f;
                    }},
                    new HoverPart() {{
                        radius = 7f;
                        x = 14f;
                        y = 16f;
                        rotation = 45f;
                        phase = 65f;
                        stroke = 2.5f;
                        minStroke = 0f;
                        sides = 4; // -
                        color = VePal.skyBlue;
                        mirror = true;
                        layerOffset = -0.001f;
                    }},
                    new HaloPart() {{
                        tri = true;
                        shapes = 2;
                        radius = 2f;
                        triLength = 5.5f;
                        triLengthTo = 0f;
                        haloRadius = 4.9f;
                        haloRadiusTo = 3f;
                        haloRotateSpeed = -2.5f;
                        x = 0f;
                        y = 0f;
                        shapeRotation = 70f;
                        rotateSpeed = 0f;
                        color = VePal.skyBlue;
                        mirror = false; // -
                        layer = Layer.effect;
                    }},
                    new HaloPart() {{
                        tri = true;
                        shapes = 2;
                        radius = 2f;
                        triLength = 0f;
                        triLengthTo = 5.5f;
                        haloRadius = 3f;
                        haloRadiusTo = 4.9f;
                        haloRotateSpeed = -7.5f;
                        x = 0f;
                        y = 0f;
                        shapeRotation = 70f;
                        rotateSpeed = 0f;
                        color = VePal.skyBlue;
                        mirror = false; // -
                        layer = Layer.effect;
                    }},
                    new ShapePart() {{
                        circle = true;
                        hollow = true;
                        radius = 4f;
                        stroke = 3.5f;
                        strokeTo = 4f;
                        x = 0f;
                        y = 0f;
                        color = VePal.skyBlue;
                        mirror = false; // -
                        layer = Layer.effect;
                    }},
                    new RegionPart("-glow") {{
                        outline = false;
                        blending = Blending.additive;
                        layerOffset = 0.001f;
                        x = 0f;
                        y = 0f;
                        color = mixColor = VePal.skyBlue67;
                    }}
            );
            abilities.add(new EnergyFieldAbility(20f, 30f, 128f) {{
                healEffect = Fx.none;
                hitEffect = Fx.hitLaserBlast; // -
                damageEffect = Fx.chainLightning; // -
                status = VeStatusEffects.blown;
                shootSound = Sounds.none;
                statusDuration = 20f * 60f;
                x = 0f;
                y = 0f;
                targetGround = false;
                targetAir = true; // -
                hitBuildings = false;
                maxTargets = 1024;
                healPercent = 0.1f;
                displayHeal = false;
                effectRadius = 0f;
                sectorRad = 0.2f;
                rotateSpeed = -7.5f;
                sectors = 2;
                color = VePal.skyBlue;
            }});
            weapons.add(
                    new Weapon() {{
                        display = false;
                        mirror = false;
                        useAttackRange = false;
                        x = 0f;
                        y = 0f; // -
                        minWarmup = 2f;
                    }},
                    new StatefulWeapon(VeName("hurricane-gatling")) {{
                        mirror = true; // -
                        alternate = false;
                        rotate = true;
                        rotateSpeed = 2f;
                        rotationLimit = 90f;
                        top = true; // -
                        layerOffset = 0.01f;
                        shootY = 22.5f;
                        x = 14f;
                        y = -5f;
                        shadow = 20f;
                        shake = 2f;
                        ejectEffect = Fx.casing2;
                        recoil = 0f;
                        recoilTime = 60f;
                        cooldownTime = 300f;
                        shootWarmupSpeed = 0.001f;
                        linearWarmup = true;
                        soundPitchMin = 0.9f;
                        soundPitchMax = 1f; // -
                        shootSound = VeSounds.get("mgsvGatling");
                        shootSoundVolume = 1f; // -
                        reload = 2f;
                        inaccuracy = 1f;
                        velocityRnd = 0.1f;
                        shootCone = 361f;

                        StatefulRegionPart hurricaneTube1 = new StatefulRegionPart("-tube") {{
                            speedFunc = PartProgress.heat.min(PartProgress.constant(0.9f)).mul(Mathf.halfPi / 8f / 0.9f);
                            modAmount = Mathf.halfPi;
                            progress = VePartProgress.sinOf(accumulator);
                            mirror = false; // -
                            heatProgress = PartProgress.warmup;
                            layerOffset = -0.0005f;
                            x = 0f;
                            y = 0f;
                            moveX = 1.5f;
                            moveY = 0f;
                            color = Color.white;
                            colorTo = VePal.gray221;
                            under = true;
                        }};
                        parts.add(
                                hurricaneTube1,
                                new RegionPart("-tube") {{
                                    progress = VePartProgress.sinOf(hurricaneTube1.accumulator.add(Mathf.halfPi));
                                    mirror = false; // -
                                    heatProgress = PartProgress.warmup;
                                    layerOffset = -0.0015f;
                                    x = 0f;
                                    y = 0f;
                                    moveX = 1.5f;
                                    moveY = 0f;
                                    color = VePal.gray187;
                                    colorTo = VePal.gray221;
                                    under = true;
                                }},
                                new RegionPart("-tube") {{
                                    progress = VePartProgress.sinOf(hurricaneTube1.accumulator);
                                    mirror = false; // -
                                    heatProgress = PartProgress.warmup;
                                    layerOffset = -0.0020f;
                                    x = 0;
                                    y = 0f;
                                    moveX = -1.5f;
                                    moveY = 0f;
                                    color = VePal.gray187;
                                    colorTo = VePal.gray221;
                                    under = true;
                                }},
                                new RegionPart("-tube") {{
                                    progress = VePartProgress.sinOf(hurricaneTube1.accumulator.add(Mathf.halfPi));
                                    mirror = false; // -
                                    heatProgress = PartProgress.warmup;
                                    layerOffset = -0.0010f;
                                    x = 0f;
                                    y = 0f;
                                    moveX = -1.5f;
                                    moveY = 0f;
                                    color = Color.white;
                                    colorTo = VePal.gray221;
                                    under = true;
                                }}
                        );

                        bullet = new BasicBulletType(13f, 29f) {{
                            backColor = VePal.skyBlue;
                            frontColor = Color.white;
                            width = 6f;
                            height = 20f;
                            shrinkY = 0f;
                            lifetime = 36f;
                            maxRange = 468f;
                            rangeOverride = 468f;
                            buildingDamageMultiplier = 1.4f;
                            shieldDamageMultiplier = 1.5f;
                            pierceArmor = true;
                            pierce = true;
                            pierceBuilding = false;
                            pierceCap = 3;
                            knockback = 4f;
                            impact = true;
                            status = VeStatusEffects.blown;
                            statusDuration = 3f * 60f;
                            hitEffect = new MultiEffect(
                                    Fx.hitBulletColor,
                                    new WaveEffect() {{
                                        colorTo = lightColor = VePal.skyBlue;
                                        sizeTo = 24f;
                                        sides = 4;
                                        strokeFrom = 4f;
                                        lifetime = 5f;
                                    }}
                                    /*
                                    new SeqEffect(new WaveEffect() {{
                                        colorTo = lightColor = VePal.skyBlue;
                                        sizeTo = 24f;
                                        sides = 4;
                                        strokeFrom = 4f;
                                        lifetime = 5f;
                                    }}
                                    )
                                    */
                            );
                            hitColor = lightColor = VePal.skyBlue;
                            despawnEffect = Fx.hitBulletColor;
                            shootEffect = Fx.shootBigColor;
                            smokeEffect = Fx.colorSpark;
                        }};
                    }},
                    new Weapon() {{
                        display = false;
                        alternate = false;
                        useAttackRange = false;
                        rotate = true;
                        rotateSpeed = 2f;
                        rotationLimit = 90f;
                        shootY = 17.5f; // 22.5
                        x = 14f;
                        y = -5f;
                        minWarmup = 0.99f;
                        shootWarmupSpeed = 0.001f; // overheaten
                        linearWarmup = true;
                        soundPitchMin = 1f;
                        soundPitchMax = 1f; // -
                        shootSound = VeSounds.get("mgsvGatlingOverheaten");
                        shootSoundVolume = 1.2f;
                        initialShootSound = VeSounds.get("mgsvGatlingOverheatenEdited");
                        // continuous = true;
                        reload = 30f;
                        shootCone = 361f;
                        shootStatus = StatusEffects.disarmed;
                        shootStatusDuration = 7f * 60f;
                        parts.add(new EffectSpawnerPart() {{
                            y = 12.75f;
                            width = 5.5f;
                            height = 12.5f;
                            effectChance = 0.25f;
                            effect = Fx.fuelburn;
                            progress = PartProgress.warmup.mul(PartProgress.warmup).mul(PartProgress.warmup).add(PartProgress.reload);
                        }});
                        bullet = new ContinuousBulletType() {{
                            length = 0f;
                            lifetime = 420f;
                            maxRange = 468f;
                            damage = 0f;
                            collides = false; // -
                            incendAmount = 0; // -
                            hitEffect = Fx.none;
                            despawnEffect = Fx.none; // -
                            smokeEffect = Fx.smokeCloud;
                        }};
                    }},
                    new Weapon(VeName("hurricane-missile-weapon")) {{
                        mirror = true; // -
                        useAttackRange = false;
                        rotate = true;
                        rotateSpeed = 5f;
                        top = false;
                        x = 8.75f;
                        y = -15f;
                        recoil = 0f;
                        shootSound = Sounds.shootHorizon;
                        predictTarget = false;
                        reload = 600f;
                        parts.add(new RegionPart("-missile") {{
                            progress = PartProgress.reload.mul(3f).add(0f);
                            color = Color.white;
                            colorTo = VePal.white0;
                            under = false;
                        }});
                        bullet = new BasicBulletType(999f, 1f) {{
                            rangeOverride = 520f;
                            spawnUnit = VeMissileUnitType.hurricaneMissile;
                            shootEffect = new WaveEffect() {{
                                colorTo = lightColor = VePal.skyBlue;
                                sizeTo = 24f;
                                sides = 4;
                                strokeFrom = 4f;
                                lifetime = 15f;
                            }};
                            smokeEffect = Fx.none;
                        }};
                    }}
            );
        }};

        meteorology = new UnitType("meteorology") {{
            constructor = ElevationMoveUnit::create;
            health = 20000f;
            armor = 13f;
            hitSize = 52f;
            itemCapacity = 300;
            canDrown = false;
            drownTimeMultiplier = 99999f; // -
            fogRadius = 240f;
            researchCostMultiplier = 0.05f;
            flying = false; // -
            speed = 1.7f;
            strafePenalty = 1f;
            boostMultiplier = 1.7f;
            rotateSpeed = 2f;
            drag = 0.033f;
            accel = 0.03f;
            riseSpeed = 0.015f;
            canBoost = true;
            hovering = true;
            groundLayer = 70f;
            lowAltitude = true;
            shadowElevation = 0.25f;
            engineOffset = 18f;
            engineSize = 8f;
            useEngineElevation = false;
            lightColor = VePal.skyBlue;
            deathSound = VeSounds.get("si2ExplodeLoud");
            loopSound = Sounds.loopHover;
            loopSoundVolume = 0.8f;
            immunities.addAll(StatusEffects.burning, StatusEffects.wet, StatusEffects.tarred,
                    VeStatusEffects.blown, VeStatusEffects.dusty, VeStatusEffects.frozen);
            targetFlags = new BlockFlag[] {BlockFlag.battery, BlockFlag.factory};
            parts.addAll(
                    new HoverPart() {{
                        radius = 15f;
                        x = 19.5f;
                        y = -20.75f;
                        phase = 75f;
                        stroke = 4.5f;
                        minStroke = 0f;
                        sides = 6;
                        color = VePal.skyBlue;
                        mirror = true;
                        layerOffset = -0.001f;
                    }},
                    new HoverPart() {{
                        radius = 12f;
                        x = 22f;
                        y = 14f;
                        phase = 75f;
                        stroke = 4f;
                        minStroke = 0f;
                        sides = 6;
                        color = VePal.skyBlue;
                        mirror = true;
                        layerOffset = -0.001f;
                    }},
                    new HaloPart() {{
                        tri = true;
                        shapes = 8;
                        radius = 6f;
                        triLength = 3f;
                        triLengthTo = 0f;
                        haloRadius = 6f;
                        haloRotateSpeed = 3.5f;
                        x = 0f;
                        y = 0f;
                        shapeRotation = 0f;
                        rotateSpeed = 0f; // -
                        color = VePal.skyBlue;
                        mirror = false; // -
                        layer = 110f;
                    }},
                    new HaloPart() {{
                        tri = true;
                        shapes = 8;
                        radius = 6f;
                        triLength = 0f;
                        triLengthTo = 3f;
                        haloRadius = 6f;
                        haloRotateSpeed = 9f;
                        x = 0f;
                        y = 0f;
                        shapeRotation = 0f;
                        rotateSpeed = 0f; // -
                        color = VePal.skyBlue;
                        mirror = false; // -
                        layer = 110f;
                    }},
                    new ShapePart() {{
                        circle = true;
                        hollow = true;
                        radius = 6f;
                        stroke = 2f;
                        strokeTo = 2f;
                        x = 0f;
                        y = 0f;
                        color = VePal.skyBlue;
                        mirror = false; // -
                        layer = 110f;
                    }},
                    new RegionPart("-glow") {{
                        outline = false;
                        blending = Blending.additive;
                        layerOffset = 0.001f;
                        x = 0f;
                        y = 0f;
                        color = VePal.skyBlue67;
                        mixColor = VePal.skyBlue67;
                    }}
            );
            abilities.add(new EnergyFieldAbility(80f, 20f, 256f) {{
                healEffect = Fx.none;
                hitEffect = Fx.hitLaserBlast; // -
                damageEffect = Fx.chainLightning; // -
                status = VeStatusEffects.blown;
                shootSound = Sounds.none;
                statusDuration = 20f * 60f;
                x = 0f;
                y = 0f;
                targetGround = false;
                targetAir = true; // -
                hitBuildings = false;
                maxTargets = 1024;
                healPercent = 0.1f;
                displayHeal = false;
                effectRadius = 3f;
                sectorRad = 0.2f;
                rotateSpeed = -10f;
                sectors = 2;
                color = VePal.skyBlue;
            }});
            weapons.add(
                    new Weapon() {{
                        mirror = false;
                        rotate = true;
                        rotateSpeed = 20f; // -
                        x = 0f;
                        y = 0f; // -
                        shake = 4f;
                        ejectEffect = Fx.none; // -
                        recoil = 0f;
                        recoilTime = 40f;
                        shootSound = Sounds.shootLancer;
                        reload = 80f;
                        parts.add(
                                new ShapePart() {{
                                    circle = true;
                                    hollow = false; // -
                                    radius = 0f;
                                    radiusTo = 6f;
                                    x = 0f;
                                    y = 0f;
                                    color = VePal.skyBlue;
                                    mirror = false; // -
                                    progress = PartProgress.recoil;
                                    layer = 110f;
                                }}
                        );
                        bullet = new BasicBulletType() {{
                            spawnUnit = VeMissileUnitType.meteorologyOrb;
                            shootEffect = new ExplosionEffect() {{
                                waveColor = smokeColor = sparkColor = VePal.skyBlue;
                                waveRad = 40f;
                                smokeRad = 40f;
                                smokes = 10;
                                sparkRad = 20f;
                                sparks = 10;
                                lifetime = 20f;
                            }};
                            smokeEffect = Fx.none;
                        }};
                    }},
                    new Weapon(VeName("meteorology-weapon")) {{
                        rotate = true;
                        rotateSpeed = 7f;
                        top = true; // -
                        layerOffset = 0.002f;
                        shootY = 3.25f;
                        x = 12.5f;
                        y = 11.5f;
                        shadow = 15f;
                        shake = 1.5f;
                        shoot.shots = 5;
                        shoot.shotDelay = 2f;
                        ejectEffect = Fx.casing2;
                        recoil = 1f;
                        shootSound = VeSounds.get("shootAltLongClassic");
                        reload = 30f;
                        inaccuracy = 15f;
                        velocityRnd = 0.3f;
                        bullet = new BasicBulletType(7f, 43f) {{
                            backColor = VePal.skyBlue;
                            frontColor = Color.white;
                            width = 10f;
                            height = 17f;
                            lifetime = 35f;
                            maxRange = 350f;
                            drag = -0.02f;
                            buildingDamageMultiplier = 1.7f;
                            homingPower = 0.04f;
                            homingRange = 315f;
                            homingDelay = 5f;
                            knockback = 2f;
                            despawnHit = true;
                            status = VeStatusEffects.blown;
                            statusDuration = 5f * 60f;
                            fragRandomSpread = 30f;
                            fragBullets = 2;
                            fragVelocityMin = 0.5f;
                            fragLifeMin = 0.5f;
                            fragBullet = new BasicBulletType(7f, 20f) {{
                                width = 9f;
                                height = 10f;
                                lifetime = 40f; // -
                                drag = 0.005f;
                                collides = false;
                                splashDamage = 47f;
                                splashDamageRadius = 32f;
                                status = VeStatusEffects.blown;
                                statusDuration = 5f * 60f;
                                hitEffect = despawnEffect = Fx.flakExplosion;
                                lightColor = VePal.skyBlue;
                            }};
                            hitEffect = new MultiEffect(
                                    Fx.hitBulletColor,
                                    new SeqEffect(
                                            new WaveEffect() {{
                                                colorTo = lightColor = VePal.skyBlue;
                                                sizeTo = 18f;
                                                sides = 4;
                                                strokeFrom = 4f;
                                                lifetime = 5f;
                                            }},
                                            new WaveEffect() {{
                                                colorTo = lightColor = VePal.skyBlue;
                                                sizeTo = 14f;
                                                sides = 4;
                                                strokeFrom = 4f;
                                                lifetime = 5f;
                                            }}
                                    )
                            );
                            hitColor = VePal.skyBlue;
                            despawnEffect = Fx.none;
                            shootEffect = Fx.shootBigColor;
                            smokeEffect = Fx.shootBigSmoke;
                            lightColor = trailColor = VePal.skyBlue;
                            trailLength = 3;
                        }};
                    }},
                    new Weapon(VeName("meteorology-weapon")) {{
                        rotate = true;
                        rotateSpeed = 7f;
                        top = true; // -
                        layerOffset = 0.002f;
                        shootY = 3.25f;
                        x = 22.25f;
                        y = -10f;
                        shadow = 15f;
                        shake = 1.5f;
                        shoot.shots = 5;
                        shoot.shotDelay = 2;
                        ejectEffect = Fx.casing2;
                        recoil = 1f;
                        shootSound = VeSounds.get("shootAltLongClassic");
                        reload = 40f;
                        inaccuracy = 15f;
                        velocityRnd = 0.3f;
                        bullet = new BasicBulletType(7f, 43f) {{
                            backColor = VePal.skyBlue;
                            frontColor = Color.white;
                            width = 10f;
                            height = 17f;
                            lifetime = 35f;
                            maxRange = 350f;
                            drag = -0.02f;
                            buildingDamageMultiplier = 1.7f;
                            homingPower = 0.04f;
                            homingRange = 315f;
                            homingDelay = 5f;
                            knockback = 2f;
                            despawnHit = true;
                            status = VeStatusEffects.blown;
                            statusDuration = 5f * 60f;
                            fragRandomSpread = 30f;
                            fragBullets = 2;
                            fragVelocityMin = 0.5f;
                            fragLifeMin = 0.5f;
                            fragBullet = new BasicBulletType(7f, 20f) {{
                                backColor = VePal.skyBlue;
                                frontColor = Color.white;
                                width = 9f;
                                height = 10f;
                                lifetime = 40f; // -
                                drag = 0.005f;
                                collides = false;
                                splashDamage = 47f;
                                splashDamageRadius = 32f;
                                status = VeStatusEffects.blown;
                                statusDuration = 5f * 60f;
                                hitEffect = despawnEffect = Fx.flakExplosion;
                                lightColor = VePal.skyBlue;
                            }};
                            hitEffect = new MultiEffect(
                                    Fx.hitBulletColor,
                                    new SeqEffect(
                                            new WaveEffect() {{
                                                colorTo = lightColor = VePal.skyBlue;
                                                sizeTo = 18f;
                                                sides = 4;
                                                strokeFrom = 4f;
                                                lifetime = 5f;
                                            }},
                                            new WaveEffect() {{
                                                colorTo = lightColor = VePal.skyBlue;
                                                sizeTo = 14f;
                                                sides = 4;
                                                strokeFrom = 4f;
                                                lifetime = 5f;
                                            }}
                                    )
                            );
                            hitColor = VePal.skyBlue;
                            despawnEffect = Fx.none;
                            shootEffect = Fx.shootBigColor;
                            smokeEffect = Fx.shootBigSmoke;
                            lightColor = trailColor = VePal.skyBlue;
                            trailLength = 3;
                        }};
                    }}
            );
        }};

        // 反制单位
        flocculate = new UnitType("flocculate") {{
            constructor = ElevationMoveUnit::create;
            health = 130f;
            armor = 0f; // -
            range = 3.15f;
            maxRange = 315f;
            hitSize = 10f;
            itemCapacity = 0;
            canDrown = false;
            drownTimeMultiplier = 99999f; // -
            fogRadius = 80f;
            researchCostMultiplier = 0.03f;
            flying = false; // -
            speed = 2.75f;
            strafePenalty = 1f;
            rotateSpeed = 6f;
            drag = 0.06f;
            accel = 0.07f;
            hovering = true;
            groundLayer = 70f;
            lowAltitude = true;
            shadowElevation = 0.1f;
            engineOffset = 6.5f;
            engineSize = 2f;
            useEngineElevation = false;
            lightColor = VePal.skyBlue;
            loopSound = Sounds.loopHover;
            loopSoundVolume = 0.15f;
            immunities.addAll(StatusEffects.disarmed,
                    VeStatusEffects.blown, VeStatusEffects.dusty);
            parts.add(new HoverPart() {{
                radius = 5f;
                x = 5f;
                y = -4f;
                phase = 90f;
                stroke = 2f;
                minStroke = 0f;
                sides = 4; // -
                color = VePal.skyBlue;
                mirror = true;
                layerOffset = -0.001f;
            }});
            abilities.add(
                    new RepairFieldAbility(18f, 45f, 40f),
                    new ForceFieldAbility(40f, 1.65f, 240f, 180f, 6, 0f)
            );
            weapons.add(new Weapon() {{
                display = false;
                mirror = true; // -
                top = true; // -
                x = 4.75f;
                y = -2.5f;
                shoot = new ShootSpread(3, 0f) {{
                    shotDelay = 5f;
                }};
                ejectEffect = Fx.casing1;
                recoil = 3.5f;
                recoilTime = 20f;
                minWarmup = 2f;
                reload = 45f;
                inaccuracy = 2f;
                bullet = new BasicBulletType(7f, 12f) {{
                    backColor = VePal.skyBlue;
                    frontColor = Color.white;
                    width = 5f; // -
                    height = 15f;
                    lifetime = 45f;
                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    hitColor = lightColor = VePal.skyBlue;
                    shootEffect = Fx.shootSmallColor;
                    smokeEffect = Fx.colorSpark;
                }};
            }});
        }};

        alleviate = new UnitType("alleviate") {{
            constructor = ElevationMoveUnit::create;
            health = 700f;
            armor = 4f;
            hitSize = 15f;
            itemCapacity = 40;
            canDrown = false;
            drownTimeMultiplier = 99999f; // -
            fogRadius = 90f;
            researchCostMultiplier = 0.3f;
            flying = false; // -
            speed = 2.7f;
            strafePenalty = 1f;
            rotateSpeed = 9f;
            drag = 0.06f;
            accel = 0.06f;
            hovering = true;
            targetAir = false;
            groundLayer = 70f;
            lowAltitude = true;
            shadowElevation = 0.1f;
            engineOffset = 8f;
            engineSize = 2.75f;
            useEngineElevation = false;
            lightColor = VePal.skyBlue;
            loopSound = Sounds.loopHover;
            loopSoundVolume = 0.2f;
            immunities.addAll(VeStatusEffects.blown, VeStatusEffects.dusty);
            targetFlags = new BlockFlag[] {BlockFlag.factory};
            parts.add(
                    new HoverPart() {{
                        radius = 6f;
                        x = 7f;
                        y = -5.25f;
                        phase = 85f;
                        stroke = 2.25f;
                        minStroke = 0f;
                        sides = 4; // -
                        color = VePal.skyBlue;
                        mirror = true;
                        layerOffset = -0.003f;
                    }},
                    new HoverPart() {{
                        radius = 6f;
                        x = 5f;
                        y = 2.25f;
                        phase = 85f;
                        stroke = 2f;
                        sides = 4; // -
                        color = VePal.skyBlue;
                        layerOffset = -0.003f;
                    }},
                    new RegionPart("-glow") {{
                        outline = false;
                        blending = Blending.additive;
                        layerOffset = 0.001f;
                        x = 0f;
                        y = 0f;
                        color = mixColor = VePal.skyBlue67;
                    }}
            );
            weapons.add(new Weapon(VeName("alleviate-missile")) {{
                mirror = false;
                layerOffset = -0.002f;
                shootX = 0f; // -
                shootY = 0f;
                x = 0f;
                y = 4.75f;
                ejectEffect = Fx.none; // -
                recoil = 8f;
                shootSound = Sounds.shootMissilePlasmaShort;
                predictTarget = false;
                reload = 50f;
                bullet = new BasicBulletType(999f, 1f) {{
                    spawnUnit = VeMissileUnitType.alleviateMissile;
                    hitColor = VePal.skyBlue;
                    shootEffect = Fx.shootBigColor;
                    smokeEffect = Fx.shootBigSmoke;
                }};
            }});
        }};


// UnitType
        /*
        unit = new UnitType("") {{
            constructor = UnitEntity::create;

//            "flying": UnitEntity::create;
//            "mech": MechUnit::create;
//            "legs": LegsUnit::create;
//            "naval": UnitWaterMove::create;
//            "payload": PayloadUnit::create;
//            "missile": TimedKillUnit::create;
//            "tank": TankUnit::create;
//            "hover": ElevationMoveUnit::create;
//            "tether": BuildingTetherPayloadUnit::create;
//            "crawl": CrawlUnit::create;

            // 属性
            health = f; // 200f 生命值
            armor = f; // 0f 护甲
            range = f; // -1f 最小攻击范围
            maxRange = f; // -1f 最大攻击范围
            aimDst = f; // -1f 武器可瞄准的最小距离
            hitSize = f; // 6f 碰撞箱边长大小
            mineRange = f; // 70f 挖掘范围
            mineSpeed = f; // 1f 挖掘速度
            mineTier = ; // -1 可挖掘的矿石最大硬度
            mineWalls = ; // false 能否从墙壁挖掘
            mineFloor = ; // true 能否从地板挖掘
            mineHardnessScaling = ; // true 更硬的矿石挖掘时间是否延长
            buildRange = ; // 220f 建造范围
            buildSpeed = f; // -1f 建造速度倍率
            rotateToBuilding = ; // true 是否面向正在建造的物体
            itemCapacity = ; // -1 可携带物品数量
            pickupUnits = ; // true 该单位能否搬起其他单位
            payloadCapacity = Mathf.sqr(f) * Vars.tilePayload; // 8 载荷容量
            createScorch = ; // true 死亡时是否会产生烧痕
            createWreck = ; // true 死亡时是否掉落残骸
            wreckHealthMultiplier = f; // 0.25f 残骸生命值倍率
            crashDamageMultiplier = f; // 1f 坠落伤害倍率
            dpsEstimate = f; // -1f DPS粗略估计
            canDrown = ; // true 能否被淹没
            drownTimeMultiplier = f; // -1f 沉没速度倍率
            fogRadius = f; // -1f 战争迷雾视野半径
            researchCostMultiplier = f; // 50f 研究成本倍数
            isEnemy = ; // true 是否被视为敌人
            flying = ; // false 是否为飞行单位
            wobble = ; // true 飞行单位是否摇晃
            targetBuildingsMobile = ; // true 仅移动端, 当玩家附身该单位时, 是否自动瞄准建筑进行附着
            allowedInPayloads = ; // true 能否被移动到载荷中
            logicControllable = ; // true 逻辑能否控制此单位
            playerControllable = ; // true 玩家能否控制该单位
            controlSelectGlobal = ; // true 能否被shift+g选中
            physics = ; // true 该单位能否与其他单位发生物理碰撞
            useUnitCap = ; // true 如果为false, 忽略单位上限, 无限生成
            coreUnitDock = ; // false 该核心机在解除附身之后是否重新出现
            hoverable = ; // true 是否显示悬停提示
            hidden = ; // false 是否隐藏
            bounded = ; // true 能否被推离地图边界

            // 移动
            speed = f; // 1.1f 移动速度
            strafePenalty = f; // 0.5f 侧向移动速度惩罚倍率
            boostMultiplier = f; // 1f 助推速度倍率
            floorMultiplier = f; // 1f 受地形影响的程度
            rotateSpeed = f; // 5f 身体转向速度
            baseRotateSpeed = f; // 5f 机甲转向速度
            drag = f; // 0.3f 移动阻力与移动速度的比例
            accel = f; // 0.5f 加速度与移动速度的比例
            riseSpeed = f; // 0.08f 助推时上升速度
            descentSpeed = f; // 0.08f 无助推时下落速度
            fallSpeed = f; // 0.018f 死亡时的坠落速度
            canBoost = ; // false 能否助推
            boostWhenBuilding = ; // true 处于建造者AI时助推
            boostWhenMining = ; // true 处于挖矿AI时助推
            hovering = ; // false 是否受下方地板影响
            omniMovement = ; // true 能否向任意方向移动, 如果为false, 则只能向前方移动
            rotateMoveFirst = ; // false 单位在实际移动前是否需要先面朝移动方向

            // 战斗
            targetPriority = f; // 0f 目标优先级
            canHeal = ; // false 能否修复建筑
            singleTarget = ; // false 武器是否攻击同一目标
            forceMultiTarget = ; // false 是否强制拥有多个目标
            canAttack = ; // true 能否攻击
            targetAir = ; // true 是否尝试攻击空中单位
            targetGround = ; // true 是否尝试攻击地面单位
            faceTarget = ; // true 攻击时是否面向目标
            circleTarget = ; // false 是否围绕目标盘旋
            circleTargetRadius = f; // 80f 围绕目标盘旋的范围
            autoDropBombs = ; // false 如果为true, 即使该单位不在其"真实"目标旁边, 也会投下炸弹, 用于地毯式轰炸机
            hittable = ; // true 能否被子弹或爆炸打中
            killable = ; // true 单位能否受伤和被击杀
            targetable = ; // true 能否被索敌
            vulnerableWithPayloads = ; // false 当该单位携带载荷时, 能否被索敌和被击中
            targetUnderBlocks = ; // true 是否攻击类似传送带的"下方"的建筑
            alwaysShootWhenMoving = ; // false 是否在移动时始终射击

            // 渲染
            clipSize = f; // -1f 单位渲染范围大小
            deathShake = f; // -1f 单位死亡时的震动强度
            stepShake = f; // -1f 单位行走时的震动强度
            rippleScale = f; // 1f 行走时扬起的尘埃云大小
            groundLayer = f; // 60f 地面单位渲染时所处的图层
            flyingLayer = f; // -1 飞行单位渲染时所处的图层
            lowAltitude = ; // false 是否在效果或子弹下方绘制
            drawCell = ; // true 是否绘制队伍指示器/单元格
            drawBody = ; // true 是否绘制单位身体
            squareShape = ; // false 是否具有方块阴影
            shadowElevation = f; // -1f 阴影垂直偏移量
            shadowElevationScl = f; // 1f 阴影缩放比例
            drawSoftShadow = ; // true 是否绘制软阴影
            softShadowScl = f; // 1f 软阴影缩放比例
            drawBuildBeam = ; // true 是否绘制建造光束
            buildBeamOffset = f; // 3.8f 建造光束向前的偏移量
            drawMineBeam = ; // true 是否绘制挖掘光束
            mineBeamOffset = f; // = hitSize / 2f 挖掘光束向前的偏移量
            drawShields = ; // true 是否绘制单位护盾
            shieldColor = Color.valueOf(""); // 单位护盾的颜色
            drawItems = ; // true 是否绘制携带物品
            itemOffsetY = f; // 3f 物品y轴偏移量
            drawMinimap = ; // true 是否在小地图上绘制
            internal = ; // false 是否仅用于内部用途且没有贴图
            internalGenerateSprites = ; // false 对于内部使用的单位, 是否仍然需要贴图
            // 轮廓
            alwaysCreateOutline = ; // false 是否始终生成轮廓区域
            outlineColor = Color.valueOf(""); // 565666 贴图轮廓颜色
            outlineRadius = ; // 3 贴图轮廓厚度
            outlines = ; // true 有无贴图轮廓
            //引擎
            setEnginesMirror(); // 引擎
            engineOffset = f; // 5f 引擎向后的偏移量
            engineSize = f; // 2.5f 引擎半径
            engineLayer = f; // -1f 引擎所处的图层
            useEngineElevation = ; // true 引擎是否始终以正常尺寸显示
            engineColor = Color.valueOf(""); // null 引擎颜色
            engineColorInner = Color.valueOf(""); // white 引擎内部颜色
            // 轨迹
            waveTrailX = f; // 4f 波纹轨迹水平偏移量
            waveTrailY = f; // -3f 波纹轨迹垂直偏移量
            trailScl = f; // 1f 轨迹缩放比例
            trailLength = ; // 0 引擎尾迹或波浪尾迹长度
            trailColor = Color.valueOf(""); // 尾迹颜色
            // 光照
            lightRadius = f; // -1f 光照半径
            lightOpacity = f; // 0.6f 光照不透明度
            lightColor = Color.valueOf(""); // fbd367 单位产生的光照的颜色
            // 治疗
            healFlash = ; // true 被治疗时是否闪光
            healColor = Color.valueOf(""); // 98ffa9 收到治疗时闪光的颜色

            // 音效
            deathSound = Sounds.; // unset 死亡音效
            deathSoundVolume = f; // 1f 死亡音效音量
            wreckSound = Sounds.; // unset 坠毁音效
            wreckSoundVolume = f; // 1f 坠毁音效音量
            loopSound = Sounds.; // none 单位在附近时循环播放的音效
            loopSoundVolume = f; // 0.5f 循环音效的音量
            stepSound = Sounds.; // mechStepSmall 步进音效
            stepSoundVolume = f; // 0.5f 步进音量
            stepSoundPitch = f; // 1f 步进音效的音高
            stepSoundPitchRange = f; // 0.1f 步进音效的音高范围
            moveSound = Sounds.; // none 移动音效
            moveSoundVolume = f; // 1f 移动音效的音量
            moveSoundPitchMin = f; // 1f 基于速度的移动音效的音高范围
            moveSoundPitchMax = f; // 1f
            mineSound = Sounds.; // loopMineBeam 挖掘音效
            mineSoundVolume = f; // 0.6f 挖掘音效音量

            // 粒子效果
            fallEffect = Fx.; // fallSmoke 坠毁时产生的粒子效果
            fallEngineEffect = Fx.; // fallSmoke 坠毁时引擎处产生的粒子效果
            deathExplosionEffect = Fx.; // dynamicExplosion 死亡时产生的粒子效果

            //LEG UNITS
            allowLegStep = ; // false 对于有腿的单位, 能否跨过方块
            legPhysicsLayer = ; // true 腿部是否强行处于地面物理层
            legCount = ; // 4 拥有腿的数量
            legGroupSize = ; // 2 腿的组数

            legLength = f; // 10f 单条腿的总长度
            legSpeed = f; // 0.1f 单条腿的移动速度
            legForwardScl = f; // 1f 腿部向前放置的距离与单位速度的比例
            legBaseOffset = f; // 0f 腿部相对于中心的偏移量
            legMoveSpace = f; // 1f 腿部移动间距比例
            legExtension = f; // 0f 腿部关节覆盖偏移
            legPairOffset = f; // 0f 腿部组间同步移动的偏移量
            legLengthScl = f; // 1f 腿部试图与单位保持的距离
            legStraightLength = f; // 1f 腿部水平伸展距离比例
            legMaxLength = f; // 1.75f 腿部最大伸展长度比例
            legMinLength = f; // 0f 腿部最小伸展长度比例
            legSplashDamage = f; // 0f 腿部触地时产生的溅射伤害
            legSplashRange = f; // 5f 腿部触地伤害的范围
            baseLegStraightness = f; // 0f 腿部基座排列直线度
            legStraightness = f; // 0f 腿部外展角度直线度

            legBaseUnder = ; // false 腿部区域是否绘制在下方
            lockLegBase = ; // false 腿部是否被锁定在单位基座上
            legContinuousMove = ; // 当单位停止移动时, 腿部是否始终尝试移动
            emitWalkSound = ; // true 踩中液体的音效
            emitWalkEffect = ; // true 踩中液体的粒子效果

            //MECH UNITS
            mechLandShake = f; // 0f 机甲落地时的震动强度
            mechSideSway = f; // 0.54f 机甲侧向摆动的幅度
            mechFrontSway = f; // 0.1f 机甲前后摆动的幅度
            mechStride = f; // -1f 机甲步幅长度
            mechStepParticles = ; // false 机甲在迈出一步后是否产生粒子效果
            mechLegColor = Color.valueOf(""); // 6e7080 机甲腿部移动时的颜色

            //TANK UNITS
            treadRects = new Rect[]{}; // 履带矩形区域列表, 相对于中心
            treadFrames = ; // 18 履带动画帧数
            treadPullOffset = ; // 0 履带顶部裁剪偏移
            tankMoveSound = Sounds.; // tankMove 坦克移动音效
            tankMoveVolume = f; // 0.5f 坦克移动音效的音量
            treadEffect = Fx.; // 坦克移动时产生的粒子效果

            //SEGMENTED / CRAWL UNITS (this is WIP content!)
            segments = ; // 0 身体节段数量
            segmentUnits = ; // 1 是否每节都是独立单位
            segmentUnit = UnitType.; // 身体节段使用的单位类型
            segmentEndUnit = UnitType.; // 尾部节段使用的单位类型
            segmentLayerOrder = ; // true 节段绘制顺序. 为false时, 后面的节段覆盖前面的节段
            segmentMag = f; // 2f 摆动幅度
            segmentScl = f; // 4f 摆动周期缩放
            segmentPhase = f; // 5f 节段间相位差
            segmentRotSpeed = f; // 1f 节段转向速度
            segmentMaxRot = f; // 30f 最大角度差
            segmentSpacing = f; // -1f 节段间距
            segmentRotationRange = f; // 80f 转向范围限制
            crawlSlowdown = f; // 0.5f 爬行减速倍率
            crushDamage = f; // 0f 碾压伤害
            crawlSlowdownFrac = f; // 0.55f 减速阈值

            //MISSILE UNITS
            lifetime = f; // 5f * 60f 导弹的生命周期
            homingDelay = f; // 10f 导弹开始追踪前需要经过的帧数
            missileAccelTime = f; // 0f 导弹加速到全速所须时间

            // 行为
            allowChangeCommands = ; // true 是否在单位工厂中隐藏命令更改界面
            mineItems = Seq.with(Items., Items.); // 目标矿石, 用于采矿AI

            commands.add(); // 可用命令列表
            defaultCommand = UnitCommand.; // 默认命令
            stances = ; // 单位可拥有的行为
            flowfieldPathType = ; // -1 寻路相关
            pathCost = ; //

            // 环境需求
            envRequired = ; // 0 必要的环境
            envEnabled = ; // 可以存在的环境
            envDisabled = ; // 无法存在的环境

            immunities.add(StatusEffects.); // 免疫的状态效果
            targetFlags = new BlockFlag[] {BlockFlag., BlockFlag.}; // 目标
            ammoCapacity = ; // -1 弹药容量
            ammoType = new ItemAmmoType(Items.); // copper 使用的弹药

            parts.add(); // 额外的动画部件
            abilities.add(); // 能力
            weapons.add(new Weapon(VanillaExpansion.VeName("")) {{
                display = ; // true 是否显示在单位属性中
                showStatSprite = ; // true 是否在数据库中显示武器贴图
                mirror = ; // true 有无镜像
                noAttack = ; // false 该武器能否用于攻击
                alternate = ; // true 不同副本是否依次射击
                shootOnDeath = ; // false 是否死亡时射击
                useAttackRange = ; // true 是否用于攻击范围计算
                minShootVelocity = f; // -1f 该武器射击所需的最小速度
                useAmmo = ; // true 当对应规则启用时, 是否消耗弹药
                targetInterval = f; // 40f 更换目标间的等待时间
                targetSwitchInterval = f; // 70f 目标切换间隔

                // 旋转
                rotate = ; // false 是否独立于单位旋转
                ignoreRotation = ; // false 射击时是否忽略单位旋转
                baseRotation = f; // 0f 起始旋转角度
                rotateSpeed = f; // 20f 武器旋转速度
                rotationLimit = f; // 361f 武器旋转限制

                // 视觉效果
                region = ""; // 显示纹理区域
                heatRegion = ""; // 发热纹理区域
                cellRegion = ""; // 能量单元纹理区域
                outlineRegion = ""; // 轮廓纹理区域
                top = ; // true 是否在顶部绘制轮廓
                layerOffset = f; // 0f 图层偏移量
                shootX = f; // 0f 弹道/特效相对于武器中心的偏移量
                shootY = f; // 3f
                x = f; // 5f 武器对于单位的偏移量
                y = f; // 0f
                xRand = f; // 0f X/Y轴上的随机散布
                yRand = f; // 0f
                shadow = f; // -1f 武器阴影半径
                shake = f; // 0f 射击后屏幕震动强度
                shoot. = ; // 用于子弹的图案
                ejectEffect = Fx.; // none 弹壳抛出效果
                parentizeEffects = ; // 射击效果是否跟随单位
                recoil = f; // 1.5f 视觉上的后坐力
                recoils = f; // -1f 额外的后坐力计数器数量
                recoilTime = f; // = reload 后坐力复位时间
                recoilPow = f; // 1.8f 后坐力功率曲线
                cooldownTime = f; // 20f 冷却热区所用时间
                minWarmup = f; // 0f 最小开火预热值
                shootWarmupSpeed = f; // 0.1f 射击预热速度
                smoothReloadSpeed = f; // 0.15f 平滑装填速度
                linearWarmup = ; // false 是否使用线性预热
                heatColor = Color.valueOf(""); // ab3400 发热区域颜色
                mountType = WeaponMount::new; // 武器挂架类型

                // 音效
                soundPitchMin = f; // 0.8f 射击音效随机音高范围
                soundPitchMax = f; // 1f
                activeSound = Sounds.; // none 射击循环音效
                activeSoundVolume = f; // 1f 射击循环音效的音量
                shootSound = Sounds.; // shoot 射击音效
                shootSoundVolume = f; // 1f 射击音效音量
                initialShootSound = Sounds.; // none 首次开火音效
                chargeSound = Sounds.; // none 充能音效

                // 子弹
                continuous = ; // 是否保持子弹在射击位置
                alwaysContinuous = ; // 是否无装填连续射击
                aimChangeSpeed = f; // Float.1/0f 改变炮塔瞄准距离的速度, 仅用于点激光子弹
                controllable = ; // true 是否可由玩家手动瞄准
                aiControllable = ; // true 是否可由单位自动瞄准
                alwaysShooting = ; // false 是否始终射击
                autoTarget = ; // false 是否自动瞄准目标
                predictTarget = ; // true 是否预测目标轨迹
                reload = f; // 77f 重新装填的帧数
                inaccuracy = f; // 0f 射击时的不精准度
                velocityRnd = f; // 0f 速度随机分量比例
                extraVelocity = f; // 0f 额外速度比例
                shootCone = f; // 5f 射击起始锥角半径
                shootStatus = StatusEffects.; // none 射击施加的状态效果
                shootStatusDuration = f; // 5f * 60f 射击状态效果持续时间

                parts.add(); // 额外动画部件
                bullet = new ();
            }});
        }};
        */

// Missile
        /*
        Missile = new MissileUnitType("") {{
            constructor = TimedKillUnit::create;
            range = 6f; // -1f 最小攻击范围
            createScorch = false; // true 死亡时是否会产生烧痕
            createWreck = false; // true 死亡时是否掉落残骸
            fogRadius = 2f; // -1f 战争迷雾视野半径
            isEnemy = false; // true 是否被视为敌人
            flying = true; // false 是否为飞行单位
            allowedInPayloads = false; // true 能否被移动到载荷中
            logicControllable = false; // true 逻辑能否控制此单位
            playerControllable = false; // true 玩家能否控制该单位
            physics = false; // true 该单位能否与其他单位发生物理碰撞
            useUnitCap = false; // true 如果为false, 忽略单位上限, 无限生成
            hoverable = false; // true 是否显示悬停提示
            hidden = true; // false 是否隐藏
            bounded = false; // true 能否被推离地图边界
            speed = 4f; // 1.1f 移动速度
            rotateSpeed = 2.5f; // 5f 身体转向速度
            targetPriority = -1f; // 0f 目标优先级
            drawCell = false; // true 是否绘制队伍指示器/单元格
            drawMinimap = false; // true 是否在小地图上绘制
            outlineColor = Pal.darkOutline; // 565666 贴图轮廓颜色
            trailLength = 7; // 0 引擎尾迹或波浪尾迹长度
            loopSound = Sounds.loopMissileTrail; // none 单位在附近时循环播放的音效
            loopSoundVolume = 0.05f; // 0.5f 循环音效的音量
            lifetime = 60f * 1.7f; // 5f * 60f 导弹的生命周期
            envEnabled = Env.any; // 可以存在的环境
            envDisabled = Env.none; // 无法存在的环境
            controller = u -> new MissileAI();
        }};
        */

// DrawPart
        /*
        DrawPart = new DrawPart() {{
            // = new EffectSpawnerPart() {{
            x = f; // 矩形中心坐标偏移
            y = f;
            width = f; // 矩形宽高
            height = f;
            rotation = f; // 矩形旋转角度
            mirror = ; // false 是否在两侧镜像生成
            effectChance = f; // 0.1f 特效触发概率
            effectRot = f; // 特效的固定旋转角度
            effectRandRot = f; // 特效的随机旋转范围
            effect = Fx.; // sparkShoot 特效类型
            effectColor = Color.valueOf(""); // white 特效颜色
            useProgress = ; // true 是否使用进度控制生成时机
            progress = PartProgress.; // warmup 进度类型
            debugDraw = ; // false 是否显示生成区域, 仅调试

            // = new FlarePart() {{
            sides = ; // 4 光晕的射线数量
            radius = f; // 100f 外半径
            radiusTo = f; // -1f 目标外半径(-1=与 radius 相同, 用于动画过渡)
            stroke = f; // 6f 射线粗细
            innerScl = f; // 0.5f 内半径缩放比例
            innerRadScl = f; // 0.33f 内圈半径缩放比例
            x = f; // 基础位置偏移
            y = f;
            rotation = f; // 基础旋转角度
            rotMove = f; // 动态旋转偏移
            spinSpeed = f; // 持续自转速度
            followRotation = ; // 是否跟随父级旋转
            color1 = Color.valueOf(""); // Pal.techBlue 主颜色
            color2 = Color.valueOf(""); // white 次颜色
            clampProgress = true; // 是否钳制进度值到 [0,1]
            progress = PartProgress.; // warmup 进度类型
            layer = Layer.; // effect 渲染图层

            // = new HaloPart() {{
            hollow = ; // false 中心形状是否为空心
            tri = ; // false 是否为三角形模式
            shapes = ; // 3 中心形状数量
            sides = ; // 3 多边形边数
            radius = f; // 3f 中心形状半径
            radiusTo = f; // -1f 目标半径
            stroke = f; // 1f 线条粗细
            strokeTo = f; // -1f 目标线条粗细
            triLength = f; // 1f 三角形边长
            triLengthTo = f; // -1f 目标三角形边长
            haloRadius = f; // 10f 光晕环半径
            haloRadiusTo = f; // -1f 目标光晕环半径
            haloRotateSpeed = f; // 0f 光晕环自转速度
            haloRotation = f; // 0f 光晕环基础旋转角度
            x = f; // 基础位置偏移
            y = f;
            shapeRotation = f; // 中心形状基础旋转
            moveX = f; // 动态位置偏移
            moveY = f; //
            shapeMoveRot = f; // 中心形状动态旋转偏移
            rotateSpeed = f; // 0f 中心形状自转速度
            color = Color.valueOf(""); // white 颜色
            colorTo = Color.valueOf(""); // 目标颜色
            mirror = ; // false 是否镜像
            clampProgress = ; // true 是否钳制进度值
            progress = PartProgress.; // warmup 进度类型
            layer = f; // -1f 渲染图层
            layerOffset = f; // 0f 图层偏移

            // = new HoverPart() {{
            radius = f; // 4f 光环半径
            x = f; // 位置偏移
            y = f;
            rotation = f; // 旋转角度
            phase = f; // 50f 波动相位差
            stroke = f; // 3f 线条最大粗细
            minStroke = f; // 0.12f 线条最小粗细
            circles = ; // 2 同心圆/光环的数量
            sides = ; // 4 多边形的边数
            color = Color.valueOf(""); // white 光环颜色
            mirror = ; // false 是否镜像
            layer = f; // -1f 渲染图层
            layerOffset = f; // 0f 图层偏移

            // = new RegionPart(region, blending, color) {{
            suffix = ""; // 纹理名称后缀
            name = ""; // 完整纹理名
            heat = ; // 热效纹理
            light = ; // 发光纹理
            regions = {}; // 多帧纹理数组
            outlines = {}; // 轮廓纹理数组
            mirror = ; // false 是否镜像
            outline = ; // true 是否绘制轮廓
            replaceOutline = ; // false 是否使用原地轮廓(仅原版内部使用)
            drawRegion = ; // true 是否绘制基础纹理
            heatLight = ; // false 热效纹理是否产生光照
            heatLightOpacity = f; // 0.3f 热效纹理光照不透明度
            clampProgress = ; // true 是否钳制进度到 [0,1]
            progress = PartProgress.; // warmup 位置/旋转进度
            growProgress = PartProgress.; // warmup 缩放进度
            heatProgress = PartProgress.; // heat 热效透明度进度
            blending = Blending.; // normal 混合模式
            layer = f; // -1 渲染图层
            layerOffset = f; // 0f 图层偏移
            heatLayerOffset = f; // 1f 热效图层偏移
            turretHeatLayer = Layer.; // turretHeat 炮塔热效图层
            outlineLayerOffset = f; // -0.001f 轮廓图层偏移
            x = f; // 基础位置
            y = f;
            xScl = f; // 1f 缩放比例
            yScl = f; // 1f
            rotation = f; // 基础旋转
            originX = f; // 旋转/缩放原点
            originY = f;
            moveX = f; // 动态位置偏移
            moveY = f;
            growX = f; // 动态缩放
            growY = f;
            moveRot = f; // 动态旋转偏移
            color = Color.valueOf(""); // 主颜色
            colorTo = Color.valueOf(""); // 目标颜色
            mixColor = Color.valueOf(""); // 混合颜色
            mixColorTo = Color.valueOf(""); // 混合颜色目标色
            heatColor = Color.valueOf(""); // Pal.turretHeat.cpy() 热效颜色
            children = new Seq<>(); // 子部件列表
            moves = new Seq<>(); // 运动路径列表

            // = new ShapePart() {{
            circle = ; // false 是否为圆形
            hollow = ; // false 是否空心
            sides = ; // 3 多边形边数
            radius = f; // 3f 半径
            radiusTo = f; // -1f 目标半径
            stroke = f; // 1f 描边粗细
            strokeTo = f; // -1f 目标描边粗细
            x = f; // 基础位置偏移
            y = f;
            rotation = f; // 基础旋转角度
            moveX = f; // 动态位置偏移
            moveY = f;
            moveRot = f; // 动态旋转偏移
            rotateSpeed = f; // 0f 持续自转速度
            color = Color.valueOf(""); // white 颜色
            colorTo = Color.valueOf(""); // 目标颜色
            mirror = ; // false 是否镜像
            clampProgress = ; // true 是否将进度钳制到 [0,1]
            progress = PartProgress.; // warmup 进度类型
            layer = f; // -1f 渲染图层
            layerOffset = f; // 0f 图层偏移

            // = new DrawPart() {{
            under = ; // false 是否渲染在武器/炮塔下层
        }};
        */

// Abilities
        /*
        abilities = new Ability(unit, spawnTime, spawnX, spawnY) {{
            // = new ArmorPlateAbility() {{ // 护甲板
            color = Color.valueOf(""); // null 光泽颜色
            shineSpeed = f; // 1f
            z = f; // -1 图层
            drawPlate = ; // true 是否绘制护甲板
            drawShine = ; // true 是否绘制光泽层
            healthMultiplier = f; // 0.2f 生命值倍率
            warmup = ; // 受击动画

            // = new EnergyFieldAbility(damage, reload, range) {{ // 能量场
            damage = f; // 1f 对敌方造成的伤害
            reload = f; // 100f 攻击间隔
            range = f; // 60f 作用半径
            healEffect = Fx.; // heal 治疗友军时播放的特效
            hitEffect = Fx.; // hitLaserBlast 命中目标时播放的特效
            damageEffect = Fx.; // chainLightning 造成伤害时在中心点播放的特效
            status = StatusEffects.; // electrified 对敌方附加的状态效果
            shootSound = Sounds.; // shootEnergyField 触发能量场时播放的音效
            statusDuration = f * 60f; // 60f * 6f 状态效果的持续时间
            x = f; // 能量场中心相对于单位位置的 X 偏移
            y = f; // 能量场中心相对于单位位置的 Y 偏移
            targetGround = ; // true 是否可攻击地面单位
            targetAir = ; // true 是否可攻击空中单位
            hitBuildings = ; // true 是否影响建筑
            hitUnits = ; // true 是否影响单位
            maxTargets = ; // 25 单次触发最多影响的目标数量
            healPercent = f; // 3f 百分比治疗
            sameTypeHealMult = f; // 1f 同类修复量
            displayHeal = ; // true 是否在统计面板显示治疗描述
            layer = Layer.; // bullet - 0.001f 图层
            blinkScl = f; // 20f 中心球体脉动闪烁的周期缩放
            blinkSize = f; // 0.1f 中心球体脉动闪烁的幅度
            effectRadius = f; // 5f 中心能量球的半径
            sectorRad = f; // 0.14f 弧形光环的弧度
            rotateSpeed = f; // 0.5f 光环旋转的速度
            sectors = ; // 5 光环的分段数量
            color = Color.valueOf(""); // Pal.heal 能量场的主颜色
            useAmmo = ; // true 触发时是否消耗单位的弹药

            // = new ForceFieldAbility(radius, regen, max, cooldown, sides, rotation) {{ // 力墙场
            radius = f; // 60f 力墙半径
            regen = f; // 0.1f 力墙每 tick 恢复量
            max = f; // 200f 力墙最大容量
            cooldown = f * 60f; // 60f * 5 力墙破碎后的冷却时间
            sides = ; // 6 力墙多边形的边数
            rotation = f; // 0f 力墙多边形的旋转角度
            breakSound = Sounds.; // shieldBreakSmall 力墙破碎时播放的音效
            hitSound = Sounds.; // shieldHit 力墙被子弹击中时播放的音效
            hitSoundVolume = f; // 0.12f 击中音效的音量

            // = new LiquidExplodeAbility() {{ // 死亡溢液
            liquid = Liquids.; // water 单位死亡时释放的液体类型
            amount = f; // 120f 释放的液体总量
            radAmountScale = f; // 5f 半径内液体量缩放系数
            radScale = f; // 1f 爆炸半径相对于单位碰撞大小的缩放系数
            noiseMag = f; // 6.5f 噪声幅度，控制液体分布的不规则程度
            noiseScl = f; // 5f 噪声缩放，控制液体分布噪声的颗粒度/频率

            // = new LiquidRegenAbility() {{ // 液体回血
            liquid = Liquids.; // 吸收的液体类型
            slurpSpeed = f; // 5f 每帧吸收液体的速率
            regenPerSlurp = f; // 6f 每吸收 1 单位液体所恢复的生命值
            slurpEffectChance = f; // 0.4f 吸收时触发特效的概率
            slurpEffect = Fx.; // heal 吸收液体时播放的特效

            // = new MoveEffectAbility(x, y, color, effect, interval) {{ // 移动特效
            minVelocity = f; // 0.08f 触发特效所需的最小移动速度
            interval = f; // 3f 特效触发间隔
            chance = f; // 0f 每帧触发特效的概率
            amount = ; // 1 每次触发生成的特效数量
            x = f; // 特效相对于单位的 X 偏移
            y = f; // 特效相对于单位的 Y 偏移
            rotation = f; // 特效的额外旋转角度
            rangeX = f; // X 方向的随机偏移范围
            rangeY = f; // Y 方向的随机偏移范围
            rangeLengthMin = f; // 径向随机模式的最小半径
            rangeLengthMax = f; // 径向随机模式的最大半径
            rotateEffect = ; // false 特效是否跟随单位旋转角度
            effectParam = f; // 3f 特效参数
            teamColor = ; // false 是否使用队伍颜色
            parentizeEffects = ; // 特效是否绑定到单位上
            color = Color.valueOf(""); // white 特效颜色
            effect = Fx.; // missileTrail 播放的特效类型

            // = new MoveLightningAbility(damage, length, chance, y, minSpeed, maxSpeed, color, heatRegion) {{ 移动时发射闪电/子弹
            damage = f; // 35f 闪电造成的伤害值
            chance = f; // 0.15f 每帧触发闪电的概率
            length = ; // 12 闪电长度
            minSpeed = f; // 0.8f 开始触发闪电所需的最小速度
            maxSpeed = f; // 1.2f 达到满触发概率的速度
            color = Color.valueOf(""); // a9d8ff 闪电颜色
            y = f; // 0f 闪电生成点沿 X 轴的偏移
            x = f; // 0f 闪电生成点沿 Y 轴的偏移
            alternate = ; // true 是否交替切换生成侧
            heatRegion = ""; // error 热效贴图名称
            bullet = ; // 同时发射的子弹类型
            bulletAngle = f; // 0f 子弹相对于单位朝向的额外角度
            bulletSpread = f; // 0f 子弹角度的随机散布范围
            shootEffect = Fx.; // sparkShoot 发射闪电时的特效
            parentizeEffects = ; // 特效是否绑定到单位上
            shootSound = Sounds.; // shootArc 发射闪电时的音效

            // = new RegenAbility() {{ // 持续再生
            percentAmount = f; // 0f 恢复最大生命值的百分比
            amount = f; // 0f 恢复的固定生命值

            // = new RepairFieldAbility(amount, reload, range, healPercent) {{ // 修复场
            amount = f; // 1 固定修复量
            reload = f; // 100 修复间隔
            range = f; // 60 修复场的作用半径
            healPercent = f; // 0f 百分比修复量
            healEffect = Fx.; // heal 被治疗单位的特效
            activeEffect = Fx.; // healWaveDynamic 修复场触发的特效
            sound = Sounds.; // healWave 修复场触发时的音效
            soundVolume = f; // 0.5f 音效音量
            parentizeEffects = ; // false 特效是否随单位移动
            sameTypeHealMult = f; // 1f 同类修复量

            // = new ShieldArcAbility() {{ // 弧形护盾
            radius = f; // 60f 护盾圆弧的半径
            regen = f; // 0.1f 护盾每 tick 恢复量
            max = f; // 200f 护盾最大容量
            cooldown = f; // 60f * 5 护盾破碎后的冷却时间
            angle = f; // 80f 护盾圆弧的角度范围
            angleOffset = f; // 0f 护盾圆弧的角度偏移
            x = f; // 0f 护盾中心相对于单位的 X 偏移
            y = f; // 0f 护盾中心相对于单位的 Y 偏移
            whenShooting = ; // true 是否仅在单位射击时激活护盾
            width = f; // 6f 护盾弧线的宽度
            chanceDeflect = f; // -1f 子弹偏转概率
            reflectBuildingDamage = f; // 1f 偏转子弹对建筑的伤害倍率
            reflectVel = f; // 1f 偏转子弹在反向轴上的速度倍率
            reflectTime = f; // 1f - 0.5f 偏转子弹的寿命倍率
            deflectSound = Sounds.; // none 子弹被偏转时的音效
            breakSound = Sounds.; // shieldBreakSmall 护盾破碎时的音效
            hitSound = Sounds.; // shieldHit 护盾被击中时的音效
            hitSoundVolume = f; // 0.12f 击中音效的音量
            missileUnitMultiplier = f; // 2f 导弹类单位对护盾造成伤害的倍率
            drawArc = ; // true 是否绘制护盾弧线
            region = ; // 覆盖绘制的贴图名称
            color = Color.valueOf(""); // 护盾颜色
            offsetRegion = ; // false 贴图位置是否受 x/y 偏移影响
            pushUnits = ; // true 是否将敌方单位推离护盾
            pushEffect = Fx.; // circleColorSpark 推离单位时播放的特效

            // = new ShieldRegenFieldAbility(amount, max, reload, range) {{ // 护盾再生场
            amount = f; // 1 每次触发的护盾恢复量
            max = f; // 100f 护盾的最大容量上限
            reload = f; // 100 恢复间隔
            range = f; // 60 再生场的作用半径
            applyEffect = Fx.; // shieldApply 被恢复单位播放的特效
            activeEffect = Fx.; // shieldWave 再生场激活时在施法者位置播放的特效
            sound = Sounds.; // shieldWave 再生场触发时的音效
            soundVolume = f; // 0.7f 音效音量
            parentizeEffects = ; // 特效是否随单位移动

            // = new SpawnDeathAbility(unit, amount, spread) {{ // 死亡生成单位
            unit = UnitType.; // 单位死亡时生成的单位类型
            amount = ; // 1 固定生成的数量
            randAmount = ; // 0 额外随机生成的数量
            spread = f; // 8f 生成单位围绕死亡位置的随机散布半径
            faceOutwards = ; // true 生成的单位是否面向远离死亡中心的方向, 如果为false, 继承死亡单位朝向 ± 随机 5°

            // = new StatusFieldAbility(effect, duration, reload, range) {{ // 状态场
            effect = StatusEffect.; // 施加给范围内单位的状态效果类型
            duration = f * 60f; // 60 状态效果的持续时间
            reload = f; // 100 状态施加的间隔
            range = f; // 20 作用半径
            onShoot = ; // false 是否仅在单位射击时触发
            applyEffect = Fx.; // none 对每个受影响的单位播放的特效
            activeEffect = Fx.; // overdriveWave 能力激活时在施法者位置播放的特效
            effectX = f; // 激活特效相对于单位的 X 偏移
            effectY = f; // 激活特效相对于单位的 Y 偏移
            parentizeEffects = ; // 特效是否随单位移动
            effectSizeParam = ; // true 激活特效是否使用范围作为大小参数
            color = Color.valueOf(""); // Pal.accent 特效颜色

            // = new SuppressionFieldAbility() {{ // 修复压制场
            reload = f; // 60f * 1.5f 压制效果的持续时间
            maxDelay = f; // 60f * 1.5f 两次压制效果之间的间隔
            range = f; // 200f 压制场的作用半径
            orbRadius = f; // 4.1f 中心球体的基础半径
            orbMidScl = f; // 0.33f 中心球体内核的半径比例
            orbSinScl = f; // 8f 球体脉动的正弦波周期缩放
            orbSinMag = f; // 1f 球体脉动的正弦波幅度
            color = Color.valueOf(""); // Pal.suppress 中心球体的颜色
            layer = Layer.; // effect 绘制层级
            x = f; // 0f 压制场中心相对于单位的 X 偏移
            y = f; // 0f 压制场中心相对于单位的 Y 偏移
            particles = ; // 15 粒子数量
            particleSize = f; // 4f 粒子大小
            particleLen = f; // 7f 粒子从中心向外扩散的最大距离
            rotateScl = f; // 3f 粒子旋转速度缩放
            particleLife = f; // 110f 粒子的生命周期
            active = ; // true 是否激活此能力
            particleInterp = f -> Interp.circleOut.apply(Interp.slope.apply(f)); // 粒子距离的插值函数
            particleColor = Color.valueOf(""); // Pal.sap.cpy() 粒子的颜色
            effectColor = Color.valueOf(""); // Pal.sapBullet 压制效果的颜色
            applyParticleChance = f; // 13f 压制效果触发时生成粒子的概率

            // = new UnitSpawnAbility(unit, spawnTime, spawnX, spawnY) {{ // 生成单位
            unit = UnitType.; // 生成的单位类型
            spawnTime = f; // 60f 生成一个单位所需的时间
            spawnX = f; // 生成点相对于单位的 X 偏移
            spawnY = f; // 生成点相对于单位的 Y 偏移
            spawnEffect = Fx.; // spawn 单位生成时播放的特效
            parentizeEffects = ; // 特效是否随单位移动

            // = new Ability() {{
            display = true; // 是否在单位能力中显示
        }};
        */

// Weapons
        /*
        BuildWeapon = new BuildWeapon(name) {{
            // = new BuildWeapon(name) {{ // 纯视觉武器
            // Weapon
            display = false; // true 是否显示在单位属性中
            noAttack = true; // false 该武器能否用于攻击
            useAttackRange = false; // true 是否用于攻击范围计算
            rotate = true; // false 是否独立于单位旋转
            predictTarget = false; // true 是否预测目标轨迹
            bullet = new BulletType();

            // = new MineWeapon(name) {{ // 纯视觉采矿武器
            // Weapon
            display = false; // true 是否显示在单位属性中
            noAttack = true; // false 该武器能否用于攻击
            useAttackRange = false; // true 是否用于攻击范围计算
            rotate = true; // false 是否独立于单位旋转
            predictTarget = false; // true 是否预测目标轨迹
            bullet = new BulletType();

            // = new PointDefenseBulletWeapon(name) {{ // 点防子弹武器
            damageTargetWeight = f; // 10f 目标选择时子弹伤害的权重系数
            bullet = new InterceptorBulletType();
            // Weapon
            useAttackRange = false; // true 是否用于攻击范围计算
            useAmmo = false; // true 当对应规则启用时, 是否消耗弹药
            targetInterval = 5f; // 40f 更换目标间的等待时间
            targetSwitchInterval = 5f; // 70f 目标切换间隔
            rotate = true; // false 是否独立于单位旋转
            controllable = false; // true 是否可由玩家手动瞄准
            autoTarget = true; // false 是否自动瞄准目标

            // = new PointDefenseWeapon(name) {{ // 点防武器
            color = Color.valueOf(""); // white 光束特效的颜色
            beamEffect = Fx.; // pointBeam 发射光束时播放的特效
            // Weapon
            useAttackRange = false; // true 是否用于攻击范围计算 4654
            useAmmo = false; // true 当对应规则启用时, 是否消耗弹药 4656
            targetInterval = 10f; // 40f 更换目标间的等待时间 4657
            rotate = true; // false 是否独立于单位旋转 4661
            controllable = false; // true 是否可由玩家手动瞄准 4710
            autoTarget = true; // false 是否自动瞄准目标 4713
            predictTarget = false; // true 是否预测目标轨迹 4714

            // = new RepairBeamWeapon(name) {{ // 修复光束武器
            targetBuildings = ; // false 是否可治疗建筑
            targetUnits = ; // true 是否可治疗建筑
            repairSpeed = f; // 0.3f 固定治疗速度
            fractionRepairSpeed = f; // 0f 百分比治疗速度
            beamWidth = f; // 1f 光束基础宽度
            pulseRadius = f; // 6f 光束末端脉冲效果半径
            pulseStroke = f; // 2f 光束末端脉冲效果线条粗细
            widthSinMag = f; // 0f 光束宽度正弦波动幅度
            widthSinScl = f; // 4f 光束宽度正弦波动周期缩放
            recentDamageMultiplier = f; // 0.1f 建筑刚受伤害时的治疗倍率
            laser = ; // 激光光束主体纹理
            laserEnd = ; // 激光末端纹理
            laserTop = ; // 激光上层覆盖纹理
            laserTopEnd = ; // 激光上层末端纹理
            laserColor = Color.valueOf(""); // 98ffa9 激光光束颜色
            laserTopColor = Color.valueOf(""); // white.cpy(); 激光上层覆盖颜色
            healColor = Color.valueOf(""); // Pal.heal; 治疗特效颜色
            healEffect = Fx.; // healBlockFull 治疗建筑时播放的特效
            // Weapon
            noAttack = true; // false 该武器能否用于攻击 4680
            useAttackRange = false; // true 是否用于攻击范围计算 4683
            useAmmo = false; // true 当对应规则启用时, 是否消耗弹药 4685
            rotate = true; // false 是否独立于单位旋转 4690
            recoil = 0f; // 1.5f 视觉上的后坐力 4714
            mountType = HealBeamMount::new; // 武器挂架类型 4723
            activeSound = Sounds.beamHeal; // none 射击循环音效 4728
            controllable = false; // true 是否可由玩家手动瞄准 4739
            autoTarget = true; // false 是否自动瞄准目标 4742
            predictTarget = false; // true 是否预测目标轨迹 4743
            reload = 1f; // 77f 重新装填的帧数 必须>0 4744
        }};
        */

        /*
        weapons = new Weapon() {{
            display = ; // true 是否显示在单位属性中
            showStatSprite = ; // true 是否在数据库中显示武器贴图
            mirror = ; // true 有无镜像
            noAttack = ; // false 该武器能否用于攻击
            alternate = ; // true 不同副本是否依次射击
            shootOnDeath = ; // false 是否死亡时射击
            useAttackRange = ; // true 是否用于攻击范围计算
            minShootVelocity = f; // -1f 该武器射击所需的最小速度
            useAmmo = ; // true 当对应规则启用时, 是否消耗弹药
            targetInterval = f; // 40f 更换目标间的等待时间
            targetSwitchInterval = f; // 70f 目标切换间隔

            // 旋转
            rotate = ; // false 是否独立于单位旋转
            ignoreRotation = ; // false 射击时是否忽略单位旋转
            baseRotation = f; // 0f 起始旋转角度
            rotateSpeed = f; // 20f 武器旋转速度
            rotationLimit = f; // 361f 武器旋转限制

            // 视觉效果
            region = ""; // 显示纹理区域
            heatRegion = ""; // 发热纹理区域
            cellRegion = ""; // 能量单元纹理区域
            outlineRegion = ""; // 轮廓纹理区域
            top = ; // true 是否在顶部绘制轮廓
            layerOffset = f; // 0f 图层偏移量
            shootX = f; // 0f 弹道/特效相对于武器中心的偏移量
            shootY = f; // 3f
            x = f; // 5f 武器对于单位的偏移量
            y = f; // 0f
            xRand = f; // 0f X/Y轴上的随机散布
            yRand = f; // 0f
            shadow = f; // -1f 武器阴影半径
            shake = f; // 0f 射击后屏幕震动强度
            shoot. = ; // 用于子弹的图案
            ejectEffect = Fx.; // none 弹壳抛出效果
            parentizeEffects = ; // 射击效果是否跟随单位
            recoil = f; // 1.5f 视觉上的后坐力
            recoils = f; // -1f 额外的后坐力计数器数量
            recoilTime = f; // = reload 后坐力复位时间
            recoilPow = f; // 1.8f 后坐力功率曲线
            cooldownTime = f; // 20f 冷却热区所用时间
            minWarmup = f; // 0f 最小开火预热值
            shootWarmupSpeed = f; // 0.1f 射击预热速度
            smoothReloadSpeed = f; // 0.15f 平滑装填速度
            linearWarmup = ; // false 是否使用线性预热
            heatColor = Color.valueOf(""); // ab3400 发热区域颜色
            mountType = WeaponMount::new; // 武器挂架类型

            // 音效
            soundPitchMin = f; // 0.8f 射击音效随机音高范围
            soundPitchMax = f; // 1f
            activeSound = Sounds.; // none 射击循环音效
            activeSoundVolume = f; // 1f 射击循环音效的音量
            shootSound = Sounds.; // shoot 射击音效
            shootSoundVolume = f; // 1f 射击音效音量
            initialShootSound = Sounds.; // none 首次开火音效
            chargeSound = Sounds.; // none 充能音效

            // 子弹
            continuous = ; // 是否保持子弹在射击位置
            alwaysContinuous = ; // 是否无装填连续射击
            aimChangeSpeed = f; // Float.1/0f 改变炮塔瞄准距离的速度, 仅用于点激光子弹
            controllable = ; // true 是否可由玩家手动瞄准
            aiControllable = ; // true 是否可由单位自动瞄准
            alwaysShooting = ; // false 是否始终射击
            autoTarget = ; // false 是否自动瞄准目标
            predictTarget = ; // true 是否预测目标轨迹
            reload = f; // 77f 重新装填的帧数
            inaccuracy = f; // 0f 射击时的不精准度
            velocityRnd = f; // 0f 速度随机分量比例
            extraVelocity = f; // 0f 额外速度比例
            shootCone = f; // 5f 射击起始锥角半径
            shootStatus = StatusEffects.; // none 射击施加的状态效果
            shootStatusDuration = f * 60f; // 5f * 60f 射击状态效果持续时间

            parts.add(); // 额外动画部件
            bullet = new BasicBulletType();
        }};
        */


        omegaObserver = new UnitType("omega-observer") {{
            constructor = PayloadUnit::create;
            speed = 3.9f;
            rotateSpeed = 9f;
            drag = 0.035f;
            accel = 0.095f;
            hitSize = 16f;
            health = 620f;
            armor = 5f;
            buildRange = 320;
            payloadCapacity = Mathf.sqr(2.5f) * Vars.tilePayload;
            buildSpeed = 2f;
            buildBeamOffset = 3.5f;
            mineBeamOffset = 5.75f;
            engineOffset = 9f;
            engineSize = 3.75f;
            fogRadius = 0f;
            isEnemy = false;
            flying = true;
            killable = true;
            createWreck = false;
            targetable = false;
            createScorch = false;
            lowAltitude = true;
            hidden = true;
            drawCell = false;
            deathSound = Sounds.none;
            immunities.add(VeStatusEffects.frozen);
            lightColor = engineColor = VePal.coralRed;
            deathExplosionEffect = Fx.none;
            itemCapacity = 110;
            mineTier = 3;
            mineSpeed = 11f;
            mineWalls = true;
            weapons.add(
                    new BuildWeapon() {{
                        rotate = false;
                        top = false;
                        shootY = 0f;
                        shootX = 0f;
                        x = 6f;
                        y = 6f;
                    }},
                    new Weapon(VeName("fast-power-weapon")) {{
                        ejectEffect = Fx.casing1;
                        top = false;
                        reload = 20f;
                        inaccuracy = 1.5f;
                        recoil = 0f;
                        shootX = 0f;
                        shootY = 4f;
                        x = 3.75f;
                        y = -4.25f;
                        shoot.shots = 5;
                        shoot.shotDelay = 3f;
                        shootSound = Sounds.none;
                        bullet = new BasicBulletType(7f, 17f) {{
                            width = 7f;
                            height = 16f;
                            lifetime = 45f;
                            hitEffect = despawnEffect =
                                    shootEffect = smokeEffect = Fx.none;
                            buildingDamageMultiplier = 0.01f;
                            instantDisappear = true;
                            maxRange = 315f;
                            homingPower = 0.12f;
                            homingDelay = 10f;
                            lightColor = Pal.accent;
                            fragBullet = new LightningBulletType() {{
                                speed = 0.0001f;
                                damage = 5f;
                                buildingDamageMultiplier = 0f;
                                status = StatusEffects.shocked;
                                statusDuration = 10f;
                                collidesTiles = false;
                                hitColor = lightningColor = lightColor = Pal.accent;
                                lightningLength = 5;
                            }};
                            fragBullets = 0;
                        }};
                    }},
                    new Weapon(VeName("omega-weapon")) {{
                        rotate = true;
                        top = false;
                        rotateSpeed = 7f;
                        reload = 32f;
                        shake = 0f;
                        recoil = 0f;
                        recoilTime = 25f;
                        cooldownTime = 60f;
                        shootX = 7.5f;
                        shootY = -0.25f;
                        x = 4.5f;
                        y = 0.25f;
                        rotationLimit = 150f;
                        minWarmup = 0.97f;
                        shootWarmupSpeed = 0.2f;
                        soundPitchMin = 1f;
                        soundPitchMax = 1.05f;
                        layerOffset = -0.002f;
                        shootSound = Sounds.none;
                        heatColor = Pal.accent;
                        parts.add(new RegionPart("-weapon") {{
                            layerOffset = 0.001f;
                            moveX = 7.5f;
                            moveY = -4f;
                            color = VePal.grayMid;
                            colorTo = Color.white;
                        }});
                        bullet = new LaserBulletType() {{
                            colors = new Color[] {
                                    VePal.accent0,
                                    VePal.accent0,
                                    Color.valueOf("ffffff00")
                            };
                            length = 0f;
                            sideLength = 45f;
                            sideWidth = 0.75f;
                            sideAngle = 30f;
                            damage = 100f;
                            hitEffect = despawnEffect = shootEffect =
                                    smokeEffect = laserEffect = Fx.none;
                            buildingDamageMultiplier = 0.01f;
                            recoil = 0f;
                            instantDisappear = true;
                            maxRange = 265f;
                            hitColor = lightColor = Pal.accent;
                        }};
                    }}
            );
        }};

    }
}
