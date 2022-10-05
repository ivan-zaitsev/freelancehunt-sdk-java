package com.ivan909020.freelancehunt.sdk.requests.feed;

import java.io.IOException;

import com.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import com.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.ivan909020.freelancehunt.sdk.responses.feed.GetMyFeedResponse;

public class GetMyFeedRequest extends GetApiRequest<GetMyFeedResponse> {

    public GetMyFeedRequest() {
    }

    @Override
    public String getUrlPath() {
        return "/my/feed";
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity();
        }
        return httpEntity;
    }

    @Override
    public GetMyFeedResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, GetMyFeedResponse.class);
    }

}
