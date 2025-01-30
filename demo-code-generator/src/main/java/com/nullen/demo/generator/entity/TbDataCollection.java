package com.nullen.demo.generator.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Baomidou
 * @since 2024-07-03
 */
@Getter
@Setter
@TableName("tb_data_collection")
public class TbDataCollection implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String collectionName;

    /**
     * 采集状态 0未启动 1启动 2异常
     */
    private Byte status;

    /**
     * 采集cron
     */
    private String dataCron;

    /**
     * 采集参数内容
     */
    private String paramContent;

    /**
     * 任务id
     */
    private String taskId;
}
