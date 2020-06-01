package com.github.ivan909020.freelancehunt.sdk.requests.post;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.post.CreateThreadResponse;

import java.util.HashMap;
import java.util.Map;

public class CreateThreadRequest extends PostApiRequest<CreateThreadResponse> {

    private String subject;
    private String messageHtml;
    private Long toProfileId;

    public CreateThreadRequest() {
    }

    public CreateThreadRequest setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public CreateThreadRequest setMessageHtml(String messageHtml) {
        this.messageHtml = messageHtml;
        return this;
    }

    public CreateThreadRequest setToProfileId(Long toProfileId) {
        this.toProfileId = toProfileId;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "threads";
    }

    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("subject", subject);
        parameters.put("message_html", messageHtml);
        parameters.put("to_profile_id", toProfileId);
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
        if (toProfileId == null) {
            throw new ApiValidationException("ToProfileId parameter can't be empty");
        }
    }

    @Override
    public CreateThreadResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, CreateThreadResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
