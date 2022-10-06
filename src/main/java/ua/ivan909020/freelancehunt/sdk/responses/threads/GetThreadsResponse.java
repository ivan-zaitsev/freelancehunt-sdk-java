package ua.ivan909020.freelancehunt.sdk.responses.threads;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.entities.Thread;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;

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