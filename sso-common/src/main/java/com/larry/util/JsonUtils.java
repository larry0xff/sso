package com.larry.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author larry
 * @since 23:23 2019/05/26
 */
public class JsonUtils {

    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
            .disableHtmlEscaping()
            .setPrettyPrinting()
            .create();

    /**
     * 对象转JSON字符串
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    /**
     * JSON字符串转对象
     * @param jsonStr
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String jsonStr, Class<T> tClass) {
        return gson.fromJson(jsonStr, tClass);
    }
}
