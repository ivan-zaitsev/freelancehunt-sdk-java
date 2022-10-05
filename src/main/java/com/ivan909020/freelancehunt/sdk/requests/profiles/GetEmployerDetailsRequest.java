package com.ivan909020.freelancehunt.sdk.requests.profiles;

import java.io.IOException;

import com.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import com.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.ivan909020.freelancehunt.sdk.responses.profiles.GetEmployerDetailsResponse;

public class GetEmployerDetailsRequest extends GetApiRequest<GetEmployerDetailsResponse> {

    private Long employerId;

    public GetEmployerDetailsRequest() {
    }

    public GetEmployerDetailsRequest setEmployerId(Long employerId) {
        this.employerId = employerId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/employers/" + employerId;
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity();
        }
        return httpEntity;
    }

    @Override
    public void validate() {
        super.validate();
        if (employerId == null) {
            throw new ApiValidationException("EmployerId parameter can't be empty");
        }
    }

    @Override
    public GetEmployerDetailsResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, GetEmployerDetailsResponse.class);
    }

}
