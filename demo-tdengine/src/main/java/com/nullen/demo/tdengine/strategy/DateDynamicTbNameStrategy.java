package com.nullen.demo.tdengine.strategy;

import com.nullen.demo.tdengine.constant.SqlConstant;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Nullen
 */
@Configuration
public class DateDynamicTbNameStrategy extends AbstractDynamicTbNameStrategy {
    @Override
    public String dynamicTableName(String tableName) {
        return tableName + SqlConstant.UNDERLINE + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
}
