package com.iblood.base;

import android.widget.ImageView;


import com.iblood.model.net.NetWorkCallBack;

import java.io.File;
import java.util.Map;


public interface IBaseHttp {
    <T> void get(String url, NetWorkCallBack<T> callBack);

    <T> void get(String url, Map<String, String> params, NetWorkCallBack<T> callBack);

    <T> void get(String url, Map<String, String> params, Map<String, String> header, NetWorkCallBack<T> callBack);

    <T> void post(String url, Map<String, String> params, NetWorkCallBack<T> callBack);

    void upLoad(String url, Map<String, String> params, File file, NetWorkCallBack callBack);

    void downLoad();

    void loadImage(String url, ImageView imageView);


}
