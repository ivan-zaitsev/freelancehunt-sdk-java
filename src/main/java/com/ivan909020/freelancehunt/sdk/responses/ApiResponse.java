package com.ivan909020.freelancehunt.sdk.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ivan909020.freelancehunt.sdk.objects.models.Error;

public abstract class ApiResponse {

    @JsonProperty("error")
    private Error error;

    public Error getError() {
        return error;
    }

}
