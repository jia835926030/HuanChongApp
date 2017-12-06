package com.iblood.model.dataModel;

import com.iblood.base.IBaseHttp;
import com.iblood.utils.HttpFactory;
public interface BaseModel {
    public static IBaseHttp iHttp = HttpFactory.createOk();

}
