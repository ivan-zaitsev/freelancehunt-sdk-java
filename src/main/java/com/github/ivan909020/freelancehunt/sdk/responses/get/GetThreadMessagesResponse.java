package com.github.ivan909020.freelancehunt.sdk.responses.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ivan909020.freelancehunt.sdk.objects.Message;
import com.github.ivan909020.freelancehunt.sdk.responses.ApiResponse;

import java.util.List;

public class GetThreadMessagesResponse extends ApiResponse {

    @JsonProperty("data")
    private List<Message> messages;

    public GetThreadMessagesResponse() {
    }

    public List<Message> getMessages() {
        return messages;
    }

}
