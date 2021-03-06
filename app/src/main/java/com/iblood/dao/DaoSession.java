package com.iblood.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.iblood.entity.PetAddBean;

import com.iblood.dao.PetAddBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig petAddBeanDaoConfig;

    private final PetAddBeanDao petAddBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        petAddBeanDaoConfig = daoConfigMap.get(PetAddBeanDao.class).clone();
        petAddBeanDaoConfig.initIdentityScope(type);

        petAddBeanDao = new PetAddBeanDao(petAddBeanDaoConfig, this);

        registerDao(PetAddBean.class, petAddBeanDao);
    }
    
    public void clear() {
        petAddBeanDaoConfig.clearIdentityScope();
    }

    public PetAddBeanDao getPetAddBeanDao() {
        return petAddBeanDao;
    }

}
