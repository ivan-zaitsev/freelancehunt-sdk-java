package com.github.ivan909020.freelancehunt.sdk.objects.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EntityType {

    @JsonProperty("project")
    PROJECT,

    @JsonProperty("freelancer")
    FREELANCER,

    @JsonProperty("employer")
    EMPLOYER,

    @JsonProperty("review")
    REVIEW,

    @JsonProperty("feed")
    FEED,

    @JsonProperty("thread")
    THREAD,

    @JsonProperty("contest")
    CONTEST,

    @JsonProperty("message")
    MESSAGE,

    @JsonProperty("attachment")
    ATTACHMENT

}
