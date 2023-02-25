package ua.ivan909020.freelancehunt.sdk.services.requests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiRequestSerializationException;

public class RequestSerializerJson implements RequestSerializer {

    private ObjectMapper objectMapper;

    public RequestSerializerJson(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public byte[] serialize(Object content) {
        try {
            return objectMapper.writeValueAsBytes(content);
        } catch (JsonProcessingException e) {
            throw new ApiRequestSerializationException("Failed to serialize content", e).setContent(content);
        }
    }

}