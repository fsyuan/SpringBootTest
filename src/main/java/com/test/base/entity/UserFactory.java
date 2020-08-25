package com.test.base.entity;


import org.springframework.stereotype.Component;

@Component // 托管到容器
public class UserFactory {
    /**
     * 静态工厂创建Bean
     *
     * @return
     */
    public static User createUser() {
        System.out.println("创建User对象，通过工厂");
        return new User("肥四", "工厂");
    }
}
