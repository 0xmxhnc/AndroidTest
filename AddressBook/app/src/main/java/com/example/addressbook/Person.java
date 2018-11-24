package com.example.addressbook;

/**
 * Created by asus on 2018/11/17.
 */

public class Person {
    private String name;
    private String phonenumber;
    private int imageId;

    public Person(String name, String phonenumber, int imageId) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenum() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        phonenumber = this.phonenumber;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
