package com.nullen.demo.helloworld;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Nullen
 */
@Data
@NoArgsConstructor
public class JsonTestEntity {

    private String username;

    private LocalDate localDate;

    private LocalDateTime localDateTime;

    private Timestamp timestamp;
}
