package ua.ivan909020.freelancehunt.sdk.objects.models;

import static ua.ivan909020.freelancehunt.sdk.utils.DateUtils.DATE_TIME_PATTERN;

import java.time.ZonedDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Conditions {

    @JsonProperty("days")
    private Integer days;

    @JsonProperty("safe_type")
    private SafeType safeType;

    @JsonProperty("budget")
    private Budget budget;

    @JsonProperty("confirmed_by")
    private ConfirmedBy confirmedBy;

    @JsonProperty("confirmed_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
    private ZonedDateTime confirmedAt;

    public Integer getDays() {
        return days;
    }

    public SafeType getSafeType() {
        return safeType;
    }

    public Budget getBudget() {
        return budget;
    }

    public ConfirmedBy getConfirmedBy() {
        return confirmedBy;
    }

    public ZonedDateTime getConfirmedAt() {
        return confirmedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conditions that = (Conditions) o;
        return Objects.equals(days, that.days) &&
                safeType == that.safeType &&
                Objects.equals(budget, that.budget) &&
                Objects.equals(confirmedBy, that.confirmedBy) &&
                Objects.equals(confirmedAt, that.confirmedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(days, safeType, budget, confirmedBy, confirmedAt);
    }

    @Override
    public String toString() {
        return "Conditions{" +
                "days=" + days +
                ", safeType=" + safeType +
                ", budget=" + budget +
                ", confirmedBy=" + confirmedBy +
                ", confirmedAt=" + confirmedAt +
                '}';
    }

}
