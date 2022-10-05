package com.ivan909020.freelancehunt.sdk.responses.threads;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ivan909020.freelancehunt.sdk.objects.entities.Message;
import com.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class AddThreadMessageResponse extends ApiResponse {

    @JsonProperty("data")
    private Message message;

    public AddThreadMessageResponse() {
    }

    public Message getMessage() {
        return message;
    }

}
