package com.iblood.fellow;

import java.util.List;

/**
 * Created by asus on 2017/12/12.
 */

public class FellowBean {

    /**
     * ret : true
     * desc : {"fosterGrade":3.1667,"fosterInfo":{"position":0,"birthday":795628800000,"userImage":"/a87ff679a2f3e71d9181a67b7542122c/IMG_20160416_194016.png","state":1,"openEndTime":"2016-06-10 00:00:00.0","openBeginTime":"2016-04-15 00:00:00.0","id":0,"family":"88888","userId":"a87ff679a2f3e71d9181a67b7542122c","userName":"呀啊","userPhone":15910721339,"qq":5716185877,"isUse":0,"coordY":"116.249706","intro":"大型宠物寄养乐园有点像升级版的宠物店，这里的活动空间大，宠物们可以不用住在小小的笼子里，它们有自己的活动空间，而且不会与其他狗狗接触，生活环境很安全。可即便如此，大型宠物寄养乐园可能还是无法一对一照顾到每只狗的所有需求，主人最好考虑清楚以后再选择如何寄养或是否寄养等。","coordX":"40.116585","address":"北京市昌平区啥","userSex":1,"realName":"于洪乾","wechat":"yhq1913_wechat"},"fosterImages":[],"fosterCommentCount":6,"fosterOtherServices":[{"id":0,"unit":"公里","petTypeName":"大型犬","petTypeCode":"2","isUse":0,"serviceCode":"2","servicePrice":"1.00","serviceName":"奔跑","isStandard":0}],"fosterServices":[{"typeName":"猫","id":0,"parentTypeCode":"","isUse":0,"isRe":0,"typeCode":"2","petPrice":"2.00","petTypeImage":"cat.png","parentTypeName":""},{"typeName":"小宠","id":0,"parentTypeCode":"","isUse":0,"isRe":0,"typeCode":"3","petPrice":"2.00","parentTypeName":""},{"typeName":"狗","id":0,"parentTypeCode":"","isUse":0,"isRe":1,"typeCode":"1","petPrice":"2.00","parentTypeName":""}]}
     */

    private boolean ret;
    private DescBean desc;

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public DescBean getDesc() {
        return desc;
    }

    public void setDesc(DescBean desc) {
        this.desc = desc;
    }

    public static class DescBean {
        /**
         * fosterGrade : 3.1667
         * fosterInfo : {"position":0,"birthday":795628800000,"userImage":"/a87ff679a2f3e71d9181a67b7542122c/IMG_20160416_194016.png","state":1,"openEndTime":"2016-06-10 00:00:00.0","openBeginTime":"2016-04-15 00:00:00.0","id":0,"family":"88888","userId":"a87ff679a2f3e71d9181a67b7542122c","userName":"呀啊","userPhone":15910721339,"qq":5716185877,"isUse":0,"coordY":"116.249706","intro":"大型宠物寄养乐园有点像升级版的宠物店，这里的活动空间大，宠物们可以不用住在小小的笼子里，它们有自己的活动空间，而且不会与其他狗狗接触，生活环境很安全。可即便如此，大型宠物寄养乐园可能还是无法一对一照顾到每只狗的所有需求，主人最好考虑清楚以后再选择如何寄养或是否寄养等。","coordX":"40.116585","address":"北京市昌平区啥","userSex":1,"realName":"于洪乾","wechat":"yhq1913_wechat"}
         * fosterImages : []
         * fosterCommentCount : 6
         * fosterOtherServices : [{"id":0,"unit":"公里","petTypeName":"大型犬","petTypeCode":"2","isUse":0,"serviceCode":"2","servicePrice":"1.00","serviceName":"奔跑","isStandard":0}]
         * fosterServices : [{"typeName":"猫","id":0,"parentTypeCode":"","isUse":0,"isRe":0,"typeCode":"2","petPrice":"2.00","petTypeImage":"cat.png","parentTypeName":""},{"typeName":"小宠","id":0,"parentTypeCode":"","isUse":0,"isRe":0,"typeCode":"3","petPrice":"2.00","parentTypeName":""},{"typeName":"狗","id":0,"parentTypeCode":"","isUse":0,"isRe":1,"typeCode":"1","petPrice":"2.00","parentTypeName":""}]
         */

