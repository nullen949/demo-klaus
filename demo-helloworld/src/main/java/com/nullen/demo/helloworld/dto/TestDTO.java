package com.nullen.demo.helloworld.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author Silas
 */
public class TestDTO {


    @JsonDeserialize(using = DateDeserializers.TimestampDeserializer.class)
    private Timestamp ts;

    private String name;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
