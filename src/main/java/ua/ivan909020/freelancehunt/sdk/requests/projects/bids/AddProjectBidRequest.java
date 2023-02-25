package ua.ivan909020.freelancehunt.sdk.requests.projects.bids;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.objects.models.Budget;
import ua.ivan909020.freelancehunt.sdk.objects.models.SafeType;
import ua.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.projects.bids.AddProjectBidResponse;

public class AddProjectBidRequest extends PostApiRequest<AddProjectBidResponse> {

    private Long projectId;
    private Integer days;
    private Budget budget;
    private SafeType safeType;
    private String comment;
    private Boolean isHidden;

    public AddProjectBidRequest() {
    }

    public AddProjectBidRequest setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

    public AddProjectBidRequest setDays(Integer days) {
        this.days = days;
        return this;
    }

    public AddProjectBidRequest setBudget(Budget budget) {
        this.budget = budget;
        return this;
    }

    public AddProjectBidRequest setSafeType(SafeType safeType) {
        this.safeType = safeType;
        return this;
    }

    public AddProjectBidRequest setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public AddProjectBidRequest setHidden(Boolean hidden) {
        isHidden = hidden;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/projects/" + projectId + "/bids";
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
        parameters.put("is_hidden", isHidden);
        return parameters;
    }

    @Override
    protected void validate() {
        if (projectId == null) {
            throw new ApiValidationException("ProjectId parameter can't be empty");
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
        if (isHidden == null) {
            throw new ApiValidationException("IsHidden parameter can't be empty");
        }
    }

    @Override
    protected AddProjectBidResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, AddProjectBidResponse.class);
    }

}
