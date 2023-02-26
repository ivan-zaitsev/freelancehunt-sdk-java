package ua.ivan909020.freelancehunt.sdk.requests.feed;

import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.feed.GetMyFeedResponse;

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

}
