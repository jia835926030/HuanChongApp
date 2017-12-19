package com.iblood.ui;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    @BindView(R.id.button_forward)
    Button button_forward;
    @BindView(R.id.button_backward)
    Button button_backward;
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
    @BindView(R.id.pet_user_name)
    TextView pet_user_name;
    @BindView(R.id.pet_user_sexy)
    TextView pet_user_sexy;
    @BindView(R.id.pet_user_steri)
    TextView pet_user_steri;

    TextView userName;
    protected static final int PET_NAME_CODE = 11;
    protected static final int PET_ISNO_CODE = 12;
    protected static final int PET_WEIGHT_CODE = 13;

    protected static final int RESUL_CODE = 200;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pet_add;
    }

    @Override
    protected void initView() {
        header_title.setText("添加宠物");
        button_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToast(" 已保存(不好使)");

                String pet_proFile = pet_Profile.getText().toString().trim();

                textToast(pet_proFile);
                finish();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.pet_face, R.id.pet_name, R.id.pet_types, R.id.pet_sterilization, R.id.pet_time, R.id.pet_weight, R.id.pet_immunizing, R.id.pet_profile,R.id.button_backward})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pet_face:

                break;
            case R.id.pet_name:
                //跳转修改Pet名称
                /*startActivityForResult(new Intent(PetAddActivity.this, ModificationActivity.class)
                        .putExtra("title", "宠物名")
                        .putExtra("hint", "请填写宠物昵称"), PET_NAME_CODE);*/
                break;
            case R.id.pet_types:
                //宠物类型
                startActivity(new Intent(PetAddActivity.this, PetTypeActivity.class));
                break;
            case R.id.pet_sterilization:
                //是否绝育
                startActivityForResult(new Intent(PetAddActivity.this, ModificationActivity.class)
                        .putExtra("title", "是否绝育")
                        .putExtra("hint", "请填写宠物是否绝育"), PET_ISNO_CODE);
                break;
            case R.id.pet_time:
                //出生日期
                Date_selection(topTime);
                break;
            case R.id.pet_weight:
                //体重
                startActivityForResult(new Intent(PetAddActivity.this, ModificationActivity.class)
                        .putExtra("title", "宠物体重")
                        .putExtra("hint", "请填写宠物体重"), PET_WEIGHT_CODE);
                break;
            case R.id.pet_immunizing:
                //免疫情况
                startActivity(new Intent(PetAddActivity.this, ImmunizingActivity.class));
                break;
            case R.id.pet_profile:

                break;
            case R.id.button_backward:
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //名字
        if (requestCode == PET_NAME_CODE && resultCode == RESUL_CODE) {
            pet_user_name.setText(data.getStringExtra("rcode"));
        }
        //是否绝育
        if (requestCode == PET_ISNO_CODE && resultCode == RESUL_CODE) {
            pet_user_steri.setText(data.getStringExtra("rcode"));
        }


    }
}
