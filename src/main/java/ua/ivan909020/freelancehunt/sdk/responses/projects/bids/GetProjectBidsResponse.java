package ua.ivan909020.freelancehunt.sdk.responses.projects.bids;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.entities.Bid;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;

import java.util.List;

public class GetProjectBidsResponse extends ApiResponse {

    @JsonProperty("data")
    private List<Bid> bids;

    public GetProjectBidsResponse() {
    }

    public List<Bid> getBids() {
        return bids;
    }

}
