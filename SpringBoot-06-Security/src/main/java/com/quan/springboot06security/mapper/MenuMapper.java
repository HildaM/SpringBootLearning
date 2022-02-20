package com.quan.springboot06security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quan.springboot06security.domain.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: MenuMapper
 * @Description: 权限信息接口
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/20 15:42
 */
public interface MenuMapper extends BaseMapper<Menu> {

    // 根据用户id查询对应的权限信息
    List<String> selectPermsByUserId(@Param("userid") Long userid);
}
