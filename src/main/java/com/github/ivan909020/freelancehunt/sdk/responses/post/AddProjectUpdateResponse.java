package com.github.ivan909020.freelancehunt.sdk.responses.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ivan909020.freelancehunt.sdk.objects.entities.ProjectDetails;
import com.github.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class AddProjectUpdateResponse extends ApiResponse {

    @JsonProperty("data")
    private ProjectDetails project;

    public AddProjectUpdateResponse() {
    }

    public ProjectDetails getProject() {
        return project;
    }

}
