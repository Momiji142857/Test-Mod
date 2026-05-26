
// Item
        /*
        item = new Item("", Color.valueOf("")) {{
            explosiveness = f; // 0f 爆炸性
            flammability = f; // 0f 燃烧性
            radioactivity = f; // 放射性
            charge = f; // 0f 放电性
            hardness = ; // 0 硬度
            cost = f; // 1f 建造时间花费
            healthScaling = f; // 0f 建筑血量系数
            lowPriority = ; // 被挖掘时, 是否是最低优先级
            buildable = ; // true 该物品进入核心时能否被焚毁
            hidden = ; // false 是否隐藏

            // 动态贴图
            frames = ; // 0 是否具有动态贴图
            transitionFrames = ; // 0 动态贴图每帧之间的过度帧数量
            frameTime = f; // 5f 动画之间的间隔时间

            // UnlockableContent
            alwaysUnlocked = ; // false 是否在科技树中始终解锁
            inlineDescription = ; // true 是否在研究界面显示描述
            hideDetails = ; // true 如果未在战役中解锁, 是否隐藏细节
            hideDatabase = ; // false 是否在核心数据库中隐藏
            allDatabaseTabs = ; // false 如果为真, 则在所有数据库标签页中显示
            shownPlanets.add(Planets.); // 包含此内容的星球. 如果为空则按照物品需求决定一个星球, 目前仅对方块有用
            databaseTabs.add(Planets.);
            databaseCategory = ""; // default 数据库类别
            databaseTag = ""; // default 数据库标签
        }};
        */

        /*
        item = new Item("", Color.valueOf("")) {{
            explosiveness = f; // 0f 爆炸性
            flammability = f; // 0f 燃烧性
            radioactivity = f; // 放射性
            charge = f; // 0f 放电性
            hardness = ; // 0 硬度
            cost = f; // 1f 建造时间花费
            healthScaling = f; // 0f 建筑血量系数
            lowPriority = ; // 被挖掘时, 是否是最低优先级
            frames = ; // 0 是否具有动态贴图
            transitionFrames = ; // 0 动态贴图每帧之间的过度帧数量
            frameTime = f; // 5f 动画之间的间隔时间
            buildable = ; // true 该物品进入核心时能否被焚毁
            hidden = ; // false 是否隐藏

            // UnlockableContent
            alwaysUnlocked = ; // false 是否在科技树中始终解锁
            inlineDescription = ; // true 是否在研究界面显示描述
            hideDetails = ; // true 如果未在战役中解锁, 是否隐藏细节
            hideDatabase = ; // false 是否在核心数据库中隐藏
            allDatabaseTabs = ; // false 如果为真, 则在所有数据库标签页中显示
            shownPlanets.add(Planets.); // 包含此内容的星球. 如果为空则按照物品需求决定一个星球, 目前仅对方块有用
            databaseTabs.add(Planets.);
            databaseCategory = ""; // default 数据库类别
            databaseTag = ""; // default 数据库标签
        }};
        */


// statusEffect
        /*
        statusEffect = new StatusEffect("") {{
            damageMultiplier = f; // 1f 伤害倍率
            healthMultiplier = f; // 1f 生命值倍率
            speedMultiplier = f; // 1f 速度倍率
            reloadMultiplier = f; // 1f 开火速率倍率
            buildSpeedMultiplier = f; // 1f 建造速度倍率
            dragMultiplier = f; // 1f 移动阻力倍率
            disarm = ; // false 是否缴械
            reactive = ; // 是否仅用于元素反应
            show = ; // true 是否在数据库中显示

            // 伤害
            transitionDamage = f; // 0f 元素反应的伤害
            damage = f; // 每帧伤害
            intervalDamageTime = f; // 间隔伤害的时间间隔
            intervalDamage = f; // 间隔伤害
            intervalDamagePierce = ; // false 间隔伤害是否穿甲

            // 产生的粒子效果
            color = Color.valueOf(""); // 状态效果的颜色
            effect = new (); // Fx.none // 单位上随机生成的粒子效果
            effectChance = f; // 0.15f 粒子效果出现的概率
            parentizeEffect = ; // 粒子效果是否应该有一个父级
            permanent = ; // 粒子效果是否会消失

            // 应用效果
            applyEffect = new (); // Fx.none // 单位被赋予该状态效果时产生的粒子效果
            applyExtend = ; // 当单位已拥有此状态效果时, 是否仍然显示应用效果
            applyColor = Color.valueOf(""); // 应用效果的颜色
            parentizeApplyEffect = ; // 应用效果是否应有一个父级

            outline = ; // true 如果为false, 将禁用轮廓线

            init(() -> {
                opposite(StatusEffects., StatusEffects.); // 互斥的状态效果

                affinity(StatusEffects., (unit, result, time) -> {
                    unit.damagePierce();
                    result.set(StatusEffects., Math.min(time + result.time, 300.0F));
                });

            });

            // UnlockableContent
            alwaysUnlocked = ; // false 是否在科技树中始终解锁
            inlineDescription = ; // true 是否在研究界面显示描述
            hideDetails = ; // true 如果未在战役中解锁, 是否隐藏细节
            hideDatabase = ; // false 是否在核心数据库中隐藏
            allDatabaseTabs = ; // false 如果为真, 则在所有数据库标签页中显示
            shownPlanets.add(Planets.); // 包含此内容的星球. 如果为空则按照物品需求决定一个星球, 目前仅对方块有用
            databaseTabs.add(Planets.);
            databaseCategory = ""; // default 数据库类别
            databaseTag = ""; // default 数据库标签
        }};
        */

        /*
        statusEffect = new StatusEffect("") {{
            damageMultiplier = f; // 1f 伤害倍率
            healthMultiplier = f; // 1f 生命值倍率
            speedMultiplier = f; // 1f 速度倍率
            reloadMultiplier = f; // 1f 开火速率倍率
            buildSpeedMultiplier = f; // 1f 建造速度倍率
            dragMultiplier = f; // 1f 移动阻力倍率
            transitionDamage = f; // 0f 元素反应的伤害
            disarm = ; // false 是否缴械
            damage = f; // 每帧伤害
            intervalDamageTime = f; // 间隔伤害的时间间隔
            intervalDamage = f; // 间隔伤害
            intervalDamagePierce = ; // false 间隔伤害是否穿甲
            effectChance = f; // 0.15f 粒子效果出现的概率
            parentizeEffect = ; // 粒子效果是否应该有一个父级
            permanent = ; // 粒子效果是否会消失
            reactive = ; // 是否仅用于元素反应
            show = ; // true 是否在数据库中显示
            color = Color.valueOf(""); // 状态效果的颜色
            effect = new (); // Fx.none // 单位上随机生成的粒子效果
            applyEffect = new (); // Fx.none // 单位被赋予该状态效果时产生的粒子效果
            applyExtend = ; // 当单位已拥有此状态效果时, 是否仍然显示应用效果
            applyColor = Color.valueOf(""); // 应用效果的颜色
            parentizeApplyEffect = ; // 应用效果是否应有一个父级
            outline = ; // true 如果为false, 将禁用轮廓线
            init(() -> {
                opposite(StatusEffects., StatusEffects.); // 互斥的状态效果

                affinity(StatusEffects., (unit, result, time) -> {
                    unit.damagePierce();
                    result.set(StatusEffects., Math.min(time + result.time, 300.0F));
                });

            });

            // UnlockableContent
            alwaysUnlocked = ; // false 是否在科技树中始终解锁
            inlineDescription = ; // true 是否在研究界面显示描述
            hideDetails = ; // true 如果未在战役中解锁, 是否隐藏细节
            hideDatabase = ; // false 是否在核心数据库中隐藏
            allDatabaseTabs = ; // false 如果为真, 则在所有数据库标签页中显示
            shownPlanets.add(Planets.); // 包含此内容的星球. 如果为空则按照物品需求决定一个星球, 目前仅对方块有用
            databaseTabs.add(Planets.);
            databaseCategory = ""; // default 数据库类别
            databaseTag = ""; // default 数据库标签
        }};
        */


// Liquid
        /*
        liquid = new Liquid("", Color.valueOf("")) {{
            gas = ; // false 是否为气体
            gasColor = Color.valueOf(""); // = Color 气态下的颜色
            barColor = Color.valueOf(""); // 界面中的颜色
            lightColor = Color.valueOf(""); // 发出的光的颜色
            hidden = ; // 是否隐藏

            // 属性
            flammability = f; // 燃烧性
            temperature = f; // 0.5f 温度
            heatCapacity = f; // 0.5f 热容量
            viscosity = f; // 0.5f 粘度
            explosiveness = f; // 爆炸性
            boilPoint = f; // 2f 沸点
            coolant = ; // true 能否作为冷却液
            incinerable = ; // true 能否被焚毁
            effect = StatusEffects.; // none 关联的状态效果

            // 水坑相关
            moveThroughBlocks = ; // true 形成的水坑能否穿过物块
            particleEffect = Fx.; // none 水坑中显示的粒子效果
            particleSpacing = f; // 60f 粒子效果的间距
            capPuddles = ; // true 水坑大小是否被限制
            vaporEffect = Fx.; // none 蒸发时产生的粒子效果

            // 其他液体相关
            blockReactive = ; // true 是否与物块里其他液体发生反应
            canStayOn.add(Liquids.); // 会浮在哪些液体上

            // UnlockableContent
            alwaysUnlocked = ; // false 是否在科技树中始终解锁
            inlineDescription = ; // true 是否在研究界面显示描述
            hideDetails = ; // true 如果未在战役中解锁, 是否隐藏细节
            hideDatabase = ; // false 是否在核心数据库中隐藏
            allDatabaseTabs = ; // false 如果为真, 则在所有数据库标签页中显示
            shownPlanets.add(Planets.); // 包含此内容的星球. 如果为空则按照物品需求决定一个星球, 目前仅对方块有用
            databaseTabs.add(Planets.);
            databaseCategory = ""; // default 数据库类别
            databaseTag = ""; // default 数据库标签
        }};
        */

        /*
        liquid = new Liquid("", Color.valueOf("")) {{
            gas = ; // false 是否为气体
            gasColor = Color.valueOf(""); // = Color 气态下的颜色
            barColor = Color.valueOf(""); // 界面中的颜色
            lightColor = Color.valueOf(""); // 发出的光的颜色
            flammability = f; // 燃烧性
            temperature = f; // 0.5f 温度
            heatCapacity = f; // 0.5f 热容量
            viscosity = f; // 0.5f 粘度
            explosiveness = f; // 爆炸性
            blockReactive = ; // true 是否与物块里其他液体发生反应
            coolant = ; // true 能否作为冷却液
            moveThroughBlocks = ; // true 形成的水坑能否穿过物块
            incinerable = ; // true 能否被焚毁
            effect = StatusEffects.; // none 关联的状态效果
            particleEffect = Fx.; // none 水坑中显示的粒子效果
            particleSpacing = f; // 60f 粒子效果的间距
            boilPoint = f; // 2f 沸点
            capPuddles = ; // true 水坑大小是否被限制
            vaporEffect = Fx.; // none 蒸发时产生的粒子效果
            hidden = ; // 是否隐藏
            canStayOn.add(Liquids.); // 会浮在哪些液体上

            // UnlockableContent
            alwaysUnlocked = ; // false 是否在科技树中始终解锁
            inlineDescription = ; // true 是否在研究界面显示描述
            hideDetails = ; // true 如果未在战役中解锁, 是否隐藏细节
            hideDatabase = ; // false 是否在核心数据库中隐藏
            allDatabaseTabs = ; // false 如果为真, 则在所有数据库标签页中显示
            shownPlanets.add(Planets.); // 包含此内容的星球. 如果为空则按照物品需求决定一个星球, 目前仅对方块有用
            databaseTabs.add(Planets.);
            databaseCategory = ""; // default 数据库类别
            databaseTag = ""; // default 数据库标签
        }};
        */


// Weathers
        /*
        weather = new ParticleWeather("") {{
            // = new ParticleWeather("") {{
            particleRegion = ""; // "circle-shadow"
            color = Color.valueOf("");
            noiseColor = Color.valueOf("");
            yspeed = f; // -2f
            xspeed = f; // 0.25f
            padding = f; // 16f
            sizeMin = f; // 2.4f
            sizeMax = f; // 12f
            density = f; // 1200f
            minAlpha = f; // 1f
            maxAlpha = f; // 1f
            force = f; // 0f
            noiseScale = f; // 2000f
            baseSpeed = f; // 6.1f
            sinSclMin = f; // 30f
            sinSclMax = f; // 80f
            sinMagMin = f; // 1f
            sinMagMax = f; // 7f
            drawNoise = ; // false
            drawParticles = ; // true
            useWindVector = ; // false
            randomParticleRotation = ; // false
            noiseLayers = ; // 1
            noiseLayerSpeedM = f; // 1.1f
            noiseLayerAlphaM = f; // 0.8f
            noiseLayerSclM = f; // 0.99f
            noiseLayerColorM = f; // 1f
            noisePath = "";
            noise = ;

            // = new RainWeather() {{
            yspeed = f; // 5f
            xspeed = f; // 1.5f
            padding = f; // 16f
            density = f; // 1200f
            stroke = f; // 0.75f
            sizeMin = f; // 8f
            sizeMax = f; // 40f
            splashTimeScale = f; // 22f
            liquid = Liquids.; // water
            splashes = ; // new TextureRegion[12];
            color = Color.valueOf("");

            boundMax = f;
            duration = f; // 10f * Time.toMinutes
            opacityMultiplier = f; // 1f;
            attrs.set(Attribute., );
            sound = Sounds.; // none
            soundVol = f; // 0.1f
            soundVolMin = f; // 0f
            soundVolOscMag = f; // 0f
            soundVolOscScl = f; // 20f
            hidden = ; // false
            status = StatusEffects.; // none
            statusDuration = f; // 60f * 2
            statusAir = ; // true
            statusGround = ; // true
        }};
         */


// UnitType
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

// 基础
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
            hovering = ; // false 是否不会受下方地板影响
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


