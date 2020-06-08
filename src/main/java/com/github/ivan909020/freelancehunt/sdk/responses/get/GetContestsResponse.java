package com.github.ivan909020.freelancehunt.sdk.responses.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ivan909020.freelancehunt.sdk.objects.entities.ContestDetails;
import com.github.ivan909020.freelancehunt.sdk.responses.ApiResponse;

import java.util.List;

public class GetContestsResponse extends ApiResponse {

    @JsonProperty("data")
    private List<ContestDetails> contests;

    public GetContestsResponse() {
    }

    public List<ContestDetails> getContests() {
        return contests;
    }

}
