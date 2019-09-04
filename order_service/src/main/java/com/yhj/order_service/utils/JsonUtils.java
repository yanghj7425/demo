package com.yhj.order_service.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode convertString2JsonNode(String content) {
        try {
            return objectMapper.readTree(content);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return null;
        }


    }


}
