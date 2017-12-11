package com.iblood.ui.ordermodole;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iblood.R;
import com.iblood.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class WholeFragment extends BaseFragment {


    public WholeFragment() {
        // Required empty public constructor
    }


/*    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_whole, container, false);
    }*/

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_whole;
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

}
