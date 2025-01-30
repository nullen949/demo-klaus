package com.nullen.demo.unittest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nullen.demo.unittest.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Silas
 */
@Mapper
public interface TestMapper extends BaseMapper<TestEntity> {
}
