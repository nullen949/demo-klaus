package com.nullen.demo.tdengine.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.dream.system.annotation.Table;
import com.nullen.demo.tdengine.anno.TDTableEntity;
import com.nullen.demo.tdengine.anno.TDTagField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Nullen
 */
@Data
@Table
@TDTableEntity
@TableName("meters")
@EqualsAndHashCode(callSuper = true)
public class TdMeters extends TDengineEntityBase {

    private Float current;

    private Integer voltage;

    private Double phase;

    @TDTagField
    private Integer groupId;

    @TDTagField
    private String location;

}
