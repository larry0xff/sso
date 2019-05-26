package com.larry.service;

/**
 * @author larry
 * @since 22:36 2019/05/26
 */
public interface UserService {
    /**
     * 校验用户名密码
     * @param username 用户名
     * @param password 密码
     * @param systemId
     */
    void verify(String username, String password, Integer systemId);

}
