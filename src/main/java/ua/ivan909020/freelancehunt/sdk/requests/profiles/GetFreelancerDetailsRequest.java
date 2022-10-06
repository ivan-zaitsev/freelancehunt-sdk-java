package ua.ivan909020.freelancehunt.sdk.requests.profiles;

import java.io.IOException;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.profiles.GetFreelancerDetailsResponse;

public class GetFreelancerDetailsRequest extends GetApiRequest<GetFreelancerDetailsResponse> {

    private Long freelancerId;

    public GetFreelancerDetailsRequest() {
    }

    public GetFreelancerDetailsRequest setFreelancerId(Long freelancerId) {
        this.freelancerId = freelancerId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/freelancers/" + freelancerId;
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
        if (freelancerId == null) {
            throw new ApiValidationException("FreelancerId parameter can't be empty");
        }
    }

    @Override
    public GetFreelancerDetailsResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, GetFreelancerDetailsResponse.class);
    }

}