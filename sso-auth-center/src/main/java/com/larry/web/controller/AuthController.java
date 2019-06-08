package com.larry.web.controller;

import com.larry.constant.RedisKeys;
import com.larry.enums.ServiceExceptionEnums;
import com.larry.pojo.AuthInfo;
import com.larry.pojo.LoginParam;
import com.larry.pojo.Result;
import com.larry.service.UserService;
import com.larry.util.JsonUtils;
import com.larry.util.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Value("${auth.token.expire.second:1800}")
    private long expireSecond;

    @Autowired
    public UserService userService;

    /**
     * 检查状态
     * @param token
     * @return
     */
    @GetMapping("/checkStatus/{token}")
    public Result checkStatus(@PathVariable("token") String token) {
        AuthInfo authInfo = ofNullable(RedisClient.get(RedisKeys.AUTH_TOKEN_SUFFIX + token))
                .filter(authInfoStr -> !StringUtils.isEmpty(authInfoStr))
                .map(authInfoStr -> JsonUtils.fromJson(authInfoStr.toString(), AuthInfo.class))
                .orElse(null);
        return Result.success(authInfo);
    }

    /**
     * 登录
     * @param param
     * @return
     */
    @PostMapping("/login")
    public Result<AuthInfo> login(@RequestBody LoginParam param) {
        AuthInfo authInfo = userService.verify(param.getUsername(), param.getPassword(), param.getSystemId());
        long current = System.currentTimeMillis();
        authInfo.setExpiredTime(current + expireSecond * 1000);
        authInfo.setLoginTime(current);
        RedisClient.setex(RedisKeys.AUTH_TOKEN_SUFFIX + authInfo.getToken(), JsonUtils.toJson(authInfo), expireSecond);
        return Result.success(authInfo);
    }

    /**
     * 注销
     * @param token
     * @return
     */
    @PostMapping("/logout")
    public Result<Boolean> logout(@PathVariable String token) {
        return Result.success(RedisClient.del(RedisKeys.AUTH_TOKEN_SUFFIX + token));
    }

    /**
     * 续期，更新状态
     * @param token
     * @return
     */
    @PostMapping("/renewal/{token}")
    public Result<Long> renewal(@PathVariable("token") String token) {
        long current = System.currentTimeMillis();
        String key = RedisKeys.AUTH_TOKEN_SUFFIX + token;
        long expiredTime = current + expireSecond * 1000;
        Object jsonStr = ofNullable(RedisClient.get(key))
                .orElseThrow(ServiceExceptionEnums.LOGIN_TIMEOUT::getException);
        of(jsonStr).ifPresent(str -> {
            AuthInfo authInfo = JsonUtils.fromJson(str.toString(), AuthInfo.class);
            authInfo.setExpiredTime(expiredTime);
            RedisClient.setex(key, str.toString(), expireSecond);
        });
        return Result.success(expiredTime);
    }

}
