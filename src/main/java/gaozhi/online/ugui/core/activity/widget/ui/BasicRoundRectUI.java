package gaozhi.online.ugui.core.activity.widget.ui;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO
 * @date 2022/4/28 10:13
 */
public class BasicRoundRectUI {
    //鼠标悬浮
    private boolean hover;
    private int arc = 10;
    private Component component;

    public BasicRoundRectUI(Component component) {
        this.component = component;
        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hover = true;
                component.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hover = false;
                component.repaint();
            }
        });
    }

    public boolean isHover() {
        return hover;
    }

    public void setHover(boolean hover) {
        this.hover = hover;
    }

    public int getArc() {
        return arc;
    }

    public void setArc(int arc) {
        this.arc = arc;
    }

    public void paintComponent(Graphics g) {
        paint(g, true);
    }

    public void paintBorder(Graphics g) {
        paint(g, false);
    }

    private void paint(Graphics g, boolean fill) {
        Graphics2D g2d = (Graphics2D) g.create();
        float tran = 1F;
        if (!hover) {
            tran = 0.9F;
        }
        //步骤2
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        //设置透明度
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                tran));
        g2d.setPaint(component.getBackground());
        if (fill) {
            g2d.fillRoundRect(0, 0, component.getWidth(), component.getHeight(), arc, arc);
        } else {
            g2d.drawRoundRect(0, 0, component.getWidth(), component.getHeight(), arc, arc);
        }
        g2d.dispose();
    }
}
