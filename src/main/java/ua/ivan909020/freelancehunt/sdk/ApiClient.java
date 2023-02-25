package ua.ivan909020.freelancehunt.sdk;

import java.io.IOException;

import ua.ivan909020.freelancehunt.sdk.configs.ApiConfig;
import ua.ivan909020.freelancehunt.sdk.configs.HttpClientConfig;
import ua.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import ua.ivan909020.freelancehunt.sdk.requests.ApiRequest;
import ua.ivan909020.freelancehunt.sdk.services.requests.RequestSerializer;
import ua.ivan909020.freelancehunt.sdk.services.responses.ResponseDeserializer;

public class ApiClient {

    private final ApiConfig apiConfig;
    private final HttpClientConfig httpClientConfig;

    private RequestSerializer requestSerializer;
    private ResponseDeserializer responseDeserializer;

    ApiClient(ApiConfig apiConfig, HttpClientConfig httpClientConfig) {
        this.apiConfig = apiConfig;
        this.httpClientConfig = httpClientConfig;
    }

    public static ApiClientBuilder builder() {
        return new ApiClientBuilder();
    }

    public ApiConfig getApiConfig() {
        return apiConfig;
    }

    public HttpClientConfig getHttpClientConfig() {
        return httpClientConfig;
    }

    public void setRequestSerializer(RequestSerializer requestSerializer) {
        this.requestSerializer = requestSerializer;
    }

    public void setResponseDeserializer(ResponseDeserializer responseDeserializer) {
        this.responseDeserializer = responseDeserializer;
    }

    public <T> T sendRequest(ApiRequest<T> request) {
        request.setApiClient(this);
        request.setRequestSerializer(requestSerializer);
        request.setResponseDeserializer(responseDeserializer);

        try {
            return request.execute();
        } catch (IOException e) {
            throw new ApiException("Failed to send http request", e);
        }
    }

}
