package vanilla.expansion.assetsload;

import arc.Core;
import arc.files.Fi;
import arc.graphics.*;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.PixmapRegion;
import arc.graphics.g2d.TextureAtlas;
import arc.graphics.g2d.TextureRegion;
import arc.graphics.gl.FrameBuffer;
import arc.graphics.gl.PixmapTextureData;
import arc.struct.ObjectIntMap;
import arc.struct.ObjectMap;
import arc.struct.Seq;
import arc.util.Log;
import mindustry.Vars;
import mindustry.graphics.MultiPacker;
import mindustry.graphics.MultiPacker.PageType;

import java.nio.ByteBuffer;

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

    /**
     * 从大图中裁剪一个矩形区域，以指定名称注册到主图集。
     *
     * @param packer     MultiPacker 实例
     * @param sheetPath  大图在 mod 文件树中的路径，例如 "vesprites/my_sheet.png"
     * @param regionName 注册到图集的区域名（完整名称，如 "ve2-myicon"）
     * @param x          裁剪区域在大图中的起始 X 坐标（像素）
     * @param y          裁剪区域在大图中的起始 Y 坐标（像素）
     * @param width      裁剪宽度（像素）
     * @param height     裁剪高度（像素）
     */
    public static void packRegion(MultiPacker packer, String sheetPath, String regionName,
                                  int x, int y, int width, int height) {
        packRegion(packer, sheetPath, "", regionName, x, y, width, height);
    }

    /**
     * 从大图中裁剪一个矩形区域，以“前缀+名称”注册到主图集。
     *
     * @param prefix     名称前缀（如 "ve2-"），若无需前缀可传空字符串
     * @param regionName 基础区域名（不含前缀），最终名称 = prefix + regionName
     */
    public static void packRegion(MultiPacker packer, String sheetPath, String prefix, String regionName,
                                  int x, int y, int width, int height) {
        String fullName = prefix + regionName;

        Fi file = Vars.tree.get(sheetPath);
        if (file == null || !file.exists()) {
            Log.err("Sprite sheet not found in tree: " + sheetPath);
            return;
        }

        Pixmap sheet = new Pixmap(file);
        if (x < 0 || y < 0 || x + width > sheet.getWidth() || y + height > sheet.getHeight()) {
            Log.err(String.format("Crop region (%d,%d,%dx%d) out of bounds on sheet %s (%dx%d)",
                    x, y, width, height, sheetPath, sheet.getWidth(), sheet.getHeight()));
            sheet.dispose();
            return;
        }

        Pixmap sub = new Pixmap(width, height);
        sub.draw(sheet, 0, 0, x, y, width, height);

        packer.add(PageType.main, fullName, new PixmapRegion(sub));
        sub.dispose();
        sheet.dispose();

        Log.info("Packed region '@' from @ (@,@ @x@)", fullName, sheetPath, x, y, width, height);
    }

    /**
     * 调试用：在 packSprites 阶段调用，将当前图集打包器的所有页面保存为 PNG。
     * 注意：此方法会消耗一定时间，仅在开发调试时使用。
     *
     * @param packer    packSprites 传入的 MultiPacker 实例
     * @param outputDir 输出目录的绝对路径，例如 "D:/atlas_debug"
     */
    public static void debugExportPages(MultiPacker packer, String outputDir) {
        Fi dir = Core.files.absolute(outputDir);
        dir.mkdirs();

        for (PageType type : PageType.values()) {
            var pixmapPacker = packer.getPacker(type);
            var pages = pixmapPacker.getPages();
            for (int i = 0; i < pages.size; i++) {
                Pixmap pix = pages.get(i).getPixmap();
                String filename = "atlas_" + type.name() + "_page" + i + ".png";
                Fi file = dir.child(filename);
                PixmapIO.writePng(file, pix);
                Log.info("Exported @ (size: @x@)", filename, pix.getWidth(), pix.getHeight());
            }
        }
    }

    public static void exportAtlasPagesFinal(String outputDir) {
        Fi dir = Core.files.absolute(outputDir);
        dir.mkdirs();

        int index = 0;
        for (Texture tex : Core.atlas.getTextures()) {
            int w = tex.width;
            int h = tex.height;

            FrameBuffer buffer = new FrameBuffer(w, h);
            buffer.begin();
            // 绘制整个纹理到帧缓冲
            Draw.rect(new TextureRegion(tex), w/2f, h/2f, w, h);
            buffer.end();

            // 从GPU读回像素
            Pixmap pix = new Pixmap(w, h);
            buffer.begin(); // 需要重新绑定吗？读取像素前确保帧缓冲已绑定
            Gl.readPixels(0, 0, w, h, Gl.rgba, Gl.unsignedByte, pix.getPixels());
            buffer.end();

            PixmapIO.writePng(dir.child("atlas_page" + index + ".png"), pix);
            pix.dispose();
            buffer.dispose();
            index++;
        }
    }

    public static void exportSlicedAtlasPages(MultiPacker packer, String outputDir) {
        Fi dir = Core.files.absolute(outputDir);
        dir.mkdirs();

        for (PageType type : PageType.values()) {
            var pixmapPacker = packer.getPacker(type);
            var pages = pixmapPacker.getPages();
            for (int pageIdx = 0; pageIdx < pages.size; pageIdx++) {
                var page = pages.get(pageIdx);
                Pixmap fullPix = page.getPixmap();

                if (fullPix == null || fullPix.isDisposed()) {
                    Log.warn("Page pixmap is null or disposed for @ page @, skipping.", type, pageIdx);
                    continue;
                }

                int fullW = fullPix.getWidth();
                int fullH = fullPix.getHeight();
                int sliceW = Math.min(fullW, 4096);
                int sliceH = Math.min(fullH, 4096);

                int cols = (int) Math.ceil(fullW / 4096.0);
                int rows = (int) Math.ceil(fullH / 4096.0);
                int sliceIdx = 0;

                for (int r = 0; r < rows; r++) {
                    for (int c = 0; c < cols; c++) {
                        int x = c * 4096;
                        int y = r * 4096;
                        int w = Math.min(4096, fullW - x);
                        int h = Math.min(4096, fullH - y);

                        Pixmap slice = new Pixmap(w, h);
                        slice.draw(fullPix, 0, 0, x, y, w, h);

                        String filename = "atlas_" + type.name() + "_page" + pageIdx + "_slice" + sliceIdx + ".png";
                        PixmapIO.writePng(dir.child(filename), slice);
                        slice.dispose();

                        Log.info("Exported @ (@x@)", filename, w, h);
                        sliceIdx++;
                    }
                }
            }
        }
    }

    public static void exportFinalPages(MultiPacker packer, String outputDir) {
        Fi dir = Core.files.absolute(outputDir);
        dir.mkdirs();

        for (PageType type : PageType.values()) {
            var pixmapPacker = packer.getPacker(type);
            var pages = pixmapPacker.getPages();
            Log.info("PageType @: @ pages", type, pages.size);
            for (int i = 0; i < pages.size; i++) {
                Pixmap pix = pages.get(i).getPixmap();
                if (pix == null || pix.isDisposed()) continue;

                String filename = "atlas_" + type.name() + "_page" + i + ".png";
                PixmapIO.writePng(dir.child(filename), pix);
                Log.info("Exported @ (size @x@)", filename, pix.getWidth(), pix.getHeight());
            }
        }
    }

    public static void exportFinalTextures(String outputDir) {
        Fi dir = Core.files.absolute(outputDir);
        dir.mkdirs();

        // 确保像素行对齐为 1 字节，避免错位
        Gl.pixelStorei(Gl.packAlignment, 1);

        int index = 0;
        for (Texture tex : Core.atlas.getTextures()) {
            int w = tex.width;
            int h = tex.height;

            // 创建一个与纹理等大的帧缓冲
            FrameBuffer buffer = new FrameBuffer(w, h);
            buffer.begin();
            // 将整个纹理绘制到帧缓冲中
            Draw.rect(Draw.wrap(tex), w / 2f, h / 2f, w, h);
            buffer.end();

            // 从帧缓冲读回像素（OpenGL 原点在左下，需要翻转）
            ByteBuffer pixels = ByteBuffer.allocateDirect(w * h * 4);
            Gl.readPixels(0, 0, w, h, Gl.rgba, Gl.unsignedByte, pixels);

            Pixmap pix = new Pixmap(pixels, w, h);
            Pixmap flipped = pix.flipY(); // 垂直翻转，使第一行为顶部
            pix.dispose();

            String filename = "atlas_page" + index + ".png";
            PixmapIO.writePng(dir.child(filename), flipped);
            flipped.dispose();
            buffer.dispose();

            Log.info("Exported final texture page @: @ (@x@)", index, filename, w, h);
            index++;
        }
    }

    public static void exportFinalAtlasPages2(String outputDir) {
        Fi dir = Core.files.absolute(outputDir);
        dir.mkdirs();

        // 1. 像素行对齐
        Gl.pixelStorei(Gl.packAlignment, 1);

        int index = 0;
        for (Texture tex : Core.atlas.getTextures()) {
            int w = tex.width;
            int h = tex.height;

            // 2. 创建帧缓冲并绘制整个纹理
            FrameBuffer buffer = new FrameBuffer(w, h);
            buffer.begin();
            // 使用 Draw.rect 绘制整个纹理（区域中心对齐）
            Draw.rect(new TextureRegion(tex), w / 2f, h / 2f, w, h);
            buffer.end();

            // 3. 读回像素
            ByteBuffer pixels = ByteBuffer.allocateDirect(w * h * 4);
            Gl.readPixels(0, 0, w, h, Gl.rgba, Gl.unsignedByte, pixels);

            // 4. 创建 Pixmap 并翻转
            Pixmap pix = new Pixmap(pixels, w, h);
            Pixmap flipped = pix.flipY();
            pix.dispose();

            // 5. 保存 PNG
            String filename = "atlas_page_" + index + ".png";
            PixmapIO.writePng(dir.child(filename), flipped);
            flipped.dispose();
            buffer.dispose();

            Log.info("Exported final page @: @ (@x@)", index, filename, w, h);
            index++;
        }
    }

    public static void exportFinalAtlasPages(MultiPacker packer, String outputDir) {
        Fi dir = Core.files.absolute(outputDir);
        dir.mkdirs();

        for (PageType type : PageType.values()) {
            var pixmapPacker = packer.getPacker(type);
            var pages = pixmapPacker.getPages();
            for (int i = 0; i < pages.size; i++) {
                Pixmap pix = pages.get(i).getPixmap();
                if (pix == null || pix.isDisposed()) continue;

                String filename = "atlas_" + type.name() + "_page" + i + ".png";
                PixmapIO.writePng(dir.child(filename), pix);
                Log.info("Exported final page @: @ (@x@)", filename, pix.getWidth(), pix.getHeight());
            }
        }
    }

    public static void analyzeAtlasLayout(String modPrefix) {
        Log.info("=== Atlas Layout Analysis for prefix '@' ===", modPrefix);
        ObjectIntMap<Texture> texIndexMap = new ObjectIntMap<>();
        ObjectMap<Texture, Seq<String>> texRegions = new ObjectMap<>();

        int idx = 0;
        for (Texture tex : Core.atlas.getTextures()) {
            texIndexMap.put(tex, idx);
            texRegions.put(tex, new Seq<>());
            idx++;
        }

        for (TextureAtlas.AtlasRegion region : Core.atlas.getRegions()) {
            Texture tex = region.texture;
            if (tex != null && texRegions.containsKey(tex)) {
                texRegions.get(tex).add(region.name);
            }
        }

        for (Texture tex : Core.atlas.getTextures()) {
            int pageIdx = texIndexMap.get(tex, -1);
            Seq<String> allRegions = texRegions.get(tex);
            int total = allRegions.size;
            int modCount = 0;
            // 手动计数
            for (int i = 0; i < total; i++) {
                if (allRegions.get(i).startsWith(modPrefix)) {
                    modCount++;
                }
            }
            Log.info("Page @: @x@  总区域: @  模组区域: @", pageIdx, tex.width, tex.height, total, modCount);
            if (modCount > 0) {
                Log.info("  模组区域列表:");
                for (int i = 0; i < total; i++) {
                    String name = allRegions.get(i);
                    if (name.startsWith(modPrefix)) {
                        Log.info("    - @", name);
                    }
                }
            }
        }
    }

    public static void exportAtlasPagesFromTextures(String outputDir) {
        Fi dir = Core.files.absolute(outputDir);
        dir.mkdirs();

        int index = 0;
        for (Texture tex : Core.atlas.getTextures()) {
            TextureData data = tex.getTextureData();
            // 只处理 PixmapTextureData，且 consumePixmap 不会返回 null
            if (data instanceof PixmapTextureData) {
                Pixmap pix = data.consumePixmap();
                if (pix != null && !pix.isDisposed()) {
                    String filename = "atlas_page_" + index + ".png";
                    PixmapIO.writePng(dir.child(filename), pix);
                    Log.info("Exported page @: @ (@x@)", index, filename, pix.getWidth(), pix.getHeight());
                } else {
                    Log.err("Page @: Pixmap is null or disposed.", index);
                }
            } else {
                Log.warn("Page @: texture data is not PixmapTextureData.", index);
            }
            index++;
        }
    }

    public static void exportFinalAtlasPages(String outputDir) {
        Core.app.post(() -> {
            Fi dir = Core.files.absolute(outputDir);
            dir.mkdirs();

            // 像素行对齐
            Gl.pixelStorei(Gl.packAlignment, 1);

            int index = 0;
            for (Texture tex : Core.atlas.getTextures()) {
                int w = tex.width;
                int h = tex.height;

                // 创建帧缓冲，begin 会自动设置视口和正交投影 (0,0)~(w,h)
                FrameBuffer buffer = new FrameBuffer(w, h);
                buffer.begin();

                // 清除残余状态，保证 1:1 绘制纹理
                Draw.flush();
                Draw.reset();

                // 绘制纹理，使其刚好覆盖整个帧缓冲（中心对齐）
                Draw.rect(new TextureRegion(tex), w / 2f, h / 2f, w, h);

                // 必须在 buffer.end() 之前读取像素
                ByteBuffer pixels = ByteBuffer.allocateDirect(w * h * 4);
                Gl.readPixels(0, 0, w, h, Gl.rgba, Gl.unsignedByte, pixels);

                buffer.end();

                // OpenGL 原点在左下，翻转为上左
                Pixmap pix = new Pixmap(pixels, w, h);
                Pixmap flipped = pix.flipY();
                pix.dispose();

                String filename = "atlas_page_" + index + ".png";
                PixmapIO.writePng(dir.child(filename), flipped);
                flipped.dispose();
                buffer.dispose();

                Log.info("Exported page @: @ (@x@)", index, filename, w, h);
                index++;
            }
        });
    }
}
