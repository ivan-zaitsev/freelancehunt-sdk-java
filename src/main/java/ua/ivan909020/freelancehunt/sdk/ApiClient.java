package ua.ivan909020.freelancehunt.sdk;

import java.io.IOException;

import ua.ivan909020.freelancehunt.sdk.configs.ApiConfig;
import ua.ivan909020.freelancehunt.sdk.configs.HttpClientConfig;
import ua.ivan909020.freelancehunt.sdk.configs.ObjectMapperConfig;
import ua.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import ua.ivan909020.freelancehunt.sdk.requests.ApiRequest;

public class ApiClient {

    private final ApiConfig apiConfig;
    private final HttpClientConfig httpClientConfig;
    private final ObjectMapperConfig objectMapperConfig;

    public ApiClient(ApiConfig apiConfig, HttpClientConfig httpClientConfig) {
        this.apiConfig = apiConfig;
        this.httpClientConfig = httpClientConfig;
        this.objectMapperConfig = new ObjectMapperConfig();
    }

    public ApiConfig getApiConfig() {
        return apiConfig;
    }

    public HttpClientConfig getHttpClientConfig() {
        return httpClientConfig;
    }

    public ObjectMapperConfig getObjectMapperConfig() {
        return objectMapperConfig;
    }

    public <T> T sendRequest(ApiRequest<T> request) {
        request.itilialize(this);

        try {
            return request.execute();
        } catch (IOException e) {
            throw new ApiException("Failed to send http request", e);
        }
    }

}
