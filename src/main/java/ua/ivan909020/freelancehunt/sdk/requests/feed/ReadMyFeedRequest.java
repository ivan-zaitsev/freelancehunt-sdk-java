package ua.ivan909020.freelancehunt.sdk.requests.feed;

import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.feed.ReadMyFeedResponse;

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

}
