package ua.ivan909020.freelancehunt.sdk.requests.contests.workspaces;

import java.io.IOException;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.contests.workspaces.GetMyContestWorkspaceDetailsResponse;

public class GetMyContestWorkspaceDetailsRequest extends GetApiRequest<GetMyContestWorkspaceDetailsResponse> {

    private Long workspaceId;

    public GetMyContestWorkspaceDetailsRequest() {
    }

    public GetMyContestWorkspaceDetailsRequest setWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/my/workspaces/contests/" + workspaceId;
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
    protected GetMyContestWorkspaceDetailsResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, GetMyContestWorkspaceDetailsResponse.class);
    }

}
