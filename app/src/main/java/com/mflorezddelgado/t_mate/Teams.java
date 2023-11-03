package com.mflorezddelgado.t_mate;

public class Teams {
    public String color;
    public String name;
    public String desc;
    public String member;

    public Teams(String color, String name, String desc, String member) {
        this.color = color;
        this.name = name;
        this.desc = desc;
        this.member = member;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
