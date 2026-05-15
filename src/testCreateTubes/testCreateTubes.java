package testCreateTubes;

import mindustry.mod.ClassMap;
import mindustry.mod.Mod;
import testCreateTubes.createTubes.StatefulRegionPart;
import testCreateTubes.createTubes.StatefulWeapon;
import testCreateTubes.createTubes.TubePart;
import testCreateTubes.createTubes.VePartProgress;

public class testCreateTubes extends Mod {

    @Override
    public void loadContent() {
        ClassMap.classes.put("StatefulWeapon", StatefulWeapon.class);
        ClassMap.classes.put("StatefulRegionPart", StatefulRegionPart.class);
        ClassMap.classes.put("VePartProgress", VePartProgress.class);
        ClassMap.classes.put("TubePart", TubePart.class);
    }
}
