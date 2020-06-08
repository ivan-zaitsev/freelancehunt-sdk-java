package com.github.ivan909020.freelancehunt.sdk.objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

import static com.github.ivan909020.freelancehunt.sdk.client.ObjectMapperConfig.DATE_PATTERN;

public class Message {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("attributes")
    private Attributes attributes;

    public Message() {
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
        Message thread = (Message) o;
        return Objects.equals(id, thread.id) &&
                Objects.equals(type, thread.type) &&
                Objects.equals(attributes, thread.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, attributes);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", attributes=" + attributes +
                '}';
    }

    public static class Attributes {

        @JsonProperty("message")
        private String message;

        @JsonProperty("message_html")
        private String messageHtml;

        @JsonProperty("posted_at")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
        private ZonedDateTime postedAt;

        @JsonProperty("attachments")
        private List<Attachment> attachments;

        @JsonProperty("participants")
        private Participants participants;

        public Attributes() {
        }

        public String getMessage() {
            return message;
        }

        public String getMessageHtml() {
            return messageHtml;
        }

        public ZonedDateTime getPostedAt() {
            return postedAt;
        }

        public List<Attachment> getAttachments() {
            return attachments;
        }

        public Participants getParticipants() {
            return participants;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Attributes that = (Attributes) o;
            return Objects.equals(message, that.message) &&
                    Objects.equals(messageHtml, that.messageHtml) &&
                    Objects.equals(postedAt, that.postedAt) &&
                    Objects.equals(attachments, that.attachments) &&
                    Objects.equals(participants, that.participants);
        }

        @Override
        public int hashCode() {
            return Objects.hash(message, messageHtml, postedAt, attachments, participants);
        }

        @Override
        public String toString() {
            return "Attributes{" +
                    "message='" + message + '\'' +
                    ", messageHtml='" + messageHtml + '\'' +
                    ", postedAt=" + postedAt +
                    ", attachments=" + attachments +
                    ", participants=" + participants +
                    '}';
        }

    }

}
