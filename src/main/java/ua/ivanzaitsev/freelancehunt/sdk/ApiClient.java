package ua.ivanzaitsev.freelancehunt.sdk;

import java.io.IOException;

import ua.ivanzaitsev.freelancehunt.sdk.configs.ApiConfig;
import ua.ivanzaitsev.freelancehunt.sdk.configs.HttpClientConfig;
import ua.ivanzaitsev.freelancehunt.sdk.exceptions.ApiException;
import ua.ivanzaitsev.freelancehunt.sdk.requests.ApiRequest;
import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;
import ua.ivanzaitsev.freelancehunt.sdk.services.requests.RequestSerializer;
import ua.ivanzaitsev.freelancehunt.sdk.services.responses.ResponseDeserializer;

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

    public <T extends ApiResponse> T sendRequest(ApiRequest<T> request) {
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
