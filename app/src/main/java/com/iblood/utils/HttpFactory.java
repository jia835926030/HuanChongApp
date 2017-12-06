package com.iblood.utils;

import com.iblood.base.IBaseHttp;

public class HttpFactory {
    public static IBaseHttp createOk() {
        return OkHttpUtils.getInstance();
    }

    public static IBaseHttp createRetrofit() {
        return RetrofitUtils.getInstance();
    }
}
