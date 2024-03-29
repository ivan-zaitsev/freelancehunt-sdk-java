package ua.ivanzaitsev.freelancehunt.sdk.services.responses;

import java.io.BufferedInputStream;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import ua.ivanzaitsev.freelancehunt.sdk.exceptions.ApiResponseDeserializationException;
import ua.ivanzaitsev.freelancehunt.sdk.objects.response.HttpResponse;
import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;
import ua.ivanzaitsev.freelancehunt.sdk.utils.StreamUtils;

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
        return deserialize(content, responseClass);
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
