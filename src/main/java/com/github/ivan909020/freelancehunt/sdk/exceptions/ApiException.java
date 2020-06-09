package com.github.ivan909020.freelancehunt.sdk.exceptions;

public class ApiException extends RuntimeException {

    private String requestUrl;

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public ApiException setRequestPath(String requestUrl) {
        this.requestUrl = requestUrl;
        return this;
    }

    @Override
    public String toString() {
        if (requestUrl != null) {
            return super.toString() + ": " + requestUrl;
        }
        return super.toString();
    }

}
