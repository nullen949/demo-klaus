package com.nullen.demo.helloworld.exception;

import com.fd.web.response.Result;
import com.nullen.fd.exception.AbstractException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Nullen
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(AbstractException.class)
    public Result<Void> test(AbstractException exception) {
        return Result.fail(DDSRCode.ADD_FAIL);
    }
}
