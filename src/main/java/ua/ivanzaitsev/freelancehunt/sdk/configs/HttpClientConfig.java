package ua.ivanzaitsev.freelancehunt.sdk.configs;

import java.util.ArrayList;
import java.util.List;

import ua.ivanzaitsev.freelancehunt.sdk.interceptors.ApiRequestInterceptior;

public class HttpClientConfig {

    private int connectionTimeout;
    private int socketTimeout;

    private List<ApiRequestInterceptior> interceptors = new ArrayList<>();

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

    public void addInterceptors(List<ApiRequestInterceptior> interceptors) {
        this.interceptors.addAll(interceptors);
    }

}
