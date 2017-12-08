package com.iblood.ui;

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
    private View v1;
    private View v2;
    private View v3;

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
    事
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.mOLBtn, R.id.mMangerBtn, R.id.mPersonalBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mOLBtn:
                popu1();
                break;
            case R.id.mMangerBtn:
                popu2();
                break;
            case R.id.mPersonalBtn:
                popu3();
                break;
        }
    }

    //选择城市
    private void popu1() {
        //显示popuwindow
        v1 = LayoutInflater.from(HomeActivity.this).inflate(R.layout.fragment_online, null);
        //创建一个popuwindow对象
        PopupWindow popu1 = new PopupWindow(v1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //默认获取不到焦点，设置获取焦点
        popu1.setFocusable(true);
        //点击窗口以外区域，窗口消失
        popu1.setBackgroundDrawable(new BitmapDrawable());
        //弹出或者消失的时候带动画效果
//                popu.setAnimationStyle(R.style.mypopu);
        //显示popuwindow
        popu1.showAsDropDown(mBottomGroup, 0, 0);
    }
    //重置
    private void popu2() {
        //显示popuwindow
        v2 = LayoutInflater.from(HomeActivity.this).inflate(R.layout.fragment_manage, null);
        //创建一个popuwindow对象
        PopupWindow popu1 = new PopupWindow(v2, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //默认获取不到焦点，设置获取焦点
        popu1.setFocusable(true);
        //点击窗口以外区域，窗口消失
        popu1.setBackgroundDrawable(new BitmapDrawable());
        //弹出或者消失的时候带动画效果
//                popu.setAnimationStyle(R.style.mypopu);
        //显示popuwindow
        popu1.showAsDropDown(mBottomGroup, 0, 0);
    }
    //确定
    private void popu3() {
        //显示popuwindow
        v3 = LayoutInflater.from(HomeActivity.this).inflate(R.layout.fragment_personal, null);
        //创建一个popuwindow对象
        PopupWindow popu1 = new PopupWindow(v3, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //默认获取不到焦点，设置获取焦点
        popu1.setFocusable(true);
        //点击窗口以外区域，窗口消失
        popu1.setBackgroundDrawable(new BitmapDrawable());
        //弹出或者消失的时候带动画效果
//                popu.setAnimationStyle(R.style.mypopu);
        //显示popuwindow
        popu1.showAsDropDown(mBottomGroup, 0, 0);

        ImageView personal_saixuan = v3.findViewById(R.id.personal_saixuan);

        Button personal_chongzhi = v3.findViewById(R.id.personal_chongzhi);
        Button personal_queding = v3.findViewById(R.id.personal_queding);
        personal_saixuan.setOnClickListener(this);
        personal_chongzhi.setOnClickListener(this);
        personal_queding.setOnClickListener(this);
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

            case R.id.my_home:
                Toast.makeText(this, "mmmmmmmmmmmm", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dingwei_hoem:
                Toast.makeText(this, "ddddddddddd", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cehua_tou:
                Toast.makeText(this, "ttttttttt", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cehua_shenqing:
                Toast.makeText(this, "不好使", Toast.LENGTH_SHORT).show();

                break;
            case R.id.personal_saixuan:
                Intent intent = new Intent(HomeActivity.this, FilterActivity.class);
                startActivity(intent);
                break;
            case R.id.personal_chongzhi:
                Toast.makeText(HomeActivity.this, "1111111111111", Toast.LENGTH_SHORT).show();
                break;
            case R.id.personal_queding:
                Toast.makeText(HomeActivity.this, "1111111111111", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
