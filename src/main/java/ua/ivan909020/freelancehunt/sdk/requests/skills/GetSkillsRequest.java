package ua.ivan909020.freelancehunt.sdk.requests.skills;

import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
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

}
