package ua.ivan909020.freelancehunt.sdk.requests;

import java.io.IOException;

import ua.ivan909020.freelancehunt.sdk.objects.request.HttpRequest;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;
import ua.ivan909020.freelancehunt.sdk.utils.StreamUtils;

public abstract class PatchApiRequest<T extends ApiResponse> extends ApiRequest<T> {

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
        StreamUtils.transfer(getEntity().getContent().getData(), request.getOutputStream());
    }

}
