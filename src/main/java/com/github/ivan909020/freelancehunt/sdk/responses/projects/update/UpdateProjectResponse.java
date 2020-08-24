package com.github.ivan909020.freelancehunt.sdk.responses.projects.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ivan909020.freelancehunt.sdk.objects.entities.ProjectDetails;
import com.github.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class UpdateProjectResponse extends ApiResponse {

    @JsonProperty("data")
    private ProjectDetails project;

    public UpdateProjectResponse() {
    }

    public ProjectDetails getProject() {
        return project;
    }

}
