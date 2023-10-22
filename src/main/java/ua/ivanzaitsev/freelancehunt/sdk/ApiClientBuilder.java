package ua.ivanzaitsev.freelancehunt.sdk;

import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import ua.ivanzaitsev.freelancehunt.sdk.configs.ApiConfig;
import ua.ivanzaitsev.freelancehunt.sdk.configs.HttpClientConfig;
import ua.ivanzaitsev.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivanzaitsev.freelancehunt.sdk.interceptors.DefaultHeadersRequestInterceptior;
import ua.ivanzaitsev.freelancehunt.sdk.services.requests.RequestSerializerJson;
import ua.ivanzaitsev.freelancehunt.sdk.services.responses.ResponseDeserializerJson;

public class ApiClientBuilder {

    private ApiConfig apiConfig;
    private HttpClientConfig httpClientConfig;

    ApiClientBuilder() {
    }

    public ApiClientBuilder setApiConfig(ApiConfig apiConfig) {
        this.apiConfig = apiConfig;
        return this;
    }

    public ApiClientBuilder setHttpClientConfig(HttpClientConfig httpClientConfig) {
        this.httpClientConfig = httpClientConfig;
        return this;
    }

    public ApiClient build() {
        validate();

        addDefaultInterceptors();

        ObjectMapper objectMapper = buildObjectMapper();

        ApiClient apiClient = new ApiClient(apiConfig, httpClientConfig);
        apiClient.setRequestSerializer(new RequestSerializerJson(objectMapper));
        apiClient.setResponseDeserializer(new ResponseDeserializerJson(objectMapper));
        return apiClient;
    }

    private void validate() {
        if (apiConfig == null) {
            throw new ApiValidationException("ApiConfig must not be null");
        }
        if (httpClientConfig == null) {
            throw new ApiValidationException("HttpClientConfig must not be null");
        }
    }

    private void addDefaultInterceptors() {
        httpClientConfig.addInterceptors(List.of(new DefaultHeadersRequestInterceptior(apiConfig)));
    }

    private ObjectMapper buildObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.disable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }

}
