package com.xzj.gmall.gmallware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xzj.gmall.gmallware.dao")
public class GamllWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(GamllWareApplication.class, args);
    }

}
