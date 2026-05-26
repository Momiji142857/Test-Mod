package vanilla.expansion.VeEntities.Bullet;

import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.MultiBulletType;

import java.util.Arrays;

/**
 * 扩展 MultiBulletType, 提供对子子弹数组的公开访问.
 *
 * @since 2026-05-13
 * @see MultiBulletType
 * @author Momiji142857 (with DeepSeek)
 */
public class ExMultiBulletType extends MultiBulletType {

    public ExMultiBulletType(BulletType... bullets) {
        super(bullets);
    }

    public ExMultiBulletType() {
        super();
    }

    /** 返回子子弹数组 */
    public BulletType[] getBullets() {
        return bullets;
    }

    /** 设置指定索引的子子弹 */
    public void setBullet(int index, BulletType bullet) {
        bullets[index] = bullet;
    }

    /** 批量设置子子弹数组 */
    public void setBullets(BulletType[] bullets) {
        this.bullets = bullets;
    }

    /** 向子子弹数组中添加一颗子弹 */
    public void addBullet(BulletType bullet) {
        bullets = Arrays.copyOf(bullets, bullets.length + 1);
        bullets[bullets.length - 1] = bullet;
    }

}
