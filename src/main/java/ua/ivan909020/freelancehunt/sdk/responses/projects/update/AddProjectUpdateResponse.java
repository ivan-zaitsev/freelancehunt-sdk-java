package ua.ivan909020.freelancehunt.sdk.responses.projects.update;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.entities.ProjectDetails;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class AddProjectUpdateResponse extends ApiResponse {

    @JsonProperty("data")
    private ProjectDetails project;

    public ProjectDetails getProject() {
        return project;
    }

}
