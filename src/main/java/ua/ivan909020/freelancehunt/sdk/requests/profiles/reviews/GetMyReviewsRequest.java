package ua.ivan909020.freelancehunt.sdk.requests.profiles.reviews;

import java.util.HashMap;
import java.util.Map;

import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.profiles.reviews.GetMyReviewsResponse;

public class GetMyReviewsRequest extends GetApiRequest<GetMyReviewsResponse> {

    private Integer pageNumber;

    public GetMyReviewsRequest setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/my/reviews";
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity();
            httpEntity.addUrlParameters(buildUrlParameters());
        }
        return httpEntity;
    }

    private Map<String, Object> buildUrlParameters() {
        Map<String, Object> parameters = new HashMap<>();
        if (pageNumber != null) {
            parameters.put("page[number]", pageNumber);
        }
        return parameters;
    }

}
