package ua.ivan909020.freelancehunt.sdk.responses.profiles.reviews;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.entities.Review;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;

import java.util.List;

public class GetMyReviewsResponse extends ApiResponse {

    @JsonProperty("data")
    private List<Review> reviews;

    public GetMyReviewsResponse() {
    }

    public List<Review> getReviews() {
        return reviews;
    }

}
