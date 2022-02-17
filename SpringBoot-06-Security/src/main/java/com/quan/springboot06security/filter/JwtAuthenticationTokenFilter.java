package com.quan.springboot06security.filter;

import com.quan.springboot06security.domain.LoginUser;
import com.quan.springboot06security.utils.JwtUtil;
import com.quan.springboot06security.utils.RedisCache;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @ClassName: JwtAuthenticationTokenFilter
 * @Description: 自定jwt过滤器
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/17 17:44
 */

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1. 获取token，获取请求头的token
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            // 放行。后面的过滤器会判断token的信息，如果没有，那也会在后面被拦截，所以这里就直接放行了
            filterChain.doFilter(request, response);
            // 避免后面的过滤器响应回来的时候，会执行下面的代码。所以需要在这里截断，直接return！！！
            return;
        }

        /*  以下均为解析token的内容  */
        // 2. 解析token
        String userId;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userId = claims.getSubject();
        } catch (Exception e) {
            throw new RuntimeException("token非法");
        }

        // 3. 从redis中获取用户信息
        String redisKey = "login:" + userId;
        LoginUser loginUser = redisCache.getCacheObject(redisKey);
        if (Objects.isNull(loginUser)) {
            throw new RuntimeException("用户未登录");
        }

        // 4. 存入scrutinyContextHolder，因为后续的过滤器都是从这里获取认证信息的
        // TODO 获取权限信息，封装到Auhtentication中！
        UsernamePasswordAuthenticationToken authenticationToken =
                // 使用三个参数的构造，第三个参数代表用户已经认证成功！
                new UsernamePasswordAuthenticationToken(loginUser, null, null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);


        // 5. 放行代码！
        filterChain.doFilter(request, response);
    }
}
