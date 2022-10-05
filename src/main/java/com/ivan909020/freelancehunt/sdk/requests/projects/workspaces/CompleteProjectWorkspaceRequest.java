package com.ivan909020.freelancehunt.sdk.requests.projects.workspaces;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import com.ivan909020.freelancehunt.sdk.objects.models.Grades;
import com.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.ivan909020.freelancehunt.sdk.responses.projects.workspaces.CompleteProjectWorkspaceResponse;

public class CompleteProjectWorkspaceRequest extends PostApiRequest<CompleteProjectWorkspaceResponse> {

    private Long workspaceId;
    private Grades grades;
    private String review;

    public CompleteProjectWorkspaceRequest() {
    }

    public CompleteProjectWorkspaceRequest setWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
        return this;
    }

    public CompleteProjectWorkspaceRequest setGrades(Grades grades) {
        this.grades = grades;
        return this;
    }

    public CompleteProjectWorkspaceRequest setReview(String review) {
        this.review = review;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/my/workspaces/projects/" + workspaceId + "/complete";
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
    public CompleteProjectWorkspaceResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, CompleteProjectWorkspaceResponse.class);
    }

}
