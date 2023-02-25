package ua.ivan909020.freelancehunt.sdk.requests;

import java.util.LinkedHashMap;
import java.util.Map;

public class RequestContext {

    private final ApiRequest<?> request;
    private final Map<String, Object> data;

    public RequestContext(ApiRequest<?> request) {
        this.request = request;
        this.data = new LinkedHashMap<>();
    }

    public ApiRequest<?> getRequest() {
        return request;
    }

    public Map<String, Object> getData() {
        return data;
    }

}
