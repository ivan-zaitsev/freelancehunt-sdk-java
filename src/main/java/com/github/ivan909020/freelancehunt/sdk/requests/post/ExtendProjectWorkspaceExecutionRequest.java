package com.github.ivan909020.freelancehunt.sdk.requests.post;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.post.ExtendProjectWorkspaceExecutionResponse;

import java.util.Collections;
import java.util.Map;

public class ExtendProjectWorkspaceExecutionRequest extends PostApiRequest<ExtendProjectWorkspaceExecutionResponse> {

    private Long workspaceId;
    private Integer days;

    public ExtendProjectWorkspaceExecutionRequest() {
    }

    public ExtendProjectWorkspaceExecutionRequest setWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
        return this;
    }

    public ExtendProjectWorkspaceExecutionRequest setDays(Integer days) {
        this.days = days;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "my/workspaces/projects/" + workspaceId + "/extend";
    }

    @Override
    public Map<String, Object> getParameters() {
        return Collections.singletonMap("days", days);
    }

    @Override
    public void validate() {
        super.validate();
        if (workspaceId == null) {
            throw new ApiValidationException("WorkspaceId parameter can't be empty");
        }
        if (days == null) {
            throw new ApiValidationException("Days parameter can't be empty");
        }
    }

    @Override
    public ExtendProjectWorkspaceExecutionResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, ExtendProjectWorkspaceExecutionResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
