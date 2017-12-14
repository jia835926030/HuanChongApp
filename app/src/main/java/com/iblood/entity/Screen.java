package com.iblood.entity;

import java.util.List;

/**
 * Created by 特雷西麦克格蕾蒂 on 2017/12/13.
 */

public class Screen {

    /**
     * ret : true
     * desc : [{"score":3.6667,"address":"北京市昌平区沙河沙阳路18号北京科技职业学院","coordX":"40.11765","userImage":"http://q.qlogo.cn/qqapp/100371282/290BB8E0BEC8DF5989060A6947C3E75D/40","coordY":"116.250639","distance":129,"price":20,"orderCount":53,"usersId":"536e2c7b99204bbb81ad8fa7e6b2860f","family":"小街爆的家"},{"score":3.5,"address":"四平市 北京市昌平区沙河","coordX":"40.134235","userImage":"/d80488022f1e4278a3149f54beeac02a/IMG_20160509_140258.jpg","coordY":"116.280098","distance":3467,"price":10,"orderCount":28,"usersId":"d80488022f1e4278a3149f54beeac02a","family":"李丽丽了"}]
     */

    private boolean ret;
    private List<DescBean> desc;

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public List<DescBean> getDesc() {
        return desc;
    }

    public void setDesc(List<DescBean> desc) {
        this.desc = desc;
    }

    public static class DescBean {
        /**
         * score : 3.6667
         * address : 北京市昌平区沙河沙阳路18号北京科技职业学院
         * coordX : 40.11765
         * userImage : http://q.qlogo.cn/qqapp/100371282/290BB8E0BEC8DF5989060A6947C3E75D/40
         * coordY : 116.250639
         * distance : 129
         * price : 20.0
         * orderCount : 53
         * usersId : 536e2c7b99204bbb81ad8fa7e6b2860f
         * family : 小街爆的家
         */

        private double score;
        private String address;
        private String coordX;
        private String userImage;
        private String coordY;
        private int distance;
        private double price;
        private int orderCount;
        private String usersId;
        private String family;

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCoordX() {
            return coordX;
        }

        public void setCoordX(String coordX) {
            this.coordX = coordX;
        }

        public String getUserImage() {
            return userImage;
        }

        public void setUserImage(String userImage) {
            this.userImage = userImage;
        }

        public String getCoordY() {
            return coordY;
        }

        public void setCoordY(String coordY) {
            this.coordY = coordY;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getOrderCount() {
            return orderCount;
        }

        public void setOrderCount(int orderCount) {
            this.orderCount = orderCount;
        }

        public String getUsersId() {
            return usersId;
        }

        public void setUsersId(String usersId) {
            this.usersId = usersId;
        }

        public String getFamily() {
            return family;
        }

        public void setFamily(String family) {
            this.family = family;
        }
    }
}
