package ua.ivan909020.freelancehunt.sdk.requests;

import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public abstract class GetApiRequest<T extends ApiResponse> extends ApiRequest<T> {

    @Override
    public String getMethod() {
        return "GET";
    }

}
