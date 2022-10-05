package com.ivan909020.freelancehunt.sdk.responses.profiles;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ivan909020.freelancehunt.sdk.objects.entities.UserDetails;
import com.ivan909020.freelancehunt.sdk.responses.ApiResponse;

import java.util.List;

public class GetFreelancersResponse extends ApiResponse {

    @JsonProperty("data")
    private List<UserDetails> freelancers;

    public GetFreelancersResponse() {
    }

    public List<UserDetails> getFreelancers() {
        return freelancers;
    }

}
