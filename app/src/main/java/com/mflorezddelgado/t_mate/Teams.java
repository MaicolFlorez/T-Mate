package com.mflorezddelgado.t_mate;

import android.graphics.drawable.Drawable;

public class Teams {
    public int image;
    public String name;
    public String desc;
    public String member;

    public Teams(int image, String name, String desc, String member) {
        this.image = image;
        this.name = name;
        this.desc = desc;
        this.member = member;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int color) {
        this.image = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }
}
