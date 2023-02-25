package ua.ivan909020.freelancehunt.sdk.requests.projects.workspaces;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.models.Budget;
import ua.ivan909020.freelancehunt.sdk.objects.models.SafeType;
import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.objects.response.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.projects.workspaces.ProposeProjectWorkspaceConditionsResponse;

public class ProposeProjectWorkspaceConditionsRequest
        extends PostApiRequest<ProposeProjectWorkspaceConditionsResponse> {

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

    @Override
    protected ProposeProjectWorkspaceConditionsResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, ProposeProjectWorkspaceConditionsResponse.class);
    }

}
