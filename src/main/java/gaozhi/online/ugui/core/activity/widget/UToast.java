package gaozhi.online.ugui.core.activity.widget;

import gaozhi.online.ugui.core.activity.Activity;
import gaozhi.online.ugui.core.activity.Context;
import gaozhi.online.ugui.core.activity.Intent;
import gaozhi.online.ugui.core.asynchronization.TaskExecutor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Timer;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO toast
 * @date 2022/4/2 18:36
 */
public class UToast extends Activity implements Runnable {
    private static final String INTENT_PERIOD = "period";
    private static final String INTENT_MESSAGE = "message";
    private static final String INTENT_PARENT_BOUNDS = "bounds";

    private ULabel label_message;

    private Timer timer;
    private long checkPeriod;
    private long timerCount;
    private long lifePeriod;
    private String message;
    private Rectangle bounds;

    public UToast(Context context, Intent intent, String title, long id) {
        super(context, intent, title, id);
    }

    @Override
    public void initParam(Intent intent) {
        checkPeriod = 100;
        lifePeriod = intent.getLong(INTENT_PERIOD, 1000);
        message = intent.getString(INTENT_MESSAGE);
        bounds = intent.getObject(INTENT_PARENT_BOUNDS);
    }

    @Override
    public void initUI() {
        removeTitleView();
        setRootGridLayout(1, 1);
        setBounds(bounds);
        label_message = new ULabel();
        UPanel panel = getChildPanel(1, 1);
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.CENTER);
        panel.setLayout(flowLayout);
        panel.add(label_message);
        label_message.setText(message);
    }

    @Override
    public void doBusiness() {
        timer = new TaskExecutor().executeTimerTask(this, checkPeriod);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void releaseResource() {
        super.releaseResource();
        if(timer!=null) {
            timer.cancel();
        }
    }

    public static void show(Activity parent, String message) {
        show(parent.getContext(), message, 1000, parent.getBounds());
    }

    public static void show(Context context, String message) {
        show(context, message, 1000);
    }

    public static void show(Context context, String message, long life) {
        Dimension dimension = Activity.screenSize();
        show(context, message, life, new Rectangle(0, 0, dimension.width, dimension.height));
    }

    public static void show(Context context, String message, long life, Rectangle bounds) {
        List<Activity> activities = context.getActivityList().getActivityList(UToast.class);
        for (Activity toast : activities) {
            toast.dispose();
        }
        Intent intent = new Intent();
        intent.put(INTENT_MESSAGE, message);
        intent.put(INTENT_PERIOD, life);
        intent.put(INTENT_PARENT_BOUNDS, bounds);
        context.startActivity(UToast.class, intent);
    }

    @Override
    public void run() {
      //  logger.info("检查toast生命周期");
        if (lifePeriod < checkPeriod * timerCount++) {
            new TaskExecutor().executeInUIThread(this::dispose);
        }
    }
}
