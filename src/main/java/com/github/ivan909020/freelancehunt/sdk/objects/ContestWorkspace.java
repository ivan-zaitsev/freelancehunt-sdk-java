package com.github.ivan909020.freelancehunt.sdk.objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.Objects;

import static com.github.ivan909020.freelancehunt.sdk.client.ObjectMapperConfig.DATE_TIME_PATTERN;

public class ContestWorkspace {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("attributes")
    private Attributes attributes;

    public ContestWorkspace() {
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
        ContestWorkspace profile = (ContestWorkspace) o;
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
        return "ContestWorkspace{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", attributes=" + attributes +
                '}';
    }

    public static class Attributes {

        @JsonProperty("contest")
        private Contest contest;

        @JsonProperty("employer")
        private User employer;

        @JsonProperty("freelancer")
        private User freelancer;

        @JsonProperty("winner_chosen_at")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
        private ZonedDateTime winnerChosenAt;

        @JsonProperty("ended_at")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
        private ZonedDateTime endedAt;

        public Attributes() {
        }

        public Contest getContest() {
            return contest;
        }

        public User getEmployer() {
            return employer;
        }

        public User getFreelancer() {
            return freelancer;
        }

        public ZonedDateTime getWinnerChosenAt() {
            return winnerChosenAt;
        }

        public ZonedDateTime getEndedAt() {
            return endedAt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Attributes that = (Attributes) o;
            return Objects.equals(contest, that.contest) &&
                    Objects.equals(employer, that.employer) &&
                    Objects.equals(freelancer, that.freelancer) &&
                    Objects.equals(winnerChosenAt, that.winnerChosenAt) &&
                    Objects.equals(endedAt, that.endedAt);
        }

        @Override
        public int hashCode() {
            return Objects.hash(contest, employer, freelancer, winnerChosenAt, endedAt);
        }

        @Override
        public String toString() {
            return "Attributes{" +
                    "contest=" + contest +
                    ", employer=" + employer +
                    ", freelancer=" + freelancer +
                    ", winnerChosenAt=" + winnerChosenAt +
                    ", endedAt=" + endedAt +
                    '}';
        }

    }

}
