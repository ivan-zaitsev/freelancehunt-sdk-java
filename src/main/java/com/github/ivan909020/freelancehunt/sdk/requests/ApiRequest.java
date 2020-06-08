package com.github.ivan909020.freelancehunt.sdk.requests;

import com.github.ivan909020.freelancehunt.sdk.FreelancehuntApi;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiRequestException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.responses.ApiResponse;
import org.apache.http.client.methods.HttpRequestBase;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class ApiRequest<T> {

    private FreelancehuntApi api;

    public ApiRequest() {
    }

    public FreelancehuntApi getApi() {
        return api;
    }

    public void setApi(FreelancehuntApi api) {
        this.api = api;
    }

    public abstract T execute();

    public String getUrl() {
        return FreelancehuntApi.API_URL + getUrlPath();
    }

    public abstract String getUrlPath();

    public Map<String, Object> getParameters() {
        return new HashMap<>();
    }

    public void validate() {
        if (api == null) {
            throw new ApiValidationException("Freelancehunt api must not be NULL");
        }
    }

    public void setHeaders(HttpRequestBase request) {
        request.setHeader("Authorization", "Bearer " + getApi().getToken());
    }

    public abstract T deserializeResponse(String responseContent);

    public <U extends ApiResponse> U deserializeResponse(String responseContent, Class<U> responseClass) {
        U response;
        try {
            response = api.getObjectMapperConfig().getObjectMapper().readValue(responseContent, responseClass);
        } catch (IOException e) {
            throw new ApiRequestException("Failed to deserialize response", e);
        }
        if (response.getError() != null) {
            throw new ApiRequestException("Api response error", response.getError());
        }
        return response;
    }

}
