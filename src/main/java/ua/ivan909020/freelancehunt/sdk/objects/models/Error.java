package ua.ivan909020.freelancehunt.sdk.objects.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class Error {

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("title")
    private String title;

    @JsonProperty("detail")
    private String detail;
    
    @JsonProperty("meta")
    private JsonNode meta;

    public Integer getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

    public JsonNode getMeta() {
        return meta;
    }

    public void setMeta(JsonNode meta) {
        this.meta = meta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Error error = (Error) o;
        return Objects.equals(status, error.status) &&
                Objects.equals(title, error.title) &&
                Objects.equals(detail, error.detail) &&
                Objects.equals(meta, error.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, title, detail, meta);
    }

    @Override
    public String toString() {
        return "Error{" +
                "status=" + status +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", meta='" + meta +
                '}';
    }

}
