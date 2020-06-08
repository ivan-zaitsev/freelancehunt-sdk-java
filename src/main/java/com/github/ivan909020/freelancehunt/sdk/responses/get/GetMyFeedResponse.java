package com.github.ivan909020.freelancehunt.sdk.responses.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ivan909020.freelancehunt.sdk.objects.entities.Feed;
import com.github.ivan909020.freelancehunt.sdk.responses.ApiResponse;

import java.util.List;

public class GetMyFeedResponse extends ApiResponse {

    @JsonProperty("data")
    private List<Feed> feeds;

    public GetMyFeedResponse() {
    }

    public List<Feed> getFeeds() {
        return feeds;
    }

}
