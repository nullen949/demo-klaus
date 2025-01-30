package com.nullen.demo.tdorm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.nullen.tdengineorm.annotation.TdTag;
import com.nullen.tdengineorm.entity.BaseTdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Nullen
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("vessel_shm_sg_10086_smart")
public class VesselShm extends BaseTdEntity {

    private Double current;
    private Integer voltage;
    @TableField("phase")
    private Float phase333;
    @TdTag
    private String tenantId;
}
