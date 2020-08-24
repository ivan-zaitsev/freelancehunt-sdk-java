package com.github.ivan909020.freelancehunt.sdk.requests.contests;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.contests.GetMyContestsResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GetMyContestsRequest extends GetApiRequest<GetMyContestsResponse> {

    private Integer pageNumber;
    private List<Integer> skillIds;
    private Integer statusId;

    public GetMyContestsRequest() {
    }

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
        return "my/contests";
    }

    @Override
    public Map<String, Object> getParameters() {
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

    @Override
    public GetMyContestsResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetMyContestsResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
