package vanilla.expansion.VeEntities.Bullet;

import mindustry.entities.bullet.BulletType;

import java.util.function.Consumer;

/**
 * 分裂子弹链的工具类, 提供对 {@link BulletType#fragBullet} 链的遍历与查询.
 * @since 2026-04-28
 */
public final class BulletChain {

    private BulletChain() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * 获取分裂链中指定层级的子弹.
     *
     * @param bullet 起始子弹
     * @param layer  层数 (0 = 起始子弹本身, 1 = 第 1 层, 以此类推)
     * @return 指定层级的子弹, 若起始子弹为 null 则返回 null, 若层级超出链长则返回最深层
     */
    public static BulletType get(BulletType bullet, int layer) {
        if (bullet == null || layer <= 0) return bullet;

        var current = bullet;
        for (int i = 0; i < layer && current.fragBullet != null; i++) {
            current = current.fragBullet;
        }
        return current;
    }

    /**
     * 获取分裂链的最深层子弹.
     *
     * @param bullet 起始子弹
     * @return 最深层子弹, 若起始子弹为 null 则返回 null
     */
    public static BulletType last(BulletType bullet) {
        if (bullet == null) return null;

        var current = bullet;
        while (current.fragBullet != null) {
            current = current.fragBullet;
        }
        return current;
    }

    /**
     * 获取分裂链的总层数.
     *
     * @param bullet 起始子弹
     * @return 总层数, 若起始子弹为 null 则返回 0
     */
    public static int size(BulletType bullet) {
        if (bullet == null) return 0;

        int count = 1;
        var current = bullet;
        while (current.fragBullet != null) {
            count++;
            current = current.fragBullet;
        }
        return count;
    }

    /**
     * 遍历分裂链的每一层.
     *
     * @param bullet 起始子弹
     * @param action 对每层子弹执行的操作
     */
    public static void forEach(BulletType bullet, Consumer<BulletType> action) {
        if (bullet == null || action == null) return;

        var current = bullet;
        do {
            action.accept(current);
            current = current.fragBullet;
        } while (current != null);
    }
}
