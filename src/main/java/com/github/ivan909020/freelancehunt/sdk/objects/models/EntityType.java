package com.github.ivan909020.freelancehunt.sdk.objects.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EntityType {

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

    @JsonProperty("project")
    PROJECT,

    @JsonProperty("project_workspace")
    PROJECT_WORKSPACE,

    @JsonProperty("contest")
    CONTEST,

    @JsonProperty("contest_workspace")
    CONTEST_WORKSPACE,

    @JsonProperty("message")
    MESSAGE,

    @JsonProperty("attachment")
    ATTACHMENT;

    @Override
    public String toString() {
        return name().toLowerCase();
    }

}
