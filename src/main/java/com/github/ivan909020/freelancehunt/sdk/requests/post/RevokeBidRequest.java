package com.github.ivan909020.freelancehunt.sdk.requests.post;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.post.RevokeBidResponse;

public class RevokeBidRequest extends PostApiRequest<RevokeBidResponse> {

    private Long projectId;
    private Long bidId;

    public RevokeBidRequest() {
    }

    public RevokeBidRequest setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

    public RevokeBidRequest setBidId(Long bidId) {
        this.bidId = bidId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "projects/" + projectId + "/bids/" + bidId + "/revoke";
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
    public RevokeBidResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, RevokeBidResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
