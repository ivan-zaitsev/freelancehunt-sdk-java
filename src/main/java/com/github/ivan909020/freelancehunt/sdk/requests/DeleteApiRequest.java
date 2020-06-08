package com.github.ivan909020.freelancehunt.sdk.requests;

import org.apache.http.client.methods.HttpDelete;

public abstract class DeleteApiRequest<T> extends ApiRequest<T> {

    @Override
    public T execute() {
        validate();

        HttpDelete request = new HttpDelete(getUrl());
        setHeaders(request);
        return deserializeResponse(getApi().getTransportClient().execute(request));
    }

}
