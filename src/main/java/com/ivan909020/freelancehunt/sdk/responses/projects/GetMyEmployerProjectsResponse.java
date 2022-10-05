package com.ivan909020.freelancehunt.sdk.responses.projects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ivan909020.freelancehunt.sdk.objects.entities.ProjectDetails;
import com.ivan909020.freelancehunt.sdk.responses.ApiResponse;

import java.util.List;

public class GetMyEmployerProjectsResponse extends ApiResponse {

    @JsonProperty("data")
    private List<ProjectDetails> projects;

    public GetMyEmployerProjectsResponse() {
    }

    public List<ProjectDetails> getProjects() {
        return projects;
    }

}
