package com.nullen.demo.mp.mapper;


import com.github.yulichang.base.MPJBaseMapper;
import com.nullen.demo.mp.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends MPJBaseMapper<Order> {
}
