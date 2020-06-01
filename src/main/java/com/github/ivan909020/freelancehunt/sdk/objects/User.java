package com.github.ivan909020.freelancehunt.sdk.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class User {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("login")
    private String login;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("avatar")
    private Avatar avatar;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(type, user.type) &&
                Objects.equals(login, user.login) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(avatar, user.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, login, firstName, lastName, avatar);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", avatar=" + avatar +
                '}';
    }

}
