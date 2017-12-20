package com.iblood.fellow;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.iblood.R;
import com.iblood.base.BaseActivity;
import com.iblood.config.Urls;
import com.iblood.ui.HomeActivity;
import com.iblood.utils.AppUtils;
import com.iblood.utils.CJSON;
import com.iblood.utils.ConnectionUtils;
import com.iblood.utils.SignUtil;
import com.iblood.utils.ToastUtil;
import com.iblood.utils.TokenUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PingLunActivity extends BaseActivity {


    @BindView(R.id.listview_fellow)
    ListView listviewFellow;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ping_lun;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("usersId ");

        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        AppUtils.setAppContext(this);
        ToastUtil.init(this);
        String token = TokenUtil.createToken();
        Request.Builder request = new Request.Builder();
        String ip = ConnectionUtils.getIp(this);
        Map<String, Object> map = new HashMap<>();
        map.put("usersId ", stringExtra);
        String s1 = CJSON.toJSONMap(map);
        builder.add("data", s1);

        String linkString = SignUtil.createLinkString(map);
        request.addHeader("sign", linkString);
        request.addHeader("ip", ip);
        request.addHeader("token", token);
        request.addHeader("channel", "android");
        Request build1 = request.url(Urls.BASE + Urls.PINGLUN).post(builder.build()).build();
        okHttpClient.newCall(build1).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String string = response.body().string();
                Log.e("TAG", "sssssss"+string);
                Toast.makeText(PingLunActivity.this, string, Toast.LENGTH_SHORT).show();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        PingLunBean pingLunBean = gson.fromJson(string, PingLunBean.class);
                        List<PingLunBean.DescBean> list = pingLunBean.getDesc();
                        PingLunAdapter adapter = new PingLunAdapter(PingLunActivity.this,list);
                        listviewFellow.setAdapter(adapter);
                    }
                });
            }
        });

//        List<PingLunBean> list = new ArrayList<>();
//        for (int i = 0; i < 4; i++) {
//            list.add(new PingLunBean(R.mipmap.ic_launcher,"YHQWYX"+i,"非常认真","大型犬 1天","2012-12-12"));
//        }
//        PingLunAdapter adapter = new PingLunAdapter(this,list);
//        listviewFellow.setAdapter(adapter);


    }

    @Override
    protected void initListener() {

    }

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
