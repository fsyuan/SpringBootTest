package com.test.base.proxy;

import com.test.base.service.AdminService;
import com.test.base.service.serviceImpl.AdminServiceImpl;

/**
 * 静态代理 就是使用代理来执行方法，增强被代理类
 * 一个新的实现类做为代理对象，内部还是调用被代理对象的执行过程
 */
public class StaticProxy implements AdminService {

    private AdminService adminService = new AdminServiceImpl();

    @Override
    public void find() {
        System.out.println("增强");
        adminService.find();
    }

    @Override
    public String findAll() {
        return null;
    }

    @Override
    public void insert() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }
}
