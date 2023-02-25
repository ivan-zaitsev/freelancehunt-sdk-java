package ua.ivan909020.freelancehunt.sdk.exceptions;

public class ApiRequestSerializationException extends ApiException {

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
