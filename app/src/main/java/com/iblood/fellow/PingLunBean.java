package com.iblood.fellow;

import java.util.List;

/**
 * Created by asus on 2017/12/13.
 */

public class PingLunBean {

    /**
     * ret : true
     * desc : [{"petTypeDesc":"小型犬","createTime":"c","isUse":0,"userImage":"/0/IMG_20160408_220317.png","score":3,"orderCount":0,"id":0,"petDuration":6,"evaluatedCount":0,"description":"胡思安徽省丢分火速回复随时胡思个覅的结果胡椒粉第三个合肥市","userId":"4","userName":"王五"},{"createTime":1320737184000,"isUse":0,"userImage":"/0/IMG_20160408_220317.png","score":1,"orderCount":0,"id":0,"petDuration":7,"evaluatedCount":0,"description":"324热狗反而个非官方个地方官的","userId":"6","userName":"赵六"}]
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
         * petTypeDesc : 小型犬
         * createTime : c
         * isUse : 0
         * userImage : /0/IMG_20160408_220317.png
         * score : 3
         * orderCount : 0
         * id : 0
         * petDuration : 6
         * evaluatedCount : 0
         * description : 胡思安徽省丢分火速回复随时胡思个覅的结果胡椒粉第三个合肥市
         * userId : 4
         * userName : 王五
         */

        private String petTypeDesc;
        private String createTime;
        private int isUse;
        private String userImage;
        private int score;
        private int orderCount;
        private int id;
        private int petDuration;
        private int evaluatedCount;
        private String description;
        private String userId;
        private String userName;

        public String getPetTypeDesc() {
            return petTypeDesc;
        }

        public void setPetTypeDesc(String petTypeDesc) {
            this.petTypeDesc = petTypeDesc;
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

        public String getUserImage() {
            return userImage;
        }

        public void setUserImage(String userImage) {
            this.userImage = userImage;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getOrderCount() {
            return orderCount;
        }

        public void setOrderCount(int orderCount) {
            this.orderCount = orderCount;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPetDuration() {
            return petDuration;
        }

        public void setPetDuration(int petDuration) {
            this.petDuration = petDuration;
        }

        public int getEvaluatedCount() {
            return evaluatedCount;
        }

        public void setEvaluatedCount(int evaluatedCount) {
            this.evaluatedCount = evaluatedCount;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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
    }
}
