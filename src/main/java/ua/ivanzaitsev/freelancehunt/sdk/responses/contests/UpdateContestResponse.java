package ua.ivanzaitsev.freelancehunt.sdk.responses.contests;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivanzaitsev.freelancehunt.sdk.objects.entities.ContestDetails;
import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;

public class UpdateContestResponse extends ApiResponse {

    @JsonProperty("data")
    private ContestDetails contest;

    public ContestDetails getContest() {
        return contest;
    }

}
