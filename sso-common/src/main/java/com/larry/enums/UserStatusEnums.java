package com.larry.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * 用户状态枚举
 * @author larry
 * @since 22:51 2019/05/26
 */
@Getter
@AllArgsConstructor
public enum UserStatusEnums {
    /**
     * 可用
     */
    ACTIVE(1),
    /**
     * 禁用
     */
    BANNED(2);

    private Integer status;

}
