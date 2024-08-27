package br.com.acme.insurancequote.controller;

import br.com.acme.insurancequote.domain.Quote;
import br.com.acme.insurancequote.domain.impl.QuoteImpl;
import br.com.acme.insurancequote.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acme/api/quote")
public class QuoteController {
        public final QuoteService quoteService;

        @Autowired
        public QuoteController( QuoteService quoteService) {
            this.quoteService = quoteService;
        }

        @PostMapping
        public ResponseEntity<?> createQuote(@RequestBody QuoteImpl quote) throws Exception {
            Quote response = null;


                response = quoteService.createQuote(quote);

                return new ResponseEntity<>(response, HttpStatus.CREATED);



        }
}
