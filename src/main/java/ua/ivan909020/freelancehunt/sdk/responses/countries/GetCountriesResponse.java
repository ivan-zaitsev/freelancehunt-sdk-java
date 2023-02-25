package ua.ivan909020.freelancehunt.sdk.responses.countries;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.models.Country;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class GetCountriesResponse extends ApiResponse {

    @JsonProperty("data")
    private List<Country> countries;

    public GetCountriesResponse() {
    }

    public List<Country> getCountries() {
        return countries;
    }

}
