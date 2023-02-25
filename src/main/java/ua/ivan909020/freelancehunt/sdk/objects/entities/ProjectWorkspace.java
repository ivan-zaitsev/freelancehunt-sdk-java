package ua.ivan909020.freelancehunt.sdk.objects.entities;

import static ua.ivan909020.freelancehunt.sdk.utils.DateUtils.DATE_TIME_PATTERN;

import java.time.ZonedDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.models.Conditions;
import ua.ivan909020.freelancehunt.sdk.objects.models.EntityType;

public class ProjectWorkspace {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("type")
    private EntityType type;

    @JsonProperty("attributes")
    private Attributes attributes;

    public ProjectWorkspace() {
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
        ProjectWorkspace that = (ProjectWorkspace) o;
        return Objects.equals(id, that.id) &&
                type == that.type &&
                Objects.equals(attributes, that.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, attributes);
    }

    @Override
    public String toString() {
        return "ProjectWorkspace{" +
                "id=" + id +
                ", type=" + type +
                ", attributes=" + attributes +
                '}';
    }

    public static class Attributes {

        @JsonProperty("development_ends_at")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
        private ZonedDateTime developmentEndsAt;

        @JsonProperty("conditions")
        private Conditions conditions;

        @JsonProperty("project")
        private Project project;

        @JsonProperty("employer")
        private User employer;

        @JsonProperty("freelancer")
        private User freelancer;

        @JsonProperty("arbitrage_started_at")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
        private ZonedDateTime arbitrageStartedAt;

        public Attributes() {
        }

        public ZonedDateTime getDevelopmentEndsAt() {
            return developmentEndsAt;
        }

        public Conditions getConditions() {
            return conditions;
        }

        public Project getProject() {
            return project;
        }

        public User getEmployer() {
            return employer;
        }

        public User getFreelancer() {
            return freelancer;
        }

        public ZonedDateTime getArbitrageStartedAt() {
            return arbitrageStartedAt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Attributes that = (Attributes) o;
            return Objects.equals(developmentEndsAt, that.developmentEndsAt) &&
                    Objects.equals(conditions, that.conditions) &&
                    Objects.equals(project, that.project) &&
                    Objects.equals(employer, that.employer) &&
                    Objects.equals(freelancer, that.freelancer) &&
                    Objects.equals(arbitrageStartedAt, that.arbitrageStartedAt);
        }

        @Override
        public int hashCode() {
            return Objects.hash(developmentEndsAt, conditions, project, employer, freelancer, arbitrageStartedAt);
        }

        @Override
        public String toString() {
            return "Attributes{" +
                    "developmentEndsAt=" + developmentEndsAt +
                    ", conditions=" + conditions +
                    ", project=" + project +
                    ", employer=" + employer +
                    ", freelancer=" + freelancer +
                    ", arbitrageStartedAt=" + arbitrageStartedAt +
                    '}';
        }

    }

}
