package ua.ivanzaitsev.freelancehunt.sdk.objects.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivanzaitsev.freelancehunt.sdk.objects.entities.User;

public class Participants {

    @JsonProperty("from")
    private User from;

    @JsonProperty("to")
    private User to;

    public User getFrom() {
        return from;
    }

    public User getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participants that = (Participants) o;
        return Objects.equals(from, that.from) &&
                Objects.equals(to, that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

    @Override
    public String toString() {
        return "Participants{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }

}
