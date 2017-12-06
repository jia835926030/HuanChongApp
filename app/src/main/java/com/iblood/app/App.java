package com.iblood.app;

import com.iblood.base.BaseActivity;
import com.iblood.base.BaseFragment;


public class App extends BaseApplication implements Thread.UncaughtExceptionHandler {

    public static BaseActivity mBaseActivity;
    public static BaseFragment mBaseFragment;


    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.setDefaultUncaughtExceptionHandler(this);

    }
}
