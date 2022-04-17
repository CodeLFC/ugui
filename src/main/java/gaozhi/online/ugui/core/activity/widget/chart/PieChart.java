package gaozhi.online.ugui.core.activity.widget.chart;

import gaozhi.online.ugui.core.activity.widget.UPanel;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO  饼状图
 * @date 2022/4/16 17:31
 */
public class PieChart extends UPanel {
    private final Map<String, Integer> propertyMap;
    private int total;
    private final Random colorRandom;

    public PieChart() {
        propertyMap = new HashMap<>();
        colorRandom = new Random();
    }

    public void setProperty(String name, Integer size) {
        if (propertyMap.containsKey(name)) {
            total -= propertyMap.get(name);
        }
        total += size;
        propertyMap.put(name, size);
        repaint();
    }

    public void removeProperty(String name) {
        if (propertyMap.containsKey(name)) {
            total -= propertyMap.get(name);
        }
        propertyMap.remove(name);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (propertyMap.size() <= 0) return;

        Graphics2D graphics2D = (Graphics2D) g;
        // 平滑绘制 （ 反锯齿 )
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int x =0;
        int y = 0;
        int D = Math.min(getHeight(), getWidth());
        Rectangle rect = new Rectangle(x, y, D, D);
        int centerX = x + D / 2;
        int centerY = y + D / 2;

        int startDegree = 0;
        int count = 0;
        for (Map.Entry<String, Integer> entry : propertyMap.entrySet()) {
            int degree = (int) (entry.getValue() * 360.0 / total);
            if (++count == propertyMap.size()) {
                degree = 360 - startDegree;
            }
            Arc2D pie = new Arc2D.Double(rect, startDegree, degree, Arc2D.PIE);
            graphics2D.setPaint(nextColor());
            graphics2D.fill(pie);
            //graphics2D
            int strX = (int) (centerX - D / 6 + D / 3 * Math.cos(Math.toRadians(startDegree + degree / 2)));
            int strY = (int) (centerY - D / 3 * Math.sin(Math.toRadians(startDegree + degree / 2)));
            graphics2D.setPaint(Color.BLACK);
            graphics2D.drawString(entry.getKey() + String.format(":%.1f", degree / 3.6) + "%", strX, strY);
            startDegree += degree;
        }

    }

    private Color nextColor() {
        return new Color(colorRandom.nextInt(0xFFFFFF));
    }
}
