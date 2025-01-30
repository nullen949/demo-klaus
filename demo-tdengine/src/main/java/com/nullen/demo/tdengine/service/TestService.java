package com.nullen.demo.tdengine.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nullen.demo.tdengine.entity.Test;

import java.util.List;

/**
 * @author Nullen
 */
public interface TestService extends IService<Test> {


    List<Test> pageList(int page, long size);
}
