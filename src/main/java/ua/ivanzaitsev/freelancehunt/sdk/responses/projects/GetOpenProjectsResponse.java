package ua.ivanzaitsev.freelancehunt.sdk.responses.projects;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivanzaitsev.freelancehunt.sdk.objects.entities.ProjectDetails;
import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;

public class GetOpenProjectsResponse extends ApiResponse {

    @JsonProperty("data")
    private List<ProjectDetails> projects;

    public List<ProjectDetails> getProjects() {
        return projects;
    }

}
