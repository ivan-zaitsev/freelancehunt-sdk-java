package ua.ivan909020.freelancehunt.sdk.requests.contests;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.contests.GetContestDetailsResponse;

public class GetContestDetailsRequest extends GetApiRequest<GetContestDetailsResponse> {

    private Long contestId;

    public GetContestDetailsRequest setContestId(Long contestId) {
        this.contestId = contestId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/contests/" + contestId;
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
        if (contestId == null) {
            throw new ApiValidationException("ContestId parameter can't be empty");
        }
    }

}
