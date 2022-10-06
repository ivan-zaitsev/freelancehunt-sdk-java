package ua.ivan909020.freelancehunt.sdk.interceptors;

import java.io.IOException;

import ua.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.requests.ApiRequest;
import ua.ivan909020.freelancehunt.sdk.requests.RequestExecutionChain;

public interface ApiRequestInterceptior {
    
    HttpResponse process(RequestExecutionChain chain, ApiRequest<?> request) throws IOException;

}
