package com.larry.service;

import com.larry.pojo.AuthInfo;

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
     * @return token 凭证
     */
    AuthInfo verify(String username, String password, Integer systemId);

}
