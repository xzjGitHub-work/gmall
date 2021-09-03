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
 *
 *  2 逻辑删除
 *   1）配置全局的逻辑删除规则（省略）
 *   2）配置逻辑删除的组件Bean
 *   3）给Bean加上逻辑删除的注解@TableLogic
 *
 *  3 JSR 303
 *      1) 接口使用@Vaild与bean中天及@NotBlank...配置使用\
 *      2) 在接口上添加BindingResult bind 可以获取检验结构
 *      常用注解：@Pattern(regexp=正则) @URL @Min
 *  4 统一异常处理
 * @controllerAdvice
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.xzj.gmall.gmallproduct.dao")
public class GmallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallProductApplication.class, args);
    }

}
