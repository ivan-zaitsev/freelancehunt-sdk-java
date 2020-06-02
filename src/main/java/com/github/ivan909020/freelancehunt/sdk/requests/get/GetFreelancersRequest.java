package com.github.ivan909020.freelancehunt.sdk.requests.get;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.get.GetFreelancersResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GetFreelancersRequest extends GetApiRequest<GetFreelancersResponse> {

    private Integer pageNumber;
    private Long countryId;
    private Long cityId;
    private List<Integer> skillIds;
    private String login;

    public GetFreelancersRequest() {
    }

    public GetFreelancersRequest setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public GetFreelancersRequest setCountryId(Long countryId) {
        this.countryId = countryId;
        return this;
    }

    public GetFreelancersRequest setCityId(Long cityId) {
        this.cityId = cityId;
        return this;
    }

    public GetFreelancersRequest setSkillIds(List<Integer> skillIds) {
        this.skillIds = skillIds;
        return this;
    }

    public GetFreelancersRequest setLogin(String login) {
        this.login = login;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "freelancers";
    }

    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        if (pageNumber != null) {
            parameters.put("page[number]", pageNumber);
        }
        if (countryId != null) {
            parameters.put("country_id", countryId);
        }
        if (cityId != null) {
            parameters.put("city_id", cityId);
        }
        if (skillIds != null && !skillIds.isEmpty()) {
            parameters.put("skill_id", skillIds.stream().map(String::valueOf).collect(Collectors.joining(",")));
        }
        if (login != null) {
            parameters.put("login", login);
        }
        return parameters;
    }

    @Override
    public GetFreelancersResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetFreelancersResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
