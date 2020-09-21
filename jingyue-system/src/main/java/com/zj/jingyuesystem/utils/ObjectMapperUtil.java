package com.zj.jingyuesystem.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zj.jingyuecommon.util.GlobalException;

public class ObjectMapperUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String writeValueAsString(Object value) {
        String valueAsString = null;
        try {
            valueAsString = objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new GlobalException("转换成String字符串失败", e);
        }
        return valueAsString;
    }
}
