package com.github.ivan909020.freelancehunt.sdk.responses.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ivan909020.freelancehunt.sdk.objects.entities.Message;
import com.github.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class UploadFileToThreadResponse extends ApiResponse {

    @JsonProperty("data")
    private Message message;

    public UploadFileToThreadResponse() {
    }

    public Message getMessage() {
        return message;
    }

}
