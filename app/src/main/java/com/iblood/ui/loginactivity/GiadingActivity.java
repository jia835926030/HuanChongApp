package com.iblood.ui.loginactivity;
import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.iblood.R;
import com.iblood.base.BaseActivity;
import com.iblood.config.Urls;
import com.iblood.entity.UserInfo;
import com.iblood.ui.menu.MainActivity;
import com.iblood.utils.AppUtils;
import com.iblood.utils.CJSON;
import com.iblood.utils.ConnectionUtils;
import com.iblood.utils.FileUtil;
import com.iblood.utils.Md5Encrypt;
import com.iblood.utils.SignUtil;
import com.iblood.utils.ToastUtil;
import com.iblood.utils.TokenUtil;
import com.iblood.utils.UserManager;

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

public class GiadingActivity extends BaseActivity implements View.OnClickListener {
        private TextView reg_fnishi;
    private TextView regin_zhu;
    private EditText login_phone;
    private EditText login_paswd;
       private TextView login_wang;
    private Button login_star;
    private ImageView Login_QQ;
    private ImageView login_wx;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_giading;
    }
    @Override
    protected void initView() {
        reg_fnishi = (TextView) findViewById(R.id.reg_fnishi);
        regin_zhu = (TextView) findViewById(R.id.regin_zhu);
        login_phone = (EditText) findViewById(R.id.login_phone);
        login_paswd = (EditText) findViewById(R.id.login_paswd);
        login_wang = (TextView) findViewById(R.id.login_wang);
        login_star = (Button) findViewById(R.id.login_star);
        Login_QQ = (ImageView) findViewById(R.id.Login_QQ);
        login_wx = (ImageView) findViewById(R.id.login_wx);
    }

    @Override
    protected void initData() {
        reg_fnishi.setOnClickListener(this);
        regin_zhu.setOnClickListener(this);
        login_phone.setOnClickListener(this);
        login_paswd.setOnClickListener(this);
        login_wang.setOnClickListener(this);
        login_star.setOnClickListener(this);
        Login_QQ.setOnClickListener(this);
        login_wx.setOnClickListener(this);
    }

    @Override
    protected void initListener() {
        if(Build.VERSION.SDK_INT>=23){
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CALL_PHONE,Manifest.permission.READ_LOGS,Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.SET_DEBUG_APP,Manifest.permission.SYSTEM_ALERT_WINDOW,Manifest.permission.GET_ACCOUNTS,Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this,mPermissionList,123);
        }
    }
    @Override
       public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

    }

    public void login(String number,String pass) {
        OkHttpClient okHttpClient=new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        TokenUtil.init(GiadingActivity.this);
        String token = TokenUtil.createToken();
        Log.e("to",token);
        Request.Builder request= new Request.Builder();
        MainActivity mainActivity=new MainActivity();
        String ip = ConnectionUtils.getIp(this);
        Map<String,Object> map=new HashMap<>();
        String s = Md5Encrypt.md5(pass, "UTF-8");
        map.put("userPhone",number);
        map.put("password",s);
        AppUtils.setAppContext(GiadingActivity.this);
        String s1 = CJSON.toJSONMap(map);
        Log.e("DA",s1);
        builder.add("data",s1);

        for (String key: map.keySet()){
            Object value = map.get(key);
            builder.add(key, (String) value);
            Log.e("TAG",value+"---------");
        }
        String linkString = SignUtil.createLinkString(map);
        request.addHeader("sign",linkString);
        request.addHeader("ip",ip);
        request.addHeader("token",token);
        request.addHeader("channel","android");

        Request build1 = request.url(Urls.BASE+Urls.LOGINURL).post(builder.build()).build();
        okHttpClient.newCall(build1).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String message = e.getMessage();
                Toast.makeText(GiadingActivity.this, message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String data = response.body().string();
                Log.e( "onResponse: ",data );
                try {
                    JSONObject jsonObject=new JSONObject(data);
                    JSONObject result = jsonObject.getJSONObject("result");
                    final String userName = result.getString("userName");
                    Log.e("da",userName);
                    final String userPhone = result.getString("userPhone");
                    int userSex = result.getInt("userSex");
                    final int userId = result.getInt("userId");
                    int qq = result.getInt("qq");
                    UserInfo userInfo=new UserInfo();
                    userInfo.setUserId(userId+"");
                    UserManager um = UserManager.getInstance();
                    um.saveUserId(userId+"");
                    String userId1 = um.getUserId();
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });

    }
      @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.reg_fnishi:
                finish();
                break;
            case R.id.regin_zhu:
                startActivity(new Intent(GiadingActivity.this, ReginActivity.class));
                Toast.makeText(this, "注册", Toast.LENGTH_SHORT).show();
                break;
            case R.id.login_phone:
                Toast.makeText(this, "账号", Toast.LENGTH_SHORT).show();
                break;
            case R.id.login_paswd:
                Toast.makeText(this, "密码", Toast.LENGTH_SHORT).show();
                break;
            case R.id.login_wang:
                Toast.makeText(this, "忘记", Toast.LENGTH_SHORT).show();
                break;
            case R.id.login_star:
                Toast.makeText(this, "登录", Toast.LENGTH_SHORT).show();
                String phone = login_phone.getText().toString();
                String password = login_paswd.getText().toString();
                login(phone,password);
                break;
            case R.id.Login_QQ:
//         UMShareAPI.get(GiadingActivity.this).getPlatformInfo(GiadingActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
//                             @Override
//                             public void onStart(SHARE_MEDIA share_media) {
//                             }
//                          @Override
//                             public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
////                                 String icoun = map.get("iconurl");
////                                 startActivity(new Intent(Main2Activity.this,Main3Activity.class).putExtra("url",icoun));
//                                 Toast.makeText(GiadingActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
//                             }
//
//                             @Override
//                             public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
//
//                             }
//
//                             @Override
//                             public void onCancel(SHARE_MEDIA share_media, int i) {
//
//                             }
//                         });
                break;
            case R.id.login_wx:
                Toast.makeText(this, "微信", Toast.LENGTH_SHORT).show();
  // startActivity(new Intent(GiadingActivity.this,WxActivity.class));
//                UMShareAPI.get(GiadingActivity.this).getPlatformInfo(GiadingActivity.this, SHARE_MEDIA.WEIXIN, new UMAuthListener() {
//                    @Override
//                    public void onStart(SHARE_MEDIA share_media) {
//                    }
//                    @Override
//                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
////                                 String icoun = map.get("iconurl");
////                                 startActivity(new Intent(Main2Activity.this,Main3Activity.class).putExtra("url",icoun));
//                        Toast.makeText(GiadingActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
//
//                    }
//
//                    @Override
//                    public void onCancel(SHARE_MEDIA share_media, int i) {
//
//                    }
//                });
                break;

        }
    }
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (event.getAction() == KeyEvent.ACTION_DOWN
                    && event.getRepeatCount() == 0) {
                setResult(1);
                finish();
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}