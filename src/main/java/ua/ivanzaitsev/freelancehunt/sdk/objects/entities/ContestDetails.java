package ua.ivanzaitsev.freelancehunt.sdk.objects.entities;

import static ua.ivanzaitsev.freelancehunt.sdk.utils.DateUtils.DATE_TIME_PATTERN;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivanzaitsev.freelancehunt.sdk.objects.models.Budget;
import ua.ivanzaitsev.freelancehunt.sdk.objects.models.EntityType;
import ua.ivanzaitsev.freelancehunt.sdk.objects.models.Skill;
import ua.ivanzaitsev.freelancehunt.sdk.objects.models.Status;
import ua.ivanzaitsev.freelancehunt.sdk.objects.models.Tag;
import ua.ivanzaitsev.freelancehunt.sdk.objects.models.Update;

public class ContestDetails {

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
        ContestDetails that = (ContestDetails) o;
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
        return "ContestDetails{" +
                "id=" + id +
                ", type=" + type +
                ", attributes=" + attributes +
                '}';
    }

    public static class Attributes {

        @JsonProperty("name")
        private String name;

        @JsonProperty("description")
        private String description;

        @JsonProperty("description_html")
        private String descriptionHtml;

        @JsonProperty("skill")
        private Skill skill;

        @JsonProperty("status")
        private Status status;

        @JsonProperty("budget")
        private Budget budget;

        @JsonProperty("application_count")
        private Integer applicationCount;

        @JsonProperty("published_at")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
        private ZonedDateTime publishedAt;

        @JsonProperty("duration_days")
        private Integer durationDays;

        @JsonProperty("final_started_at")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
        private ZonedDateTime finalStartedAt;

        @JsonProperty("freelancer")
        private User freelancer;

        @JsonProperty("employer")
        private User employer;

        @JsonProperty("tags")
        private List<Tag> tags;

        @JsonProperty("updates")
        private List<Update> updates;

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getDescriptionHtml() {
            return descriptionHtml;
        }

        public Skill getSkill() {
            return skill;
        }

        public Status getStatus() {
            return status;
        }

        public Budget getBudget() {
            return budget;
        }

        public Integer getApplicationCount() {
            return applicationCount;
        }

        public ZonedDateTime getPublishedAt() {
            return publishedAt;
        }

        public Integer getDurationDays() {
            return durationDays;
        }

        public ZonedDateTime getFinalStartedAt() {
            return finalStartedAt;
        }

        public User getFreelancer() {
            return freelancer;
        }

        public User getEmployer() {
            return employer;
        }

        public List<Tag> getTags() {
            return tags;
        }

        public List<Update> getUpdates() {
            return updates;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Attributes that = (Attributes) o;
            return Objects.equals(name, that.name) &&
                    Objects.equals(description, that.description) &&
                    Objects.equals(descriptionHtml, that.descriptionHtml) &&
                    Objects.equals(skill, that.skill) &&
                    Objects.equals(status, that.status) &&
                    Objects.equals(budget, that.budget) &&
                    Objects.equals(applicationCount, that.applicationCount) &&
                    Objects.equals(publishedAt, that.publishedAt) &&
                    Objects.equals(durationDays, that.durationDays) &&
                    Objects.equals(finalStartedAt, that.finalStartedAt) &&
                    Objects.equals(freelancer, that.freelancer) &&
                    Objects.equals(employer, that.employer) &&
                    Objects.equals(tags, that.tags) &&
                    Objects.equals(updates, that.updates);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, description, descriptionHtml, skill, status, budget, applicationCount, publishedAt, durationDays, finalStartedAt, freelancer, employer, tags, updates);
        }

        @Override
        public String toString() {
            return "Attributes{" +
                    "name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", descriptionHtml='" + descriptionHtml + '\'' +
                    ", skill=" + skill +
                    ", status=" + status +
                    ", budget=" + budget +
                    ", applicationCount=" + applicationCount +
                    ", publishedAt=" + publishedAt +
                    ", durationDays=" + durationDays +
                    ", finalStartedAt=" + finalStartedAt +
                    ", freelancer=" + freelancer +
                    ", employer=" + employer +
                    ", tags=" + tags +
                    ", updates=" + updates +
                    '}';
        }

    }

}
