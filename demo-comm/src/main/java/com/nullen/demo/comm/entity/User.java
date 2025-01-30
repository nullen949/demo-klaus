package com.nullen.demo.comm.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author Nullen
 */


// @Data
@Getter
@Setter
@RequiredArgsConstructor
public class User {

    private Long id;

    private String userCode;

    private String username;

    private String password;

    private int age;

}
