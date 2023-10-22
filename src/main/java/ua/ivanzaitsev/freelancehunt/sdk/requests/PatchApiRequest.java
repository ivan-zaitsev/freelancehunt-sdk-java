package ua.ivanzaitsev.freelancehunt.sdk.requests;

import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;

public abstract class PatchApiRequest<T extends ApiResponse> extends WritableApiRequest<T> {

    @Override
    public String getMethod() {
        return "PATCH";
    }

}
