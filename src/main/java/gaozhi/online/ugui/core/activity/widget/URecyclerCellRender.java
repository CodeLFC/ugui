package gaozhi.online.ugui.core.activity.widget;

import gaozhi.online.ugui.core.activity.Context;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO   Recycler的元素渲染器
 * @date 2022/3/16 21:43
 */
public abstract class URecyclerCellRender<T> implements ListCellRenderer<T> {
    private final Map<Integer, ViewHolder<T>> viewHolderMap = new HashMap<Integer, ViewHolder<T>>();

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        ViewHolder viewHolder;
        if (!viewHolderMap.containsKey(index)) {
            viewHolderMap.put(index, createViewHolder());
        }
        viewHolder = viewHolderMap.get(index);
        viewHolder.bindView(index, isSelected, cellHasFocus, value);
        return viewHolder;
    }

    public ViewHolder<T> getViewHolder(int index) {
        return viewHolderMap.get(index);
    }

    /**
     * @description: TODO 创建ViewHolder
     * @author LiFucheng
     * @date 2022/4/28 20:15
     * @version 1.0
     */
    protected abstract ViewHolder<T> createViewHolder();

    /**
     * @author LiFucheng
     * @version 1.0
     * @description: TODO holder
     * @date 2022/4/28 20:14
     */
    public static abstract class ViewHolder<T> extends UPanel {
        public abstract void bindView(int index, boolean isSelected, boolean cellHasFocus, T value);
    }
}
