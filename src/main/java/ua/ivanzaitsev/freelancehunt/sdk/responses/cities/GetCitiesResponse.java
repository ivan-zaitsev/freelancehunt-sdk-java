package ua.ivanzaitsev.freelancehunt.sdk.responses.cities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivanzaitsev.freelancehunt.sdk.objects.models.City;
import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;

public class GetCitiesResponse extends ApiResponse {

    @JsonProperty("data")
    private List<City> cities;

    public List<City> getCities() {
        return cities;
    }

}
