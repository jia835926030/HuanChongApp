package com.iblood.ui.activity;
import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.iblood.R;
import com.iblood.base.BaseActivity;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

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
                break;
            case R.id.Login_QQ:
         UMShareAPI.get(GiadingActivity.this).getPlatformInfo(GiadingActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
                             @Override
                             public void onStart(SHARE_MEDIA share_media) {
                             }
                          @Override
                             public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
//                                 String icoun = map.get("iconurl");
//                                 startActivity(new Intent(Main2Activity.this,Main3Activity.class).putExtra("url",icoun));
                                 Toast.makeText(GiadingActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                             }

                             @Override
                             public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                             }

                             @Override
                             public void onCancel(SHARE_MEDIA share_media, int i) {

                             }
                         });
                break;
            case R.id.login_wx:
                Toast.makeText(this, "微信", Toast.LENGTH_SHORT).show();
  // startActivity(new Intent(GiadingActivity.this,WxActivity.class));
                UMShareAPI.get(GiadingActivity.this).getPlatformInfo(GiadingActivity.this, SHARE_MEDIA.WEIXIN, new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {
                    }
                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
//                                 String icoun = map.get("iconurl");
//                                 startActivity(new Intent(Main2Activity.this,Main3Activity.class).putExtra("url",icoun));
                        Toast.makeText(GiadingActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {

                    }
                });
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
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}