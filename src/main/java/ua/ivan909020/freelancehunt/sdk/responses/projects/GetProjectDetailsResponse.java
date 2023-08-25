package ua.ivan909020.freelancehunt.sdk.responses.projects;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.entities.ProjectDetails;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class GetProjectDetailsResponse extends ApiResponse {

    @JsonProperty("data")
    private ProjectDetails project;

    public ProjectDetails getProject() {
        return project;
    }

}
