package com.test.base.service.serviceImpl;

import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements com.test.base.service.AdminService {
    @Override
    public void find() {
        System.out.println("查询");
    }

    @Override
    public String findAll() {
        int i = 1 / 0;
        return "查询完毕";
    }

    @Override
    public void insert() {
        System.out.println("插入");

    }

    @Override
    public void delete() {
        System.out.println("删除");

    }

    @Override
    public void update() {
        System.out.println("更新");

    }
}
