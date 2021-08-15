package com.xzj.gmall.gmallmember;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 1 使用Feign调用其他工程
 *  1）引入open-feign
 *  2）编写一个接口 告诉SpringCloude这个接口需要远程调用
 *      注解：在接口上使用@FeignClient（name="application.name"）
 *  3）启动远程调用
 *      注解：在启动类上添加@EnableFeignClients("com.xzj.gmall.gmallmember.feign")
 */
@EnableDiscoveryClient
@EnableFeignClients("com.xzj.gmall.gmallmember.feign")
@SpringBootApplication
@MapperScan("com.xzj.gmall.gmallmember.dao")
public class GmallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallMemberApplication.class, args);
    }

}
