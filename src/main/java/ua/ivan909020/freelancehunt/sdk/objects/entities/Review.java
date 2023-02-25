package ua.ivan909020.freelancehunt.sdk.objects.entities;

import static ua.ivan909020.freelancehunt.sdk.utils.DateUtils.DATE_TIME_PATTERN;

import java.time.ZonedDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.models.EntityType;
import ua.ivan909020.freelancehunt.sdk.objects.models.Grades;

public class Review {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("type")
    private EntityType type;

    @JsonProperty("attributes")
    private Attributes attributes;

    public Review() {
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
        Review review = (Review) o;
        return Objects.equals(id, review.id) &&
                type == review.type &&
                Objects.equals(attributes, review.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, attributes);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", type=" + type +
                ", attributes=" + attributes +
                '}';
    }

    public static class Attributes {

        @JsonProperty("published_at")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
        private ZonedDateTime publishedAt;

        @JsonProperty("is_pending")
        private Boolean isPending;

        @JsonProperty("comment")
        private String comment;

        @JsonProperty("grades")
        private Grades grades;

        @JsonProperty("from")
        private User from;

        @JsonProperty("project")
        private Project project;

        public Attributes() {
        }

        public ZonedDateTime getPublishedAt() {
            return publishedAt;
        }

        public Boolean getPending() {
            return isPending;
        }

        public String getComment() {
            return comment;
        }

        public Grades getGrades() {
            return grades;
        }

        public User getFrom() {
            return from;
        }

        public Project getProject() {
            return project;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Attributes that = (Attributes) o;
            return Objects.equals(publishedAt, that.publishedAt) &&
                    Objects.equals(isPending, that.isPending) &&
                    Objects.equals(comment, that.comment) &&
                    Objects.equals(grades, that.grades) &&
                    Objects.equals(from, that.from) &&
                    Objects.equals(project, that.project);
        }

        @Override
        public int hashCode() {
            return Objects.hash(publishedAt, isPending, comment, grades, from, project);
        }

        @Override
        public String toString() {
            return "Attributes{" +
                    "publishedAt=" + publishedAt +
                    ", isPending=" + isPending +
                    ", comment='" + comment + '\'' +
                    ", grades=" + grades +
                    ", from=" + from +
                    ", project=" + project +
                    '}';
        }

    }

}
