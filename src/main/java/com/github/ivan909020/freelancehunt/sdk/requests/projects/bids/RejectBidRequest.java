package com.github.ivan909020.freelancehunt.sdk.requests.projects.bids;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.projects.bids.RejectBidResponse;

public class RejectBidRequest extends PostApiRequest<RejectBidResponse> {

    private Long projectId;
    private Long bidId;

    public RejectBidRequest() {
    }

    public RejectBidRequest setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

    public RejectBidRequest setBidId(Long bidId) {
        this.bidId = bidId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "projects/" + projectId + "/bids/" + bidId + "/reject";
    }

    @Override
    public void validate() {
        super.validate();
        if (projectId == null) {
            throw new ApiValidationException("ProjectId parameter can't be empty");
        }
        if (bidId == null) {
            throw new ApiValidationException("BidId parameter can't be empty");
        }
    }

    @Override
    public RejectBidResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, RejectBidResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
