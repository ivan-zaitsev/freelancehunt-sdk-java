package com.github.ivan909020.freelancehunt.sdk.requests.get;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.get.GetThreadsResponse;

import java.util.HashMap;
import java.util.Map;

public class GetThreadsRequest extends GetApiRequest<GetThreadsResponse> {

    private Integer pageNumber;

    public GetThreadsRequest() {
    }

    public GetThreadsRequest setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "threads";
    }

    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        if (pageNumber != null) {
            parameters.put("page[number]", pageNumber);
        }
        return parameters;
    }

    @Override
    public GetThreadsResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetThreadsResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
