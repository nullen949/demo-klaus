package com.nullen.demo.helloworld.exception;


import com.nullen.fd.exception.AbstractException;
import com.nullen.fd.exception.ExceptionCode;

/**
 * @author Nullen
 */
public class DDSException extends AbstractException {

    public DDSException(Integer code, String message) {
        super(code, message);
    }

    public <T extends ExceptionCode> DDSException(T irCode) {
        super(irCode);
    }
}
