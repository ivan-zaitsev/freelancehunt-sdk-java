package com.github.ivan909020.freelancehunt.sdk.requests;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public abstract class GetApiRequest<T> extends ApiRequest<T> {

    @Override
    public T execute() {
        validate();

        HttpGet request = new HttpGet(buildUri());
        setHeaders(request);
        return deserializeResponse(getApi().getTransportClient().execute(request));
    }

    private URI buildUri() {
        URI uri;
        try {
            URIBuilder builder = new URIBuilder(getUrl());
            for (Map.Entry<String, Object> parameter : getParameters().entrySet()) {
                builder.addParameter(parameter.getKey(), String.valueOf(parameter.getValue()));
            }
            uri = builder.build();
        } catch (URISyntaxException e) {
            throw new ApiException("Failed to build request uri", e);
        }
        return uri;
    }

}
