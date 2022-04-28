package gaozhi.online.ugui.core.activity.widget;

import gaozhi.online.ugui.core.activity.widget.ui.BasicRoundRectUI;

import javax.swing.*;
import java.awt.*;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO 重绘按钮
 * @date 2022/4/22 18:50
 */
public class UButton extends JButton {
    private BasicRoundRectUI basicRoundRectUI;

    public UButton() {
        this(null);
    }

    public UButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        basicRoundRectUI = new BasicRoundRectUI(this);
    }

    public BasicRoundRectUI getBasicRoundRectUI() {
        return basicRoundRectUI;
    }

    public void setBasicRoundRectUI(BasicRoundRectUI basicRoundRectUI) {
        this.basicRoundRectUI = basicRoundRectUI;
    }

    @Override
    protected void paintComponent(Graphics g) {
        basicRoundRectUI.setArc(getHeight()/2);
        basicRoundRectUI.paintComponent(g);
        super.paintComponent(g);
    }
}
