package com.github.ivan909020.freelancehunt.sdk.objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ivan909020.freelancehunt.sdk.client.ResponseDeserializer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class ContestDetails {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("attributes")
    private Attributes attributes;

    public ContestDetails() {
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
        ContestDetails profile = (ContestDetails) o;
        return Objects.equals(id, profile.id) &&
                Objects.equals(type, profile.type) &&
                Objects.equals(attributes, profile.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, attributes);
    }

    @Override
    public String toString() {
        return "Contest{" +
                "id=" + id +
                ", type='" + type + '\'' +
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
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ResponseDeserializer.DATE_TIME_PATTERN)
        private LocalDateTime publishedAt;

        @JsonProperty("duration_days")
        private Integer durationDays;

        @JsonProperty("final_started_at")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ResponseDeserializer.DATE_TIME_PATTERN)
        private LocalDateTime finalStartedAt;

        @JsonProperty("freelancer")
        private User freelancer;

        @JsonProperty("employer")
        private User employer;

        @JsonProperty("tags")
        private List<Tag> tags;

        @JsonProperty("updates")
        private List<Update> updates;

        public Attributes() {
        }

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

        public LocalDateTime getPublishedAt() {
            return publishedAt;
        }

        public Integer getDurationDays() {
            return durationDays;
        }

        public LocalDateTime getFinalStartedAt() {
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
