package com.github.ivan909020.freelancehunt.sdk.objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.Objects;

import static com.github.ivan909020.freelancehunt.sdk.client.ObjectMapperConfig.DATE_TIME_PATTERN;

public class Feed {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("attributes")
    private Attributes attributes;

    public Feed() {
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feed feed = (Feed) o;
        return Objects.equals(id, feed.id) &&
                Objects.equals(type, feed.type) &&
                Objects.equals(attributes, feed.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, attributes);
    }

    @Override
    public String toString() {
        return "Feed{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", attributes=" + attributes +
                '}';
    }

    public static class Attributes {

        @JsonProperty("from")
        private User from;

        @JsonProperty("message")
        private String message;

        @JsonProperty("is_new")
        private Boolean isNew;

        @JsonProperty("created_at")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
        private ZonedDateTime createdAt;

        public User getFrom() {
            return from;
        }

        public String getMessage() {
            return message;
        }

        public Boolean getNew() {
            return isNew;
        }

        public ZonedDateTime getCreatedAt() {
            return createdAt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Attributes that = (Attributes) o;
            return Objects.equals(from, that.from) &&
                    Objects.equals(message, that.message) &&
                    Objects.equals(isNew, that.isNew) &&
                    Objects.equals(createdAt, that.createdAt);
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, message, isNew, createdAt);
        }

        @Override
        public String toString() {
            return "Attributes{" +
                    "from=" + from +
                    ", message='" + message + '\'' +
                    ", isNew=" + isNew +
                    ", createdAt=" + createdAt +
                    '}';
        }

    }

}
