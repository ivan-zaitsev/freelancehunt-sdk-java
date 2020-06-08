package com.github.ivan909020.freelancehunt.sdk.requests.get;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.get.GetEmployersResponse;

import java.util.HashMap;
import java.util.Map;

public class GetEmployersRequest extends GetApiRequest<GetEmployersResponse> {

    private Integer pageNumber;
    private Long countryId;
    private Long cityId;
    private String login;

    public GetEmployersRequest() {
    }

    public GetEmployersRequest setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public GetEmployersRequest setCountryId(Long countryId) {
        this.countryId = countryId;
        return this;
    }

    public GetEmployersRequest setCityId(Long cityId) {
        this.cityId = cityId;
        return this;
    }

    public GetEmployersRequest setLogin(String login) {
        this.login = login;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "employers";
    }

    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        if (pageNumber != null) {
            parameters.put("page[number]", pageNumber);
        }
        if (countryId != null) {
            parameters.put("filter[country_id]", countryId);
        }
        if (cityId != null) {
            parameters.put("filter[city_id]", cityId);
        }
        if (login != null) {
            parameters.put("filter[login]", login);
        }
        return parameters;
    }

    @Override
    public GetEmployersResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetEmployersResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
