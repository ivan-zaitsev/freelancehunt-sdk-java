package com.ivan909020.freelancehunt.sdk.objects.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum BidStatus {

    @JsonProperty("active")
    ACTIVE,

    @JsonProperty("revoked")
    REVOKED,

    @JsonProperty("rejected")
    REJECTED;

    @Override
    public String toString() {
        return name().toLowerCase();
    }

}
