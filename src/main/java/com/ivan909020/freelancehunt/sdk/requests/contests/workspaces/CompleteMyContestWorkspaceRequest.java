package com.ivan909020.freelancehunt.sdk.requests.contests.workspaces;

import java.io.IOException;
import java.util.Map;

import com.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import com.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.ivan909020.freelancehunt.sdk.responses.contests.workspaces.CompleteMyContestWorkspaceResponse;

public class CompleteMyContestWorkspaceRequest extends PostApiRequest<CompleteMyContestWorkspaceResponse> {

    private Long workspaceId;
    private String comment;

    public CompleteMyContestWorkspaceRequest() {
    }

    public CompleteMyContestWorkspaceRequest setWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
        return this;
    }

    public CompleteMyContestWorkspaceRequest setComment(String comment) {
        this.comment = comment;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/my/workspaces/contests/" + workspaceId + "/complete";
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity(requestSerializer.serialize(buildBodyParameters()));
        }
        return httpEntity;
    }

    private Map<String, Object> buildBodyParameters() {
        return Map.of("comment", comment);
    }

    @Override
    public void validate() {
        super.validate();
        if (workspaceId == null) {
            throw new ApiValidationException("WorkspaceId parameter can't be empty");
        }
        if (comment == null) {
            throw new ApiValidationException("Comment parameter can't be empty");
        }
    }

    @Override
    public CompleteMyContestWorkspaceResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, CompleteMyContestWorkspaceResponse.class);
    }

}
