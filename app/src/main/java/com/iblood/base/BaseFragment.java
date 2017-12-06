package com.iblood.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.iblood.app.App;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment extends Fragment {
    private View view;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = View.inflate(App.mBaseActivity, getLayoutRes(), null);
        }

        ViewGroup parent = (ViewGroup) view.getParent();

        if (parent != null) {
            parent.removeView(view);
        }

        unbinder = ButterKnife.bind(view);
        initView(view);

        return view;
    }

    /**
     * 获取Fragment布局文件的View
     *
     * @param inflater
     * @param container
     * @return
     */
    private View getCreateView(LayoutInflater inflater, ViewGroup container) {

        return inflater.inflate(getLayoutRes(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    protected abstract int getLayoutRes();

    protected abstract void initView(View view);

    protected abstract void initData();
    /**
     * Fragment之间传递数据或者Fragment与Activity之间传递值都可以使用该方法
     * 对应的获取Bundle的方法是
     * Bundle bundle=getArguments();
     *
     * @param bundle
     */
    public abstract void setBundle(Bundle bundle);

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

}
