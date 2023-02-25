package ua.ivan909020.freelancehunt.sdk.objects.http;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class HttpEntity {

    private final Map<String, String> headers;
    private final Map<String, Object> urlParameters;
    private final InputStream content;

    public HttpEntity() {
        this(new byte[0]);
    }

    public HttpEntity(byte[] content) {
        this(new ByteArrayInputStream(content));
    }

    public HttpEntity(InputStream content) {
        this.content = content;
        this.headers = new LinkedHashMap<>();
        this.urlParameters = new LinkedHashMap<>();
    }
    
    public Map<String, Object> getUrlParameters() {
        return new LinkedHashMap<>(urlParameters);
    }

    public void addUrlParameters(Map<String, Object> urlParameters) {
        for (Map.Entry<String, Object> entry : urlParameters.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                this.urlParameters.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public Map<String, String> getHeaders() {
        return new LinkedHashMap<>(headers);
    }

    public void addHeaders(Map<String, String> headers) {
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                this.headers.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public InputStream getContent() {
        return content;
    }

}
