package ua.ivan909020.freelancehunt.sdk;

import ua.ivan909020.freelancehunt.sdk.configs.ApiConfig;
import ua.ivan909020.freelancehunt.sdk.configs.HttpClientConfig;
import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.interceptors.DefaultHeadersRequestInterceptior;

public class ApiClientBuilder {

    private ApiConfig apiConfig;
    private HttpClientConfig httpClientConfig;

    public ApiClientBuilder() {
    }

    public void setApiConfig(ApiConfig apiConfig) {
        this.apiConfig = apiConfig;
    }
    
    public void setHttpClientConfig(HttpClientConfig httpClientConfig) {
        this.httpClientConfig = httpClientConfig;
    }

    public ApiClient build() {
        validate();
        
        addDefaultInterceptors();
        
        return new ApiClient(apiConfig, httpClientConfig);
    }
    
    private void addDefaultInterceptors() {
        httpClientConfig.getInterceptors().add(new DefaultHeadersRequestInterceptior(apiConfig));
    }

    private void validate() {
        if (apiConfig == null) {
            throw new ApiValidationException("ApiConfig must not be null");
        }
        if (httpClientConfig == null) {
            throw new ApiValidationException("HttpClientConfig must not be null");
        }
    }

}
