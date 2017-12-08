package com.iblood.app;

import android.content.SharedPreferences;

import com.iblood.base.BaseActivity;
import com.iblood.base.BaseFragment;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.zhy.autolayout.config.AutoLayoutConifg;


public class App extends BaseApplication implements Thread.UncaughtExceptionHandler {

    public static BaseActivity mBaseActivity;
    public static BaseFragment mBaseFragment;
    /**
     * 小型数据库读取
     */
    public static SharedPreferences preferences;
    /**
     * 小型数据库写入
     */
    public static SharedPreferences.Editor editor;
    {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }
    @Override
    public void onCreate() {
        super.onCreate();
        preferences = getSharedPreferences("dome", MODE_PRIVATE);
        editor = preferences.edit();
        //设备的物理高度进行百分比化：
        AutoLayoutConifg.getInstance().useDeviceSize();
        com.umeng.socialize.Config.DEBUG=true;
        UMShareAPI.get(this);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.setDefaultUncaughtExceptionHandler(this);

    }
}
