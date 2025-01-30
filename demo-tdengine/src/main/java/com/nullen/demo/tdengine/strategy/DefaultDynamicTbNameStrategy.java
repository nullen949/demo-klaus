package com.nullen.demo.tdengine.strategy;

/**
 * 动态生成表名默认策略: 保持不变
 *
 * @author Nullen
 */
public class DefaultDynamicTbNameStrategy extends AbstractDynamicTbNameStrategy {

    @Override
    public String dynamicTableName(String tableName) {
        return tableName;
    }
}
