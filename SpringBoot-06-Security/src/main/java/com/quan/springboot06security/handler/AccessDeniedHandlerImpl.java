package com.quan.springboot06security.handler;

import com.alibaba.fastjson.JSON;
import com.quan.springboot06security.domain.ResponseResult;
import com.quan.springboot06security.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: AccessDeniedHandlerImpl
 * @Description: 自定义授权失败的异常处理
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/20 16:21
 */

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ResponseResult responseResult = new ResponseResult(
                HttpStatus.FORBIDDEN.value(),
                "您的权限不足");
        String json = JSON.toJSONString(responseResult);
        WebUtils.renderString(response, json);
    }
}
