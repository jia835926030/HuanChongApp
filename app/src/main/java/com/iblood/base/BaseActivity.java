package com.iblood.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.iblood.app.App;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity extends AutoLayoutActivity {
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置竖屏
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        setContentView(getLayoutId());
        App.mBaseActivity = this;
        unbinder = ButterKnife.bind(this);

        //注意以下方法仅在Activity创建的时候调用一次
        //activity添加到Activity的管理里面
        // ActivityCollector.getInstance().addActivity(this);
        initView();
        initData();
        initListener();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();

    @Override
    protected void onResume() {
        super.onResume();
        //这里添加需要重复执行的内容
        App.mBaseActivity = this;
    }

    public void textToast(String str){
        Toast.makeText(App.mBaseActivity,str,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

}
