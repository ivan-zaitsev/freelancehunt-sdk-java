package ua.ivanzaitsev.freelancehunt.sdk.requests.feed;

import ua.ivanzaitsev.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivanzaitsev.freelancehunt.sdk.requests.GetApiRequest;
import ua.ivanzaitsev.freelancehunt.sdk.responses.feed.GetMyFeedResponse;

public class GetMyFeedRequest extends GetApiRequest<GetMyFeedResponse> {

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

}
