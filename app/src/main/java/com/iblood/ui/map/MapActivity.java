package com.iblood.ui.map;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.iblood.R;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);


        TextView viewById = findViewById(R.id.button_forward);

        TextView text_title = findViewById(R.id.text_title);

        ImageView button_backward = findViewById(R.id.button_backward);

        viewById.setVisibility(View.GONE);
        text_title.setVisibility(View.GONE);

        WebView byId = (WebView)findViewById(R.id.my_Map);

        byId.setWebViewClient(new WebViewClient() {
            //设置在webView点击打开的新网页在当前界面显示,而不跳转到新的浏览器中
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        byId.getSettings().setJavaScriptEnabled(true);  //设置WebView属性,运行执行js脚本
        byId.loadUrl("http://www.gaode.com/");
        button_backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
