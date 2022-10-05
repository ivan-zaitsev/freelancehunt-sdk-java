package com.ivan909020.freelancehunt.sdk.requests.projects.workspaces;

import java.io.IOException;

import com.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import com.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.ivan909020.freelancehunt.sdk.responses.projects.workspaces.AcceptProjectWorkspaceConditionsResponse;

public class AcceptProjectWorkspaceConditionsRequest extends PostApiRequest<AcceptProjectWorkspaceConditionsResponse> {

    private Long workspaceId;

    public AcceptProjectWorkspaceConditionsRequest() {
    }

    public AcceptProjectWorkspaceConditionsRequest setWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/my/workspaces/projects/" + workspaceId + "/accept-conditions";
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
    public AcceptProjectWorkspaceConditionsResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, AcceptProjectWorkspaceConditionsResponse.class);
    }

}
