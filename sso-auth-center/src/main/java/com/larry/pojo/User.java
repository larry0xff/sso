package com.larry.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author larry
 * @since 22:49 2019/05/26
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 状态
     */
    private Integer status;

}
