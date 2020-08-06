package com.test.base;

import com.test.base.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StartBase {

    public static void main(String[] args) {
        SpringApplication.run(StartBase.class);//运行启动类
    }

    /**
     * IOC 典型示例
     *
     * @return
     */

    @Bean(initMethod = "init", destroyMethod = "dis")
    public User getUser() {
        return new User("杨胖", "58");
    }


}
