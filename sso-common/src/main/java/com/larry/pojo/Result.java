package com.larry.pojo;

import com.larry.enums.RequestCodeEnums;
import com.larry.enums.ReturnCodeEnums;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result<T> {

    private T data;
    private String requestCode;
    private String returnCode;
    private String msg;

    public static <T> Result<T> success(T data) {
        return (Result<T>) Result.builder()
                .data(data)
                .requestCode(RequestCodeEnums.SUCCESS.getCode())
                .returnCode(ReturnCodeEnums.SUCCESS.getCode()).build();
    }
}
