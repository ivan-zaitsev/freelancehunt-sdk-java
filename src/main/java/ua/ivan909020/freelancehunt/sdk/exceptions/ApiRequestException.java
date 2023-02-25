package ua.ivan909020.freelancehunt.sdk.exceptions;

import ua.ivan909020.freelancehunt.sdk.objects.models.Error;

public class ApiRequestException extends ApiException {

    private static final long serialVersionUID = 1L;

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

}
