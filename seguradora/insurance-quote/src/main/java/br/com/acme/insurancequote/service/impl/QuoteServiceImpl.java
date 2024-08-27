package br.com.acme.insurancequote.service.impl;

import br.com.acme.insurancequote.domain.Offer;

import br.com.acme.insurancequote.domain.Quote;

import br.com.acme.insurancequote.exception.CustomException;
import br.com.acme.insurancequote.service.QuoteService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


@Service
public class QuoteServiceImpl implements QuoteService {
    private final ProductServiceImpl productService;
    private final OfferServiceImpl offerService;
    private final CoverageServiceImpl coverageService;
    private final AssistenceServiceImpl assistenceService;



    public QuoteServiceImpl(ProductServiceImpl productService, OfferServiceImpl offerService,
                            CoverageServiceImpl coverageService, AssistenceServiceImpl assistenceService) {
        this.productService = productService;
        this.offerService = offerService;
        this.coverageService = coverageService;
        this.assistenceService = assistenceService;
    }

    @Override
    public Quote createQuote(Quote quote) throws Exception {

        if (productService.isProductValid(quote.getProductId())){
            Offer offer = offerService.getOffertId(quote.getOfferId());

            coverageService.validInformedCoverages(offer.getCoverages(),quote.getCoverages());

            assistenceService.validInformedAssistences(offer.getAssistences(),quote.getAssistences());

            validTotalMonthlyPremiumAmount(quote,offer);

            validTotalCoverageAmount(quote);

        }



        return quote;

    }

    @Override
    public void validTotalMonthlyPremiumAmount(Quote quote, Offer offer) throws Exception {

        int maxValue = quote.getTotalMonthlyPremiumAmount().compareTo(offer.getMonthlyPremiumAmount().getMaxAmount());

        int minValue = quote.getTotalMonthlyPremiumAmount().compareTo(offer.getMonthlyPremiumAmount().getMinAmount());


        if (maxValue > 0)
            throw new CustomException("O total do prêmio mensal é maior que o permitido pela oferta.");

        if (minValue < 0)
            throw new CustomException("O total do prêmio mensal é menor que o permitido pela oferta.");

    }

    @Override
    public void validTotalCoverageAmount(Quote quote) throws Exception {

        BigDecimal totalCoverageAmount = BigDecimal.valueOf(quote.getCoverages().values().stream().mapToDouble(BigDecimal::doubleValue).sum());

        int result = totalCoverageAmount.compareTo(quote.getTotalCoverageAmount());

        if (result != 0)
            throw new CustomException("O total das coberturas informada não corresponde ao valor total das coberturas selecionadas.");


    }

}
