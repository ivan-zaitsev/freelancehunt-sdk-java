package ua.ivan909020.freelancehunt.sdk.requests.contests;

import java.io.IOException;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.contests.GetContestDetailsResponse;

public class GetContestDetailsRequest extends GetApiRequest<GetContestDetailsResponse> {

    private Long contestId;

    public GetContestDetailsRequest() {
    }

    public GetContestDetailsRequest setContestId(Long contestId) {
        this.contestId = contestId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/contests/" + contestId;
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
        if (contestId == null) {
            throw new ApiValidationException("ContestId parameter can't be empty");
        }
    }

    @Override
    protected GetContestDetailsResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, GetContestDetailsResponse.class);
    }

}
