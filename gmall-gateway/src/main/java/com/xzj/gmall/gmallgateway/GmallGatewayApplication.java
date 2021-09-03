package com.xzj.gmall.gmallgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/8/15 10:55
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class GmallGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GmallGatewayApplication.class,args);
    }
}
