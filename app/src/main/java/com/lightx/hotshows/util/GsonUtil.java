package com.lightx.hotshows.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * Created by Nitin Gautam on 07/02/2018.
 */

public class GsonUtil {

    private static Gson gson = new GsonBuilder().create();
    private static Gson gsonExposeField = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    private static Gson gsonAllowNullValues = new GsonBuilder().serializeNulls().create();

    public static <T> String toJsonFromExposeFields(T t) {
        return gsonExposeField.toJson(t);
    }

    public static <T> String toJson(T t) {
        return gson.toJson(t);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, (Type) classOfT);
    }

    public static <T> String toJsonFromNullValues(T t) {
        return gsonAllowNullValues.toJson(t);
    }
}
