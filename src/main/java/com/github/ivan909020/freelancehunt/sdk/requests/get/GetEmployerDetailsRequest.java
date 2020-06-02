package com.github.ivan909020.freelancehunt.sdk.requests.get;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.get.GetEmployerDetailsResponse;

public class GetEmployerDetailsRequest extends GetApiRequest<GetEmployerDetailsResponse> {

    private Long employerId;

    public GetEmployerDetailsRequest() {
    }

    public GetEmployerDetailsRequest setEmployerId(Long employerId) {
        this.employerId = employerId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "employers/" + employerId;
    }

    @Override
    public void validate() {
        super.validate();
        if (employerId == null) {
            throw new ApiValidationException("EmployerId parameter can't be empty");
        }
    }

    @Override
    public GetEmployerDetailsResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetEmployerDetailsResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
