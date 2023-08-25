package ua.ivan909020.freelancehunt.sdk.responses.projects.create;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.entities.ProjectDetails;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class CreatePersonalProjectResponse extends ApiResponse {

    @JsonProperty("data")
    private ProjectDetails project;

    public ProjectDetails getProject() {
        return project;
    }

}
