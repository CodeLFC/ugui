package gaozhi.online.ugui.core.activity.widget;

import gaozhi.online.ugui.core.activity.widget.ui.BasicRoundRectUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO 重写 JTextField
 * @date 3/14/2022 10:05 AM
 */
public class UTextField extends JTextField {
    private final BasicRoundRectUI basicRoundRectUI = new BasicRoundRectUI(this);
    private final ReminderFocusAdapter reminderFocusAdapter = new ReminderFocusAdapter(this, null);
    private Color hintColor = Color.LIGHT_GRAY;
    public UTextField() {
        super("");
        addFocusListener(reminderFocusAdapter);
        setOpaque(false);
        setBorder(null);
        setHorizontalAlignment(CENTER);
    }

    public void setHint(String hint) {
        reminderFocusAdapter.setReminder(hint);
    }

    public Color getHintColor() {
        return hintColor;
    }

    public void setHintColor(Color hintColor) {
        this.hintColor = hintColor;
    }

    public String getUText() {
        if (reminderFocusAdapter.isHintState) {
            return "";
        }
        return getText();
    }

    @Override
    protected void paintComponent(Graphics g) {
        basicRoundRectUI.setArc(getHeight()/2);
        basicRoundRectUI.paintComponent(g);
        super.paintComponent(g);
    }

    /**
     * @author LiFucheng
     * @version 1.0
     * @description: TODO 提示词
     * @date 3/14/2022 10:04 AM
     */
    private static class ReminderFocusAdapter extends FocusAdapter {  //JTextField提示文字通用方法
        private final UTextField txt;
        private String reminder;
        private final Color foreground;
        private boolean isHintState;

        //初始化
        public ReminderFocusAdapter(UTextField txt_, String reminderString_) {
            // TODO Auto-generated constructor stub
            txt = txt_;
            reminder = reminderString_;
            foreground = txt.getForeground();
            isHintState = false;
        }

        //焦点获得
        @Override
        public void focusGained(FocusEvent e) {
            String tempString = txt.getText();
            if (tempString.equals(reminder)) {
                txt.setText("");
                txt.setForeground(foreground);
                isHintState = false;
            }
        }

        //焦点失去
        @Override
        public void focusLost(FocusEvent e) {
            String tempString = txt.getText();
            if (tempString.equals("")) {
                txt.setForeground(txt.getHintColor());
                txt.setText(reminder);
                isHintState = true;
            }
        }

        public String getReminder() {
            return reminder;
        }

        public void setReminder(String reminder) {
            this.reminder = reminder;
        }
    }
}
