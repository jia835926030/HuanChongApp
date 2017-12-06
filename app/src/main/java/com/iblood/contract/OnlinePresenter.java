package com.iblood.contract;


import com.iblood.entity.HotBean;
import com.iblood.model.dataModel.IOnlineModel;
import com.iblood.model.dataModel.OnlineModelImpl;
import com.iblood.model.net.NetWorkCallBack;


public class OnlinePresenter implements Contract.Presenter {

    private Contract.OnlineView onlineView;
    private IOnlineModel onlineModel;

    /*
       在构造方法里面做了什么事情;   初始化了HomeView  这时候的homeView相当于HomePageFragent
       同时在这个构造方法中有初始化了homeModel   HomeModel里面就是网络请求后从服务器返回的bean结果
     */
    public OnlinePresenter(Contract.OnlineView onlineView) {
        this.onlineView = onlineView;
        onlineView.setPresenter(this);
        this.onlineModel = new OnlineModelImpl();
    }

    @Override
    public void start() {
        onlineView.showProgress();
        onlineModel.loadHotList(new NetWorkCallBack<HotBean>() {
            @Override
            public void onSuccess(HotBean hotBean) {
                onlineView.showHotData(hotBean);
                onlineView.dismissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                onlineView.showMessage(errorMsg);
                onlineView.dismissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }
}
