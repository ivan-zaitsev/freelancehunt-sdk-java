package com.github.ivan909020.freelancehunt.sdk;

import com.github.ivan909020.freelancehunt.sdk.client.HttpTransportClient;
import com.github.ivan909020.freelancehunt.sdk.client.ResponseDeserializer;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiRequestException;
import com.github.ivan909020.freelancehunt.sdk.requests.ApiRequest;

public class FreelancehuntApi {

    public static final String API_URL = "https://api.freelancehunt.com/v2/";

    private final String token;
    private final HttpTransportClient transportClient;
    private final ResponseDeserializer responseDeserializer;

    public FreelancehuntApi(String token) {
        this.token = token;
        this.transportClient = new HttpTransportClient();
        this.responseDeserializer = new ResponseDeserializer();
    }

    public String getToken() {
        return token;
    }

    public HttpTransportClient getTransportClient() {
        return transportClient;
    }

    public ResponseDeserializer getResponseDeserializer() {
        return responseDeserializer;
    }

    public <T> T sendRequest(ApiRequest<T> request) throws ApiRequestException {
        request.setApi(this);
        return request.execute();
    }

}
