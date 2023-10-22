package ua.ivanzaitsev.freelancehunt.sdk.responses.contests.workspaces;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivanzaitsev.freelancehunt.sdk.objects.entities.ContestWorkspace;
import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;

public class GetMyContestWorkspaceDetailsResponse extends ApiResponse {

    @JsonProperty("data")
    private ContestWorkspace contestWorkspace;

    public ContestWorkspace getContestWorkspace() {
        return contestWorkspace;
    }

}
