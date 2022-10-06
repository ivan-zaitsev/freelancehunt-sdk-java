package ua.ivan909020.freelancehunt.sdk.objects.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
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

    public Grades setConnectivity(Integer connectivity) {
        this.connectivity = connectivity;
        return this;
    }

    public Integer getDefinition() {
        return definition;
    }

    public Grades setDefinition(Integer definition) {
        this.definition = definition;
        return this;
    }

    public Integer getPay() {
        return pay;
    }

    public Grades setPay(Integer pay) {
        this.pay = pay;
        return this;
    }

    public Integer getRequirements() {
        return requirements;
    }

    public Grades setRequirements(Integer requirements) {
        this.requirements = requirements;
        return this;
    }

    public Integer getQuality() {
        return quality;
    }

    public Grades setQuality(Integer quality) {
        this.quality = quality;
        return this;
    }

    public Integer getProfessionalism() {
        return professionalism;
    }

    public Grades setProfessionalism(Integer professionalism) {
        this.professionalism = professionalism;
        return this;
    }

    public Integer getCost() {
        return cost;
    }

    public Grades setCost(Integer cost) {
        this.cost = cost;
        return this;
    }

    public Integer getSchedule() {
        return schedule;
    }

    public Grades setSchedule(Integer schedule) {
        this.schedule = schedule;
        return this;
    }

    public Float getTotal() {
        return total;
    }

    public Grades setTotal(Float total) {
        this.total = total;
        return this;
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
