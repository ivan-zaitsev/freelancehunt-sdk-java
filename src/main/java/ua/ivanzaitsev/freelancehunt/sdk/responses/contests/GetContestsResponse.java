package ua.ivanzaitsev.freelancehunt.sdk.responses.contests;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivanzaitsev.freelancehunt.sdk.objects.entities.ContestDetails;
import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;

public class GetContestsResponse extends ApiResponse {

    @JsonProperty("data")
    private List<ContestDetails> contests;

    public List<ContestDetails> getContests() {
        return contests;
    }

}
