package vanilla.expansion.content;

import arc.graphics.Blending;
import arc.graphics.Color;
import arc.math.Mathf;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.abilities.EnergyFieldAbility;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.ContinuousBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.entities.part.*;
import mindustry.gen.ElevationMoveUnit;
import mindustry.gen.Sounds;
import mindustry.graphics.Layer;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.world.meta.BlockFlag;
import vanilla.expansion.VeEntities.Part.StatefulRegionPart;
import vanilla.expansion.VeEntities.Part.VePartProgress;
import vanilla.expansion.VeType.StatefulWeapon;

import static vanilla.expansion.VanillaExpansion.VeName;

public class VeTestUnitTypes {

    public static UnitType testUnit1;

    public static void load() {


        testUnit1 = new UnitType("testUnit1") {{
            constructor = ElevationMoveUnit::create;
            health = 9000f;
            armor = 10f;
            maxRange = 520f;
            hitSize = 45f;
            itemCapacity = 160;
            canDrown = false;
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
                status = VeStatusEffects.blown;
                shootSound = Sounds.none;
                statusDuration = 20f * 60f;
                x = 0f;
                y = 0f;
                targetGround = false;
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

                        parts.add(createTubes(3,
                                new StatefulRegionPart("-tube") {{
                                    mirror = false; // -
                                    clampProgress = false;
                                    heatProgress = PartProgress.warmup;
                                    layerOffset = -0.0010f;
                                    x = 0f;
                                    y = 0f;
                                    moveX = 1.5f;
                                    moveY = 0f;
                                    color = VePal.gray187;
                                    colorTo = Color.white;
                                    under = true;
                                }}
                        ));

                        /*
                        StatefulRegionPart hurricaneTube1 = new StatefulRegionPart("-tube") {{
                            speedFunc = PartProgress.heat.min(PartProgress.constant(0.9f)).mul(Mathf.PI / 16f / 0.9f);
                            modAmount = Mathf.PI2;
                            progress = VePartProgress.sinOf(accumulator);
                            layerProgress = VePartProgress.cosOf(accumulator).mul(0.0005f);
                            colorProgress = VePartProgress.cosOf(accumulator).mul(0.5f).add(0.5f);
                            mirror = false; // -
                            clampProgress = false;
                            heatProgress = PartProgress.warmup;
                            layerOffset = -0.0010f;
                            x = 0f;
                            y = 0f;
                            moveX = 1.5f;
                            moveY = 0f;
                            color = VePal.gray187;
                            colorTo = Color.white;
                            under = true;
                        }};
                        parts.add(
                                hurricaneTube1,
                                new StatefulRegionPart("-tube") {{
                                    progress = VePartProgress.sinOf(hurricaneTube1.accumulator.add(Mathf.halfPi));
                                    layerProgress = VePartProgress.cosOf(hurricaneTube1.accumulator.add(Mathf.halfPi)).mul(0.0005f);
                                    colorProgress = VePartProgress.cosOf(hurricaneTube1.accumulator.add(Mathf.halfPi)).mul(0.5f).add(0.5f);
                                    mirror = false; // -
                                    clampProgress = false;
                                    heatProgress = PartProgress.warmup;
                                    layerOffset = -0.0010f;
                                    x = 0f;
                                    y = 0f;
                                    moveX = 1.5f;
                                    moveY = 0f;
                                    color = VePal.gray187;
                                    colorTo = Color.white;
                                    under = true;
                                }},
                                new StatefulRegionPart("-tube") {{
                                    progress = VePartProgress.sinOf(hurricaneTube1.accumulator.add(Mathf.PI));
                                    layerProgress = VePartProgress.cosOf(hurricaneTube1.accumulator.add(Mathf.PI)).mul(0.0005f);
                                    colorProgress = VePartProgress.cosOf(hurricaneTube1.accumulator.add(Mathf.PI)).mul(0.5f).add(0.5f);
                                    mirror = false; // -
                                    clampProgress = false;
                                    heatProgress = PartProgress.warmup;
                                    layerOffset = -0.0010f;
                                    x = 0;
                                    y = 0f;
                                    moveX = 1.5f;
                                    moveY = 0f;
                                    color = VePal.gray187;
                                    colorTo = Color.white;
                                    under = true;
                                }},
                                new StatefulRegionPart("-tube") {{
                                    progress = VePartProgress.sinOf(hurricaneTube1.accumulator.add(Mathf.PI + Mathf.halfPi));
                                    layerProgress = VePartProgress.cosOf(hurricaneTube1.accumulator.add(Mathf.PI + Mathf.halfPi)).mul(0.0005f);
                                    colorProgress = VePartProgress.cosOf(hurricaneTube1.accumulator.add(Mathf.PI + Mathf.halfPi)).mul(0.5f).add(0.5f);
                                    mirror = false; // -
                                    clampProgress = false;
                                    heatProgress = PartProgress.warmup;
                                    layerOffset = -0.0010f;
                                    x = 0f;
                                    y = 0f;
                                    moveX = 1.5f;
                                    moveY = 0f;
                                    color = VePal.gray187;
                                    colorTo = Color.white;
                                    under = true;
                                }}
                        );
                        */

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
    }
}