// Block
// Floor
        /*
        floor = new Floor("", variants) {{
            // = new Floor("", variants) {{
                // = new ShallowLiquid("") {{
                liquidBase = Blocks.; // 液体基础
                floorBase = Blocks.; // 地板基础
                liquidOpacity = f; // 0.35f 液体不透明度

                // = new OverlayFloor("") {{
                    // = new OreBlock("", Items.ore) {{
                    localizedName = ore.localizedName;
                    itemDrop = ore;
                    variants = 3;
                    mapColor.set(ore.color);
                    useColor = true;

                // OverlayFloor
                useColor = false;

            // Floow
            // 属性
            speedMultiplier = f; // 1f 移动速度倍率
            dragMultiplier = f; // 1f 阻力倍率
            damageTaken = f; // 0f 对上方单位造成的伤害
            drownTime = f; // 0f 沉没时间
            status = StatusEffects.; // none 对上方单位造成的状态效果
            statusDuration = f; // 60f 状态效果的时长
            isLiquid = ; // 是否为液体
            supportsOverlay = ; // false 是否支持覆盖层地板
            shallow = ; // false 是否为浅水
            wall = Blocks.; // 对应的墙壁
            decoration = Blocks.; // 对应的装饰块
            needsSurface = ; // true 这个覆盖层是否需要放在表面上
            allowCorePlacement = ; // false 核心能否放置在该地板上
            // 资源
            liquidDrop = Liquids.; // 泵可抽取的液体
            liquidMultiplier = f; // 1f 泵送液体的倍率
            oreDefault = ; // false 对于矿石, 是否默认在地图中生成
            oreScale = ; // 24f 矿石生成参数
            oreThreshold = ; // 0.828f
            wallOre = ; // false 该矿石能否放置在墙上
            itemDrop = Items.; // 被钻头开采时, 能够开采出的物品
            playerUnmineable = ; // false 如果为false, 该方块无法被玩家手动开采
            attributes.set(Attribute., ); // 对某些事物的效率加成

            // 渲染
            edge = ; // "stone" // 边缘填充纹理
            overlayAlpha = f; // 0.65f 对于液体, 上方覆盖层的不透明度
            blendGroup = ; // this 不绘制边缘的方块组
            canShadow = ; // true 单位能否在其上绘制阴影
            forceDrawLight = ; // false 这个地板是否忽略覆盖层的阻光标志
            tilingVariants = ; // 0 大型平铺变体的数量
            autotile = ; // false 是否使用自动拼接
            autotileMidVariants = ; // 1 自动拼接中间区域的随机变体数量
            autotileVariants = ; // 1 主自动拼接精灵的变体数量
            drawEdgeIn = ; // true 是否在其他地板上绘制这个地板的边缘
            drawEdgeOut = ; // true 是否将这个地板的边缘绘制到其他地板上
            // 粒子效果
            walkEffect = Fx.; // none 上方单位移动时产生的粒子效果
            drownUpdateEffect = Fx.; // bubble 沉没时产生的粒子效果
            // 音效
            walkSound = Sounds.; // none 上方单位移动时产生的音效
            walkSoundVolume = f; // 0.1f 移动音效音量
            walkSoundPitchMin = f; // 0.8f 移动音效音高范围
            walkSoundPitchMax = f; // 1.2f

            // Block
            placeableLiquid = true; // 能否放置在任何液体上
            allowRectanglePlacement = true; // 是否为矩形放置, 而非线性放置
            ignoreBuildDarkness = true; // 能否在黑暗区域放置, 用于编辑静态墙
            variants = 3; // 0 不同的变体贴图数量
            obstructsLight = false; // 是否遮挡其他方块发出的光线
            placeEffect = Fx.rotateBlock; // 放置效果

        }};
        */

// Prop
        /*
        prop = new Prop("") {{
            // = new Prop("") {{
                // = new SeaBush("") {{
                lobesMin = ; // 7
                lobesMax = ; // 7
                botAngle = f; // 60f
                origin = f; // 0.1f
                sclMin = f; // 30f
                sclMax = f; // 50f
                magMin = f; // 5f
                magMax = f; // 15f
                timeRange = f; // 40f
                spread = f; // 0f

                variants = 0; // 0 不同的变体贴图数量
                obstructsLight = false; // true 是否遮挡其他方块发出的光线

                // = new Seaweed("") {{
                obstructsLight = false; // true 是否遮挡其他方块发出的光线

                // = new WobbleProp("") {{
                wscl = f; // 25f
                wmag = f; // 0.4f
                wtscl = f; // 1f
                wmag2 = f; // 1f

                breakSound = Sounds.plantBreak; // unset 拆除音效

                // = new StaticWall("") {{
                    // = new StaticTree("") {{
                    variants = 0; // 0 不同的变体贴图数量

                // StaticWall
                solid = true; // 是否为实体
                breakable = alwaysReplace = unitMoveBreakable = false;
                // 是否可以用右键直接拆除这个方块; 是否在所有情况下都可以被替换; 如果为true, 某些单位踩到或移动到该方块上时会破坏该方块
                placeableLiquid = true; // false 能否放置在任何液体上
                allowRectanglePlacement = true; // false 是否为矩形放置, 而非线性放置
                ignoreBuildDarkness = true; // false 能否在黑暗区域放置, 用于编辑静态墙
                variants = 2; // 0 不同的变体贴图数量
                cacheLayer = CacheLayer.walls; // 缓存渲染层类型
                placeEffect = Fx.rotateBlock; // placeBlock 放置效果
                instantBuild = true;

            // Prop
            layer = Layer.; // blockProp 图层

            // Block
            breakable = true; // 是否可以用右键直接拆除这个方块
            alwaysReplace = true; // false 是否在所有情况下都可以被替换
            instantDeconstruct = true; // false 是否立即拆除, 不返还资源
            unitMoveBreakable = true; // 如果为true, 某些单位踩到或移动到该方块上时会破坏该方块
            breakSound = Sounds.rockBreak; // unset 拆除音效
            breakEffect = Fx.breakProp; // breakBlock 拆除效果
        }};
        */

// Drill
        /*
        drill = new Drill("") {{
            requirements(Category.distribution, BuildVisibility.hidden, ItemStack.with(Items., ));

             // = new Drill("") {{
                // = new BurstDrill("") {{
                shake = f; // 2f 挖掘时的震动强度
                speedCurve = Interp.; // pow2In
                invertedTime = f; // 200f 动画周期
                arrowSpacing = f; // 4f 箭头之间的间隔距离
                arrowOffset = f; // 0f 箭头位置的偏移量
                arrows = ; // 3 显示的箭头数量
                arrowColor = Color.valueOf(""); // feb380 箭头颜色
                baseArrowColor = Color.valueOf(""); // 6e7080 箭头底座颜色
                glowColor = Color.valueOf(""); // = arrowColor 发光颜色
                drillSound = Sounds.; // drillImpact 钻头工作时的声效
                drillSoundVolume = f; // 0.6f 钻头声效音量
                drillSoundPitchRand = f; // 0.1f 钻头音效音调随机变化范围

                // Drill
                hardnessDrillMultiplier = 0f; // 50f 硬度乘数 (未被使用)
                drillEffect = Fx.shockwave; // mine 产出物品时产生的粒子效果
                drillEffectRnd = 0f; // -1f 挖掘效果的随机范围
                ambientSound = Sounds.drillCharge; // none 空闲时发出的声音
                ambientSoundVolume = 0.18f; // 0.05f 空闲音效音量

            // BurstDrill
            // 挖掘速度
            hardnessDrillMultiplier = f; // 50f 硬度乘数
            tier = ; // 可开采的最大硬度
            drillTime = f; // 300f 基础开采时间
            liquidBoostIntensity = f; // 1.6f 液体加速倍率
            warmupSpeed = f; // 0.015f 钻头预热速度
            drillMultipliers.put(Items., f); // 不同矿石的开采速度倍率

            // 挖掘物品
            blockedItem = Items.; // 禁止开采的物品
            blockedItems = ; // 禁止开采的物品列表

            // 渲染
            drawMineItem = ; // true 是否绘制正在开采的物品
            drillEffect = Fx.; // mine 产出物品时产生的粒子效果
            drillEffectRnd = f; // -1f 挖掘效果的随机范围
            drillEffectChance = f; // 0.02f 挖掘效果出现的概率
            rotateSpeed = f; // 2f 钻头旋转的速度
            updateEffect = Fx.; // pulverizeSmall 钻头工作时随机产生的粒子效果
            updateEffectChance = f; // 0.02f 工作效果出现的概率
            drawRim = ; // false 是否绘制边框
            drawSpinSprite = ; // true 是否绘制旋转的钻头贴图
            heatColor = Color.valueOf(""); // ff5512 钻头发热时的颜色

            // Block
            flags = EnumSet.of(BlockFlag.drill); // 方块的标志集合，用于AI索引
            update = true; // 该方块是否具有持续更新的方块实体
            solid = true; // 是否为实心方块
            group = BlockGroup.drills; // 属于哪个组, 同组方块可以相互替换
            envEnabled |= Env.space; // Env.terrestrial 可运行环境
            hasItems = true; // 是否拥有物品模块
            hasLiquids = true; // 是否拥有液体模块
            ambientSound = Sounds.loopDrill; // none 空闲时发出的声音
            ambientSoundVolume = 0.019f; // 0.05f 空闲音效音量

            // = new BeamDrill("") {{
            // 挖掘速度
            drillTime = f; // 200f 基础开采时间
            range = ; // 5 开采距离
            tier = ; // 1 可开采的最大硬度
            laserWidth = f; // 0.65f
            optionalBoostIntensity = f; // 2.5f 增强倍率
            drillMultipliers.put(Items., f); // 不同矿石的开采速度倍率

            // 挖掘物品
            blockedItem = Items.; // 禁止开采的物品
            blockedItems = ; // 禁止开采的物品列表

            // 渲染
            sparkColor = Color.valueOf(""); // fd9e81 火花颜色
            glowColor = Color.valueOf(""); // white 辉光颜色
            glowIntensity = f; // 0.2f 辉光强度
            pulseIntensity = f; // 0.07f 脉冲强度
            glowScl = f; // 3f 辉光缩放
            sparks = ; // 7 火花数量
            sparkRange = f; // 10f 火花扩散范围
            sparkLife = f; // 27f 火花存在时间
            sparkRecurrence = f; // 4f 火花重复间隔
            sparkSpread = f; // 45f 火花散开角度
            sparkSize = f; // 3.5f 火花大小
            boostHeatColor = Color.valueOf(""); // Color.sky.cpy().mul(0.87f); 加速时的颜色
            heatColor = Color.valueOf(""); // 无加速时的颜色
            heatPulse = f; // 0.3f 脉冲强度
            heatPulseScl = f; // 7f 脉冲频率

            // Block
            flags = EnumSet.of(BlockFlag.drill); // 方块的标志集合，用于AI索引
            update = true; // 该方块是否具有持续更新的方块实体
            solid = true; // 是否为实心方块
            rotate = true; // 是否可旋转
            ignoreLineRotation = true; // false 如果为true, 该方块的朝向不会朝向拖动方向
            envEnabled |= Env.space; // Env.terrestrial 可运行环境
            hasItems = true; // 是否拥有物品模块
            drawArrow = false; // true 是否绘制旋转箭头
            ambientSound = Sounds.loopMineBeam; // none 空闲时发出的声音
            ambientSoundVolume = 0.05f; // 0.05f 空闲音效音量 -

            armor = f; // 0f 护甲
            size = ; // 1 方块大小
            itemCapacity = ; // 10 物品容量
            liquidCapacity = f; // -1f 液体容量
            hasPower = ; // 是否拥有电力模块
            conductivePower = ; // false 能否通过接触传导电力
            dumpTime = ; // 5 尝试输出的时间间隔, 填5即每秒尝试输出12次
            consumeLiquid(Liquids., f / 60f); // + .boost(); 消耗的液体 + 强化
            consumeLiquids(LiquidStack.with(Liquids., f/ 60f));
            consumeCoolant(f); // + .boost(); 消耗任意冷却液 + 强化
            consumePower(f / 60f); // 消耗的电力
            consumeItem(Items., ); // 消耗的物品
            consumeItems(ItemStack.with(Items., , Items., ));
            squareSprite = ; // true 贴图是否为完整方块

            researchCostMultiplier = f; // 1f 研究成本倍数
        }};
        */

