package ua.ivanzaitsev.freelancehunt.sdk.requests.threads;

import java.util.HashMap;
import java.util.Map;

import ua.ivanzaitsev.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivanzaitsev.freelancehunt.sdk.requests.GetApiRequest;
import ua.ivanzaitsev.freelancehunt.sdk.responses.threads.GetThreadsResponse;

public class GetThreadsRequest extends GetApiRequest<GetThreadsResponse> {

    private Integer pageNumber;

    public GetThreadsRequest setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/threads";
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity();
            httpEntity.addUrlParameters(buildUrlParameters());
        }
        return httpEntity;
    }

    private Map<String, Object> buildUrlParameters() {
        Map<String, Object> parameters = new HashMap<>();
        if (pageNumber != null) {
            parameters.put("page[number]", pageNumber);
        }
        return parameters;
    }

}
