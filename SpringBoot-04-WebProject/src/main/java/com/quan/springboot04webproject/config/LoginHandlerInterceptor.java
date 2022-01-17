package com.quan.springboot04webproject.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: LoginHandlerInterceptor
 * @Description: 登录拦截器
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/17 17:33
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 登录成功后应设置用户的session
        Object loginUser = request.getSession().getAttribute("loginUser");
        // 找不到就退出
        if (loginUser == null) {
            request.setAttribute("msg", "请先登录");
            // 转发后，由配置的视图解析器跳转
            request.getRequestDispatcher("/index.html").forward(request, response);
            // 不放行
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
