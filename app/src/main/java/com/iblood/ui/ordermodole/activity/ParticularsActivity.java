package com.iblood.ui.ordermodole.activity;

import android.widget.ListView;

import com.iblood.R;
import com.iblood.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class ParticularsActivity extends BaseActivity {

    private ListView listView_par;
  private List<String> mlist = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        //return R.layout.activity_particulars;
        return  R.layout.item_appraise;
    }

    @Override
    protected void initView() {
     // listView_par =  (ListView) findViewById(R.id.listView_par);
    }

    @Override
    protected void initData() {
//       runOnUiThread(new Runnable() {
//           @Override
//           public void run() {
//
//           }
//       });
    }

    @Override
    protected void initListener() {

    }
}
