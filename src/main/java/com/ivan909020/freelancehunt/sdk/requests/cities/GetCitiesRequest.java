package com.ivan909020.freelancehunt.sdk.requests.cities;

import java.io.IOException;

import com.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import com.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.ivan909020.freelancehunt.sdk.responses.cities.GetCitiesResponse;

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
        return "/cities/" + countryId;
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity();
        }
        return httpEntity;
    }

    @Override
    public void validate() {
        super.validate();
        if (countryId == null) {
            throw new ApiValidationException("CountryId parameter can't be empty");
        }
    }

    @Override
    public GetCitiesResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, GetCitiesResponse.class);
    }

}