// Distribution
        /*
        distribution = new ("") {{
            // = new Conveyor("") {{
                // = new ArmoredConveyor("") {{
                noSideBlend = true;

            itemSpace = f; // 0.4f 物品之间的最小间隔
            capacity = ; // 3 每节传送带最多容纳的物品数量
            speed = f; // 0f 运输速率
            displayedSpeed = f; // 0f 显示的速率
            pushUnits = ; // true 是否推动站在上面的单位
            junctionReplacement = Blocks.; // 交叉器
            bridgeReplacement = Blocks.; // 桥
            // Block
            update = true; // 该方块是否具有持续更新的方块实体
            underBullets = true; // 如果为true, 则该方块除非被明确指定, 否则无法被子弹击中
            group = BlockGroup.transportation; // 属于哪个组, 同组方块可以相互替换
            conveyorPlacement = true; // 是否使用传送带式放置模式
            priority = TargetPriority.transport; // TargetPriority.base 敌人瞄准优先级
            rotate = true; // 是否可旋转
            noUpdateDisabled = false; // false 当方块被禁用时，是否停止更新
            hasItems = true; // 是否拥有物品模块
            itemCapacity = capacity; // 10 物品容量
            unloadable = false; // true 装卸器能否作用于该方块
            ambientSound = Sounds.loopConveyor; // none 空闲时发出的声音
            ambientSoundVolume = 0.0022f; // 0.05f 空闲音效音量

            // = new StackConveyor("") {{
            glowAlpha = f; // 1f 发光透明度
            glowColor = Color.valueOf(""); // Pal.redLight 发光颜色
            baseEfficiency = f; // 0f 基础运力倍率, 强化后倍率为 this +1
            speed = f; // 0f 运输速率, 运力 = 单次装载数 * this * 60f
            outputRouter = ; // true 是否输出到路由器
            recharge = f; // 2f 填满一条线所需的最小装载点数量
            loadEffect = Fx.; // conveyorPoof 装载时的粒子效果
            unloadEffect = Fx.; // conveyorPoof 卸载时的粒子效果
            // Block
            priority = TargetPriority.transport; // TargetPriority.base 敌人瞄准优先级
            update = true; // 该方块是否具有持续更新的方块实体
            underBullets = true; // 如果为true, 则该方块除非被明确指定, 否则无法被子弹击中
            group = BlockGroup.transportation; // 属于哪个组, 同组方块可以相互替换
            conveyorPlacement = true; // 是否使用传送带式放置模式
            rotate = true; // 是否可旋转
            hasItems = true; // 是否拥有物品模块
            itemCapacity = 10; // 10 物品容量
            ambientSound = Sounds.loopConveyor; // none 空闲时发出的声音
            ambientSoundVolume = 0.004f; // 0.05f 空闲音效音量

            // = new Junction("") {{
            speed = f; // 26 物品经过需要的时间
            capacity = ; // 6 物品容量
            displayedSpeed = f; // 13f 显示的速率
            // Block
            update = true; // 该方块是否具有持续更新的方块实体
            solid = false; // 是否为实体
            underBullets = true; // 如果为true, 则该方块除非被明确指定, 否则无法被子弹击中
            group = BlockGroup.transportation; // 属于哪个组, 同组方块可以相互替换
            noUpdateDisabled = true; // false 当方块被禁用时，是否停止更新
            unloadable = false; // true 装卸器能否作用于该方块

            // = new ItemBridge("") {{
                // = new BufferedItemBridge("") {{
                speed = f; // 40f 物品经过需要的时间
                bufferCapacity = ; // 50 缓冲区容量
                displayedSpeed = f; // 11f 显示给玩家的速度
                // Block
                canOverdrive = true; // true 能否超速
                hasItems = true; // 是否拥有物品模块
                hasPower = false; // 是否拥有电力模块

            range = ; // 最大连接距离
            transportTime = f; // 物品从一端传输到另一端所需的时间
            fadeIn = ; // true 是否渐显
            moveArrows = ; // true 是否显示移动的箭头
            pulse = ; // false 是否启用脉冲效果
            arrowSpacing = f; // 4f 箭头之间的间隔距离
            arrowOffset = f; // 2f 箭头位置的偏移量
            arrowPeriod = f; // 0.4f 箭头动画周期
            arrowTimeScl = f; // 6.2f 箭头动画时间缩放
            bridgeWidth = f; // 6.5f 桥身绘制的宽度
            // Block
            update = true; // 该方块是否具有持续更新的方块实体
            solid = true; // 是否为实体
            underBullets = true; // 如果为true, 则该方块除非被明确指定, 否则无法被子弹击中
            group = BlockGroup.transportation; // 属于哪个组, 同组方块可以相互替换
            delayLandingConfig = true; // 如果为true, 则在着陆构建动画中, 该方块的配置操作会被延迟, 未来可能会被移除
            allowDiagonal = false; // true 能否使用对角线放置模式(ctrl)
            priority = TargetPriority.transport; // TargetPriority.base 敌人瞄准优先级
            copyConfig = false; // true 能否通过选取操作复制配置
            allowConfigInventory = false; // true 物品库存是否与配置界面一起显示
            ignoreResizeConfig = true; // 如果为true, 在地图大小改变时, 不会有名为transform的点配置
            noUpdateDisabled = true; // false 当方块被禁用时，是否停止更新
            configurable = true; // false 能否被逻辑配置
            hasItems = true; // 是否拥有物品模块
            itemCapacity = 10; // 10 物品容量
            unloadable = false; // true 装卸器能否作用于该方块
            hasPower = true; // 是否拥有电力模块

            // = new Sorter("") {{
            invert = ; // 效果反向
            // Block
            update = false; // 该方块是否具有持续更新的方块实体
            underBullets = true; // 如果为true, 则该方块除非被明确指定, 否则无法被子弹击中
            group = BlockGroup.transportation; // 属于哪个组, 同组方块可以相互替换
            destructible = true; // 该方块是否具有生命值并可摧毁. update为true时, 该项为false不会有任何效果
            saveConfig = true; // false 是否保存上一次的配置并应用到新方块
            clearOnDoubleTap = true; // true 能否通过双击清除配置
            configurable = true;  // 能否被点击并打开配置界面
            unloadable = false; // true 装卸器能否作用于该方块
            instantTransfer = true; // false 是否支持瞬时传输(光传)

            // = new Router("") {{
            speed = f; // 8f
            // Block
            update = true; // 该方块是否具有持续更新的方块实体
            solid = false; // 是否为实体
            underBullets = true; // 如果为true, 则该方块除非被明确指定, 否则无法被子弹击中
            group = BlockGroup.transportation; // 属于哪个组, 同组方块可以相互替换
            noUpdateDisabled = true; // false 当方块被禁用时，是否停止更新
            hasItems = true; // 是否拥有物品模块
            itemCapacity = 1; // 10 物品容量
            unloadable = false; // true 装卸器能否作用于该方块

            // = new OverflowGate("") {{
            speed = f; // 1f
            invert = ; // false 效果反向
            // Block
            canOverdrive = false; // true 能否超速
            update = false; // 该方块是否具有持续更新的方块实体
            underBullets = true; // 如果为true, 则该方块除非被明确指定, 否则无法被子弹击中
            group = BlockGroup.transportation; // 属于哪个组, 同组方块可以相互替换
            destructible = true; // 该方块是否具有生命值并可摧毁. update为true时, 该项为false不会有任何效果
            hasItems = true; // 是否拥有物品模块
            itemCapacity = 0; // 10 物品容量
            unloadable = false; // true 装卸器能否作用于该方块
            instantTransfer = true; // false 是否支持瞬时传输(光传)

            // = new Unloader("") {{
            speed = f; // 1f 每次装卸的时间间隔
            allowCoreUnload = ; // true 能否从核心卸载
            // Block
            health = 70; // -1 生命值, 跳过scaledHealth
            update = true; // 该方块是否具有持续更新的方块实体
            solid = true; // 是否为实体
            saveConfig = true; // false 是否保存上一次的配置并应用到新方块
            clearOnDoubleTap = true; // true 能否通过双击清除配置
            configurable = true; // 能否被点击并打开配置界面
            noUpdateDisabled = true; // false 当方块被禁用时，是否停止更新
            hasItems = true; // 是否拥有物品模块
            itemCapacity = 0; // 10 物品容量
            unloadable = false; // true 装卸器能否作用于该方块

            // = new Duct("") {{
            speed = f; // 5f 两次物品运输之间的时间间隔
            armored = ; // false 是否具有装甲
            transparentColor = Color.valueOf(""); // 管道颜色
            bridgeReplacement = Blocks.; // 交叉器
            junctionReplacement = Blocks.; // 桥
            // Block
            priority = TargetPriority.transport; // TargetPriority.base 敌人瞄准优先级
            update = true; // 该方块是否具有持续更新的方块实体
            solid = false; // 是否为实体
            underBullets = true; // 如果为true, 则该方块除非被明确指定, 否则无法被子弹击中
            group = BlockGroup.transportation; // 属于哪个组, 同组方块可以相互替换
            conveyorPlacement = true; // 是否使用传送带式放置模式
            rotate = true; // 是否可旋转
            envEnabled = Env.space | Env.terrestrial | Env.underwater; // Env.terrestrial 可运行环境
            noUpdateDisabled = true; // false 当方块被禁用时，是否停止更新
            hasItems = true; // 是否拥有物品模块
            itemCapacity = 1; // 10 物品容量
            unloadable = false; // true 装卸器能否作用于该方块
            noSideBlend = true; // false 是否接受来自侧面的输入
            isDuct = true; // false 该方块是否为管道

            // = new DuctJunction("") {{
            transparentColor = Color.valueOf(""); // 管道颜色
            speed = f; // 5f 两次物品运输之间的时间间隔
            // Block
            priority = TargetPriority.transport; // TargetPriority.base 敌人瞄准优先级
            update = true; // 该方块是否具有持续更新的方块实体
            solid = false; // 是否为实体
            underBullets = true; // 如果为true, 则该方块除非被明确指定, 否则无法被子弹击中
            floating = true; // false 是否可以放置在液体边缘
            group = BlockGroup.transportation; // 属于哪个组, 同组方块可以相互替换
            envEnabled = Env.space | Env.terrestrial | Env.underwater; // Env.terrestrial 可运行环境
            noUpdateDisabled = true; // false 当方块被禁用时，是否停止更新
            hasItems = true; // 是否拥有物品模块
            unloadable = false; // true 装卸器能否作用于该方块

            // = new DuctBridge("") {{
            speed = 5f; // 物品运输的时间间隔
            // Block-1
            underBullets = true; // 如果为true, 则该方块除非被明确指定, 否则无法被子弹击中
            hasItems = true; // 是否拥有物品模块
            itemCapacity = 4; // 10 物品容量
            isDuct = true; // false 该方块是否为管道
            // DirectionBridge
            range = ; // 4 最大连接距离
            // Block-2
            update = true; // 该方块是否具有持续更新的方块实体
            solid = true; // 是否为实体
            group = BlockGroup.transportation; // 属于哪个组, 同组方块可以相互替换
            allowDiagonal = false; // true 能否使用对角线放置模式(ctrl)
            priority = TargetPriority.transport; // TargetPriority.base 敌人瞄准优先级
            rotate = true; // 是否可旋转
            envEnabled = Env.space | Env.terrestrial | Env.underwater; // Env.terrestrial 可运行环境
            noUpdateDisabled = true; // false 当方块被禁用时，是否停止更新
            drawArrow = false; // true 是否绘制旋转箭头

            // = new DuctRouter("") {{
                // = new StackRouter("") {{
                baseEfficiency = f; // 0f 基础效率
                glowAlpha = f; // 1f 发光透明度
                glowColor = Color.valueOf(""); // Pal.redLight 发光颜色
                // Block
                itemCapacity = 10; // 10 物品容量

            speed = f; // 5f 两次物品运输之间的时间间隔
            // Block
            priority = TargetPriority.transport; // TargetPriority.base 敌人瞄准优先级
            update = true; // 该方块是否具有持续更新的方块实体
            solid = false; // 是否为实体
            underBullets = true; // 如果为true, 则该方块除非被明确指定, 否则无法被子弹击中
            group = BlockGroup.transportation; // 属于哪个组, 同组方块可以相互替换
            rotate = true; // 是否可旋转
            envEnabled = Env.space | Env.terrestrial | Env.underwater; // Env.terrestrial 可运行环境
            saveConfig = true; // false 是否保存上一次的配置并应用到新方块
            clearOnDoubleTap = true; // true 能否通过双击清除配置
            configurable = true; // 能否被点击并打开配置界面
            noUpdateDisabled = true; // false 当方块被禁用时，是否停止更新
            hasItems = true; // 是否拥有物品模块
            itemCapacity = 1; // 10 物品容量
            unloadable = false; // true 装卸器能否作用于该方块

            // = new OverflowDuct("") {{
            speed = f; // 5f 两次物品运输之间的时间间隔
            invert = ; // false 效果反向
            // Block
            priority = TargetPriority.transport; // TargetPriority.base 敌人瞄准优先级
            update = true; // 该方块是否具有持续更新的方块实体
            solid = false; // 是否为实体
            underBullets = true; // 如果为true, 则该方块除非被明确指定, 否则无法被子弹击中
            group = BlockGroup.transportation; // 属于哪个组, 同组方块可以相互替换
            conveyorPlacement = true; // 是否使用传送带式放置模式
            rotate = true; // 是否可旋转
            envEnabled = Env.space | Env.terrestrial | Env.underwater; // Env.terrestrial 可运行环境
            noUpdateDisabled = true; // false 当方块被禁用时，是否停止更新
            hasItems = true; // 是否拥有物品模块
            itemCapacity = 1; // 10 物品容量
            unloadable = false; // true 装卸器能否作用于该方块

            // = new DirectionalUnloader("") {{
            speed = f; // 1f 两次物品运输之间的时间间隔
            allowCoreUnload = ; // false 能否从核心卸载
            // Block
            priority = TargetPriority.transport; // TargetPriority.base 敌人瞄准优先级
            update = true; // 该方块是否具有持续更新的方块实体
            solid = true; // 是否为实体
            group = BlockGroup.transportation; // 属于哪个组, 同组方块可以相互替换
            rotate = true; // 是否可旋转
            envDisabled = Env.none; // 0 无法运行的环境
            clearOnDoubleTap = true; // true 能否通过双击清除配置
            saveConfig = true; // false 是否保存上一次的配置并应用到新方块
            configurable = true; // 能否被点击并打开配置界面
            noUpdateDisabled = true; // false 当方块被禁用时，是否停止更新
            hasItems = true; // 是否拥有物品模块
            itemCapacity = 0; // 10 物品容量
            unloadable = false; // true 装卸器能否作用于该方块
            isDuct = true; // false 该方块是否为管道

            // = new MassDriver("") {{
            range = f; // 最大传输距离
            rotateSpeed = f; // 5f 旋转速度
            translation = f; // 7f 后坐力位移
            minDistribute = ; // 10 最小发送数量
            knockback = f; // 4f 后坐力强度
            reload = f; // 100f 装填时间
            bullet = new MassDriverBolt(); // 发射的子弹类型
            bulletSpeed = f; // 5.5f 子弹飞行速度
            bulletLifetime = f; // 200f 子弹最长存在时间
            shootEffect = Fx.; // shootBig2 发射特效
            smokeEffect = Fx.; // shootBigSmoke2 烟雾特效
            receiveEffect = Fx.; // mineBig 接收特效
            shootSound = Sounds.; // massdriver 发射音效
            receiveSound = Sounds.; // massdriverReceive 接收音效
            shootSoundVolume = f; // 0.5f 发射音量
            shake = f; // 3f 屏幕震动强度
            // Block
            update = true; // 该方块是否具有持续更新的方块实体
            solid = true; // 是否为实体
            sync = true; // 是否需要周期性的在网络中同步
            envEnabled |= Env.space; // Env.terrestrial 可运行环境
            configurable = true; // 能否被点击并打开配置界面
            hasItems = true; // 是否拥有物品模块
            hasPower = true; // 是否拥有电力模块
            outlineIcon = true; // false 是否有图标轮廓
        }};
        */

