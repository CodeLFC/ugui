package gaozhi.online.ugui.core.resource;

import javax.swing.*;
import java.awt.*;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO 字体
 * @date 3/13/2022 7:14 PM
 */
public class FontClass {
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

    public static void loadIndyFont(FontExample font,Color foreground) {

        UIManager.put("CheckBox.font", font.getFont());
        UIManager.put("Tree.font",  font.getFont());
        UIManager.put("Viewport.font",  font.getFont());
        UIManager.put("ProgressBar.font",  font.getFont());
        UIManager.put("RadioButtonMenuItem.font",  font.getFont());
        UIManager.put("FormattedTextField.font",  font.getFont());
        UIManager.put("ToolBar.font",  font.getFont());
        UIManager.put("ColorChooser.font",  font.getFont());
        UIManager.put("ToggleButton.font",  font.getFont());
        UIManager.put("Panel.font",  font.getFont());
        UIManager.put("TextArea.font",  font.getFont());
        UIManager.put("Menu.font",  font.getFont());
        UIManager.put("RadioButtonMenuItem.acceleratorFont",  font.getFont());
        UIManager.put("Spinner.font",  font.getFont());
        UIManager.put("Menu.acceleratorFont",  font.getFont());
        UIManager.put("CheckBoxMenuItem.acceleratorFont",  font.getFont());
        UIManager.put("TableHeader.font",  font.getFont());
        UIManager.put("TextField.font",  font.getFont());
        UIManager.put("OptionPane.font",  font.getFont());
        UIManager.put("MenuBar.font",  font.getFont());
        UIManager.put("Button.font",  font.getFont());
        UIManager.put("Label.font",  font.getFont());
        UIManager.put("PasswordField.font",  font.getFont());
        UIManager.put("InternalFrame.titleFont",  font.getFont());
        UIManager.put("OptionPane.buttonFont",  font.getFont());
        UIManager.put("ScrollPane.font",  font.getFont());
        UIManager.put("MenuItem.font",  font.getFont());
        UIManager.put("ToolTip.font",  font.getFont());
        UIManager.put("List.font",  font.getFont());
        UIManager.put("OptionPane.messageFont",  font.getFont());
        UIManager.put("EditorPane.font",  font.getFont());
        UIManager.put("Table.font",  font.getFont());
        UIManager.put("TabbedPane.font",  font.getFont());
        UIManager.put("RadioButton.font",  font.getFont());
        UIManager.put("CheckBoxMenuItem.font",  font.getFont());
        UIManager.put("TextPane.font",  font.getFont());
        UIManager.put("PopupMenu.font",  font.getFont());
        UIManager.put("TitledBorder.font",  font.getFont());
        UIManager.put("ComboBox.font",  font.getFont());

        //    foreground
        UIManager.put("CheckBox.foreground",foreground);
        UIManager.put("Tree.foreground", foreground);
        UIManager.put("Viewport.foreground", foreground);
        UIManager.put("ProgressBar.foreground",  foreground);
        UIManager.put("RadioButtonMenuItem.foreground",foreground);
        UIManager.put("FormattedTextField.foreground",  foreground);
        UIManager.put("ToolBar.foreground",  foreground);
        UIManager.put("ColorChooser.foreground", foreground);
        UIManager.put("ToggleButton.foreground",  foreground);
        UIManager.put("Panel.foreground",  foreground);
        UIManager.put("TextArea.foreground", foreground);
        UIManager.put("Menu.foreground",  foreground);
        UIManager.put("RadioButtonMenuItem.foreground",  foreground);
        UIManager.put("Spinner.foreground", foreground);
        UIManager.put("Menu.foreground", foreground);
        UIManager.put("CheckBoxMenuItem.foreground", foreground);
        UIManager.put("TableHeader.foreground", foreground);
        UIManager.put("TextField.foreground", foreground);
        UIManager.put("OptionPane.foreground",  foreground);
        UIManager.put("MenuBar.foreground", foreground);
        UIManager.put("Button.foreground",  foreground);
        UIManager.put("Label.foreground",  foreground);
        UIManager.put("PasswordField.foreground",  foreground);
        UIManager.put("InternalFrame.foreground", foreground);
        UIManager.put("OptionPane.foreground",  foreground);
        UIManager.put("ScrollPane.foreground",  foreground);
        UIManager.put("MenuItem.foreground",  foreground);
        UIManager.put("ToolTip.foreground", foreground);
        UIManager.put("List.foreground",  foreground);
        UIManager.put("OptionPane.foreground",  foreground);
        UIManager.put("EditorPane.foreground", foreground);
        UIManager.put("Table.foreground",  foreground);
        UIManager.put("TabbedPane.foreground", foreground);
        UIManager.put("RadioButton.foreground",  foreground);
        UIManager.put("CheckBoxMenuItem.foreground",  foreground);
        UIManager.put("TextPane.foreground",  foreground);
        UIManager.put("PopupMenu.foreground",  foreground);
        UIManager.put("TitledBorder.foreground",  foreground);
        UIManager.put("ComboBox.foreground",  foreground);
    }
}