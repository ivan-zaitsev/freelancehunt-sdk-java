package ua.ivan909020.freelancehunt.sdk.requests;

import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public abstract class PatchApiRequest<T extends ApiResponse> extends WritableApiRequest<T> {

    @Override
    public String getMethod() {
        return "PATCH";
    }

}
