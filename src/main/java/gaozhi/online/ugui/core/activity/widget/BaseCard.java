package gaozhi.online.ugui.core.activity.widget;

import gaozhi.online.ugui.core.activity.Context;

import java.awt.*;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO  卡片
 * @date 2022/4/13 9:38
 */
public abstract class BaseCard<T> extends UPanel {
    private final String key;
    private final Context context;
    private final GridLayout gridLayout;

    public BaseCard(String key, Context context, T data) {
        this.key = key;
        this.context = context;
        gridLayout = new GridLayout();
        setLayout(gridLayout);
        initParam(data);
        initUI();
        doBusiness();
    }

    public void setRootGridLayout(final int rows, final int cols) {
        gridLayout.setRows(rows);
        gridLayout.setColumns(cols);
        removeAll();
        int size = rows * cols;
        while (size-- > 0) {
            add(new UPanel());
        }
    }

    public void setVGap(int gap) {
        gridLayout.setVgap(gap);
    }

    public void setHGap(int gap) {
        gridLayout.setHgap(gap);
    }

    public UPanel getChildPanel(int row, int column) {
        return (UPanel) getComponent((row - 1) * gridLayout.getColumns() + column - 1);
    }

    public abstract void initParam(T data);

    public abstract void initUI();

    public abstract void doBusiness();

    public String getKey() {
        return key;
    }

    public Context getContext() {
        return context;
    }

    public abstract void releaseResource();
}
