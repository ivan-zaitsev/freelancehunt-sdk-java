package com.github.ivan909020.freelancehunt.sdk.requests.post;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.post.CreateSupportThreadResponse;

import java.util.HashMap;
import java.util.Map;

public class CreateSupportThreadRequest extends PostApiRequest<CreateSupportThreadResponse> {

    private String subject;
    private String messageHtml;

    public CreateSupportThreadRequest() {
    }

    public CreateSupportThreadRequest setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public CreateSupportThreadRequest setMessageHtml(String messageHtml) {
        this.messageHtml = messageHtml;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "threads/action/support";
    }

    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("subject", subject);
        parameters.put("message_html", messageHtml);
        return parameters;
    }

    @Override
    public void validate() {
        super.validate();
        if (subject == null) {
            throw new ApiValidationException("Subject parameter can't be empty");
        }
        if (messageHtml == null) {
            throw new ApiValidationException("MessageHtml parameter can't be empty");
        }
    }

    @Override
    public CreateSupportThreadResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, CreateSupportThreadResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
