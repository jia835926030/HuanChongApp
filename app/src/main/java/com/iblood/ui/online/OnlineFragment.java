package com.iblood.ui.online;


import android.os.Bundle;
import android.view.View;

import com.iblood.R;
import com.iblood.base.BaseFragment;
import com.iblood.contract.Contract;
import com.iblood.entity.HotBean;


public class OnlineFragment extends BaseFragment implements Contract.OnlineView {


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_online;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void setBundle(Bundle bundle) {

    }

    @Override
    public void showHotData(HotBean hotBean) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(Contract.Presenter presenter) {

    }
}
