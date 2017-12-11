package com.iblood.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.iblood.R;
import com.iblood.base.BaseActivity;

public class WxActivity extends BaseActivity implements View.OnClickListener {

     private TextView top_left;
    private TextView top_right;
    private CheckBox wx_check;
    private Button wx_login;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wx;
    }

    @Override
    protected void initView() {
        top_left = (TextView) findViewById(R.id.top_left);
        top_right = (TextView) findViewById(R.id.top_right);
        wx_check = (CheckBox) findViewById(R.id.wx_check);
           wx_login = (Button) findViewById(R.id.wx_login);

    }

    @Override
    protected void initData() {
       top_left.setOnClickListener(this);
     top_right.setOnClickListener(this);
     wx_check.setOnClickListener(this);
     wx_login.setOnClickListener(this);
    }

    @Override
    protected void initListener() {
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.top_left:
                finish();
                break;
            case  R.id.top_right:
                Toast.makeText(WxActivity.this,"刷新",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
