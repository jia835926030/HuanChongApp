package com.iblood.ui.setmodoule;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.iblood.R;
import com.iblood.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProposalActivity extends BaseActivity {

    @BindView(R.id.proposal_edittext)
    EditText proposalEdittext;
    @BindView(R.id.proposal_textview)
    TextView proposalTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_proposal;
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
