package ua.ivan909020.freelancehunt.sdk.requests.contests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.objects.response.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.contests.GetContestsResponse;

public class GetContestsRequest extends GetApiRequest<GetContestsResponse> {

    private Integer pageNumber;
    private List<Integer> skillIds;
    private Long employerId;

    public GetContestsRequest() {
    }

    public GetContestsRequest setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public GetContestsRequest setSkillIds(List<Integer> skillIds) {
        this.skillIds = skillIds;
        return this;
    }

    public GetContestsRequest setEmployerId(Long employerId) {
        this.employerId = employerId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/contests";
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
        if (employerId != null) {
            parameters.put("filter[employer_id]", employerId);
        }
        return parameters;
    }

    @Override
    protected GetContestsResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, GetContestsResponse.class);
    }

}
