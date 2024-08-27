package br.com.acme.insurancequote.domain.impl;

import br.com.acme.insurancequote.domain.Category;
import br.com.acme.insurancequote.domain.Customer;
import br.com.acme.insurancequote.domain.Quote;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class QuoteImpl implements Serializable, Quote {

    @JsonProperty("id")
    private final Long id;

    @JsonProperty("insurance_policy_id")
    private final Long insurancePolicyId;

    @JsonProperty("product_id")
    private final String productId;

    @JsonProperty("offer_id")
    private final String offerId;

    @JsonProperty("category")
    private final Category category;

    @JsonProperty("total_monthly_premium_amount")
    private final BigDecimal totalMonthlyPremiumAmount;

    @JsonProperty("total_coverage_amount")
    private final BigDecimal totalCoverageAmount;

    @JsonProperty("coverages")
    private final Map<String, BigDecimal> coverages;

    @JsonProperty("assistences")
    private final  List<String> assistences;

    @JsonProperty("customer")
    private final Customer customer;

    @JsonCreator
    public QuoteImpl(
                     @JsonProperty("id") Long id,  @JsonProperty("insurance_policy_id") Long insurancePolicyId,
                     @JsonProperty("product_id") String productId, @JsonProperty("offer_id") String offerId,
                     @JsonProperty("category") Category category, @JsonProperty("total_monthly_premium_amount") BigDecimal totalMonthlyPremiumAmount,
                     @JsonProperty("total_coverage_amount") BigDecimal totalCoverageAmount,  @JsonProperty("coverages") Map<String, BigDecimal> coverages,
                     @JsonProperty("assistences")  List<String> assistences, @JsonProperty("customer")  Customer customer) {

        this.id = id;
        this.insurancePolicyId = insurancePolicyId;
        this.productId = productId;
        this.offerId = offerId;
        this.category = category;
        this.totalMonthlyPremiumAmount = totalMonthlyPremiumAmount;
        this.totalCoverageAmount = totalCoverageAmount;
        this.coverages = coverages;
        this.assistences = assistences;
        this.customer = customer;
    }

    @Override
    public Long getId() {
        return 0L;
    }

    @Override
    public Long getInsurancePolicyId() {
        return insurancePolicyId;
    }

    @Override
    public String getProductId() {
        return productId;
    }

    @Override
    public String getOfferId() {
        return offerId;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public BigDecimal getTotalMonthlyPremiumAmount() {
        return totalMonthlyPremiumAmount;
    }

    @Override
    public BigDecimal getTotalCoverageAmount() {
        return totalCoverageAmount;
    }

    @Override
    public Map<String, BigDecimal> getCoverages() {
        return coverages;
    }

    @Override
    public List<String> getAssistences() {
        return assistences;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }
}
