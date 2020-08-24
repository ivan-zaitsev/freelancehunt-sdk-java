package com.github.ivan909020.freelancehunt.sdk.requests.projects.workspaces;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.projects.workspaces.RejectProjectWorkspaceConditionsResponse;

public class RejectProjectWorkspaceConditionsRequest extends PostApiRequest<RejectProjectWorkspaceConditionsResponse> {

    private Long workspaceId;

    public RejectProjectWorkspaceConditionsRequest() {
    }

    public RejectProjectWorkspaceConditionsRequest setWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "my/workspaces/projects/" + workspaceId + "/reject-conditions";
    }

    @Override
    public void validate() {
        super.validate();
        if (workspaceId == null) {
            throw new ApiValidationException("WorkspaceId parameter can't be empty");
        }
    }

    @Override
    public RejectProjectWorkspaceConditionsResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, RejectProjectWorkspaceConditionsResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
