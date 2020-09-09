package com.test.spring;

import com.test.base.proxy.CGLABProxy;
import com.test.base.proxy.JDKProxy;
import com.test.base.proxy.StaticProxy;
import com.test.base.service.AdminService;
import com.test.base.service.CGLIBService;
import com.test.base.service.serviceImpl.AdminServiceImpl;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

public class AdminProxy {

    @Test
    //不是用代理
    public void test00() {
        AdminServiceImpl adminService = new AdminServiceImpl();
        adminService.find();

    }


    @Test
    //jdk代理
    public void test() {
        JDKProxy jdkProxy = new JDKProxy(new AdminServiceImpl());
        AdminService adminService = (AdminService) jdkProxy.geProxy();
        adminService.find();
    }

    @Test
    //静态代理
    public void test2() {
        StaticProxy staticProxy = new StaticProxy();
        staticProxy.find();
    }

    @Test
    //cglib代理,代理类
    public void test01() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CGLIBService.class);
        enhancer.setCallback(new CGLABProxy());
        CGLIBService cglibService = (CGLIBService) enhancer.create();
        cglibService.find();
    }


}
