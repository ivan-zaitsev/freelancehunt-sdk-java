package ua.ivan909020.freelancehunt.sdk.exceptions;

import java.io.Serial;

public class ApiValidationException extends ApiException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ApiValidationException(String message) {
        super(message);
    }

    public ApiValidationException(String message, Throwable cause) {
        super(message, cause);
    }

}
