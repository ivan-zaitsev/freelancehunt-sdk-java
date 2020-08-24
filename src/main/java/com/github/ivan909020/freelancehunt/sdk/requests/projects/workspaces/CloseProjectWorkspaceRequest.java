package com.github.ivan909020.freelancehunt.sdk.requests.projects.workspaces;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.projects.workspaces.CloseProjectWorkspaceResponse;

import java.util.Collections;
import java.util.Map;

public class CloseProjectWorkspaceRequest extends PostApiRequest<CloseProjectWorkspaceResponse> {

    private Long workspaceId;
    private String review;

    public CloseProjectWorkspaceRequest() {
    }

    public CloseProjectWorkspaceRequest setWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
        return this;
    }

    public CloseProjectWorkspaceRequest setReview(String review) {
        this.review = review;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "my/workspaces/projects/" + workspaceId + "/close";
    }

    @Override
    public Map<String, Object> getParameters() {
        return Collections.singletonMap("review", review);
    }

    @Override
    public void validate() {
        super.validate();
        if (workspaceId == null) {
            throw new ApiValidationException("WorkspaceId parameter can't be empty");
        }
        if (review == null) {
            throw new ApiValidationException("Review parameter can't be empty");
        }
    }

    @Override
    public CloseProjectWorkspaceResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, CloseProjectWorkspaceResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
