package com.ivan909020.freelancehunt.sdk.responses.projects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ivan909020.freelancehunt.sdk.objects.entities.ProjectDetails;
import com.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class GetProjectDetailsResponse extends ApiResponse {

    @JsonProperty("data")
    private ProjectDetails project;

    public GetProjectDetailsResponse() {
    }

    public ProjectDetails getProject() {
        return project;
    }

}
