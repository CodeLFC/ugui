package gaozhi.online.ugui.core;

import gaozhi.online.ugui.core.activity.Context;
import gaozhi.online.ugui.core.resource.Resources;


/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO 主应用
 * @date 2022/1/25 13:28
 */
public class Application extends Context {
    public Application() {
        this(new Resources("config.application"));
    }

    public Application(Resources resources) {
        super(resources);
    }

}
