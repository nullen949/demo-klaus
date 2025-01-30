package com.nullen.demo.starter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Silas
 */
@Data
@ConfigurationProperties(DemoProperties.PREFIX)
public class DemoProperties {
    public static final String PREFIX = "demo";
    private String name = "nullen";
}
