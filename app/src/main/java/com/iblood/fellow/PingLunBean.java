package com.iblood.fellow;

/**
 * Created by asus on 2017/12/13.
 */

public class PingLunBean {
    private int img;
    private String name;
    private String text;
    private String zhonglei;
    private String shiian;

    public PingLunBean(int img, String name, String text, String zhonglei, String shiian) {
        this.img = img;
        this.name = name;
        this.text = text;
        this.zhonglei = zhonglei;
        this.shiian = shiian;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getZhonglei() {
        return zhonglei;
    }

    public void setZhonglei(String zhonglei) {
        this.zhonglei = zhonglei;
    }

    public String getShiian() {
        return shiian;
    }

    public void setShiian(String shiian) {
        this.shiian = shiian;
    }
}
