package ua.ivanzaitsev.freelancehunt.sdk.requests.projects.bids;

import java.util.HashMap;
import java.util.Map;

import ua.ivanzaitsev.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivanzaitsev.freelancehunt.sdk.objects.models.BidStatus;
import ua.ivanzaitsev.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivanzaitsev.freelancehunt.sdk.requests.GetApiRequest;
import ua.ivanzaitsev.freelancehunt.sdk.responses.projects.bids.GetProjectBidsResponse;

public class GetProjectBidsRequest extends GetApiRequest<GetProjectBidsResponse> {

    private Long projectId;
    private Boolean isWinner;
    private BidStatus bidStatus;

    public GetProjectBidsRequest setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

    public GetProjectBidsRequest setIsWinner(Boolean isWinner) {
        this.isWinner = isWinner;
        return this;
    }

    public GetProjectBidsRequest setBidStatus(BidStatus bidStatus) {
        this.bidStatus = bidStatus;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/projects/" + projectId + "/bids";
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity();
            httpEntity.addUrlParameters(buildUrlParameters());
        }
        return httpEntity;
    }

    private Map<String, Object> buildUrlParameters() {
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
    protected void validate() {
        if (projectId == null) {
            throw new ApiValidationException("ProjectId parameter can't be empty");
        }
    }

}
