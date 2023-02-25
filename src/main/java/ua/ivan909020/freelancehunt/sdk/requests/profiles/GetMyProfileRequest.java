package ua.ivan909020.freelancehunt.sdk.requests.profiles;

import java.io.IOException;

import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.objects.response.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.profiles.GetMyProfileResponse;

public class GetMyProfileRequest extends GetApiRequest<GetMyProfileResponse> {

    public GetMyProfileRequest() {
    }

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

    @Override
    protected GetMyProfileResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, GetMyProfileResponse.class);
    }

}
