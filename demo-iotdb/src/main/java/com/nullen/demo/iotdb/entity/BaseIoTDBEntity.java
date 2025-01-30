package com.nullen.demo.iotdb.entity;

import lombok.Data;

/**
 * @author Silas
 */
@Data
public class BaseIoTDBEntity {

    private String deviceId;

    private Long ts;
}
