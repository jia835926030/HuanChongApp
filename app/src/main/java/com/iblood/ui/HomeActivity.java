package com.iblood.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
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
import com.iblood.ui.setmodoule.SetUpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.mOLBtn)
    RadioButton mOLBtn;
    @BindView(R.id.mMangerBtn)
    RadioButton mMangerBtn;
    @BindView(R.id.mPersonalBtn)
    RadioButton mPersonalBtn;
    @BindView(R.id.my_home)
    ImageView myHome;
    @BindView(R.id.ed_home)
    EditText edHome;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.dingwei_hoem)
    ImageView dingweiHoem;
    @BindView(R.id.rel_home)
    RelativeLayout relHome;
    @BindView(R.id.mBottomGroup)
    RadioGroup mBottomGroup;
    @BindView(R.id.mFrame)
    FrameLayout mFrame;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.activity_home)
    DrawerLayout activityHome;
    @BindView(R.id.cehua_shenqing)
    Button cehuaShenqing;
    private FragmentManager fragmentManager;
    private long mExitTime;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        //侧滑头布局
        View headerView = navView.getHeaderView(0);
        View cehua_tou = headerView.findViewById(R.id.cehua_tou);
        cehua_tou.setOnClickListener(this);
        //侧滑item点击事件
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //允许条目点击
                item.setCheckable(true);
                switch (item.getItemId()) {
                    case R.id.cehua_xiaoxi:
                        Toast.makeText(HomeActivity.this, "11111111111111", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.cehua_chongwu:
                        Toast.makeText(HomeActivity.this, "22222222222222", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.cehua_shezhi:
                        Intent intent=new Intent(HomeActivity.this, SetUpActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.cehua_qianbao:
                        Intent intent1=new Intent(HomeActivity.this,WalletActivity.class);
                        startActivity(intent1);
                        break;

                }
                return false;
            }
        });
        myHome.setOnClickListener(this);
        dingweiHoem.setOnClickListener(this);
        cehuaShenqing.setOnClickListener(this);
    }

    //添加初始Fragment
    @Override
    protected void initData() {
        fragmentManager = App.mBaseActivity.getSupportFragmentManager();
        OnlineFragment onlineFragment = (OnlineFragment) FragmentManger.getInstance().start(R.id.mFrame, OnlineFragment.class, false).build();
        new OnlinePresenter(onlineFragment);
    }

    @Override
    protected void initListener() {

    }

    //Fragment切换
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
                if ((System.currentTimeMillis() - mExitTime) > 100) {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cehua_tou:
                Intent intent=new Intent(this,PersonalInformation.class);
                startActivity(intent);
                break;
            case R.id.my_home:
                Toast.makeText(this, "mmmmmmmmmmmm", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dingwei_hoem:
                Toast.makeText(this, "ddddddddddd", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cehua_shenqing:
                Toast.makeText(this, "不好使", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
