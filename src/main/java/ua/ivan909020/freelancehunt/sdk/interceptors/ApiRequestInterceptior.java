package ua.ivan909020.freelancehunt.sdk.interceptors;

import java.io.IOException;

import ua.ivan909020.freelancehunt.sdk.objects.response.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.requests.RequestContext;
import ua.ivan909020.freelancehunt.sdk.requests.RequestExecutionChain;

public interface ApiRequestInterceptior {
    
    HttpResponse process(RequestExecutionChain chain, RequestContext context) throws IOException;

}
