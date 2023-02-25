package ua.ivan909020.freelancehunt.sdk.requests.profiles;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.objects.response.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.profiles.GetFreelancersResponse;

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
        return "/freelancers";
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
        if (skillIds != null && !skillIds.isEmpty()) {
            parameters.put("filter[skill_id]", skillIds.stream().map(String::valueOf).collect(Collectors.joining(",")));
        }
        if (login != null) {
            parameters.put("filter[login]", login);
        }
        return parameters;
    }

    @Override
    protected GetFreelancersResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, GetFreelancersResponse.class);
    }

}
