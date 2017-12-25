package com.iblood.ui.postpersondata;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.iblood.R;
import com.iblood.base.BaseActivity;
import com.iblood.config.Urls;
import com.iblood.utils.AppUtils;
import com.iblood.utils.CJSON;
import com.iblood.utils.ConnectionUtils;
import com.iblood.utils.SharedPreferencesUtils;
import com.iblood.utils.SignUtil;
import com.iblood.utils.TableUtils;
import com.iblood.utils.TokenUtil;
import com.zhy.autolayout.AutoRelativeLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BindQQActivity extends BaseActivity implements View.OnClickListener {

    private TextView text_title;
    private ImageView button_backward;
    private TextView button_forward;
    private AutoRelativeLayout layout_titlebar;
    private EditText bindqq;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bind_qq;
    }

    @Override
    protected void initView() {

        text_title = (TextView) findViewById(R.id.text_title);
        text_title.setOnClickListener(this);
        button_backward = (ImageView) findViewById(R.id.button_backward);
        button_backward.setOnClickListener(this);
        button_forward = (TextView) findViewById(R.id.button_forward);
        button_forward.setOnClickListener(this);
        layout_titlebar = (AutoRelativeLayout) findViewById(R.id.layout_titlebar);
        layout_titlebar.setOnClickListener(this);
        bindqq = (EditText) findViewById(R.id.bindqq);
        bindqq.setOnClickListener(this);
    }
    private void postData(String o) {
        OkHttpClient okHttpClient=new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        AppUtils.setAppContext(BindQQActivity.this);
        TokenUtil.init(BindQQActivity.this);
        String token = TokenUtil.createToken();
        Log.e("token",token);
        Request.Builder request = new Request.Builder();
        String ip = ConnectionUtils.getIp(BindQQActivity.this);
        Map<String, Object> map = new HashMap<>();
        String ws = (String) SharedPreferencesUtils.getParam(BindQQActivity.this, "userId", "");
        map.put(TableUtils.UserInfo.USERID, ws);
        map.put(TableUtils.UserInfo.QQ, o);
        String s1 = CJSON.toJSONMap(map);
        Log.e("DA", s1);
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
                final String string = response.body().string();
                Log.e("data",string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject=new JSONObject(string);
                            String ret = jsonObject.getString("ret");
                            if(ret.equals("true")){
                                Toast.makeText(BindQQActivity.this, "成功", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(BindQQActivity.this, "失败", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_backward:
                finish();
                break;
            case R.id.button_forward:
                String trim = bindqq.getText().toString().trim();
                if (!TextUtils.isEmpty(trim)){

                Intent intent = new Intent();
                intent.putExtra("rcode",trim);
                setResult(200,intent);
                finish();
                }else {
                    textToast("请输入QQ号");
                }
                break;
        }
    }

}
