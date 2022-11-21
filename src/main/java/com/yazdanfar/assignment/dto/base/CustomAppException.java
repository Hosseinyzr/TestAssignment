package com.yazdanfar.assignment.dto.base;

import lombok.Getter;


@Getter
public class CustomAppException extends Exception  {
    private Integer code;

    public CustomAppException(String message) {
        super(message);
        this.code = -1;

    }

    public CustomAppException(String message, int code) {
        super(message);
        this.code = code;
    }

    public CustomAppException(Throwable throwable) {
        super(throwable.getMessage());
        this.code = -1;

    }

    public CustomAppException(Throwable throwable, int code) {
        super(throwable.getMessage());
        this.code = code;

    }

    public CustomAppException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomAppException(String message,
                              Throwable cause,
                              boolean enableSuppression,
                              boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public void setCode(Integer code) {
        this.code = code;
    }





}
