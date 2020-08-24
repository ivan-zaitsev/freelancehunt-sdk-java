package com.github.ivan909020.freelancehunt.sdk.requests.projects;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.projects.GetProjectDetailsResponse;

public class GetProjectDetailsRequest extends GetApiRequest<GetProjectDetailsResponse> {

    private Long projectId;

    public GetProjectDetailsRequest() {
    }

    public GetProjectDetailsRequest setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "projects/" + projectId;
    }

    @Override
    public void validate() {
        super.validate();
        if (projectId == null) {
            throw new ApiValidationException("ProjectId parameter can't be empty");
        }
    }

    @Override
    public GetProjectDetailsResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetProjectDetailsResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
