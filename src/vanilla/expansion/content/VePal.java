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
    public static final Color white0 = Color.valueOf("ffffff00");


    // 暖橙黄
    // accent = Pal.accent;
    public static final Color accent0 = Color.valueOf("ffd37f00");
    public static final Color accent40 = Color.valueOf("ffd37f66");
    public static final Color accent73 = Color.valueOf("ffd37fbb");

    // 中灰色
    public static final Color grayMid = Color.valueOf("aaaaaa");

    // 浅灰色, 与Color.lightGray相近
    public static final Color gray187 = Color.valueOf("bbbbbb");

    // 灰白色
    public static final Color gray221 = Color.valueOf("dddddd");

    // 珊瑚红
    public static final Color coralRed = Color.valueOf("f25555");

    // 浅红色
    // redLight = Pal.redLight;
    public static final Color redLight0 = Color.valueOf("feb38000");
    public static final Color redLight20 = Color.valueOf("feb38033");
    public static final Color redLight50 = Color.valueOf("feb38080");
    public static final Color redLight53 = Color.valueOf("feb38088");
    public static final Color redLight67 = Color.valueOf("feb380aa");

    // 反应堆紫色
    // reactorPurple = Pal.reactorPurple;
    public static final Color reactorPurple40 = Color.valueOf("bf92f966");
    public static final Color reactorPurple67 = Color.valueOf("bf92f9aa");

    // 天蓝色
    public static final Color skyBlue = Color.valueOf("90dbff");
    public static final Color skyBlue67 = Color.valueOf("90dbffaa");

}
