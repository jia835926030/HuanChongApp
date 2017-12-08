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
    private EditText regin_photo;
    private EditText login_pswd;
    private EditText regin_pswd;
    private Button regin_star;
    private ImageView Regin_QQ;
    private ImageView Regin_wx;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_regin;
    }
    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
    }
    @Override
    protected void initListener() {

    }
}