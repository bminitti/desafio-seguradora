package br.com.acme.insurancequote.service.impl;

import br.com.acme.insurancequote.exception.CustomException;
import br.com.acme.insurancequote.service.CoverageService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class CoverageServiceImpl implements CoverageService {

    @Override
    public void validInformedCoverages(Map<String, BigDecimal> coverage, Map<String, BigDecimal> coverageInformed) {
        for (String key : coverageInformed.keySet()) {
            if (coverage.containsKey(key)) {
                BigDecimal valueCovarage = coverage.get(key);
                BigDecimal valuecoverageInformed = coverageInformed.get(key);

                int result  = valuecoverageInformed.compareTo(valueCovarage);

                if (result > 0) {
                    throw new CustomException("O valor da cobertura " + key + " informado " + valuecoverageInformed + " é maior que o range permitido de " + valueCovarage);
                }
            }else{
                throw new CustomException("Cobertura informada inválida " + key);
            }
        }
    }
}
