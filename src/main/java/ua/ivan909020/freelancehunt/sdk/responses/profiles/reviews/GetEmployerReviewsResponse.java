package ua.ivan909020.freelancehunt.sdk.responses.profiles.reviews;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.entities.Review;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class GetEmployerReviewsResponse extends ApiResponse {

    @JsonProperty("data")
    private List<Review> reviews;

    public GetEmployerReviewsResponse() {
    }

    public List<Review> getReviews() {
        return reviews;
    }

}
