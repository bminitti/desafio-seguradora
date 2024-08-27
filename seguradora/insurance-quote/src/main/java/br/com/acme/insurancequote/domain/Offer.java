package br.com.acme.insurancequote.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.List;

public class Offer implements Serializable {

    @JsonProperty("id")
    private String id;

    @JsonProperty("product_id")
    private String productId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("created_at")
    private ZonedDateTime createdAt;

    @JsonProperty("active")
    private boolean active;

    @JsonProperty("coverages")
    private Map<String, BigDecimal> coverages;

    @JsonProperty("assistences")
    private List<String> assistences;

    @JsonProperty("monthly_premium_amount")
    private PremiumAmount monthlyPremiumAmount;

    public Offer() {

    }

    public Offer(String id, String productId, String name, ZonedDateTime createdAt, boolean active,
                           Map<String, BigDecimal> coverages, List<String> assistences, PremiumAmount monthlyPremiumAmount) {
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.createdAt = createdAt;
        this.active = active;
        this.coverages = coverages;
        this.assistences = assistences;
        this.monthlyPremiumAmount = monthlyPremiumAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Map<String, BigDecimal> getCoverages() {
        return coverages;
    }

    public void setCoverages(Map<String, BigDecimal> coverages) {
        this.coverages = coverages;
    }

    public List<String> getAssistences() {
        return assistences;
    }

    public void setAssistences(List<String> assistences) {
        this.assistences = assistences;
    }

    public PremiumAmount getMonthlyPremiumAmount() {
        return monthlyPremiumAmount;
    }

    public void setMonthlyPremiumAmount(PremiumAmount monthlyPremiumAmount) {
        this.monthlyPremiumAmount = monthlyPremiumAmount;
    }
}
