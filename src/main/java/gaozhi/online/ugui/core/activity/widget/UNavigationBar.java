package gaozhi.online.ugui.core.activity.widget;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO 导航栏
 * @date 2022/4/12 20:45
 */
public class UNavigationBar extends UPanel implements ActionListener {
    private final GridLayout navigationPanelGridLayout = new GridLayout();
    private int selected;
    private UItemSelectedListener uItemSelectedListener;
    private Orientation orientation;
    private Color itemSelectedColor = Color.BLACK;
    private Color itemUnSelectedColor = Color.GRAY;

    public enum Orientation {
        HORIZON,
        VERTICAL;
    }

    public UNavigationBar() {
        this(Orientation.HORIZON);
    }

    public UNavigationBar(Orientation orientation) {
        this.orientation = orientation;
        setLayout(navigationPanelGridLayout);
        setBackground(Color.WHITE);
    }

    public void setItems(String[] items) {
        removeAll();
        if (orientation == Orientation.VERTICAL) {
            navigationPanelGridLayout.setColumns(1);
            navigationPanelGridLayout.setRows(items.length);
        } else {
            navigationPanelGridLayout.setRows(1);
            navigationPanelGridLayout.setColumns(items.length);
        }
        for (int i = 0; i < items.length; i++) {
            UItemView item = new UItemView(i, items[i]);
            item.setHorizontalAlignment(JLabel.CENTER);
            item.setVerticalAlignment(JLabel.CENTER);
            item.setBorder(new EmptyBorder(10, 10, 10, 10));
            item.setActionListener(this);
            add(item);
        }
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
        UItemView itemView = updateColor();

        actionPerformed(new ActionEvent(itemView, itemView.getIndex(), null));
    }

    public Color getItemSelectedColor() {
        return itemSelectedColor;
    }

    public void setItemSelectedColor(Color itemSelectedColor) {
        this.itemSelectedColor = itemSelectedColor;
        updateColor();
    }

    public Color getItemUnSelectedColor() {
        return itemUnSelectedColor;
    }

    public void setItemUnSelectedColor(Color itemUnSelectedColor) {
        this.itemUnSelectedColor = itemUnSelectedColor;
        updateColor();
    }

    public UItemSelectedListener getuItemSelectedListener() {
        return uItemSelectedListener;
    }

    public void setuItemSelectedListener(UItemSelectedListener uItemSelectedListener) {
        this.uItemSelectedListener = uItemSelectedListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(e.getSource() instanceof UItemView)) {
            return;
        }

        UItemView itemView = (UItemView) e.getSource();
        selected = itemView.getIndex();
        updateColor();
        if (uItemSelectedListener == null) {
            return;
        }
        uItemSelectedListener.onClick(itemView);
    }

    /**
     * @description: TODO 更新显示的颜色
     * @author LiFucheng
     * @date 2022/4/12 21:09
     * @version 1.0
     */
    private UItemView updateColor() {
        UItemView selectedView = null;
        for (Component component : getComponents()) {
            if (component instanceof UItemView) {
                if (((UItemView) component).index != selected) {
                    component.setForeground(itemUnSelectedColor);
                } else {
                    component.setForeground(itemSelectedColor);
                    selectedView = (UItemView) component;
                }
            }
        }
        return selectedView;
    }

    @FunctionalInterface
    public interface UItemSelectedListener {
        void onClick(UItemView itemView);
    }

    public static class UItemView extends ULabel {
        private final int index;
        private final String item;

        public UItemView(int index, String item) {
            this.index = index;
            this.item = item;
            setText(item);
        }

        public int getIndex() {
            return index;
        }

        public String getItem() {
            return item;
        }
    }
}
