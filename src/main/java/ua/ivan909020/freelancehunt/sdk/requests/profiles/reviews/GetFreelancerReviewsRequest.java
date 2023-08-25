package ua.ivan909020.freelancehunt.sdk.requests.profiles.reviews;

import java.util.HashMap;
import java.util.Map;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.profiles.reviews.GetFreelancerReviewsResponse;

public class GetFreelancerReviewsRequest extends GetApiRequest<GetFreelancerReviewsResponse> {

    private Integer pageNumber;
    private Long freelancerId;

    public GetFreelancerReviewsRequest setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public GetFreelancerReviewsRequest setFreelancerId(Long freelancerId) {
        this.freelancerId = freelancerId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/freelancers/" + freelancerId + "/reviews";
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

    @Override
    protected void validate() {
        if (freelancerId == null) {
            throw new ApiValidationException("FreelancerId parameter can't be empty");
        }
    }

}
