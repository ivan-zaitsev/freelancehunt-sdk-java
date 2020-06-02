package com.github.ivan909020.freelancehunt.sdk.responses.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ivan909020.freelancehunt.sdk.objects.UserDetails;
import com.github.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class GetFreelancerDetailsResponse extends ApiResponse {

    @JsonProperty("data")
    private UserDetails freelancer;

    public GetFreelancerDetailsResponse() {
    }

    public UserDetails getFreelancer() {
        return freelancer;
    }

}
