package com.quan.springboot06security.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: LoginUser
 * @Description: 实现UserDetails
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/16 17:41
 */

@Data
@NoArgsConstructor
public class LoginUser implements UserDetails {

    // 其实也可让User类直接实现UserDetails
    private User user;

    private List<String> permissions;

    // redis默认不会将SimpleGrantedAuthority序列化，所以要对它进行忽略
    // 而且，即使没有这个东西，也可以通过permissions再次生成！！！
    @JSONField(serialize = false)
    private List<SimpleGrantedAuthority> authorities;

    public LoginUser(User user, List<String> permissions) {
        this.user = user;
        this.permissions = permissions;
    }

    // 返回权限信息
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 把permission中的String类型的权限信息封装成SimpleGrantedAuthority对象
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for (String permission : permissions) {
//            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(permission);
//            authorities.add(authority);
//        }

        // 函数式编程，stream操作
        if (authorities == null)
            authorities = permissions.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }


    // 判断是否没有过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 是否可用
    @Override
    public boolean isEnabled() {
        return true;
    }
}
