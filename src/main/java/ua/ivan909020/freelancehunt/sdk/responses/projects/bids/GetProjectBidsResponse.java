package ua.ivan909020.freelancehunt.sdk.responses.projects.bids;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.entities.Bid;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class GetProjectBidsResponse extends ApiResponse {

    @JsonProperty("data")
    private List<Bid> bids;

    public List<Bid> getBids() {
        return bids;
    }

}
