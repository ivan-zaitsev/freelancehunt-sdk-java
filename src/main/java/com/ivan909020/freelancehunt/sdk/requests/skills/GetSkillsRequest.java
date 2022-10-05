package com.ivan909020.freelancehunt.sdk.requests.skills;

import java.io.IOException;

import com.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import com.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.ivan909020.freelancehunt.sdk.responses.skills.GetSkillsResponse;

public class GetSkillsRequest extends GetApiRequest<GetSkillsResponse> {

    public GetSkillsRequest() {
    }

    @Override
    public String getUrlPath() {
        return "/skills";
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity();
        }
        return httpEntity;
    }

    @Override
    public GetSkillsResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, GetSkillsResponse.class);
    }

}
