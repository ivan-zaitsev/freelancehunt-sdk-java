package com.github.ivan909020.freelancehunt.sdk.objects.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ivan909020.freelancehunt.sdk.objects.models.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

import static com.github.ivan909020.freelancehunt.sdk.client.ObjectMapperConfig.DATE_TIME_PATTERN;

public class ProjectDetails {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("type")
    private EntityType type;

    @JsonProperty("attributes")
    private Attributes attributes;

    public ProjectDetails() {
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
        ProjectDetails that = (ProjectDetails) o;
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
        return "ProjectDetails{" +
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

        @JsonProperty("skills")
        private List<Skill> skills;

        @JsonProperty("status")
        private Status status;

        @JsonProperty("budget")
        private Budget budget;

        @JsonProperty("bid_count")
        private Integer bidCount;

        @JsonProperty("is_remote_job")
        private Boolean isRemoteJob;

        @JsonProperty("is_premium")
        private Boolean isPremium;

        @JsonProperty("is_only_for_plus")
        private Boolean isOnlyForPlus;

        @JsonProperty("location")
        private Location location;

        @JsonProperty("safe_type")
        private SafeType safeType;

        @JsonProperty("is_personal")
        private Boolean isPersonal;

        @JsonProperty("employer")
        private User employer;

        @JsonProperty("freelancer")
        private User freelancer;

        @JsonProperty("updates")
        private List<Update> updates;

        @JsonProperty("published_at")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
        private ZonedDateTime publishedAt;

        @JsonProperty("expired_at")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
        private ZonedDateTime expiredAt;

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

        public List<Skill> getSkills() {
            return skills;
        }

        public Status getStatus() {
            return status;
        }

        public Budget getBudget() {
            return budget;
        }

        public Integer getBidCount() {
            return bidCount;
        }

        public Boolean getRemoteJob() {
            return isRemoteJob;
        }

        public Boolean getPremium() {
            return isPremium;
        }

        public Boolean getOnlyForPlus() {
            return isOnlyForPlus;
        }

        public Location getLocation() {
            return location;
        }

        public SafeType getSafeType() {
            return safeType;
        }

        public Boolean getPersonal() {
            return isPersonal;
        }

        public User getEmployer() {
            return employer;
        }

        public User getFreelancer() {
            return freelancer;
        }

        public List<Update> getUpdates() {
            return updates;
        }

        public ZonedDateTime getPublishedAt() {
            return publishedAt;
        }

        public ZonedDateTime getExpiredAt() {
            return expiredAt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Attributes that = (Attributes) o;
            return Objects.equals(name, that.name) &&
                    Objects.equals(description, that.description) &&
                    Objects.equals(descriptionHtml, that.descriptionHtml) &&
                    Objects.equals(skills, that.skills) &&
                    Objects.equals(status, that.status) &&
                    Objects.equals(budget, that.budget) &&
                    Objects.equals(bidCount, that.bidCount) &&
                    Objects.equals(isRemoteJob, that.isRemoteJob) &&
                    Objects.equals(isPremium, that.isPremium) &&
                    Objects.equals(isOnlyForPlus, that.isOnlyForPlus) &&
                    Objects.equals(location, that.location) &&
                    safeType == that.safeType &&
                    Objects.equals(isPersonal, that.isPersonal) &&
                    Objects.equals(employer, that.employer) &&
                    Objects.equals(freelancer, that.freelancer) &&
                    Objects.equals(updates, that.updates) &&
                    Objects.equals(publishedAt, that.publishedAt) &&
                    Objects.equals(expiredAt, that.expiredAt);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, description, descriptionHtml, skills, status, budget, bidCount, isRemoteJob, isPremium, isOnlyForPlus, location, safeType, isPersonal, employer, freelancer, updates, publishedAt, expiredAt);
        }

        @Override
        public String toString() {
            return "Attributes{" +
                    "name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", descriptionHtml='" + descriptionHtml + '\'' +
                    ", skills=" + skills +
                    ", status=" + status +
                    ", budget=" + budget +
                    ", bidCount=" + bidCount +
                    ", isRemoteJob=" + isRemoteJob +
                    ", isPremium=" + isPremium +
                    ", isOnlyForPlus=" + isOnlyForPlus +
                    ", location=" + location +
                    ", safeType=" + safeType +
                    ", isPersonal=" + isPersonal +
                    ", employer=" + employer +
                    ", freelancer=" + freelancer +
                    ", updates=" + updates +
                    ", publishedAt=" + publishedAt +
                    ", expiredAt=" + expiredAt +
                    '}';
        }

    }

}
