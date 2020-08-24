package com.github.ivan909020.freelancehunt.sdk.requests.feed;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.feed.ReadMyFeedResponse;

public class ReadMyFeedRequest extends PostApiRequest<ReadMyFeedResponse> {

    public ReadMyFeedRequest() {
    }

    @Override
    public String getUrlPath() {
        return "my/feed/read";
    }

    @Override
    public ReadMyFeedResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, ReadMyFeedResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
