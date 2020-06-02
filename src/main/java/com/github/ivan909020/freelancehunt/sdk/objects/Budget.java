package com.github.ivan909020.freelancehunt.sdk.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Budget {

    @JsonProperty("amount")
    private Integer amount;

    @JsonProperty("currency")
    private String currency;

    public Budget() {
    }

    public Integer getAmount() {
        return amount;
    }

    public Budget setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public Budget setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Budget budget = (Budget) o;
        return Objects.equals(amount, budget.amount) &&
                Objects.equals(currency, budget.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() {
        return "Budget{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

}
