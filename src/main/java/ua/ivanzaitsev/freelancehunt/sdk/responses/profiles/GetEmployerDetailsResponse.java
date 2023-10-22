package ua.ivanzaitsev.freelancehunt.sdk.responses.profiles;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivanzaitsev.freelancehunt.sdk.objects.entities.UserDetails;
import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;

public class GetEmployerDetailsResponse extends ApiResponse {

    @JsonProperty("data")
    private UserDetails employer;

    public UserDetails getEmployer() {
        return employer;
    }

}
