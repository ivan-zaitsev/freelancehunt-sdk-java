package ua.ivanzaitsev.freelancehunt.sdk.interceptors;

import java.io.IOException;

import ua.ivanzaitsev.freelancehunt.sdk.objects.response.HttpResponse;
import ua.ivanzaitsev.freelancehunt.sdk.requests.RequestContext;
import ua.ivanzaitsev.freelancehunt.sdk.requests.RequestExecutionChain;

public interface ApiRequestInterceptior {
    
    HttpResponse process(RequestExecutionChain chain, RequestContext context) throws IOException;

}