        private double fosterGrade;
        private FosterInfoBean fosterInfo;
        private int fosterCommentCount;
        private List<?> fosterImages;
        private List<FosterOtherServicesBean> fosterOtherServices;
        private List<FosterServicesBean> fosterServices;

        public double getFosterGrade() {
            return fosterGrade;
        }

        public void setFosterGrade(double fosterGrade) {
            this.fosterGrade = fosterGrade;
        }

        public FosterInfoBean getFosterInfo() {
            return fosterInfo;
        }

        public void setFosterInfo(FosterInfoBean fosterInfo) {
            this.fosterInfo = fosterInfo;
        }

        public int getFosterCommentCount() {
            return fosterCommentCount;
        }

        public void setFosterCommentCount(int fosterCommentCount) {
            this.fosterCommentCount = fosterCommentCount;
        }

        public List<?> getFosterImages() {
            return fosterImages;
        }

        public void setFosterImages(List<?> fosterImages) {
            this.fosterImages = fosterImages;
        }

        public List<FosterOtherServicesBean> getFosterOtherServices() {
            return fosterOtherServices;
        }

        public void setFosterOtherServices(List<FosterOtherServicesBean> fosterOtherServices) {
            this.fosterOtherServices = fosterOtherServices;
        }

        public List<FosterServicesBean> getFosterServices() {
            return fosterServices;
        }

        public void setFosterServices(List<FosterServicesBean> fosterServices) {
            this.fosterServices = fosterServices;
        }

        public static class FosterInfoBean {
            /**
             * position : 0
             * birthday : 795628800000
             * userImage : /a87ff679a2f3e71d9181a67b7542122c/IMG_20160416_194016.png
             * state : 1
             * openEndTime : 2016-06-10 00:00:00.0
             * openBeginTime : 2016-04-15 00:00:00.0
             * id : 0
             * family : 88888
             * userId : a87ff679a2f3e71d9181a67b7542122c
             * userName : 呀啊
             * userPhone : 15910721339
             * qq : 5716185877
             * isUse : 0
             * coordY : 116.249706
             * intro : 大型宠物寄养乐园有点像升级版的宠物店，这里的活动空间大，宠物们可以不用住在小小的笼子里，它们有自己的活动空间，而且不会与其他狗狗接触，生活环境很安全。可即便如此，大型宠物寄养乐园可能还是无法一对一照顾到每只狗的所有需求，主人最好考虑清楚以后再选择如何寄养或是否寄养等。
             * coordX : 40.116585
             * address : 北京市昌平区啥
             * userSex : 1
             * realName : 于洪乾
             * wechat : yhq1913_wechat
             */

            private int position;
            private long birthday;
            private String userImage;
            private int state;
            private String openEndTime;
            private String openBeginTime;
            private int id;
            private String family;
            private String userId;
            private String userName;
            private long userPhone;
            private long qq;
            private int isUse;
            private String coordY;
            private String intro;
            private String coordX;
            private String address;
            private int userSex;
            private String realName;
            private String wechat;

            public int getPosition() {
                return position;
            }

            public void setPosition(int position) {
                this.position = position;
            }

            public long getBirthday() {
                return birthday;
            }

            public void setBirthday(long birthday) {
                this.birthday = birthday;
            }

            public String getUserImage() {
                return userImage;
            }

