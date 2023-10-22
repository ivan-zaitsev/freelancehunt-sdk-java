package ua.ivanzaitsev.freelancehunt.sdk.requests.projects.bids;

import java.util.HashMap;
import java.util.Map;

import ua.ivanzaitsev.freelancehunt.sdk.objects.models.BidStatus;
import ua.ivanzaitsev.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivanzaitsev.freelancehunt.sdk.requests.GetApiRequest;
import ua.ivanzaitsev.freelancehunt.sdk.responses.projects.bids.GetMyFreelancerBidsResponse;

public class GetMyFreelancerBidsRequest extends GetApiRequest<GetMyFreelancerBidsResponse> {

    private Long projectId;
    private BidStatus bidStatus;

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
        return "/my/bids";
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
        if (projectId != null) {
            parameters.put("filter[project_id]", projectId);
        }
        if (bidStatus != null) {
            parameters.put("filter[status]", bidStatus);
        }
        return parameters;
    }

}
