package com.test.base.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAdvice {


    @Pointcut("execution(* com.test.base.service..*Impl.*(..))")
    public void impl() {
    }

    @Before("impl()")
    public void befor() {
        System.out.println("Before");

    }

    @AfterReturning("impl()")
    public void afterR() {
        System.out.println("AfterReturning");
    }

    @Around("impl()")
    public Object around(ProceedingJoinPoint poj) throws Throwable {
        System.out.println("Around1");
        Object proceed = poj.proceed();
        System.out.println("Around2");
        return proceed;
    }

    @AfterThrowing("impl()")
    public void afterE() {
        System.out.println("AfterThrowing：异常时出现");
    }

    @After("impl()")
    public void after() {
        System.out.println("After:无论是否异常都出现");
    }
}
