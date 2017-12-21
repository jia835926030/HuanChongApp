package com.iblood.ui.online;

import java.util.List;

/**
 * Created by dell on 2017/12/21.
 */

public class PetTypeVO {
    private int id;
    private String typeCode;// 类型code
    private String typeName;// 类型名称
    private String typeIndex;// 数据索引
    private String createTime;// 创建时间
    private int isUse; // 是否启用
    private String parentTypeCode;// 父分类code
    private String parentTypeName;// 父分类名�??
    private String usersId;// 寄养师id
    private String petPrice;// 宠物价格
    private int isRe; // 是否热门
    private List<String> typeCodes;// 多类�??

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public int getIsRe() {
        return isRe;
    }

    public void setIsRe(int isRe) {
        this.isRe = isRe;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeIndex() {
        return typeIndex;
    }

    public void setTypeIndex(String typeIndex) {
        this.typeIndex = typeIndex;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getIsUse() {
        return isUse;
    }

    public void setIsUse(int isUse) {
        this.isUse = isUse;
    }

    public List<String> getTypeCodes() {
        return typeCodes;
    }

    public void setTypeCodes(List<String> typeCodes) {
        this.typeCodes = typeCodes;
    }

    public String getParentTypeCode() {
        return parentTypeCode;
    }

    public void setParentTypeCode(String parentTypeCode) {
        this.parentTypeCode = parentTypeCode;
    }

    public String getParentTypeName() {
        return parentTypeName;
    }

    public void setParentTypeName(String parentTypeName) {
        this.parentTypeName = parentTypeName;
    }

    public String getUsersId() {
        return usersId;
    }

    public void setUsersId(String usersId) {
        this.usersId = usersId;
    }

    public String getPetPrice() {
        return petPrice;
    }

    public void setPetPrice(String petPrice) {
        this.petPrice = petPrice;
    }

}