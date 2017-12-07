package com.iblood.ui.personal;

import android.widget.TextView;

import com.iblood.R;
import com.iblood.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by 刘贵河 on 2017/12/7.
 *
 * 修改联系地址
 */

public class PersonalAddress extends BaseActivity {
    @BindView(R.id.mTitleaddress)
    TextView mTitleaddress;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_address;
    }

    @Override
    protected void initView() {
        String title = getIntent().getStringExtra("title");
        mTitleaddress.setText(title);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
