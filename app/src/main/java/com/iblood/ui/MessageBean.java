package com.iblood.ui;

/**
 * Created by asus on 2017/12/11.
 * 消息列表listview实体类
 */

public class MessageBean {
    private String name;
    private int img;
    private String text;
    private String shijian;

    public MessageBean(String name, int img, String text, String shijian) {
        this.name = name;
        this.img = img;
        this.text = text;
        this.shijian = shijian;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getShijian() {
        return shijian;
    }

    public void setShijian(String shijian) {
        this.shijian = shijian;
    }
}
