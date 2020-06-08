package com.github.ivan909020.freelancehunt.sdk.responses.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ivan909020.freelancehunt.sdk.objects.entities.Thread;
import com.github.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class CreateThreadResponse extends ApiResponse {

    @JsonProperty("data")
    private Thread thread;

    public CreateThreadResponse() {
    }

    public Thread getThread() {
        return thread;
    }

}
