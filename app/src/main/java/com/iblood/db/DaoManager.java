package com.iblood.db;

import android.content.Context;

import com.iblood.dao.DaoMaster;
import com.iblood.dao.DaoSession;
import com.iblood.dao.PetAddBeanDao;

/**
 * Created by 刘贵河 on 2017/12/12.
 *   刘贵河
 */

public class DaoManager {
    private static DaoManager daoManager;
    private DaoMaster.DevOpenHelper helper;
    private static final String DB_NAME = "petinformation.db";

    private DaoManager(Context context) {
        helper = new DaoMaster.DevOpenHelper(context, DB_NAME);
    }

    public static synchronized DaoManager getInstence(Context context) {
        if (daoManager == null)
            daoManager = new DaoManager(context);
        return daoManager;
    }

    public PetAddBeanDao getDao() {
        DaoMaster master = new DaoMaster(helper.getWritableDatabase());
        DaoSession daoSession = master.newSession();
        PetAddBeanDao petAddBeanDao = daoSession.getPetAddBeanDao();
        return petAddBeanDao;
    }



}
