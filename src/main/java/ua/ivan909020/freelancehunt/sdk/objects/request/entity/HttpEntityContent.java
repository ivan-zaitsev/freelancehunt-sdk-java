package ua.ivan909020.freelancehunt.sdk.objects.request.entity;

import java.io.InputStream;

public class HttpEntityContent {

    private final InputStream data;
    private final long length;

    public HttpEntityContent(InputStream data, long length) {
        this.data = data;
        this.length = length;
    }

    public InputStream getData() {
        return data;
    }

    public long getLength() {
        return length;
    }

}
