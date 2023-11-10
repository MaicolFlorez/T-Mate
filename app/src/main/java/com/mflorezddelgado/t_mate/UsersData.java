package com.mflorezddelgado.t_mate;

public class UsersData {

    private String email;
    private String name;
    private String lastname;
    private int age;
    private String address;
    private float weight;
    private float height;

    public UsersData(String email, String name, String lastname, int age, String address, float weight, float height) {
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.address = address;
        this.weight = weight;
        this.height = height;
    }

    public UsersData() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
