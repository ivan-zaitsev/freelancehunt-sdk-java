package com.github.ivan909020.freelancehunt.sdk.client;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HttpTransportClient {

    private static final String USER_AGENT = "freelancehunt-sdk-java/1.0.0";

    private static final int CONNECTION_TIMEOUT_MS = 10_000;
    private static final int SOCKET_TIMEOUT_MS = 60_000;

    private final CloseableHttpClient httpClient;

    public HttpTransportClient() {
        this.httpClient = buildHttpClient();
    }

    private CloseableHttpClient buildHttpClient() {
        return HttpClientBuilder.create()
                .setUserAgent(USER_AGENT)
                .setDefaultCookieStore(createCookieStore())
                .setDefaultRequestConfig(buildRequestConfig())
                .build();
    }

    private CookieStore createCookieStore() {
        return new BasicCookieStore();
    }

    private RequestConfig buildRequestConfig() {
        return RequestConfig.custom()
                .setCookieSpec(CookieSpecs.STANDARD)
                .setConnectionRequestTimeout(CONNECTION_TIMEOUT_MS)
                .setConnectTimeout(CONNECTION_TIMEOUT_MS)
                .setSocketTimeout(SOCKET_TIMEOUT_MS)
                .build();
    }

    public String execute(HttpRequestBase request) {
        String response = "{}";
        try (CloseableHttpResponse httpResponse = httpClient.execute(request)) {
            if (httpResponse.getEntity() != null) {
                response = EntityUtils.toString(httpResponse.getEntity(), StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            throw new ApiException("Error execute http request", e);
        }
        return response;
    }

}
