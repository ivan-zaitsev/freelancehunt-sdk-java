package com.github.ivan909020.freelancehunt.sdk.responses.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ivan909020.freelancehunt.sdk.objects.entities.Bid;
import com.github.ivan909020.freelancehunt.sdk.responses.ApiResponse;

import java.util.List;

public class GetMyFreelancerBidsResponse extends ApiResponse {

    @JsonProperty("data")
    private List<Bid> bids;

    public GetMyFreelancerBidsResponse() {
    }

    public List<Bid> getBids() {
        return bids;
    }

}
