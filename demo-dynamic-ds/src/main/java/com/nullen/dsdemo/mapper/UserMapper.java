package com.nullen.dsdemo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nullen.dsdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
