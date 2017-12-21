package com.iblood.ui.ordermodole.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.iblood.R;
import com.iblood.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class ParticularsActivity extends BaseActivity {

    private ListView listView_par;
  private List<String> mlist = new ArrayList<>();
  private Button app_order;
    private ImageView order_back;

    @Override
    protected int getLayoutId() {
        //return R.layout.activity_particulars;
           return  R.layout.item_appraise;
    }

    @Override
    protected void initView() {
     // listView_par =  (ListView) findViewById(R.id.listView_par);
    app_order =   (Button)  findViewById(R.id.app_order);
      order_back =  (ImageView) findViewById(R.id.order_back);
    }

    @Override
    protected void initData() {
//       runOnUiThread(new Runnable() {
//           @Override
//           public void run() {
//
//           }
//       });
      app_order.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
startActivity(new Intent(ParticularsActivity.this,RegoActibity.class));
        }
      });
        order_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    @Override
    protected void initListener() {

    }
}
