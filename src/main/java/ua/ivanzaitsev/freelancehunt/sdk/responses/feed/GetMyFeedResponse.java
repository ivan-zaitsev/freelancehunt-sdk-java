package ua.ivanzaitsev.freelancehunt.sdk.responses.feed;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivanzaitsev.freelancehunt.sdk.objects.entities.Feed;
import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;

public class GetMyFeedResponse extends ApiResponse {

    @JsonProperty("data")
    private List<Feed> feeds;

    public List<Feed> getFeeds() {
        return feeds;
    }

}
