package com.github.ivan909020.freelancehunt.sdk.responses.countries;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ivan909020.freelancehunt.sdk.objects.models.Country;
import com.github.ivan909020.freelancehunt.sdk.responses.ApiResponse;

import java.util.List;

public class GetCountriesResponse extends ApiResponse {

    @JsonProperty("data")
    private List<Country> countries;

    public GetCountriesResponse() {
    }

    public List<Country> getCountries() {
        return countries;
    }

}
