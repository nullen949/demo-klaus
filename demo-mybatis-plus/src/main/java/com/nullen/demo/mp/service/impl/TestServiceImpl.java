package com.nullen.demo.mp.service.impl;

import com.github.yulichang.base.MPJBaseServiceImpl;
import com.nullen.demo.comm.entity.Test;
import com.nullen.demo.mp.mapper.TestMapper;
import com.nullen.demo.mp.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author Nullen
 */
@Service
public class TestServiceImpl extends MPJBaseServiceImpl<TestMapper, Test> implements TestService {
}
