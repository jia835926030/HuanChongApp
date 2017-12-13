package com.iblood.base;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.iblood.app.App;
import com.iblood.ui.PetAddActivity;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.qqtheme.framework.picker.DatePicker;


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
//选择日期
    public void Date_selection(final TextView view) {
        DatePicker picker = new DatePicker(App.mBaseActivity);
        picker.setRange(1990, 2030);//年份范围
        picker.setSubmitTextColor(Color.BLUE);
        picker.setCancelTextColor(Color.BLUE);
        picker.setTextColor(Color.BLACK);
        picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
            @Override
            public void onDatePicked(String year, String month, String day) {
                if (!year.isEmpty() || !month.isEmpty() || !day.isEmpty()) {
                    textToast("修改成功");
                    view.setText(year + "年" + month + "月" + day + "日");
                } else {
                    textToast("网络不佳,请稍后重试");
                }

            }
        });
        picker.show();
    }

}
