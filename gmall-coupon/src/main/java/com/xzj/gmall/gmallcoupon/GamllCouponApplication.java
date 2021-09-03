package com.xzj.gmall.gmallcoupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 1 如何使用nacos做配置中心
 *      1） 引入依赖
 *           <dependency>
 * 		    	<groupId>com.alibaba.cloud</groupId>
 * 		    	<artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
 * 		    </dependency>
 * 		2）创建bootstrap.properties 在其中添加数据配置
 * 			spring.application.name=nacos-config-example
 * 		    spring.cloud.nacos.config.server-addr=127.0.0.1:8848
 * 		3） 需要给配置中心默认添加一个数据集（DATAID）(application.name).properties
 * 	    4) 需要添加数据直接在	(application.name).properties添加即可
 * 	    5）动态刷新 并获取数据 添加数据@RefreshScope @Value
 * 	       如果本地与配置中心有同名数据名 优先使用配置中心的数据
 * 2 细节
 *      1） 命名空间
 *          默认：a.public 做数据隔离的，默认新增的所有配置都在public空间
 *               b.这个可以结合profile使用 不同环境使用不同的命名空间
 *               c.一个微服务一个配置
 *
 *      2）配置集：所有配置的集合
 *      3）配置集ID：类似文件名
 *          data ID：
 *      4）配置组Group
 *          不同时区 使用不同的group
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.xzj.gmall.gmallcoupon.dao")
public class GamllCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GamllCouponApplication.class, args);
    }

}
