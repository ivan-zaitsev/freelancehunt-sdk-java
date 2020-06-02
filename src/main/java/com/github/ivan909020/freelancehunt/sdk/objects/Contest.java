package com.github.ivan909020.freelancehunt.sdk.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Contest {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("type")
    private String type;

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

    public String getType() {
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
                Objects.equals(type, contest.type) &&
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
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", budget=" + budget +
                '}';
    }

}
