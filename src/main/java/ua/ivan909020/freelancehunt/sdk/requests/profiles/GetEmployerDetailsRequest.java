package ua.ivan909020.freelancehunt.sdk.requests.profiles;

import java.io.IOException;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.objects.response.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.profiles.GetEmployerDetailsResponse;

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
    protected void validate() {
        if (employerId == null) {
            throw new ApiValidationException("EmployerId parameter can't be empty");
        }
    }

    @Override
    protected GetEmployerDetailsResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, GetEmployerDetailsResponse.class);
    }

}
