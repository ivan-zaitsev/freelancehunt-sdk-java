package com.github.ivan909020.freelancehunt.sdk.requests.projects.create;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.objects.models.Budget;
import com.github.ivan909020.freelancehunt.sdk.objects.models.SafeType;
import com.github.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.projects.create.CreatePublicProjectResponse;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.github.ivan909020.freelancehunt.sdk.client.ObjectMapperConfig.DATE_TIME_PATTERN;

public class CreatePublicProjectRequest extends PostApiRequest<CreatePublicProjectResponse> {

    private String name;
    private Budget budget;
    private SafeType safeType;
    private String descriptionHtml;
    private List<Integer> skills;
    private ZonedDateTime expiredAt;
    private List<String> tags;
    private Boolean isOnlyForPlus;

    public CreatePublicProjectRequest() {
    }

    public CreatePublicProjectRequest setName(String name) {
        this.name = name;
        return this;
    }

    public CreatePublicProjectRequest setBudget(Budget budget) {
        this.budget = budget;
        return this;
    }

    public CreatePublicProjectRequest setSafeType(SafeType safeType) {
        this.safeType = safeType;
        return this;
    }

    public CreatePublicProjectRequest setDescriptionHtml(String descriptionHtml) {
        this.descriptionHtml = descriptionHtml;
        return this;
    }

    public CreatePublicProjectRequest setSkills(List<Integer> skills) {
        this.skills = skills;
        return this;
    }

    public CreatePublicProjectRequest setExpiredAt(ZonedDateTime expiredAt) {
        this.expiredAt = expiredAt;
        return this;
    }

    public CreatePublicProjectRequest setTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public CreatePublicProjectRequest setOnlyForPlus(Boolean isOnlyForPlus) {
        this.isOnlyForPlus = isOnlyForPlus;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "projects";
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
        if (isOnlyForPlus != null) {
            parameters.put("is_only_for_plus", isOnlyForPlus);
        }
        return parameters;
    }

    @Override
    public void validate() {
        super.validate();
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
    public CreatePublicProjectResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, CreatePublicProjectResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
