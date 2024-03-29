package ua.ivanzaitsev.freelancehunt.sdk.requests.contests.workspaces;

import java.util.Map;

import ua.ivanzaitsev.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivanzaitsev.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivanzaitsev.freelancehunt.sdk.requests.PostApiRequest;
import ua.ivanzaitsev.freelancehunt.sdk.responses.contests.workspaces.CompleteMyContestWorkspaceResponse;

public class CompleteMyContestWorkspaceRequest extends PostApiRequest<CompleteMyContestWorkspaceResponse> {

    private Long workspaceId;
    private String comment;

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
    protected void validate() {
        if (workspaceId == null) {
            throw new ApiValidationException("WorkspaceId parameter can't be empty");
        }
        if (comment == null) {
            throw new ApiValidationException("Comment parameter can't be empty");
        }
    }

}
