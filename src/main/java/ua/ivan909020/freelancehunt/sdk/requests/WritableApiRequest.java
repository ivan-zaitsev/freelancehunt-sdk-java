package ua.ivan909020.freelancehunt.sdk.requests;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import ua.ivan909020.freelancehunt.sdk.objects.request.HttpRequest;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;
import ua.ivan909020.freelancehunt.sdk.utils.StreamUtils;

public abstract class WritableApiRequest<T extends ApiResponse> extends ApiRequest<T> {

    @Override
    public boolean isWritable() {
        return true;
    }

    @Override
    public void writeRequest(HttpRequest request) throws IOException {
        InputStream inputStream = getEntity().getContent().getData();
        OutputStream outputStream = request.getOutputStream();
        try (inputStream; outputStream) {
            StreamUtils.transfer(inputStream, outputStream);
        }
    }

}