// Liquid
        /*
        liquid = new LiquidBlock("") {{
            // = new LiquidBlock("") {{
                // = new Pump("") {{
                    // = new SolidPump("") {{
                        // = new Fracker("") {{
                        itemUseTime = f; // 100f 物品消耗时间
                        // Block
                        envRequired |= Env.groundOil; // 0 必要环境
                        hasItems = true; // 是否拥有物品模块
                        ambientSound = Sounds.loopDrill; // none 空闲时发出的声音
                        ambientSoundVolume = 0.03f; // 0.05f 空闲音效音量

                    result = Liquids.; // water 抽取的液体类型
                    updateEffect = Fx.; // none 工作特效
                    updateEffectChance = f; // 0.02f 特效触发概率
                    rotateSpeed = f; // 1f 转子旋转速度
                    baseEfficiency = f; // 1f 基础效率
                    attribute = Attribute.; // 增产属性类型
                    // Block
                    envEnabled = Env.terrestrial; // Env.terrestrial 可运行环境
                    hasPower = true; // 是否拥有电力模块

                pumpAmount = f / 60f; // 0.2f 每帧泵量
                consumeTime = f; // 60f * 5f 额外消耗的时间间隔
                warmupSpeed = f; // 0.019f 预热速度
                // Block
                update = true; // 该方块是否具有持续更新的方块实体
                solid = true; // 是否为实体
                group = BlockGroup.liquids; // 属于哪个组, 同组方块可以相互替换
                envEnabled |= Env.space | Env.underwater; // Env.terrestrial 可运行环境
                hasLiquids = true; // 是否拥有液体模块
                outputsLiquid = true; // false 是否输出液体

                // = new Conduit("") {{
                    // = new ArmoredConduit("") {{
                    // Conduit
                    leaks = false;

                rotatePad = f; // 6f 旋转偏移值
                hpad = f; // rotatePad / 2f / 4f 半偏移值
                botColor = Color.valueOf(""); // 565656 管道底部颜色
                padCorners = ; // true 是否填充边角
                leaks = ; // true 是否会泄漏液体
                junctionReplacement = ; // 交叉器
                bridgeReplacement = ; // 桥
                rotBridgeReplacement = ; // 旋转桥
                // Block
                canOverdrive = false; // true 能否超速
                priority = TargetPriority.transport; // TargetPriority.base 敌人瞄准优先级
                solid = false; // 是否为实体
                underBullets = true; // 如果为true, 则该方块除非被明确指定, 否则无法被子弹击中
                floating = true; // false 是否可以放置在液体边缘
                conveyorPlacement = true; // 是否使用传送带式放置模式
                rotate = true; // 是否可旋转
                noUpdateDisabled = true; // false 当方块被禁用时，是否停止更新

                // = new LiquidRouter("") {{
                liquidPadding = f; // 0f 液体填充
                // Block
                canOverdrive = false; // true 能否超速
                solid = true; // 是否为实体
                floating = true; // false 是否可以放置在液体边缘
                noUpdateDisabled = true; // false 当方块被禁用时，是否停止更新

            // Block
            update = true; // 该方块是否具有持续更新的方块实体
            solid = true; // 是否为实体
            group = BlockGroup.liquids; // 属于哪个组, 同组方块可以相互替换
            envEnabled |= Env.space | Env.underwater; // Env.terrestrial 可运行环境
            hasLiquids = true; // 是否拥有液体模块
            outputsLiquid = true; // false 是否输出液体

            // = new LiquidBridge("") {{
            // Block
            canOverdrive = false; // true 能否超速
            group = BlockGroup.liquids; // 属于哪个组, 同组方块可以相互替换
            envEnabled = Env.any; // Env.terrestrial 可运行环境
            hasItems = false; // 是否拥有物品模块
            hasLiquids = true; // 是否拥有液体模块
            outputsLiquid = true; // false 是否输出液体

            // = new DirectionLiquidBridge("") {{
            speed = f; // 5f 液体传输速度
            liquidPadding = f; // 1f 液体缓冲量
            // Block-1
            canOverdrive = false; // true 能否超速
            group = BlockGroup.liquids; // 属于哪个组, 同组方块可以相互替换
            hasLiquids = true; // 是否拥有液体模块
            liquidCapacity = 20f; // -1f 液体容量
            outputsLiquid = true; // false 是否输出液体
            // DirectionBridge
            range = ; // 4 最大连接距离
            // Block-2
            solid = true; // 是否为实体
            group = BlockGroup.transportation; // 属于哪个组, 同组方块可以相互替换
            allowDiagonal = false; // true 能否使用对角线放置模式(ctrl)
            priority = TargetPriority.transport; // 0 蓝图建造优先级
            rotate = true; // 是否可旋转
            envEnabled = Env.space | Env.terrestrial | Env.underwater; // Env.terrestrial 可运行环境
            noUpdateDisabled = true; // false 当方块被禁用时，是否停止更新
            update = true; // 该方块是否具有持续更新的方块实体
            drawArrow = false; // true 是否绘制旋转箭头


        }};
        */

// Power
        /*
        power = new PowerBlock("") {{
            // = new PowerBlock("") {{
                // = new PowerDistributor("") {{ // 电力分配器
                    // = new Battery("") {{ // 电池
                    drawer = ; // 自定义绘制器
                    emptyLightColor = Color.valueOf(""); // f8c266 空电量灯光颜色
                    fullLightColor = Color.valueOf(""); // fb9567 满电量灯光颜色
                    // Block
                    canOverdrive = false; // true 能否超速
                    flags = EnumSet.of(BlockFlag.battery); // 方块的标志集合，用于AI索引
                    update = false; // 该方块是否具有持续更新的方块实体
                    destructible = true; // 该方块是否具有生命值并可摧毁. update为true时, 该项为false不会有任何效果
                    envEnabled |= Env.space; // Env.terrestrial 可运行环境
                    consumesPower = true; // true 是否被视为耗电单元
                    outputsPower = true; // false 是否输出电力
                    consumePowerBuffered(f); // 储存的电力

                    // = new PowerGenerator("") {{ // 发电机
                        // = new ConsumeGenerator("") {{ // 消耗型发电机
                            // = new HeaterGenerator("") {{ // 加热器发电机
                            heatOutput = f; // 10f 热量输出
                            warmupRate = f; // 0.15f 升温速率
                            // PowerGenerator
                            drawer = new DrawMulti(new DrawDefault(), new DrawHeatOutput()); // 绘制器
                            // Block
                            canOverdrive = false; // true 能否超速
                            rotate = true; // 是否可旋转
                            rotateDraw = false; // true 当rotate为true且该项为false时, 该方块在渲染时不会旋转
                            drawArrow = true; // true 是否绘制旋转箭头

                        itemDuration = f; // 120f 单个物品能产生电力的持续时间
                        warmupSpeed = f; // 0.05f 预热速度
                        effectChance = f; // 0.01f 特效触发概率
                        generateEffect = Fx.; // none 发电特效
                        consumeEffect = Fx.; // none 消耗特效
                        generateEffectRange = f; // 3f 特效范围
                        baseLightRadius = f; // 65f 基础光照半径
                        outputLiquid =  = new LiquidStack(Liquids., f); // 输出液体
                        explodeOnFull = ; // false 是否满液爆炸
                        filterItem = ; // 物品过滤器
                        filterLiquid = ; // 液体过滤器
                        itemDurationMultipliers.put(Items., f); // 物品时长倍率映射表

                        // = new ImpactReactor("") {{ // 冲击反应堆
                        warmupSpeed = f; // 0.001f 预热速度
                        itemDuration = f; // 60f 单个物品能维持反应堆运行的时间
                        // PowerGenerator
                        drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawPlasma(), new DrawDefault()); // 绘制器
                        explosionDamage = 1900 * 4; // 0 爆炸伤害
                        explodeEffect = Fx.impactReactorExplosion; // none 爆炸特效
                        explodeSound = Sounds.explosionReactor2; // none 爆炸音效
                        explosionMinWarmup = 0.3f; // 0f 触发爆炸所需的最小工作效率
                        explosionShake = 6f; // 0f 爆炸震动强度
                        explosionShakeDuration = 16f; // 6f 爆炸震动持续时间
                        // Block
                        flags = EnumSet.of(BlockFlag.reactor, BlockFlag.generator); // 方块的标志集合，用于AI索引
                        envEnabled = Env.any; // Env.terrestrial 可运行环境
                        hasItems = true; // 是否拥有物品模块
                        hasLiquids = true; // 是否拥有液体模块
                        liquidCapacity = 30f; // -1f 液体容量
                        hasPower = true; // 是否拥有电力模块
                        consumesPower = true; // true 是否被视为耗电单元
                        outputsPower = true; // false 是否输出电力
                        emitLight = true; // false 是否调用drawLight()
                        lightRadius = 115f; // 60f 光照半径

                        // = new NuclearReactor("") {{ // 核反应堆
                        lightColor = Color.valueOf(""); // 7f19ea 基础发光颜色
                        coolColor = new Color(1, 1, 1, 0f); // 冷却状态颜色
                        hotColor = Color.valueOf(""); // ff9575a3 过热状态颜色
                        itemDuration = f; // 120 单个燃料持续时间
                        heating = f / 60f; // 0.01f 加热速率
                        heatOutput = f; // 15f 热量输出
                        heatWarmupRate = f; // 1f 热升温速率
                        ambientCooldownTime = f * 60f; // 60f * 20f 环境冷却时间
                        smokeThreshold = f; // 0.3f 冒烟阈值
                        flashThreshold = f; // 0.46f 闪烁阈值
                        coolantPower = f; // 0.5f 冷却功率
                        fuelItem = Items.; // thorium 燃料类型
                        // PowerGenerator
                        explosionRadius = 19; // 12 爆炸半径
                        explosionDamage = 1250 * 4; // 0 爆炸伤害
                        explodeEffect = Fx.reactorExplosion; // none 爆炸特效
                        explodeSound = Sounds.explosionReactor; // none 爆炸音效
                        explosionShake = 6f; // 0f 爆炸震动强度
                        explosionShakeDuration = 16f; // 6f 爆炸震动持续时间
                        // Block
                        flags = EnumSet.of(BlockFlag.reactor, BlockFlag.generator); // 方块的标志集合，用于AI索引
                        schematicPriority = -5; // 0 蓝图建造优先级
                        rebuildable = false; // true 是否可重建
                        envEnabled = Env.any; // Env.terrestrial 可运行环境
                        hasItems = true; // 是否拥有物品模块
                        itemCapacity = 30; // 10 物品容量
                        hasLiquids = true; // 是否拥有液体模块
                        liquidCapacity = 30; // -1f 液体容量
                        emitLight = true; // false 是否调用drawLight()

                        // = new SolarGenerator("") {{/ 太阳能
                        // Block
                        flags = EnumSet.of(); // 方块的标志集合，用于AI索引
                        envEnabled = Env.any; // Env.terrestrial 可运行环境

                        // = new ThermalGenerator("") {{ // 地热发电机
                        generateEffect = Fx.; // none 发电特效
                        effectChance = f; // 0.05f 特效概率
                        minEfficiency = f; // 0f 最低效率
                        displayEfficiencyScale = f; // 1f 显示效率的缩放因子
                        displayEfficiency = ; // true UI界面是否显示当前效率百分比
                        outputLiquid = Liquids.; // 输出液体
                        attribute = Attribute.heat; // 依赖属性
                        // Block
                        noUpdateDisabled = true; // false 当方块被禁用时，是否停止更新

                        // = new VariableReactor("") {{ // 可变反应堆
                        maxHeat = f; // 100f 最大热量
                        unstableSpeed = f / 60f; // 1f / 60f / 3f 不稳定性增长速度
                        warmupSpeed = f; // 0.1f 预热速度
                        effect = Fx.; // fluxVapor 工作特效类型
                        effectChance = f; // 0.05f 工作特效概率
                        effectColor = Color.valueOf(""); // ffdf9d 工作特效颜色
                        flashThreshold = f; // 0.01f 闪烁阈值
                        flashAlpha = f; // 0.4f 闪烁透明度
                        flashSpeed = f; // 7f 闪烁速度
                        flashColor1 = Color.valueOf(""); // red 闪烁颜色渐变1
                        flashColor2 = Color.valueOf(""); // 89e8b6 闪烁颜色渐变2
                        // PowerGenerator
                        powerProduction = 20f; // 发电量
                        explosionRadius = 16; // 12 爆炸半径
                        explosionDamage = 1500; // 0 爆炸伤害
                        explodeEffect = new MultiEffect(Fx.bigShockwave, new WrapEffect(Fx.titanSmoke, Color.valueOf("e3ae6f"))); // none 爆炸特效
                        explodeSound = Sounds.explosionReactor2; // none 爆炸音效
                        explosionPuddles = 70; // 10 爆炸后产生的水坑数量
                        explosionPuddleRange = tilesize * 6f; // tilesize * 2f 水坑散布范围
                        explosionPuddleAmount = 100f; // 100f 每个水坑的液体量
                        explosionPuddleLiquid = Liquids.slag; // 水坑的液体类型
                        // Block
                        rebuildable = false; // true 是否可重建

                    powerProduction = f / 60f; // 发电量
                    generationType = Stat.; // basePowerGeneration 统计界面显示时使用的统计类型
                    drawer = new DrawDefault(); // 绘制器
                    explosionRadius = ; // 12 爆炸半径
                    explosionDamage = ; // 0 爆炸伤害
                    explodeEffect = Fx.; // none 爆炸特效
                    explodeSound = Sounds.; // none 爆炸音效
                    explosionPuddles = ; // 10 爆炸后产生的水坑数量
                    explosionPuddleRange = f; // tilesize * 2f 水坑散布范围
                    explosionPuddleAmount = f; // 100f 每个水坑的液体量
                    explosionPuddleLiquid = Liquids.; // 水坑的液体类型
                    explosionMinWarmup = f; // 0f 触发爆炸所需的最小工作效率
                    explosionShake = f; // 0f 爆炸震动强度
                    explosionShakeDuration = f; // 6f 爆炸震动持续时间
                    // Block
                    baseExplosiveness = 5f; // 0f 基础爆炸性
                    flags = EnumSet.of(BlockFlag.generator); // 方块的标志集合，用于AI索引
                    sync = true; // 是否需要周期性的在网络中同步

                    // = new PowerNode("") {{ // 电力节点
                        // = new LongPowerNode("") {{ // 长距离电力节点
                        glowColor = Color.valueOf("cbfd81").a(0.45f); // 光晕颜色
                        glowScl = f; // 16f 光晕缩放速度
                        glowMag = f; // 0.6f 光晕幅度
                        // PowerNode
                        drawRange = false; // true 放置预览时是否显示连接范围

                    laserRange = f; // 6 最大连接距离
                    maxNodes = ; // 3 最大连接数
                    autolink = ; // true 是否自动连接
                    drawRange = ; // true 放置预览时是否显示连接范围
                    sameBlockConnection = ; // false 是否优先连接同类型的方块
                    laserScale = f; // 0.25f 激光缩放
                    powerLayer = Layer.; // power 图层
                    laserColor1 = Color.valueOf(""); // white 激光颜色1
                    laserColor2 = Color.valueOf(""); // Pal.powerLight 激光颜色2
                    // Block
                    canOverdrive = false; // true 能否超速
                    update = false; // 该方块是否具有持续更新的方块实体
                    delayLandingConfig = true; // 如果为true, 则在着陆构建动画中, 该方块的配置操作会被延迟, 未来可能会被移除
                    swapDiagonalPlacement = true; // 是否交换对角线放置模式
                    schematicPriority = -10; // 0 蓝图建造优先级
                    destructible = true; // 该方块是否具有生命值并可摧毁. update为true时, 该项为false不会有任何效果
                    envEnabled |= Env.space; // Env.terrestrial 可运行环境
                    configurable = true; // 能否被点击并打开配置界面
                    drawDisabled = false; // true 是否绘制禁用状态
                    consumesPower = false; // true 是否被视为耗电单元
                    outputsPower = false; // false 是否输出电力

                // Block
                consumesPower = false; // true 是否被视为耗电单元
                outputsPower = true; // false 是否输出电力

                // = new BeamNode("") {{ // 激光节点
                range = ; // 5 最大连接距离
                laserColor1 = Color.valueOf(""); // white 激光颜色1
                laserColor2 = Color.valueOf(""); // ffd9c2 激光颜色2
                pulseScl = f; // 7 脉冲缩放速度
                pulseMag = f; // 0.05f 脉冲幅度
                laserWidth = f; // 0.4f 激光宽度
                // Block
                priority = TargetPriority.transport; // TargetPriority.base 敌人瞄准优先级
                underBullets = true; // 如果为true, 则该方块除非被明确指定, 否则无法被子弹击中
                allowDiagonal = false; // true 能否使用对角线放置模式(ctrl)
                envEnabled |= Env.space; // Env.terrestrial 可运行环境
                drawDisabled = false; // true 是否绘制禁用状态
                consumesPower = false; // true 是否被视为耗电单元
                outputsPower = false; // false 是否输出电力

            // Block
            update = true; // 该方块是否具有持续更新的方块实体
            solid = true; // 是否为实体
            group = BlockGroup.power; // 属于哪个组, 同组方块可以相互替换
            hasPower = true; // 是否拥有电力模块

            // = new LightBlock("") {{
            brightness = f; // 0.9f 亮度
            radius = f; // 200f 光照半径
            // Block
            update = true; // 该方块是否具有持续更新的方块实体
            swapDiagonalPlacement = true; // 是否交换对角线放置模式
            envEnabled |= Env.space; // Env.terrestrial 可运行环境
            saveConfig = true; // false 是否保存上一次的配置并应用到新方块
            configurable = true; // 能否被点击并打开配置界面
            hasPower = true; // 是否拥有电力模块

            // = new PowerDiode("") {{ // 二极管
            // Block
            insulated = true; // false 是否具有绝缘属性
            update = true; // 该方块是否具有持续更新的方块实体
            solid = true; // 是否为实体
            group = BlockGroup.power; // 属于哪个组, 同组方块可以相互替换
            schematicPriority = 10; // 0 蓝图建造优先级
            rotate = true; // 是否可旋转
            envEnabled |= Env.space; // Env.terrestrial 可运行环境
            noUpdateDisabled = true; // false 当方块被禁用时，是否停止更新
        }};
        */

