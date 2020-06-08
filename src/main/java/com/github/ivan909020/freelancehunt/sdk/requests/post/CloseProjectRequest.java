package com.github.ivan909020.freelancehunt.sdk.requests.post;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.post.CloseProjectResponse;

public class CloseProjectRequest extends PostApiRequest<CloseProjectResponse> {

    private Long projectId;

    public CloseProjectRequest() {
    }

    public CloseProjectRequest setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "projects/" + projectId + "/close";
    }

    @Override
    public void validate() {
        super.validate();
        if (projectId == null) {
            throw new ApiValidationException("ProjectId parameter can't be empty");
        }
    }

    @Override
    public CloseProjectResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, CloseProjectResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
