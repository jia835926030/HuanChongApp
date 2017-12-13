package com.iblood.ui;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iblood.R;
import com.iblood.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;
import cn.qqtheme.framework.picker.DatePicker;

/**
 * 添加宠物
 * <p>
 * 刘贵河
 */
public class PetAddActivity extends BaseActivity {
    @BindView(R.id.text_title)
    TextView header_title;//头标题
    @BindView(R.id.pet_face)
    RelativeLayout pet_Face;
    @BindView(R.id.pet_name)
    RelativeLayout pet_Name;
    @BindView(R.id.pet_types)
    RelativeLayout pet_Types;
    @BindView(R.id.pet_sterilization)
    RelativeLayout pet_Sterilization;
    @BindView(R.id.pet_time)
    RelativeLayout pet_Time;
    @BindView(R.id.pet_weight)
    RelativeLayout pet_Weight;
    @BindView(R.id.pet_immunizing)
    RelativeLayout pet_immunizing;
    @BindView(R.id.pet_profile)
    EditText pet_Profile;
    @BindView(R.id.topTime)
    TextView topTime;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_pet_add;
    }

    @Override
    protected void initView() {
        header_title.setText("添加宠物");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.pet_face, R.id.pet_name, R.id.pet_types, R.id.pet_sterilization, R.id.pet_time, R.id.pet_weight, R.id.pet_immunizing, R.id.pet_profile})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pet_face:

                break;
            case R.id.pet_name:

                break;
            case R.id.pet_types:
                //宠物类型
                startActivity(new Intent(PetAddActivity.this, PetTypeActivity.class));
                break;
            case R.id.pet_sterilization:
                break;
            case R.id.pet_time:
                //出生日期
                Date_selection(topTime);
                break;
            case R.id.pet_weight:
                break;
            case R.id.pet_immunizing:
                //免疫情况
                startActivity(new Intent(PetAddActivity.this, ImmunizingActivity.class));
                break;
            case R.id.pet_profile:
                break;
        }
    }


}
