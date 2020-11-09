package com.learn.app.utils;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHelper {
    private static final Logger log = LoggerFactory.getLogger(JsonHelper.class);

    // Initialize JsonFactory instance
    private static final JsonFactory jsonFactory = new JsonFactory().disable(JsonGenerator.Feature.AUTO_CLOSE_TARGET);

    // Initialize ObjectMapper instance
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        objectMapper.setSerializationInclusion(Include.NON_EMPTY);
    }

    public static String toJsonString(Object input) {
        try {
            StringWriter sw = new StringWriter();
            JsonGenerator generator = jsonFactory.createGenerator(sw);
            objectMapper.writeValue(generator, input);
            return sw.toString();
        } catch (Exception e) {
            log.error("Error writing Json String:" + input, e);
        }
        return StringUtils.EMPTY;
    }

    public static boolean isJSONValid(String jsonInString) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            objectMapper.readTree(jsonInString);
            return true;
        } catch (Exception e) {
            log.error("Invalid Json String %s: ", jsonInString);
            return false;
        }
    }

    public static <T> T toObject(String jsonString, Class<T> T) {
        try {
            return objectMapper.readValue(jsonString, T);
        } catch (IOException e) {
            log.error("Error while adapting json string to pojo ", e);
        }
        return null;
    }

    public static ObjectMapper objectMapper() {
        return objectMapper;
    }
}
