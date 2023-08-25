package ua.ivan909020.freelancehunt.sdk.requests.threads;

import java.util.HashMap;
import java.util.Map;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.threads.CreateThreadResponse;

public class CreateThreadRequest extends PostApiRequest<CreateThreadResponse> {

    private String subject;
    private String messageHtml;
    private Long toProfileId;

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
        return "/threads";
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
        parameters.put("to_profile_id", toProfileId);
        return parameters;
    }

    @Override
    protected void validate() {
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

}
