package com.iblood.ui;

import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.iblood.R;
import com.iblood.app.ActivityCollector;
import com.iblood.app.App;
import com.iblood.app.FragmentManger;
import com.iblood.base.BaseActivity;
import com.iblood.base.BaseFragment;
import com.iblood.contract.OnlinePresenter;
import com.iblood.ui.manage.ManageFragment;
import com.iblood.ui.online.OnlineFragment;
import com.iblood.ui.personal.PersonalFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {
    @BindView(R.id.mOLBtn)
    RadioButton mOLBtn;
    @BindView(R.id.mMangerBtn)
    RadioButton mMangerBtn;
    @BindView(R.id.mPersonalBtn)
    RadioButton mPersonalBtn;
    private FragmentManager fragmentManager;
    private long mExitTime;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {
        fragmentManager = App.mBaseActivity.getSupportFragmentManager();
        OnlineFragment onlineFragment = (OnlineFragment) FragmentManger.getInstance().start(R.id.mFrame, OnlineFragment.class, false).build();
        new OnlinePresenter(onlineFragment);
    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.mOLBtn, R.id.mMangerBtn, R.id.mPersonalBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mOLBtn:
                FragmentManger.getInstance().start(R.id.mFrame, new OnlineFragment().getClass(), false).build();
                break;
            case R.id.mMangerBtn:
                FragmentManger.getInstance().start(R.id.mFrame, new ManageFragment().getClass(), false).build();
                break;
            case R.id.mPersonalBtn:
                FragmentManger.getInstance().start(R.id.mFrame, new PersonalFragment().getClass(), false).build();
                break;
        }
    }


    @Override
    public void onBackPressed() {
        String simpleName = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
        if ("HomePageFragment".equals(simpleName) ||
                "LivePageFragment".equals(simpleName) ||
                "VideoFragment".equals(simpleName) ||
                "BoBaoFragment".equals(simpleName)
                ) {
            finish();
        } else {
            if (fragmentManager.getBackStackEntryCount() > 1) {
                fragmentManager.popBackStackImmediate();//
                String name = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
                App.mBaseFragment = (BaseFragment) fragmentManager.findFragmentByTag(name);
            }
        }
    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        String name = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
        if ("HomePageFragment".equals(name) ||
                "LivePageFragment".equals(name) ||
                "VideoFragment".equals(name) ||
                "BoBaoFragment".equals(name)
                ) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                if ((System.currentTimeMillis() - mExitTime) > 2000) {
                    Toast.makeText(this, "-------------", Toast.LENGTH_SHORT).show();
                    mExitTime = System.currentTimeMillis();
                } else {
                    ActivityCollector.getInstance().exit(App.mBaseActivity);
                }
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
