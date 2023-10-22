package ua.ivanzaitsev.freelancehunt.sdk.responses.profiles.reviews;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivanzaitsev.freelancehunt.sdk.objects.entities.Review;
import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;

public class GetMyReviewsResponse extends ApiResponse {

    @JsonProperty("data")
    private List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

}
