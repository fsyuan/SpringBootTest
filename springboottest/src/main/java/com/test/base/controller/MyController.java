package com.test.base.controller;

import com.test.base.entity.User;
import com.test.base.entity.UserFactory;
import com.test.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {


//    @Autowired
//    private User user;

    /**
     * 此时 user 不托管，直接托管userfactory
     */
    @Autowired
    private UserFactory userFactory;

    /**
     * 注入接口，自动返回接口的实现类，
     */
    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    @ResponseBody
    public String quick() {
        User user = userFactory.createUser();
        String age = user.getAge();
        String name = user.getName();
        System.out.println("123");
        userService.getName();
        System.out.println("123");
        System.out.println("123123");
        return "热部署完成" + name + age;
    }
}





