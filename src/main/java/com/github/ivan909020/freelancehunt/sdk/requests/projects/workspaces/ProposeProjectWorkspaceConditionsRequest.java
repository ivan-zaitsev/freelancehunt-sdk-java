package com.github.ivan909020.freelancehunt.sdk.requests.projects.workspaces;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.objects.models.Budget;
import com.github.ivan909020.freelancehunt.sdk.objects.models.SafeType;
import com.github.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.projects.workspaces.ProposeProjectWorkspaceConditionsResponse;

import java.util.HashMap;
import java.util.Map;

public class ProposeProjectWorkspaceConditionsRequest extends PostApiRequest<ProposeProjectWorkspaceConditionsResponse> {

    private Long workspaceId;
    private Integer days;
    private Budget budget;
    private SafeType safeType;
    private String comment;

    public ProposeProjectWorkspaceConditionsRequest() {
    }

    public ProposeProjectWorkspaceConditionsRequest setWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
        return this;
    }

    public ProposeProjectWorkspaceConditionsRequest setDays(Integer days) {
        this.days = days;
        return this;
    }

    public ProposeProjectWorkspaceConditionsRequest setBudget(Budget budget) {
        this.budget = budget;
        return this;
    }

    public ProposeProjectWorkspaceConditionsRequest setSafeType(SafeType safeType) {
        this.safeType = safeType;
        return this;
    }

    public ProposeProjectWorkspaceConditionsRequest setComment(String comment) {
        this.comment = comment;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "my/workspaces/projects/" + workspaceId + "/propose-conditions";
    }

    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("days", days);
        parameters.put("budget", budget);
        parameters.put("safe_type", safeType);
        parameters.put("comment", comment);
        return parameters;
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
        if (budget == null) {
            throw new ApiValidationException("Budget parameter can't be empty");
        }
        if (safeType == null) {
            throw new ApiValidationException("SafeType parameter can't be empty");
        }
        if (comment == null) {
            throw new ApiValidationException("Comment parameter can't be empty");
        }
    }

    @Override
    public ProposeProjectWorkspaceConditionsResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, ProposeProjectWorkspaceConditionsResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
