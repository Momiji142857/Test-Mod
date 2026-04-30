package vanilla.expansion.VeEntities.Part;

import arc.math.Mathf;
import arc.struct.ObjectFloatMap;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Unit;

/**
 * 支持有状态累加器与动态层级的 RegionPart.<p>
 * 通过 speedFunc 定义每帧累加量, 内部以 Unit 为 key 存储独立状态.<p>
 * 通过 layerProgress 动态修改 layerOffset.<p>
 * speedFunc 与 layerProgress 均为 null 时退化为普通 RegionPart.
 *
 * @since 2026-04-28
 * @author Momiji142857 (with DeepSeek)
 */
public class StatefulRegionPart extends RegionPart {

    /** 由 StatefulWeapon 在 draw 前设置, draw 后清除 */
    public static Unit currentUnit;

    // 累加器

    /** 每帧累加增量, null 时跳过 */
    public PartProgress speedFunc;

    /** 累加取模周期, 默认 2π */
    public float modAmount = Mathf.PI2;

    /** 累加初始值 */
    public float initial = 0f;

    /** 以 Unit 为 key 的独立累加状态 */
    private final ObjectFloatMap<Unit> stateMap = new ObjectFloatMap<>();

    /** 当前帧累加结果的缓存 */
    private float cachedPhase;

    /** 累加器, 作为 PartProgress 供外部 sinOf 等函数引用 */
    public final PartProgress accumulator = p -> cachedPhase;

    // 层级

    /** 动态 layerOffset 增量, null 时使用原值 */
    public PartProgress layerProgress;

    public StatefulRegionPart(String suffix) {
        super(suffix);
    }

    public StatefulRegionPart() {
        super();
    }

    @Override
    public void draw(PartParams params) {
        if (currentUnit == null) {
            super.draw(params);
            return;
        }

        // 当前 unit 已死则即时清理
        if (!currentUnit.isAdded()) {
            stateMap.remove(currentUnit, 0f);
            super.draw(params);
            return;
        }

        if (speedFunc == null && layerProgress == null) {
            super.draw(params);
            return;
        }

        // 更新累加值
        if (speedFunc != null) {
            float speed = speedFunc.get(params);
            float phase = stateMap.get(currentUnit, initial);
            phase = Mathf.mod(phase + speed, modAmount);
            stateMap.put(currentUnit, phase);
            cachedPhase = phase;
        }

        // 临时修改 layerOffset
        float originalLayer = layerOffset;
        if (layerProgress != null) {
            layerOffset += layerProgress.get(params);
        }

        super.draw(params);

        layerOffset = originalLayer;
    }

    /** 清理已死亡单位的累加状态, 由 StatefulWeapon 定期调用 */
    public void cleanDeadUnits() {
        if (speedFunc == null) return;
        var iter = stateMap.entries();
        while (iter.hasNext()) {
            if (!iter.next().key.isAdded()) {
                iter.remove();
            }
        }
    }
}
