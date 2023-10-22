package ua.ivanzaitsev.freelancehunt.sdk.requests.projects.workspaces;

import java.util.HashMap;
import java.util.Map;

import ua.ivanzaitsev.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivanzaitsev.freelancehunt.sdk.objects.models.Budget;
import ua.ivanzaitsev.freelancehunt.sdk.objects.models.SafeType;
import ua.ivanzaitsev.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivanzaitsev.freelancehunt.sdk.requests.PostApiRequest;
import ua.ivanzaitsev.freelancehunt.sdk.responses.projects.workspaces.ProposeProjectWorkspaceConditionsResponse;

public class ProposeProjectWorkspaceConditionsRequest
        extends PostApiRequest<ProposeProjectWorkspaceConditionsResponse> {

    private Long workspaceId;
    private Integer days;
    private Budget budget;
    private SafeType safeType;
    private String comment;

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
        return "/my/workspaces/projects/" + workspaceId + "/propose-conditions";
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity(requestSerializer.serialize(buildBodyParameters()));
        }
        return httpEntity;
    }

    private Map<String, Object> buildBodyParameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("days", days);
        parameters.put("budget", budget);
        parameters.put("safe_type", safeType);
        parameters.put("comment", comment);
        return parameters;
    }

    @Override
    protected void validate() {
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

}
