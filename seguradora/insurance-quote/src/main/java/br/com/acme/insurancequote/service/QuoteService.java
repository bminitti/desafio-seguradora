package br.com.acme.insurancequote.service;

import br.com.acme.insurancequote.domain.Offer;
import br.com.acme.insurancequote.domain.Quote;



public interface QuoteService {
    Quote createQuote(Quote quote) throws Exception;
    void validTotalMonthlyPremiumAmount(Quote quote, Offer Offer) throws Exception;
    void validTotalCoverageAmount(Quote quote) throws Exception;
}
