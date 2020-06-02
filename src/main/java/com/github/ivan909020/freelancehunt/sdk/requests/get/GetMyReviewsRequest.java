package com.github.ivan909020.freelancehunt.sdk.requests.get;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.get.GetMyReviewsResponse;

import java.util.HashMap;
import java.util.Map;

public class GetMyReviewsRequest extends GetApiRequest<GetMyReviewsResponse> {

    private Integer pageNumber;

    public GetMyReviewsRequest() {
    }

    public GetMyReviewsRequest setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "my/reviews";
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
    public GetMyReviewsResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetMyReviewsResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
