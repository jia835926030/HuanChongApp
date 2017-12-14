package com.iblood.ui.personal;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.iblood.R;
import com.iblood.base.BaseFragment;
import com.iblood.ui.filter.FilterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalFragment extends BaseFragment implements View.OnClickListener {

//    @BindView(R.id.personal_saixuan)
//    ImageView personalSaixuan;
    @BindView(R.id.personal_dizhi)
    TextView personalDizhi;
    @BindView(R.id.personal_xizao)
    CheckBox personalXizao;
    @BindView(R.id.personal_jiesong)
    CheckBox personalJiesong;
    @BindView(R.id.personal_yuandan)
    CheckBox personalYuandan;
    @BindView(R.id.personal_cunjie)
    CheckBox personalCunjie;
    @BindView(R.id.personal_qingming)
    CheckBox personalQingming;
    @BindView(R.id.personal_laodong)
    CheckBox personalLaodong;
    @BindView(R.id.personal_duanwu)
    CheckBox personalDuanwu;
    @BindView(R.id.personal_zhongqiu)
    CheckBox personalZhongqiu;
    @BindView(R.id.personal_guoqing)
    CheckBox personalGuoqing;
    @BindView(R.id.personal_chongzhi)
    Button personalChongzhi;
    @BindView(R.id.personal_queding)
    Button personalQueding;
    Unbinder unbinder;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_personal;
    }

    @Override
    protected void initView(View view) {
        //personalSaixuan.setOnClickListener(this);
        personalChongzhi.setOnClickListener(this);
        personalQueding.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void setBundle(Bundle bundle) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.personal_saixuan:
//
//                break;
            case R.id.personal_chongzhi:
                break;
            case R.id.personal_queding:
                break;
        }

    }
}
