package com.iblood.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.iblood.app.App;
import com.iblood.base.IBaseHttp;
import com.iblood.model.net.NetWorkCallBack;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class OkHttpUtils implements IBaseHttp {
    private OkHttpClient client;
    private static OkHttpUtils utils;

    private OkHttpUtils() {
        client = new OkHttpClient.Builder().build();
    }

    public static OkHttpUtils getInstance() {
        if (utils == null) {
            synchronized (OkHttpUtils.class) {
                utils = new OkHttpUtils();
            }
        }
        return utils;
    }


    /**
     * @param url      网址
     * @param callBack 回调
     * @param <T>      请求回来的数据对应的javaBean
     */

    @Override
    public <T> void get(String url, NetWorkCallBack<T> callBack) {

    }

    /**
     * @param url      网址
     * @param params   参数
     * @param callBack 回调
     * @param <T>      javaBean
     */
    @Override
    public <T> void get(String url, Map<String, String> params, final NetWorkCallBack<T> callBack) {
        StringBuffer buffer = new StringBuffer(url);
        if (params != null && params.size() > 0) {
            buffer.append("?");
            Set<String> keys = params.keySet();
            for (String key :
                    keys) {
                String value = params.get(keys);
                buffer.append(key).append("=").append(value).append("&");
            }
            url = buffer.substring(0, buffer.length() - 1).toString();
        }

        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.mBaseActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(404, e.getMessage().toString());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonString = response.body().string();
                App.mBaseActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(getGeneric(jsonString, callBack));
                    }
                });
            }
        });


    }

    @Override
    public <T> void get(String url, Map<String, String> params, Map<String, String> header, final NetWorkCallBack<T> callBack) {
        StringBuffer buffer = new StringBuffer(url);
        if (params != null && params.size() > 0) {
            buffer.append("?");
            Set<String> keys = params.keySet();
            for (String key :
                    keys) {
                String value = params.get(key);
                buffer.append(key).append("=").append(value).append("&");
            }
            url = buffer.substring(0, buffer.length() - 1).toString();
        }
        Request.Builder builder = new Request.Builder();
        if (header != null && header.size() > 0) {
            Set<String> keys = header.keySet();
            for (String key :
                    keys) {
                String value = header.get(key);
                builder.addHeader(key, value);
            }
        }
        Request request = builder.url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.mBaseActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(404, e.getMessage().toString());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                App.mBaseActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(getGeneric(string, callBack));
                    }
                });
            }
        });
    }

    /**
     * post表单上传
     *
     * @param url
     * @param params
     * @param callBack
     * @param <T>
     */
    @Override
    public <T> void post(String url, Map<String, String> params, final NetWorkCallBack<T> callBack) {
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null && params.size() > 0) {
            Set<String> keys = params.keySet();
            for (String key :
                    keys) {
                String value = params.get(key);
                builder.add(key, value);
            }
        }
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.mBaseActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(404, e.getMessage().toString());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                App.mBaseActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(getGeneric(string, callBack));
                    }
                });
            }
        });
    }

    @Override
    public void upLoad(String url, Map<String, String> params, File file, NetWorkCallBack callBack) {

    }

    @Override
    public void downLoad() {

    }

    @Override
    public void loadImage(String url, ImageView imageView) {
        Glide.with(App.mBaseActivity).load(url).into(imageView);
    }


    private <T> T getGeneric(String jsonData, NetWorkCallBack<T> callBack) {
        Gson gson = new Gson();
        //通过反射获取泛型的实例
        Type[] types = callBack.getClass().getGenericInterfaces();
        Type[] actualTypeArguments = ((ParameterizedType) types[0]).getActualTypeArguments();
        Type type = actualTypeArguments[0];
        T t = gson.fromJson(jsonData, type);
        return t;
    }
}
