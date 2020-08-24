package com.github.ivan909020.freelancehunt.sdk.requests.projects.bids;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.objects.models.BidStatus;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.projects.bids.GetProjectBidsResponse;

import java.util.HashMap;
import java.util.Map;

public class GetProjectBidsRequest extends GetApiRequest<GetProjectBidsResponse> {

    private Long projectId;
    private Boolean isWinner;
    private BidStatus bidStatus;

    public GetProjectBidsRequest() {
    }

    public GetProjectBidsRequest setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

    public GetProjectBidsRequest setWinner(Boolean isWinner) {
        this.isWinner = isWinner;
        return this;
    }

    public GetProjectBidsRequest setBidStatus(BidStatus bidStatus) {
        this.bidStatus = bidStatus;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "projects/" + projectId + "/bids";
    }

    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        if (isWinner != null) {
            parameters.put("filter[is_winner]", isWinner);
        }
        if (bidStatus != null) {
            parameters.put("filter[status]", bidStatus);
        }
        return parameters;
    }

    @Override
    public void validate() {
        super.validate();
        if (projectId == null) {
            throw new ApiValidationException("ProjectId parameter can't be empty");
        }
    }

    @Override
    public GetProjectBidsResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetProjectBidsResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
