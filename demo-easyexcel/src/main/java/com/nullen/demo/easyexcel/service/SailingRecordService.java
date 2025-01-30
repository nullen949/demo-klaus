package com.nullen.demo.easyexcel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nullen.demo.easyexcel.entity.SailingRecord;

/**
 * @author Nullen
 */
public interface SailingRecordService extends IService<SailingRecord> {

    void getById();
}
