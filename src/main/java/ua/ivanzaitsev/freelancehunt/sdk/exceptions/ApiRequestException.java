package ua.ivanzaitsev.freelancehunt.sdk.exceptions;

import java.io.Serial;

import ua.ivanzaitsev.freelancehunt.sdk.objects.models.Error;

public class ApiRequestException extends ApiException {

    @Serial
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
