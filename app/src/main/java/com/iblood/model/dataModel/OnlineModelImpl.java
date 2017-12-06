package com.iblood.model.dataModel;

import com.iblood.config.Urls;
import com.iblood.entity.HotBean;
import com.iblood.model.net.NetWorkCallBack;
public class OnlineModelImpl implements IOnlineModel {
    @Override
    public void loadHotList(NetWorkCallBack<HotBean> callback) {
        iHttp.get(Urls.HOT, null, callback);
    }
}
