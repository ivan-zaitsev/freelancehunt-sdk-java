package ua.ivan909020.freelancehunt.sdk.responses.profiles;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.entities.UserDetails;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class GetEmployersResponse extends ApiResponse {

    @JsonProperty("data")
    private List<UserDetails> employers;

    public List<UserDetails> getEmployers() {
        return employers;
    }

}
