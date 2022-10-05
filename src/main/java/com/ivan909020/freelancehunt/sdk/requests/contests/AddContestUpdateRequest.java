package com.ivan909020.freelancehunt.sdk.requests.contests;

import java.io.IOException;
import java.util.Map;

import com.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import com.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.ivan909020.freelancehunt.sdk.responses.contests.AddContestUpdateResponse;

public class AddContestUpdateRequest extends PostApiRequest<AddContestUpdateResponse> {

    private Long contestId;
    private String updateHtml;

    public AddContestUpdateRequest() {
    }

    public AddContestUpdateRequest setContestId(Long contestId) {
        this.contestId = contestId;
        return this;
    }

    public AddContestUpdateRequest setUpdateHtml(String updateHtml) {
        this.updateHtml = updateHtml;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/contests/" + contestId + "/amend";
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity(requestSerializer.serialize(buildBodyParameters()));
        }
        return httpEntity;
    }

    private Map<String, Object> buildBodyParameters() {
        return Map.of("update_html", updateHtml);
    }

    @Override
    public void validate() {
        super.validate();
        if (contestId == null) {
            throw new ApiValidationException("ContestId parameter can't be empty");
        }
        if (updateHtml == null) {
            throw new ApiValidationException("UpdateHtml parameter can't be empty");
        }
    }

    @Override
    public AddContestUpdateResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, AddContestUpdateResponse.class);
    }

}
