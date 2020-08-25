package com.test;

import com.test.base.entity.User;
import com.test.base.entity.UserFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
public class StartBase {

    public static void main(String[] args) {
        SpringApplication.run(StartBase.class);//运行启动类
    }

    /**
     * IOC 典型示例
     * BEAN创建单例
     *
     * @return
     */

//    @Bean(initMethod = "init", destroyMethod = "dis")
    public User getUser() {
        return new User("杨胖", "58");

    }

    /**
     * 静态工厂创建
     *
     * @return
     */
//    @Bean
    public User getUserFromFactory() {
        return UserFactory.createUser();
    }

}
