package com.ivan909020.freelancehunt.sdk.requests.feed;

import java.io.IOException;

import com.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import com.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.ivan909020.freelancehunt.sdk.responses.feed.ReadMyFeedResponse;

public class ReadMyFeedRequest extends PostApiRequest<ReadMyFeedResponse> {

    public ReadMyFeedRequest() {
    }

    @Override
    public String getUrlPath() {
        return "/my/feed/read";
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity();
        }
        return httpEntity;
    }

    @Override
    public ReadMyFeedResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, ReadMyFeedResponse.class);
    }

}
