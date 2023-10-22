package ua.ivanzaitsev.freelancehunt.sdk.exceptions;

import java.io.Serial;

public class ApiRequestSerializationException extends ApiException {

    @Serial
    private static final long serialVersionUID = 1L;

    private Object content;

    public ApiRequestSerializationException(String message) {
        super(message);
    }

    public ApiRequestSerializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public Object getContent() {
        return content;
    }

    public ApiRequestSerializationException setContent(Object content) {
        this.content = content;
        return this;
    }

}
