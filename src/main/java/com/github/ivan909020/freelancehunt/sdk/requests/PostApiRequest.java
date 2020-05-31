package com.github.ivan909020.freelancehunt.sdk.requests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

public abstract class PostApiRequest<T> extends ApiRequest<T> {

    @Override
    public T execute() {
        validate();

        HttpPost request = new HttpPost(getUrl());
        addHeaders(request);
        addEntity(request);
        return deserializeResponse(getApi().getTransportClient().execute(request));
    }

    public void addEntity(HttpPost request) {
        request.setEntity(new StringEntity(createPayload(), ContentType.APPLICATION_JSON));
    }

    private String createPayload() {
        try {
            return getApi().getResponseDeserializer().getObjectMapper().writeValueAsString(getParameters());
        } catch (JsonProcessingException e) {
            throw new ApiException("Failed to create request payload", e);
        }
    }

}
