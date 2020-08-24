package com.github.ivan909020.freelancehunt.sdk.requests.projects.bids;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.objects.models.BidStatus;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.projects.bids.GetMyFreelancerBidsResponse;

import java.util.HashMap;
import java.util.Map;

public class GetMyFreelancerBidsRequest extends GetApiRequest<GetMyFreelancerBidsResponse> {

    private Long projectId;
    private BidStatus bidStatus;

    public GetMyFreelancerBidsRequest() {
    }

    public GetMyFreelancerBidsRequest setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

    public GetMyFreelancerBidsRequest setBidStatus(BidStatus bidStatus) {
        this.bidStatus = bidStatus;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "my/bids";
    }

    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        if (projectId != null) {
            parameters.put("filter[project_id]", projectId);
        }
        if (bidStatus != null) {
            parameters.put("filter[status]", bidStatus);
        }
        return parameters;
    }

    @Override
    public GetMyFreelancerBidsResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetMyFreelancerBidsResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
