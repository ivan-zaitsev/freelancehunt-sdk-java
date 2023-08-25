package ua.ivan909020.freelancehunt.sdk.responses.profiles;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.entities.UserDetails;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class GetEmployerDetailsResponse extends ApiResponse {

    @JsonProperty("data")
    private UserDetails employer;

    public UserDetails getEmployer() {
        return employer;
    }

}
