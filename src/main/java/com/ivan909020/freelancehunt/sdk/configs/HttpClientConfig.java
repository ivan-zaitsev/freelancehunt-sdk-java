package com.ivan909020.freelancehunt.sdk.configs;

import java.util.ArrayList;
import java.util.List;

import com.ivan909020.freelancehunt.sdk.iterceptors.ApiRequestInterceptior;

public class HttpClientConfig {

    private int connectionTimeout;

    private int socketTimeout;

    private List<ApiRequestInterceptior> interceptors = new ArrayList<>();

    public HttpClientConfig() {
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public List<ApiRequestInterceptior> getInterceptors() {
        return interceptors;
    }

    public void setInterceptors(List<ApiRequestInterceptior> interceptors) {
        this.interceptors = interceptors;
    }

}
