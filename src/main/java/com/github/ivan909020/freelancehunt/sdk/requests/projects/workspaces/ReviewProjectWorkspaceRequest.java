package com.github.ivan909020.freelancehunt.sdk.requests.projects.workspaces;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.objects.models.Grades;
import com.github.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.projects.workspaces.CompleteProjectWorkspaceResponse;

import java.util.HashMap;
import java.util.Map;

public class ReviewProjectWorkspaceRequest extends PostApiRequest<CompleteProjectWorkspaceResponse> {

    private Long workspaceId;
    private Grades grades;
    private String review;

    public ReviewProjectWorkspaceRequest() {
    }

    public ReviewProjectWorkspaceRequest setWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
        return this;
    }

    public ReviewProjectWorkspaceRequest setGrades(Grades grades) {
        this.grades = grades;
        return this;
    }

    public ReviewProjectWorkspaceRequest setReview(String review) {
        this.review = review;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "my/workspaces/projects/" + workspaceId + "/review";
    }

    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("grades", grades);
        parameters.put("review", review);
        return parameters;
    }

    @Override
    public void validate() {
        super.validate();
        if (workspaceId == null) {
            throw new ApiValidationException("WorkspaceId parameter can't be empty");
        }
        if (grades == null) {
            throw new ApiValidationException("Grades parameter can't be empty");
        }
        if (review == null) {
            throw new ApiValidationException("Review parameter can't be empty");
        }
    }

    @Override
    public CompleteProjectWorkspaceResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, CompleteProjectWorkspaceResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
