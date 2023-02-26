package ua.ivan909020.freelancehunt.sdk.requests.projects.workspaces;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.projects.workspaces.GetMyProjectWorkspaceDetailsResponse;

public class GetMyProjectWorkspaceDetailsRequest extends GetApiRequest<GetMyProjectWorkspaceDetailsResponse> {

    private Long workspaceId;

    public GetMyProjectWorkspaceDetailsRequest() {
    }

    public GetMyProjectWorkspaceDetailsRequest setWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/my/workspaces/projects/" + workspaceId;
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

}
