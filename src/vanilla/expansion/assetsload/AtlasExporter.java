package vanilla.expansion.assetsload;

import arc.Core;
import arc.files.Fi;
import arc.graphics.Pixmap;
import arc.graphics.PixmapIO;
import arc.graphics.Texture;
import arc.graphics.g2d.TextureAtlas;
import arc.util.Log;

public class AtlasExporter {

    /** 导出当前 Core.atlas 中所有纹理页面到指定目录（例如游戏根目录或 mod 配置目录） */
    public static void exportAtlasPages(String outputDirPath) {
        Fi dir = Core.files.absolute(outputDirPath);
        dir.mkdirs();

        TextureAtlas atlas = Core.atlas;
        int index = 0;
        for (Texture texture : atlas.getTextures()) {
            // 获取纹理数据到 Pixmap
            texture.getTextureData().prepare();
            Pixmap pix = texture.getTextureData().consumePixmap();
            if (pix != null) {
                Fi file = dir.child("atlas_page_" + index + ".png");
                PixmapIO.writePng(file, pix);
                Log.info("Exported atlas page @: @", index, file.absolutePath());
                pix.dispose();
            }
            index++;
        }
    }
}
