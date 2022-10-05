package com.ivan909020.freelancehunt.sdk.responses.contests.workspaces;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ivan909020.freelancehunt.sdk.objects.entities.ContestWorkspace;
import com.ivan909020.freelancehunt.sdk.responses.ApiResponse;

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
