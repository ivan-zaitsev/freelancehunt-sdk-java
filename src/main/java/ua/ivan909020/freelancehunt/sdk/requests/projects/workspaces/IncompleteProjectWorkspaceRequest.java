package ua.ivan909020.freelancehunt.sdk.requests.projects.workspaces;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.objects.models.Grades;
import ua.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.projects.workspaces.IncompleteProjectWorkspaceResponse;

public class IncompleteProjectWorkspaceRequest extends PostApiRequest<IncompleteProjectWorkspaceResponse> {

    private Long workspaceId;
    private Grades grades;
    private String review;

    public IncompleteProjectWorkspaceRequest() {
    }

    public IncompleteProjectWorkspaceRequest setWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
        return this;
    }

    public IncompleteProjectWorkspaceRequest setGrades(Grades grades) {
        this.grades = grades;
        return this;
    }

    public IncompleteProjectWorkspaceRequest setReview(String review) {
        this.review = review;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/my/workspaces/projects/" + workspaceId + "/incomplete";
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
    protected void validate() {
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
    protected IncompleteProjectWorkspaceResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, IncompleteProjectWorkspaceResponse.class);
    }

}
