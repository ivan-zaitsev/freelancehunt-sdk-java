package ua.ivanzaitsev.freelancehunt.sdk.exceptions;

import java.io.Serial;

public class ApiResponseDeserializationException extends ApiException {

    @Serial
    private static final long serialVersionUID = 1L;

    private String content;

    public ApiResponseDeserializationException(String message) {
        super(message);
    }

    public ApiResponseDeserializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getContent() {
        return content;
    }

    public ApiResponseDeserializationException setContent(String content) {
        this.content = content;
        return this;
    }

}
