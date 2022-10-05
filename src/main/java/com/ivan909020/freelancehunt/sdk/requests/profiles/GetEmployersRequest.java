package com.ivan909020.freelancehunt.sdk.requests.profiles;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import com.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.ivan909020.freelancehunt.sdk.responses.profiles.GetEmployersResponse;

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
        return "/employers";
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
    public GetEmployersResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, GetEmployersResponse.class);
    }

}
