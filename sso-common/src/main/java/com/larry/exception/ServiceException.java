package com.larry.exception;

import lombok.Getter;

/**
 * @author larry
 * @since 23:02 2019/05/26
 */
@Getter
public class ServiceException extends RuntimeException {

    private String code;

    private String message;

    public ServiceException(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
