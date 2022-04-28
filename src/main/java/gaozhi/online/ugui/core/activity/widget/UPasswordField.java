package gaozhi.online.ugui.core.activity.widget;

import gaozhi.online.ugui.core.activity.widget.ui.BasicRoundRectUI;

import javax.swing.*;
import java.awt.*;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO password 重写
 * @date 2022/4/28 14:27
 */
public class UPasswordField extends JPasswordField {
    private final BasicRoundRectUI basicRoundRectUI = new BasicRoundRectUI(this);

    public UPasswordField() {
        setOpaque(false);
        setBorder(null);
        setHorizontalAlignment(CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        basicRoundRectUI.setArc(getHeight() / 2);
        basicRoundRectUI.paintComponent(g);
        super.paintComponent(g);
    }
}
