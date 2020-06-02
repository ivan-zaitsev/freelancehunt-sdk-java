package com.github.ivan909020.freelancehunt.sdk.requests.get;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.get.GetCitiesResponse;

public class GetCitiesRequest extends GetApiRequest<GetCitiesResponse> {

    private Long countryId;

    public GetCitiesRequest() {
    }

    public GetCitiesRequest setCountryId(Long countryId) {
        this.countryId = countryId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "cities/" + countryId;
    }

    @Override
    public void validate() {
        super.validate();
        if (countryId == null) {
            throw new ApiValidationException("CountryId parameter can't be empty");
        }
    }

    @Override
    public GetCitiesResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetCitiesResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
