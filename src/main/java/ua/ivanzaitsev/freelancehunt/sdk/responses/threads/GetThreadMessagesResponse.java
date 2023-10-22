package ua.ivanzaitsev.freelancehunt.sdk.responses.threads;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivanzaitsev.freelancehunt.sdk.objects.entities.Message;
import ua.ivanzaitsev.freelancehunt.sdk.responses.ApiResponse;

public class GetThreadMessagesResponse extends ApiResponse {

    @JsonProperty("data")
    private List<Message> messages;

    public List<Message> getMessages() {
        return messages;
    }

}
