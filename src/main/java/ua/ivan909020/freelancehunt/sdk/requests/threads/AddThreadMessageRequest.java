package ua.ivan909020.freelancehunt.sdk.requests.threads;

import java.util.Map;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.threads.AddThreadMessageResponse;

public class AddThreadMessageRequest extends PostApiRequest<AddThreadMessageResponse> {

    private Long threadId;
    private String messageHtml;

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
        return "/threads/" + threadId;
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity(requestSerializer.serialize(buildBodyParameters()));
        }
        return httpEntity;
    }

    private Map<String, Object> buildBodyParameters() {
        return Map.of("message_html", messageHtml);
    }

    @Override
    protected void validate() {
        if (threadId == null) {
            throw new ApiValidationException("ThreadId parameter can't be empty");
        }
        if (messageHtml == null) {
            throw new ApiValidationException("MessageHtml parameter can't be empty");
        }
    }

}
