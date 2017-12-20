package com.iblood.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.iblood.R;
import com.iblood.base.BaseActivity;
import com.iblood.tools.ClearEditText;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 宠物类型
 *
 *   刘贵河
 */
public class PetTypeActivity  extends BaseActivity {
    @BindView(R.id.text_title)
    TextView header_title;//头标题
    @BindView(R.id.button_backward)
    ImageView button_backward;
    @BindView(R.id.filter_edit)
    ClearEditText mClearEditText;//搜索框


    @Override
    protected int getLayoutId() {
        return R.layout.activity_pet_type;
//
    }

    @Override
    protected void initView() {
        mClearEditText.setHint("请输入要搜索的宠物信息");
        header_title.setText("宠物类型");
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
