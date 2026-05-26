package MultiCrafter_Momiji;

import arc.Core;
import arc.Events;
import arc.func.*;
import arc.graphics.g2d.*;
import arc.math.Interp;
import arc.math.geom.*;
import arc.scene.*;
import arc.scene.actions.*;
import arc.scene.event.Touchable;
import arc.scene.ui.Image;
import arc.scene.ui.layout.*;
import arc.struct.*;
import arc.util.*;
import mindustry.Vars;
import mindustry.core.UI;
import mindustry.ctype.UnlockableContent;
import mindustry.game.EventType.*;
import mindustry.gen.*;

import static mindustry.Vars.*;

/**
 * 简化版的 BlockInventoryFragment，只显示图标和数量，无点击交互。
 * 适用于任何有图标的内容（载荷、物品、液体等）。
 */
public class BlockContentFragment {
    private static final float holdShrink = 120f;

    private ObjectMap<UnlockableContent, Integer> lastData;

    Table table = new Table();
    Building build;
    float emptyTime;

    /** 提供要显示的内容数据：内容 → 数量 */
    private Prov<ObjectMap<UnlockableContent, Integer>> dataProvider;

    {
        Events.on(WorldLoadEvent.class, e -> hide());
    }

    public BlockContentFragment() {
        // 默认空数据提供者
        this.dataProvider = ObjectMap::new;
    }

    /** 设置数据提供者 */
    public void setDataProvider(Prov<ObjectMap<UnlockableContent, Integer>> provider) {
        this.dataProvider = provider;
    }

    public void build(Group parent) {
        table.name = "payload-inventory";
        table.setTransform(true);
        parent.setTransform(true);
        parent.addChild(table);
    }

    public void showFor(Building t) {
        if (this.build == t) {
            hide();
            return;
        }
        this.build = t;
        rebuild(true);
    }

    public void hide() {
        if (table == null) return;

        table.actions(
                Actions.scaleTo(0f, 1f, 0.06f, Interp.pow3Out),
                Actions.run(() -> {
                    table.clearChildren();
                    table.update(null);
                }),
                Actions.visible(false)
        );
        table.touchable = Touchable.disabled;
        build = null;
    }

    private void rebuild(boolean actions) {
        emptyTime = 0f;

        table.clearChildren();
        table.clearActions();
        table.background(Tex.inventory); // 与原版相同的淡灰背景
        table.touchable = Touchable.disabled; // 禁止交互
        table.update(() -> {
            if (Vars.control.input.config.getSelected() != build) {
                hide();
                return;
            }
            if (state.isMenu() || build == null || !build.isValid() || emptyTime >= holdShrink) {
                hide();
                return;
            }

            ObjectMap<UnlockableContent, Integer> currentData = dataProvider.get();
            if (currentData == null) currentData = new ObjectMap<>();
            if (currentData.isEmpty()) {
                emptyTime += Time.delta;
            } else {
                emptyTime = 0f;
            }

            // 检测数据是否变化
            boolean dirty = lastData == null || lastData.size != currentData.size;
            if (!dirty) {
                for (var entry : currentData.entries()) {
                    if (lastData.get(entry.key, -1) != entry.value) {
                        dirty = true;
                        break;
                    }
                }
            }

            if (dirty) {
                lastData = currentData;
                rebuild(false);
                return;
            }

            updateTablePosition();
        });

        int cols = 4; // 每行显示数量
        int row = 0;

        table.margin(4f);
        table.defaults().size(8 * 5).pad(4f);

        ObjectMap<UnlockableContent, Integer> data = dataProvider.get();
        if (data != null && !data.isEmpty()) {
            for (var entry : data.entries()) {
                UnlockableContent content = entry.key;
                int amount = entry.value;
                if (amount <= 0) continue;

                table.add(itemImage(content.uiIcon, () -> round(amount)));
                if (row++ % cols == cols - 1) table.row();
            }
        }

        if (row == 0) {
            table.setSize(0f, 0f);
        }

        updateTablePosition();

        table.visible = true;

        if (actions) {
            table.setScale(0f, 1f);
            table.actions(Actions.scaleTo(1f, 1f, 0.07f, Interp.pow3Out));
        } else {
            table.setScale(1f, 1f);
        }
    }

    private void updateTablePosition() {
        if (build == null) return;
        Vec2 v = Core.input.mouseScreen(
                build.x + build.block.size * tilesize / 2f,
                build.y + build.block.size * tilesize / 2f
        );
        table.pack();
        table.setPosition(v.x, v.y, Align.topLeft);
    }

    private String round(float f) {
        f = (int) f;
        if (f >= 1000000) {
            return (int) (f / 1000000f) + "[gray]" + UI.millions;
        } else if (f >= 1000) {
            return (int) (f / 1000) + UI.thousands;
        } else {
            return (int) f + "";
        }
    }

    private Element itemImage(TextureRegion region, Prov<CharSequence> text) {
        Stack stack = new Stack();

        Table t = new Table().left().bottom();
        t.label(text);

        stack.add(new Image(region));
        stack.add(t);
        return stack;
    }
}