// Wall
        /*
        Wall = new Wall("") {{
            // = new Wall("") {{
                // = new ShieldWall("") {{
                shieldHealth = f; // 900f 护盾容量
                breakCooldown = f * 60f; // 60f * 10f 过热时的冷却时间
                regenSpeed = f; // 2f 未过热时的护盾恢复速度
                glowColor = Color.valueOf("ff7531").a(0.5f); // 光晕颜色
                glowMag = f; // 0.6f 光晕脉动幅度
                glowScl = f; // 8f 光晕脉动速度
                glowRegion = ; // 光晕纹理
                // Block
                update = true; // 该方块是否具有持续更新的方块实体

                // = new Door("") {{
                openfx = Fx.; // dooropen 开门特效
                closefx = Fx.; // doorclose 关门特效
                doorSound = Sounds.; // door 开关门音效
                chainEffect = ; // false 是否连锁触发特效
                openRegion = ; // 开门状态纹理
                // Block
                solid = false; // 是否为实体
                solidifes = true; // 是否为实心方块
                consumesTap = true; // 当方块被点击时，是否拦截touchDown事件

                // = new AutoDoor("") {{
                checkInterval = f; // 20f 检测时间间隔
                openfx = Fx.; // dooropen 开门特效
                closefx = Fx.; // doorclose 关门特效
                doorSound = Sounds.; // door 开关门音效
                openRegion = ; // 开门状态纹理
                triggerMargin = f; // 12f 触发范围余量
                // Block
                update = true; // 该方块是否具有持续更新的方块实体
                solid = false; // 是否为实体
                solidifes = true; // 是否为实心方块
                teamPassable = true; // 如果为true, 则被视为同阵营的非实体方块
                drawDisabled = true; // true 是否绘制禁用状态
                noUpdateDisabled = true; // false 当方块被禁用时，是否停止更新

            // 闪电
            lightningChance = f; // -1f 触发闪电几率
            lightningDamage = f; // 20f 闪电伤害
            lightningLength = ; // 17 闪电长度
            lightningColor = Color.valueOf(""); // Pal.surge 闪电颜色
            lightningSound = Sounds.; // shootArc 闪电音效
            // 反弹子弹
            chanceDeflect = f; // -1f 反弹几率
            flashHit = ; // 反弹时是否产生闪光
            flashColor = Color.valueOf(""); // white 反弹闪光颜色
            deflectSound = Sounds.; // none 反弹音效

            // Block
            canOverdrive = false; // true 能否超速
            priority = TargetPriority.wall; // TargetPriority.base 敌人瞄准优先级
            solid = true; // 是否为实体
            group = BlockGroup.walls; // 属于哪个组, 同组方块可以相互替换
            buildCostMultiplier = 6f; // -1f 建造此方块的速度倍率
            destructible = true; // 该方块是否具有生命值并可摧毁. update为true时, 该项为false不会有任何效果
            crushDamageMultiplier = 5f; // 1f 碾压伤害倍率
            envEnabled = Env.any; // Env.terrestrial 可运行环境
            drawDisabled = false; // true 是否绘制禁用状态
        }};
        */

// GenericCrafter


// 其他
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
            // 载荷
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
            consumePowerBuffered(f); // 储存的电力

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
        floor = new Floor("", variants) {{
            edge = ; // "stone" // 边缘填充纹理
            speedMultiplier = f; // 1f 移动速度倍率
            dragMultiplier = f; // 1f 阻力倍率
            damageTaken = f; // 0f 对上方单位造成的伤害
            drownTime = f; // 0f 沉没时间
            walkEffect = Fx.; // none 上方单位移动时产生的粒子效果
            walkSound = Sounds.; // none 上方单位移动时产生的音效
            walkSoundVolume = f; // 0.1f 移动音效音量
            walkSoundPitchMin = f; // 0.8f 移动音效音高范围
            walkSoundPitchMax = f; // 1.2f
            drownUpdateEffect = Fx.; // bubble 沉没时产生的粒子效果
            status = StatusEffects.; // none 对上方单位造成的状态效果
            statusDuration = f; // 60f 状态效果的时长
            liquidDrop = Liquids.; // 泵可抽取的液体
            liquidMultiplier = f; // 1f 泵送液体的倍率
            isLiquid = ; // 是否为液体
            overlayAlpha = f; // 0.65f 对于液体, 上方覆盖层的不透明度
            supportsOverlay = ; // false 是否支持覆盖层地板
            shallow = ; // false 是否为浅水
            blendGroup = ; // this 不绘制边缘的方块组
            oreDefault = ; // false 对于矿石, 是否默认在地图中生成
            oreScale = ; // 24f 矿石生成参数
            oreThreshold = ; // 0.828f
            wall = Blocks.; // 对应的墙壁
            decoration = Blocks.; // 对应的装饰块
            canShadow = ; // true 单位能否在其上绘制阴影
            forceDrawLight = ; // false 这个地板是否忽略覆盖层的阻光标志
            needsSurface = ; // true 这个覆盖层是否需要放在表面上
            allowCorePlacement = ; // false 核心能否放置在该地板上
            wallOre = ; // false 该矿石能否放置在墙上
            tilingVariants = ; // 0 大型平铺变体的数量
            autotile = ; // false 是否使用自动拼接
            autotileMidVariants = ; // 1 自动拼接中间区域的随机变体数量
            autotileVariants = ; // 1 主自动拼接精灵的变体数量
            drawEdgeIn = ; // true 是否在其他地板上绘制这个地板的边缘
            drawEdgeOut = ; // true 是否将这个地板的边缘绘制到其他地板上

            placeableLiquid = true; // 能否放置在任何液体上
            allowRectanglePlacement = true; // 是否为矩形放置, 而非线性放置
            ignoreBuildDarkness = true; // 能否在黑暗区域放置, 用于编辑静态墙
            obstructsLight = false; // 是否遮挡其他方块发出的光线
            placeEffect = Fx.rotateBlock; // 放置效果

            itemDrop = Items.; // 被钻头开采时, 能够开采出的物品
            playerUnmineable = ; // false 如果为false, 该方块无法被玩家手动开采
            attributes.set(Attribute., ); // 对某些事物的效率加成

        }};
        */
        /*
        block = new Block("") {{
            hasItems = ; // 是否拥有物品模块
            hasLiquids = ; // 是否拥有液体模块
            hasPower = ; // 是否拥有电力模块
            outputsLiquid = ; // false 是否输出液体
            consumesPower = ; // true 是否被视为耗电单元
            outputsPower = ; // false 是否输出电力
            connectedPower = ; // true 能否被节点连接
            conductivePower = ; // false 能否通过接触传导电力
            outputsPayload = ; // false 能否输出载荷
            acceptsUnitPayloads = ; // false 能否输入载荷
            acceptsPayload = ; // false 载荷是否尝试进入该方块
            acceptsItems = ; // false 是否与附近的传送带连接
            alwaysAllowDeposit = ; // false 是否忽略onlyDepositCore规则
            depositCooldown = f; // -1f 玩家向该方块存入物品时的冷却时间
            separateItemCapacity = ; // false 物品容量是否独立计算
            itemCapacity = ; // 10 物品容量
            liquidCapacity = f; // -1f 液体容量
            liquidPressure = f; // 1f 液体输出速率
            outputFacing = ; // true 是否按方块朝向输出
            noSideBlend = ; // false 是否接受来自侧面的输入
            displayFlow = ; // true 显示液体传输速率
            inEditor = ; // true 编辑器中是否可见
            editorConfigurable = ; // 是否可在编辑器中配置
            saveConfig = ; // false 是否保存上一次的配置并应用到新方块
            copyConfig = ; // true 能否通过选取操作复制配置
            clearOnDoubleTap = ; // true 能否通过双击清除配置
            update = ; // 该方块是否具有持续更新的方块实体
            destructible = ; // 该方块是否具有生命值并可摧毁. update为true时, 该项为false不会有任何效果
            unloadable = ; // true 装卸器能否作用于该方块
            isDuct = ; // false 该方块是否为管道
            allowResupply = ; // false 单位能否从该方块拿取物品
            solid = ; // 是否为实体
            solidifes = ; // 是否为实心方块
            teamPassable = ; // 如果为true, 则被视为同阵营的非实体方块
            underBullets = ; // 如果为true, 则该方块除非被明确指定, 否则无法被子弹击中
            rotate = ; // 是否可旋转
            rotateDraw = ; // true 当rotate为true且该项为false时, 该方块在渲染时不会旋转
            rotateDrawEditor = ; // true 当rotate为true且该项为false时, 该方块在编辑器中渲染时不会旋转
            visualRotationOffset = f; // 0f 视觉旋转偏移
            lockRotation = ; // true 当rotate为false且该项为true时, 该方块放置时旋转将锁定到0(默认)
            ignoreLineRotation = ; // false 如果为true, 该方块的朝向不会朝向拖动方向
            invertFlip = ; // false 如果为true, 则放置或保存蓝图时不会旋转
            variants = ; // 0 不同的变体贴图数量
            drawArrow = ; // true 是否绘制旋转箭头
            drawTeamOverlay = ; // true 是否绘制队伍标识
            saveData = ; // 是否保存数据到世界存档
            breakable = ; // 是否可以用右键直接拆除这个方块
            unitMoveBreakable = ; // 如果为true, 某些单位踩到或移动到该方块上时会破坏该方块
            rebuildable = ; // true 是否可重建
            privileged = ; // false 对于逻辑相关方块, 能否被普通逻辑处理器更改
            requiresWater = ; // false 是否只能放置在水上
            placeableLiquid = ; // false 能否放置在任何液体上
            placeablePlayer = ; // true 能否通过建筑菜单直接放置
            placeableOn = ; // true 其他方块能否放置在这个方块上面
            insulated = ; // false 是否具有绝缘属性
            squareSprite = ; // true 贴图是否为完整方块
            absorbLasers = ; // false 能否吸收激光
            enableDrawStatus = ; // true 是否绘制状态
            drawDisabled = ; // true 是否绘制禁用状态
            autoResetEnabled = ; // true 当逻辑块长时间没有交互时，是否自动重置其启用状态
            noUpdateDisabled = ; // false 当方块被禁用时，是否停止更新
            updateInUnits = ; // true 当方块作为单位搬运的载荷时，是否继续更新
            alwaysUpdateInUnits = ; // false 作为载荷时, 是否无视实验性游戏规则，始终更新
            canPickup = ; // true 能否被搬起
            deconstructDropAllLiquid = ; // false 如果为false, 则在解构时仅输出可焚烧液体, 否则输出所有液体
            mapColor = ; // 小地图颜色
            useColor = ; // true 是否在小地图中使用这个方块的颜色
            itemDrop = Items.; // 用于钻头, 能够开采的物品
            playerUnmineable = ; // false 如果为false, 该方块无法被玩家手动开采
            attributes.set(Attribute., ); // 对某些事物的效率加成
            scaledHealth = f; // -1f 每个格子所占的生命值基数, 结果为: health = size * size * scaledHealth并四舍五入至5的倍数
            health = ; // -1 生命值, 跳过scaledHealth
            armor = f; // 0f 护甲
            baseExplosiveness = ; // 0f 基础爆炸性
            explosivenessScale = ; // 1f 爆炸性系数
            flammabilityScale = ; // 1f 易燃性系数
            baseShake = ; // 3f 被摧毁时的屏幕震动
            destroyBullet = new () {{}}; // 被摧毁时产生的子弹
            destroyBulletSameTeam = ; // false 被摧毁时产生子弹的阵营
            lightLiquid = Liquids.; // 用于光照效果的液体
            drawCracks = ; // true 损坏时是否产生裂纹
            createRubble = ; // true 被摧毁时是否产生废墟
            floating = ; // false 是否可以放置在液体边缘
            size = ; // 1 方块大小
            offset = f; // 0f 方块在网格中的偏移量
            clipSize = f; // -1f 方块的贴图裁剪范围大小
            lightClipSize = f; // 仅用于光照的裁剪范围
            placeOverlapRange = f; // 50f 启用placeRangeCheck规则时, 检测敌方方块的范围
            crushDamageMultiplier = f; // 1f 碾压伤害倍率
            crushFragile = ; // false 如果为true, 当坦克的crushFragile同为true时, 会立刻破坏该方块
            timers = ; // 0 计时器的最大值
            cacheLayer = CacheLayer.; // 缓存渲染层类型
            fillsTile = ; // true 如果为 false，即使被缓存，也会在方块下方绘制地板
            forceDark = ; // false 是否强制让这个方块被黑暗/战争迷雾覆盖
            alwaysReplace = ; // false 是否在所有情况下都可以被替换
            replaceable = ; // true 能否被替换
            group = BlockGroup.; // 属于哪个组, 同组方块可以相互替换
            flags = EnumSet.of(BlockFlag.); // 方块的标志集合，用于AI索引
            priority = f; // TargetPriority.base 敌人瞄准优先级
            unitCapModifier = ; // 0 提供的单位容量, 仅当方块的标志包含unitModifier时生效
            configurable = ; // 能否被点击并打开配置界面
            configureSound = Sounds.; // click 进行配置时产生的音效
            ignoreResizeConfig = ; // 如果为true, 在地图大小改变时, 不会有名为transform的点配置
            commandable = ; // 在指挥模式下能否被选中
            allowConfigInventory = ; // true 物品库存是否与配置界面一起显示
            selectionRows = ; // 5 选择菜单的行数
            selectionColumns = ; // 4 选择菜单的列数
            logicConfigurable = ; // false 能否被逻辑配置
            delayLandingConfig = ; // 如果为true, 则在着陆构建动画中, 该方块的配置操作会被延迟, 未来可能会被移除
            consumesTap = ; // 当方块被点击时，是否拦截touchDown事件
            drawLiquidLight = ; // true 是否绘制液体的发光效果

            // 环境需求
            envRequired = Env. | Env.; // 0 必要环境
            envEnabled = Env. | Env.; // Env.terrestrial 可运行环境
            envDisabled = Env. | Env.; // 0 无法运行的环境

            sync = ; // 是否需要周期性的在网络中同步
            conveyorPlacement = ; // 是否使用传送带式放置模式
            allowDiagonal = ; // true 能否使用对角线放置模式(ctrl)
            swapDiagonalPlacement = ; // 是否交换对角线放置模式
            allowRectanglePlacement = ; // false 是否为矩形放置, 而非线性放置
            schematicPriority = ; // 0 蓝图建造优先级
            hasColor = ; //false 是否具有小地图颜色
            targetable = ; // true 单位是否瞄准此方块
            attacks = ; // false 能否攻击
            suppressable = ; // false 是否与修复有关
            canOverdrive = ; // true 能否超速
            outlineColor = Color.valueOf(""); // 404049 方块图标的轮廓颜色
            outlineIcon = ; // false 是否有图标轮廓
            outlineRadius = ; // 4 轮廓宽度
            outlinedIcon = ; // -1 哪个图标区域会添加轮廓
            hasShadow = ; // true 下方是否有阴影
            customShadow = ; // false 是否绘制自定义阴影(VeName-shadow)
            placePitchChange = ; // true 建造时是否改变建造音效的音高
            breakPitchChange = ; // true 拆除时是否改变拆除音效的音高
            placeSound = Sounds.; // unset 建造音效
            breakSound = Sounds.; // unset 拆除音效
            destroySound = Sounds.; // unset 摧毁音效
            destroySoundVolume = f; // 1f 摧毁音效音量
            destroyPitchMin = f; // 1f 摧毁音效音调范围
            destroyPitchMax = f; // 1f
            albedo = f; // 0f 反射率
            lightColor = Color.valueOf(""); // 方块自身发出的环境光颜色
            emitLight = ; // false 是否调用drawLight()
            obstructsLight = ; // true 是否遮挡其他方块发出的光线
            lightRadius = f; // 60f 光照半径

            fogRadius = ; // -1 能揭示多大范围的战争迷雾

            ambientSound = Sounds.; // none 空闲时发出的声音
            ambientSoundVolume = f; // 0.05f 空闲音效音量

            requirements(Category.distribution, BuildVisibility.hidden, ItemStack.with(Items., ));
            buildTime = f; // -1f 建造时间
            buildCostMultiplier = f; // -1f 建造此方块的速度倍率
            deconstructThreshold = f; // 0f
            instantDeconstruct = ; // false 是否立即拆除, 不返还资源
            ignoreBuildDarkness = ; // false 能否在黑暗区域放置, 用于编辑静态墙
            placeEffect = Fx.; // placeBlock 放置效果
            breakEffect = Fx.; // breakBlock 拆除效果
            destroyEffect = Fx.; // dynamicExplosion 摧毁效果
            researchCostMultiplier = f; // 1f 研究成本倍数
            researchCostMultipliers.put(Items., f); // 每种物品的研究成本
            researchCost = ItemStack.with(Items., ); // 覆盖研究成本
            forceTeam = ; // 所有这个方块全部强制属于这个队伍
            instantTransfer = ; // false 是否支持瞬时传输(光传)
            quickRotate = ; // true 放置后能否旋转
            allowDerelictRepair = ; // true 该方块的废墟能否通过点击修复

            consumeLiquid(Liquids., f / 60f); // + .boost(); 消耗的液体 + 强化
            consumeLiquids(LiquidStack.with(Liquids., f / 60f));
            consumePower(f / 60f); // 消耗的电力
            consumeItem(Items., ); // 消耗的物品
            consumeItems(ItemStack.with(Items., , Items., ));
        }};
        */


