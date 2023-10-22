package ua.ivanzaitsev.freelancehunt.sdk.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivanzaitsev.freelancehunt.sdk.objects.models.Error;

public abstract class ApiResponse {

    @JsonProperty("error")
    private Error error;

    public Error getError() {
        return error;
    }

}
