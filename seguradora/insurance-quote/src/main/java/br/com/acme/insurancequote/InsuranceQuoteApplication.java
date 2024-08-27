package br.com.acme.insurancequote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class InsuranceQuoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceQuoteApplication.class, args);
	}

}
