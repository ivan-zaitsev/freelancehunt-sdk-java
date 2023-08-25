package ua.ivan909020.freelancehunt.sdk.objects.entities;

import static ua.ivan909020.freelancehunt.sdk.utils.DateUtils.DATE_TIME_PATTERN;

import java.time.ZonedDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.models.BidStatus;
import ua.ivan909020.freelancehunt.sdk.objects.models.Budget;
import ua.ivan909020.freelancehunt.sdk.objects.models.EntityType;
import ua.ivan909020.freelancehunt.sdk.objects.models.SafeType;

public class Bid {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("type")
    private EntityType type;

    @JsonProperty("attributes")
    private Attributes attributes;

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
        Bid feed = (Bid) o;
        return Objects.equals(id, feed.id) &&
                type == feed.type &&
                Objects.equals(attributes, feed.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, attributes);
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id +
                ", type=" + type +
                ", attributes=" + attributes +
                '}';
    }

    public static class Attributes {

        @JsonProperty("days")
        private Integer days;

        @JsonProperty("safe_type")
        private SafeType safeType;

        @JsonProperty("budget")
        private Budget budget;

        @JsonProperty("comment")
        private String comment;

        @JsonProperty("status")
        private BidStatus status;

        @JsonProperty("is_hidden")
        private Boolean isHidden;

        @JsonProperty("is_winner")
        private Boolean isWinner;

        @JsonProperty("freelancer")
        private User freelancer;

        @JsonProperty("project")
        private Project project;

        @JsonProperty("attachment")
        private Attachment attachment;

        @JsonProperty("published_at")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
        private ZonedDateTime publishedAt;

        public Integer getDays() {
            return days;
        }

        public SafeType getSafeType() {
            return safeType;
        }

        public Budget getBudget() {
            return budget;
        }

        public String getComment() {
            return comment;
        }

        public BidStatus getStatus() {
            return status;
        }

        public Boolean getIsHidden() {
            return isHidden;
        }

        public Boolean getIsWinner() {
            return isWinner;
        }

        public User getFreelancer() {
            return freelancer;
        }

        public Project getProject() {
            return project;
        }

        public Attachment getAttachment() {
            return attachment;
        }

        public ZonedDateTime getPublishedAt() {
            return publishedAt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Attributes that = (Attributes) o;
            return Objects.equals(days, that.days) &&
                    safeType == that.safeType &&
                    Objects.equals(budget, that.budget) &&
                    Objects.equals(comment, that.comment) &&
                    status == that.status &&
                    Objects.equals(isHidden, that.isHidden) &&
                    Objects.equals(isWinner, that.isWinner) &&
                    Objects.equals(freelancer, that.freelancer) &&
                    Objects.equals(project, that.project) &&
                    Objects.equals(attachment, that.attachment) &&
                    Objects.equals(publishedAt, that.publishedAt);
        }

        @Override
        public int hashCode() {
            return Objects.hash(days, safeType, budget, comment, status, isHidden, isWinner, freelancer, project, attachment, publishedAt);
        }

        @Override
        public String toString() {
            return "Attributes{" +
                    "days=" + days +
                    ", safeType=" + safeType +
                    ", budget=" + budget +
                    ", comment='" + comment + '\'' +
                    ", status=" + status +
                    ", isHidden=" + isHidden +
                    ", isWinner=" + isWinner +
                    ", freelancer=" + freelancer +
                    ", project=" + project +
                    ", attachment=" + attachment +
                    ", publishedAt=" + publishedAt +
                    '}';
        }

    }

}
