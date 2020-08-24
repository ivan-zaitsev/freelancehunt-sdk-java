package com.github.ivan909020.freelancehunt.sdk.responses.projects.workspaces;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ivan909020.freelancehunt.sdk.objects.entities.ProjectWorkspace;
import com.github.ivan909020.freelancehunt.sdk.responses.ApiResponse;

import java.util.List;

public class GetMyProjectWorkspacesResponse extends ApiResponse {

    @JsonProperty("data")
    private List<ProjectWorkspace> projectWorkspaces;

    public GetMyProjectWorkspacesResponse() {
    }

    public List<ProjectWorkspace> getProjectWorkspaces() {
        return projectWorkspaces;
    }

}
