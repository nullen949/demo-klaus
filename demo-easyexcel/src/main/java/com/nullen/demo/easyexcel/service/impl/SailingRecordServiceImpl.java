package com.nullen.demo.easyexcel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nullen.demo.easyexcel.entity.SailingRecord;
import com.nullen.demo.easyexcel.mapper.SailingRecordMapper;
import com.nullen.demo.easyexcel.service.SailingRecordService;
import org.springframework.stereotype.Service;

/**
 * @author Nullen
 */
@Service
public class SailingRecordServiceImpl extends ServiceImpl<SailingRecordMapper, SailingRecord> implements SailingRecordService {


    @Override
    public void getById() {

    }
}
