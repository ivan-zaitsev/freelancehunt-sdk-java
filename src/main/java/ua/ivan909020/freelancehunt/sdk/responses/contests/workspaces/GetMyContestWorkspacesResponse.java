package ua.ivan909020.freelancehunt.sdk.responses.contests.workspaces;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.entities.ContestWorkspace;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;

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
