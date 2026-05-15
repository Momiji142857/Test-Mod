package vanilla.expansion.VeEntities.Bullet;

import arc.util.Log;
import mindustry.entities.bullet.*;

/**
 * 多重子弹构建器.<p>
 * 根据预定义的层级数组和子弹模板, 生成包含多颗独立子弹的 {@link ExMultiBulletType}.<p>
 * 每颗子子弹基于原型复制, 并通过 {@link BulletLayer} 覆写差异化属性.<p>
 * 最多支持 {@value #MAX_BULLETS} 颗子弹, 超出部分被截断并输出警告.
 *
 * @since 2026-05-13
 * @see BulletLayer
 * @see ExMultiBulletType
 * @see MultiBulletType
 * @author Momiji142857 (with DeepSeek)
 */
public class MultiBulletBuilder {

    /** 最大子弹数量 */
    private static final int MAX_BULLETS = 32;

    /**
     * 构建多重子弹组.
     *
     * @param layers    子弹层定义数组, 每个元素对应一颗子子弹
     * @param prototype 子弹模板, 每颗子子弹基于此复制并用 BulletLayer 覆写属性
     * @return  ExMultiBulletType 实例; layers 为空时返回仅含原型子弹的 ExMultiBulletType
     */
    public static ExMultiBulletType create(BulletLayer[] layers, BulletType prototype) {
        // 空数组则返回单颗原型子弹
        if (layers == null || layers.length == 0) {
            Log.warn("[MultiBulletBuilder] layers is empty, returning single prototype bullet.");
            return new ExMultiBulletType(prototype.copy());
        }

        // 超出上限则截断
        if (layers.length > MAX_BULLETS) {
            Log.warn("[MultiBulletBuilder] layers exceeds MAX_BULLETS (@), truncating.", MAX_BULLETS);
            BulletLayer[] trimmed = new BulletLayer[MAX_BULLETS];
            System.arraycopy(layers, 0, trimmed, 0, MAX_BULLETS);
            layers = trimmed;
        }

        // 逐层生成子子弹
        BulletType[] bullets = new BulletType[layers.length];
        for (int i = 0; i < layers.length; i++) {
            BulletType bullet = prototype.copy();
            layers[i].applyTo(bullet);
            bullets[i] = bullet;
        }

        ExMultiBulletType multi = new ExMultiBulletType();
        multi.setBullets(bullets);
        return multi;
    }
}
