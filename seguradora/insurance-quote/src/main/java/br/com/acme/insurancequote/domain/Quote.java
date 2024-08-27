package br.com.acme.insurancequote.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface Quote {
    Long getId();
    Long getInsurancePolicyId();
    String getProductId();
    String getOfferId();
    Category getCategory();
    BigDecimal getTotalMonthlyPremiumAmount();
    BigDecimal getTotalCoverageAmount();
    Map<String, BigDecimal> getCoverages();
    List<String> getAssistences();
    Customer getCustomer();


}
