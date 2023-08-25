package ua.ivan909020.freelancehunt.sdk.requests.projects;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.projects.GetProjectDetailsResponse;

public class GetProjectDetailsRequest extends GetApiRequest<GetProjectDetailsResponse> {

    private Long projectId;

    public GetProjectDetailsRequest setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/projects/" + projectId;
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity();
        }
        return httpEntity;
    }

    @Override
    protected void validate() {
        if (projectId == null) {
            throw new ApiValidationException("ProjectId parameter can't be empty");
        }
    }

}
