package com.iblood.ui.activity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.iblood.R;
import com.iblood.base.BaseActivity;

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
      regin_phone =  (EditText)  findViewById(R.id.regin_photo);
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

    @Override
         protected void initData() {

    }
    @Override
    protected void initListener() {

    }
}