package com.vue.web.ui.entity;

import lombok.Data;

/**
 * Created by Administrator on 2017/6/3.
 */
@Data
public class User {

    private String name;

    private Integer sex;

    private Integer age;

    private String birth;

    private String address;

    public User(String name, int sex, int age, String birth, String address) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.birth = birth;
        this.address = address;
    }

    public User() {
    }
}