            public void setUserImage(String userImage) {
                this.userImage = userImage;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public String getOpenEndTime() {
                return openEndTime;
            }

            public void setOpenEndTime(String openEndTime) {
                this.openEndTime = openEndTime;
            }

            public String getOpenBeginTime() {
                return openBeginTime;
            }

            public void setOpenBeginTime(String openBeginTime) {
                this.openBeginTime = openBeginTime;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getFamily() {
                return family;
            }

            public void setFamily(String family) {
                this.family = family;
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

            public long getUserPhone() {
                return userPhone;
            }

            public void setUserPhone(long userPhone) {
                this.userPhone = userPhone;
            }

            public long getQq() {
                return qq;
            }

            public void setQq(long qq) {
                this.qq = qq;
            }

            public int getIsUse() {
                return isUse;
            }

            public void setIsUse(int isUse) {
                this.isUse = isUse;
            }

            public String getCoordY() {
                return coordY;
            }

            public void setCoordY(String coordY) {
                this.coordY = coordY;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getCoordX() {
                return coordX;
            }

            public void setCoordX(String coordX) {
                this.coordX = coordX;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public int getUserSex() {
                return userSex;
            }

            public void setUserSex(int userSex) {
                this.userSex = userSex;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }

            public String getWechat() {
                return wechat;
            }

            public void setWechat(String wechat) {
                this.wechat = wechat;
            }
        }

        public static class FosterOtherServicesBean {
            /**
             * id : 0
             * unit : 公里
             * petTypeName : 大型犬
             * petTypeCode : 2
             * isUse : 0
             * serviceCode : 2
             * servicePrice : 1.00
             * serviceName : 奔跑
             * isStandard : 0
             */

            private int id;
            private String unit;
            private String petTypeName;
            private String petTypeCode;
            private int isUse;
            private String serviceCode;
            private String servicePrice;
            private String serviceName;
            private int isStandard;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public String getPetTypeName() {
                return petTypeName;
            }

            public void setPetTypeName(String petTypeName) {
                this.petTypeName = petTypeName;
            }

            public String getPetTypeCode() {
                return petTypeCode;
            }

            public void setPetTypeCode(String petTypeCode) {
                this.petTypeCode = petTypeCode;
            }

            public int getIsUse() {
                return isUse;
            }

            public void setIsUse(int isUse) {
                this.isUse = isUse;
            }

            public String getServiceCode() {
                return serviceCode;
            }

            public void setServiceCode(String serviceCode) {
                this.serviceCode = serviceCode;
            }

            public String getServicePrice() {
                return servicePrice;
            }

            public void setServicePrice(String servicePrice) {
                this.servicePrice = servicePrice;
            }

            public String getServiceName() {
                return serviceName;
            }

            public void setServiceName(String serviceName) {
                this.serviceName = serviceName;
            }

            public int getIsStandard() {
                return isStandard;
            }

            public void setIsStandard(int isStandard) {
                this.isStandard = isStandard;
            }
        }

        public static class FosterServicesBean {
            /**
             * typeName : 猫
             * id : 0
             * parentTypeCode :
             * isUse : 0
             * isRe : 0
             * typeCode : 2
             * petPrice : 2.00
             * petTypeImage : cat.png
             * parentTypeName :
             */

            private String typeName;
            private int id;
            private String parentTypeCode;
            private int isUse;
            private int isRe;
            private String typeCode;
            private String petPrice;
            private String petTypeImage;
            private String parentTypeName;

            public String getTypeName() {
                return typeName;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getParentTypeCode() {
                return parentTypeCode;
            }

            public void setParentTypeCode(String parentTypeCode) {
                this.parentTypeCode = parentTypeCode;
            }

            public int getIsUse() {
                return isUse;
            }

            public void setIsUse(int isUse) {
                this.isUse = isUse;
            }

            public int getIsRe() {
                return isRe;
            }

            public void setIsRe(int isRe) {
                this.isRe = isRe;
            }

            public String getTypeCode() {
                return typeCode;
            }

            public void setTypeCode(String typeCode) {
                this.typeCode = typeCode;
            }

            public String getPetPrice() {
                return petPrice;
            }

            public void setPetPrice(String petPrice) {
                this.petPrice = petPrice;
            }

            public String getPetTypeImage() {
                return petTypeImage;
            }

            public void setPetTypeImage(String petTypeImage) {
                this.petTypeImage = petTypeImage;
            }

            public String getParentTypeName() {
                return parentTypeName;
            }

            public void setParentTypeName(String parentTypeName) {
                this.parentTypeName = parentTypeName;
            }
        }
    }
}
