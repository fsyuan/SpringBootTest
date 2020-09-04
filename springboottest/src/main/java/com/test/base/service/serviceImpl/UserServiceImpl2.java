package com.test.base.service.serviceImpl;

import com.test.base.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component 不允许托管
public class UserServiceImpl2 implements UserService {
    @Override
    public void getName() {
        System.out.println("嘻嘻嘻");
    }
}
