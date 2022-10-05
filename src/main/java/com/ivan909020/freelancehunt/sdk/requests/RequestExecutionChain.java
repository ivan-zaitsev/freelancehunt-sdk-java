package com.ivan909020.freelancehunt.sdk.requests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import com.ivan909020.freelancehunt.sdk.configs.HttpClientConfig;
import com.ivan909020.freelancehunt.sdk.iterceptors.ApiRequestInterceptior;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpRequest;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;

public class RequestExecutionChain {

    private final HttpClientConfig httpClientConfig;

    private final Iterator<ApiRequestInterceptior> interceptors;

    public RequestExecutionChain(HttpClientConfig httpClientConfig) {
        this.httpClientConfig = httpClientConfig;
        this.interceptors = httpClientConfig.getInterceptors().iterator();
    }

    public HttpResponse execute(ApiRequest<?> request) throws IOException {
        if (interceptors.hasNext()) {
            return interceptors.next().process(this, request);
        } else {
            return executeInternal(request);
        }
    }

    private HttpResponse executeInternal(ApiRequest<?> request) throws IOException {
        URL url = new URL(request.getUrl());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setDoInput(true);
        connection.setDoOutput(request.isWritable());
        connection.setRequestMethod(request.getMethod());
        connection.setConnectTimeout(httpClientConfig.getConnectionTimeout());
        connection.setReadTimeout(httpClientConfig.getSocketTimeout());

        request.getEntity().getHeaders().forEach(connection::addRequestProperty);
        request.writeRequest(new HttpRequest(connection));

        return new HttpResponse(connection);
    }

}
