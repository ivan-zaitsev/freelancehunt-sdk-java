package com.github.ivan909020.freelancehunt.sdk.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Grades {

    @JsonProperty("connectivity")
    private Integer connectivity;

    @JsonProperty("definition")
    private Integer definition;

    @JsonProperty("pay")
    private Integer pay;

    @JsonProperty("requirements")
    private Integer requirements;

    @JsonProperty("quality")
    private Integer quality;

    @JsonProperty("professionalism")
    private Integer professionalism;

    @JsonProperty("cost")
    private Integer cost;

    @JsonProperty("schedule")
    private Integer schedule;

    @JsonProperty("total")
    private Float total;

    public Grades() {
    }

    public Integer getConnectivity() {
        return connectivity;
    }

    public Integer getDefinition() {
        return definition;
    }

    public Integer getPay() {
        return pay;
    }

    public Integer getRequirements() {
        return requirements;
    }

    public Integer getQuality() {
        return quality;
    }

    public Integer getProfessionalism() {
        return professionalism;
    }

    public Integer getCost() {
        return cost;
    }

    public Integer getSchedule() {
        return schedule;
    }

    public Float getTotal() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grades grades = (Grades) o;
        return Objects.equals(connectivity, grades.connectivity) &&
                Objects.equals(definition, grades.definition) &&
                Objects.equals(pay, grades.pay) &&
                Objects.equals(requirements, grades.requirements) &&
                Objects.equals(quality, grades.quality) &&
                Objects.equals(professionalism, grades.professionalism) &&
                Objects.equals(cost, grades.cost) &&
                Objects.equals(schedule, grades.schedule) &&
                Objects.equals(total, grades.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connectivity, definition, pay, requirements, quality, professionalism, cost, schedule, total);
    }

    @Override
    public String toString() {
        return "Grades{" +
                "connectivity=" + connectivity +
                ", definition=" + definition +
                ", pay=" + pay +
                ", requirements=" + requirements +
                ", quality=" + quality +
                ", professionalism=" + professionalism +
                ", cost=" + cost +
                ", schedule=" + schedule +
                ", total=" + total +
                '}';
    }

}
