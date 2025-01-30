package com.nullen.demo.jpa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nullen.demo.jpa.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Nullen
 */
@Mapper
public interface TestEntityMapper extends BaseMapper<TestEntity> {
}
