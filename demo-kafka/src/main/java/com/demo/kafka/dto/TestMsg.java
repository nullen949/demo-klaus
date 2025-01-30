package com.demo.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Silas
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestMsg {

    private Long id;
    private String msg;
    private LocalDateTime time;
    private Integer status;
    private Boolean enable;

}
