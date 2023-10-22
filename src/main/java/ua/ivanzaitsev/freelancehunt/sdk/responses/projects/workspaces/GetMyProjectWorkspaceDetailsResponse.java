package ua.ivanzaitsev.freelancehunt.sdk.responses.projects.workspaces;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivanzaitsev.freelancehunt.sdk.objects.entities.ProjectWorkspace;
import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;

public class GetMyProjectWorkspaceDetailsResponse extends ApiResponse {

    @JsonProperty("data")
    private ProjectWorkspace projectWorkspace;

    public ProjectWorkspace getProjectWorkspace() {
        return projectWorkspace;
    }

}
