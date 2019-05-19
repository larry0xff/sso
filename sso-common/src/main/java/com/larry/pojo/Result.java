package com.larry.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Result<T> {

    private T data;
    private String requestCode;
    private String returnCode;
    private String msg;

}
