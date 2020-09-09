package com.thy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.thy.dao")
public class StarMybaties {

    public static void main(String[] args) {
        SpringApplication.run(StarMybaties.class);//运行启动类
    }


}
