package gaozhi.online.ugui.core.activity.widget.ui;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO 优化 comboBox
 * @date 2022/4/28 18:13
 */
public class UComboBoxUI extends BasicComboBoxUI {
    private BasicRoundRectUI basicRoundRectUI;

    public UComboBoxUI() {
        currentValuePane = new CellRendererPane(){

        };
    }

    @Override
    protected JButton createArrowButton() {
        JButton btn_arrow = new JButton("...");
        btn_arrow.setOpaque(false);
        btn_arrow.setContentAreaFilled(false);
        btn_arrow.setBorderPainted(false);
        btn_arrow.setFocusPainted(false);
        btn_arrow.setBorder(null);
        return btn_arrow;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        if (basicRoundRectUI == null) {
            basicRoundRectUI = new BasicRoundRectUI(c);
        }
        basicRoundRectUI.setArc(comboBox.getHeight() / 2);
        basicRoundRectUI.paintComponent(g);
        super.paint(g, c);
    }

    @Override
    public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
       // super.paintCurrentValueBackground(g, bounds, hasFocus);
    }
}
