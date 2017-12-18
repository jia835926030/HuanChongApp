package com.iblood.ui;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 刘贵河 on 2017/12/7.
 */

public class ModificationActivity extends BaseActivity {
    @BindView(R.id.text_title)
    TextView text_title;
    @BindView(R.id.mEditText)
    EditText mEditText;
    @BindView(R.id.button_forward)
    Button button_forward;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_modification;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        //获取传过来的值
        String titletext = intent.getStringExtra("title");
        String hint = intent.getStringExtra("hint");
        text_title.setText(titletext);
        mEditText.setHint(hint);
    }
    private void postData(String name) {
        OkHttpClient okHttpClient=new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        AppUtils.setAppContext(ModificationActivity.this);
        TokenUtil.init(ModificationActivity.this);
        String token = TokenUtil.createToken();
        Log.e("token",token);
        Request.Builder request = new Request.Builder();
        String ip = ConnectionUtils.getIp(ModificationActivity.this);
        Map<String, Object> map = new HashMap<>();
        String ws = (String) SharedPreferencesUtils.getParam(ModificationActivity.this, "userId", "");
        map.put(TableUtils.UserInfo.USERID, ws);
        map.put(TableUtils.UserInfo.USERNAME,name);
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
    @Override
    protected void initView() {

        button_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String trim = mEditText.getText().toString().trim();
                Log.e("TAG", trim);
                postData(trim);
                Intent intent = new Intent();
                Intent rcode = intent.putExtra("rcode", trim);
                Log.e("TAG", rcode.getStringExtra("rcode"));
                setResult(200, rcode);
                finish();
            }
        });

    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
