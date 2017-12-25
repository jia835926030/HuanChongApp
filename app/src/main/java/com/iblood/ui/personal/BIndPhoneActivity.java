package com.iblood.ui.personal;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

public class BIndPhoneActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView text_title;
    private Button button_backward;
    private Button button_forward;
    private AutoRelativeLayout layout_titlebar;
    private EditText mEditText_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_phone);
        initView();

    }

    @SuppressLint("WrongViewCast")
    private void initView() {
        text_title = (TextView) findViewById(R.id.text_title);
        button_backward = (Button) findViewById(R.id.button_backward);
        button_forward = (Button) findViewById(R.id.button_forward);
        layout_titlebar = (AutoRelativeLayout) findViewById(R.id.layout_titlebar);
        mEditText_phone = (EditText) findViewById(R.id.mEditText_phone);
        button_backward.setOnClickListener(this);
        button_forward.setOnClickListener(this);
    }

    private void postData(String name) {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        AppUtils.setAppContext(BIndPhoneActivity.this);
        TokenUtil.init(BIndPhoneActivity.this);
        String token = TokenUtil.createToken();
        Log.e("token", token);
        Request.Builder request = new Request.Builder();
        String ip = ConnectionUtils.getIp(BIndPhoneActivity.this);
        Map<String, Object> map = new HashMap<>();
        String ws = (String) SharedPreferencesUtils.getParam(BIndPhoneActivity.this, "userId", "");
        map.put(TableUtils.UserInfo.USERID, ws);
        map.put(TableUtils.UserInfo.USERPHONE, name);
        String s1 = CJSON.toJSONMap(map);
        Log.e("DA", s1);
        builder.add("data", s1);
        String linkString = SignUtil.createLinkString(map);
        request.addHeader("sign", linkString);
        request.addHeader("ip", ip);
        request.addHeader("token", token);
        request.addHeader("channel", "android");
        Request build1 = request.url(Urls.BASE + Urls.PERSONDATAUP1).post(builder.build()).build();
        okHttpClient.newCall(build1).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("data", string);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_backward:
                finish();
                break;
            case R.id.button_forward:
                postData(mEditText_phone.getText().toString().trim());
                Toast.makeText(this, "提交", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
