package com.ivan909020.freelancehunt.sdk.interceptors;

import java.io.IOException;

import com.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import com.ivan909020.freelancehunt.sdk.requests.ApiRequest;
import com.ivan909020.freelancehunt.sdk.requests.RequestExecutionChain;

public interface ApiRequestInterceptior {
    
    HttpResponse process(RequestExecutionChain chain, ApiRequest<?> request) throws IOException;

}
