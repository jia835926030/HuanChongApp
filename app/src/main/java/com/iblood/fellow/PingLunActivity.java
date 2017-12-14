package com.iblood.fellow;

import android.os.Bundle;
import android.widget.ListView;

import com.iblood.R;
import com.iblood.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PingLunActivity extends BaseActivity {


    @BindView(R.id.listview_fellow)
    ListView listviewFellow;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ping_lun;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        List<PingLunBean> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(new PingLunBean(R.mipmap.ic_launcher,"YHQWYX"+i,"非常认真","大型犬 1天","2012-12-12"));
        }
        PingLunAdapter adapter = new PingLunAdapter(this,list);
        listviewFellow.setAdapter(adapter);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
