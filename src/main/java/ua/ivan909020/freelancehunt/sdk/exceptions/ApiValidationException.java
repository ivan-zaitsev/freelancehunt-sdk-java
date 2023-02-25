package ua.ivan909020.freelancehunt.sdk.exceptions;

public class ApiValidationException extends ApiException {

    private static final long serialVersionUID = 1L;

    public ApiValidationException(String message) {
        super(message);
    }

    public ApiValidationException(String message, Throwable cause) {
        super(message, cause);
    }

}
