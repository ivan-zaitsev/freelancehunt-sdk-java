package com.github.ivan909020.freelancehunt.sdk.objects.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ConfirmedBy {

    @JsonProperty("employer")
    private Boolean employer;

    @JsonProperty("freelancer")
    private Boolean freelancer;

    public ConfirmedBy() {
    }

    public Boolean getEmployer() {
        return employer;
    }

    public Boolean getFreelancer() {
        return freelancer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfirmedBy that = (ConfirmedBy) o;
        return Objects.equals(employer, that.employer) &&
                Objects.equals(freelancer, that.freelancer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employer, freelancer);
    }

    @Override
    public String toString() {
        return "ConfirmedBy{" +
                "employer=" + employer +
                ", freelancer=" + freelancer +
                '}';
    }

}
