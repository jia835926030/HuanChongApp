package com.iblood.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alipay.sdk.app.PayTask;
import com.iblood.R;
import com.iblood.ui.menu.MainActivity;
import com.iblood.ui.zhifubao.PayResult;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WalletActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.text_title)
    TextView header_title;//头标题
    @BindView(R.id.button_forward)
    TextView button_forward;
    @BindView(R.id.button_backward)
    ImageView button_backward;
    @BindView(R.id.zhifubao_wallet)
    AutoRelativeLayout zhifubaoWallet;



    private TextView tv_Balance;
    private TextView zhifubao;
    private TextView youhuijquan;
    private TextView jifen;

    private final int ALI_PAY_FLAG = 1;
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ALI_PAY_FLAG: {
                    //PayResult非常简单的工具类,把map里的结果取出来(来自支付宝demo)
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);

                    //对于支付结果，请商户依赖服务端的异步通知结果
                    //同步通知结果，仅作为支付结束的通知
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();//状态码
                    String memo = payResult.getMemo();//附加信息,如果不为空可以提示该内容
                    switch (resultStatus) {
                        case "9000":
                            //支付成功
                            break;
                        case "8000":
                            //支付结果确认中
                            break;
                        case "4000":
                            //订单支付失败
                            break;
                        case "5000":
                            //重复请求
                            break;
                        case "6001":
                            //用户中途取消
                            break;
                        case "6002":
                            //网络连接出错
                            break;
                        case "6004":
                            //支付结果未知,请查询订单
                            break;
                        default:
                            //其它支付错误
                            break;
                    }
                    Log.e("TAG", "handleMessage: " + payResult.toString());
                    break;
                }
                default:
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        ButterKnife.bind(this);
        initView();
        button_backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    @OnClick({R.id.button_backward})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_backward:
                finish();
                break;
        }

    }

    private void initView() {

        tv_Balance = (TextView) findViewById(R.id.tv_Balance);
        zhifubao = (TextView) findViewById(R.id.zhifubao);
        youhuijquan = (TextView) findViewById(R.id.youhuijquan);
        jifen = (TextView) findViewById(R.id.jifen);
        button_forward.setText("交易记录");
        header_title.setText("我的钱包");
        zhifubaoWallet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.zhifubao_wallet:
                //orderInfo的获取必须来自服务端；
                alipay("orderInfo");
                break;
        }
    }

    /**
     * 支付宝支付 必须在异步线程
     *
     * @param orderInfo app支付请求参数字符串，主要包含商户的订单信息，
     *                  key=value形式，以&连接,由服务端生成
     */
    private void alipay(final String orderInfo) {
        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                PayTask alipay = new PayTask(WalletActivity.this);
                //传入支付订单信息,设置ture表示显示支付的loading
                Map<String, String> result = alipay.payV2(orderInfo, true);
                Message msg = new Message();
                msg.what = ALI_PAY_FLAG;
                msg.obj = result;
                handler.sendMessage(msg);
            }
        };
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }
}
