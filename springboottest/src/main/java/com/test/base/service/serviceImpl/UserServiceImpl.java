package com.test.base.service.serviceImpl;

import com.test.base.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserServiceImpl implements UserService {

    @Override
    public void getName() {
        System.out.println("哈哈哈");
    }
}
