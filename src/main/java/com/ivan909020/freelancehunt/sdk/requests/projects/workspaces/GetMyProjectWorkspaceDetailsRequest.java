package com.ivan909020.freelancehunt.sdk.requests.projects.workspaces;

import java.io.IOException;

import com.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import com.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.ivan909020.freelancehunt.sdk.responses.projects.workspaces.GetMyProjectWorkspaceDetailsResponse;

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
    public void validate() {
        super.validate();
        if (workspaceId == null) {
            throw new ApiValidationException("WorkspaceId parameter can't be empty");
        }
    }

    @Override
    public GetMyProjectWorkspaceDetailsResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, GetMyProjectWorkspaceDetailsResponse.class);
    }

}
