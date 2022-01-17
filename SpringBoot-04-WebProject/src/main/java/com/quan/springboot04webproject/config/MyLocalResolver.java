package com.quan.springboot04webproject.config;


import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @ClassName: MyLocalResolver
 * @Description: 自定义国际化解析器
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/17 15:50
 */


public class MyLocalResolver implements LocaleResolver {
    // 解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 获取请求中的语言参数
        String language = request.getParameter("l");

        // 默认
        Locale locale = Locale.getDefault();
        // 如果没有就是用默认的
        if (language != null && language.length() > 0) {
            // 字符串分割 zh_CN
            String[] s = language.split("_");
            // 国家 + 地区
            locale = new Locale(s[0], s[1]);
        }


        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
