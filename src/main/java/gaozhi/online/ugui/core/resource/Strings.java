package gaozhi.online.ugui.core.resource;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO 字符串常量
 * @date 2022/1/25 21:25
 */
public final class Strings {
    private final Resources resources;

    public Strings(Resources resources) {
        this.resources = resources;
    }

    public String getString(String key) {
        return resources.getString(key);
    }
}
