package com.ivan909020.freelancehunt.sdk.requests;

import java.io.IOException;

import com.ivan909020.freelancehunt.sdk.ApiClient;
import com.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpRequest;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import com.ivan909020.freelancehunt.sdk.services.requests.RequestBuilder;
import com.ivan909020.freelancehunt.sdk.services.requests.RequestSerializer;
import com.ivan909020.freelancehunt.sdk.services.responses.ResponseDeserializer;

public abstract class ApiRequest<T> {

    protected ApiClient apiClient;

    protected RequestBuilder requestBuilder;
    protected RequestSerializer requestSerializer;
    protected ResponseDeserializer responseDeserializer;

    protected RequestExecutionChain requestExecutor;
    protected HttpEntity httpEntity;

    protected ApiRequest() {
    }

    public void itilialize(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.requestBuilder = new RequestBuilder();
        this.requestSerializer = new RequestSerializer(apiClient.getObjectMapperConfig().getObjectMapper());
        this.responseDeserializer = new ResponseDeserializer(apiClient.getObjectMapperConfig().getObjectMapper());
        this.requestExecutor = new RequestExecutionChain(apiClient.getHttpClientConfig());
    }

    public abstract boolean isWritable();
    
    public abstract String getMethod();

    public abstract String getUrlPath();

    public abstract HttpEntity getEntity();

    public abstract void writeRequest(HttpRequest request) throws IOException;

    public abstract T deserializeResponse(HttpResponse response) throws IOException;

    public String getUrl() {
        return apiClient.getApiConfig().getBaseUrl() + getUrlPath();
    }

    public void validate() {
        if (apiClient == null) {
            throw new ApiValidationException("ApiClient must not be NULL");
        }
    }

    public T execute() throws IOException {
        validate();

        HttpResponse response = requestExecutor.execute(this);
        return deserializeResponse(response);
    }

}
