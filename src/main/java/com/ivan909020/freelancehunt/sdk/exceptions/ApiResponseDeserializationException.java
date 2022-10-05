package com.ivan909020.freelancehunt.sdk.exceptions;

public class ApiResponseDeserializationException extends ApiException {

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
