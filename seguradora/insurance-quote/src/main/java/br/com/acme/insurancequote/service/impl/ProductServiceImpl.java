package br.com.acme.insurancequote.service.impl;

import br.com.acme.insurancequote.config.ApplicationConfig;
import br.com.acme.insurancequote.config.JacksonConfig;
import br.com.acme.insurancequote.domain.Product;

import br.com.acme.insurancequote.exception.CustomException;
import br.com.acme.insurancequote.exception.NotFoundException;
import br.com.acme.insurancequote.service.ProductService;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {
    private final ApplicationConfig applicationConfig;
    private final JacksonConfig jacksonConfig;
    private final RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    public ProductServiceImpl(ApplicationConfig applicationConfig, JacksonConfig jacksonConfig, RedisTemplate<Object, Object> redisTemplate) {
        this.applicationConfig = applicationConfig;
        this.jacksonConfig = jacksonConfig;
        this.redisTemplate = redisTemplate;

    }

    @Override
    public Product getProductId(String productId) {
        Product product = (Product) redisTemplate.opsForValue().get("products");

        if (Objects.isNull(product))
            product = findProductById(productId);
        else if (!product.getId().equals(productId))
            product = null;

        productValidate(product);

        return product;
    }

    @Override
    public boolean isProductValid(String productId) {
        return Objects.nonNull(getProductId(productId));
    }

    private void productValidate(Product product){
        if (Objects.isNull(product))
            throw new NotFoundException("Produto não disponível!");

        if (!product.isActive())
            throw new CustomException("Produto descontinuado!");

    }

    private Product findProductById(String productId)  {

        String url = applicationConfig.getUrl() + "/api/product/" + productId;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                String jsonResponse = EntityUtils.toString(response.getEntity());

                if (!jsonResponse.isEmpty()) {
                    Product product = jacksonConfig.objectMapper().readValue(jsonResponse, Product.class);

                    redisTemplate.opsForValue().set("products", product);

                    return product;
                }else return null;
            }


        } catch (IOException e) {
            throw new RuntimeException("Falha ao buscar o produto.", e);
        }
    }


}
