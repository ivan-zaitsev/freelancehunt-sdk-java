package com.github.ivan909020.freelancehunt.sdk.requests.contests.workspaces;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.contests.workspaces.GetMyContestWorkspaceDetailsResponse;

public class GetMyContestWorkspaceDetailsRequest extends GetApiRequest<GetMyContestWorkspaceDetailsResponse> {

    private Long workspaceId;

    public GetMyContestWorkspaceDetailsRequest() {
    }

    public GetMyContestWorkspaceDetailsRequest setWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "my/workspaces/contests/" + workspaceId;
    }

    @Override
    public void validate() {
        super.validate();
        if (workspaceId == null) {
            throw new ApiValidationException("WorkspaceId parameter can't be empty");
        }
    }

    @Override
    public GetMyContestWorkspaceDetailsResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetMyContestWorkspaceDetailsResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
