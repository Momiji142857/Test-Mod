package vanilla.expansion.VeEntities.Bullet;

import mindustry.entities.bullet.*;

/**
 * 子弹层级配置.<p>
 * 存储各层子弹的差异化属性, 用于 ChainFragBullet 和 BurstBullet 的工厂方法.<p>
 * 未设置的字段为 null, 在 {@link #applyTo} 时跳过.
 *
 * @since 2026-05-12
 * @see BulletType
 * @see BasicBulletType
 * @author Momiji142857 (with DeepSeek)
 */
public class BulletLayer {
    public Float lifetime,
            speed,
            hitSize,
            splashDamage,
            splashDamageRadius,
            despawnShake,
            // BasicBulletType 特有字段
            width,
            height;

    /** 全 null 构造, 所有字段默认 null, 不覆写任何属性 */
    public BulletLayer() {}

    /** 构造基础属性 */
    public BulletLayer(float lifetime, float speed, float hitSize, float despawnShake) {
        this.lifetime = lifetime;
        this.speed = speed;
        this.hitSize = hitSize;
        this.despawnShake = despawnShake;
    }

    /** 设置溅射属性 */
    public BulletLayer setSplash(float splashDamage, float splashDamageRadius) {
        this.splashDamage = splashDamage;
        this.splashDamageRadius = splashDamageRadius;
        return this;
    }

    /** 设置 BasicBulletType 特有字段 */
    public BulletLayer setBasicFields(float width, float height) {
        this.width = width;
        this.height = height;
        return this;
    }

    /**
     * 创建指定层数的全 null 层数组.
     * 每层不覆写任何属性, 子弹完全继承原型值.
     *
     * @param count 层数
     * @return 全 null 层的 BulletLayer 数组
     */
    public static BulletLayer[] nullLayers(int count) {
        BulletLayer[] layers = new BulletLayer[count];
        for (int i = 0; i < count; i++) {
            layers[i] = new BulletLayer();
        }
        return layers;
    }

    /** 是否设置了 BasicBulletType 特有字段 */
    public boolean hasBasicFields() {
        return width != null ||
                height != null;
    }

    /** 将本层非 null 属性覆写到目标子弹 */
    public void applyTo(BulletType bullet) {
        if (lifetime != null) bullet.lifetime = lifetime;
        if (speed != null) bullet.speed = speed;
        if (hitSize != null) bullet.hitSize = hitSize;
        if (despawnShake != null) bullet.despawnShake = despawnShake;

        if (splashDamage != null) bullet.splashDamage = splashDamage;
        if (splashDamageRadius != null) bullet.splashDamageRadius = splashDamageRadius;

        if (hasBasicFields() && bullet instanceof BasicBulletType b) {
            if (width != null) b.width = width;
            if (height != null) b.height = height;
        }
    }

}
