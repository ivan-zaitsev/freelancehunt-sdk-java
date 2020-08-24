package com.github.ivan909020.freelancehunt.sdk.requests.profiles;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.profiles.GetFreelancerDetailsResponse;

public class GetFreelancerDetailsRequest extends GetApiRequest<GetFreelancerDetailsResponse> {

    private Long freelancerId;

    public GetFreelancerDetailsRequest() {
    }

    public GetFreelancerDetailsRequest setFreelancerId(Long freelancerId) {
        this.freelancerId = freelancerId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "freelancers/" + freelancerId;
    }

    @Override
    public void validate() {
        super.validate();
        if (freelancerId == null) {
            throw new ApiValidationException("FreelancerId parameter can't be empty");
        }
    }

    @Override
    public GetFreelancerDetailsResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetFreelancerDetailsResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
