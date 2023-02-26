package ua.ivan909020.freelancehunt.sdk.requests.countries;

import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.countries.GetCountriesResponse;

public class GetCountriesRequest extends GetApiRequest<GetCountriesResponse> {

    public GetCountriesRequest() {
    }

    @Override
    public String getUrlPath() {
        return "/countries";
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity();
        }
        return httpEntity;
    }

}
