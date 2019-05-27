package com.larry.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReturnCodeEnums {

    SUCCESS("0000", "成功"),
    XXX_ERR("1000", "");

    private String code;
    private String msg;


}
