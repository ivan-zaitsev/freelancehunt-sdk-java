package ua.ivanzaitsev.freelancehunt.sdk.requests.contests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ua.ivanzaitsev.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivanzaitsev.freelancehunt.sdk.requests.GetApiRequest;
import ua.ivanzaitsev.freelancehunt.sdk.responses.contests.GetMyContestsResponse;

public class GetMyContestsRequest extends GetApiRequest<GetMyContestsResponse> {

    private Integer pageNumber;
    private List<Integer> skillIds;
    private Integer statusId;

    public GetMyContestsRequest setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public GetMyContestsRequest setSkillIds(List<Integer> skillIds) {
        this.skillIds = skillIds;
        return this;
    }

    public GetMyContestsRequest setStatusId(Integer statusId) {
        this.statusId = statusId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/my/contests";
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
        if (pageNumber != null) {
            parameters.put("page[number]", pageNumber);
        }
        if (skillIds != null && !skillIds.isEmpty()) {
            parameters.put("filter[skill_id]", skillIds.stream().map(String::valueOf).collect(Collectors.joining(",")));
        }
        if (statusId != null) {
            parameters.put("filter[status_id]", statusId);
        }
        return parameters;
    }

}
