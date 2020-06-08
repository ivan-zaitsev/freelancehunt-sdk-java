package com.github.ivan909020.freelancehunt.sdk.requests.get;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.get.GetOpenProjectsResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GetOpenProjectsRequest extends GetApiRequest<GetOpenProjectsResponse> {

    private Integer pageNumber;
    private Integer onlyMySkills;
    private List<Integer> skillIds;
    private Long employerId;
    private Integer onlyForPlus;

    public GetOpenProjectsRequest() {
    }

    public GetOpenProjectsRequest setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public GetOpenProjectsRequest setOnlyMySkills(Integer onlyMySkills) {
        this.onlyMySkills = onlyMySkills;
        return this;
    }

    public GetOpenProjectsRequest setSkillIds(List<Integer> skillIds) {
        this.skillIds = skillIds;
        return this;
    }

    public GetOpenProjectsRequest setEmployerId(Long employerId) {
        this.employerId = employerId;
        return this;
    }

    public GetOpenProjectsRequest setOnlyForPlus(Integer onlyForPlus) {
        this.onlyForPlus = onlyForPlus;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "projects";
    }

    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        if (pageNumber != null) {
            parameters.put("page[number]", pageNumber);
        }
        if (onlyMySkills != null) {
            parameters.put("filter[only_my_skills]", onlyMySkills);
        }
        if (skillIds != null && !skillIds.isEmpty()) {
            parameters.put("filter[skill_id]", skillIds.stream().map(String::valueOf).collect(Collectors.joining(",")));
        }
        if (employerId != null) {
            parameters.put("filter[employer_id]", employerId);
        }
        if (onlyForPlus != null) {
            parameters.put("filter[only_for_plus]", onlyForPlus);
        }
        return parameters;
    }

    @Override
    public GetOpenProjectsResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetOpenProjectsResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
