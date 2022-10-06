package ua.ivan909020.freelancehunt.sdk.interceptors;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import ua.ivan909020.freelancehunt.sdk.configs.ApiConfig;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.requests.ApiRequest;
import ua.ivan909020.freelancehunt.sdk.requests.RequestExecutionChain;

public class DefaultHeadersRequestInterceptior implements ApiRequestInterceptior {

    private final ApiConfig apiConfig;

    public DefaultHeadersRequestInterceptior(ApiConfig apiConfig) {
        this.apiConfig = apiConfig;
    }

    @Override
    public HttpResponse process(RequestExecutionChain chain, ApiRequest<?> request) throws IOException {
        Map<String, String> headers = new LinkedHashMap<>();
        headers.put("Authorization", "Bearer " + apiConfig.getApiToken());
        headers.put("Accept-Language", apiConfig.getLanguage());
        headers.put("Content-Type", "application/json");

        request.getEntity().addHeaders(headers);

        return chain.execute(request);
    }

}
