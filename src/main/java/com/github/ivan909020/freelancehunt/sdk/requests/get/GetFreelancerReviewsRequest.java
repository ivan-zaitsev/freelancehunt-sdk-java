package com.github.ivan909020.freelancehunt.sdk.requests.get;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.get.GetFreelancerReviewsResponse;

import java.util.HashMap;
import java.util.Map;

public class GetFreelancerReviewsRequest extends GetApiRequest<GetFreelancerReviewsResponse> {

    private Integer pageNumber;
    private Long freelancerId;

    public GetFreelancerReviewsRequest() {
    }

    public GetFreelancerReviewsRequest setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public GetFreelancerReviewsRequest setFreelancerId(Long freelancerId) {
        this.freelancerId = freelancerId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "freelancers/" + freelancerId + "/reviews";
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
        if (freelancerId == null) {
            throw new ApiValidationException("FreelancerId parameter can't be empty");
        }
    }

    @Override
    public GetFreelancerReviewsResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetFreelancerReviewsResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
