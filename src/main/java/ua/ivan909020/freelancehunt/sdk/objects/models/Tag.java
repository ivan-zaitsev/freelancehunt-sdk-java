package ua.ivan909020.freelancehunt.sdk.objects.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tag {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag status = (Tag) o;
        return Objects.equals(id, status.id) &&
                Objects.equals(name, status.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
