package vanilla.expansion.VeEntities.Bullet;

import arc.util.Log;
import mindustry.entities.bullet.*;

/**
 * 链式分裂子弹工厂.<p>
 * 根据层级数组和子弹模板将多个子弹层嵌套为链式分裂序列.<p>
 * 支持四种模式: REPLACE / APPEND 操作第一层, REPLACE_TO_FRAG_FRAG / APPEND_TO_FRAG_FRAG 操作第二层.<p>
 * 待添加的递归子弹应放在 MultiBulletType 的第一位.
 *
 * @since 2026-05-17
 * @see BulletLayer
 * @see ExMultiBulletType
 * @author Momiji142857 (with DeepSeek)
 */
public class ChainFragBullet {

    private static final int MAX_FRAG_BULLETS = 1024;

    public enum Mode {
        REPLACE,
        APPEND,
        REPLACE_TO_FRAG_FRAG,
        APPEND_TO_FRAG_FRAG
    }

    public static BulletType create(BulletLayer[] layers, BulletType prototype) {
        return create(layers, prototype, Mode.REPLACE);
    }

    public static BulletType create(BulletLayer[] layers, BulletType prototype, Mode mode) {
        if (prototype instanceof InterceptorBulletType ||
                prototype instanceof MassDriverBolt ||
                prototype instanceof ContinuousBulletType ||
                prototype instanceof EmptyBulletType ||
                prototype instanceof MultiBulletType) {
            Log.err("[ChainFragBullet] Bullet type @ is not supported, returning original bullet.",
                    prototype.getClass().getSimpleName());
            return prototype;
        }

        boolean setBasicFields = false;
        for (BulletLayer l : layers) {
            if (l.hasBasicFields()) { setBasicFields = true; break; }
        }
        if (setBasicFields && !(prototype instanceof BasicBulletType)) {
            Log.warn("[ChainFragBullet] width/height not supported for @.", prototype.getClass().getSimpleName());
            return prototype;
        }

        // 估算总子弹数
        int fragBullets1 = prototype.fragBullets;
        int total1 = fragBullets1;
        if (prototype.fragBullet instanceof MultiBulletType m) {
            fragBullets1 = m.repeat;
            total1 = m.bullets.length * m.repeat;
        }

        int fragBullets2 = 1, total2 = 1;
        if (mode == Mode.REPLACE_TO_FRAG_FRAG || mode == Mode.APPEND_TO_FRAG_FRAG) {
            BulletType c = resolveInner(prototype);
            if (c != null) {
                if (c.fragBullet instanceof MultiBulletType m2) {
                    fragBullets2 = m2.repeat;
                    total2 = m2.bullets.length * m2.repeat;
                } else if (c.fragBullet != null) {
                    fragBullets2 = c.fragBullets;
                }
            }
        }

        int estimated = 1;
        for (int i = 0; i < layers.length - 1; i++) {
            estimated *= total1 * total2;
            if (estimated > MAX_FRAG_BULLETS) break;
        }
        boolean forceSingle = estimated > MAX_FRAG_BULLETS;

        // 从内向外构建
        BulletType current = null;
        for (int i = layers.length - 1; i >= 0; i--) {
            BulletType bullet = prototype.copy();

            if (bullet.fragBullet instanceof MultiBulletType m) {
                BulletType[] copies = new BulletType[m.bullets.length];
                for (int j = 0; j < copies.length; j++) copies[j] = m.bullets[j].copy();
                bullet.fragBullet = new ExMultiBulletType(copies);
            }

            layers[i].applyTo(bullet);

            if (current != null) {
                if (bullet.fragBullet == null || mode == Mode.REPLACE) {
                    bullet.fragBullet = current;
                } else if (mode == Mode.APPEND) {
                    bullet.fragBullet = wrapAndAppend(bullet.fragBullet, current);
                } else {
                    BulletType inner = resolveInner(bullet);
                    if (inner.fragBullet == null || mode == Mode.REPLACE_TO_FRAG_FRAG) {
                        inner.fragBullet = current;
                    } else {
                        inner.fragBullet = wrapAndAppend(inner.fragBullet, current);
                    }
                    inner.fragBullets = forceSingle ? 1 : fragBullets2;
                }
                bullet.fragBullets = forceSingle ? 1 : fragBullets1;
            } else {
                if (mode == Mode.REPLACE_TO_FRAG_FRAG || mode == Mode.APPEND_TO_FRAG_FRAG) {
                    if (bullet.fragBullet instanceof MultiBulletType m) {
                        for (BulletType b : m.bullets) {
                            b.fragBullet = prototype.copy();
                            b.fragBullets = forceSingle ? 1 : fragBullets2;
                        }
                    }
                    bullet.fragBullets = forceSingle ? 1 : fragBullets1;
                }
            }

            current = bullet;
        }

        return current;
    }

    /** 取 fragBullet 的第一个子子弹, 若为 MultiBulletType 则先包装为 ExMultiBulletType */
    private static BulletType resolveInner(BulletType target) {
        BulletType inner = target.fragBullet;
        if (inner instanceof MultiBulletType m) {
            inner = new ExMultiBulletType(m.bullets);
            target.fragBullet = inner;
        }
        return inner instanceof ExMultiBulletType em && em.bullets.length > 0 ? em.bullets[0] : inner;
    }

    /** 追加到 ExMultiBulletType, 若不是则先包装 */
    private static ExMultiBulletType wrapAndAppend(BulletType target, BulletType toAdd) {
        ExMultiBulletType multi = target instanceof ExMultiBulletType e ? e
                : target instanceof MultiBulletType m ? new ExMultiBulletType(m.bullets)
                  : new ExMultiBulletType(target);
        multi.addBullet(toAdd);
        return multi;
    }
}
