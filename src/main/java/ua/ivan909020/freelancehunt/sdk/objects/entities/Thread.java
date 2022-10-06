package ua.ivan909020.freelancehunt.sdk.objects.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.models.EntityType;
import ua.ivan909020.freelancehunt.sdk.objects.models.Participants;

import static ua.ivan909020.freelancehunt.sdk.configs.ObjectMapperConfig.DATE_TIME_PATTERN;

import java.time.ZonedDateTime;
import java.util.Objects;

public class Thread {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("type")
    private EntityType type;

    @JsonProperty("attributes")
    private Attributes attributes;

    public Thread() {
    }

    public Long getId() {
        return id;
    }

    public EntityType getType() {
        return type;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thread thread = (Thread) o;
        return Objects.equals(id, thread.id) &&
                type == thread.type &&
                Objects.equals(attributes, thread.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, attributes);
    }

    @Override
    public String toString() {
        return "Thread{" +
                "id=" + id +
                ", type=" + type +
                ", attributes=" + attributes +
                '}';
    }

    public static class Attributes {

        @JsonProperty("subject")
        private String subject;

        @JsonProperty("first_post_at")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
        private ZonedDateTime firstPostAt;

        @JsonProperty("last_post_at")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
        private ZonedDateTime lastPostAt;

        @JsonProperty("messages_count")
        private Integer messagesCount;

        @JsonProperty("is_unread")
        private Boolean isUnread;

        @JsonProperty("has_attachments")
        private Boolean hasAttachments;

        @JsonProperty("participants")
        private Participants participants;

        public Attributes() {
        }

        public String getSubject() {
            return subject;
        }

        public ZonedDateTime getFirstPostAt() {
            return firstPostAt;
        }

        public ZonedDateTime getLastPostAt() {
            return lastPostAt;
        }

        public Integer getMessagesCount() {
            return messagesCount;
        }

        public Boolean getUnread() {
            return isUnread;
        }

        public Boolean getHasAttachments() {
            return hasAttachments;
        }

        public Participants getParticipants() {
            return participants;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Attributes that = (Attributes) o;
            return Objects.equals(subject, that.subject) &&
                    Objects.equals(firstPostAt, that.firstPostAt) &&
                    Objects.equals(lastPostAt, that.lastPostAt) &&
                    Objects.equals(messagesCount, that.messagesCount) &&
                    Objects.equals(isUnread, that.isUnread) &&
                    Objects.equals(hasAttachments, that.hasAttachments) &&
                    Objects.equals(participants, that.participants);
        }

        @Override
        public int hashCode() {
            return Objects.hash(subject, firstPostAt, lastPostAt, messagesCount, isUnread, hasAttachments, participants);
        }

        @Override
        public String toString() {
            return "Attributes{" +
                    "subject='" + subject + '\'' +
                    ", firstPostAt=" + firstPostAt +
                    ", lastPostAt=" + lastPostAt +
                    ", messagesCount=" + messagesCount +
                    ", isUnread=" + isUnread +
                    ", hasAttachments=" + hasAttachments +
                    ", participants=" + participants +
                    '}';
        }

    }

}
