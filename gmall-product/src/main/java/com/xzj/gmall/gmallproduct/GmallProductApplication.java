package com.xzj.gmall.gmallproduct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * 1 整合mybatis-plus
 *  1）导入依赖
 *  2）配置
 *      1.配置数据源：
 *          1）导入数据库的依赖
 *          2) 配置数据源
 *      2. 配置mybatis-plus
 *          1）@MapperScan("com.xzj.gmall.gmallproduct.dao") 扫描地址
 *          2）映射文件(*mapper.xml)文件 在application.yml中配置的mapper-location
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.xzj.gmall.gmallproduct.dao")
public class GmallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallProductApplication.class, args);
    }

}
