package com.larry.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReturnCodeEnums {


    XXX_ERR("1000", "");

    private String code;
    private String msg;


}
