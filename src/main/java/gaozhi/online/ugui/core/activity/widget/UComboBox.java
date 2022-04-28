package gaozhi.online.ugui.core.activity.widget;

import gaozhi.online.ugui.core.activity.widget.ui.UComboBoxUI;

import javax.swing.*;
import java.awt.*;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO
 * @date 2022/4/28 18:04
 */
public class UComboBox<T> extends JComboBox<T> {

    public UComboBox() {
        setOpaque(false);
        setUI(new UComboBoxUI());

        setRenderer(new URecyclerCellRender<T>() {
            @Override
            protected ViewHolder<T> createViewHolder() {
                return new ViewHolder<T>() {
                    private final ULabel label = new ULabel();

                    {
                        add(label);
                    }

                    @Override
                    public void bindView(int index, boolean isSelected, boolean cellHasFocus, T value) {
                        label.setText(value.toString());
                    }
                };
            }
        });
    }

    public void setRenderer(URecyclerCellRender<? super T> aRenderer) {
        super.setRenderer(aRenderer);
    }
}
