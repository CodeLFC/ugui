package gaozhi.online.ugui.core.resource;

import javax.swing.*;
import java.awt.*;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO 字体
 * @date 3/13/2022 7:14 PM
 */
public class StyleClass {
    public enum FontExample {
        SONG16(new Font("宋体", Font.PLAIN, 16)),
        SONG14(new Font("宋体", Font.PLAIN, 14));
        private final Font font;

        FontExample(Font font) {
            this.font = font;
        }

        public Font getFont() {
            return font;
        }
    }

    private static Color foreground = Color.WHITE;
    private static Color background = Color.BLACK;
    private static Color panelColor = Color.BLACK;

    private static Font font = FontExample.SONG16.getFont();

    public static Color getForeground() {
        return foreground;
    }

    public static Color getBackground() {
        return background;
    }

    public static Font getFont() {
        return font;
    }

    public static Color getPanelColor() {
        return panelColor;
    }

    public static void setPanelColor(Color panelColor) {
        StyleClass.panelColor = panelColor;
        UIManager.put("Panel.foreground", panelColor);
        UIManager.put("Panel.background", panelColor);
    }

    public static void setForeground(Color foreground) {
        StyleClass.foreground = foreground;
        //    foreground
        UIManager.put("CheckBox.foreground", foreground);
        UIManager.put("Tree.foreground", foreground);
        UIManager.put("Viewport.foreground", foreground);
        UIManager.put("ProgressBar.foreground", foreground);
        UIManager.put("RadioButtonMenuItem.foreground", foreground);
        UIManager.put("FormattedTextField.foreground", foreground);
        UIManager.put("ToolBar.foreground", foreground);
        UIManager.put("ColorChooser.foreground", foreground);
        UIManager.put("ToggleButton.foreground", foreground);
        UIManager.put("TextArea.foreground", foreground);
        UIManager.put("Menu.foreground", foreground);
        UIManager.put("RadioButtonMenuItem.foreground", foreground);
        UIManager.put("Spinner.foreground", foreground);
        UIManager.put("Menu.foreground", foreground);
        UIManager.put("CheckBoxMenuItem.foreground", foreground);
        UIManager.put("TableHeader.foreground", foreground);
        UIManager.put("TextField.foreground", foreground);
        UIManager.put("OptionPane.foreground", foreground);
        UIManager.put("MenuBar.foreground", foreground);
        UIManager.put("Button.foreground", foreground);
        UIManager.put("Label.foreground", foreground);
        UIManager.put("PasswordField.foreground", foreground);
        UIManager.put("InternalFrame.foreground", foreground);
        UIManager.put("OptionPane.foreground", foreground);
        UIManager.put("ScrollPane.foreground", foreground);
        UIManager.put("MenuItem.foreground", foreground);
        UIManager.put("ToolTip.foreground", foreground);
        UIManager.put("List.foreground", foreground);
        UIManager.put("OptionPane.foreground", foreground);
        UIManager.put("EditorPane.foreground", foreground);
        UIManager.put("Table.foreground", foreground);
        UIManager.put("TabbedPane.foreground", foreground);
        UIManager.put("RadioButton.foreground", foreground);
        UIManager.put("CheckBoxMenuItem.foreground", foreground);
        UIManager.put("TextPane.foreground", foreground);
        UIManager.put("PopupMenu.foreground", foreground);
        UIManager.put("TitledBorder.foreground", foreground);
        UIManager.put("ComboBox.foreground", foreground);
    }

    public static void setBackground(Color background) {
        StyleClass.background = background;
        //    foreground
        UIManager.put("CheckBox.background", background);
        UIManager.put("Tree.background", background);
        UIManager.put("Viewport.background", background);
        UIManager.put("ProgressBar.background", background);
        UIManager.put("RadioButtonMenuItem.background", background);
        UIManager.put("FormattedTextField.background", background);
        UIManager.put("ToolBar.background", background);
        UIManager.put("ColorChooser.background", background);
        UIManager.put("ToggleButton.background", background);
        UIManager.put("TextArea.background", background);
        UIManager.put("Menu.background", background);
        UIManager.put("RadioButtonMenuItem.background", background);
        UIManager.put("Spinner.background", background);
        UIManager.put("Menu.background", background);
        UIManager.put("CheckBoxMenuItem.background", background);
        UIManager.put("TableHeader.background", background);
        UIManager.put("TextField.background", background);
        UIManager.put("OptionPane.background", background);
        UIManager.put("MenuBar.background", background);
        UIManager.put("Button.background", background);
        UIManager.put("Label.background", background);
        UIManager.put("PasswordField.background", background);
        UIManager.put("InternalFrame.background", background);
        UIManager.put("OptionPane.background", background);
        UIManager.put("ScrollPane.background", background);
        UIManager.put("MenuItem.background", background);
        UIManager.put("ToolTip.background", background);
        UIManager.put("List.background", background);
        UIManager.put("OptionPane.background", background);
        UIManager.put("EditorPane.background", background);
        UIManager.put("Table.background", background);
        UIManager.put("TabbedPane.background", background);
        UIManager.put("RadioButton.background", background);
        UIManager.put("CheckBoxMenuItem.background", background);
        UIManager.put("TextPane.background", background);
        UIManager.put("PopupMenu.background", background);
        UIManager.put("TitledBorder.background", background);
        UIManager.put("ComboBox.background", background);
    }

    public static void setFont(Font font) {
        StyleClass.font = font;
        UIManager.put("CheckBox.font", font);
        UIManager.put("Tree.font", font);
        UIManager.put("Viewport.font", font);
        UIManager.put("ProgressBar.font", font);
        UIManager.put("RadioButtonMenuItem.font",font);
        UIManager.put("FormattedTextField.font", font);
        UIManager.put("ToolBar.font",font);
        UIManager.put("ColorChooser.font",font);
        UIManager.put("ToggleButton.font",font);
        UIManager.put("Panel.font", font);
        UIManager.put("TextArea.font",font);
        UIManager.put("Menu.font", font);
        UIManager.put("RadioButtonMenuItem.acceleratorFont", font);
        UIManager.put("Spinner.font", font);
        UIManager.put("Menu.acceleratorFont",font);
        UIManager.put("CheckBoxMenuItem.acceleratorFont", font);
        UIManager.put("TableHeader.font",font);
        UIManager.put("TextField.font", font);
        UIManager.put("OptionPane.font", font);
        UIManager.put("MenuBar.font", font);
        UIManager.put("Button.font", font);
        UIManager.put("Label.font",font);
        UIManager.put("PasswordField.font", font);
        UIManager.put("InternalFrame.titleFont", font);
        UIManager.put("OptionPane.buttonFont", font);
        UIManager.put("ScrollPane.font", font);
        UIManager.put("MenuItem.font", font);
        UIManager.put("ToolTip.font", font);
        UIManager.put("List.font", font);
        UIManager.put("OptionPane.messageFont", font);
        UIManager.put("EditorPane.font", font);
        UIManager.put("Table.font", font);
        UIManager.put("TabbedPane.font", font);
        UIManager.put("RadioButton.font", font);
        UIManager.put("CheckBoxMenuItem.font", font);
        UIManager.put("TextPane.font", font);
        UIManager.put("PopupMenu.font", font);
        UIManager.put("TitledBorder.font", font);
        UIManager.put("ComboBox.font", font);
    }
}