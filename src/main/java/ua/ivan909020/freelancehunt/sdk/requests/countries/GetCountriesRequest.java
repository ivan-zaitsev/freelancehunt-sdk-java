package ua.ivan909020.freelancehunt.sdk.requests.countries;

import java.io.IOException;

import ua.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
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

    @Override
    public GetCountriesResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, GetCountriesResponse.class);
    }

}