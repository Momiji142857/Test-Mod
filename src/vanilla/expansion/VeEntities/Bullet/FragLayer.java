package vanilla.expansion.VeEntities.Bullet;

/**
 * 链式分裂子弹的层级配置.<p>
 * 用于定义链式分裂子弹中某一层的各项属性.<p>
 * 包含通用子弹属性以及 BasicBulletType 特有的字段.
 *
 * @see ChainFragBullet
 * @see mindustry.entities.bullet.BulletType
 * @see mindustry.entities.bullet.BasicBulletType
 *
 * @since 2026-04-28
 */

public class FragLayer {

    // 通用子弹属性
    public float lifetime,
            hitSize,
            splashDamage,
            splashDamageRadius,
            despawnShake;

    // BasicBulletType 特有字段
    public Float width,
            height;

    // 构造一个层级 (不设置 BasicBulletType 特有字段).
    public FragLayer(float lifetime, float hitSize, float splashDamage, float splashDamageRadius, float despawnShake) {
        this.lifetime = lifetime;
        this.hitSize = hitSize;
        this.splashDamage = splashDamage;
        this.splashDamageRadius = splashDamageRadius;
        this.despawnShake = despawnShake;
        this.width = null;
        this.height = null;
    }

    // 构造一个层级 (设置 BasicBulletType 特有字段).
    public FragLayer basicFields(float width, float height) {
        this.width = width;
        this.height = height;
        return this;
    }

    // 检查是否设置了 BasicBulletType 特有的字段
    public boolean hasBasicFields() {
        return width != null ||
                height != null;
    }
}
