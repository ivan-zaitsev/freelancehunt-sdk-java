package ua.ivanzaitsev.freelancehunt.sdk.objects.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Skill {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("rating_position")
    private Integer ratingPosition;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getRatingPosition() {
        return ratingPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return Objects.equals(id, skill.id) &&
                Objects.equals(name, skill.name) &&
                Objects.equals(ratingPosition, skill.ratingPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ratingPosition);
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ratingPosition=" + ratingPosition +
                '}';
    }

}
