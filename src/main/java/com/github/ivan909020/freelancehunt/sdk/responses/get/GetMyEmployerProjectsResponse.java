package com.github.ivan909020.freelancehunt.sdk.responses.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ivan909020.freelancehunt.sdk.objects.entities.ProjectDetails;
import com.github.ivan909020.freelancehunt.sdk.responses.ApiResponse;

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
