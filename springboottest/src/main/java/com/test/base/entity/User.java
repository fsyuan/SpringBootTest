package com.test.base.entity;

import org.springframework.stereotype.Component;

/**
 * 直接创建bean
 */
//@Component
public class User {
    private String name;
    private String age;

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void init() {
        System.out.println("初始化");
    }

    public void dis() {
        System.out.println("销毁");
    }
}
