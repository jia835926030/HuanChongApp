package com.iblood.app;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.iblood.base.BaseActivity;
import com.iblood.base.BaseFragment;
import com.iblood.ui.setmodoule.SetUpActivity;
import com.iblood.utils.SharedPreferencesUtils;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.zhy.autolayout.config.AutoLayoutConifg;

import java.util.Iterator;
import java.util.List;


public class App extends BaseApplication implements Thread.UncaughtExceptionHandler {

    public static BaseActivity mBaseActivity;
    public static BaseFragment mBaseFragment;
    private static App instance;
    private Context appContext;

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
        SharedPreferencesUtils.setParam(this,"flag3","ischeckd");
        //设备的物理高度进行百分比化：
        AutoLayoutConifg.getInstance().useDeviceSize();

        //设备的物理高度进行百分比化：
        AutoLayoutConifg.getInstance().useDeviceSize();

        initImageLoader(getApplicationContext());

        EMOptions options = new EMOptions();
        options.setAcceptInvitationAlways(false);

        //环信
        appContext = this;
        int pid = android.os.Process.myPid();
        String processAppName = getAppName(pid);
        // 如果APP启用了远程的service，此application:onCreate会被调用2次
        // 为了防止环信SDK被初始化2次，加此判断会保证SDK被初始化1次
        // 默认的APP会在以包名为默认的process name下运行，如果查到的process name不是APP的process name就立即返回

        if (processAppName == null || !processAppName.equalsIgnoreCase(appContext.getPackageName())) {
            Log.e("--->", "enter the service process!");

            // 则此application::onCreate 是被service 调用的，直接返回
            return;
        }

        //初始化
        EMClient.getInstance().init(getApplicationContext(), options);
        //在做打包混淆时，关闭debug模式，避免消耗不必要的资源
        EMClient.getInstance().setDebugMode(true);

    }

    private String getAppName(int pID) {
        String processName = null;
        ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();
        PackageManager pm = this.getPackageManager();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
            try {
                if (info.pid == pID) {
                    processName = info.processName;
                    return processName;
                }
            } catch (Exception e) {
                // Log.d("Process", "Error>> :"+ e.toString());
            }
        }
        return processName;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.setDefaultUncaughtExceptionHandler(this);

    }
    public static void initImageLoader(Context context) {

        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.writeDebugLogs();
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
