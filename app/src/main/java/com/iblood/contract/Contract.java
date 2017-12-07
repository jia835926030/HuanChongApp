package com.iblood.contract;


import com.iblood.base.IBasePresenter;
import com.iblood.base.IBaseView;
import com.iblood.entity.HotBean;

public class Contract {

    public interface OnlineView extends IBaseView<Presenter> {
        void showHotData(HotBean hotBean);

    }

    public interface MangerView extends IBaseView<Presenter> {

    }

    public interface Presenter extends IBasePresenter {
    }
}
