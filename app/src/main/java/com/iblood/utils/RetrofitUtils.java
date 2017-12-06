package com.iblood.utils;

import android.widget.ImageView;


import com.iblood.base.IBaseHttp;
import com.iblood.model.net.NetWorkCallBack;

import java.io.File;
import java.util.Map;

import retrofit2.Retrofit;


public class RetrofitUtils implements IBaseHttp {
    private Retrofit retrofit;
    private static RetrofitUtils utils;

    public static RetrofitUtils getInstance() {
        if (utils == null) {
            synchronized (RetrofitUtils.class) {
                utils = new RetrofitUtils();
            }
        }
        return utils;
    }

    @Override
    public <T> void get(String url, NetWorkCallBack<T> callBack) {

    }

    @Override
    public <T> void get(String url, Map<String, String> params, NetWorkCallBack<T> callBack) {

    }

    @Override
    public <T> void get(String url, Map<String, String> params, Map<String, String> header, NetWorkCallBack<T> callBack) {

    }

    @Override
    public <T> void post(String url, Map<String, String> params, NetWorkCallBack<T> callBack) {

    }

    @Override
    public void upLoad(String url, Map<String, String> params, File file, NetWorkCallBack callBack) {

    }

    @Override
    public void downLoad() {

    }

    @Override
    public void loadImage(String url, ImageView imageView) {

    }
}
