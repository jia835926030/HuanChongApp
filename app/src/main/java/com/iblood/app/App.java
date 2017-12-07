package com.iblood.app;

import com.iblood.base.BaseActivity;
import com.iblood.base.BaseFragment;
import com.zhy.autolayout.config.AutoLayoutConifg;


public class App extends BaseApplication implements Thread.UncaughtExceptionHandler {

    public static BaseActivity mBaseActivity;
    public static BaseFragment mBaseFragment;


    @Override
    public void onCreate() {
        super.onCreate();
        //设备的物理高度进行百分比化：
        AutoLayoutConifg.getInstance().useDeviceSize();

    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.setDefaultUncaughtExceptionHandler(this);

    }
}
