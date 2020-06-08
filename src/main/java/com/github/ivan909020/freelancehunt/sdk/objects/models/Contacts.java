package com.github.ivan909020.freelancehunt.sdk.objects.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contacts {

    @JsonProperty("skype")
    private String skype;

    @JsonProperty("telegram")
    private String telegram;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("wmid")
    private String wmid;

    @JsonProperty("email")
    private String email;

    @JsonProperty("website")
    private String website;

    public Contacts() {
    }

    public String getSkype() {
        return skype;
    }

    public String getTelegram() {
        return telegram;
    }

    public String getPhone() {
        return phone;
    }

    public String getWmid() {
        return wmid;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "skype='" + skype + '\'' +
                ", telegram='" + telegram + '\'' +
                ", phone='" + phone + '\'' +
                ", wmid='" + wmid + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                '}';
    }

}
