package ua.ivan909020.freelancehunt.sdk.objects.http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class HttpRequest {

    private final HttpURLConnection connection;

    public HttpRequest(HttpURLConnection connection) {
        this.connection = connection;
    }

    public void addHeader(String key, String value) {
        connection.setRequestProperty(key, value);
    }

    public OutputStream getOutputStream() throws IOException {
        return connection.getOutputStream();
    }

}
