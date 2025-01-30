package com.nullen.demo.generator.entity;

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
@TableName("biz_alarm_inhibit")
public class BizAlarmInhibit implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String ruleSubChainId;

    private String deviceCode;

    private String alarmName;

    private LocalDateTime createTime;
}
