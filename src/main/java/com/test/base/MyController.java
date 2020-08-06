package com.test.base;

import com.test.base.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Autowired
    private User user;

    @Value("${person.name}")
    private String name;

    @Value("${person.age}")
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String quick() {
        user.setAge("12");
        System.out.println(user.getAge());

        return "热部署完成" + name + age;
    }
}





