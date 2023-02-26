package ua.ivan909020.freelancehunt.sdk.requests.projects.bids;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.projects.bids.RestoreBidResponse;

public class RestoreBidRequest extends PostApiRequest<RestoreBidResponse> {

    private Long projectId;
    private Long bidId;

    public RestoreBidRequest() {
    }

    public RestoreBidRequest setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

    public RestoreBidRequest setBidId(Long bidId) {
        this.bidId = bidId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/projects/" + projectId + "/bids/" + bidId + "/restore";
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity();
        }
        return httpEntity;
    }

    @Override
    protected void validate() {
        if (projectId == null) {
            throw new ApiValidationException("ProjectId parameter can't be empty");
        }
        if (bidId == null) {
            throw new ApiValidationException("BidId parameter can't be empty");
        }
    }

}
