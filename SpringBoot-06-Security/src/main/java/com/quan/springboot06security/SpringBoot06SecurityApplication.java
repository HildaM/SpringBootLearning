package com.quan.springboot06security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.quan.springboot06security.mapper")
public class SpringBoot06SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot06SecurityApplication.class, args);
    }

}
