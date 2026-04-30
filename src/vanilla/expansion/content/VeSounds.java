package vanilla.expansion.content;

import arc.Core;
import arc.assets.loaders.SoundLoader;
import arc.audio.Sound;
import arc.files.Fi;
import arc.struct.ObjectMap;
import arc.util.Log;
import mindustry.Vars;
import mindustry.gen.Sounds;
import mindustry.mod.Mods;
import vanilla.expansion.VanillaExpansion;

/**
 * 音频加载类<p>
 * 使用: VeSounds.get("文件名").play();<p>
 * 目录结构: mod.jar/sounds/*.ogg<p>
 * 注意: 文件名全局唯一
 */
public class VeSounds {

    /** 音频存储表, key: 文件名, value: Sound对象 */
    private static final ObjectMap<String, Sound> sounds = new ObjectMap<>();

    /** 加载所有音频 */
    public static void load() {
        // 通过模组主类获取当前模组实例
        Mods.LoadedMod mod = Vars.mods.getMod(VanillaExpansion.class);
        if (mod == null) {
            Log.err("VeSounds: Failed to get mod instance");
            return;
        }

        // 定位 sounds 文件夹
        Fi soundsDir = mod.root.child("sounds");
        if (!soundsDir.exists()) {
            Log.warn("VeSounds: Sounds directory not found: " + soundsDir);
            return;
        }

        // 递归扫描并加载所有音频
        int count = scanAndLoad(soundsDir);
        Log.info("VeSounds: Loaded " + count + " sounds");
    }

    /**
     * 递归扫描目录, 加载所有 .ogg 文件
     * @param dir 当前扫描的目录
     * @return 加载的音频数量
     */
    private static int scanAndLoad(Fi dir) {
        int count = 0;

        // 获取目录下所有文件, 防御性处理返回 null 的情况
        Fi[] files = dir.list();
        if (files == null) {
            Log.warn("VeSounds: Failed to list directory: " + dir);
            return 0;
        }

        for (Fi file : files) {
            if (file.isDirectory()) {
                // 递归进入子目录
                count += scanAndLoad(file);
            } else if (file.extension().equals("ogg")) {
                // 只处理 .ogg 格式的音频文件
                String key = file.nameWithoutExtension(); // 文件名作为唯一标识

                // 重复检查 (暂不需要, 现有音频无重复)
                // if (sounds.containsKey(key)) {
                //     Log.warn("VeSounds: Duplicate: " + key);
                //     continue;
                // }

                // 获取相对于模组根目录的加载路径
                String loadPath = getLoadPath(file);

                // 创建 Sound 对象并存入映射表
                Sound sound = new Sound();
                sounds.put(key, sound);

                // 异步加载音频, 使用 SoundParameter 直接填充当前对象
                Core.assets.load(loadPath, Sound.class, new SoundLoader.SoundParameter(sound));

                count++;
            }
        }

        return count;
    }

    /**
     * 获取音频文件的加载路径
     * @param file 音频文件
     * @return 相对路径
     */
    private static String getLoadPath(Fi file) {
        Mods.LoadedMod mod = Vars.mods.getMod(VanillaExpansion.class);
        // 获取相对于模组根目录的路径
        String relative = file.path().substring(mod.root.path().length());
        // 移除开头的路径分隔符
        if (relative.startsWith("/") || relative.startsWith("\\")) {
            relative = relative.substring(1);
        }
        // 统一使用正斜杠
        return relative.replace("\\", "/");
    }

    /**
     * 获取音频
     * @param key 音频文件名
     * @return Sound对象, 不存在时返回 Sounds.none
     */
    public static Sound get(String key) {
        Sound s = sounds.get(key);
        if (s == null) {
            Log.warn("VeSounds: Sound not found: " + key);
            return Sounds.none;
        }
        return s;
    }

    /**
     * 检查音频是否存在
     * @param key 音频文件名
     * @return true 存在, false 不存在
     */
    public static boolean has(String key) {
        return sounds.containsKey(key);
    }

    /**
     * 获取已加载的音频数量
     * @return 音频总数
     */
    public static int size() {
        return sounds.size;
    }
}