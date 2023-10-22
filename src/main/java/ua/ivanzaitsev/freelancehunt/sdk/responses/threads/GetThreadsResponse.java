package ua.ivanzaitsev.freelancehunt.sdk.responses.threads;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivanzaitsev.freelancehunt.sdk.objects.entities.Thread;
import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;

public class GetThreadsResponse extends ApiResponse {

    @JsonProperty("data")
    private List<Thread> threads;

    public List<Thread> getThreads() {
        return threads;
    }

}
