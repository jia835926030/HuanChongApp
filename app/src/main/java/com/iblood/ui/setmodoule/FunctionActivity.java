package com.iblood.ui.setmodoule;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.iblood.R;
import com.iblood.ui.setmodoule.dapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class FunctionActivity extends AppCompatActivity {

    private ViewPager mvp;
    private ImageView iv_back;
    private List<View> lImageViews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);
        mvp = (ViewPager) findViewById(R.id.vp);
        iv_back = (ImageView) findViewById(R.id.iv_newback);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        lImageViews = new ArrayList<View>();
        ImageView iv1 = new ImageView(FunctionActivity.this);
        iv1.setImageResource(R.drawable.a);
        ImageView iv2 = new ImageView(FunctionActivity.this);
        iv2.setImageResource(R.drawable.b);
        ImageView iv3 = new ImageView(FunctionActivity.this);
        iv3.setImageResource(R.drawable.c);
        lImageViews.add(iv1);
        lImageViews.add(iv2);
        lImageViews.add(iv3);
        MyPagerAdapter mAdapter = new MyPagerAdapter(lImageViews);
        mvp.setAdapter(mAdapter);
    }
    }

