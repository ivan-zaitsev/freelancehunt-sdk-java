package ua.ivanzaitsev.freelancehunt.sdk.objects.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Budget {

    @JsonProperty("amount")
    private Integer amount;

    @JsonProperty("currency")
    private Currency currency;

    public Integer getAmount() {
        return amount;
    }

    public Budget setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Budget setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Budget budget = (Budget) o;
        return Objects.equals(amount, budget.amount) &&
                currency == budget.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() {
        return "Budget{" +
                "amount=" + amount +
                ", currency=" + currency +
                '}';
    }

}
