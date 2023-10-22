package ua.ivanzaitsev.freelancehunt.sdk.services.responses;

import java.io.IOException;

import ua.ivanzaitsev.freelancehunt.sdk.objects.response.HttpResponse;
import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;

public interface ResponseDeserializer {

    <T> T deserialize(String content, Class<T> resultClass);

    <T extends ApiResponse> T deserialize(HttpResponse response, Class<T> responseClass) throws IOException;

}
