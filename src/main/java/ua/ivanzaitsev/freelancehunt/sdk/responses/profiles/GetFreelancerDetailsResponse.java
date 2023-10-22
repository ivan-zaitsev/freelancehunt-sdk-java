package ua.ivanzaitsev.freelancehunt.sdk.responses.profiles;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivanzaitsev.freelancehunt.sdk.objects.entities.UserDetails;
import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;

public class GetFreelancerDetailsResponse extends ApiResponse {

    @JsonProperty("data")
    private UserDetails freelancer;

    public UserDetails getFreelancer() {
        return freelancer;
    }

}
