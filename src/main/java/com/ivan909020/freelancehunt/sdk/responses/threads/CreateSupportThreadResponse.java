package com.ivan909020.freelancehunt.sdk.responses.threads;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ivan909020.freelancehunt.sdk.objects.entities.Thread;
import com.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class CreateSupportThreadResponse extends ApiResponse {

    @JsonProperty("data")
    private Thread thread;

    public CreateSupportThreadResponse() {
    }

    public Thread getThread() {
        return thread;
    }

}