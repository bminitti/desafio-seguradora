package br.com.acme.insurancequote.service;

import br.com.acme.insurancequote.domain.Product;

public interface ProductService {
    Product getProductId(String productId);
    boolean isProductValid(String productId);
}
