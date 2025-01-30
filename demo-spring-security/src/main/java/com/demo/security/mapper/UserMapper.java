package com.demo.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.security.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Nullen
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}