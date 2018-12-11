package com.example.addressbook;

/**
 * Created by asus on 2018/11/17.
 * 自定义Person类
 */

public class Person {
    //定义联系人姓名
    private String name;
    //定义联系人电话号码
    private String phonenumber;
    //定义联系人头像Id
    private int imageId;

    //有参构造
    public Person(String name, String phonenumber, int imageId) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.imageId = imageId;
    }

    //编写对应Get、Set方法
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
