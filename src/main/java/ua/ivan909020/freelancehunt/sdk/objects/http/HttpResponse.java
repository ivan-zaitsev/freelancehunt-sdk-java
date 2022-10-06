package ua.ivan909020.freelancehunt.sdk.objects.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class HttpResponse {

    private final HttpURLConnection connection;

    public HttpResponse(HttpURLConnection connection) {
        this.connection = connection;
    }

    public InputStream getInputStream() throws IOException {
        return isErrorResponse() ? connection.getErrorStream() : connection.getInputStream();
    }
    
    private boolean isErrorResponse() throws IOException {
        int series = connection.getResponseCode() / 100;
        return series == 4 || series == 5;
    }

}
