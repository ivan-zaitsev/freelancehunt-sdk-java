package ua.ivanzaitsev.freelancehunt.sdk.responses.threads;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivanzaitsev.freelancehunt.sdk.objects.entities.Thread;
import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;

public class CreateSupportThreadResponse extends ApiResponse {

    @JsonProperty("data")
    private Thread thread;

    public Thread getThread() {
        return thread;
    }

}
