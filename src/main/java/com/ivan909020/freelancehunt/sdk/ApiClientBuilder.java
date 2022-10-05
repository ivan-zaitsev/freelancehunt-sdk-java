package com.ivan909020.freelancehunt.sdk;

import com.ivan909020.freelancehunt.sdk.configs.ApiConfig;
import com.ivan909020.freelancehunt.sdk.configs.HttpClientConfig;
import com.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.ivan909020.freelancehunt.sdk.iterceptors.DefaultHeadersRequestInterceptior;

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
        if (apiConfig == null) {
            throw new ApiValidationException("ApiConfig must not be null");
        }
    }

}
