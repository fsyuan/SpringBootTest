package com.thy.springBootStart;

import com.thy.springBootStart.entry.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan
public class StartBase {

    public static void main(String[] args) {
        SpringApplication.run(StartBase.class);
    }

}
