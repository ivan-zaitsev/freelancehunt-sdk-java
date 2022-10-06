package ua.ivan909020.freelancehunt.sdk.responses.threads;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.entities.Message;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;

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
