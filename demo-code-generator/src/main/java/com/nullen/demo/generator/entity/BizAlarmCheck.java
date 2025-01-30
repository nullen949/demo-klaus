package com.nullen.demo.generator.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

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
@TableName("biz_alarm_check")
public class BizAlarmCheck implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long checkedTs;

    private String sessionId;

    private Byte checkStatus;

    private String content;

    private String deviceCode;
}
