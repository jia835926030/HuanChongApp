package com.iblood.app;

import android.content.Context;
import android.content.SharedPreferences;

import com.iblood.base.BaseActivity;
import com.iblood.base.BaseFragment;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.zhy.autolayout.config.AutoLayoutConifg;


public class App extends BaseApplication implements Thread.UncaughtExceptionHandler {

    public static BaseActivity mBaseActivity;
    public static BaseFragment mBaseFragment;
    private static App instance;
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


        initImageLoader(getApplicationContext());
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.setDefaultUncaughtExceptionHandler(this);

    }
    public static void initImageLoader(Context context) {
        // This configuration tuning is custom. You can tune every option, you may tune some of them,
        // or you can create default configuration by
        //  ImageLoaderConfiguration.createDefault(this);
        // method.
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.writeDebugLogs(); // Remove for release app

        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config.build());
    }
    public static App getInstance() {
        return instance;
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
