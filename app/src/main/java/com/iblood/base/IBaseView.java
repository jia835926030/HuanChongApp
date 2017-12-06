package com.iblood.base;


public interface IBaseView<T> {
    void showProgress();

    void dismissProgress();

    void showMessage(String msg);

    void setPresenter(T t);
}
