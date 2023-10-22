package ua.ivanzaitsev.freelancehunt.sdk.responses.profiles;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivanzaitsev.freelancehunt.sdk.objects.entities.UserDetails;
import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;

public class GetEmployersResponse extends ApiResponse {

    @JsonProperty("data")
    private List<UserDetails> employers;

    public List<UserDetails> getEmployers() {
        return employers;
    }

}
