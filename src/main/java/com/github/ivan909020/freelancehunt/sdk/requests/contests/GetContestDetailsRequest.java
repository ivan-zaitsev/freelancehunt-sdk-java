package com.github.ivan909020.freelancehunt.sdk.requests.contests;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.contests.GetContestDetailsResponse;

public class GetContestDetailsRequest extends GetApiRequest<GetContestDetailsResponse> {

    private Long contestId;

    public GetContestDetailsRequest() {
    }

    public GetContestDetailsRequest setContestId(Long contestId) {
        this.contestId = contestId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "contests/" + contestId;
    }

    @Override
    public void validate() {
        super.validate();
        if (contestId == null) {
            throw new ApiValidationException("ContestId parameter can't be empty");
        }
    }

    @Override
    public GetContestDetailsResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetContestDetailsResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
