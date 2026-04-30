package vanilla.expansion.content.VeEntities.Part;

import arc.math.Mathf;
import arc.struct.ObjectFloatMap;
import mindustry.entities.part.*;
import mindustry.entities.units.WeaponMount;

/**
 * 支持有状态累加器的 RegionPart.通过 speedFunc 定义每帧累加量.<p>
 * 内部以 WeaponMount 为 key 存储每个单位的独立状态.<p>
 * 若 speedFunc 为 null，退化为普通 RegionPart.
 *
 * @since 2026-04-28
 */
public class StatefulRegionPart extends RegionPart {

    /** 由 StatefulWeapon 在 draw 前设置 */
    public static WeaponMount currentMount;

    private final ObjectFloatMap<WeaponMount> stateMap = new ObjectFloatMap<>();

    /** 每帧累加增量。为 null 时等同于普通 RegionPart */
    public PartProgress speedFunc;

    /** 累加取模周期，默认 2π */
    public float modAmount = Mathf.PI * 2f;

    /** 累加初始值 */
    public float initial = 0f;

    private float cachedPhase;

    /** 累加器，作为 PartProgress 供外部 sinOf 等函数引用 */
    public final PartProgress accumulator = p -> cachedPhase;

    public StatefulRegionPart(String suffix) {
        super(suffix);
    }

    public StatefulRegionPart() {
        super();
    }

    @Override
    public void draw(PartParams params) {
        if (speedFunc == null) {
            super.draw(params);
            return;
        }
        float speed = speedFunc.get(params);
        float phase = stateMap.get(currentMount, initial);
        phase = Mathf.mod(phase + speed, modAmount);
        stateMap.put(currentMount, phase);
        cachedPhase = phase;

        super.draw(params);
    }
}
