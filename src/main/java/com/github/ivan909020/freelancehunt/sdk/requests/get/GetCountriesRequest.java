package com.github.ivan909020.freelancehunt.sdk.requests.get;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.get.GetCountriesResponse;

public class GetCountriesRequest extends GetApiRequest<GetCountriesResponse> {

    public GetCountriesRequest() {
    }

    @Override
    public String getUrlPath() {
        return "countries";
    }

    @Override
    public GetCountriesResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetCountriesResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
