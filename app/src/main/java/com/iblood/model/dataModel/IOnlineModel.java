package com.iblood.model.dataModel;

import com.iblood.entity.HotBean;
import com.iblood.model.net.NetWorkCallBack;



public interface IOnlineModel extends BaseModel {

    void loadHotList(NetWorkCallBack<HotBean> callback);

}
