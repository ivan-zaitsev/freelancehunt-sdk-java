package com.ivan909020.freelancehunt.sdk.requests.projects.update;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import com.ivan909020.freelancehunt.sdk.objects.models.Budget;
import com.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.ivan909020.freelancehunt.sdk.responses.projects.update.AddProjectUpdateResponse;

public class AddProjectUpdateRequest extends PostApiRequest<AddProjectUpdateResponse> {

    private Long projectId;
    private Budget budget;
    private String updateHtml;
    private List<Integer> skills;

    public AddProjectUpdateRequest() {
    }

    public AddProjectUpdateRequest setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

    public AddProjectUpdateRequest setBudget(Budget budget) {
        this.budget = budget;
        return this;
    }

    public AddProjectUpdateRequest setUpdateHtml(String updateHtml) {
        this.updateHtml = updateHtml;
        return this;
    }

    public AddProjectUpdateRequest setSkills(List<Integer> skills) {
        this.skills = skills;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/projects/" + projectId + "/amend";
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity(requestSerializer.serialize(buildBodyParameters()));
        }
        return httpEntity;
    }

    private Map<String, Object> buildBodyParameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("budget", budget);
        parameters.put("update_html", updateHtml);
        parameters.put("skills", skills);
        return parameters;
    }

    @Override
    public void validate() {
        super.validate();
        if (projectId == null) {
            throw new ApiValidationException("ProjectId parameter can't be empty");
        }
        if (budget == null) {
            throw new ApiValidationException("Budget parameter can't be empty");
        }
        if (updateHtml == null) {
            throw new ApiValidationException("UpdateHtml parameter can't be empty");
        }
        if (skills == null || skills.isEmpty()) {
            throw new ApiValidationException("Skills parameter can't be empty");
        }
    }

    @Override
    public AddProjectUpdateResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, AddProjectUpdateResponse.class);
    }

}