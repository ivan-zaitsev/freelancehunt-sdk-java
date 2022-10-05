package com.ivan909020.freelancehunt.sdk.requests.projects.bids;

import java.io.IOException;

import com.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import com.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.ivan909020.freelancehunt.sdk.responses.projects.bids.RejectBidResponse;

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
        return "/projects/" + projectId + "/bids/" + bidId + "/reject";
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity();
        }
        return httpEntity;
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
    public RejectBidResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, RejectBidResponse.class);
    }

}
