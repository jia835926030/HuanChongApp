package com.iblood.ui;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.iblood.R;
import com.iblood.app.ActivityCollector;
import com.iblood.app.App;
import com.iblood.base.BaseActivity;
import com.iblood.base.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity /*extends BaseActivity implements View.OnClickListener*/ {
    @BindView(R.id.mOLBtn)
    RadioButton mOLBtn;
    @BindView(R.id.mMangerBtn)
    RadioButton mMangerBtn;
    @BindView(R.id.mPersonalBtn)
    RadioButton mPersonalBtn;
   /* @BindView(R.id.my_home)
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
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.activity_home)
    DrawerLayout activityHome;
    @BindView(R.id.cehua_shenqing)
    Button cehuaShenqing;
    @BindView(R.id.list_home)
    ListView listHome;
    private FragmentManager fragmentManager;
    private long mExitTime;
    private View v;

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
                }
                return false;
            }
        });
        myHome.setOnClickListener(this);
        dingweiHoem.setOnClickListener(this);
        cehuaShenqing.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    //Fragment切换
    @OnClick({R.id.mOLBtn, R.id.mMangerBtn, R.id.mPersonalBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mOLBtn:
                //显示popuwindow
                v = LayoutInflater.from(HomeActivity.this).inflate(R.layout.fragment_online, null);
                //创建一个popuwindow对象
                PopupWindow popu = new PopupWindow(v, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                //默认获取不到焦点，设置获取焦点
                popu.setFocusable(true);
                //点击窗口以外区域，窗口消失
                popu.setBackgroundDrawable(new BitmapDrawable());
                //弹出或者消失的时候带动画效果
//                popu.setAnimationStyle(R.style.mypopu);
                //显示popuwindow
                popu.showAsDropDown(mBottomGroup, 0, 0);
                break;
            case R.id.mMangerBtn:
                //显示popuwindow
                v = LayoutInflater.from(HomeActivity.this).inflate(R.layout.fragment_manage, null);
                //创建一个popuwindow对象
                PopupWindow popu1 = new PopupWindow(v, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                //默认获取不到焦点，设置获取焦点
                popu1.setFocusable(true);
                //点击窗口以外区域，窗口消失
                popu1.setBackgroundDrawable(new BitmapDrawable());
                //弹出或者消失的时候带动画效果
//                popu.setAnimationStyle(R.style.mypopu);
                //显示popuwindow
                popu1.showAsDropDown(mBottomGroup, 0, 0);
                break;
            case R.id.mPersonalBtn:
                //显示popuwindow
                v = LayoutInflater.from(HomeActivity.this).inflate(R.layout.fragment_personal, null);
                //创建一个popuwindow对象
                PopupWindow popu2 = new PopupWindow(v, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                //默认获取不到焦点，设置获取焦点
                popu2.setFocusable(true);
                //点击窗口以外区域，窗口消失
                popu2.setBackgroundDrawable(new BitmapDrawable());
                //弹出或者消失的时候带动画效果
//                popu.setAnimationStyle(R.style.mypopu);
                //显示popuwindow
                popu2.showAsDropDown(mBottomGroup, 0, 0);
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
                Toast.makeText(this, "ttttttttt", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_home:
                Toast.makeText(this, "mmmmmmmmmmmm", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dingwei_hoem:
                Toast.makeText(this, "ddddddddddd", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cehua_shenqing:
                Toast.makeText(this, "ssssssssssss", Toast.LENGTH_SHORT).show();
                break;
        }
    }*/
}
