package com.github.ivan909020.freelancehunt.sdk.responses.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ivan909020.freelancehunt.sdk.objects.Country;
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
