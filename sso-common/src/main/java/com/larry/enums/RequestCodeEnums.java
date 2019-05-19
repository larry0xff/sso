package com.larry.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RequestCodeEnums {


    SUCCESS("0000", "成功"),
    SYS_ERR("5000", "网络请求超时");

    private String code;
    private String msg;


}
