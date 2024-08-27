package br.com.acme.insurancequote.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class PremiumAmount implements Serializable  {

    @JsonProperty("max_amount")
    private BigDecimal maxAmount;

    @JsonProperty("min_amount")
    private BigDecimal minAmount;

    @JsonProperty("suggested_amount")
    private BigDecimal suggestedAmount;

    public PremiumAmount(){
    }

    public PremiumAmount(BigDecimal maxAmount, BigDecimal minAmount, BigDecimal suggestedAmount) {
        this.maxAmount = maxAmount;
        this.minAmount = minAmount;
        this.suggestedAmount = suggestedAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public BigDecimal getSuggestedAmount() {
        return suggestedAmount;
    }

    public void setSuggestedAmount(BigDecimal suggestedAmount) {
        this.suggestedAmount = suggestedAmount;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }
}
