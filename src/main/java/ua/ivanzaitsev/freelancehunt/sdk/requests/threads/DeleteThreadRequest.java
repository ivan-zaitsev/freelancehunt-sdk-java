package ua.ivanzaitsev.freelancehunt.sdk.requests.threads;

import ua.ivanzaitsev.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivanzaitsev.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivanzaitsev.freelancehunt.sdk.requests.DeleteApiRequest;
import ua.ivanzaitsev.freelancehunt.sdk.responses.threads.DeleteThreadResponse;

public class DeleteThreadRequest extends DeleteApiRequest<DeleteThreadResponse> {

    private Long threadId;

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
    protected void validate() {
        if (threadId == null) {
            throw new ApiValidationException("ThreadId parameter can't be empty");
        }
    }

}
