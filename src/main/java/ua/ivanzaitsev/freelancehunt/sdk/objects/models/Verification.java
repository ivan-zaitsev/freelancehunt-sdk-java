package ua.ivanzaitsev.freelancehunt.sdk.objects.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Verification {

    @JsonProperty("identity")
    private Boolean identity;

    @JsonProperty("birth_date")
    private Boolean birthDate;

    @JsonProperty("phone")
    private Boolean phone;

    @JsonProperty("website")
    private Boolean website;

    @JsonProperty("wmid")
    private Boolean wmid;

    @JsonProperty("email")
    private Boolean email;

    public Boolean getIdentity() {
        return identity;
    }

    public Boolean getBirthDate() {
        return birthDate;
    }

    public Boolean getPhone() {
        return phone;
    }

    public Boolean getWebsite() {
        return website;
    }

    public Boolean getWmid() {
        return wmid;
    }

    public Boolean getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Verification that = (Verification) o;
        return Objects.equals(identity, that.identity) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(website, that.website) &&
                Objects.equals(wmid, that.wmid) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identity, birthDate, phone, website, wmid, email);
    }

    @Override
    public String toString() {
        return "Verification{" +
                "identity=" + identity +
                ", birthDate=" + birthDate +
                ", phone=" + phone +
                ", website=" + website +
                ", wmid=" + wmid +
                ", email=" + email +
                '}';
    }

}
