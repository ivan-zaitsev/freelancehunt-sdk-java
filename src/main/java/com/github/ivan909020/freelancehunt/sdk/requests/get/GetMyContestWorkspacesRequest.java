package com.github.ivan909020.freelancehunt.sdk.requests.get;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.get.GetMyContestWorkspacesResponse;

import java.util.HashMap;
import java.util.Map;

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
        return "my/workspaces/contests";
    }

    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        if (pageNumber != null) {
            parameters.put("page[number]", pageNumber);
        }
        if (contestId != null) {
            parameters.put("contest_id", contestId);
        }
        return parameters;
    }

    @Override
    public GetMyContestWorkspacesResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetMyContestWorkspacesResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
