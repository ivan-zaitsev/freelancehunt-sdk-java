package com.ivan909020.freelancehunt.sdk.requests.threads;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import com.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.ivan909020.freelancehunt.sdk.responses.threads.CreateSupportThreadResponse;

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
        return "/threads/action/support";
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity(requestSerializer.serialize(buildBodyParameters()));
        }
        return httpEntity;
    }

    private Map<String, Object> buildBodyParameters() {
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
    public CreateSupportThreadResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, CreateSupportThreadResponse.class);
    }

}
