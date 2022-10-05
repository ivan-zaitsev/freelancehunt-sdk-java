package com.ivan909020.freelancehunt.sdk.requests.profiles.reviews;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import com.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.ivan909020.freelancehunt.sdk.responses.profiles.reviews.GetFreelancerReviewsResponse;

public class GetFreelancerReviewsRequest extends GetApiRequest<GetFreelancerReviewsResponse> {

    private Integer pageNumber;
    private Long freelancerId;

    public GetFreelancerReviewsRequest() {
    }

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
    public void validate() {
        super.validate();
        if (freelancerId == null) {
            throw new ApiValidationException("FreelancerId parameter can't be empty");
        }
    }

    @Override
    public GetFreelancerReviewsResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, GetFreelancerReviewsResponse.class);
    }

}
