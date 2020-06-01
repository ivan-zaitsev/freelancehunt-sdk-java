package com.github.ivan909020.freelancehunt.sdk.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Country {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("iso2")
    private String iso2;

    @JsonProperty("name")
    private String name;

    public Country() {
    }

    public Long getId() {
        return id;
    }

    public String getIso2() {
        return iso2;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id) &&
                Objects.equals(iso2, country.iso2) &&
                Objects.equals(name, country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iso2, name);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", iso2='" + iso2 + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
