package com.test.base.proxy;

import com.test.base.service.AdminService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理实现过程
 * 要求必须是接口
 */
public class JDKProxy implements InvocationHandler {

    private AdminService adminService;

    public JDKProxy(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("增强");
        Object invoke = method.invoke(adminService, args);
        return invoke;
    }
}
