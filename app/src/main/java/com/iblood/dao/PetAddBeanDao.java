package com.iblood.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.iblood.entity.PetAddBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PET_ADD_BEAN".
*/
public class PetAddBeanDao extends AbstractDao<PetAddBean, Long> {

    public static final String TABLENAME = "PET_ADD_BEAN";

    /**
     * Properties of entity PetAddBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Petimgurl = new Property(1, String.class, "petimgurl", false, "PETIMGURL");
        public final static Property Petname = new Property(2, String.class, "petname", false, "PETNAME");
        public final static Property Pettype = new Property(3, String.class, "pettype", false, "PETTYPE");
        public final static Property Petsterilization = new Property(4, String.class, "petsterilization", false, "PETSTERILIZATION");
        public final static Property Petbirth = new Property(5, String.class, "petbirth", false, "PETBIRTH");
        public final static Property Petweight = new Property(6, String.class, "petweight", false, "PETWEIGHT");
        public final static Property Condition = new Property(7, String.class, "condition", false, "CONDITION");
        public final static Property Petprofile = new Property(8, String.class, "petprofile", false, "PETPROFILE");
    }


    public PetAddBeanDao(DaoConfig config) {
        super(config);
    }
    
    public PetAddBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PET_ADD_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"PETIMGURL\" TEXT," + // 1: petimgurl
                "\"PETNAME\" TEXT," + // 2: petname
                "\"PETTYPE\" TEXT," + // 3: pettype
                "\"PETSTERILIZATION\" TEXT," + // 4: petsterilization
                "\"PETBIRTH\" TEXT," + // 5: petbirth
                "\"PETWEIGHT\" TEXT," + // 6: petweight
                "\"CONDITION\" TEXT," + // 7: condition
                "\"PETPROFILE\" TEXT);"); // 8: petprofile
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PET_ADD_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, PetAddBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String petimgurl = entity.getPetimgurl();
        if (petimgurl != null) {
            stmt.bindString(2, petimgurl);
        }
 
        String petname = entity.getPetname();
        if (petname != null) {
            stmt.bindString(3, petname);
        }
 
        String pettype = entity.getPettype();
        if (pettype != null) {
            stmt.bindString(4, pettype);
        }
 
        String petsterilization = entity.getPetsterilization();
        if (petsterilization != null) {
            stmt.bindString(5, petsterilization);
        }
 
        String petbirth = entity.getPetbirth();
        if (petbirth != null) {
            stmt.bindString(6, petbirth);
        }
 
        String petweight = entity.getPetweight();
        if (petweight != null) {
            stmt.bindString(7, petweight);
        }
 
        String condition = entity.getCondition();
        if (condition != null) {
            stmt.bindString(8, condition);
        }
 
        String petprofile = entity.getPetprofile();
        if (petprofile != null) {
            stmt.bindString(9, petprofile);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, PetAddBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String petimgurl = entity.getPetimgurl();
        if (petimgurl != null) {
            stmt.bindString(2, petimgurl);
        }
 
        String petname = entity.getPetname();
        if (petname != null) {
            stmt.bindString(3, petname);
        }
 
        String pettype = entity.getPettype();
        if (pettype != null) {
            stmt.bindString(4, pettype);
        }
 
        String petsterilization = entity.getPetsterilization();
        if (petsterilization != null) {
            stmt.bindString(5, petsterilization);
        }
 
        String petbirth = entity.getPetbirth();
        if (petbirth != null) {
            stmt.bindString(6, petbirth);
        }
 
        String petweight = entity.getPetweight();
        if (petweight != null) {
            stmt.bindString(7, petweight);
        }
 
        String condition = entity.getCondition();
        if (condition != null) {
            stmt.bindString(8, condition);
        }
 
        String petprofile = entity.getPetprofile();
        if (petprofile != null) {
            stmt.bindString(9, petprofile);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public PetAddBean readEntity(Cursor cursor, int offset) {
        PetAddBean entity = new PetAddBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // petimgurl
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // petname
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // pettype
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // petsterilization
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // petbirth
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // petweight
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // condition
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8) // petprofile
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, PetAddBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPetimgurl(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPetname(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPettype(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPetsterilization(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setPetbirth(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setPetweight(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setCondition(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setPetprofile(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(PetAddBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(PetAddBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(PetAddBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
