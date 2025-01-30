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
@TableName("tb_device_info")
public class TbDeviceInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String deviceName;

    private String deviceCode;

    private String deviceSecret;

    private Long productId;

    private String productCode;

    private Byte deviceStatus;

    private String deviceIp;

    private LocalDateTime latestOnlineTime;

    private LocalDateTime activeTime;

    private String remarks;

    private String latitude;

    private String longitude;

    private String tenantId;

    private Byte disabled;

    private LocalDateTime createTime;

    private Byte deleted;

    /**
     * 船舶imo编号
     */
    private String imo;
}
