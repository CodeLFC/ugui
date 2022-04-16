package gaozhi.online.ugui.core;

import gaozhi.online.ugui.core.activity.Context;
import gaozhi.online.ugui.core.asynchronization.TaskExecutor;
import gaozhi.online.ugui.core.resource.FontClass;
import gaozhi.online.ugui.core.resource.Resources;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.SubstanceSkin;

import java.awt.*;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO 主应用
 * @date 2022/1/25 13:28
 */
public class Application extends Context {
    private final TaskExecutor taskExecutor = new TaskExecutor();

    public Application() {
        this(new Resources("config.application"));
    }

    public Application(Resources resources) {
        super(resources);
    }

    public void configSkin(SubstanceSkin substanceSkin) {

        //JFrame.setDefaultLookAndFeelDecorated(true);
        //JDialog.setDefaultLookAndFeelDecorated(true);
        taskExecutor.executeInUIThread(() -> {
            //启动页面
            SubstanceLookAndFeel.setSkin(substanceSkin);
        });
    }
}
