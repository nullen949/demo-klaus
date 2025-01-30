package com.nullen.demo.iotdb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Silas
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Pc extends BaseIoTDBEntity {
    private String name;
    private Integer status;
    private Boolean current;
}
