package com.ivan909020.freelancehunt.sdk.exceptions;

public class ApiValidationException extends ApiException {

    public ApiValidationException(String message) {
        super(message);
    }

    public ApiValidationException(String message, Throwable cause) {
        super(message, cause);
    }

}
