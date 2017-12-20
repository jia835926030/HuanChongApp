package com.iblood.ui.postpersondata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.iblood.R;
import com.iblood.config.Urls;
import com.iblood.utils.AppUtils;
import com.iblood.utils.CJSON;
import com.iblood.utils.ConnectionUtils;
import com.iblood.utils.SharedPreferencesUtils;
import com.iblood.utils.SignUtil;
import com.iblood.utils.TableUtils;
import com.iblood.utils.TokenUtil;
import com.zhy.autolayout.AutoRelativeLayout;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BindWeChatActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView text_title;
    private Button button_backward;
    private Button button_forward;
    private AutoRelativeLayout layout_titlebar;
    private EditText bindwechat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_we_chat);
        initView();

    }
    private void postData(String o) {
        OkHttpClient okHttpClient=new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        AppUtils.setAppContext(BindWeChatActivity.this);
        TokenUtil.init(BindWeChatActivity.this);
        String token = TokenUtil.createToken();
        Log.e("token",token);
        Request.Builder request = new Request.Builder();
        String ip = ConnectionUtils.getIp(BindWeChatActivity.this);
        Map<String, Object> map = new HashMap<>();
        String ws = (String) SharedPreferencesUtils.getParam(BindWeChatActivity.this, "userId", "");
        map.put(TableUtils.UserInfo.USERID, ws);
        map.put(TableUtils.UserInfo.WECHAT, o);
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
                String string = response.body().string();
                Log.e("data",string);
            }
        });
    }
    private void initView() {
        text_title = (TextView) findViewById(R.id.text_title);
        button_backward = (Button) findViewById(R.id.button_backward);
        button_forward = (Button) findViewById(R.id.button_forward);
        layout_titlebar = (AutoRelativeLayout) findViewById(R.id.layout_titlebar);
        bindwechat = (EditText) findViewById(R.id.bindwechat);

        button_backward.setOnClickListener(this);
        button_forward.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_backward:

                break;
            case R.id.button_forward:
                postData(bindwechat.getText().toString());
                finish();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        text_title.setText("微信");
        bindwechat.setHint("请输入微信账号");
    }
}
