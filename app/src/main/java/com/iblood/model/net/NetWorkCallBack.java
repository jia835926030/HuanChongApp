package com.iblood.model.net;

public interface NetWorkCallBack<T> {
    void onSuccess(T t);

    void onError(int errorCode, String errorMsg);

    void onFail(String netOff);
}
