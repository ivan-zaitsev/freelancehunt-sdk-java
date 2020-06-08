package com.github.ivan909020.freelancehunt.sdk.responses.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ivan909020.freelancehunt.sdk.objects.entities.Thread;
import com.github.ivan909020.freelancehunt.sdk.responses.ApiResponse;

import java.util.List;

public class GetThreadsResponse extends ApiResponse {

    @JsonProperty("data")
    private List<Thread> threads;

    public GetThreadsResponse() {
    }

    public List<Thread> getThreads() {
        return threads;
    }

}
