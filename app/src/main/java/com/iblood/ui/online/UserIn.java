package com.iblood.ui.online;

/**
 * Created by dell on 2017/12/21.
 */

public class UserIn {
    private int id;
    private String userId = "";// 用户id
    private String userName = "";// 用户�??
    private String password = "";// 密码
    private long userPhone;// 手机�??
    private int position;// 用户身份
    private String address = "";// 用户地址
    private String identify = "";// 地图标识
    private String createTime = "";// 创建时间
    private String upStringTime = "";// 修改时间
    private long qq;// QQ
    private String realName = "";// 真实姓名
    private String family = "";// 寄养家庭
    private String identityCard = "";// 身份证号
    private String identityImage = "";// 身份证照�??
    private String lastRegisterTime = "";// �??后登录时�??
    private String userImage = "";// 用户图片
    private String businessLicense = "";// 营业执照
    private int userSex;// 用户年龄
    private String birthday = "";// 出生日期
    private String threeId = "";// 第三方登录标�??
    private int isUse;// 是否启用
    private String token = "";
    private String cityId = "";// 城市
    private String orderBy = "";// 排序字段
    private int beginIndex;// �??始第几条
    private int endIndex;// 结束第几�??
    private String petTypeCode = "";// 宠物类型
    private String coordX = "";// 横坐�??
    private String coordY = "";// 纵坐�??
    private int imageType;
    private String wechat = "";
    private int state;// 用户状�??
    private String intro = "";// �??�??

    public UserIn(int id, String userId, String userName, String password, long userPhone, int position, String address, String identify, String createTime, String upStringTime, long qq, String realName, String family, String identityCard, String identityImage, String lastRegisterTime, String userImage, String businessLicense, int userSex, String birthday, String threeId, int isUse, String token, String cityId, String orderBy, int beginIndex, int endIndex, String petTypeCode, String coordX, String coordY, int imageType, String wechat, int state, String intro) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userPhone = userPhone;
        this.position = position;
        this.address = address;
        this.identify = identify;
        this.createTime = createTime;
        this.upStringTime = upStringTime;
        this.qq = qq;
        this.realName = realName;
        this.family = family;
        this.identityCard = identityCard;
        this.identityImage = identityImage;
        this.lastRegisterTime = lastRegisterTime;
        this.userImage = userImage;
        this.businessLicense = businessLicense;
        this.userSex = userSex;
        this.birthday = birthday;
        this.threeId = threeId;
        this.isUse = isUse;
        this.token = token;
        this.cityId = cityId;
        this.orderBy = orderBy;
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
        this.petTypeCode = petTypeCode;
        this.coordX = coordX;
        this.coordY = coordY;
        this.imageType = imageType;
        this.wechat = wechat;
        this.state = state;
        this.intro = intro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpStringTime() {
        return upStringTime;
    }

    public void setUpStringTime(String upStringTime) {
        this.upStringTime = upStringTime;
    }

    public long getQq() {
        return qq;
    }

    public void setQq(long qq) {
        this.qq = qq;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getIdentityImage() {
        return identityImage;
    }

    public void setIdentityImage(String identityImage) {
        this.identityImage = identityImage;
    }

    public String getLastRegisterTime() {
        return lastRegisterTime;
    }

    public void setLastRegisterTime(String lastRegisterTime) {
        this.lastRegisterTime = lastRegisterTime;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getThreeId() {
        return threeId;
    }

    public void setThreeId(String threeId) {
        this.threeId = threeId;
    }

    public int getIsUse() {
        return isUse;
    }

    public void setIsUse(int isUse) {
        this.isUse = isUse;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public int getBeginIndex() {
        return beginIndex;
    }

    public void setBeginIndex(int beginIndex) {
        this.beginIndex = beginIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public String getPetTypeCode() {
        return petTypeCode;
    }

    public void setPetTypeCode(String petTypeCode) {
        this.petTypeCode = petTypeCode;
    }

    public String getCoordX() {
        return coordX;
    }

    public void setCoordX(String coordX) {
        this.coordX = coordX;
    }

    public String getCoordY() {
        return coordY;
    }

    public void setCoordY(String coordY) {
        this.coordY = coordY;
    }

    public int getImageType() {
        return imageType;
    }

    public void setImageType(int imageType) {
        this.imageType = imageType;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public UserIn() {
    }
}
