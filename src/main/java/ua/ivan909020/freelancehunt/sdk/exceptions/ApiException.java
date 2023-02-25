package ua.ivan909020.freelancehunt.sdk.exceptions;

public class ApiException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

}