// Planets
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


// Sector
        /*
        sector = new SectorPreset("", Planets., ) {{
            planet = Planets.; // 所在的星球
            sector = ; // 所在的区块号
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


// Effect
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
            sizeInterp = Interp.; // null 粒子大小的专用插值
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
            sides = ; // -1 多边形边数
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
            renderer = ; // 特效的渲染逻辑
            lifetime = f; // 50f 特效存在时间
            clip = f; // 特效的裁剪范围
            startDelay = f; // 特效开始前的延迟时间
            baseRotation = f; // 基础旋转角度
            followParent = ; // true 是否跟随父级单位移动
            rotWithParent = ; // 是否跟随父级单位旋转
            layer = Layer.; // effect 特效的渲染层
            layerDuration = f; // 特定层的持续时间
        }};
        */


// Bullet
        /*
        basicBullet = new BulletType() {{
            // = new BasicBulletType(speed, damage, bulletSprite) {{
                // = new ArtilleryBulletType(speed, damage) {{ // 火炮类型(冰雹类型)
                trailMult = f; // 1f 拖尾效果的强度
                trailSize = f; // 4f 拖尾的大小
                // BasicBulletType
                shrinkX = 0.15f; // 0f X轴缩放收缩量
                shrinkY = 0.5f; // 0.5f Y轴缩放收缩量
                shrinkInterp = Interp.slope; // linear 收缩效果的插值方式
                // Bullet
                scaleLife = true; // 是否根据距离缩放存在时间
                speed = 1f; // 1f 子弹速度
                damage = 1f; // 1f 直接命中伤害
                collidesTiles = false; // true 是否与地形碰撞
                collidesAir = false; // true 是否与空中单位碰撞
                collides = false; // true 是否与任何东西碰撞
                hitEffect = Fx.flakExplosion; // hitBulletSmall 命中效果
                shootEffect = Fx.shootBig; // shootSmall 发射效果
                hitShake = 1f; // 0f 命中时的屏幕震动
                trailEffect = Fx.artilleryTrail; // missileTrail 尾迹特效
                hitSound = Sounds.explosionArtillery; // none 命中音效

                // = new BombBulletType(damage, radius, "sprite") {{ // 炸弹类型(天垠类型)
                // BasicBulletType
                shrinkY = 0.7f; // 0.5f Y轴缩放收缩量
                // Bullet
                lifetime = 30f; // 40f 子弹存在时间
                speed = 0.7f; // 1f 子弹速度
                drag = 0.05f; // 0f 阻力大小
                keepVelocity = false; // true 是否继承射手速度
                damage = 0f; // 1f 直接命中伤害
                collidesTiles = false; // true 是否与地形碰撞
                collidesAir = false; // true 是否与空中单位碰撞
                collides = false;  // true 是否与任何东西碰撞
                splashDamage = damage; // 0f 溅射伤害
                splashDamageRadius = radius; // -1f 溅射伤害半径
                hitSound = Sounds.explosion; // none 命中音效

                // = new EmpBulletType() {{ // EMP类型(龙王类型)
                radius = f; // 100f EMP效果半径
                timeIncrease = f; // 2.5f 己方倍率(超速至)
                powerSclDecrease = f; // 0.2f 敌方倍率(减速至)
                timeDuration = f; // 60f * 10f 效果总持续时间
                powerDamageScl = f; // 2f 对电力建筑的伤害倍率
                hitPowerEffect = Fx.; // hitEmpSpark 命中电力建筑时的特效
                chainEffect = Fx.; // chainEmp 连锁跳转特效
                applyEffect = Fx.; // heal 施加状态时的特效
                hitUnits = ; // true 是否影响单位
                unitDamageScl = f; // 0.7f 对单位伤害倍率

                // = new FlakBulletType(speed, damage) {{ // 防空炮类型(分裂类型)
                explodeRange = f; // 30f 触发爆炸的目标距离范围
                explodeDelay = f; // 5f 命中后的爆炸延迟
                flakDelay = f; // 0f 首次引爆延迟
                flakInterval = f; // 6f 后续引爆间隔
                // BasicBulletType
                width = 8f; // 5f 子弹宽度
                height = 10f; // 7f 子弹高度
                // Bullet
                speed = 1f; // 1f 子弹速度
                damage = 1f; // 1f 直接命中伤害
                collidesGround = false; // true 是否与地面单位碰撞
                splashDamageRadius = 34f; // -1f 溅射伤害半径
                splashDamage = 15f;  // 0f 溅射伤害
                hitEffect = Fx.flakExplosionBig; // hitBulletSmall 命中效果

                // = new InterceptorBulletType(speed, damage, bulletSprite) {{ // 点防拦截类型

                // = new LaserBoltBulletType(speed, damage) {{ // 激光子弹类型(新星类型)
                width = f; // 2f 激光束宽度
                height = f; // 7f 激光束长度
                // Bullet
                speed = 1f; // 1f 子弹速度
                damage = 1f; // 1f 直接命中伤害
                hittable = false; // true 是否能被点防消除
                reflectable = false; // true 是否可被反射
                hitEffect = Fx.hitLaser; // hitBulletSmall 命中效果
                despawnEffect = Fx.hitLaser; // hitBulletSmall 消失效果
                smokeEffect = Fx.hitLaser; // shootSmallSmoke 烟雾效果
                lightOpacity = 0.6f; // 0.3f 光照透明度
                lightColor = Pal.heal; // Pal.powerLight 光照颜色

                // = new MassDriverBolt() {{ // 质驱子弹类型
                // BasicBulletType
                width = 11f; // 5f 子弹宽度
                height = 13f; // 7f 子弹高度
                shrinkY = 0f; // 0.5f Y轴缩放收缩量
                sprite = "shell"; // 主贴图
                // Bullet
                speed = 1f; // 1f 子弹速度
                damage = 75f; // 1f 直接命中伤害
                lifetime = 1f; // 40f 子弹存在时间
                collidesTiles = false; // true 是否与地形碰撞
                hitEffect = Fx.hitBulletBig; // hitBulletSmall 命中效果
                despawnEffect = Fx.smeltsmoke; // hitBulletSmall 消失效果

                // = new MissileBulletType(speed, damage, bulletSprite) {{ // 导弹类型(蜂群类型)
                backColor = Pal.missileYellowBack; // Pal.bulletYellowBack 底部颜色
                frontColor = Pal.missileYellow; // Pal.bulletYellow 顶部颜色
                width = 8f; // 5f 子弹宽度
                height = 8f; // 7f 子弹高度
                shrinkY = 0f; // 0.5f Y轴缩放收缩量
                // Bullet
                lifetime = 52f; // 40f 子弹存在时间
                speed = 1f; // 1f 子弹速度
                damage = 1f; // 1f 直接命中伤害
                homingPower = 0.08f; // 0f 制导力度
                trailChance = 0.2f; // -0.0001f 每帧产生尾迹特效的概率
                hitSound = Sounds.explosion; // none 命中音效

            backColor = Color.valueOf(""); // Pal.bulletYellowBack 底部颜色
            frontColor = Color.valueOf(""); // Pal.bulletYellow 顶部颜色
            mixColorFrom = Color.valueOf(""); // 混合颜色的起始值
            mixColorTo = Color.valueOf(""); // 混合颜色的终止值
            width = f; // 5f 子弹宽度
            height = f; // 7f 子弹高度
            shrinkX = f; // 0f X轴缩放收缩量
            shrinkY = f; // 0.5f Y轴缩放收缩量
            shrinkInterp = Interp.; // linear 收缩效果的插值方式
            spin = f; // 0 每帧旋转速度
            rotationOffset = f; // 0f 旋转角度偏移量
            sprite = ""; // 主贴图
            backSprite = ""; // 底部贴图

            // = new ContinuousBulletType() {{ // 连续子弹类型(激光等)
                // = new ContinuousFlameBulletType(damage) {{ // 连续火焰子弹类型(升华类型)
                lightStroke = f; // 40f 光照线条粗细
                width = f; // 3.7f 火焰宽度
                oscScl = f; // 1.2f 火焰摆动频率
                oscMag = f; // 0.02f 火焰摆动幅度
                divisions = ; // 25 火焰分段数量
                drawFlare = ; // true 是否绘制闪光
                flareColor = Color.valueOf(""); // e189f5 闪光颜色
                flareWidth = f; // 3f 闪光宽度
                flareInnerScl = f; // 0.5f 内部闪光缩放
                flareLength = f; // 40f 闪光长度
                flareInnerLenScl = f; // 0.5f 内部闪光长度缩放
                flareLayer = Layer.; // bullet - 0.0001f 闪光渲染层
                flareRotSpeed = f; // 1.2f 闪光旋转速度
                rotateFlare = ; // false 闪光是否旋转
                lengthInterp = Interp.; // slope 长度插值方式
                lengthWidthPans = ; // 火焰各段的[长度, 宽度, 偏移]数组
                colors = ; // 火焰颜色数组(从根部到尖端渐变)
                // ContinuousBulletType
                length = 120f; // 220f 最大攻击距离
                // Bullet
                lifetime = 16f; // 40f 子弹存在时间
                optimalLifeFract = 0.5f; // 0f 达到最佳效果需要的时间
                pierceArmor = true; // false 是否无视护甲
                laserAbsorb = false; // true 是否被塑钢墙吸收(用于激光)
                hitSize = 4; // 4 碰撞箱大小
                ammoMultiplier = 1f; // 2f 装填倍率
                drawSize = 420f; // 40f 子弹的渲染裁剪大小
                hitEffect = Fx.hitFlameBeam; // hitBulletSmall 命中效果
                hitColor = colors[1].cpy().a(1f); // white 命中效果颜色
                lightOpacity = 0.7f; // 0.3f 光照透明度
                lightColor = hitColor; // Pal.powerLight 光照颜色

                // = new ContinuousLaserBulletType(damage) {{ // 连续激光类型(熔毁类型)
                fadeTime = f; // 16f 激光淡入/淡出时间
                lightStroke = f; // 40f 光照线条粗细
                divisions = ; // 13 激光分段数量
                strokeFrom = f; // 2f 线条粗细范围
                strokeTo = f; // 0.5f
                pointyScaling = f; // 0.75f 尖端缩放比例
                backLength = f; // 7f 激光末端长度
                frontLength = f; // 35f 激光前端长度
                width = f; // 9f 激光基础宽度
                oscScl = f; // 0.8f 宽度摆动频率
                oscMag = f; // 1.5f 宽度摆动幅度
                colors = new Color[] {
                        Color.valueOf("ec745855"),
                        Color.valueOf("ec7458aa"),
                        Color.valueOf("ff9c5a"),
                        Color.white
                }; // 激光颜色渐变数组
                // ContinuousBulletType
                shake = 1f; // 0f 屏幕震动强度
                largeHit = true; // false 是否使用大型命中效果
                // Bullet
                lifetime = 16f; // 40f 子弹存在时间
                hitSize = 4; // 4 碰撞箱大小
                incendAmount = 1; // 0 尝试生成的火焰数量
                incendSpread = 5; // 8f 火焰的扩散程度
                incendChance = 0.4f; // 1f 火焰生成概率
                drawSize = 420f; // 40f 子弹的渲染裁剪大小
                hitEffect = Fx.hitBeam; // hitBulletSmall 命中效果
                hitColor = colors[2]; // white 命中效果颜色
                lightOpacity = 0.7f; // 0.3f 光照透明度
                lightColor = Color.orange; // Pal.powerLight 光照颜色

            length = f; // 220f 最大攻击距离
            shake = f; // 0f 屏幕震动强度
            damageInterval = f; // 5f 伤害间隔
            largeHit = ; // false 是否使用大型命中效果
            continuous = ; // true 是否持续攻击
            timescaleDamage = ; // false 是否受超速影响
            // Bullet
            lifetime = 16f; // 40f 子弹存在时间
            speed = 0f; // 1f 子弹速度
            keepVelocity = false; // true 是否继承射手速度
            pierce = true; // 是否穿透单位
            pierceCap = -1; // -1f 最大穿透次数
            removeAfterPierce = false; // true 穿透次数耗尽后是否移除子弹
            collides = false; // true 是否与任何东西碰撞
            hittable = false; // true 是否能被点防消除
            absorbable = false; // true 是否可被护盾吸收
            impact = true; // 击退是否沿子弹方向
            despawnEffect = Fx.none; // hitBulletSmall 消失效果
            shootEffect = Fx.none; // shootSmall 发射效果

            // = new EmptyBulletType() {{ // 空子弹类型
            // Bullet
            speed = 0f; // 1f 子弹速度
            keepVelocity = false; // true 是否继承射手速度
            collidesTiles = collidesAir = collidesGround = hittable = false;

            // = new ExplosionBulletType(splashDamage, splashDamageRadius) {{ // 爆炸类型
            // Bullet
            lifetime = 1f; // 40f 子弹存在时间
            rangeOverride = Math.max(20f, splashDamageRadius * 2f / 3f); // -1f 强制射程
            speed = 0f; // 1f 子弹速度
            keepVelocity = false; // true 是否继承射手速度
            collides = false; // true 是否与任何东西碰撞
            hittable = false; // true 是否能被点防消除
            killShooter = true; // 是否杀死射击者
            instantDisappear = true; // 是否立即消失
            splashDamage = splashDamage; // 0f 溅射伤害
            scaledSplashDamage = true; // false 是否根据单位体积缩放溅射伤害
            splashDamageRadius = splashDamageRadius; // -1f 溅射伤害半径
            shootEffect = Fx.massiveExplosion; // shootSmall 发射效果

            // = new FireBulletType(speed, damage) {{ // 火焰类型
            colorFrom = Color.valueOf(""); // Pal.lightFlame 火焰起始颜色
            colorMid = Color.valueOf(""); // Pal.darkFlame 火焰中间颜色
            colorTo = Color.valueOf(""); // Color.gray 火焰结束颜色
            radius = f; // 3f 火焰半径
            velMin = f; // 0.6f 火焰粒子最小速度
            velMax = f; // 2.6f 火焰粒子最大速度
            fireTrailChance = f; // 0.04f 产生火焰拖尾的概率
            trailEffect2 = Fx.; // ballfire 第二种拖尾特效
            fireEffectChance = f; // 0.1f 火焰特效触发概率
            fireEffectChance2 = f; // 0.1f 第二种火焰特效触发概率
            // Bullet
            drag = 0.03f; // 0f 阻力大小
            pierce = true; // 是否穿透单位
            collidesTiles = false; // true 是否与地形碰撞
            collides = false; // true 是否与任何东西碰撞
            hitEffect = Fx.none; // hitBulletSmall 命中效果
            despawnEffect = Fx.none; // hitBulletSmall 消失效果
            trailEffect = Fx.fireballsmoke; // missileTrail 尾迹特效

            // = new LaserBulletType(damage) {{ // 激光束类型(蓝瑟类型)
            laserEffect = Fx.; // lancerLaserShootSmoke 激光发射时的特效
            length = f; // 160f 激光最大长度
            width = f; // 15f 激光基础宽度
            lengthFalloff = f; // 0.5f 长度衰减系数
            sideLength = f; // 29f 侧面光翼的长度
            sideWidth = f; // 0.7f 侧面光翼的宽度
            sideAngle = f; // 90f 侧面光翼的角度偏移
            lightningSpacing = f; // -1 闪电生成间隔
            lightningDelay = f; // 0.1f 闪电生成延迟
            lightningAngleRand = f; // 闪电角度随机范围
            largeHit = ; // false 是否使用大型命中判定
            colors = new Color[]{Pal.lancerLaser.cpy().mul(1f, 1f, 1f, 0.4f), Pal.lancerLaser, Color.white}; // 激光颜色渐变数组
            // Bullet
            lifetime = 16f; // 40f 子弹存在时间
            speed = 0f; // 1f 子弹速度
            keepVelocity = false; // true 是否继承射手速度
            pierce = true; // 是否穿透单位
            removeAfterPierce = false; // true 穿透次数耗尽后是否移除子弹
            hitSize = 4; // 4 碰撞箱大小
            collides = false; // true 是否与任何东西碰撞
            hittable = false; // true 是否能被点防消除
            absorbable = false; // true 是否可被护盾吸收
            impact = true; // 击退是否沿子弹方向
            delayFrags = true; // false 分裂子弹是否延迟生成
            hitEffect = Fx.hitLaserBlast;  // hitBulletSmall 命中效果
            hitColor = colors[2]; // white 命中效果颜色
            despawnEffect = Fx.none; // hitBulletSmall 消失效果
            shootEffect = Fx.hitLancer; // shootSmall 发射效果
            smokeEffect = Fx.none; // shootSmallSmoke 烟雾效果

            // = new LightningBulletType() {{ // 闪电子弹类型(电弧类型)
            // Bullet
            lifetime = 1; // 40f 子弹存在时间
            speed = 0f; // 1f 子弹速度
            keepVelocity = false; // true 是否继承射手速度
            damage = 1f; // 1f 直接命中伤害
            hittable = false; // true 是否能被点防消除
            status = StatusEffects.shocked; // none 命中附加的状态效果
            lightningColor = Pal.lancerLaser; // Pal.surge 闪电颜色
            lightningLength = 25; // 5 闪电基础长度
            lightningLengthRand = 0; // 0 闪电随机额外长度
            hitEffect = Fx.hitLancer; // hitBulletSmall 命中效果
            despawnEffect = Fx.none; // hitBulletSmall 消失效果

            // = new LiquidBulletType(Liquids.) {{ // 液体子弹类型(波浪类型)
            liquid = liquid; // 子弹携带的液体类型
            puddleSize = f; // 6f 命中后生成的水坑大小
            orbSize = f; // 3f 子弹飞行时的液滴大小
            boilTime = f; // 5f 水坑蒸发时间
            // Bullet
                // if(liquid != null){
                liquid = liquid;
                lifetime = 34f; // 40f 子弹存在时间
                ammoMultiplier = 1f; // 2f 装填倍率
                status = liquid.effect; // none 命中附加的状态效果
                hitColor = liquid.color; // white 命中效果颜色
                lightOpacity = liquid.lightColor.a; // 0.3f 光照透明度
                lightColor = liquid.lightColor; // Pal.powerLight 光照颜色
            speed = 3.5f; // 1f 子弹速度
            damage = 0f; // 1f 直接命中伤害
            drag = 0.001f; // 0f 阻力大小
            knockback = 0.55f; // 击退力度
            statusDuration = 60f * 2f; // 60 * 8f 状态效果持续时间
            hitEffect = Fx.hitLiquid; // hitBulletSmall 命中效果
            despawnEffect = Fx.none; // hitBulletSmall 消失效果
            shootEffect = Fx.none; // shootSmall 发射效果
            smokeEffect = Fx.none; // shootSmallSmoke 烟雾效果
            displayAmmoMultiplier = false; // true 是否显示弹药倍率

            // = new MultiBulletType(bullets1, bullets2) {{}} // 多子弹类型

            // = new PointBulletType() {{ // 单点制导子弹类型(旧厄兆类型)
            trailSpacing = f; // 10f 拖尾特效的间隔距离
            // Bullet
            lifetime = 100f; // 40f 子弹存在时间
            scaleLife = true; // 是否根据距离缩放存在时间
            keepVelocity = false; // true 是否继承射手速度
            collides = false; // true 是否与任何东西碰撞
            reflectable = false; // true 是否可被反射

            // = new PointLaserBulletType() {{ // 点激光类型(光辉类型)
            sprite = ; // "point-laser" 激光纹理名称
            color = Color.valueOf(""); // white 激光颜色
            beamEffect = Fx.; // colorTrail 光束上的特效
            beamEffectInterval = f; // 3f 特效生成间隔
            beamEffectSize = f; // 3.5f 特效大小
            oscScl = f; // 2f 宽度波动频率
            oscMag = f; // 0.3f 宽度波动幅度
            damageInterval = f; // 5f 伤害间隔
            shake = f; // 0f 屏幕震动强度
            // Bullet
            lifetime = 20f; // 40f 子弹存在时间
            speed = 0f; // 1f 子弹速度
            keepVelocity = false; // true 是否继承射手速度
            optimalLifeFract = 0.5f; // 0f 达到最佳效果需要的时间
            pierce = true; // 是否穿透单位
            removeAfterPierce = false; // true 穿透次数耗尽后是否移除子弹
            collides = false; // true 是否与任何东西碰撞
            hittable = false; // true 是否能被点防消除
            absorbable = false; // true 是否可被护盾吸收
            impact = true; // 击退是否沿子弹方向
            drawSize = 1000f; // 40f 子弹的渲染裁剪大小
            despawnEffect = Fx.none; // hitBulletSmall 消失效果
            shootEffect = Fx.none; // shootSmall 发射效果
            smokeEffect =Fx.none; // shootSmallSmoke 烟雾效果

            // = new RailBulletType() {{ // 轨道炮类型(厄兆类型)
            pierceEffect = Fx.; // hitBulletSmall 每次穿透物体时触发的特效
            pointEffect = Fx.; // none 沿弹道每隔一定距离生成的点状特效
            lineEffect = Fx.; // none 沿整条弹道生成的线状特效
            endEffect = Fx.; // none 弹道末端无命中时的特效
            length = f; // 100f 子弹最大射程
            pointEffectSpace = f; // 20f 点特效之间的间隔距离
            // Bullet
            lifetime = 1f; // 40f 子弹存在时间
            speed = 0f; // 1f 子弹速度
            keepVelocity = false; // true 是否继承射手速度
            pierce = true; // 是否穿透单位
            pierceBuilding = true; // 是否穿透建筑
            collides = false; // true 是否与任何东西碰撞
            reflectable = false; // true 是否可被反射
            delayFrags = true; // false 分裂子弹是否延迟生成
            hitEffect = Fx.none; // hitBulletSmall 命中效果
            despawnEffect = Fx.none; // hitBulletSmall 消失效果

            // = new SapBulletType() {{ // 生命窃取类型(血蛭类型)
            length = f; // 100f 最大攻击距离
            lengthRand = f; // 0f 距离随机增量
            sapStrength = f; // 0.5f 吸血比例
            color = Color.valueOf(""); // Color.white.cpy(); 激光颜色
            width = f; // 0.4f 激光宽度
            sprite = ; // "laser" 激光纹理名称
            laserRegion = ; // 激光主体纹理
            laserEndRegion = ; // 激光末端纹理
            // Bullet
            speed = 0f; // 1f 子弹速度
            pierce = true; // 是否穿透单位
            hitSize = 0f; // 4 碰撞箱大小
            collides = false; // true 是否与任何东西碰撞
            hittable = false; // true 是否能被点防消除
            impact = true; // 击退是否沿子弹方向
            status = StatusEffects.sapped; // none 命中附加的状态效果
            statusDuration = 60f * 3f; // 60 * 8f 状态效果持续时间
            hitEffect = Fx.hitLiquid; // hitBulletSmall 命中效果
            despawnEffect = Fx.none; // hitBulletSmall 消失效果
            lightOpacity = 0.6f; // 0.3f 光照透明度
            lightColor = Pal.sap; // Pal.powerLight 光照颜色

            // = new ShrapnelBulletType() {{ // 雷光子弹类型
            length = f; // 100f 闪电的总长度
            width = f; // 20f 主闪电的基础宽度
            fromColor = Color.valueOf(""); // white 颜色渐变起始颜色
            toColor = Color.valueOf(""); // Pal.lancerLaser 颜色渐变结束颜色
            hitLarge = ; // false 是否使用大型命中判定
            serrations = ; // 7 分支的数量
            serrationLenScl = f; // 10f 分支长度的缩放系数
            serrationWidth = f; // 4f 每个分支的宽度
            serrationSpacing = f; // 8f 分支之间的间隔距离
            serrationSpaceOffset = f; // 80f 分支空间偏移量
            serrationFadeOffset = f; // 0.5f 分支淡出偏移量
            // Bullet
            lifetime = 10f; // 40f 子弹存在时间
            speed = 0f; // 1f 子弹速度
            keepVelocity = false; // true 是否继承射手速度
            pierce = true; // 是否穿透单位
            collides = false; // true 是否与任何东西碰撞
            hittable = false; // true 是否能被点防消除
            absorbable = false; // true 是否可被护盾吸收
            hitEffect = Fx.hitLancer; // hitBulletSmall 命中效果
            despawnEffect = Fx.none; // hitBulletSmall 消失效果
            shootEffect = Fx.lightningShoot; //  // shootSmall 发射效果
            smokeEffect = Fx.lightningShoot; // shootSmallSmoke 烟雾效果
            lightOpacity = 0.6f; // 0.3f 光照透明度

            // = new SpaceLiquidBulletType() {{ // 太空液体子弹类型
            orbSize = f; // 5.5f 液滴大小
            // Bullet
            lifetime = 90f; // 40f 子弹存在时间
            speed = 3.5f; // 1f 子弹速度
            drag = 0.002f; // 0f 阻力大小
            damage = 0f; // 1f 直接命中伤害
            collides = false; // true 是否与任何东西碰撞
            hittable = false; // true 是否能被点防消除
            hitEffect = Fx.none; // hitBulletSmall 命中效果
            despawnEffect = Fx.none; // hitBulletSmall 消失效果
            shootEffect = Fx.none; // shootSmall 发射效果
            smokeEffect = Fx.none; // shootSmallSmoke 烟雾效果
        }};
        */

        /*
        bullet = new BulletType(speed, damage) {{
            // 基础属性部分
            // 射程
            lifetime = f; // 40f 子弹存在时间
            lifeScaleRandMin = f; // 1f 子弹生命时间的随机缩放范围
            lifeScaleRandMax = f; // 1f
            scaleLife = ; // 是否根据距离缩放存在时间
            maxRange = f; // -1f 最大射程
            rangeOverride = f; // -1f 强制射程
            rangeChange = f; // 0f 炮塔射程改变量
            extraRangeMargin = f; // 0f 额外射程余量
            range = f; // 0f 初始化后的实际射程
            minRangeChange = f; // 0f 最小射程改变量
            // 速度
            speed = f; // 1f 子弹速度
            velocityScaleRandMin = f; // 1f 子弹速度的随机缩放范围
            velocityScaleRandMax = f; // 1f
            drag = f; // 0f 阻力大小
            accel = f; // 0f 加速度大小
            keepVelocity = ; // true 是否继承射手速度
            // 伤害
            damage = f; // 1f 直接命中伤害
            optimalLifeFract = f; // 0f 达到最佳效果需要的时间
            buildingDamageMultiplier = f; // 1f 对建筑伤害倍率
            shieldDamageMultiplier = f; // 1f 对护盾伤害倍率
            pierceArmor = ; // false 是否无视护甲
            armorMultiplier = f; // 1f 目标护甲乘数
            // 穿透
            pierce = ; // 是否穿透单位
            pierceBuilding = ; // 是否穿透建筑
            pierceCap = ; // -1 最大穿透次数
            pierceDamageFactor = f; // 0f 每次穿透后伤害衰减比例
            maxDamageFraction = f; // -1f 对目标最大生命值的伤害上限比例
            removeAfterPierce = ; // true 穿透次数耗尽后是否移除子弹
            laserAbsorb = ; // true 是否被塑钢墙吸收(用于激光)
            // 碰撞与消除
            hitSize = f; // 4 碰撞箱大小
            collidesTiles = ; // true 是否与地形碰撞
            collidesTeam = ; // false 是否与同队单位碰撞
            collidesAir = ; // true 是否与空中单位碰撞
            collidesGround = ; // true 是否与地面单位碰撞
            collides = ; // true 是否与任何东西碰撞
            collideFloor = ; // false 是否与非实心地面碰撞
            collideTerrain = ; // false 是否与静态墙碰撞
            hittable = ; // true 是否能被点防消除
            reflectable = ; // true 是否可被反射
            absorbable = ; // true 是否可被护盾吸收
            hitUnder = ; // false 是否命中下方的方块
            // 其他属性
            shootPattern = ; // null 射击模式
            ammoMultiplier = f; // 2f 装填倍率
            reloadMultiplier = f; // 1f 炮塔装填速度倍率
            recoil = f; // 后坐力
            killShooter = ; // 是否杀死射击者
            instantDisappear = ; // 是否立即消失
            targetBlocks = ; // true 是否锁定方块
            targetMissiles = ; // true 是否锁定导弹
            createChance = f; // 1 子弹生成概率
            lifesteal = f; // 0f 生命偷取比例
            setDefaults = ; // true 是否自动设置默认值
            rotateSpeed = f; // 0f 子弹旋转速度

            // 子弹移动轨迹部分
            // 散布和偏移
            angleOffset = f; // 0f 角度偏移
            randomAngleOffset = f; // 0f 随机角度偏移
            inaccuracy = f; // 0f 射击误差
            ignoreSpawnAngle = ; // false 是否忽略生成角度
            // 子弹环绕射击者
            circleShooter = ; // false 是否环绕射击者
            circleShooterRadius = f; // 13f 环绕半径
            circleShooterRadiusSmooth = f; // 10f 平滑额外半径
            circleShooterRotateSpeed = f; // 0.3f 环绕旋转速度
            // 追踪
            homingPower = f; // 0f 制导力度
            homingRange = f; // 50f 制导范围
            homingDelay = f; // -1f 制导延迟
            followAimSpeed = f; // 0f 跟踪瞄准点的速度
            // 子弹曲线飞行
            weaveScale = f; // 1f 摆动曲线波长
            weaveMag = f; // 0f 摆动曲线波强
            weaveRandom = ; // true 是否随机初始摆动方向

            // 击中效果部分
            knockback = f; // 击退力度
            impact = ; // 击退是否沿子弹方向
            despawnHit = ; // false 消失时是否触发命中效果
            // 溅射伤害
            splashDamage = f; // 0f 溅射伤害
            scaledSplashDamage = ; // false 是否根据单位体积缩放溅射伤害
            splashDamageRadius = f; // -1f 溅射伤害半径
            splashDamagePierce = ; // false 溅射伤害是否穿透方块
            // 状态效果
            status = StatusEffects.; // none 命中附加的状态效果
            statusDuration = f; // 60 * 8f 状态效果持续时间
            // 治疗相关
            healPercent = f; // 0f 建筑生命恢复百分比
            healAmount = f; // 0f 建筑生命恢复量
            healColor = Color.valueOf(""); // Pal.heal 治疗效果颜色
            healEffect = Fx.; // healBlockFull 治疗效果特效
            suppressionRange = f; // -1f 修复压制范围
            suppressionDuration = f; // 60f * 8f 修复压制持续时间
            suppressionEffectChance = f; // 50f 修复压制触发概率
            suppressColor = Color.valueOf(""); // Pal.sapBullet 修复压制效果颜色
            // 黏附效果
            sticky = ; // false 是否黏附在敌人身上
            stickyExtraLifetime = f; // 0f 黏附后额外存在时间
            // 火焰
            makeFire = ; // false 是否产生火焰
            incendAmount = ; // 0 尝试生成的火焰数量
            incendSpread = f; // 8f 火焰的扩散程度
            incendChance = f; // 1f 火焰生成概率
            // 生成液体
            puddles = ; // 生成的水坑数量
            puddleRange = ; // 水坑生成范围
            puddleAmount = f; // 5f 每个水坑的液体量
            puddleLiquid = Liquids.; // water 水坑的液体类型

            // 额外子弹部分
            // 分裂子弹
            fragOnHit = ; // true 命中时是否产生分裂子弹
            fragOnDespawn = ; // true 消失时是否产生分裂子弹
            fragOnAbsorb = ; // true 被护盾吸收时是否产生分裂子弹
            delayFrags = ; // false 分裂子弹是否延迟生成
            fragRandomSpread = f; // 360f 破片随机散布角度
            fragSpread = f; // 0f 破片均匀散布角度
            fragAngle = f; // 0f 破片角度偏移
            fragBullets = ; // 9 破片数量
            fragVelocityMin = f; // 0.2f 破片速度随机范围
            fragVelocityMax = f; // 1f
            fragLifeMin = f; // 1f 破片寿命随机范围
            fragLifeMax = f; // 1f
            fragOffsetMin = f; // 1f 破片位置偏移范围
            fragOffsetMax = f; // 7f
            pierceFragCap = ; // -1 穿透时生成碎片的次数上限
            fragBullet = ; // null 分裂子弹类型
            // 间隔生成子弹
            bulletInterval = f; // 20f 间隔子弹生成的时间间隔
            intervalBullets = ; // 1 每次生成的子弹数量
            intervalRandomSpread = f; // 360f 间隔子弹随机散布
            intervalSpread = f; // 0f 间隔子弹均匀散布
            intervalAngle = f; // 0f 间隔子弹角度偏移
            intervalDelay = f; // -1f 间隔子弹延迟
            intervalBullet = ; // 间隔生成的子弹类型
            // 生成时的装饰性子弹
            spawnBulletRandomSpread = f; // 0f 生成子弹随机散布
            spawnBullets = ; // 生成时额外生成的子弹, 用于视觉效果
            // 生成单位
            spawnUnit = ; // 替代子弹生成的单位
            despawnUnit = ; // 消失时生成的单位
            despawnUnitChance = f; // 1 消失时单位生成概率
            despawnUnitCount = ; // 1 消失时单位生成的数量
            despawnUnitRadius = f; // 0.1f 消失时单位生成半径
            faceOutwards = ; // false 单位是否背对子弹方向
            // 子弹产生的闪电效果
            lightningColor = Color.valueOf(""); // Pal.surge 闪电颜色
            lightning = ; // 闪电分支数量
            lightningLength = ; // 5 闪电基础长度
            lightningLengthRand = ; // 0 闪电随机额外长度
            lightningDamage = f; // -1 闪电伤害
            lightningCone = f; // 360f 闪电散布锥形角度
            lightningAngle = f; // 0f 闪电角度偏移
            lightningType = ; // null 闪电点生成的子弹类型

            // 视觉效果与音效部分
            // 部件
            parts = ; // 额外视觉部件序列
            // 渲染
            drawSize = f; // 40f 子弹的渲染裁剪大小
            layer = Layer.; // bullet 渲染层
            underwater = f; // false 是否在水下渲染
            // 粒子效果和颜色
            hitEffect = Fx.; // hitBulletSmall 命中效果
            hitColor = Color.valueOf(""); // white 命中效果颜色
            despawnEffect = Fx.; // hitBulletSmall 消失效果
            shootEffect = Fx.; // shootSmall 发射效果
            chargeEffect = Fx.; // none 充能效果
            smokeEffect = Fx.; // shootSmallSmoke 烟雾效果
            // 屏幕震动
            hitShake = f; // 0f 命中时的屏幕震动
            despawnShake = f; // 0f 消失时的屏幕震动
            // 光照
            lightRadius = f; // -1f 光照半径
            lightOpacity = f; // 0.3f 光照透明度
            lightColor = Color.valueOf(""); // Pal.powerLight 光照颜色
            // 尾迹
            trailColor = Color.valueOf(""); // Pal.missileYellowBack 尾迹颜色
            trailChance = f; // -0.0001f 每帧产生尾迹特效的概率
            trailInterval = f; // 0f 尾迹特效生成间隔
            trailMinVelocity = f; // 0f 产生尾迹的最小速度
            trailEffect = Fx.; // missileTrail 尾迹特效
            trailSpread = f; // 0f 尾迹随机偏移
            trailParam = f; // 2f 尾迹特效参数
            trailRotation = ; // false 是否用子弹旋转作为参数,而不是一个固定值
            trailInterp = Interp.; // one 尾迹宽度插值函数
            trailLength = ; // -1 尾迹长度
            trailWidth = f; // 2f 尾迹宽度
            trailSinMag = f; // 0f 尾迹宽度正弦波动幅度
            trailSinScl = f; // 3f 尾迹宽度正弦波动频率
            // 音效
            shootSound = Sounds.; // none 发射音效
            hitSound = Sounds.; // none 命中音效
            hitSoundPitch = f; // 1 命中音效的音调
            hitSoundPitchRange = f; // 0.1f 命中音效的音调范围
            hitSoundVolume = f; // 1 命中音效的音量
            despawnSound = Sounds.; // none 消失音效
            healSound = Sounds.; // blockHeal 治疗音效
            healSoundVolume = f; // 0.9f 治疗音效音量

            // 信息显示部分
            showStats = ; // false 是否显示统计信息
            displayAmmoMultiplier = ; // true 是否显示弹药倍率
            statLiquidConsumed = f; // 显示的液体消耗量
            cachedDps = f; // -1 显示的DPS
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
            useAttackRange = false; // true 是否用于攻击范围计算
            useAmmo = false; // true 当对应规则启用时, 是否消耗弹药
            targetInterval = 10f; // 40f 更换目标间的等待时间
            rotate = true; // false 是否独立于单位旋转
            controllable = false; // true 是否可由玩家手动瞄准
            autoTarget = true; // false 是否自动瞄准目标
            predictTarget = false; // true 是否预测目标轨迹

            // = new RepairBeamWeapon(name) {{ // 修复光束武器
            targetBuildings = ; // false 是否可治疗建筑
            targetUnits = ; // true 是否可治疗单位
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
            noAttack = true; // false 该武器能否用于攻击
            useAttackRange = false; // true 是否用于攻击范围计算
            useAmmo = false; // true 当对应规则启用时, 是否消耗弹药
            rotate = true; // false 是否独立于单位旋转
            recoil = 0f; // 1.5f 视觉上的后坐力
            mountType = HealBeamMount::new; // 武器挂架类型
            activeSound = Sounds.beamHeal; // none 射击循环音效
            controllable = false; // true 是否可由玩家手动瞄准
            autoTarget = true; // false 是否自动瞄准目标
            predictTarget = false; // true 是否预测目标轨迹
            reload = 1f; // 77f 重新装填的帧数 必须>0
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


// UnlockableContent
            /*
            alwaysUnlocked = ; // false 是否在科技树中始终解锁
            inlineDescription = ; // true 是否在研究界面显示描述
            hideDetails = ; // true 如果未在战役中解锁, 是否隐藏细节
            hideDatabase = ; // false 是否在核心数据库中隐藏
            allDatabaseTabs = ; // false 如果为真, 则在所有数据库标签页中显示
            shownPlanets.add(Planets.); // 包含此内容的星球. 如果为空则按照物品需求决定一个星球, 目前仅对方块有用
            databaseTabs.add(Planets.);
            databaseCategory = ""; // default 数据库类别
            databaseTag = ""; // default 数据库标签
            */
