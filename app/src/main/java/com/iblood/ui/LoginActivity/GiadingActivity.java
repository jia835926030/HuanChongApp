package com.iblood.ui.LoginActivity;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.iblood.R;
import com.iblood.base.BaseActivity;

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
                Toast.makeText(this, "QQ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.login_wx:
                Toast.makeText(this, "微信", Toast.LENGTH_SHORT).show();
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
}