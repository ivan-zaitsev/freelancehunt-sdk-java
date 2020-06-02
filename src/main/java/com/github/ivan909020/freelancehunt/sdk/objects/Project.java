package com.github.ivan909020.freelancehunt.sdk.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Project {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("name")
    private String name;

    @JsonProperty("status")
    private Status status;

    @JsonProperty("safe_type")
    private String safeType;

    @JsonProperty("budget")
    private Budget budget;

    public Project() {
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

    public String getSafeType() {
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
                Objects.equals(type, project.type) &&
                Objects.equals(name, project.name) &&
                Objects.equals(status, project.status) &&
                Objects.equals(safeType, project.safeType) &&
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
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", safeType='" + safeType + '\'' +
                ", budget=" + budget +
                '}';
    }

}
