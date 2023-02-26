package ua.ivan909020.freelancehunt.sdk.requests.cities;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.cities.GetCitiesResponse;

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
    protected void validate() {
        if (countryId == null) {
            throw new ApiValidationException("CountryId parameter can't be empty");
        }
    }

}
