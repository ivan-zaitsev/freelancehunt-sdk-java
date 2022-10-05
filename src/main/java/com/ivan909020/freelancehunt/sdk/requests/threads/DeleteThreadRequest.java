package com.ivan909020.freelancehunt.sdk.requests.threads;

import java.io.IOException;

import com.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import com.ivan909020.freelancehunt.sdk.requests.DeleteApiRequest;
import com.ivan909020.freelancehunt.sdk.responses.threads.DeleteThreadResponse;

public class DeleteThreadRequest extends DeleteApiRequest<DeleteThreadResponse> {

    private Long threadId;

    public DeleteThreadRequest() {
    }

    @Override
    public String getUrlPath() {
        return "/threads/" + threadId;
    }

    public DeleteThreadRequest setThreadId(Long threadId) {
        this.threadId = threadId;
        return this;
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
    public DeleteThreadResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, DeleteThreadResponse.class);
    }

}
