package ua.ivan909020.freelancehunt.sdk.responses.profiles;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.entities.UserDetails;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class GetMyProfileResponse extends ApiResponse {

    @JsonProperty("data")
    private UserDetails profile;

    public GetMyProfileResponse() {
    }

    public UserDetails getProfile() {
        return profile;
    }

}
