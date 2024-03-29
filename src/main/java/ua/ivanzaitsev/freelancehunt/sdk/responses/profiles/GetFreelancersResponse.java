package ua.ivanzaitsev.freelancehunt.sdk.responses.profiles;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivanzaitsev.freelancehunt.sdk.objects.entities.UserDetails;
import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;

public class GetFreelancersResponse extends ApiResponse {

    @JsonProperty("data")
    private List<UserDetails> freelancers;

    public List<UserDetails> getFreelancers() {
        return freelancers;
    }

}
