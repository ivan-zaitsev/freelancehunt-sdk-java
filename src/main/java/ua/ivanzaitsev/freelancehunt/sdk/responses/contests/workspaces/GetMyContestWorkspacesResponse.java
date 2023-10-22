package ua.ivanzaitsev.freelancehunt.sdk.responses.contests.workspaces;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivanzaitsev.freelancehunt.sdk.objects.entities.ContestWorkspace;
import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;

public class GetMyContestWorkspacesResponse extends ApiResponse {

    @JsonProperty("data")
    private List<ContestWorkspace> contestWorkspaces;

    public List<ContestWorkspace> getContestWorkspaces() {
        return contestWorkspaces;
    }

}
