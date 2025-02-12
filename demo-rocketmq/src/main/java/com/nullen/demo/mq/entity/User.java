package com.nullen.demo.mq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Nullen
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;


    private String name;


    private Integer age;


    public static User getUser() {
        return new User(1L, "test", 18);
    }
}
