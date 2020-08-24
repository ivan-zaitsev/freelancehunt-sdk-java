package com.github.ivan909020.freelancehunt.sdk.requests.profiles.reviews;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.profiles.reviews.GetEmployerReviewsResponse;

import java.util.HashMap;
import java.util.Map;

public class GetEmployerReviewsRequest extends GetApiRequest<GetEmployerReviewsResponse> {

    private Integer pageNumber;
    private Long employerId;

    public GetEmployerReviewsRequest() {
    }

    public GetEmployerReviewsRequest setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public GetEmployerReviewsRequest setEmployerId(Long employerId) {
        this.employerId = employerId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "employers/" + employerId + "/reviews";
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
    public void validate() {
        super.validate();
        if (employerId == null) {
            throw new ApiValidationException("EmployerId parameter can't be empty");
        }
    }

    @Override
    public GetEmployerReviewsResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetEmployerReviewsResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
