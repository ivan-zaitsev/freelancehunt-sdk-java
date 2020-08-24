package com.github.ivan909020.freelancehunt.sdk.responses.profiles.reviews;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ivan909020.freelancehunt.sdk.objects.entities.Review;
import com.github.ivan909020.freelancehunt.sdk.responses.ApiResponse;

import java.util.List;

public class GetEmployerReviewsResponse extends ApiResponse {

    @JsonProperty("data")
    private List<Review> reviews;

    public GetEmployerReviewsResponse() {
    }

    public List<Review> getReviews() {
        return reviews;
    }

}
