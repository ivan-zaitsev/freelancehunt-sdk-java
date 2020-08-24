package com.github.ivan909020.freelancehunt.sdk.responses.projects.workspaces;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ivan909020.freelancehunt.sdk.objects.entities.ProjectWorkspace;
import com.github.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class GetMyProjectWorkspaceDetailsResponse extends ApiResponse {

    @JsonProperty("data")
    private ProjectWorkspace projectWorkspace;

    public GetMyProjectWorkspaceDetailsResponse() {
    }

    public ProjectWorkspace getProjectWorkspace() {
        return projectWorkspace;
    }

}
