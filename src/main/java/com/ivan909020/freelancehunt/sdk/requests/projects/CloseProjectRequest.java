package com.ivan909020.freelancehunt.sdk.requests.projects;

import java.io.IOException;

import com.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import com.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.ivan909020.freelancehunt.sdk.responses.projects.CloseProjectResponse;

public class CloseProjectRequest extends PostApiRequest<CloseProjectResponse> {

    private Long projectId;

    public CloseProjectRequest() {
    }

    public CloseProjectRequest setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/projects/" + projectId + "/close";
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity();
        }
        return httpEntity;
    }

    @Override
    public void validate() {
        super.validate();
        if (projectId == null) {
            throw new ApiValidationException("ProjectId parameter can't be empty");
        }
    }

    @Override
    public CloseProjectResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, CloseProjectResponse.class);
    }

}
