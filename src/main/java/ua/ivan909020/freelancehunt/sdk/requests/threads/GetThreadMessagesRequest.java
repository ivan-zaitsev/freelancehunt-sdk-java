package ua.ivan909020.freelancehunt.sdk.requests.threads;

import java.io.IOException;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.threads.GetThreadMessagesResponse;

public class GetThreadMessagesRequest extends GetApiRequest<GetThreadMessagesResponse> {

    private Long threadId;

    public GetThreadMessagesRequest() {
    }

    public GetThreadMessagesRequest setThreadId(Long threadId) {
        this.threadId = threadId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/threads/" + threadId;
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
        if (threadId == null) {
            throw new ApiValidationException("ThreadId parameter can't be empty");
        }
    }

    @Override
    public GetThreadMessagesResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, GetThreadMessagesResponse.class);
    }

}
