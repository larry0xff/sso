package com.larry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.larry.pojo.AuthInfo;
import com.larry.pojo.LoginParam;
import com.larry.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

/**
 * @author larry
 * @since 13:14 2019/06/08
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthCenterApplication.class)
@AutoConfigureMockMvc
@Slf4j
public class AuthApiTest {

    private String token;

    @Autowired
    private MockMvc mvc;

    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .disableHtmlEscaping().create();

    @Before
    public void testLogin() throws Exception {

        LoginParam param = new LoginParam();
        param.setUsername("tony");
        param.setPassword("tony");
        param.setSystemId(1);

        MvcResult mvcResult = mvc.perform(post("/auth/login")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(GSON.toJson(param))).andReturn();

//        Js result = GSON.fromJson(mvcResult.getResponse().getContentAsString(), Result.class).getData();
//
//        JsonObject json = new JsonObject();
//        this.token = result.getData().getToken();
    }

    @Test
    public void testCheckStatus() throws Exception {
        mvc.perform(get("/auth/checkStatus/" + token)).andDo(a -> {
            log.info("[查询登录状态] -> {}", a.getResponse().getContentAsString());
        });
    }

    @Test
    public void testRenewal() throws Exception {
        mvc.perform(post("/auth/renewal/" + token)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(a -> {
                    log.info("[续期结果] -> {}", a.getResponse().getContentAsString());
                });
    }
}
