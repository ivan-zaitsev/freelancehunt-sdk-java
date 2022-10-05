package com.ivan909020.freelancehunt.sdk.objects.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SafeType {

    @JsonProperty("employer")
    EMPLOYER,

    @JsonProperty("developer")
    DEVELOPER,

    @JsonProperty("split")
    SPLIT,

    @JsonProperty("employer_cashless")
    EMPLOYER_CASHLESS;

    @Override
    public String toString() {
        return name().toLowerCase();
    }

}
