package ua.ivan909020.freelancehunt.sdk.requests.projects.workspaces;

import java.io.IOException;
import java.util.Map;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.projects.workspaces.CloseProjectWorkspaceResponse;

public class CloseProjectWorkspaceRequest extends PostApiRequest<CloseProjectWorkspaceResponse> {

    private Long workspaceId;
    private String review;

    public CloseProjectWorkspaceRequest() {
    }

    public CloseProjectWorkspaceRequest setWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
        return this;
    }

    public CloseProjectWorkspaceRequest setReview(String review) {
        this.review = review;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/my/workspaces/projects/" + workspaceId + "/close";
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity(requestSerializer.serialize(buildBodyParameters()));
        }
        return httpEntity;
    }

    private Map<String, Object> buildBodyParameters() {
        return Map.of("review", review);
    }

    @Override
    public void validate() {
        super.validate();
        if (workspaceId == null) {
            throw new ApiValidationException("WorkspaceId parameter can't be empty");
        }
        if (review == null) {
            throw new ApiValidationException("Review parameter can't be empty");
        }
    }

    @Override
    public CloseProjectWorkspaceResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, CloseProjectWorkspaceResponse.class);
    }

}
