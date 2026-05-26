package vanilla.expansion;

import MultiCrafter_Momiji.BlockContentFragment;
import MultiCrafter_Momiji.ExtendedCrafter;
import arc.Events;
import mindustry.Vars;
import mindustry.game.EventType;
import mindustry.mod.ClassMap;
import mindustry.mod.Mod;
import mindustry.world.meta.Attribute;
import vanilla.expansion.VeEntities.Part.StatefulRegionPart;
import vanilla.expansion.VeEntities.Part.VePartProgress;
import vanilla.expansion.VeType.StatefulWeapon;
import vanilla.expansion.content.*;
import vanilla.expansion.content.Override;

public class VanillaExpansion extends Mod {

    /** 添加新的环境属性 */
    public static final Attribute plant = Attribute.add("plant");

    public static String VeName(String add) {
        return "ve2" + "-" + add;
    }

    @java.lang.Override
    public void loadContent() {
        // 尝试让json文件也能使用StatefulWeapon
        ClassMap.classes.put("StatefulWeapon", StatefulWeapon.class);
        ClassMap.classes.put("StatefulRegionPart", StatefulRegionPart.class);
        ClassMap.classes.put("VePartProgress", VePartProgress.class);

        VeSounds.load();
        VeItems.load();
        VeStatusEffects.load();
        VeLiquids.load();
        VeWeathers.load();
        VeMissileUnitType.load();
        VeUnitTypes.load();
        VeTestUnitTypes.load();
        VeBlocks.load();
        VePlanets.load();
        VeSectors.load();
        VeTechTree.load();
        Override.load();
        SetShownPlanets.load();

        // 创建 fragment 实例
        ExtendedCrafter.payloadFragment = new BlockContentFragment();

        // 延迟到客户端加载完成后再添加到 UI 树
        Events.on(EventType.ClientLoadEvent.class, e -> {
            ExtendedCrafter.payloadFragment.build(Vars.ui.hudGroup);
        });

        // ... 其余代码
    }
}
