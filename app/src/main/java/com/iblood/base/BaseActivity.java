package com.iblood.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.iblood.app.App;
import com.iblood.config.Urls;
import com.iblood.ui.PersonalInformation;
import com.iblood.ui.PetAddActivity;
import com.iblood.utils.AppUtils;
import com.iblood.utils.CJSON;
import com.iblood.utils.CharacterParser;
import com.iblood.utils.ConnectionUtils;
import com.iblood.utils.FileUtil;
import com.iblood.utils.SharedPreferencesUtils;
import com.iblood.utils.SignUtil;
import com.iblood.utils.TableUtils;
import com.iblood.utils.TokenUtil;
import com.zhy.autolayout.AutoLayoutActivity;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.qqtheme.framework.picker.DatePicker;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public abstract class BaseActivity extends AutoLayoutActivity {
    private Unbinder unbinder;
    // 获取网络管理信息
    private static ConnectivityManager manager;
    // 获取网络信息
    private static NetworkInfo network = null;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置竖屏
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        setContentView(getLayoutId());
        App.mBaseActivity = this;
        AppUtils.setAppContext(this);
        TokenUtil.init(this);
        String token = TokenUtil.createToken();

        FileUtil.saveToken();
        unbinder = ButterKnife.bind(this);

        //注意以下方法仅在Activity创建的时候调用一次
        //activity添加到Activity的管理里面
        // ActivityCollector.getInstance().addActivity(this);
        initView();
        initData();
        initListener();
    }



    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();

    @Override
    protected void onResume() {
        super.onResume();
        //这里添加需要重复执行的内容
        App.mBaseActivity = this;
    }

    public void textToast(String str){
        Toast.makeText(App.mBaseActivity,str,Toast.LENGTH_SHORT).show();
    }
    public static boolean isWiFi(Context context) {
        manager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        network = manager.getActiveNetworkInfo();
        if (network != null && network.isAvailable()) {
            // 是网
            if (network.getType() == ConnectivityManager.TYPE_WIFI) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    public void loadImg(Context context, String url, ImageView imageView){
        boolean wiFi = isWiFi(context);
        if(wiFi==true){
            Glide.with(context).load(url).into(imageView);

        }else {
            Toast.makeText(context, "当前未连WIFI", Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
    private void postDataSimple(String data) {
        OkHttpClient okHttpClient=new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        AppUtils.setAppContext(BaseActivity.this);
        TokenUtil.init(BaseActivity.this);
        String token = TokenUtil.createToken();
        Log.e("token",token);
        Request.Builder request = new Request.Builder();
        String ip = ConnectionUtils.getIp(BaseActivity.this);
        Map<String, Object> map = new HashMap<>();
        String ws = (String) SharedPreferencesUtils.getParam(BaseActivity.this, "userId", "");
        map.put(TableUtils.UserInfo.USERID, ws);
        map.put(TableUtils.UserInfo.BIRTHDAY, data);
        String s1 = CJSON.toJSONMap(map);
        builder.add("data", s1);
        String linkString = SignUtil.createLinkString(map);
        request.addHeader("sign", linkString);
        request.addHeader("ip", ip);
        request.addHeader("token", token);
        request.addHeader("channel", "android");
        Request build1 = request.url(Urls.BASE+Urls.PERSONDATAUP1).post(builder.build()).build();
        okHttpClient.newCall(build1).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("data",string);
            }
        });
    }
//选择日期
    public void Date_selection(final TextView view,int data) {

        DatePicker picker = new DatePicker(App.mBaseActivity);
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        String date = df.format(new Date());
        picker.setRange(data, Integer.parseInt(date));//年份范围
        picker.setSubmitTextColor(Color.BLUE);
        picker.setCancelTextColor(Color.BLUE);
        picker.setTextColor(Color.BLACK);
        picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
            @Override
            public void onDatePicked(String year, String month, String day) {
                if (!year.isEmpty() || !month.isEmpty() || !day.isEmpty()) {
                    textToast("修改成功");
                    view.setText(year + "年" + month + "月" + day + "日");
                    view.setTextSize(20);
                    CharacterParser instance = CharacterParser.getInstance();
                    int chsAscii = instance.getChsAscii(view.getText().toString());
                    postDataSimple(chsAscii+"");
                    //TODO sfsasfas
                } else {
                    textToast("网络不佳,请稍后重试");
                }

            }
        });
        picker.show();
    }

}
