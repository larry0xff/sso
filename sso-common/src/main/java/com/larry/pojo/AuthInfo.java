package com.larry.pojo;

import lombok.Data;

@Data
public class AuthInfo {

    private String token;

    private String username;

    private Long expiredTime;

    private Long loginTime;

    private Integer lastSystemId;
}
