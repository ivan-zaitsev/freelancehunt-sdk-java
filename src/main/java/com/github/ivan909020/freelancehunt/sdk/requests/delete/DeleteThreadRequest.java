package com.github.ivan909020.freelancehunt.sdk.requests.delete;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.DeleteApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.delete.DeleteThreadResponse;

public class DeleteThreadRequest extends DeleteApiRequest<DeleteThreadResponse> {

    private Long threadId;

    public DeleteThreadRequest() {
    }

    @Override
    public String getUrlPath() {
        return "threads/" + threadId;
    }

    public DeleteThreadRequest setThreadId(Long threadId) {
        this.threadId = threadId;
        return this;
    }

    @Override
    public void validate() {
        super.validate();
        if (threadId == null) {
            throw new ApiValidationException("ThreadId parameter can't be empty");
        }
    }

    @Override
    public DeleteThreadResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, DeleteThreadResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
