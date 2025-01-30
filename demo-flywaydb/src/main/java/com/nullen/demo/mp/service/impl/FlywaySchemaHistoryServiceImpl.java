package com.nullen.demo.mp.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nullen.demo.mp.entity.FlywaySchemaHistory;
import com.nullen.demo.mp.mapper.FlyWaySchemaHistoryMapper;
import com.nullen.demo.mp.service.FlywaySchemaHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nullen
 */
@Service
public class FlywaySchemaHistoryServiceImpl extends ServiceImpl<FlyWaySchemaHistoryMapper, FlywaySchemaHistory> implements FlywaySchemaHistoryService {


    @Override
    public String getLastVersion() {
        List<FlywaySchemaHistory> list = list(Wrappers.<FlywaySchemaHistory>lambdaQuery().orderByDesc(FlywaySchemaHistory::getInstalledRank).last("LIMIT 1"));
        return null;
    }
}
