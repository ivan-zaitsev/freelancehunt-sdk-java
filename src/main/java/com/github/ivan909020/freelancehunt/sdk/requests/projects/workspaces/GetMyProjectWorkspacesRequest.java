package com.github.ivan909020.freelancehunt.sdk.requests.projects.workspaces;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.projects.workspaces.GetMyProjectWorkspacesResponse;

import java.util.HashMap;
import java.util.Map;

public class GetMyProjectWorkspacesRequest extends GetApiRequest<GetMyProjectWorkspacesResponse> {

    private Integer pageNumber;
    private Long projectId;

    public GetMyProjectWorkspacesRequest() {
    }

    public GetMyProjectWorkspacesRequest setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public GetMyProjectWorkspacesRequest setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "my/workspaces/projects";
    }

    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        if (pageNumber != null) {
            parameters.put("page[number]", pageNumber);
        }
        if (projectId != null) {
            parameters.put("filter[project_id]", projectId);
        }
        return parameters;
    }

    @Override
    public GetMyProjectWorkspacesResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetMyProjectWorkspacesResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
