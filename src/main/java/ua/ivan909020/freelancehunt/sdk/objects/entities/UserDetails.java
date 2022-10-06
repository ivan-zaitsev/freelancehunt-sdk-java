package ua.ivan909020.freelancehunt.sdk.objects.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.models.*;

import static ua.ivan909020.freelancehunt.sdk.configs.ObjectMapperConfig.DATE_PATTERN;
import static ua.ivan909020.freelancehunt.sdk.configs.ObjectMapperConfig.DATE_TIME_PATTERN;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

public class UserDetails {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("type")
    private EntityType type;

    @JsonProperty("attributes")
    private Attributes attributes;

    public UserDetails() {
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
        UserDetails that = (UserDetails) o;
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
        return "UserDetails{" +
                "id=" + id +
                ", type=" + type +
                ", attributes=" + attributes +
                '}';
    }

    public static class Attributes {

        @JsonProperty("login")
        private String login;

        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;

        @JsonProperty("avatar")
        private Avatar avatar;

        @JsonProperty("birth_date")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
        private LocalDate birthDate;

        @JsonProperty("created_at")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
        private ZonedDateTime createdAt;

        @JsonProperty("cv")
        private String cv;

        @JsonProperty("cv_html")
        private String cvHtml;

        @JsonProperty("rating")
        private Integer rating;

        @JsonProperty("ratingPosition")
        private Integer ratingPosition;

        @JsonProperty("arbitrages")
        private Integer arbitrages;

        @JsonProperty("positive_reviews")
        private Integer positiveReviews;

        @JsonProperty("negative_reviews")
        private Integer negativeReviews;

        @JsonProperty("plus_ends_at")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
        private ZonedDateTime plusEndsAt;

        @JsonProperty("is_plus_active")
        private Boolean isPlusActive;

        @JsonProperty("is_online")
        private Boolean isOnline;

        @JsonProperty("visited_at")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
        private ZonedDateTime visitedAt;

        @JsonProperty("location")
        private Location location;

        @JsonProperty("verification")
        private Verification verification;

        @JsonProperty("contacts")
        private Contacts contacts;

        @JsonProperty("status")
        private Status status;

        @JsonProperty("skills")
        private List<Skill> skills;

        public Attributes() {
        }

        public String getLogin() {
            return login;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public Avatar getAvatar() {
            return avatar;
        }

        public LocalDate getBirthDate() {
            return birthDate;
        }

        public ZonedDateTime getCreatedAt() {
            return createdAt;
        }

        public String getCv() {
            return cv;
        }

        public String getCvHtml() {
            return cvHtml;
        }

        public Integer getRating() {
            return rating;
        }

        public Integer getRatingPosition() {
            return ratingPosition;
        }

        public Integer getArbitrages() {
            return arbitrages;
        }

        public Integer getPositiveReviews() {
            return positiveReviews;
        }

        public Integer getNegativeReviews() {
            return negativeReviews;
        }

        public ZonedDateTime getPlusEndsAt() {
            return plusEndsAt;
        }

        public Boolean getPlusActive() {
            return isPlusActive;
        }

        public Boolean getOnline() {
            return isOnline;
        }

        public ZonedDateTime getVisitedAt() {
            return visitedAt;
        }

        public Location getLocation() {
            return location;
        }

        public Verification getVerification() {
            return verification;
        }

        public Contacts getContacts() {
            return contacts;
        }

        public Status getStatus() {
            return status;
        }

        public List<Skill> getSkills() {
            return skills;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Attributes that = (Attributes) o;
            return Objects.equals(login, that.login) &&
                    Objects.equals(firstName, that.firstName) &&
                    Objects.equals(lastName, that.lastName) &&
                    Objects.equals(avatar, that.avatar) &&
                    Objects.equals(birthDate, that.birthDate) &&
                    Objects.equals(createdAt, that.createdAt) &&
                    Objects.equals(cv, that.cv) &&
                    Objects.equals(cvHtml, that.cvHtml) &&
                    Objects.equals(rating, that.rating) &&
                    Objects.equals(ratingPosition, that.ratingPosition) &&
                    Objects.equals(arbitrages, that.arbitrages) &&
                    Objects.equals(positiveReviews, that.positiveReviews) &&
                    Objects.equals(negativeReviews, that.negativeReviews) &&
                    Objects.equals(plusEndsAt, that.plusEndsAt) &&
                    Objects.equals(isPlusActive, that.isPlusActive) &&
                    Objects.equals(isOnline, that.isOnline) &&
                    Objects.equals(visitedAt, that.visitedAt) &&
                    Objects.equals(location, that.location) &&
                    Objects.equals(verification, that.verification) &&
                    Objects.equals(contacts, that.contacts) &&
                    Objects.equals(status, that.status) &&
                    Objects.equals(skills, that.skills);
        }

        @Override
        public int hashCode() {
            return Objects.hash(login, firstName, lastName, avatar, birthDate, createdAt, cv, cvHtml, rating, ratingPosition, arbitrages, positiveReviews, negativeReviews, plusEndsAt, isPlusActive, isOnline, visitedAt, location, verification, contacts, status, skills);
        }

        @Override
        public String toString() {
            return "Attributes{" +
                    "login='" + login + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", avatar=" + avatar +
                    ", birthDate=" + birthDate +
                    ", createdAt=" + createdAt +
                    ", cv='" + cv + '\'' +
                    ", cvHtml='" + cvHtml + '\'' +
                    ", rating=" + rating +
                    ", ratingPosition=" + ratingPosition +
                    ", arbitrages=" + arbitrages +
                    ", positiveReviews=" + positiveReviews +
                    ", negativeReviews=" + negativeReviews +
                    ", plusEndsAt=" + plusEndsAt +
                    ", isPlusActive=" + isPlusActive +
                    ", isOnline=" + isOnline +
                    ", visitedAt=" + visitedAt +
                    ", location=" + location +
                    ", verification=" + verification +
                    ", contacts=" + contacts +
                    ", status=" + status +
                    ", skills=" + skills +
                    '}';
        }

    }

}
