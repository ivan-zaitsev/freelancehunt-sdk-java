package com.github.ivan909020.freelancehunt.sdk.responses.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ivan909020.freelancehunt.sdk.objects.entities.UserDetails;
import com.github.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class GetEmployerDetailsResponse extends ApiResponse {

    @JsonProperty("data")
    private UserDetails employer;

    public GetEmployerDetailsResponse() {
    }

    public UserDetails getEmployer() {
        return employer;
    }

}
