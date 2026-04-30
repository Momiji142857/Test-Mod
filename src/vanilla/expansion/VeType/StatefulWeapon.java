package vanilla.expansion.VeType;

import mindustry.entities.units.WeaponMount;
import mindustry.gen.Unit;
import mindustry.type.Weapon;
import vanilla.expansion.VeEntities.Part.StatefulRegionPart;

/**
 * 在 draw 前将当前单位传入 StatefulRegionPart, 使其累加器能以 Unit 为 key 区分不同单位.<p>
 * 每 900 ticks (15 秒) 清理一次已死亡单位的残留状态.
 *
 * @since 2026-04-28
 */
public class StatefulWeapon extends Weapon {

    /** 清理计时器, 每帧 +1 */
    private int cleanTimer = 0;

    /** 清理间隔 (ticks) */
    private static final int CLEAN_INTERVAL = 900;

    public StatefulWeapon(String name) {
        super(name);
    }

    @Override
    public void draw(Unit unit, WeaponMount mount) {
        // 传入当前单位, 供 StatefulRegionPart 使用
        StatefulRegionPart.currentUnit = unit;
        super.draw(unit, mount);
        StatefulRegionPart.currentUnit = null;

        // 定期清理已死亡单位的累加状态
        if (++cleanTimer >= CLEAN_INTERVAL) {
            cleanTimer = 0;
            for (var part : parts) {
                if (part instanceof StatefulRegionPart sp) {
                    sp.cleanDeadUnits();
                }
            }
        }
    }

}
