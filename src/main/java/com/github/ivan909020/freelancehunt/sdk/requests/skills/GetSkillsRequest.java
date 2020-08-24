package com.github.ivan909020.freelancehunt.sdk.requests.skills;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.skills.GetSkillsResponse;

public class GetSkillsRequest extends GetApiRequest<GetSkillsResponse> {

    public GetSkillsRequest() {
    }

    @Override
    public String getUrlPath() {
        return "skills";
    }

    @Override
    public GetSkillsResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetSkillsResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
