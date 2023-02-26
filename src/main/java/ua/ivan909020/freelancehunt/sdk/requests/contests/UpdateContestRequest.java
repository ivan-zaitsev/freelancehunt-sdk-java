package ua.ivan909020.freelancehunt.sdk.requests.contests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.models.Budget;
import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.requests.PatchApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.contests.UpdateContestResponse;

public class UpdateContestRequest extends PatchApiRequest<UpdateContestResponse> {

    private Long contestId;
    private String name;
    private Budget budget;
    private Integer durationDays;
    private String descriptionHtml;
    private Boolean isStockAllowed;
    private List<String> tags;

    public UpdateContestRequest() {
    }

    public UpdateContestRequest setContestId(Long contestId) {
        this.contestId = contestId;
        return this;
    }

    public UpdateContestRequest setName(String name) {
        this.name = name;
        return this;
    }

    public UpdateContestRequest setBudget(Budget budget) {
        this.budget = budget;
        return this;
    }

    public UpdateContestRequest setDurationDays(Integer durationDays) {
        this.durationDays = durationDays;
        return this;
    }

    public UpdateContestRequest setDescriptionHtml(String descriptionHtml) {
        this.descriptionHtml = descriptionHtml;
        return this;
    }

    public UpdateContestRequest setStockAllowed(Boolean isStockAllowed) {
        this.isStockAllowed = isStockAllowed;
        return this;
    }

    public UpdateContestRequest setTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/contests/" + contestId;
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
        parameters.put("duration_days", durationDays);
        parameters.put("description_html", descriptionHtml);
        if (isStockAllowed != null) {
            parameters.put("is_stock_allowed", isStockAllowed);
        }
        if (tags != null && !tags.isEmpty()) {
            parameters.put("tags", tags);
        }
        return parameters;
    }

    @Override
    protected void validate() {
        if (contestId == null) {
            throw new ApiValidationException("ContestId parameter can't be empty");
        }
        if (name == null) {
            throw new ApiValidationException("Name parameter can't be empty");
        }
        if (budget == null) {
            throw new ApiValidationException("Budget parameter can't be empty");
        }
        if (durationDays == null) {
            throw new ApiValidationException("DurationDays parameter can't be empty");
        }
        if (descriptionHtml == null) {
            throw new ApiValidationException("DescriptionHtml parameter can't be empty");
        }
    }

}
