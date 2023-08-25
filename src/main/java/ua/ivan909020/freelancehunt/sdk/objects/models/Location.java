package ua.ivan909020.freelancehunt.sdk.objects.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

    @JsonProperty("country")
    private Country country;

    @JsonProperty("city")
    private City city;

    public Country getCountry() {
        return country;
    }

    public City getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(country, location.country) &&
                Objects.equals(city, location.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city);
    }

    @Override
    public String toString() {
        return "Location{" +
                "country=" + country +
                ", city=" + city +
                '}';
    }

}
