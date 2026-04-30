package vanilla.expansion.VeEntities.Bullet;

import arc.util.Log;
import mindustry.entities.bullet.*;

/**
 * 链式分裂子弹工厂.<p>
 * 根据传入的预定义数组和子弹模板, 将多个子弹层嵌套为一个完整的链式分裂子弹序列.
 * 外层子弹分裂后产生内层子弹, 内层子弹继续分裂直至最内层.
 * 每层子弹的 lifetime, hitSize 等均可独立配置.<p>
 * 支持 BulletType 的大多数子类, 但以下类型被列入黑名单:<p>
 * <ul>
 *     <li>InterceptorBulletType</li>
 *     <li>MassDriverBolt</li>
 *     <li>ContinuousBulletType</li>
 *     <li>EmptyBulletType</li>
 *     <li>MultiBulletType</li>
 * </ul>
 * 字段 width/height 仅对 BasicBulletType 及其子类生效.
 * 若 FragLayer 中指定了视觉尺寸但传入的子弹类型不支持, 工厂将输出警告并直接返回原型子弹.<p>
 * 内置性能保护机制: 当预计产生的总子弹数超过 MAX_FRAG_BULLETS 时,
 * 强制所有外层每次只生成 1 个分裂子弹, 避免子弹数量爆炸.
 *
 * @since 2026-04-28
 * @author Momiji142857 (with DeepSeek)
 */
public class ChainFragBullet {

    // 最大总分裂子弹数上限
    private static final int MAX_FRAG_BULLETS = 128;

    /**
     * 构建链式分裂子弹.<p>
     * 构建顺序为从最内层向外层逐级包装, 确保每层子弹正确引用其内层子弹.<p>
     * 最内层的 fragBullets 被显式设置为 0, 表示不再继续分裂.<p>
     *
     * @param layers    分裂层定义数组, 索引 0 为最外层, 索引递增方向为向内层
     * @param prototype 子弹模板, 每一层均基于此模板复制并覆写指定属性, 其 fragBullet 将被覆盖
     * @return 最外层子弹实例, 内部已完整嵌套所有内层子弹, layers 为空时返回 null, 若创建失败则返回原型子弹
     */
    public static BulletType create(FragLayer[] layers, BulletType prototype) {
        // 黑名单检查
        if (prototype instanceof InterceptorBulletType ||
                prototype instanceof MassDriverBolt ||
                prototype instanceof ContinuousBulletType ||
                prototype instanceof EmptyBulletType ||
                prototype instanceof MultiBulletType) {
            Log.err("[ChainFragBullet] Bullet type @ is not supported for chain fragmentation, returning original bullet",
                    prototype.getClass().getSimpleName());
            return prototype;
        }

        // 检查是否需要设置BasicBulletType特有字段
        boolean setBasicFields = false;
        for (FragLayer layer : layers) {
            if (layer.hasBasicFields()) {
                setBasicFields = true;
                break;
            }
        }

        // 不兼容则直接返回
        if (setBasicFields && !(prototype instanceof BasicBulletType)) {
            Log.warn("[ChainFragBullet] Bullet type @ does not support width/height fields, returning original bullet.",
                    prototype.getClass().getSimpleName());
            return prototype;
        }

        // 计算总子弹数，超限则强制每层只生成1个
        int baseFragBullets = prototype.fragBullets;
        int estimatedTotal = 1;
        for (int i = 0; i < layers.length - 1; i++) {
            estimatedTotal *= baseFragBullets;
        }
        boolean forceSingleFrag = estimatedTotal > MAX_FRAG_BULLETS;

        // 从内向外构建
        BulletType current = null;

        for (int i = layers.length - 1; i >= 0; i--) {
            FragLayer layer = layers[i];
            BulletType bullet = prototype.copy();

            // 通用属性
            bullet.lifetime = layer.lifetime;
            bullet.hitSize = layer.hitSize;
            bullet.splashDamage = layer.splashDamage;
            bullet.splashDamageRadius = layer.splashDamageRadius;
            bullet.despawnShake = layer.despawnShake;

            // BasicBulletType特有属性
            if (layer.hasBasicFields()) {
                BasicBulletType b = (BasicBulletType) bullet;
                b.width = layer.width;
                b.height = layer.height;
            }

            // 链接内层
            if (current != null) {
                bullet.fragBullet = current;
                bullet.fragBullets = forceSingleFrag ? 1 : baseFragBullets;
            } else {
                bullet.fragBullets = 0;
                bullet.fragBullet = null;
            }

            current = bullet;
        }

        return current;
    }
}
