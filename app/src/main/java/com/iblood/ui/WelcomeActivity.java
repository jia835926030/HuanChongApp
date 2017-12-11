package com.iblood.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.iblood.R;
import com.iblood.base.BaseActivity;
import com.iblood.ui.setmodoule.SetUpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends BaseActivity implements Animator.AnimatorListener {

    @BindView(R.id.mWelcomeImg)
    ImageView mWelcomeImg;
    private ObjectAnimator oa;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        oa = ObjectAnimator.ofFloat(mWelcomeImg, "alpha", 1f);
        oa.setDuration(2000);
        oa.start();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        oa.addListener(this);
    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
        startActivity(new Intent(this,HomeActivity.class));
		finish();
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
}
