package com.yazdanfar.assignment.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yazdanfar.assignment.dto.base.TransactionBean;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
public class MessageDTO implements Message {

    private TransactionBean transactionBean;

    @SneakyThrows
    public String toJson(ObjectMapper objectMapper) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        }
        return objectMapper.writeValueAsString(this);
    }

    @SneakyThrows
    public String toJson() {
        return toJson(null);
    }


    public static <T extends MessageDTO> T fromString(ObjectMapper objectMapper, String json, Class<T> messageClass) throws Exception {
        return (T) objectMapper.readValue(json, messageClass);
    }

}
