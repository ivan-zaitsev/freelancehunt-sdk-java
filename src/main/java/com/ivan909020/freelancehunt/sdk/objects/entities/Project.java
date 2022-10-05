package com.ivan909020.freelancehunt.sdk.objects.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ivan909020.freelancehunt.sdk.objects.models.Budget;
import com.ivan909020.freelancehunt.sdk.objects.models.EntityType;
import com.ivan909020.freelancehunt.sdk.objects.models.SafeType;
import com.ivan909020.freelancehunt.sdk.objects.models.Status;

import java.util.Objects;

public class Project {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("type")
    private EntityType type;

    @JsonProperty("name")
    private String name;

    @JsonProperty("status")
    private Status status;

    @JsonProperty("safe_type")
    private SafeType safeType;

    @JsonProperty("budget")
    private Budget budget;

    public Project() {
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

    public SafeType getSafeType() {
        return safeType;
    }

    public Budget getBudget() {
        return budget;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) &&
                type == project.type &&
                Objects.equals(name, project.name) &&
                Objects.equals(status, project.status) &&
                safeType == project.safeType &&
                Objects.equals(budget, project.budget);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, status, safeType, budget);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", safeType=" + safeType +
                ", budget=" + budget +
                '}';
    }

}
