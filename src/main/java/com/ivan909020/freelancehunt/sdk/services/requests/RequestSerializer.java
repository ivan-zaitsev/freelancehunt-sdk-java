package com.ivan909020.freelancehunt.sdk.services.requests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivan909020.freelancehunt.sdk.exceptions.ApiRequestSerializationException;

public class RequestSerializer {

    private ObjectMapper objectMapper;

    public RequestSerializer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public byte[] serialize(Object content) {
        try {
            return objectMapper.writeValueAsBytes(content);
        } catch (JsonProcessingException e) {
            throw new ApiRequestSerializationException("Failed to serialize content", e).setContent(content);
        }
    }

}
