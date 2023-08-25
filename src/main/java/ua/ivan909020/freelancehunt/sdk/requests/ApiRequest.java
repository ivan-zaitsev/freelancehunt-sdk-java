package ua.ivan909020.freelancehunt.sdk.requests;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;

import ua.ivan909020.freelancehunt.sdk.ApiClient;
import ua.ivan909020.freelancehunt.sdk.exceptions.ApiRequestException;
import ua.ivan909020.freelancehunt.sdk.objects.request.HttpRequest;
import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.objects.response.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;
import ua.ivan909020.freelancehunt.sdk.services.requests.RequestSerializer;
import ua.ivan909020.freelancehunt.sdk.services.responses.ResponseDeserializer;
import ua.ivan909020.freelancehunt.sdk.utils.RequestUtils;

public abstract class ApiRequest<T extends ApiResponse> {

    protected ApiClient apiClient;

    protected RequestSerializer requestSerializer;
    protected ResponseDeserializer responseDeserializer;

    protected HttpEntity httpEntity;

    protected ApiRequest() {
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public void setRequestSerializer(RequestSerializer requestSerializer) {
        this.requestSerializer = requestSerializer;
    }

    public void setResponseDeserializer(ResponseDeserializer responseDeserializer) {
        this.responseDeserializer = responseDeserializer;
    }

    public String getUrl() {
        String baseUrl = apiClient.getApiConfig().getBaseUrl();
        String urlParameters = RequestUtils.buildUrlParameters(httpEntity.getUrlParameters());
        return baseUrl + getUrlPath() + urlParameters;
    }

    public abstract String getMethod();

    public abstract String getUrlPath();

    public abstract HttpEntity getEntity();

    public boolean isWritable() {
        return false;
    }

    protected void writeRequest(HttpRequest request) throws IOException {
    }

    protected T deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, getResponseClass());
    }

    protected void validate() {
    }

    @SuppressWarnings("unchecked")
    protected Class<T> getResponseClass() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) type.getActualTypeArguments()[0];
    }

    public T execute() throws IOException {
        validate();

        RequestContext context = new RequestContext(this);
        RequestExecutionChain executionChain = new RequestExecutionChain(apiClient.getHttpClientConfig());

        try (HttpResponse response = executionChain.execute(context)) {
            return deserializeResponseInternal(response);
        }
    }

    private T deserializeResponseInternal(HttpResponse response) throws IOException {
        T result = deserializeResponse(response);

        if (result.getError() != null) {
            throw new ApiRequestException("Api response error", result.getError());
        }
        return result;
    }

}
