package com.ivan909020.freelancehunt.sdk.requests.contests.workspaces;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import com.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.ivan909020.freelancehunt.sdk.responses.contests.workspaces.GetMyContestWorkspacesResponse;

public class GetMyContestWorkspacesRequest extends GetApiRequest<GetMyContestWorkspacesResponse> {

    private Integer pageNumber;
    private Long contestId;

    public GetMyContestWorkspacesRequest() {
    }

    public GetMyContestWorkspacesRequest setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public GetMyContestWorkspacesRequest setContestId(Long contestId) {
        this.contestId = contestId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/my/workspaces/contests";
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity();
            httpEntity.addUrlParameters(buildUrlParameters());
        }
        return httpEntity;
    }

    private Map<String, Object> buildUrlParameters() {
        Map<String, Object> parameters = new HashMap<>();
        if (pageNumber != null) {
            parameters.put("page[number]", pageNumber);
        }
        if (contestId != null) {
            parameters.put("filter[contest_id]", contestId);
        }
        return parameters;
    }

    @Override
    public GetMyContestWorkspacesResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, GetMyContestWorkspacesResponse.class);
    }

}
