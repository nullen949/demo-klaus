package com.nullen.demo.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@TableName("flyway_schema_history")
public class FlywaySchemaHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("installed_rank")
    private Integer installedRank;

    private String version;

    private String description;

    private String type;

    private String script;

    private Integer checksum;

    private String installedBy;

    private LocalDateTime installedOn;

    private Integer executionTime;

    private Boolean success;
}
