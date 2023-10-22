package ua.ivanzaitsev.freelancehunt.sdk.responses.projects.workspaces;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivanzaitsev.freelancehunt.sdk.objects.entities.ProjectWorkspace;
import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;

public class GetMyProjectWorkspacesResponse extends ApiResponse {

    @JsonProperty("data")
    private List<ProjectWorkspace> projectWorkspaces;

    public List<ProjectWorkspace> getProjectWorkspaces() {
        return projectWorkspaces;
    }

}
