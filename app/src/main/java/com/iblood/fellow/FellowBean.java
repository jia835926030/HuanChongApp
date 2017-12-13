package com.iblood.fellow;

/**
 * Created by asus on 2017/12/12.
 */

public class FellowBean {
    private int img;
    private String name;
    private String dizhi;
    private String jiage;
    private String juli;

    public FellowBean(int img, String name, String dizhi, String jiage, String juli) {
        this.img = img;
        this.name = name;
        this.dizhi = dizhi;
        this.jiage = jiage;
        this.juli = juli;
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

    public String getDizhi() {
        return dizhi;
    }

    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }

    public String getJiage() {
        return jiage;
    }

    public void setJiage(String jiage) {
        this.jiage = jiage;
    }

    public String getJuli() {
        return juli;
    }

    public void setJuli(String juli) {
        this.juli = juli;
    }
}
