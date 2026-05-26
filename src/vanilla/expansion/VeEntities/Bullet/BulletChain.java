package vanilla.expansion.VeEntities.Bullet;

import arc.util.Log;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.MultiBulletType;

import java.util.function.Consumer;

/**
 * 分裂子弹链的工具类, 提供对 {@link BulletType#fragBullet} 链的遍历与查询.<p>
 * 当遇到 {@link MultiBulletType} 时, 默认选取其第 n 个子子弹 (索引 n) 继续遍历.
 *
 * @since 2026-05-17
 */
public final class BulletChain {

    private BulletChain() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * 获取分裂链中指定层级的子弹.<p>
     * 层数从 0 开始. 遇到 MultiBulletType 时选取其第 n 个子子弹.
     *
     * @param bullet 起始子弹
     * @param layer  层数 (0 = 起始子弹本身)
     * @param n      当遇到子弹组时选取的子子弹索引, 超出则取 n % bullets.length
     * @return 指定层级的子弹, 若起始子弹为 null 则返回 null
     */
    public static BulletType get(BulletType bullet, int layer, int n) {
        if (bullet == null || layer <= 0) return bullet;

        var current = bullet;
        // 起始子弹本身可能是 MultiBulletType
        if (current instanceof MultiBulletType m) {
            current = m.bullets[n % m.bullets.length];
            layer--;
        }

        while (layer > 0 && current != null) {
            if (current instanceof MultiBulletType m) {
                current = m.bullets[n % m.bullets.length];
            } else if (current.fragBullet != null) {
                current = current.fragBullet;
            } else {
                Log.warn("[BulletChain] get: null fragBullet at remaining layer @", layer);
                break;
            }
            layer--;
        }
        return current;
    }

    public static BulletType get(BulletType bullet, int layer) {
        return get(bullet, layer, 0);
    }

    public static BulletType last(BulletType bullet) {
        return last(bullet, 0);
    }

    public static BulletType last(BulletType bullet, int n) {
        if (bullet == null) return null;

        var current = bullet;
        if (current instanceof MultiBulletType m) {
            current = m.bullets[n % m.bullets.length];
        }

        while (current != null) {
            if (current instanceof MultiBulletType m) {
                current = m.bullets[n % m.bullets.length];
            } else if (current.fragBullet != null) {
                current = current.fragBullet;
            } else {
                break;
            }
        }
        return current;
    }

    public static int size(BulletType bullet) {
        return size(bullet, 0);
    }

    public static int size(BulletType bullet, int n) {
        if (bullet == null) return 0;

        int count = 1;
        var current = bullet;
        if (current instanceof MultiBulletType m) {
            current = m.bullets[n % m.bullets.length];
        }

        while (current != null) {
            count++;
            if (current instanceof MultiBulletType m) {
                current = m.bullets[n % m.bullets.length];
            } else if (current.fragBullet != null) {
                current = current.fragBullet;
            } else {
                break;
            }
        }
        return count;
    }

    public static void forEach(BulletType bullet, Consumer<BulletType> action) {
        forEach(bullet, action, 0);
    }

    public static void forEach(BulletType bullet, Consumer<BulletType> action, int n) {
        if (bullet == null || action == null) return;

        var current = bullet;
        // 包含起始子弹本身
        if (current instanceof MultiBulletType m) {
            action.accept(current);
            current = m.bullets[n % m.bullets.length];
        }

        while (current != null) {
            action.accept(current);
            if (current instanceof MultiBulletType m) {
                current = m.bullets[n % m.bullets.length];
            } else if (current.fragBullet != null) {
                current = current.fragBullet;
            } else {
                break;
            }
        }
    }
}
