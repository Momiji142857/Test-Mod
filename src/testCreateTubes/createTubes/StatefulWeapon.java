package testCreateTubes.createTubes;

import arc.math.Mathf;
import arc.util.Log;
import mindustry.entities.part.DrawPart;
import mindustry.entities.units.WeaponMount;
import mindustry.gen.Unit;
import mindustry.type.Weapon;

/**
 * 在 draw 前将当前单位传入 StatefulRegionPart, 使其累加器能以 Unit 为 key 区分不同单位.<p>
 * 提供 {@link #createTubes} 快捷生成旋转炮管组, 旋转速度与武器射击间隔自动同步.<p>
 * 每 {@value #CLEAN_INTERVAL} ticks 清理一次已死亡单位的残留状态.
 *
 * @since 2026-05-08
 * @see StatefulRegionPart
 * @see VePartProgress
 * @author Momiji142857 (with DeepSeek)
 */
public class StatefulWeapon extends Weapon {

    /** 清理计时器, 每帧 +1 */
    private int cleanTimer = 0;

    /** 清理间隔 (ticks) */
    private static final int CLEAN_INTERVAL = 900;

    public StatefulWeapon(String name) {
        super(name);
    }

    public StatefulWeapon() {
        super("");
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
                if (part instanceof StatefulRegionPart sp) sp.cleanDeadUnits();
            }
        }
    }

    /**
     * 创建一组旋转炮管, 旋转速度与武器射击间隔同步.<p>
     * 开火时每根炮管旋转一周的时间 = reload * count ticks, 每次射击时下一根炮管恰好转到当前位置.<p>
     * base 中仅有部分外观参数生效, 详见 {@link StatefulRegionPart#copy()}.<p>
     * speedFunc, progress, layerProgress, colorProgress 由本方法自动覆写.
     *
     * @param count  炮管数量, 有效范围 1~9, 超出时返回仅含 base 的单元素数组并在日志输出警告
     * @param base   炮管基础配置, 部分参数生效
     * @return 炮管数组, 首元素为累加器 master, 其余为只读 children
     */
    public StatefulRegionPart[] createTubes(int count, StatefulRegionPart base) {
        if (count < 1 || count > 9) {
            Log.warn("[StatefulWeapon] createTubes: count must be in range [1, 9], got @. Returning base unchanged.", count);
            return new StatefulRegionPart[] {base};
        }

        StatefulRegionPart[] tubes = new StatefulRegionPart[count];

        // 理论值为 PI2 / (reload * count), 实测需除以 4 才能与射击频率同步
        float speed = Mathf.PI2 / (reload * count) / 4f;
        DrawPart.PartProgress masterAcc = null;

        for (int i = 0; i < count; i++) {
            float phase = i * Mathf.PI2 / count;
            tubes[i] = base.copy();

            if (i == 0) {
                // master: 带累加器, 转速受 heat 控制, 开火全速停火衰减
                tubes[i].speedFunc = DrawPart.PartProgress.heat
                        .min(DrawPart.PartProgress.constant(0.9f))  // heat 上限 0.9, 避免开火瞬间波动
                        .mul(speed / 0.9f);
                tubes[i].modAmount = Mathf.PI2;
                tubes[i].progress = VePartProgress.sinOf(tubes[i].accumulator);
                masterAcc = tubes[i].accumulator;
            } else {
                // children: 共享 master 累加器, 各自偏移相位
                tubes[i].progress = VePartProgress.sinOf(masterAcc.add(phase));
            }

            // 层级与颜色渐变基于同一个相位源 (accumulator + 相位偏移)
            DrawPart.PartProgress acc = i == 0 ? tubes[i].accumulator : masterAcc.add(phase);
            tubes[i].layerProgress = VePartProgress.cosOf(acc).mul(0.0005f);
            tubes[i].colorProgress = VePartProgress.cosOf(acc).mul(0.5f).add(0.5f);
        }
        return tubes;
    }

    @Override
    public void load() {
        super.load();

        for (int i = 0; i < parts.size; i++) {
            if (parts.get(i) instanceof TubePart tp) {
                StatefulRegionPart[] tubes = createTubes(tp.tubeCount, tp);
                // 替换原来的 TubePart 为生成的炮管组
                parts.remove(i);
                for (int j = tubes.length - 1; j >= 0; j--) {
                    parts.insert(i, tubes[j]);
                }
            }
        }
    }
}
