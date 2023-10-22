package ua.ivanzaitsev.freelancehunt.sdk.requests.projects.bids;

import java.util.HashMap;
import java.util.Map;

import ua.ivanzaitsev.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivanzaitsev.freelancehunt.sdk.objects.models.Budget;
import ua.ivanzaitsev.freelancehunt.sdk.objects.models.SafeType;
import ua.ivanzaitsev.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivanzaitsev.freelancehunt.sdk.requests.PostApiRequest;
import ua.ivanzaitsev.freelancehunt.sdk.responses.projects.bids.AddProjectBidResponse;

public class AddProjectBidRequest extends PostApiRequest<AddProjectBidResponse> {

    private Long projectId;
    private Integer days;
    private Budget budget;
    private SafeType safeType;
    private String comment;
    private Boolean isHidden;

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

    public AddProjectBidRequest setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
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

}
