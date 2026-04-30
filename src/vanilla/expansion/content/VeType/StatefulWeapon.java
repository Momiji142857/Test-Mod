package vanilla.expansion.content.VeType;

import mindustry.entities.units.WeaponMount;
import mindustry.gen.*;
import mindustry.type.*;
import vanilla.expansion.content.VeEntities.Part.StatefulRegionPart;

/**
 * 在 draw 前将当前单位的 WeaponMount 传给 StatefulRegionPart，
 * 使其累加器能区分不同单位.
 */
public class StatefulWeapon extends Weapon {

    public StatefulWeapon(String name) {
        super(name);
    }

    @Override
    public void draw(Unit unit, WeaponMount mount) {
        StatefulRegionPart.currentMount = mount;
        super.draw(unit, mount);
        StatefulRegionPart.currentMount = null;
    }
}
