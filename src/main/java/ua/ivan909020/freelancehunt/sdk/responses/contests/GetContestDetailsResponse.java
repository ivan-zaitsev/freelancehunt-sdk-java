package ua.ivan909020.freelancehunt.sdk.responses.contests;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.entities.ContestDetails;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class GetContestDetailsResponse extends ApiResponse {

    @JsonProperty("data")
    private ContestDetails contest;

    public ContestDetails getContest() {
        return contest;
    }

}
