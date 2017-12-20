package com.iblood.ui.setmodoule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.iblood.R;
import com.iblood.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProposalActivity extends BaseActivity {

    @BindView(R.id.proposal_edittext)
    EditText proposalEdittext;
    @BindView(R.id.proposal_textview)
    TextView proposalTextview;
    @BindView(R.id.proposal_back)
    ImageView proposal_back;

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
    @OnClick({R.id.proposal_back})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.proposal_back:
                finish();
                break;

        }
    }

}
