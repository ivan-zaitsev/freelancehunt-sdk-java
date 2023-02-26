package ua.ivan909020.freelancehunt.sdk.requests.projects.create;

import static ua.ivan909020.freelancehunt.sdk.utils.DateUtils.DATE_TIME_PATTERN;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.models.Budget;
import ua.ivan909020.freelancehunt.sdk.objects.models.SafeType;
import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.projects.create.CreatePersonalProjectResponse;

public class CreatePersonalProjectRequest extends PostApiRequest<CreatePersonalProjectResponse> {

    private String name;
    private Long freelancerId;
    private Boolean isPersonal;
    private Budget budget;
    private SafeType safeType;
    private String descriptionHtml;
    private List<Integer> skills;
    private ZonedDateTime expiredAt;
    private List<String> tags;

    public CreatePersonalProjectRequest() {
    }

    public CreatePersonalProjectRequest setName(String name) {
        this.name = name;
        return this;
    }

    public CreatePersonalProjectRequest setFreelancerId(Long freelancerId) {
        this.freelancerId = freelancerId;
        return this;
    }

    public CreatePersonalProjectRequest setPersonal(Boolean personal) {
        isPersonal = personal;
        return this;
    }

    public CreatePersonalProjectRequest setBudget(Budget budget) {
        this.budget = budget;
        return this;
    }

    public CreatePersonalProjectRequest setSafeType(SafeType safeType) {
        this.safeType = safeType;
        return this;
    }

    public CreatePersonalProjectRequest setDescriptionHtml(String descriptionHtml) {
        this.descriptionHtml = descriptionHtml;
        return this;
    }

    public CreatePersonalProjectRequest setSkills(List<Integer> skills) {
        this.skills = skills;
        return this;
    }

    public CreatePersonalProjectRequest setExpiredAt(ZonedDateTime expiredAt) {
        this.expiredAt = expiredAt;
        return this;
    }

    public CreatePersonalProjectRequest setTags(List<String> tags) {
        this.tags = tags;
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
        parameters.put("freelancer_id", freelancerId);
        parameters.put("is_personal", isPersonal);
        parameters.put("budget", budget);
        parameters.put("safe_type", String.valueOf(safeType).toLowerCase());
        parameters.put("description_html", descriptionHtml);
        parameters.put("skills", skills);
        parameters.put("expired_at", expiredAt.format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)));
        if (tags != null && !tags.isEmpty()) {
            parameters.put("tags", tags);
        }
        return parameters;
    }

    @Override
    protected void validate() {
        if (name == null) {
            throw new ApiValidationException("Name parameter can't be empty");
        }
        if (freelancerId == null) {
            throw new ApiValidationException("FreelancerId parameter can't be empty");
        }
        if (isPersonal == null) {
            throw new ApiValidationException("IsPersonal parameter can't be empty");
        }
        if (budget == null) {
            throw new ApiValidationException("Budget parameter can't be empty");
        }
        if (safeType == null) {
            throw new ApiValidationException("SafeType parameter can't be empty");
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
