package ua.ivanzaitsev.freelancehunt.sdk.responses.threads;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivanzaitsev.freelancehunt.sdk.objects.entities.Message;
import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;

public class UploadFileToThreadResponse extends ApiResponse {

    @JsonProperty("data")
    private Message message;

    public Message getMessage() {
        return message;
    }

}
