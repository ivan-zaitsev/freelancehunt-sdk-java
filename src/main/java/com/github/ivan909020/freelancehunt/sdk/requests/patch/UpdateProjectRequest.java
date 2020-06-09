package com.github.ivan909020.freelancehunt.sdk.requests.patch;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.objects.models.Budget;
import com.github.ivan909020.freelancehunt.sdk.objects.models.SafeType;
import com.github.ivan909020.freelancehunt.sdk.requests.PatchApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.patch.UpdateProjectResponse;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.github.ivan909020.freelancehunt.sdk.client.ObjectMapperConfig.DATE_TIME_PATTERN;

public class UpdateProjectRequest extends PatchApiRequest<UpdateProjectResponse> {

    private Long projectId;
    private String name;
    private Budget budget;
    private SafeType safeType;
    private String descriptionHtml;
    private List<Integer> skills;
    private ZonedDateTime expiredAt;
    private List<String> tags;

    public UpdateProjectRequest() {
    }

    public UpdateProjectRequest setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

    public UpdateProjectRequest setName(String name) {
        this.name = name;
        return this;
    }

    public UpdateProjectRequest setBudget(Budget budget) {
        this.budget = budget;
        return this;
    }

    public UpdateProjectRequest setSafeType(SafeType safeType) {
        this.safeType = safeType;
        return this;
    }

    public UpdateProjectRequest setDescriptionHtml(String descriptionHtml) {
        this.descriptionHtml = descriptionHtml;
        return this;
    }

    public UpdateProjectRequest setSkills(List<Integer> skills) {
        this.skills = skills;
        return this;
    }

    public UpdateProjectRequest setExpiredAt(ZonedDateTime expiredAt) {
        this.expiredAt = expiredAt;
        return this;
    }

    public UpdateProjectRequest setTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "projects/" + projectId;
    }

    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", name);
        parameters.put("budget", budget);
        parameters.put("safe_type", safeType);
        parameters.put("description_html", descriptionHtml);
        parameters.put("skills", skills);
        parameters.put("expired_at", expiredAt.format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)));
        if (tags != null && !tags.isEmpty()) {
            parameters.put("tags", tags);
        }
        return parameters;
    }

    @Override
    public void validate() {
        super.validate();
        if (projectId == null) {
            throw new ApiValidationException("ProjectId parameter can't be empty");
        }
        if (name == null) {
            throw new ApiValidationException("Name parameter can't be empty");
        }
        if (budget == null) {
            throw new ApiValidationException("Budget parameter can't be empty");
        }
        if (descriptionHtml == null) {
            throw new ApiValidationException("DescriptionHtml parameter can't be empty");
        }
        if (skills == null || skills.isEmpty()) {
            throw new ApiValidationException("Skills parameter can't be empty");
        }
        if (expiredAt == null) {
            throw new ApiValidationException("ExpiredAt parameter can't be empty");
        }
    }

    @Override
    public UpdateProjectResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, UpdateProjectResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
