package com.ivan909020.freelancehunt.sdk.responses.projects.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ivan909020.freelancehunt.sdk.objects.entities.ProjectDetails;
import com.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class CreatePublicProjectResponse extends ApiResponse {

    @JsonProperty("data")
    private ProjectDetails project;

    public CreatePublicProjectResponse() {
    }

    public ProjectDetails getProject() {
        return project;
    }

}
