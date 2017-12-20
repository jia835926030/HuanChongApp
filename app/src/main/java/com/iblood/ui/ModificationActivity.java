package com.iblood.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.iblood.R;
import com.iblood.base.BaseActivity;
import com.iblood.config.Urls;
import com.iblood.utils.AppUtils;
import com.iblood.utils.CJSON;
import com.iblood.utils.CharacterParser;
import com.iblood.utils.ConnectionUtils;
import com.iblood.utils.SharedPreferencesUtils;
import com.iblood.utils.SignUtil;
import com.iblood.utils.TableUtils;
import com.iblood.utils.TokenUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
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
    TextView button_forward;
    @BindView(R.id.button_backward)
    ImageView button_backward;
    private String hint;

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
        hint = intent.getStringExtra("hint");
        text_title.setText(titletext);
        mEditText.setHint(hint);
    }
    private void postData(int name) {
        OkHttpClient okHttpClient=new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        AppUtils.setAppContext(ModificationActivity.this);
        TokenUtil.init(ModificationActivity.this);
        String token = TokenUtil.createToken();
        Log.e("token", token);
        Request.Builder request = new Request.Builder();
        String ip = ConnectionUtils.getIp(ModificationActivity.this);
        Map<String, Object> map = new HashMap<>();
        String ws = (String) SharedPreferencesUtils.getParam(ModificationActivity.this, "userId", "");
        map.put(TableUtils.UserInfo.USERID, ws);
        map.put(TableUtils.UserInfo.USERNAME, name);
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
                //Log.e("data",string);

            }
        });
    }

    @Override
    protected void initView() {



    }



    @OnClick({R.id.button_backward,R.id.button_forward})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_backward:
                finish();
                break;
            case R.id.button_forward:
                String trim = mEditText.getText().toString().trim();
                if (!TextUtils.isEmpty(trim)) {
                    CharacterParser instance = CharacterParser.getInstance();
                    int chsAscii = instance.getChsAscii(trim);
                    postData(chsAscii);
                    Intent intent = new Intent();
                    intent.putExtra("rcode", trim);
                    setResult(200, intent);
                    finish();
                }else {
                    textToast(hint);
                }
                break;
        }
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
    @OnClick({R.id.button_backward})
    public void onClicked(View view){
        switch (view.getId()){
            case R.id.button_backward:
                finish();

        }

    }
}
