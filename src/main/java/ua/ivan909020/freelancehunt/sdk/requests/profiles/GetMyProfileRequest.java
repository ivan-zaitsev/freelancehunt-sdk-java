package ua.ivan909020.freelancehunt.sdk.requests.profiles;

import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.profiles.GetMyProfileResponse;

public class GetMyProfileRequest extends GetApiRequest<GetMyProfileResponse> {

    @Override
    public String getUrlPath() {
        return "/my/profile";
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity();
        }
        return httpEntity;
    }

}
