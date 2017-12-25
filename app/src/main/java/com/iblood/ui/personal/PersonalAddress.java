package com.iblood.ui.personal;

import android.content.Intent;
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
import com.iblood.ui.PersonalInformation;
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
 *
 * 修改联系地址
 */

public class PersonalAddress extends BaseActivity {
    @BindView(R.id.text_title)
    TextView header_title;//头标题
    @BindView(R.id.button_backward)
    ImageView button_backward;
    @BindView(R.id.button_forward)
    TextView button_forward;
    @BindView(R.id.myaddress)
    EditText myAddress;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_address;
    }


    @Override
    protected void onResume() {
        super.onResume();

        header_title.setText(getIntent().getStringExtra("title"));
    }

    @Override
    protected void initView() {


    }

    private void postAddress(int address) {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        AppUtils.setAppContext(PersonalAddress.this);
        TokenUtil.init(PersonalAddress.this);
        String token = TokenUtil.createToken();
        Log.e("token", token);
        Request.Builder request = new Request.Builder();
        String ip = ConnectionUtils.getIp(PersonalAddress.this);
        Map<String, Object> map = new HashMap<>();
        String ws = (String) SharedPreferencesUtils.getParam(PersonalAddress.this, "userId", "");
        map.put(TableUtils.UserInfo.USERID, ws);
        map.put(TableUtils.UserInfo.ADDRESS, address);
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
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
    @OnClick({R.id.button_backward,R.id.button_forward})
    public void onClicked(View view){
        switch (view.getId()){
            case R.id.button_backward:
                finish();
                break;
            case R.id.button_forward:
                String trim = myAddress.getText().toString().trim();
                Log.e("TAG", trim);
                CharacterParser instance = CharacterParser.getInstance();
                int chsAscii = instance.getChsAscii(trim);

                postAddress(chsAscii);
                Intent intent = new Intent();
                Intent rcode = intent.putExtra("rcode", trim);
                Log.e("TAG", rcode.getStringExtra("rcode"));
                setResult(200, rcode);
                finish();
                Toast.makeText(this, "dasdsada", Toast.LENGTH_SHORT).show();
                break;

        }

    }
}
