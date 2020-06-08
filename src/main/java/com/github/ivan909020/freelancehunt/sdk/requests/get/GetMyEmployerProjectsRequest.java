package com.github.ivan909020.freelancehunt.sdk.requests.get;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.get.GetMyEmployerProjectsResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GetMyEmployerProjectsRequest extends GetApiRequest<GetMyEmployerProjectsResponse> {

    private List<Integer> skillIds;
    private Integer statusId;

    public GetMyEmployerProjectsRequest() {
    }

    public GetMyEmployerProjectsRequest setSkillIds(List<Integer> skillIds) {
        this.skillIds = skillIds;
        return this;
    }

    public GetMyEmployerProjectsRequest setStatusId(Integer statusId) {
        this.statusId = statusId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "my/projects";
    }

    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        if (skillIds != null && !skillIds.isEmpty()) {
            parameters.put("filter[skill_id]", skillIds.stream().map(String::valueOf).collect(Collectors.joining(",")));
        }
        if (statusId != null) {
            parameters.put("filter[status_id]", statusId);
        }
        return parameters;
    }

    @Override
    public GetMyEmployerProjectsResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetMyEmployerProjectsResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
