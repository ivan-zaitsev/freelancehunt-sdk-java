package com.github.ivan909020.freelancehunt.sdk.requests.profiles;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.profiles.GetMyProfileResponse;

public class GetMyProfileRequest extends GetApiRequest<GetMyProfileResponse> {

    public GetMyProfileRequest() {
    }

    @Override
    public String getUrlPath() {
        return "my/profile";
    }

    @Override
    public GetMyProfileResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetMyProfileResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
