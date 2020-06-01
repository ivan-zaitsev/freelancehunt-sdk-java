package com.github.ivan909020.freelancehunt.sdk.requests.get;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.GetApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.get.GetThreadMessagesResponse;

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
        return "threads/" + threadId;
    }

    @Override
    public void validate() {
        super.validate();
        if (threadId == null) {
            throw new ApiValidationException("ThreadId parameter can't be empty");
        }
    }

    @Override
    public GetThreadMessagesResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, GetThreadMessagesResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
