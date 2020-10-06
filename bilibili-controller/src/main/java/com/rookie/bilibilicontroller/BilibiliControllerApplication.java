package com.rookie.bilibilicontroller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.rookie.bilibilidao.dao","com.rookie.bilibilibean.entity"})
public class BilibiliControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BilibiliControllerApplication.class, args);
    }

}
