package ua.ivan909020.freelancehunt.sdk.responses.projects;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.entities.ProjectDetails;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class GetOpenProjectsResponse extends ApiResponse {

    @JsonProperty("data")
    private List<ProjectDetails> projects;

    public List<ProjectDetails> getProjects() {
        return projects;
    }

}
