package ua.ivanzaitsev.freelancehunt.sdk.requests;

import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;

public abstract class GetApiRequest<T extends ApiResponse> extends ApiRequest<T> {

    @Override
    public String getMethod() {
        return "GET";
    }

}
