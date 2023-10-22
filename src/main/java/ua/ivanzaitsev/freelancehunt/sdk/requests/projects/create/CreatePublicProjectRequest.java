package ua.ivanzaitsev.freelancehunt.sdk.requests.projects.create;

import static ua.ivanzaitsev.freelancehunt.sdk.utils.DateUtils.DATE_TIME_PATTERN;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.ivanzaitsev.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivanzaitsev.freelancehunt.sdk.objects.models.Budget;
import ua.ivanzaitsev.freelancehunt.sdk.objects.models.SafeType;
import ua.ivanzaitsev.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivanzaitsev.freelancehunt.sdk.requests.PostApiRequest;
import ua.ivanzaitsev.freelancehunt.sdk.responses.projects.create.CreatePublicProjectResponse;

public class CreatePublicProjectRequest extends PostApiRequest<CreatePublicProjectResponse> {

    private String name;
    private Budget budget;
    private SafeType safeType;
    private String descriptionHtml;
    private List<Integer> skills;
    private ZonedDateTime expiredAt;
    private List<String> tags;
    private Boolean isOnlyForPlus;

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

    public CreatePublicProjectRequest setIsOnlyForPlus(Boolean isOnlyForPlus) {
        this.isOnlyForPlus = isOnlyForPlus;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/projects";
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
    protected void validate() {
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

}
