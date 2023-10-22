package ua.ivanzaitsev.freelancehunt.sdk.objects.request;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class HttpRequest {

    private final HttpURLConnection connection;

    public HttpRequest(HttpURLConnection connection) {
        this.connection = connection;
    }

    public OutputStream getOutputStream() throws IOException {
        return connection.getOutputStream();
    }

}
