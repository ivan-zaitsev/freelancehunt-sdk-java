package ua.ivan909020.freelancehunt.sdk.services.responses;

import java.io.BufferedInputStream;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiRequestException;
import ua.ivan909020.freelancehunt.sdk.exceptions.ApiResponseDeserializationException;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;
import ua.ivan909020.freelancehunt.sdk.utils.StreamUtils;

public class ResponseDeserializerJson implements ResponseDeserializer {

    private ObjectMapper objectMapper;

    public ResponseDeserializerJson(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public <T> T deserialize(String content, Class<T> resultClass) {
        try {
            return objectMapper.readValue(content, resultClass);
        } catch (IOException e) {
            throw new ApiResponseDeserializationException("Failed to deserialize response", e).setContent(content);
        }
    }

    @Override
    public <T extends ApiResponse> T deserialize(HttpResponse response, Class<T> responseClass) throws IOException {
        String content = readContent(response);

        T result = deserialize(content, responseClass);

        if (result.getError() != null) {
            throw new ApiRequestException("Api response error", result.getError());
        }
        return result;
    }

    private String readContent(HttpResponse response) throws IOException {
        if (response.getInputStream() == null) {
            return "{}";
        }

        String content = StreamUtils.readContent(new BufferedInputStream(response.getInputStream()));

        if (content.isEmpty()) {
            return "{}";
        }

        return content;
    }

}