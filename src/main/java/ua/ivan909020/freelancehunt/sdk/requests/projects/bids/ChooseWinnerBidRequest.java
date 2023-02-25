package ua.ivan909020.freelancehunt.sdk.requests.projects.bids;

import java.io.IOException;
import java.util.Map;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.projects.bids.ChooseWinnerBidResponse;

public class ChooseWinnerBidRequest extends PostApiRequest<ChooseWinnerBidResponse> {

    private Long projectId;
    private Long bidId;
    private String comment;

    public ChooseWinnerBidRequest() {
    }

    public ChooseWinnerBidRequest setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

    public ChooseWinnerBidRequest setBidId(Long bidId) {
        this.bidId = bidId;
        return this;
    }

    public ChooseWinnerBidRequest setComment(String comment) {
        this.comment = comment;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/projects/" + projectId + "/bids/" + bidId + "/reject";
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity(requestSerializer.serialize(buildBodyParameters()));
        }
        return httpEntity;
    }

    private Map<String, Object> buildBodyParameters() {
        return Map.of("comment", comment);
    }

    @Override
    protected void validate() {
        if (projectId == null) {
            throw new ApiValidationException("ProjectId parameter can't be empty");
        }
        if (bidId == null) {
            throw new ApiValidationException("BidId parameter can't be empty");
        }
        if (comment == null) {
            throw new ApiValidationException("Comment parameter can't be empty");
        }
    }

    @Override
    protected ChooseWinnerBidResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, ChooseWinnerBidResponse.class);
    }

}
