package ua.ivan909020.freelancehunt.sdk.responses.feed;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.entities.Feed;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;

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
