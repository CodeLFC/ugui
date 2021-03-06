package gaozhi.online.ugui.core.activity;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO 窗口管理器,栈的方式管理窗口的生命周期
 * @date 2022/1/25 15:10
 */
public class ActivityList implements WindowListener {
    //活跃活动的栈
    private final Map<Long, Activity> activityMap = new HashMap<>();
    private final Logger logger = Logger.getLogger(ActivityList.class.getName());

    @Override
    public void windowOpened(WindowEvent e) {
        //窗口首次打开时调用
        Activity activity = (Activity) e.getWindow();
        if (!activityMap.containsKey(activity.getId())) {
            activityMap.put(activity.getId(), activity);
            logger.info("windowOpened:" + activity.getId() + " : " + activity.getClass().getName());
        } else {
            throw new IllegalArgumentException("activity id is occupied! id=" + activity.getId() + " : " + activity.getClass().getName());
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        //从系统菜单中关闭窗体时调用
        Activity activity = (Activity) e.getWindow();
        //logger.info("windowClosing:" + activity.getClass().getName());
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //对窗口调用 dispose 而将其关闭时调用。
        Activity activity = (Activity) e.getWindow();
        activity.releaseResource();
        activityMap.remove(activity.getId());
        logger.info("windowClosed:" + activity.getId() + " : " + activity.getClass().getName());

        if (activityMap.size() == 0) {
            System.exit(0);
        }
    }

    @Override
    public void windowIconified(WindowEvent e) {
        //窗体变为最小化时调用
        Activity activity = (Activity) e.getWindow();
        //logger.info("windowIconified:" + activity.getClass().getName());
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //窗体变为正常状态事调用
        Activity activity = (Activity) e.getWindow();
        // logger.info("windowDeiconified:" + activity.getClass().getName());
    }

    @Override
    public void windowActivated(WindowEvent e) {
        //窗体被激活时调用
        Activity activity = (Activity) e.getWindow();

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // 当 Window 不再是活动 Window 时调用。
        Activity activity = (Activity) e.getWindow();
        //logger.info("windowDeactivated:" + activity.getClass().getName());
    }

    public int size() {
        return activityMap.size();
    }

    public <T extends Activity> List<Activity> getActivityList(Class<T> klass) {
        List<Activity> res = new LinkedList<>();
        for (Activity activity : activityMap.values()) {
            if (klass == activity.getClass()) {
                res.add(activity);
            }
        }
        return res;
    }

    public Activity getActivity(long id) {
        return activityMap.get(id);
    }

    public List<Activity> getActivityList() {
        return new LinkedList<>(activityMap.values());
    }
}
