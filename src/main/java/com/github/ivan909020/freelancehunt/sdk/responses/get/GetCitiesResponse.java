package com.github.ivan909020.freelancehunt.sdk.responses.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ivan909020.freelancehunt.sdk.objects.models.City;
import com.github.ivan909020.freelancehunt.sdk.responses.ApiResponse;

import java.util.List;

public class GetCitiesResponse extends ApiResponse {

    @JsonProperty("data")
    private List<City> cities;

    public GetCitiesResponse() {
    }

    public List<City> getCities() {
        return cities;
    }

}
