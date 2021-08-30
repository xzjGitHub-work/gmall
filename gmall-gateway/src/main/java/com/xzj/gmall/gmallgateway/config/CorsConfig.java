package com.xzj.gmall.gmallgateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @Description: 跨域
 * @Author: xzj
 * @CreateDate: 2021/8/30 16:32
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter getCorsWebFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
        //请求来源
        configuration.addAllowedOrigin("*");
        //请求头
        configuration.addAllowedHeader("*");
        //请求方式
        configuration.addAllowedMethod("*");
        //是否允许伊俄代cookie跨域
        configuration.setAllowCredentials(true);
        source.registerCorsConfiguration("/**", configuration);
        return new CorsWebFilter(source);
    }

}
