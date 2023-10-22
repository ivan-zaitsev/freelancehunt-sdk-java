package ua.ivanzaitsev.freelancehunt.sdk.responses.countries;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivanzaitsev.freelancehunt.sdk.objects.models.Country;
import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;

public class GetCountriesResponse extends ApiResponse {

    @JsonProperty("data")
    private List<Country> countries;

    public List<Country> getCountries() {
        return countries;
    }

}
