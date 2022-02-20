package com.quan.springboot06security.handler;

import com.alibaba.fastjson.JSON;
import com.quan.springboot06security.domain.ResponseResult;
import com.quan.springboot06security.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: AuthenticationEntryPointImpl
 * @Description: 自定义AuthenticationEntryPoint，处理认证异常
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/20 16:14
 */

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseResult responseResult = new ResponseResult(
                HttpStatus.UNAUTHORIZED.value(),
                "用户认证失败，请重新登录");
        String json = JSON.toJSONString(responseResult);
        WebUtils.renderString(response, json);
    }
}
