package com.test.spring;


import java.util.HashMap;
import java.util.HashSet;

public class Test {

    @org.junit.Test
    public void test() {
        User user = new User(12, "小李");
        User user2 = new User(13, "小李");
        HashSet set = new HashSet();
        set.add(user);
        set.add(user2);

        for (Object o : set) {
            System.out.println(o);
        }
    }

}
