package ua.ivan909020.freelancehunt.sdk.requests.projects.workspaces;

import java.io.IOException;
import java.util.Map;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.projects.workspaces.ExtendProjectWorkspaceExecutionResponse;

public class ExtendProjectWorkspaceExecutionRequest extends PostApiRequest<ExtendProjectWorkspaceExecutionResponse> {

    private Long workspaceId;
    private Integer days;

    public ExtendProjectWorkspaceExecutionRequest() {
    }

    public ExtendProjectWorkspaceExecutionRequest setWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
        return this;
    }

    public ExtendProjectWorkspaceExecutionRequest setDays(Integer days) {
        this.days = days;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/my/workspaces/projects/" + workspaceId + "/extend";
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity(requestSerializer.serialize(buildBodyParameters()));
        }
        return httpEntity;
    }

    private Map<String, Object> buildBodyParameters() {
        return Map.of("days", days);
    }

    @Override
    public void validate() {
        super.validate();
        if (workspaceId == null) {
            throw new ApiValidationException("WorkspaceId parameter can't be empty");
        }
        if (days == null) {
            throw new ApiValidationException("Days parameter can't be empty");
        }
    }

    @Override
    public ExtendProjectWorkspaceExecutionResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, ExtendProjectWorkspaceExecutionResponse.class);
    }

}
