package ua.ivan909020.freelancehunt.sdk.requests;

import java.io.IOException;

import ua.ivan909020.freelancehunt.sdk.ApiClient;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpRequest;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
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

    public abstract boolean isWritable();

    public abstract String getMethod();

    public abstract String getUrlPath();

    public abstract HttpEntity getEntity();

    public String getUrl() {
        String baseUrl = apiClient.getApiConfig().getBaseUrl() + getUrlPath();
        String urlPath = getUrlPath();
        String urlParameters = RequestUtils.buildUrlParameters(getEntity().getUrlParameters());

        return baseUrl + urlPath + urlParameters;
    }

    protected abstract void writeRequest(HttpRequest request) throws IOException;

    protected abstract T deserializeResponse(HttpResponse response) throws IOException;

    protected void validate() {

    }

    public T execute() throws IOException {
        validate();

        RequestExecutionChain executionChain = new RequestExecutionChain(apiClient.getHttpClientConfig());

        HttpResponse response = executionChain.execute(this);
        return deserializeResponse(response);
    }

}
