package com.github.ivan909020.freelancehunt.sdk.objects.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ivan909020.freelancehunt.sdk.objects.models.Budget;
import com.github.ivan909020.freelancehunt.sdk.objects.models.EntityType;
import com.github.ivan909020.freelancehunt.sdk.objects.models.Status;

import java.util.Objects;

public class Contest {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("type")
    private EntityType type;

    @JsonProperty("name")
    private String name;

    @JsonProperty("status")
    private Status status;

    @JsonProperty("budget")
    private Budget budget;

    public Contest() {
    }

    public Long getId() {
        return id;
    }

    public EntityType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public Budget getBudget() {
        return budget;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contest contest = (Contest) o;
        return Objects.equals(id, contest.id) &&
                type == contest.type &&
                Objects.equals(name, contest.name) &&
                Objects.equals(status, contest.status) &&
                Objects.equals(budget, contest.budget);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, status, budget);
    }

    @Override
    public String toString() {
        return "Contest{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", budget=" + budget +
                '}';
    }

}
