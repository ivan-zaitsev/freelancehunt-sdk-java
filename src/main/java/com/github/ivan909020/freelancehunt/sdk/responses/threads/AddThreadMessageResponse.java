package com.github.ivan909020.freelancehunt.sdk.responses.threads;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ivan909020.freelancehunt.sdk.objects.entities.Message;
import com.github.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class AddThreadMessageResponse extends ApiResponse {

    @JsonProperty("data")
    private Message message;

    public AddThreadMessageResponse() {
    }

    public Message getMessage() {
        return message;
    }

}
