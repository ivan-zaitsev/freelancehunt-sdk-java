package ua.ivan909020.freelancehunt.sdk.requests;

import java.io.IOException;

import ua.ivan909020.freelancehunt.sdk.objects.request.HttpRequest;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public abstract class GetApiRequest<T extends ApiResponse> extends ApiRequest<T> {

    @Override
    public boolean isWritable() {
        return false;
    }

    @Override
    public String getMethod() {
        return "GET";
    }

    @Override
    public void writeRequest(HttpRequest request) throws IOException {

    }

}
