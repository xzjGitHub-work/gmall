package com.xzj.gmall.gmallcoupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xzj.gmall.gmallcoupon.dao")
public class GamllCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GamllCouponApplication.class, args);
    }

}
