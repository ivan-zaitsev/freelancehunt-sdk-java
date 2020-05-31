package com.github.ivan909020.freelancehunt.sdk.exceptions;

import com.github.ivan909020.freelancehunt.sdk.objects.Error;

public class ApiRequestException extends ApiException {

    private Error error;

    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiRequestException(String message, Error error) {
        super(message);
        this.error = error;
    }

    public Error getError() {
        return error;
    }

    @Override
    public String toString() {
        if (error != null) {
            return super.toString() + ": " + error.toString();
        }
        return super.toString();
    }

}
