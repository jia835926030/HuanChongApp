package com.iblood.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iblood.R;
import com.iblood.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 免疫情况
 *
 *   刘贵河
 */
public class  ImmunizingActivity extends BaseActivity {
    @BindView(R.id.text_title)
    TextView header_title;//头标题
    @BindView(R.id.button_forward)
    TextView button_forward;
    @BindView(R.id.button_backward)
    ImageView button_backward;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_immunizing;
    }

    @Override
    protected void initView() {
        header_title.setText("免疫情况");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
    @OnClick({R.id.button_backward})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.button_backward:
                finish();
                break;
        }
    }
}
