package com.iblood.app;

import android.content.SharedPreferences;

import com.iblood.base.BaseActivity;
import com.iblood.base.BaseFragment;
import com.zhy.autolayout.config.AutoLayoutConifg;


public class App extends BaseApplication implements Thread.UncaughtExceptionHandler {

    public static BaseActivity mBaseActivity;
    public static BaseFragment mBaseFragment;
    /**
     小型数据库读取
     */
    public static SharedPreferences preferences;
    /**
     * 小型数据库写入
     */
    public static SharedPreferences.Editor editor;
    @Override
    public void onCreate() {
        super.onCreate();
        //轮播图小型库
        preferences = getSharedPreferences("dome", MODE_PRIVATE);
        editor = preferences.edit();

        //设备的物理高度进行百分比化：
        AutoLayoutConifg.getInstance().useDeviceSize();

        //设备的物理高度进行百分比化：
        AutoLayoutConifg.getInstance().useDeviceSize();

    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.setDefaultUncaughtExceptionHandler(this);

    }
}
