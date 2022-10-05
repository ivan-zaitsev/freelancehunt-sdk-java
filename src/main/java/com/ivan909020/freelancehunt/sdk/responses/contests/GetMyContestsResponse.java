package com.ivan909020.freelancehunt.sdk.responses.contests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ivan909020.freelancehunt.sdk.objects.entities.ContestDetails;
import com.ivan909020.freelancehunt.sdk.responses.ApiResponse;

import java.util.List;

public class GetMyContestsResponse extends ApiResponse {

    @JsonProperty("data")
    private List<ContestDetails> contests;

    public GetMyContestsResponse() {
    }

    public List<ContestDetails> getContests() {
        return contests;
    }

}
