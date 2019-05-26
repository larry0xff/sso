package com.larry.pojo;

import lombok.Data;

@Data
public class LoginParam {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 系统id
     */
    private Integer systemId;

}
