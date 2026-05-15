package vanilla.expansion.VeEntities.Bullet;

import arc.util.Log;
import mindustry.entities.bullet.*;

/**
 * 链式分裂子弹工厂.<p>
 * 根据预定义的层级数组和子弹模板, 将多个子弹层嵌套为完整的链式分裂子弹序列.<p>
 * 外层子弹分裂产生内层, 内层继续分裂直至最内层.<p>
 * 每层子弹的 lifetime, hitSize 等属性通过 {@link BulletLayer} 独立配置.<p>
 * 支持大多数 BulletType 子类, 但以下类型不受支持:
 * <ul>
 *     <li>InterceptorBulletType</li>
 *     <li>MassDriverBolt</li>
 *     <li>ContinuousBulletType</li>
 *     <li>EmptyBulletType</li>
 *     <li>MultiBulletType</li>
 * </ul>
 * 字段 width / height 仅对 BasicBulletType 及其子类生效.<p>
 * 若指定了视觉尺寸但原型不支持, 工厂将输出警告并直接返回原型.<p>
 * 当预计产生的总子弹数超过 {@value #MAX_FRAG_BULLETS} 时,
 * 强制所有外层每次只生成 1 个分裂子弹, 避免数量爆炸.
 *
 * @since 2026-05-13
 * @see BulletLayer
 * @author Momiji142857 (with DeepSeek)
 */
public class ChainFragBullet {

    /** 最大总分裂子弹数上限 */
    private static final int MAX_FRAG_BULLETS = 128;

    /**
     * 构建链式分裂子弹.<p>
     * 从最内层向外逐级包装, 每层子弹引用其内层子弹.<p>
     * 最内层子弹的 fragBullets 设为 0 以终止分裂.
     *
     * @param layers    分裂层定义数组, 索引 0 为最外层, 索引递增方向为向内层
     * @param prototype 子弹模板, 每层基于此复制并用 BulletLayer 覆写属性, 其 fragBullet 将被覆盖
     * @return 最外层子弹实例; layers 为空时返回 null; 创建失败时返回原型
     */
    public static BulletType create(BulletLayer[] layers, BulletType prototype) {
        // 黑名单检查
        if (prototype instanceof InterceptorBulletType ||
                prototype instanceof MassDriverBolt ||
                prototype instanceof ContinuousBulletType ||
                prototype instanceof EmptyBulletType ||
                prototype instanceof MultiBulletType) {
            Log.err("[ChainFragBullet] Bullet type @ is not supported, returning original bullet.",
                    prototype.getClass().getSimpleName());
            return prototype;
        }

        // 检查是否需要设置 BasicBulletType 特有字段
        boolean setBasicFields = false;
        for (BulletLayer layer : layers) {
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

        // 估算总子弹数, 超限则强制每层仅分裂 1 个
        int baseFragBullets = prototype.fragBullets;
        int estimatedTotal = 1;
        for (int i = 0; i < layers.length - 1; i++) {
            estimatedTotal *= baseFragBullets;
        }
        boolean forceSingleFrag = estimatedTotal > MAX_FRAG_BULLETS;

        // 从内向外逐层构建
        BulletType current = null;
        for (int i = layers.length - 1; i >= 0; i--) {
            BulletLayer layer = layers[i];
            BulletType bullet = prototype.copy();

            // 设置属性
            layer.applyTo(bullet);

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
