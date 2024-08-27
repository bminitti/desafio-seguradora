package br.com.acme.insurancequote.config;

import br.com.acme.insurancequote.domain.Offer;
import br.com.acme.insurancequote.domain.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
@EnableCaching
public class RedisConfig {

    @Bean
    public CacheManager cacheManagerWithTTL(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(10)) // Expiração de 10 minutos
                .disableCachingNullValues();

        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(config)
                .build();
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplatet(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        // Configurar ObjectMapper com suporte a Java 8 Date/Time
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.findAndRegisterModules();


        Jackson2JsonRedisSerializer<Product> serializerProduct = new Jackson2JsonRedisSerializer<>(Product.class);
        serializerProduct.setObjectMapper(objectMapper);

        Jackson2JsonRedisSerializer<Offer> serializerOffer = new Jackson2JsonRedisSerializer<>(Offer.class);
        serializerOffer.setObjectMapper(objectMapper);


        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(serializerProduct);
        template.setValueSerializer(serializerOffer);
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(serializerProduct);
        template.setHashValueSerializer(serializerOffer);

        return template;
    }


}
