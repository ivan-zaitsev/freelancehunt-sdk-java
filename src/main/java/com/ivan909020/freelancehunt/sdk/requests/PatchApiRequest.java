package com.ivan909020.freelancehunt.sdk.requests;

import java.io.IOException;

import com.ivan909020.freelancehunt.sdk.objects.http.HttpRequest;
import com.ivan909020.freelancehunt.sdk.utils.StreamUtils;

public abstract class PatchApiRequest<T> extends ApiRequest<T> {

    @Override
    public boolean isWritable() {
        return true;
    }

    @Override
    public String getMethod() {
        return "PATCH";
    }

    @Override
    public void writeRequest(HttpRequest request) throws IOException {
        StreamUtils.transfer(getEntity().getContent(), request.getOutputStream());
    }

}
