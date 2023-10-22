package ua.ivanzaitsev.freelancehunt.sdk.responses.projects;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivanzaitsev.freelancehunt.sdk.objects.entities.ProjectDetails;
import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;

public class GetProjectDetailsResponse extends ApiResponse {

    @JsonProperty("data")
    private ProjectDetails project;

    public ProjectDetails getProject() {
        return project;
    }

}
