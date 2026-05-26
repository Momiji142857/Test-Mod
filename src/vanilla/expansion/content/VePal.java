package vanilla.expansion.content;

import arc.graphics.Color;
import mindustry.graphics.Pal;

/**
 * 自定义调色板, 提供扩展的颜色常量.
 *
 * @see Pal
 * @see Color
 */
public class VePal {
    // 白色
    // white = Color.white;
    public static final Color white0 = Color.valueOf("ffffff00"),
            white93 = Color.valueOf("ffffffee"),

    // 暖橙黄
    // accent = Pal.accent;
    accent0 = Color.valueOf("ffd37f00"),
            accent40 = Color.valueOf("ffd37f66"),
            accent73 = Color.valueOf("ffd37fbb"),

    // 中灰色
    grayMid = Color.valueOf("aaaaaa"),

    // 浅灰色, 与Color.lightGray相近
    gray187 = Color.valueOf("bbbbbb"),

    // 灰白色
    gray221 = Color.valueOf("dddddd"),

    // 珊瑚红
    coralRed = Color.valueOf("f25555"),

    // 浅红色
    // redLight = Pal.redLight;
    redLight0 = Color.valueOf("feb38000"),
            redLight20 = Color.valueOf("feb38033"),
            redLight50 = Color.valueOf("feb38080"),
            redLight53 = Color.valueOf("feb38088"),
            redLight67 = Color.valueOf("feb380aa"),

    // 反应堆紫色
    // reactorPurple = Pal.reactorPurple;
    reactorPurple40 = Color.valueOf("bf92f966"),
            reactorPurple67 = Color.valueOf("bf92f9aa"),

    // 天蓝色
    skyBlue = Color.valueOf("90dbff"),
            skyBlue67 = Color.valueOf("90dbffaa"),

    // 单位前色 (暖橙)
    // unitFront = Pal.unitFront;
    unitFront0 = Color.valueOf("ffa66500"),
            unitFront53 = Color.valueOf("feb38088"),
            unitFront73 = Color.valueOf("ffa665bb"),

    // 单位后色 (暗橙棕)
    // unitBack = Pal.unitBack;
    unitBack0 = Color.valueOf("d06b5300"),

    // 炮塔热浪颜色 (暗暖红棕)
    // turretHeat = Pal.turretHeat;
    turretHeat0 = Color.valueOf("ab340000"),

    // 子弹浅橙背色
    // bulletYellowBack = Pal.bulletYellowBack;

    // 123
    // surge = Pal.surge;
    surge67 = Color.valueOf("f3e979aa"),

    // 234
    // heal = Pal.heal;
    heal0 = Color.valueOf("98ffa900"),
            heal40 = Color.valueOf("98ffa966"),
            heal53 = Color.valueOf("98ffa988"),
            heal67 = Color.valueOf("98ffa9aa"),
            heal80 = Color.valueOf("98ffa9cc");

    // 黑色
    // black = Color.black;
}
