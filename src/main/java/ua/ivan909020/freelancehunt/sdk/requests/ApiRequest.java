package ua.ivan909020.freelancehunt.sdk.requests;

import java.io.IOException;

import ua.ivan909020.freelancehunt.sdk.ApiClient;
import ua.ivan909020.freelancehunt.sdk.objects.request.HttpRequest;
import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.objects.response.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.services.requests.RequestSerializer;
import ua.ivan909020.freelancehunt.sdk.services.responses.ResponseDeserializer;
import ua.ivan909020.freelancehunt.sdk.utils.RequestUtils;

public abstract class ApiRequest<T> {

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
        String baseUrl = apiClient.getApiConfig().getBaseUrl() + getUrlPath();
        String urlPath = getUrlPath();
        String urlParameters = RequestUtils.buildUrlParameters(httpEntity.getUrlParameters());

        return baseUrl + urlPath + urlParameters;
    }

    public abstract boolean isWritable();

    public abstract String getMethod();

    public abstract String getUrlPath();

    public abstract HttpEntity getEntity();

    protected abstract void writeRequest(HttpRequest request) throws IOException;

    protected abstract T deserializeResponse(HttpResponse response) throws IOException;

    protected void validate() {

    }

    public T execute() throws IOException {
        validate();

        RequestContext context = new RequestContext(this);
        RequestExecutionChain executionChain = new RequestExecutionChain(apiClient.getHttpClientConfig());

        try (HttpResponse response = executionChain.execute(context)) {
            return deserializeResponse(response);
        }
    }

}
