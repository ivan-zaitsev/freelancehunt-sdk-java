package ua.ivan909020.freelancehunt.sdk.requests.contests;

import java.util.Map;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.contests.AddContestUpdateResponse;

public class AddContestUpdateRequest extends PostApiRequest<AddContestUpdateResponse> {

    private Long contestId;
    private String updateHtml;

    public AddContestUpdateRequest() {
    }

    public AddContestUpdateRequest setContestId(Long contestId) {
        this.contestId = contestId;
        return this;
    }

    public AddContestUpdateRequest setUpdateHtml(String updateHtml) {
        this.updateHtml = updateHtml;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/contests/" + contestId + "/amend";
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity(requestSerializer.serialize(buildBodyParameters()));
        }
        return httpEntity;
    }

    private Map<String, Object> buildBodyParameters() {
        return Map.of("update_html", updateHtml);
    }

    @Override
    protected void validate() {
        if (contestId == null) {
            throw new ApiValidationException("ContestId parameter can't be empty");
        }
        if (updateHtml == null) {
            throw new ApiValidationException("UpdateHtml parameter can't be empty");
        }
    }

}
