package com.rookie.bilibiliservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.rookie.bilibilidao.dao")
public class BilibiliServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BilibiliServiceApplication.class, args);
    }

}
