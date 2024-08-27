package br.com.acme.insurancequote.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;


public class Product implements Serializable {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("created_at")
    private ZonedDateTime createdAt;

    @JsonProperty("active")
    private  boolean active;

    @JsonProperty("offers")
    private  List<String> offers;


    public Product(){

    }

    public Product(String id, String name, ZonedDateTime createdAt, boolean active, List<String> offers) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.active = active;
        this.offers = offers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<String> getOffers() {
        return offers;
    }

    public void setOffers(List<String> offers) {
        this.offers = offers;
    }
}
