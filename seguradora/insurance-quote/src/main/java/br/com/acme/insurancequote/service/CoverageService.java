package br.com.acme.insurancequote.service;

import java.math.BigDecimal;
import java.util.Map;

public interface CoverageService {
    void validInformedCoverages(Map<String, BigDecimal> coverage,Map<String, BigDecimal> coverageInformed);
}
