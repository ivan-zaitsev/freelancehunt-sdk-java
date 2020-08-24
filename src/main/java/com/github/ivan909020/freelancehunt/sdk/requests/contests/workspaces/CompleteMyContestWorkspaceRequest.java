package com.github.ivan909020.freelancehunt.sdk.requests.contests.workspaces;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.contests.workspaces.CompleteMyContestWorkspaceResponse;

import java.util.Collections;
import java.util.Map;

public class CompleteMyContestWorkspaceRequest extends PostApiRequest<CompleteMyContestWorkspaceResponse> {

    private Long workspaceId;
    private String comment;

    public CompleteMyContestWorkspaceRequest() {
    }

    public CompleteMyContestWorkspaceRequest setWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
        return this;
    }

    public CompleteMyContestWorkspaceRequest setComment(String comment) {
        this.comment = comment;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "my/workspaces/contests/" + workspaceId + "/complete";
    }

    @Override
    public Map<String, Object> getParameters() {
        return Collections.singletonMap("comment", comment);
    }

    @Override
    public void validate() {
        super.validate();
        if (workspaceId == null) {
            throw new ApiValidationException("WorkspaceId parameter can't be empty");
        }
        if (comment == null) {
            throw new ApiValidationException("Comment parameter can't be empty");
        }
    }

    @Override
    public CompleteMyContestWorkspaceResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, CompleteMyContestWorkspaceResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
