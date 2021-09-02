package com.xzj.gmall.gmalllib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/9/2 17:28
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ApplicationLibStart {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationLibStart.class,args);
    }
}
