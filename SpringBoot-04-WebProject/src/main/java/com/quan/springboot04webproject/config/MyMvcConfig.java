package com.quan.springboot04webproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: MyMvcConfig
 * @Description: 自定义MVC配置类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/17 14:49
 */

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 设置视图控制器
        // Spring Boot中使用addViewController实现实现无业务逻辑跳转
        // https://blog.csdn.net/huangjhai/article/details/104203415
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");

        // 登录验证的视图解析器
        registry.addViewController("/dashboard").setViewName("dashboard");
    }

    // 将自定义的国际化组件注入到IOC中
    /*
    * 我们需要保证：在webmvc添加的国际化解析器是Spring中的一个bean元素
    * 而且，这个自定义的解析器要融合到原有的webmvc配置中
    * 所以需要在这里进行注册bean操作！！！
    * */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocalResolver();
    }

    // 实现拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 添加需要拦截的路径，excludePathPatterns 排除不需要拦截的路径
        // 此处本应排除静态资源的路径，不过不排除也没问题，不知道哪里更新了
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/", "/static/**", "/index.html", "/user/login");
    }
}
