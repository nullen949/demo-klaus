package com.nullen.demo.tdengine.strategy;

/**
 * @author Nullen
 */
public abstract class AbstractDynamicTbNameStrategy {

    /**
     * 动态表名生成
     *
     * @param tableName 原始表名
     * @return 根据策略修改后的表名
     */
    public abstract String dynamicTableName(String tableName);

}
