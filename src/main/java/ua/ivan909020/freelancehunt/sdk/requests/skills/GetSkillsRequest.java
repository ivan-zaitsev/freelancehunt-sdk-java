package ua.ivan909020.freelancehunt.sdk.requests.skills;

import java.io.IOException;

import ua.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.skills.GetSkillsResponse;

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
