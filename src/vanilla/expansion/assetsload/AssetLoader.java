package vanilla.expansion.assetsload;

import arc.Core;
import arc.files.Fi;
import arc.graphics.Pixmap;
import arc.graphics.g2d.PixmapRegion;
import arc.graphics.g2d.TextureRegion;
import arc.util.Log;
import mindustry.Vars;
import mindustry.graphics.MultiPacker;
import mindustry.graphics.MultiPacker.PageType;

public class AssetLoader {

    /**
     * 在 packSprites 阶段调用，将精灵表裁剪并注册到全局图集。
     *
     * @param packer      MultiPacker 实例（来自 packSprites 参数）
     * @param sheetPath   精灵表在 mod 文件树中的路径，如 "vesprites/nitroalkoss.png"
     * @param baseName    基础区域名，第一帧为 baseName，后续为 baseName+1, baseName+2...
     * @param cols        列数
     * @param rows        行数（包括可能存在的空白行）
     * @param frameWidth  单帧宽度（像素）
     * @param frameHeight 单帧高度（像素）
     * @param padding     帧间隔（像素），通常为 0
     * @param blanks      末尾空白帧数量（最后 n 个位置不生成贴图），0 表示无空白
     */
    public static void packSheet(MultiPacker packer, String sheetPath, String baseName,
                                 int cols, int rows, int frameWidth, int frameHeight,
                                 int padding, int blanks) {
        if (blanks >= cols * rows) {
            throw new IllegalArgumentException("blanks must be less than total frames");
        }

        Fi file = Vars.tree.get(sheetPath);
        if (file == null || !file.exists()) {
            Log.err("Sprite sheet not found in tree: " + sheetPath);
            return;
        }

        Pixmap sheet = new Pixmap(file);
        int sheetWidth = sheet.getWidth();
        int sheetHeight = sheet.getHeight();
        int requiredWidth = cols * frameWidth + (cols - 1) * padding;
        int requiredHeight = rows * frameHeight + (rows - 1) * padding;

        if (sheetWidth < requiredWidth || sheetHeight < requiredHeight) {
            Log.err(String.format("Sheet %s too small: %dx%d, need %dx%d",
                    sheetPath, sheetWidth, sheetHeight, requiredWidth, requiredHeight));
            sheet.dispose();
            return;
        }

        int totalFrames = cols * rows - blanks;   // 实际有效帧数
        int index = 0;                             // 当前有效帧索引
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // 超出有效帧数范围后直接停止（空白区域都在末尾）
                if (index >= totalFrames) break;

                int x = c * (frameWidth + padding);
                int y = r * (frameHeight + padding);

                Pixmap sub = new Pixmap(frameWidth, frameHeight);
                sub.draw(sheet, 0, 0, x, y, frameWidth, frameHeight);

                String regionName = (index == 0) ? baseName : baseName + index;
                packer.add(PageType.main, regionName, new PixmapRegion(sub));
                sub.dispose();

                index++;
            }
        }
        sheet.dispose();
        Log.info("Packed @ frames from @ into atlas (skipped @ blanks).", totalFrames, sheetPath, blanks);
    }

    /** 便利重载, 默认无空白帧. */
    public static void packSheet(MultiPacker packer, String sheetPath, String baseName,
                                 int cols, int rows, int frameWidth, int frameHeight, int padding) {
        packSheet(packer, sheetPath, baseName, cols, rows, frameWidth, frameHeight, padding, 0);
    }

    /**
     * 在 loadContent 阶段调用，通过区域名获取已注册的帧数组。
     *
     * @param baseName    与 packSheet 中相同的基础名
     * @param frameCount  总有效帧数（cols * rows - blanks）
     * @return TextureRegion 数组，索引 0 为 baseName，后续为 baseName+1 ...
     */
    public static TextureRegion[] getFrames(String baseName, int frameCount) {
        TextureRegion[] frames = new TextureRegion[frameCount];
        frames[0] = Core.atlas.find(baseName);
        for (int i = 1; i < frameCount; i++) {
            frames[i] = Core.atlas.find(baseName + i);
        }
        return frames;
    }

    /**
     * 使用自定义名称数组裁剪并注册精灵表到图集，可跳过末尾空白帧。
     *
     * @param names       每帧的名称数组，长度必须等于 cols * rows - blanks
     * @param blanks      末尾空白帧数（自动忽略最后 blanks 个位置）
     */
    public static void packSheet(MultiPacker packer, String sheetPath, String[] names,
                                 int cols, int rows, int frameWidth, int frameHeight,
                                 int padding, int blanks) {
        int totalFrames = cols * rows - blanks;
        if (names.length != totalFrames) {
            throw new IllegalArgumentException(
                    "names.length must equal total frames (" + totalFrames + "), but was " + names.length);
        }

        Fi file = Vars.tree.get(sheetPath);
        if (file == null || !file.exists()) {
            Log.err("Sprite sheet not found in tree: " + sheetPath);
            return;
        }

        Pixmap sheet = new Pixmap(file);
        int sheetWidth = sheet.getWidth();
        int sheetHeight = sheet.getHeight();
        int requiredWidth = cols * frameWidth + (cols - 1) * padding;
        int requiredHeight = rows * frameHeight + (rows - 1) * padding;

        if (sheetWidth < requiredWidth || sheetHeight < requiredHeight) {
            Log.err(String.format("Sheet %s too small: %dx%d, need %dx%d",
                    sheetPath, sheetWidth, sheetHeight, requiredWidth, requiredHeight));
            sheet.dispose();
            return;
        }

        int index = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (index >= totalFrames) break;

                int x = c * (frameWidth + padding);
                int y = r * (frameHeight + padding);

                Pixmap sub = new Pixmap(frameWidth, frameHeight);
                sub.draw(sheet, 0, 0, x, y, frameWidth, frameHeight);

                packer.add(PageType.main, names[index], new PixmapRegion(sub));
                sub.dispose();

                index++;
            }
        }
        sheet.dispose();
        Log.info("Packed @ frames from @ into atlas with custom names.", totalFrames, sheetPath);
    }

    /**
     * 使用自定义名称数组裁剪并注册精灵表到图集（无空白帧）。
     *
     * @param packer      MultiPacker 实例
     * @param sheetPath   精灵表文件路径（如 "vesprites/nitroalkoss.png"）
     * @param names       每帧的名称数组，长度必须等于 cols * rows
     */
    public static void packSheet(MultiPacker packer, String sheetPath, String[] names,
                                 int cols, int rows, int frameWidth, int frameHeight, int padding) {
        packSheet(packer, sheetPath, names, cols, rows, frameWidth, frameHeight, padding, 0);
    }

    /**
     * 通过自定义名称数组获取已注册的帧数组。
     *
     * @param names  与 packSheet 中相同的名称数组
     * @return TextureRegion 数组，顺序与 names 一致
     */
    public static TextureRegion[] getFrames(String[] names) {
        TextureRegion[] frames = new TextureRegion[names.length];
        for (int i = 0; i < names.length; i++) {
            frames[i] = Core.atlas.find(names[i]);
        }
        return frames;
    }

    /**
     * 使用前缀 + 名字数组裁剪并注册精灵表到图集，可跳过末尾空白帧。
     *
     * @param prefix      统一名称前缀（如 "ve2-"），会与 names 中每个元素拼接
     * @param names       帧的后缀名数组，长度必须等于 cols * rows - blanks
     * @param blanks      末尾空白帧数
     */
    public static void packSheet(MultiPacker packer, String sheetPath, String prefix, String[] names,
                                 int cols, int rows, int frameWidth, int frameHeight,
                                 int padding, int blanks) {
        String[] fullNames = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            fullNames[i] = prefix + names[i];
        }
        packSheet(packer, sheetPath, fullNames, cols, rows, frameWidth, frameHeight, padding, blanks);
    }

    /**
     * 使用前缀 + 名字数组裁剪并注册精灵表到图集（无空白帧）。
     *
     * @param packer      MultiPacker 实例
     * @param sheetPath   精灵表文件路径
     * @param prefix      统一名称前缀（如 "ve2-"），会与 names 中每个元素拼接
     * @param names       帧的后缀名数组，长度必须等于 cols * rows
     */
    public static void packSheet(MultiPacker packer, String sheetPath, String prefix, String[] names,
                                 int cols, int rows, int frameWidth, int frameHeight, int padding) {
        packSheet(packer, sheetPath, prefix, names, cols, rows, frameWidth, frameHeight, padding, 0);
    }

    /**
     * 通过前缀和名字数组获取已注册的帧数组。
     *
     * @param prefix  前缀（如 "ve2-"）
     * @param names   名字数组（不含前缀）
     * @return TextureRegion 数组，顺序与 names 一致
     */
    public static TextureRegion[] getFrames(String prefix, String[] names) {
        String[] fullNames = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            fullNames[i] = prefix + names[i];
        }
        return getFrames(fullNames);
    }
}