package vanilla.expansion.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class VeItems {
    public static Item
            // Cyclant
            aluminium, quartz, catalyzon, silicide, salt, plantMatter, chromium, sodium,
                    carbonShaleCobble, shaleCobble, nitroalkoss, cobalt, fibralt, fusionFuel,
                    capacitor, warpNucleus,

            // Maress
            redSoil, ferrum, reflectorMatter, ferricShaleCobble,
                    silver, tantalum, astroPlate, phecteel,

            // Sitrullus
            melonDirt, sugar;

    public static void load() {

        aluminium = new Item("aluminium", Color.valueOf("eae3c3")) {{
            hardness = 1;
            cost = 0.2f;
            healthScaling = 0;
        }};

        quartz = new Item("quartz", Color.valueOf("f0d7d7")) {{
            hardness = 3;
            cost = 1.1f;
        }};

        catalyzon = new Item("catalyzon", Color.valueOf("a799a6")) {{
            charge = 0.2f;
            hardness = 2;
            cost = 0.7f;
            healthScaling = 0;
        }};

        silicide = new Item("silicide", Color.valueOf("646567")) {{
            flammability = -1f;
            cost = 1.6f;
            healthScaling = 1.6f;
        }};

        salt = new Item("salt", Color.valueOf("e2f2d7")) {{
            explosiveness = 0.1f;
            cost = 0.5f;
            lowPriority = true;
        }};

        plantMatter = new Item("plant-matter", Color.valueOf("6aa95e")) {{
            flammability = 1.05f;
            hardness = 8;
            cost = 0.1f;
        }};

        chromium = new Item("chromium", Color.valueOf("ff6b41")) {{
            hardness = 6;
            cost = 1.3f;
            healthScaling = 1.1f;
        }};

        sodium = new Item("sodium", Color.valueOf("d4e5ed")) {{
            flammability = 0.6f;
            cost = 0.1f;
        }};

        carbonShaleCobble = new Item("carbon-shale-cobble", Color.valueOf("3c4448")) {{
            flammability = 0.5f;
            hardness = 7;
            cost = 0.7f;
            lowPriority = true;
        }};

        shaleCobble = new Item("shale-cobble", Color.valueOf("676593")) {{
            flammability = 0.05f;
            hardness = 7;
            cost = 0.8f;
            lowPriority = true;
        }};

        nitroalkoss = new Item("nitroalkoss", Color.valueOf("ff8a67")) {{
            explosiveness = 4.7f;
            flammability = 2.3f;
            cost = 0.1f;
            frames = 11;
        }};

        cobalt = new Item("cobalt", Color.valueOf("809fff")) {{
            hardness = 3;
            cost = 0.9f;
        }};

        fibralt = new Item("fibralt", Color.valueOf("90dbff")) {{
            flammability = 0.05f;
            cost = 1.4f;
            healthScaling = 0.2f;
        }};

        fusionFuel = new Item("fusion-fuel", Color.valueOf("9eabf7")) {{
            explosiveness = 1.3f;
            flammability = 0.8f;
            radioactivity = 0.9f;
            charge = 0.6f;
        }};

        capacitor = new Item("capacitor", Color.valueOf("e8d174")) {{
            explosiveness = 1f;
            charge = 3.6f;
            cost = 1.2f;
        }};

        warpNucleus = new Item("warp-nucleus", Color.valueOf("b791eb")) {{
            explosiveness = 0.3f;
            radioactivity = 0.2f;
            charge = 3f;
            cost = 1.6f;
            frames = 23;
            frameTime = 7;
        }};

        redSoil = new Item("red-soil", Color.valueOf("ba754e")) {{
            cost = 0.1f;
            lowPriority = true;
        }};

        ferrum = new Item("ferrum", Color.valueOf("9f8c88")) {{
            hardness = 3;
            cost = 0.4f;
            healthScaling = 0.8f;
        }};

        reflectorMatter = new Item("reflector-matter", Color.valueOf("a58570")) {{
            explosiveness = 0.7f;
            flammability = 0.3f;
            cost = 0.4f;
        }};

        ferricShaleCobble = new Item("ferric-shale-cobble", Color.valueOf("877d72")) {{
            hardness = 7;
            cost = 0.9f;
            lowPriority = true;
        }};

        silver = new Item("silver", Color.valueOf("f5e1eb")) {{
            hardness = 1;
            cost = 0.5f;
        }};

        tantalum = new Item("tantalum", Color.valueOf("6d897b")) {{
            flammability = -0.75f;
            charge = 0.25f;
            hardness = 4;
            cost = 0.6f;
            healthScaling = 1f;
        }};

        astroPlate = new Item("astro-plate", Color.valueOf("bfbba9")) {{
            flammability = -0.5f;
            healthScaling = 2f;
        }};

        phecteel = new Item("phecteel", Color.valueOf("00ffce")) {{
            explosiveness = 0.5f;
            charge = 1.5f;
            cost = 1.2f;
            frames = 18;
        }};

        melonDirt = new Item("melon-dirt", Color.valueOf("e44646")) {{
            flammability = 0.04f;
            cost = 0.1f;
            lowPriority = true;
        }};

        sugar = new Item("sugar", Color.valueOf("ffffff")) {{
            flammability = 0.6f;
            cost = 0.2f;
            lowPriority = true;
        }};

    }
}
