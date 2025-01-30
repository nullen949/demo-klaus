package com.nullen.demo.tdengine.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author Nullen
 */
public class TDEntity {

    /**
     * 获取表名
     *
     * @return 子类的表名
     */
    public String getTableName() {
        TableName tableNameAnnotation = this.getClass().getAnnotation(TableName.class);
        return tableNameAnnotation.value();
    }



}
