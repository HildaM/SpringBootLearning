package com.quan.springboot06security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName: SecurityConfig
 * @Description: 安全框架配置类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/16 17:58
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // 注入容器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
