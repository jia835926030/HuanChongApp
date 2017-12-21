package com.iblood.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iblood.R;
import com.iblood.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 免疫情况
 * <p>
 * 刘贵河
 */
public class ImmunizingActivity extends BaseActivity {
    @BindView(R.id.text_title)
    TextView header_title;//头标题
    @BindView(R.id.button_forward)
    TextView button_forward;
    @BindView(R.id.button_backward)
    ImageView button_backward;
    @BindView(R.id.pet_mian_time)
    RelativeLayout pet_mian_time;
    @BindView(R.id.tv_pet_immune_data)
    TextView tv_pet_immune_data;
    @BindView(R.id.cb_imm)
    CheckBox cb_imm;
    @BindView(R.id.pet_re_time)
    LinearLayout pet_re_time;
    @BindView(R.id.mian_gridView)
    LinearLayout mian_gridView;
    @BindView(R.id.add_pet_immune)
    LinearLayout add_pet_immune;
    @BindView(R.id.immgrid)
    GridView immgrid;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_immunizing;
    }

    @Override
    protected void initView() {
        header_title.setText("免疫情况");
        button_forward.setText("确定");
    }


    @Override
    protected void initData() {

    }
    @Override
    protected void onResume() {
        super.onResume();
        //因为默认false 所以进来是看不到这些
        add_pet_immune.setVisibility(View.GONE);
        pet_mian_time.setVisibility(View.GONE);
        pet_re_time.setVisibility(View.GONE);
        mian_gridView.setVisibility(View.GONE);

    }

    @Override
    protected void initListener() {
        cb_imm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    textToast("true");
                    add_pet_immune.setVisibility(View.VISIBLE);
                    pet_mian_time.setVisibility(View.VISIBLE);
                    pet_re_time.setVisibility(View.VISIBLE);
                    mian_gridView.setVisibility(View.VISIBLE);
                } else {
                    textToast("false");
                    add_pet_immune.setVisibility(View.GONE);
                    pet_mian_time.setVisibility(View.GONE);
                    pet_re_time.setVisibility(View.GONE);
                    mian_gridView.setVisibility(View.GONE);
                }
            }
        });
    }

    @OnClick({R.id.button_backward, R.id.pet_mian_time, R.id.button_forward})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_backward:
                finish();
                break;
            case R.id.pet_mian_time:
                Date_selection(tv_pet_immune_data, 2015);
                break;
            case R.id.button_forward:
                textToast("不好使");
                break;
//
        }
    }
}
