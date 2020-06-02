package com.github.ivan909020.freelancehunt.sdk.responses.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ivan909020.freelancehunt.sdk.objects.ContestWorkspace;
import com.github.ivan909020.freelancehunt.sdk.responses.ApiResponse;

import java.util.List;

public class GetMyContestWorkspacesResponse extends ApiResponse {

    @JsonProperty("data")
    private List<ContestWorkspace> contestWorkspaces;

    public GetMyContestWorkspacesResponse() {
    }

    public List<ContestWorkspace> getContestWorkspaces() {
        return contestWorkspaces;
    }

}
