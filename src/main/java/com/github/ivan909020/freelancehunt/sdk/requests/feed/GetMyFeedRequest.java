package com.github.ivan909020.freelancehunt.sdk.requests.feed;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.feed.GetMyFeedResponse;

public class GetMyFeedRequest extends GetApiRequest<GetMyFeedResponse> {

    public GetMyFeedRequest() {
    }

    @Override
    public String getUrlPath() {
        return "my/feed";
    }

    @Override
    public GetMyFeedResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetMyFeedResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
