package com.iblood.ui.loginactivity;

import android.content.Intent;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.iblood.R;
import com.iblood.base.BaseActivity;
import com.iblood.config.Urls;
import com.iblood.ui.menu.MainActivity;
import com.iblood.utils.AppUtils;
import com.iblood.utils.CJSON;
import com.iblood.utils.ConnectionUtils;
import com.iblood.utils.Md5Encrypt;
import com.iblood.utils.SignUtil;
import com.iblood.utils.TokenUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ReginActivity extends BaseActivity {
    private TextView reg_fnishi;
       private TextView regin_login;
    private EditText regin_phone;
    private EditText regin_yan;
    private TextView regin_huoqu;
    private EditText regin_photo;
    private EditText regin_password;
    private Button regin_star;
    private ImageView regin_qq;
    private ImageView regin_wx;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_regin;
    }
    @Override

    protected void initView() {
     reg_fnishi =   (TextView) findViewById(R.id.regin_fnishi);
     regin_login =   (TextView) findViewById(R.id.regin_login);
      //手机号
      regin_phone =  (EditText)  findViewById(R.id.regin_phone);
        //验证码
        regin_yan =  (EditText) findViewById(R.id.regin_yan);
       //获取验证码
        regin_huoqu = (TextView) findViewById(R.id.regin_huo);
       //用户名
      regin_photo =  (EditText)   findViewById(R.id.regin_photo);
      regin_password =  (EditText) findViewById(R.id.regin_paswd);
     //注册按钮
       regin_star = (Button)  findViewById(R.id.regin_star);
      regin_qq =  (ImageView) findViewById(R.id.regin_qq);
      regin_wx =  (ImageView) findViewById(R.id.regin_wx);
    }
    public void gethttpdata(String phone,String password,String name) {
        OkHttpClient okHttpClient=new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        TokenUtil.init(ReginActivity.this);
        String token = TokenUtil.createToken();
        Log.e("to",token);
        Request.Builder request= new Request.Builder();
        String ip = ConnectionUtils.getIp(this);
        Map<String,Object> map=new HashMap<>();
        String s = Md5Encrypt.md5(password, "UTF-8");
        map.put("userPhone",phone);
        map.put("userName",name);
        map.put("password",s);
        AppUtils.setAppContext(ReginActivity.this);
        String s1 = CJSON.toJSONMap(map);
        Log.e("DA",s1);
        builder.add("data",s1);

        String linkString = SignUtil.createLinkString(map);
        request.addHeader("sign",linkString);
        request.addHeader("ip",ip);
        request.addHeader("token",token);
        request.addHeader("channel","android");

        Request build1 = request.url(Urls.BASE+Urls.REGIS).post(builder.build()).build();
        okHttpClient.newCall(build1).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String message = e.getMessage();
                Toast.makeText(ReginActivity.this, message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String data = response.body().string();
                Log.e( "onResponse: ",data );
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ReginActivity.this, data, Toast.LENGTH_SHORT).show();
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
        regin_star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = regin_phone.getText().toString();
                String password = regin_password.getText().toString();
                String name = regin_photo.getText().toString();

                gethttpdata(phone,password,name);
            }
        });
        regin_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
            }
        });
    }
}