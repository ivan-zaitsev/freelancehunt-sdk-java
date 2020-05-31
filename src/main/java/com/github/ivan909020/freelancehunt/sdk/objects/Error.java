package com.github.ivan909020.freelancehunt.sdk.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Error {

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("title")
    private String title;

    public Error() {
    }

    public Integer getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Error error = (Error) o;
        return Objects.equals(status, error.status) &&
                Objects.equals(title, error.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, title);
    }

    @Override
    public String toString() {
        return "Error{" +
                "status=" + status +
                ", title='" + title + '\'' +
                '}';
    }

}
