package com.github.ivan909020.freelancehunt.sdk.requests.threads;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.threads.AddThreadMessageResponse;

import java.util.Collections;
import java.util.Map;

public class AddThreadMessageRequest extends PostApiRequest<AddThreadMessageResponse> {

    private Long threadId;
    private String messageHtml;

    public AddThreadMessageRequest() {
    }

    public AddThreadMessageRequest setThreadId(Long threadId) {
        this.threadId = threadId;
        return this;
    }

    public AddThreadMessageRequest setMessageHtml(String messageHtml) {
        this.messageHtml = messageHtml;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "threads/" + threadId;
    }

    @Override
    public Map<String, Object> getParameters() {
        return Collections.singletonMap("message_html", messageHtml);
    }

    @Override
    public void validate() {
        super.validate();
        if (threadId == null) {
            throw new ApiValidationException("ThreadId parameter can't be empty");
        }
        if (messageHtml == null) {
            throw new ApiValidationException("MessageHtml parameter can't be empty");
        }
    }

    @Override
    public AddThreadMessageResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, AddThreadMessageResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
