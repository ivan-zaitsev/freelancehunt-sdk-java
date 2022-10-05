package com.ivan909020.freelancehunt.sdk.responses.cities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ivan909020.freelancehunt.sdk.objects.models.City;
import com.ivan909020.freelancehunt.sdk.responses.ApiResponse;

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
