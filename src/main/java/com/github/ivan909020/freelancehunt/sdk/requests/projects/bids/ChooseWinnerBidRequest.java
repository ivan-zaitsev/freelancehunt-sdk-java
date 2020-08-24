package com.github.ivan909020.freelancehunt.sdk.requests.projects.bids;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.projects.bids.ChooseWinnerBidResponse;

import java.util.Collections;
import java.util.Map;

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
        return "projects/" + projectId + "/bids/" + bidId + "/reject";
    }

    @Override
    public Map<String, Object> getParameters() {
        return Collections.singletonMap("comment", comment);
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
        if (comment == null) {
            throw new ApiValidationException("Comment parameter can't be empty");
        }
    }

    @Override
    public ChooseWinnerBidResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, ChooseWinnerBidResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
