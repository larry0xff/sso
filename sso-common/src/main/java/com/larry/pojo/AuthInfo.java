package com.larry.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthInfo {

    private String token;

    private UserInfo userInfo;

    private Long expiredTime;

    private Long loginTime;

    private Integer lastSystemId;
}
