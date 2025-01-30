package com.nullen.demo.comm.entity;

import com.nullen.demo.comm.enums.TestEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Nullen
 */
@Data
public class Test {

    private Long id;

    private String content;

    private LocalDateTime time;

    private TestEnum testEnum;
}
