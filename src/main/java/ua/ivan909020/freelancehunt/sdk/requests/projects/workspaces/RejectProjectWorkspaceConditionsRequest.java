package ua.ivan909020.freelancehunt.sdk.requests.projects.workspaces;

import java.io.IOException;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.projects.workspaces.RejectProjectWorkspaceConditionsResponse;

public class RejectProjectWorkspaceConditionsRequest extends PostApiRequest<RejectProjectWorkspaceConditionsResponse> {

    private Long workspaceId;

    public RejectProjectWorkspaceConditionsRequest() {
    }

    public RejectProjectWorkspaceConditionsRequest setWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/my/workspaces/projects/" + workspaceId + "/reject-conditions";
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity();
        }
        return httpEntity;
    }

    @Override
    protected void validate() {
        if (workspaceId == null) {
            throw new ApiValidationException("WorkspaceId parameter can't be empty");
        }
    }

    @Override
    protected RejectProjectWorkspaceConditionsResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, RejectProjectWorkspaceConditionsResponse.class);
    }

}
