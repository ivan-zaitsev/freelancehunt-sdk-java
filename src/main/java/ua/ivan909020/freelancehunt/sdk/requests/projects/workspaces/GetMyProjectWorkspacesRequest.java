package ua.ivan909020.freelancehunt.sdk.requests.projects.workspaces;

import java.util.HashMap;
import java.util.Map;

import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.projects.workspaces.GetMyProjectWorkspacesResponse;

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
        return "/my/workspaces/projects";
    }
    
    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity();
            httpEntity.addUrlParameters(buildUrlParameters());
        }
        return httpEntity;
    }

    private Map<String, Object> buildUrlParameters() {
        Map<String, Object> parameters = new HashMap<>();
        if (pageNumber != null) {
            parameters.put("page[number]", pageNumber);
        }
        if (projectId != null) {
            parameters.put("filter[project_id]", projectId);
        }
        return parameters;
    }

}
