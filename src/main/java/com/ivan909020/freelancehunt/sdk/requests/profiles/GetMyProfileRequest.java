package com.ivan909020.freelancehunt.sdk.requests.profiles;

import java.io.IOException;

import com.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import com.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.ivan909020.freelancehunt.sdk.responses.profiles.GetMyProfileResponse;

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
    public GetMyProfileResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, GetMyProfileResponse.class);
    }

}
