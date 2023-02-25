package ua.ivan909020.freelancehunt.sdk.services.responses;

import java.io.IOException;

import ua.ivan909020.freelancehunt.sdk.objects.response.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public interface ResponseDeserializer {

    <T> T deserialize(String content, Class<T> resultClass);

    <T extends ApiResponse> T deserialize(HttpResponse response, Class<T> responseClass) throws IOException;

}
