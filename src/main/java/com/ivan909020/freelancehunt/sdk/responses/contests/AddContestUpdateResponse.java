package com.ivan909020.freelancehunt.sdk.responses.contests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ivan909020.freelancehunt.sdk.objects.entities.ContestDetails;
import com.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class AddContestUpdateResponse extends ApiResponse {

    @JsonProperty("data")
    private ContestDetails contest;

    public AddContestUpdateResponse() {
    }

    public ContestDetails getContest() {
        return contest;
    }

}
