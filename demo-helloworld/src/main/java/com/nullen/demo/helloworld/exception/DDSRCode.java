package com.nullen.demo.helloworld.exception;


import com.nullen.fd.exception.ExceptionCode;

/**
 * @author Nullen
 */
public enum DDSRCode implements ExceptionCode {

    ADD_FAIL(70001, "Unable connect datasource!");

    private final Integer code;

    private final String msg;

    DDSRCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
