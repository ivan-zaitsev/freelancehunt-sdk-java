package com.github.ivan909020.freelancehunt.sdk.requests.get;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.get.GetMyProjectWorkspaceDetailsResponse;

public class GetMyProjectWorkspaceDetailsRequest extends GetApiRequest<GetMyProjectWorkspaceDetailsResponse> {

    private Long workspaceId;

    public GetMyProjectWorkspaceDetailsRequest() {
    }

    public GetMyProjectWorkspaceDetailsRequest setWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "my/workspaces/projects/" + workspaceId;
    }

    @Override
    public void validate() {
        super.validate();
        if (workspaceId == null) {
            throw new ApiValidationException("WorkspaceId parameter can't be empty");
        }
    }

    @Override
    public GetMyProjectWorkspaceDetailsResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetMyProjectWorkspaceDetailsResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
