package com.nullen.demo.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nullen.demo.mp.entity.FlywaySchemaHistory;

/**
 * @author Nullen
 */
public interface FlywaySchemaHistoryService extends IService<FlywaySchemaHistory> {

    /**
     * 获取最新版本
     *
     * @return {@link String}
     */
    String getLastVersion();
}
