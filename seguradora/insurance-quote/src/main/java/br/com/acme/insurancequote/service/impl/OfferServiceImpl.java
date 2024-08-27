package br.com.acme.insurancequote.service.impl;

import br.com.acme.insurancequote.config.ApplicationConfig;
import br.com.acme.insurancequote.config.JacksonConfig;
import br.com.acme.insurancequote.domain.Offer;
import br.com.acme.insurancequote.exception.CustomException;
import br.com.acme.insurancequote.exception.NotFoundException;
import br.com.acme.insurancequote.service.OfferService;
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
public class OfferServiceImpl implements OfferService {
    private final ApplicationConfig applicationConfig;
    private final JacksonConfig jacksonConfig;
    private final RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    public OfferServiceImpl(ApplicationConfig applicationConfig, JacksonConfig jacksonConfig, RedisTemplate<Object, Object> redisTemplate) {
        this.applicationConfig = applicationConfig;
        this.jacksonConfig = jacksonConfig;
        this.redisTemplate = redisTemplate;

    }

    @Override
    public Offer getOffertId(String offerId) {
        Offer offer = (Offer) redisTemplate.opsForValue().get("offers");

        if (Objects.isNull(offer))
            offer = findOfferById(offerId);
        else if (!offer.getId().equals(offerId))
            offer = null;

        offerValidate(offer);

        return offer;
    }

   private void offerValidate(Offer offer){
        if (Objects.isNull(offer))
            throw new NotFoundException("Oferta não disponível!");

        if (!offer.isActive())
            throw new CustomException("Oferta descontinuada!");



    }

    private Offer findOfferById(String offerId)  {
        String url = applicationConfig.getUrl() + "/api/offer/" + offerId;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                String jsonResponse = EntityUtils.toString(response.getEntity());

                if (!jsonResponse.isEmpty()) {
                    Offer offer = jacksonConfig.objectMapper().readValue(jsonResponse, Offer.class);

                    redisTemplate.opsForValue().set("offers", offer);
                    return offer;
                }else return null;
            }
        } catch (IOException e) {
            throw new RuntimeException("Falha ao buscar oferta.", e);
        }
    }

}
