package com.github.ivan909020.freelancehunt.sdk.responses.contests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ivan909020.freelancehunt.sdk.objects.entities.ContestDetails;
import com.github.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class UpdateContestResponse extends ApiResponse {

    @JsonProperty("data")
    private ContestDetails contest;

    public UpdateContestResponse() {
    }

    public ContestDetails getContest() {
        return contest;
    }

}
