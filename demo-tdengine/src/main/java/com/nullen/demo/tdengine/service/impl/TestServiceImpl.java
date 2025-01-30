package com.nullen.demo.tdengine.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nullen.demo.tdengine.entity.Test;
import com.nullen.demo.tdengine.mapper.TestMapper;
import com.nullen.demo.tdengine.service.TestService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nullen
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {


    @Override
    public List<Test> pageList(int page, long size) {

        return null;
    }
}
