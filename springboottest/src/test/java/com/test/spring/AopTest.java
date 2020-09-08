package com.test.spring;

import org.junit.Test;
import org.springframework.aop.framework.AopProxy;

public class AopTest {

    @Test
    public void a() {

        switch ("c") {
            case "1":
                System.out.println("1");
                break;
            case "2":
                System.out.println("3");
                break;
            case "c":
                System.out.println("c");
                break;
            default:
                System.out.println("123");
        }
//        AopProxy
    }
}
