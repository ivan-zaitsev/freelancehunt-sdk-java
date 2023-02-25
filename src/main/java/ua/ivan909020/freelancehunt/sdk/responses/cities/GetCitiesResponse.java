package ua.ivan909020.freelancehunt.sdk.responses.cities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.models.City;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class GetCitiesResponse extends ApiResponse {

    @JsonProperty("data")
    private List<City> cities;

    public GetCitiesResponse() {
    }

    public List<City> getCities() {
        return cities;
    }

}
