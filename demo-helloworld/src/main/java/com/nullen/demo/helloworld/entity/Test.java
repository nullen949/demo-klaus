package com.nullen.demo.helloworld.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.nullen.demo.comm.entity.BaseEntity;
import com.nullen.demo.helloworld.anno.DataSync;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

/**
 * @author Nullen
 */
@Data
@EqualsAndHashCode(callSuper = true)
@DataSync(pullCron = "0 0 1 * * ?")
public class Test extends BaseEntity {
    @JsonDeserialize(using = DateDeserializers.TimestampDeserializer.class)
    private Timestamp ts;

    private String name;
}
