package com.larry.enums;

import com.larry.exception.ServiceException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author larry
 * @since 23:05 2019/05/26
 */
@AllArgsConstructor
@Getter
public enum ServiceExceptionEnums {

    PASSWORD_INCORRECT(new ServiceException("10000", "用户名或密码错误")),
    USER_NOT_EXIST(new ServiceException("10001", "用户不存在")),
    USER_BANNED(new ServiceException("10002", "用户已被禁用"));

    private ServiceException exception;
}
