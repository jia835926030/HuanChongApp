package com.iblood.ui;

import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

import com.iblood.R;
import com.iblood.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by 刘贵河 on 2017/12/7.
 */

public class ModificationActivity extends BaseActivity {
    @BindView(R.id.mTitle)
    TextView mTitle;
    @BindView(R.id.mEditText)
    EditText mEditText;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_modification;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        String titletext = intent.getStringExtra("title");
        String hint = intent.getStringExtra("hint");
        mTitle.setText(titletext);
        mEditText.setHint(hint);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
