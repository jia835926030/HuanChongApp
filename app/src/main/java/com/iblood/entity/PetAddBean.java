package com.iblood.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 刘贵河 on 2017/12/12.
 * <p>
 *     添加宠物信息
 *     数据库
 */
@Entity
public class  PetAddBean {
    @Id(autoincrement = true)
    private Long id;
    @Property
    private String petimgurl;//头像
    @Property
    private String petname;//昵称
    @Property
    private String pettype;//类型
    @Property
    private String petsterilization;//绝育否
    @Property
    private String petbirth;//出生日期
    @Property
    private String petweight;//体重
    @Property
    private String condition;//免疫情况
    @Property
    private String petprofile;//宠物简介
    @Generated(hash = 2077858436)
    public PetAddBean(Long id, String petimgurl, String petname, String pettype,
            String petsterilization, String petbirth, String petweight,
            String condition, String petprofile) {
        this.id = id;
        this.petimgurl = petimgurl;
        this.petname = petname;
        this.pettype = pettype;
        this.petsterilization = petsterilization;
        this.petbirth = petbirth;
        this.petweight = petweight;
        this.condition = condition;
        this.petprofile = petprofile;
    }
    @Generated(hash = 2052849108)
    public PetAddBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPetimgurl() {
        return this.petimgurl;
    }
    public void setPetimgurl(String petimgurl) {
        this.petimgurl = petimgurl;
    }
    public String getPetname() {
        return this.petname;
    }
    public void setPetname(String petname) {
        this.petname = petname;
    }
    public String getPettype() {
        return this.pettype;
    }
    public void setPettype(String pettype) {
        this.pettype = pettype;
    }
    public String getPetsterilization() {
        return this.petsterilization;
    }
    public void setPetsterilization(String petsterilization) {
        this.petsterilization = petsterilization;
    }
    public String getPetbirth() {
        return this.petbirth;
    }
    public void setPetbirth(String petbirth) {
        this.petbirth = petbirth;
    }
    public String getPetweight() {
        return this.petweight;
    }
    public void setPetweight(String petweight) {
        this.petweight = petweight;
    }
    public String getCondition() {
        return this.condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }
    public String getPetprofile() {
        return this.petprofile;
    }
    public void setPetprofile(String petprofile) {
        this.petprofile = petprofile;
    }

}
