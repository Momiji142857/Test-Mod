package vanilla.expansion;

import mindustry.mod.Mod;
import mindustry.world.meta.Attribute;
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
        VeSounds.load();
        VeItems.load();
        VeStatusEffects.load();
        VeLiquids.load();
        VeWeathers.load();
        VeMissileUnitType.load();
        VeUnitTypes.load();
        VeBlocks.load();
        VePlanets.load();
        VeSectors.load();
        VeTechTree.load();
        Override.load();
        SetShownPlanets.load();
    }
}
