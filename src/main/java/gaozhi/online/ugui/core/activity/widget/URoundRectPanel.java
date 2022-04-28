package gaozhi.online.ugui.core.activity.widget;

import java.awt.*;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO 圆角
 * @date 2022/4/14 20:16
 */
public class URoundRectPanel extends UPanel {

    private int arc = 20;
    private Dimension activitySize = new Dimension(100, 100);

    public int getArc() {
        return arc;
    }

    public void setArc(int arc) {
        this.arc = arc;
    }

    public Dimension getActivitySize() {
        return activitySize;
    }

    public void setActivitySize(Dimension activitySize) {
        this.activitySize = activitySize;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = ((Graphics2D) g.create());
        graphics2D.fillRoundRect(0, 0, activitySize.width, activitySize.height, arc, arc);
        graphics2D.dispose();
        // System.out.println("重绘制："+activitySize.toString());
        super.paintComponent(g);
    }

}
