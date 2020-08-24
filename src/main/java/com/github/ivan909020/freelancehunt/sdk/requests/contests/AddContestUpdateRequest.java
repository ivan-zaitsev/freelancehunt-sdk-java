package com.github.ivan909020.freelancehunt.sdk.requests.contests;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.contests.AddContestUpdateResponse;

import java.util.Collections;
import java.util.Map;

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
        return "contests/" + contestId + "/amend";
    }

    @Override
    public Map<String, Object> getParameters() {
        return Collections.singletonMap("update_html", updateHtml);
    }

    @Override
    public void validate() {
        super.validate();
        if (contestId == null) {
            throw new ApiValidationException("ContestId parameter can't be empty");
        }
        if (updateHtml == null) {
            throw new ApiValidationException("UpdateHtml parameter can't be empty");
        }
    }

    @Override
    public AddContestUpdateResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, AddContestUpdateResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
